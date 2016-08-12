package pe.ucs.wilsonapp.domain;

public class Usuario {
    
  private String USUARIO_ID;
  private String USUARIO_PASS;
  private String USUARIO_NOMBRE;
  private String USUARIO_APELLIDOS;
  private String USUARIO_CARGO;
  private String USUARIO_EMAIL;
  private String USUARIO_ESTADO;
  
  public Usuario() {
  }

  public String getId() {
    return USUARIO_ID;
  }

  public void setId(String USUARIO_ID) {
    this.USUARIO_ID = USUARIO_ID;
  }

  public String getClave() {
    return USUARIO_PASS;
  }

  public void setClave(String USUARIO_PASS) {
    this.USUARIO_PASS = USUARIO_PASS;
  }

  public String getNombre() {
    return USUARIO_NOMBRE;
  }

  public void setNombre(String USUARIO_NOMBRE) {
    this.USUARIO_NOMBRE = USUARIO_NOMBRE;
  }
  
    public String getApellidos() {
    return USUARIO_APELLIDOS;
  }

  public void setApellidos(String USUARIO_APELLIDOS) {
    this.USUARIO_APELLIDOS = USUARIO_APELLIDOS;
  }
  
  public String getCargo() {
    return USUARIO_CARGO;
  }

  public void setCargo(String USUARIO_CARGO) {
    this.USUARIO_CARGO = USUARIO_CARGO;
  }

  public String getEmail() {
    return USUARIO_EMAIL;
  }

  public void setEmail(String USUARIO_EMAIL) {
    this.USUARIO_EMAIL = USUARIO_EMAIL;
  }
  
   public String getEstado() {
    return USUARIO_ESTADO;
  }

  public void setEstado(String USUARIO_ESTADO) {
    this.USUARIO_ESTADO = USUARIO_ESTADO;
  }
  
}