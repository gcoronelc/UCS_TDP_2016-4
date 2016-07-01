package pe.egcc.ventaapp.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pe.egcc.ventaapp.dto.VentaDto;
import pe.egcc.ventaapp.service.VentaService;

public class VentaView extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private JPanel contentPane;
  private JTextField txtPrecio;
  private JTextField txtCantidad;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          VentaView frame = new VentaView();
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
  public VentaView() {
    setTitle("VENTAS");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblPrecio = new JLabel("Precio:");
    lblPrecio.setBounds(33, 33, 64, 14);
    contentPane.add(lblPrecio);
    
    JLabel lblCantidad = new JLabel("Cantidad:");
    lblCantidad.setBounds(33, 61, 64, 14);
    contentPane.add(lblCantidad);
    
    txtPrecio = new JTextField();
    txtPrecio.setBounds(97, 30, 86, 20);
    contentPane.add(txtPrecio);
    txtPrecio.setColumns(10);
    
    txtCantidad = new JTextField();
    txtCantidad.setBounds(97, 58, 86, 20);
    contentPane.add(txtCantidad);
    txtCantidad.setColumns(10);
    
    JButton btnProcesar = new JButton("Procesar");
    btnProcesar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        // Datos
        double precio = Double.parseDouble(txtPrecio.getText());
        int cant = Integer.parseInt(txtCantidad.getText());
        // Proceso
        VentaDto dto = new VentaDto();
        dto.setPrecio(precio);
        dto.setCant(cant);
        VentaService service = new VentaService();
        service.procesar(dto);
        // Reporte
        String texto = "";
        texto += "Importe: " + dto.getImporte() + "\n";
        texto += "Impuesto: " + dto.getImpuesto() + "\n";
        texto += "Total: " + dto.getTotal() + "\n";
        JOptionPane.showMessageDialog(rootPane, texto);
      }
    });
    btnProcesar.setBounds(219, 33, 89, 45);
    contentPane.add(btnProcesar);
  }
  
  
  
  
}
