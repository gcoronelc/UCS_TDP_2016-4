package pe.egcc.ventaapp.service;

import pe.egcc.ventaapp.dto.VentaDto;

public class VentaService {

  public void procesar(VentaDto dto){
    // Variables
    double importe, impuesto, total;
    // Proceso
    total = dto.getPrecio() * dto.getCant();
    importe = total / 1.18;
    impuesto = total - importe;
    // Reporte
    dto.setImporte(importe);
    dto.setImpuesto(impuesto);
    dto.setTotal(total);
  }
  
}
