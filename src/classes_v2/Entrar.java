package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entrar {

	private JFrame frame;
	private JTextField placaField;
	private JTextField vagaField;
	private Estacionamento estacionamento;
	private JButton EntrarButton;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @param estacionamento 
	 */
	public Entrar(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entre no Estacionamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(100, 24, 230, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(68, 67, 102, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vaga");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(100, 117, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		placaField = new JTextField();
		placaField.setBounds(168, 70, 86, 20);
		frame.getContentPane().add(placaField);
		placaField.setColumns(10);
		
		vagaField = new JTextField();
		vagaField.setBounds(168, 116, 86, 20);
		frame.getContentPane().add(vagaField);
		vagaField.setColumns(10);
		
		EntrarButton = new JButton("Entrar");
		EntrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String placa = placaField.getText();
				int vaga = Integer.parseInt(vagaField.getText());
				try {
					estacionamento.entrar(placa,vaga);
					JOptionPane.showMessageDialog(null, "Entrada Feita na vaga:  " + vaga);
					frame.dispose();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					String error = e1.getMessage();
				
				
				}
			}
		});
		EntrarButton.setBounds(165, 189, 102, 34);
		frame.getContentPane().add(EntrarButton);
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		voltarButton.setBounds(0, 0, 72, 23);
		frame.getContentPane().add(voltarButton);
	}
}
