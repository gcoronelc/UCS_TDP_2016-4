/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.service.espec;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ServiceCrud<T> {
    
    void insert(T bean);  
    void update(T bean);
    void delete(String id);
    T getForId(String id);
    List<T> getRecords(T bean);
}
