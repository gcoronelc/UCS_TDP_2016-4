package pe.ucs.wilsonapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import pe.ucs.wilsonapp.db.AccesoDB;
import pe.ucs.wilsonapp.service.espec.DescuentoServiceEspec;

public class DescuentoServiceImpl implements DescuentoServiceEspec{
    
  @Override
  public Map<String, Object> getDatosCuenta(String cliente) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void doDescuentoCliente(String DSCTO_ID, String CLI_ID, String DSCTO_FECHA, int DSCTO_PORC, String DSCTO_ESTADO) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Paso 1: Inicio de Tx
      cn.setAutoCommit(false);
      // Paso 2: Actualizar cuenta
//      String sql = "update cuenta "
//              + "set dec_cuensaldo = dec_cuensaldo + ?, "
//              + "int_cuencontmov = int_cuencontmov + 1 "
//              + "where chr_cuencodigo = ? ";
//      PreparedStatement pstm = cn.prepareStatement(sql);
//      pstm.setDouble(1, cliente);
//      pstm.setString(2, cuenta);
//      int filas = pstm.executeUpdate();
//      pstm.close();
//      if (filas != 1) {
//        throw new Exception("Cuenta no es correcta.");
//      }
      // Paso 3: Leer contador
      String sql = "select MAX(DSCTO_ID) AS CUENTA from DESCUENTO ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int nroMov = rs.getInt("CUENTA") + 1;
      rs.close();
      pstm.close();
      // Paso 4: Registrar movimiento
      sql = "insert into DESCUENTO(DSCTO_ID,CLI_ID,DSCTO_FECHA,DSCTO_PORC,DSCTO_ESTADO) "
              + "values(?,?,?,?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, nroMov );
      pstm.setString(2, CLI_ID);
      pstm.setString(3, DSCTO_FECHA);      
      pstm.setInt(4, DSCTO_PORC);     
      pstm.setString(5, DSCTO_ESTADO);     
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
}