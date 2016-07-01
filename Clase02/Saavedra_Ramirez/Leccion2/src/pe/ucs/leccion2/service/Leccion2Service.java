package pe.ucs.leccion2.service;

import pe.usc.leccion2.dto.Leccion2Dto;

public class Leccion2Service {

	public void procesar(Leccion2Dto dto)
	{		
		 // Variables
	    double HorasTrabajadas, DiasTrabajados, PagoHora, PagoTotal, Impuesto;
	    
	    // Proceso
	    PagoTotal = (dto.getHorasTrabajadas() * dto.getPagoHora())*dto.getDiasTrabajados();
	    Impuesto = PagoTotal * 0.08;
	   	    
	    // Reporte
	    dto.setPagoTotal(PagoTotal);
	    dto.setImpuesto(Impuesto);	    
	}

}
