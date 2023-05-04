/**
 * @authors TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Swing class - Entrar
*/
package classes;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class Entrar {

	private JFrame frame;
	private Estacionamento estacionamento;
	private JButton EntrarButton;

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
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Formatador
		MaskFormatter textPlaca=null;
		try {
			textPlaca = new MaskFormatter("UUU####");
			textPlaca.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
        	} catch (ParseException e) {
            		e.printStackTrace();
        	}

		JLabel lblNewLabel = new JLabel("Entrada no Estacionamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(100, 24, 262, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(68, 67, 102, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vaga");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(100, 120, 46, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JFormattedTextField placaField = new JFormattedTextField(textPlaca);
		placaField.setBounds(168, 74, 86, 20);
		frame.getContentPane().add(placaField);
		placaField.setColumns(10);
		
		JTextField vagaField = new JTextField();
		vagaField.setBounds(168, 123, 86, 20);
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
				try {vaga = Integer.parseInt(vagaField.getText().replace(" ", ""));}
				catch (NumberFormatException ex) { 
					errorLabel.setText("Error: digite um número válido para vaga!"); 
					return;
				}
				try {
					placa = placa.replace(" ", "");
					estacionamento.entrar(placa,vaga);
					errorLabel.setText("Entrada bem-sucedida!");
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
