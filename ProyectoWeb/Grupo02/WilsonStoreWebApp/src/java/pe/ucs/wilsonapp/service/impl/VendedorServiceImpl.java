/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucs.wilsonapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.ucs.wilsonapp.db.AccesoDB;
import pe.ucs.wilsonapp.domain.Vendedor;
import pe.ucs.wilsonapp.service.espec.VendedorServiceEspec;

public class VendedorServiceImpl
implements VendedorServiceEspec{
    
   private static final String SQL_SELECT = "SELECT VEND_ID,VEND_NOMBRE,VEND_ESTADO FROM VENDEDOR ";
  
  @Override
  public void insert(Vendedor bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Vendedor bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Vendedor getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Vendedor> getRecords(Vendedor bean) {
    List<Vendedor> lista = new ArrayList<Vendedor>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      //String sql = SQL_SELECT;
//              + " where chr_cliecodigo like concat(?,'%') "
//              + "and vch_cliepaterno like concat(?,'%') "
//              + "and vch_cliematerno like concat(?,'%') "
//              + "and vch_clienombre like concat(?,'%') ";
      
      String sql = SQL_SELECT//              
              + "where VEND_NOMBRE like concat(?,'%') ";
      
      
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getNOMBRE());

      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Vendedor a = mapRow(rs);
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
  public Vendedor mapRow(ResultSet rs) throws SQLException {
           
      
    Vendedor bean = new Vendedor(); 
    bean.setID(rs.getString("VEND_ID"));
    bean.setNOMBRE(rs.getString("VEND_NOMBRE"));
    bean.setESTADO(rs.getString("VEND_ESTADO"));

    return bean;
  }

  @Override
  public void doRegistroVendedor(String ID, String NOMBRE, String ESTADO){
  
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Paso 1: Inicio de Tx
      cn.setAutoCommit(false);
      // Paso 2: Actualizar cuenta 
//      String sql = "update vendedor "
//              + "set VEND_NOMBRE = ?, "
//              + "VEND_ESTADO = ? "
//              + "where VEND_ID = ? ";
//      PreparedStatement pstm = cn.prepareStatement(sql);
//      pstm.setString(1, NOMBRE);
//      pstm.setString(2, ESTADO);
//      pstm.setString(3, ID);
//      int filas = pstm.executeUpdate();
//      pstm.close();
//      if (filas != 1) {
//        throw new Exception("Vendedor Incorrecto.");
//      }
      // Paso 3: Leer contador
      String sql = "select MAX(VEND_ID) AS CUENTA from Vendedor ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int nroMov = rs.getInt("CUENTA") + 1;
      rs.close();
      pstm.close();
      // Paso 4: Registrar movimiento
      sql = "insert into vendedor(VEND_ID,VEND_NOMBRE,VEND_ESTADO) "
              + "values(?,?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, nroMov );
      pstm.setString(2, NOMBRE.toUpperCase());
      pstm.setString(3, ESTADO);      
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
