package pe.egcc.edutecapp.domain;

public class Cliente {

  private String codigo;
  //private String paterno;
  //private String materno;
  private String nombre;
  private String rucdni;
  //private String ciudad;
  private String direccion;
  private String telefono;
  private String email;
  private String fechaafiliacion;

  public Cliente() {
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
/*
  public String getPaterno() {
    return paterno;
  }

  public void setPaterno(String paterno) {
    this.paterno = paterno;
  }

  public String getMaterno() {
    return materno;
  }

  public void setMaterno(String materno) {
    this.materno = materno;
  }
*/
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getRUCDni() {
    return rucdni;
  }

  public void setRUCDni(String rucdni) {
    this.rucdni = rucdni;
  }
/*
  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
*/
  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getFechaafi() {
    return fechaafiliacion;
  }

  public void setFechaafi(String fechaafiliacion) {
    this.fechaafiliacion = fechaafiliacion;
  }

}