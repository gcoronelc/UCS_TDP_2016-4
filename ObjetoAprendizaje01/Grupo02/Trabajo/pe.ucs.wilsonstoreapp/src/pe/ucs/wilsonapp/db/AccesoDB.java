package pe.ucs.wilsonapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
    
    private AccesoDB() {
  }
  
  private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private static final String URL = "jdbc:sqlserver://172.33.2.42:1433;databaseName=WILSONSTORE_JL";
  private static final String USER = "java";
  private static final String PASS = "java";
  
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
