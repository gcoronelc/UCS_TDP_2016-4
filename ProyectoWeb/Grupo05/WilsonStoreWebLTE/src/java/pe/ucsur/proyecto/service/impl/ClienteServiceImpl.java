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
import java.util.ArrayList;
import java.util.List;
import pe.ucsur.proyecto.db.AccesoDB;
import pe.ucsur.proyecto.domain.Clientes;
import pe.ucsur.proyecto.service.espec.ClientesServiceEspec;


public class ClienteServiceImpl implements ClientesServiceEspec{

    private static final String SQL_SELECT="select idCliente, Nombres, tipodoc, nrodoc, Estado, correo,"
            + "Telefono, ApellidoPaterno, ApellidoMaterno,"
            + "NombreCompleto from Clientes";
    
    @Override
    public Clientes InfoCliente(int CodigoUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Clientes bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Clientes bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Clientes getForId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Clientes> getRecords(Clientes bean) {
        List<Clientes> lista=new ArrayList<Clientes>();
        Connection cn=null;
        try {
            cn=AccesoDB.getConnection();
            String sql=SQL_SELECT
                    + " where idCliente=(case ? when 0 then idCliente else ? end) "
                    + " and ApellidoPaterno like concat(?,'%') "
                    + " and ApellidoMaterno like concat(?,'%') "
                    + " and Nombres like concat(?,'%') ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdcliente());
            pstm.setInt(2, bean.getIdcliente());
            pstm.setString(3, bean.getApellidopaterno());
            pstm.setString(4, bean.getApellidomaterno());
            pstm.setString(5, bean.getNombres());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Clientes a=mapRow(rs);
                lista.add(a);
            }
            rs.close();
            pstm.close();
        }
        catch (Exception ex) {
            String texto = "Error en el proceso.";
            if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
              texto += "\n" + ex.getMessage();
            }
            throw new RuntimeException(texto);
        }
        finally {
            try {
                // Cerrando la conexión
                cn.close();
              } catch (Exception e) {
              }
        }
        return lista;
    }

    @Override
    public Clientes mapRow(ResultSet rs) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Clientes bean=new Clientes();
        bean.setIdcliente(rs.getInt("idCliente"));
        bean.setNombres(rs.getString("Nombres"));
        bean.setApellidopaterno(rs.getString("ApellidoPaterno"));
        bean.setApellidomaterno(rs.getString("ApellidoMaterno"));
        return bean;
    }

    @Override
    public void doNuevo(int codigo, String nombres, String ApePaterno, String ApeMaterno) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            // Paso 1: Inicio de Tx
            cn.setAutoCommit(false);
            // Paso 2: Actualizar cuenta
            String sql="insert into Clientes(idCliente, Nombres, ApellidoPaterno, ApellidoMaterno) " +
                        "values (?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            pstm.setString(2, nombres);
            pstm.setString(3, ApePaterno);
            pstm.setString(4, ApeMaterno);
            int filas = pstm.executeUpdate();
            pstm.close();
            if (filas != 1) {
                throw new Exception("No se han guardado los datos");
            }
            cn.commit();            
        }
        catch (Exception ex) {
            try {
                cn.rollback();
            }
            catch (Exception e){}
            //Mensaje
            String texto = "Error en el proceso, clave duplicada.";
            if (ex.getMessage() != null && !ex.getMessage().isEmpty()) {
                texto += " " + ex.getMessage();
              }
              throw new RuntimeException(texto);
        }
        finally{
            try {
                cn.close();
              } catch (Exception e) {
              }
        }
    }
    
}
