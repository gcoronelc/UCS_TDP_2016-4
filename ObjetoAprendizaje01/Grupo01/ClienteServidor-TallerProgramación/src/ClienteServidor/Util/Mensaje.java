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

import java.awt.Component;
import javax.swing.JOptionPane;

public final class Mensaje {

    private Mensaje() {
    }

    public static void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "SISTEMA VENTAS - ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "SISTEMA VENTAS - INFO", JOptionPane.INFORMATION_MESSAGE);
    }

}
