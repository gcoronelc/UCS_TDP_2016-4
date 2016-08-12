/*
 *******************************************************************************
 * @author:         Fernando Parodi
 *                  fparodig@gmail.com
 *                  944154597
 * @Universidad:    Cientifica del Sur
                    Ingenieria de Sistema y Gestion de Información
 *******************************************************************************
 */
package Prueba;

import Domain.Cliente;
import Service.Impl.ClienteServiceImpl;
import Service.Espec.ClienteServiceEspec;

/**
 *
 * @author Gustavo Coronel
 * @email gcoronelc@gmail.com
 * @blog www.desarrollasoftware.com
 */
public class Prueba04 {

    public static void main(String[] args) {

        try {
            Cliente bean = new Cliente();
            bean.setCodigo("0");
            bean.setPaterno("");
            bean.setMaterno("");
            bean.setNombre("");
            ClienteServiceEspec service;
            service = new ClienteServiceImpl();
            for (Cliente a : service.getRecords(bean)) {
                System.out.println(a.getCodigo()
                        + " | " + a.getPaterno()
                        + " | " + a.getMaterno()
                        + " | " + a.getNombre());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
