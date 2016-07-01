package pe.egcc.PagoTrabajador.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import pe.egcc.PagoTrabajador.dto.PagoDto;
import pe.egcc.PagoTrabajador.service.PagoService;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtHorasTrabajadas;
	private JTextField txtDíasTrabajados;
	private JTextField txtPagoPorHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoView frame = new PagoView();
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
	public PagoView() {
		setTitle("PAGO TRABAJADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHorasTrabajadas = new JLabel("Horas Trabajadas:");
		lblHorasTrabajadas.setBounds(49, 49, 106, 14);
		contentPane.add(lblHorasTrabajadas);
		
		JLabel lblNewLabel = new JLabel("D\u00EDas Trabajados:");
		lblNewLabel.setBounds(49, 84, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pago por Hora:");
		lblNewLabel_1.setBounds(49, 122, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		txtHorasTrabajadas = new JTextField();
		txtHorasTrabajadas.setBounds(151, 46, 86, 20);
		contentPane.add(txtHorasTrabajadas);
		txtHorasTrabajadas.setColumns(10);
		
		txtDíasTrabajados = new JTextField();
		txtDíasTrabajados.setColumns(10);
		txtDíasTrabajados.setBounds(151, 81, 86, 20);
		contentPane.add(txtDíasTrabajados);
		
		txtPagoPorHora = new JTextField();
		txtPagoPorHora.setColumns(10);
		txtPagoPorHora.setBounds(151, 119, 86, 20);
		contentPane.add(txtPagoPorHora);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Datos
				int DíasTrabajados = Integer.parseInt(txtDíasTrabajados.getText());
				double HorasTrabajadas = Double.parseDouble(txtHorasTrabajadas.getText());
				double PagoPorHora = Double.parseDouble(txtPagoPorHora.getText());
				
				//Proceso
				
				PagoDto dto = new PagoDto();
				dto.setDias(DíasTrabajados);
				dto.setHoras(HorasTrabajadas);
				dto.setPagoHora(PagoPorHora);
				PagoService service = new PagoService();
				service.calcular(dto);
				
				//Reporte
				String texto = "";
				texto += "Pago Total: " + dto.getPago() + "\n";
				texto += "Renta: " + dto.getRenta() + "\n";
				JOptionPane.showMessageDialog(rootPane, texto);
				
			}
		});
		btnCalcular.setBounds(273, 80, 89, 56);
		contentPane.add(btnCalcular);
	}

}
