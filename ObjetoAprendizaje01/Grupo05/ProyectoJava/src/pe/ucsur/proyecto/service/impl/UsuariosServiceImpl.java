/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.ucsur.proyecto.db.AccesoDB;
import pe.ucsur.proyecto.domain.Usuarios;
import pe.ucsur.proyecto.service.espec.UsuariosServiceEspec;
/**
 *
 * @author Administrador
 */
public class UsuariosServiceImpl
        implements UsuariosServiceEspec
{

    @Override
    public boolean validar(String Usuario, String contrasenia) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean resultado=false;
        String respuesta="";
        Connection cn = null;
        try{
            // Abriendo la conexión con la BD
            cn = AccesoDB.getConnection();
            // Proceso
            String sql = "exec [ValidarLogin] @usuario=? ,@contraseina=? ";          
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, Usuario);
            pstm.setString(2, contrasenia);
            ResultSet rs = pstm.executeQuery();
            if(!rs.next()){
                throw new Exception("Datos incorrectos.");
            }
            respuesta=rs.getString("RESULTADO");
            
            if ("1".equals(respuesta)){
                return true;
            }
            else
            {
                return false;
            }
                
            
        }
        catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void insert(Usuarios bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuarios bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarios getForId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuarios> getRecords(Usuarios bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarios mapRow(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
