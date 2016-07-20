/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ucsur.proyecto.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrador
 */
public final class Memoria {
    private Memoria() {}
    
    private static final Map<String, Object> datos;

  static {
    datos = new HashMap<>();
  }

  public static void put(String key, Object value) {
    datos.put(key, value);
  }

  public static Object get(String key) {
    return datos.get(key);
  }
}
