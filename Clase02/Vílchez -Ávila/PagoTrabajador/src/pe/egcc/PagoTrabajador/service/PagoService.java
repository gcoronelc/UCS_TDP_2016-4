package pe.egcc.PagoTrabajador.service;

import pe.egcc.PagoTrabajador.dto.*; 

public class PagoService {
	
	public void calcular(PagoDto dto){
		//Variables
		double pagoT, renta;
		
		//Proceso
		pagoT = (dto.getHoras() * dto.getPagoHora()) * dto.getDias();
		renta = pagoT * 0.08;
		
		//Reporte
		dto.setPago(pagoT);
		dto.setRenta(renta);
	}
}
