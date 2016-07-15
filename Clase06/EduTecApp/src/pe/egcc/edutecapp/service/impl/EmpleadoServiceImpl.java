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
  
  private final String SQL_SELECT = "SELECT IdEmpleado, "
          + "ApeEmpleado, NomEmpleado,Cargo, DirEmpleado, "
          + "TelEmpleado, EmailEmpleado FROM dbo.EMPLEADO ";
  

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      // Abriendo la conexión con la BD
      cn = AccesoDB.getConnection();
      // Proceso
      String sql = SQL_SELECT + " WHERE IdEmpleado = ? "
              + "and clave = ? ";
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
    bean.setId(rs.getString("IdEmpleado"));
    bean.setApellido(rs.getString("ApeEmpleado"));
    bean.setNombre(rs.getString("NomEmpleado"));
    bean.setCargo(rs.getString("Cargo"));
    bean.setDireccion(rs.getString("DirEmpleado"));
    bean.setTelefono(rs.getString("TelEmpleado"));
    bean.setEmail(rs.getString("EmailEmpleado"));
    bean.setClave("******");
    return bean;
  }
  
}
