package pe.jcpr.practica1.prueba;

import pe.jcpr.practica1.dto.practica1Dto;
import pe.jcpr.practica1.service.PracticaService;



public class prueba1 {
	public static void main(String[] args) {
		practica1Dto dto = new practica1Dto();
	    // Datos
	    dto.setDiaslab(8);
	    dto.setHorasdiarias(8);
	    dto.setPagoxhora(20.0);
	    // Proceso
	    PracticaService service = new PracticaService();
	    service.procesar(dto);
	    // Reporte
	    System.out.println("Retencion: " + dto.getReten());
	    System.out.println("Total: " + dto.getTotal());
	}
}
