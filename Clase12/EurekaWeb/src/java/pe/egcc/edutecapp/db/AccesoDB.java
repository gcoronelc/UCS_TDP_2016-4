package pe.egcc.edutecapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AccesoDB {

  private AccesoDB() {
  }
  
  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost:3306/eurekabank";
  private static final String USER = "eureka";
  private static final String PASS = "admin";
  
  public static Connection getConnection() 
          throws SQLException{
    Connection cn = null;
    try {
     // Paso 1: Cargar el driver
     Class.forName(DRIVER).newInstance();
     // Paso 2: Abrir conexión
     cn = DriverManager.getConnection(URL, USER, PASS);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se ha encontrado el driver.");
    } catch(SQLException e){
      throw e;
    } catch(Exception e){
      throw new SQLException("No se ha logrado establecer la conexión.");
    }
    return cn;
  }
  
}
