/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.service.espec;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Administrador
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
