package pe.egcc.edutecapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.edutecapp.db.AccesoDB;
import pe.egcc.edutecapp.domain.Cliente;
import pe.egcc.edutecapp.service.espec.ClienteServiceEspec;

public class ClienteServiceImpl
        implements ClienteServiceEspec {
/*
  private static final String SQL_SELECT = "select chr_cliecodigo,"
          + "vch_cliepaterno,vch_cliematerno,"
          + "vch_clienombre,chr_cliedni,"
          + "vch_clieciudad,vch_cliedireccion,"
          + "vch_clietelefono,vch_clieemail "
          + "from Cliente ";
*/
   private static final String SQL_SELECT = "select CliCod,"
          + "CliNom,CliRUC,"
          + "CliDir,CliTelf,"
          + "CliEmail "
          // + "CliFechaAfiliacion "
          + "from MCliente "; 
   String Fechaafi; 
   
   
  @Override
  /*public void insert(Cliente bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }*/
  public void insert(Cliente bean) {
     //To change body of generated methods, choose Tools | Templates.
     Connection cn = null;
     
     String sql;
     PreparedStatement pstm;
     ResultSet rs;
     
     try{
         
         cn = AccesoDB.getConnection();
         
         cn.setAutoCommit(false);
            // Verificar si esta matriculado

            sql = "select count(*) cont "
                    + "from MCliente "
                    + "where CliNom = ? ";

            pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getNombre());

            rs = pstm.executeQuery();
            rs.next();
            
            int cont = rs.getInt("cont");
            rs.close();
            pstm.close();

            if (cont > 0) {
              //throw new Exception("Ya Existe el Cliente en nuestra Base de Datos");
            }
         
            sql = "INSERT INTO MCliente (CliCod,CliNom, CliRUC,CliDir,CliTelf,CliEmail)"
                        + "values(?,?,?,?,?,?)";
                
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getCodigo());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getRUCDni());
            pstm.setString(4, bean.getDireccion());
            pstm.setString(5, bean.getTelefono());
            pstm.setString(6,bean.getEmail());
            //pstm.setString(7, bean.getFechaafi());
                
            pstm.executeUpdate();
            pstm.close();
                // Confirmar Tx
            cn.commit();
     
     }
     catch (Exception e) {
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
      /*
      String sql = SQL_SELECT
              + " where chr_cliecodigo like concat(?,'%') "
              + "and vch_cliepaterno like concat(?,'%') "
              + "and vch_cliematerno like concat(?,'%') "
              + "and vch_clienombre like concat(?,'%') ";
       */
        String sql = SQL_SELECT
              + " where CliCod like concat(?,'%') "
              + "and CliNom like concat(?,'%') "
              //+ " where CliNom like concat(?,'%') "
              ;

      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCodigo());
      //pstm.setString(2, bean.getPaterno());
      //pstm.setString(3, bean.getMaterno());
      pstm.setString(2, bean.getNombre());
      //pstm.setString(1, bean.getNombre());
      
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
    bean.setCodigo(rs.getString("CliCod"));
    //bean.setPaterno(rs.getString("vch_cliepaterno"));
    //bean.setMaterno(rs.getString("vch_cliematerno"));
    bean.setNombre(rs.getString("CliNom"));
    bean.setRUCDni(rs.getString("CliRUC"));
    //bean.setCiudad(rs.getString("vch_clieciudad"));
    bean.setDireccion(rs.getString("CliDir"));
    bean.setTelefono(rs.getString("CliTelf"));
    bean.setEmail(rs.getString("CliEmail"));
    //bean.setFechaafi(rs.getString("CliEmail"));
    
    bean.setFechaafi("01-01-2016");
    return bean;
  }

}
