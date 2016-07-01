package pe.jcpr.practica1.service;

import pe.jcpr.practica1.dto.practica1Dto;

public class PracticaService {

	public void procesar(practica1Dto dto){
	    // Variables
		int horasdiarias,diaslab;
	    double pagoxhora,total,reten;
	    // Proceso
	    total = dto.getPagoxhora() * dto.getDiaslab()*dto.getHorasdiarias();
	   if (total>=1500) {
		   reten = total*0.08;
	}else {
		reten =0;
	}
	    
	    // Reporte
	    dto.setReten(reten);
	    dto.setTotal(total);
	  }
}
