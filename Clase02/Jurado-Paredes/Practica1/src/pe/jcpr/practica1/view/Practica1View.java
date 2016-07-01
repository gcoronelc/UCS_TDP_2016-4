package pe.jcpr.practica1.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JTextField;

import pe.jcpr.practica1.dto.practica1Dto;
import pe.jcpr.practica1.service.PracticaService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Practica1View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txthorasdiarias;
	private JTextField txtdiaslab;
	private JTextField txtpagoxhora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practica1View frame = new Practica1View();
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
	public Practica1View() {
		setTitle("Practica1");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblHorasDiarias = new JLabel("Horas Diarias:");
		lblHorasDiarias.setBounds(10, 19, 109, 14);
		getContentPane().add(lblHorasDiarias);
		
		txthorasdiarias = new JTextField();
		txthorasdiarias.setBounds(147, 16, 109, 20);
		getContentPane().add(txthorasdiarias);
		txthorasdiarias.setColumns(10);
		
		JLabel lblDiasLaboradoss = new JLabel("Dias Laborados:");
		lblDiasLaboradoss.setBounds(10, 44, 109, 14);
		getContentPane().add(lblDiasLaboradoss);
		
		JLabel lblPagoPorHora = new JLabel("Pago por Hora:");
		lblPagoPorHora.setBounds(10, 68, 109, 14);
		getContentPane().add(lblPagoPorHora);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int horasdiarias=Integer.parseInt(txthorasdiarias.getText());
				int diaslab=Integer.parseInt(txtdiaslab.getText());
				double pagoxhora=Double.parseDouble(txtpagoxhora.getText());
				
				practica1Dto dto = new practica1Dto();
			    // Datos
			   	dto.setHorasdiarias(horasdiarias);
			    dto.setDiaslab(diaslab);
			    dto.setPagoxhora(pagoxhora);
			    // Proceso
			    PracticaService service = new PracticaService();
			    service.procesar(dto);
			    // Reporte
			    String texto= "";
			    texto+="Retencion: " + dto.getReten()+"\n";
			    texto+="Total: " + dto.getTotal()+"\n";
			    texto+="Neto: " + (dto.getTotal()-dto.getReten())+"\n";
			    JOptionPane.showMessageDialog(rootPane, texto);
			}
		});
		btnNewButton.setBounds(147, 96, 89, 23);
		getContentPane().add(btnNewButton);
		
		txtdiaslab = new JTextField();
		txtdiaslab.setColumns(10);
		txtdiaslab.setBounds(147, 41, 109, 20);
		getContentPane().add(txtdiaslab);
		
		txtpagoxhora = new JTextField();
		txtpagoxhora.setColumns(10);
		txtpagoxhora.setBounds(147, 65, 109, 20);
		getContentPane().add(txtpagoxhora);

	}
}
