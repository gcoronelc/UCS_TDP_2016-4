
package pe.ucs.wilsonapp.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.ucs.wilsonapp.db.AccesoDB;
import pe.ucs.wilsonapp.domain.Cliente;
import pe.ucs.wilsonapp.service.espec.ClienteServiceEspec;

public class ClienteServiceImpl 
implements ClienteServiceEspec{
    

//  private static final String SQL_SELECT = "select chr_cliecodigo,"
//          + "vch_cliepaterno,vch_cliematerno,"
//          + "vch_clienombre,chr_cliedni,"
//          + "vch_clieciudad,vch_cliedireccion,"
//          + "vch_clietelefono,vch_clieemail "
//          + "from Cliente ";

   private static final String SQL_SELECT = "select CLI_RUC,CLI_RAZONSOCIAL,CLI_DIRECCION from Cliente ";
  
  @Override
  public void insert(Cliente bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Cliente bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Cliente getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Cliente> getRecords(Cliente bean) {
    List<Cliente> lista = new ArrayList<Cliente>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
//      String sql = SQL_SELECT
//              + " where chr_cliecodigo like concat(?,'%') "
//              + "and vch_cliepaterno like concat(?,'%') "
//              + "and vch_cliematerno like concat(?,'%') "
//              + "and vch_clienombre like concat(?,'%') ";
      
      String sql = SQL_SELECT
              + " where CLI_RUC like concat(?,'%') "
              + "and CLI_RAZONSOCIAL like concat(?,'%') "
              + "and CLI_DIRECCION like concat(?,'%') ";
      
      
      PreparedStatement pstm = cn.prepareStatement(sql);
     //pstm.setInt(1, bean.getID());
      pstm.setString(1, bean.getRUC());
      pstm.setString(2, bean.getRAZONSOCIAL());
      pstm.setString(3, bean.getDIRECCION());
//      pstm.setString(5, bean.getCORREO());
//      pstm.setString(6, bean.getTELEFONO());
//      pstm.setDate(7, bean.getFECHAREGISTRO());
//      pstm.setString(8, bean.getESTADO());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Cliente a = mapRow(rs);
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
  public Cliente mapRow(ResultSet rs) throws SQLException {
    Cliente bean = new Cliente();
    //bean.setID(rs.getInt("CLI_ID"));
    bean.setRUC(rs.getString("CLI_RUC"));
    bean.setRAZONSOCIAL(rs.getString("CLI_RAZONSOCIAL"));
    bean.setDIRECCION(rs.getString("CLI_DIRECCION"));
//    bean.setCORREO(rs.getString("CLI_CORREO"));
//    bean.setTELEFONO(rs.getString("CLI_TELEFONO"));
//    bean.setFECHAREGISTRO(rs.getDate("CLI_FECHAREGISTRO"));
//    bean.setESTADO(rs.getString("CLI_ESTADO"));    
    return bean;
  }
  
@Override
  public void doRegistroCliente(String ID, String RUC, String RAZONSOCIAL, String DIRECCION, String CORREO, String TELEFONO, String ESTADO){
  
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
      String sql = "select MAX(CLI_ID) AS CUENTA from CLIENTE ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int nroMov = rs.getInt("CUENTA") + 1;
      rs.close();
      pstm.close();
      // Paso 4: Registrar movimiento
      sql = "insert into CLIENTE(CLI_ID,CLI_RUC,CLI_RAZONSOCIAL,CLI_DIRECCION,CLI_CORREO,CLI_TELEFONO,CLI_ESTADO) "
              + "values(?,?,?,?,?,?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, nroMov );
      pstm.setString(2, RUC.toUpperCase());
      pstm.setString(3, RAZONSOCIAL.toUpperCase());
      pstm.setString(4, DIRECCION.toUpperCase());
      pstm.setString(5, CORREO.toUpperCase());
      pstm.setString(6, TELEFONO.toUpperCase());
      pstm.setString(7, ESTADO.toUpperCase());
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

