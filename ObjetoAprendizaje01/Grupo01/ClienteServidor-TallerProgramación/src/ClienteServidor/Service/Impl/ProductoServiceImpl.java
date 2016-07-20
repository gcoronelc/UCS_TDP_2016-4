package ClienteServidor.Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ClienteServidor.DB.AccesoDB;
import ClienteServidor.Service.Espec.ProductoServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class ProductoServiceImpl implements ProductoServiceEspec {

  @Override
  public void regProducto(int idCursoProg, String idAlumno) {
    int cont, matriculados, vacantes;
    String sql;
    PreparedStatement pstm;
    ResultSet rs;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Iniciar Tx
      cn.setAutoCommit(false);
      // Verificar si esta matriculado
      sql = "select count(*) cont "
              + "from Matricula "
              + "where IdCursoProg = ? "
              + "and IdAlumno = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idCursoProg);
      pstm.setString(2, idAlumno);
      rs = pstm.executeQuery();
      rs.next();
      cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if (cont > 0) {
        throw new Exception("Ya se encuentra matriculado");
      }
      // Leer datos del curso programado
      sql = "select Vacantes, Matriculados "
              + "from CursoProgramado with (updlock) "
              + "where IdCursoProg = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idCursoProg);
      rs = pstm.executeQuery();
      if (!rs.next()) {
        rs.close();
        pstm.close();
        throw new Exception("El curso programado no existe.");
      }
      vacantes = rs.getInt("vacantes");
      matriculados = rs.getInt("matriculados");
      rs.close();
      pstm.close();
      if (vacantes <= 0) {
        throw new Exception("No hay vacantes.");
      }
      // Actualizar curso programado
      vacantes--;
      matriculados++;
      sql = "update CursoProgramado "
              + "set Vacantes = ?, "
              + "Matriculados = ? "
              + "where IdCursoProg = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, vacantes);
      pstm.setInt(2, matriculados);
      pstm.setInt(3, idCursoProg);
      pstm.executeUpdate();
      pstm.close();
      // Registrar la matricula
      sql = "insert into matricula(IdCursoProg, "
              + "IdAlumno, FecMatricula) "
              + "values(?,?,GETDATE())";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idCursoProg);
      pstm.setString(2, idAlumno);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "Error en el proceso Matricula.";
      if(e.getMessage() != null && !e.getMessage().isEmpty()){
        texto += "\n" + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }

  }

}
