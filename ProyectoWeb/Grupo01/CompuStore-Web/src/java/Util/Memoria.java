/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package ClienteServidor.Util;

import java.util.HashMap;
import java.util.Map;

public final class Memoria {

    private Memoria() {
    }

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
