package pe.ucs.leccion2.view;
import pe.usc.leccion2.dto.Leccion2Dto;
import pe.ucs.leccion2.service.Leccion2Service;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leccion2View extends JFrame {
	private JTextField txtHorasTrabajadas;
	private JTextField txtDiasTrabajados;
	private JTextField txtPagoHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leccion2View frame = new Leccion2View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Leccion2View() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad de horas trabajadas:");
		lblNewLabel.setBounds(30, 11, 159, 14);
		getContentPane().add(lblNewLabel);
		
		txtHorasTrabajadas = new JTextField();
		txtHorasTrabajadas.setBounds(251, 11, 86, 20);
		getContentPane().add(txtHorasTrabajadas);
		txtHorasTrabajadas.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de dias trabajados:");
		lblNewLabel_1.setBounds(30, 47, 164, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtDiasTrabajados = new JTextField();
		txtDiasTrabajados.setColumns(10);
		txtDiasTrabajados.setBounds(251, 44, 86, 20);
		getContentPane().add(txtDiasTrabajados);
		
		JLabel lblPagoPorHora = new JLabel("Pago por hora:");
		lblPagoPorHora.setBounds(30, 78, 164, 14);
		getContentPane().add(lblPagoPorHora);
		
		txtPagoHora = new JTextField();
		txtPagoHora.setColumns(10);
		txtPagoHora.setBounds(251, 75, 86, 20);
		getContentPane().add(txtPagoHora);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
					int HorasTrabajadas = Integer.parseInt(txtHorasTrabajadas.getText());
					int DiasTrabajados = Integer.parseInt(txtDiasTrabajados.getText());
					double PagoHoras = Double.parseDouble(txtPagoHora.getText());
					
		    	  //Proceso
					Leccion2Dto dto = new Leccion2Dto();
					dto.setHorasTrabajadas(HorasTrabajadas);
					dto.setDiasTrabajados(DiasTrabajados);
					dto.setPagoHora(PagoHoras);
		    	  
					Leccion2Service service = new Leccion2Service();
					service.procesar(dto);
		    	  
		    	  //Reporte
		    	  String texto = "";
		    	  texto += "Horas trabajadas: " + dto.getHorasTrabajadas() + "\n";
		    	  texto += "Dias trabajados: " + dto.getDiasTrabajados() + "\n";
		    	  texto += "Pago Horas: " + dto.getPagoHora() + "\n";
		    	  texto += "Retencion: " + dto.getImpuesto() + "\n";
		    	  texto += "Pago Total: " + dto.getPagoTotal() + "\n";
		    	  
		    	  
		    	  JOptionPane.showMessageDialog(rootPane, texto);
			}
		});
		btnProcesar.setBounds(40, 150, 89, 23);
		getContentPane().add(btnProcesar);

	}

}
