package pe.ucs.wilsonapp.domain;

public class Combo {
    
    private String code;
    private String name;
    private String select;

    public Combo() {
    }
    
    public Combo(String code, String name)
    {
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
}
