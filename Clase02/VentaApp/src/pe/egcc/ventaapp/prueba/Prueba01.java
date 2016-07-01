package pe.egcc.ventaapp.prueba;

import pe.egcc.ventaapp.dto.VentaDto;
import pe.egcc.ventaapp.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    VentaDto dto = new VentaDto();
    // Datos
    dto.setPrecio(80.0);
    dto.setCant(10);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(dto);
    // Reporte
    System.out.println("Importe: " + dto.getImporte());
    System.out.println("Impuesto: " + dto.getImpuesto());
    System.out.println("Total: " + dto.getTotal());
  }
  
}
