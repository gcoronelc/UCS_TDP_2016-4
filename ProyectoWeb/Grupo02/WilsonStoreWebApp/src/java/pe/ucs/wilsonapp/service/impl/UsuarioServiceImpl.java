package pe.ucs.wilsonapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.ucs.wilsonapp.db.AccesoDB;
import pe.ucs.wilsonapp.domain.Usuario;
import pe.ucs.wilsonapp.service.espec.UsuarioServiceEspec;


public class UsuarioServiceImpl
    implements UsuarioServiceEspec{
    private final String SQL_SELECT = "SELECT USUARIO_ID,USUARIO_NOMBRE, "
            + " USUARIO_APELLIDOS,USUARIO_CARGO,USUARIO_EMAIL,USUARIO_ESTADO "
            + " FROM Usuario ";
  @Override
  public Usuario validar(String Usuario_id, String Usuario_pass) {
    Usuario bean = null;
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_SELECT + " WHERE USUARIO_ID = ? "
              + "and USUARIO_PASS = ? ";
      
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, Usuario_id);
      pstm.setString(2, Usuario_pass);
      
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new Exception("Datos incorrectos.");
      }
      bean = mapRow(rs);
      rs.close();
      pstm.close();
    } catch (Exception e) {
        e.printStackTrace();
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
  public void insert(Usuario bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Usuario bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Usuario getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Usuario> getRecords(Usuario bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  } 
  
 @Override
  public Usuario mapRow(ResultSet rs) throws SQLException {
    Usuario bean = new Usuario();
    bean.setId(rs.getString("USUARIO_ID"));
    bean.setNombre(rs.getString("USUARIO_NOMBRE"));
    bean.setApellidos(rs.getString("USUARIO_APELLIDOS"));
    bean.setCargo(rs.getString("USUARIO_CARGO"));
    bean.setEmail(rs.getString("USUARIO_EMAIL"));
    bean.setEstado(rs.getString("USUARIO_ESTADO"));
    bean.setClave("******");
    return bean;
  }
}
