/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author Administrador
 */
public final class AccesoDB {
    private AccesoDB(){}
    
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://172.33.6.141:1433;databaseName=WilsonStore";
    private static final String USER = "java";
    private static final String PASS = "java123";
    
    
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
