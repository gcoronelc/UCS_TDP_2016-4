package ClienteServidor.Domain;

public class Combo {
  
  private String code;
  private String name;
  private int select;

  public Combo() {
  }

  public Combo(String code, String name, int select) {
    this.code = code;
    this.name = name;
    this.select = select;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSelect() {
    return select;
  }

  public void setSelect(int select) {
    this.select = select;
  }

  @Override
  public String toString() {
    return name;
  }

}
