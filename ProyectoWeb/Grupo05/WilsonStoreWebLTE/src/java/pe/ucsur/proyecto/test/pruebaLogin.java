/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.test;
import pe.ucsur.proyecto.service.impl.UsuariosServiceImpl;

/**
 *
 * @author Administrador
 */
public class pruebaLogin {
    public static void main(String[] args)
    {
        String usuario="cbocanegra";
        String contraseina="Cesar123$$";
        boolean resultado=false;
                
        try {
            UsuariosServiceImpl service=new UsuariosServiceImpl();
            resultado=service.validar(usuario, contraseina);
            System.out.println(resultado);
                    
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
