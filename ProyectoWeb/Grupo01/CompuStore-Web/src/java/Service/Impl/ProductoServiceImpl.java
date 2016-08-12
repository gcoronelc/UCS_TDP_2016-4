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

import Domain.Producto;
import Service.Espec.ProductoServiceEspec;


public class ProductoServiceImpl
        implements ProductoServiceEspec {

  private static final String SQL_SELECT = "SELECT idprod, idcat, nombre,precio,stock " 
          + "  FROM Tbl_Producto";

  @Override
  public void insert(Producto bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void update(Producto bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Producto getForId(String id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Producto> getRecords(Producto bean) {
    List<Producto> lista = new ArrayList<Producto>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_SELECT
              + " where nombre like ? + '%' ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getNombre());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        Producto a = mapRow(rs);
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
  public Producto mapRow(ResultSet rs) throws SQLException {
    Producto bean = new Producto();
    bean.setIdprod(rs.getString("idprod"));
    bean.setIdcat(rs.getString("idcat"));
    bean.setNombre(rs.getString("nombre"));
    bean.setPrecio(rs.getString("precio"));
    bean.setStock(rs.getString("stock"));

    return bean;
  }
  
  





  

}
