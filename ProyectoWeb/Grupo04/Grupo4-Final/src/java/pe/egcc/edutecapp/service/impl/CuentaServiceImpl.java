package pe.egcc.edutecapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.egcc.edutecapp.db.AccesoDB;
import pe.egcc.edutecapp.domain.Combo;
import pe.egcc.edutecapp.service.espec.CuentaServiceEspec;

public class CuentaServiceImpl implements CuentaServiceEspec {

  @Override
  public Map<String, Object> getDatosCuenta(String cuenta) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void doDeposito(String cuenta, double importe, String codEmpl) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Paso 1: Inicio de Tx
      cn.setAutoCommit(false);
      // Paso 2: Actualizar cuenta
      String sql = "update cuenta "
              + "set dec_cuensaldo = dec_cuensaldo + ?, "
              + "int_cuencontmov = int_cuencontmov + 1 "
              + "where chr_cuencodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, importe);
      pstm.setString(2, cuenta);
      int filas = pstm.executeUpdate();
      pstm.close();
      if (filas != 1) {
        throw new Exception("Cuenta no es correcta.");
      }
      // Paso 3: Leer contador
      sql = "select int_cuencontmov from cuenta "
              + "where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int nroMov = rs.getInt("int_cuencontmov");
      rs.close();
      pstm.close();
      // Paso 4: Registrar movimiento
      sql = "insert into movimiento(chr_cuencodigo,"
              + "int_movinumero,dtt_movifecha,"
              + "chr_emplcodigo,chr_tipocodigo,"
              + "dec_moviimporte) "
              + "values(?,?,sysdate(),?,'003',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, nroMov);
      pstm.setString(3, codEmpl);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      // Paso : Finalizar Tx
      cn.commit();
    } catch (Exception e) {
      // Cancelar Tx
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      // Mensaje
      String texto = "Error en el proceso.";
      if (e.getMessage() != null && !e.getMessage().isEmpty()) {
        texto += " " + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public List<Combo> getCuentaCombo() {
    List<Combo> lista = new ArrayList<Combo>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = "select chr_cuencodigo cuenta from cuenta";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        Combo bean = new Combo();
        bean.setKey(rs.getString("cuenta"));
        bean.setValue(rs.getString("cuenta"));
        lista.add(bean);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String texto = "Error en el proceso.";
      if(e.getMessage() != null && !e.getMessage().isEmpty()){
        texto += "\n" + e.getMessage();
      }
      throw new RuntimeException(texto);
    } finally{
      try {
        // Cerrando la conexión
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

}
