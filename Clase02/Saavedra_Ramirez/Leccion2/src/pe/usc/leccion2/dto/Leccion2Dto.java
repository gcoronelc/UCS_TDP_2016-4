
package pe.usc.leccion2.dto;

public class Leccion2Dto
{

	  // Datos
		private int HorasTrabajadas;
		private int DiasTrabajados;
		private double PagoHora;
		
	  
	  
	  // Respuesta
		private double Ingreso;
	  private double PagoTotal;
	  private double Impuesto;
	  
	  
	  public Leccion2Dto() {
	  }

	  public int getHorasTrabajadas() {
		    return HorasTrabajadas;
		  }

	  public void setHorasTrabajadas(int HorasTrabajadas) {
	    this.HorasTrabajadas = HorasTrabajadas;
	  }
	  
	  public int getDiasTrabajados() {
		    return DiasTrabajados;
		  }
	  	  
	  public void setDiasTrabajados(int DiasTrabajados) {
		    this.DiasTrabajados = DiasTrabajados;
		  }
	  
	  public double getIngreso() {
	    return Ingreso;
	  }
	  
	  public void setIngreso(int Ingreso) {
		    this.Ingreso = Ingreso;
		  }

	  public double getPagoHora() {
		    return PagoHora;
		  }
		  
		  public void setPagoHora(double PagoHora) {
			    this.PagoHora = PagoHora;
			  }
	  
	  public double getPagoTotal() {
		    return PagoTotal;
		  }
	  
	  public void setPagoTotal(double PagoTotal) {
		    this.PagoTotal = PagoTotal;
		  }
	  
	  public double getImpuesto() {
		    return Impuesto;
		  }
	  
	  public void setImpuesto(double Impuesto) {
		    this.Impuesto = Impuesto;
		  }
}
