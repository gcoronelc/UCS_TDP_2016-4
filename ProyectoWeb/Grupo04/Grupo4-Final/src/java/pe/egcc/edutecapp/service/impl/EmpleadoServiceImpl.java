package pe.egcc.edutecapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.edutecapp.db.AccesoDB;
import pe.egcc.edutecapp.domain.Empleado;
import pe.egcc.edutecapp.service.espec.EmpleadoServiceEspec;

public class EmpleadoServiceImpl 
        implements EmpleadoServiceEspec{
  
  /*
    private final String SQL_SELECT = "SELECT chr_emplcodigo,"
          + "vch_emplpaterno, vch_emplmaterno,"
          + "vch_emplnombre, vch_emplciudad, "
          + "vch_empldireccion, vch_emplusuario "
          + "FROM EMPLEADO ";
  */
    private final String SQL_SELECT = "SELECT UsuCod, "
          + "UsuLogin, UsuPass, "
          + "UsuEstado, UsuNombre from MUsuario";
    

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_SELECT + " WHERE UsuLogin = ? "
              + "and UsuPass = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new Exception("Datos incorrectos.");
      }
      bean = mapRow(rs);
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
    return bean;
  }

  @Override
  public void insert(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Empleado getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> getRecords(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Empleado mapRow(ResultSet rs) throws SQLException {
    Empleado bean = new Empleado();
    /*
    bean.setCodigo(rs.getString("chr_emplcodigo"));
    bean.setPaterno(rs.getString("vch_emplpaterno"));
    bean.setMaterno(rs.getString("vch_emplmaterno"));
    bean.setNombre(rs.getString("vch_emplnombre"));
    bean.setCiudad(rs.getString("vch_emplciudad"));
    bean.setDireccion(rs.getString("vch_empldireccion"));
    bean.setUsuario(rs.getString("vch_emplusuario"));
    bean.setClave("******");
    */
    bean.setCodigo(rs.getString("UsuCod"));
    bean.setNombre(rs.getString("UsuNombre"));
    bean.setPaterno(rs.getString("UsuLogin"));
    bean.setMaterno(rs.getString("UsuLogin"));
    bean.setUsuario(rs.getString("UsuNombre"));
    
    return bean;
  }

}
