package Service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import DB.AccesoDB;
import Domain.Usuario;
import Service.Espec.UsuarioServiceEspec;
import static ClienteServidor.Util.EncriptarMD5.encriptaEnMD5;

public class UsuarioServiceImpl
        implements UsuarioServiceEspec {

    private final String SQL_SELECT = "SELECT idemp "
            + "      ,usuario "
            + "      ,clave "
            + "      ,estado "
            + "  FROM Tbl_Usuario ";

    @Override
    public Usuario validar(String usuario, String clave) {
        Usuario bean = null;
        Connection cn = null;
        try {
            // Abriendo la conexión con la BD
            cn = AccesoDB.getConnection();
            // Proceso
            String sql = SQL_SELECT + " WHERE usuario = ? "
                    + "and clave = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, usuario);
            pstm.setString(2, encriptaEnMD5(clave));
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new Exception("Datos incorrectos.");
            }
            bean = mapRow(rs);
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
        bean.setIdemp(rs.getString("idemp"));
        bean.setUsuario(rs.getString("usuario"));
        bean.setClave(rs.getString("clave"));
        bean.setEstado(rs.getString("estado"));

        return bean;

    }

}
