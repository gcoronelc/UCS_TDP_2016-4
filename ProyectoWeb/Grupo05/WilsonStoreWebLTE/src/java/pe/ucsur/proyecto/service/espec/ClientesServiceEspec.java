/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.service.espec;
import pe.ucsur.proyecto.domain.Clientes;
/**
 *
 * @author Alumno
 */
public interface ClientesServiceEspec 
        extends ServiceCrud<Clientes>, RowMapper<Clientes>{
    Clientes InfoCliente(int CodigoUsuario);
    void doNuevo(int codigo, String nombres, String ApePaterno, String ApeMaterno);
}
