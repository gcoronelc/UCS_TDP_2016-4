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
import java.util.ArrayList;
import java.util.List;
import pe.jpaj.wilsonapp.db.AccesoDB;
import pe.jpaj.wilsonapp.domain.Combo;
import pe.jpaj.wilsonapp.domain.Producto;
import pe.jpaj.wilsonapp.service.espec.ProductoServiceEspec;

/**
 *
 * @author jcpr1994
 */
public class ProductoServiceImpl 
            implements ProductoServiceEspec{

    private static final String SQL_SELECT = "select prod.tp_producto,tpp.descripcion 'tipo', " +
            "prod.nombre,prod.precio,prod.descripcion, " +
            "prod.stock,prod.stock_min " +
            "from producto prod " +
            "join tp_producto tpp on prod.tp_producto=tpp.id";
    
    @Override
    public void insert(Producto bean) {
        Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Paso 1: Inicio de Tx
      cn.setAutoCommit(false);
      // Paso 2: Actualizar cuenta
      String sql="insert into producto(tp_producto,nombre,precio,descripcion,stock,stock_min) " +
        "values(?,?,?,?,?,?)";
//        sqlres=sql;
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getTp_producto());
      pstm.setString(2, bean.getNombre());
      pstm.setDouble(3, bean.getPrecio());
      pstm.setString(4, bean.getDescripcion());
      pstm.setInt(5, bean.getStock());
      pstm.setInt(6, bean.getStock_min());
      
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
                  + " where prod.nombre like ? + '%' ";
          PreparedStatement pstm = cn.prepareStatement(sql);
          pstm.setString(1, bean.getNombre());
//          pstm.setInt(2, bean.getTp_producto());
          ResultSet rs = pstm.executeQuery();
          while (rs.next()) {
            Producto a = mapRow(rs);
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
    public Producto mapRow(ResultSet rs) throws SQLException {
        Producto bean = new Producto();
        bean.setTp_producto(rs.getInt("tp_producto"));
        bean.setNombre(rs.getString("nombre"));
        bean.setTipo(rs.getString("tipo"));
        bean.setDescripcion(rs.getString("descripcion"));
        bean.setPrecio(rs.getDouble("precio"));
        bean.setStock(rs.getInt("stock"));
        bean.setStock_min(rs.getInt("stock_min"));
        return bean;
    }
    
    @Override
    public List<Combo> getCuentaCombo() {
    List<Combo> lista = new ArrayList<Combo>();
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = "select id,descripcion from tp_producto ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        Combo bean = new Combo();
        bean.setKey(rs.getString("id"));
        bean.setValue(rs.getString("descripcion"));
        lista.add(bean);
      }
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
    return lista;
  }
    
}
