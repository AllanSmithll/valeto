/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Swing class - Entrar
*/
package classes_v2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		frame.setTitle("Valetinho - Sistema de Estacionamento");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entrada no Estacionamento");
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
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(new Color(0, 0, 0));
		errorLabel.setBackground(new Color(255, 255, 255));
		EntrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				String placa = placaField.getText();
				int vaga = 0;
				try {vaga = Integer.parseInt(vagaField.getText());}
				catch (NumberFormatException ex) { 
					errorLabel.setText("Error: digite um número válido para vaga!"); 
					return;
				}
				try {
					estacionamento.entrar(placa,vaga);
					JOptionPane.showMessageDialog(null, "Entrada feita na vaga: " + vaga);
					placaField.setText("");
					vagaField.setText("");
					// frame.dispose();
				} catch (Exception e1) { errorLabel.setText("Error: "+e1.getMessage());}
			}
		});
		EntrarButton.setBounds(164, 177, 102, 34);
		frame.getContentPane().add(EntrarButton);
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		voltarButton.setBounds(0, 0, 72, 23);
		errorLabel.setBounds(12, 221, 368, 30);
		frame.getContentPane().add(errorLabel);
		frame.getContentPane().add(voltarButton);
	}
}