/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.jpaj.wilsonapp.domain;

/**
 *
 * @author jcpr1994
 */
public class Producto {
    private Integer tp_producto;
    private String tipo;
    private String nombre;
    private Double precio;
    private String descripcion;
    private Integer stock;
    private Integer stock_min;

    /**
     * @return the tp_producto
     */
    public Integer getTp_producto() {
        return tp_producto;
    }

    /**
     * @param tp_producto the tp_producto to set
     */
    public void setTp_producto(Integer tp_producto) {
        this.tp_producto = tp_producto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return the stock_min
     */
    public Integer getStock_min() {
        return stock_min;
    }

    /**
     * @param stock_min the stock_min to set
     */
    public void setStock_min(Integer stock_min) {
        this.stock_min = stock_min;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
