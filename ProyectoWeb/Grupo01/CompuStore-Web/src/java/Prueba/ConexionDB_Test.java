/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package ClienteServidor.Prueba;
import DB.AccesoDB;
import java.sql.Connection;

public class ConexionDB_Test {
    public static void main(String[] args) {
    try {
      Connection cn = AccesoDB.getConnection();
      System.out.println("Ok.");
      cn.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }    
    
}
