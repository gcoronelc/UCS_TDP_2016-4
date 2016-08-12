/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package Service.Impl;

import DB.AccesoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Cliente;
import Service.Espec.ClienteServiceEspec;


public class ClienteServiceImpl
        implements ClienteServiceEspec {

  private static final String SQL_SELECT = "select codigo,"
          + "paterno,materno,"
          + "nombre,dni,"
          + "ciudad,direccion,"
          + "telefono,email "
          + "from Tbl_Cliente ";

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
      String sql = SQL_SELECT
              + " where codigo like ? + '%' "
              + "and paterno like ? + '%' "
              + "and materno like ? + '%' "
              + "and nombre like ? + '%' ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getCodigo());
      pstm.setString(2, bean.getPaterno());
      pstm.setString(3, bean.getMaterno());
      pstm.setString(4, bean.getNombre());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Cliente a = mapRow(rs);
        lista.add(a);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
        e.printStackTrace();
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
    bean.setCodigo(rs.getString("codigo"));
    bean.setPaterno(rs.getString("paterno"));
    bean.setMaterno(rs.getString("materno"));
    bean.setNombre(rs.getString("nombre"));
    bean.setDni(rs.getString("dni"));
    bean.setCiudad(rs.getString("ciudad"));
    bean.setDireccion(rs.getString("direccion"));
    bean.setTelefono(rs.getString("telefono"));
    bean.setEmail(rs.getString("email"));
    return bean;
  }

}
