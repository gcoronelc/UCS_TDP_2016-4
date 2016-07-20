/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.jpaj.wilsonapp.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.jpaj.wilsonapp.db.AccesoDB;
import pe.jpaj.wilsonapp.domain.UsuarioDomain;
import pe.jpaj.wilsonapp.service.espec.UsuarioServiceEspec;

/**
 *
 * @author jcpr1994
 */
public class UsuarioServiceImpl implements UsuarioServiceEspec {
    
    
     private final String SQL_SELECT = "SELECT id, "
          + "usuario, nombre, tp_user "
          + "FROM dbo.usuario ";

    @Override
    public UsuarioDomain validar(String usuario, String clave) {
       
      UsuarioDomain bean = null;
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_SELECT + " WHERE usuario = ? "
              + "and PWDCOMPARE(?,contra) = 1 ";
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
    public void insert(UsuarioDomain bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UsuarioDomain bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDomain getForId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioDomain> getRecords(UsuarioDomain bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioDomain mapRow(ResultSet rs) throws SQLException {
        UsuarioDomain bean = new UsuarioDomain();
        bean.setNombre(rs.getString("nombre"));
        bean.setUsuario(rs.getString("usuario"));
        return bean;
    }
    
    
}
