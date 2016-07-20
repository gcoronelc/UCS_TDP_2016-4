package pe.ucs.wilsonapp.service.espec;

import pe.ucs.wilsonapp.domain.Empleado;

public interface EmpleadoServiceEspec
        extends ServiceCrud<Empleado>, RowMapper<Empleado> {
  
  Empleado validar(String usuario, String clave);
}
