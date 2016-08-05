package pe.egcc.edutecapp.service.espec;

import pe.egcc.edutecapp.domain.Empleado;

public interface EmpleadoServiceEspec
        extends ServiceCrud<Empleado>, RowMapper<Empleado> {
  
  Empleado validar(String usuario, String clave);
}
