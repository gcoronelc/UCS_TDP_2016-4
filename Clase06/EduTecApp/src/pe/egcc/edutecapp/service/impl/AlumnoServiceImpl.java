package pe.egcc.edutecapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.edutecapp.db.AccesoDB;
import pe.egcc.edutecapp.domain.Alumno;
import pe.egcc.edutecapp.service.espec.AlumnoServiceEspec;

public class AlumnoServiceImpl
        implements AlumnoServiceEspec {

  private static final String SQL_SELECT = "select IdAlumno,"
          + "ApeAlumno,NomAlumno,DirAlumno, "
          + "TelAlumno,EmailAlumno "
          + "from Alumno ";

  @Override
  public void insert(Alumno bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Alumno bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Alumno getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Alumno> getRecords(Alumno bean) {
    List<Alumno> lista = new ArrayList<>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_SELECT
              + " where ApeAlumno like concat(?,'%') "
              + "and NomAlumno like concat(?,'%') "
              + "and EmailAlumno like concat('%',?,'%') ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getApellido());
      pstm.setString(2, bean.getNombre());
      pstm.setString(3, bean.getEmail());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Alumno a = mapRow(rs);
        lista.add(a);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String texto = "Error en el proceso.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        texto += "\n" + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        // Cerrando la conexión
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  @Override
  public Alumno mapRow(ResultSet rs) throws SQLException {
    Alumno bean = new Alumno();
    bean.setId(rs.getString("IdAlumno"));
    bean.setApellido(rs.getString("ApeAlumno"));
    bean.setNombre(rs.getString("NomAlumno"));
    bean.setDireccion(rs.getString("DirAlumno"));
    bean.setTelefono(rs.getString("TelAlumno"));
    bean.setEmail(rs.getString("EmailAlumno"));
    return bean;
  }

}
