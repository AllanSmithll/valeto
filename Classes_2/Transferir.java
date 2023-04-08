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

public class Transferir {

	private JFrame frame;
	private Estacionamento estacionamento;
	private JTextField vagaOrigemField;
	private JTextField vagaDestinoField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Transferir window = new Transferir();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Transferir(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 346);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transferir Vaga");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(149, 25, 224, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel vagaOrigemLabel = new JLabel("Vaga Origem:");
		vagaOrigemLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vagaOrigemLabel.setBounds(103, 88, 104, 19);
		frame.getContentPane().add(vagaOrigemLabel);
		
		vagaOrigemField = new JTextField();
		vagaOrigemField.setBounds(203, 89, 86, 20);
		frame.getContentPane().add(vagaOrigemField);
		vagaOrigemField.setColumns(10);
		
		JLabel vagaDestinoLabel = new JLabel("Vaga Destino");
		vagaDestinoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vagaDestinoLabel.setBounds(103, 142, 104, 19);
		frame.getContentPane().add(vagaDestinoLabel);
		
		vagaDestinoField = new JTextField();
		vagaDestinoField.setColumns(10);
		vagaDestinoField.setBounds(203, 143, 86, 20);
		frame.getContentPane().add(vagaDestinoField);
		
		JButton btnNewButton = new JButton("Transferir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vagaOrigem = Integer.parseInt(vagaOrigemField.getText());
				vagaOrigemField.setText("");
				int vagaDestino = Integer.parseInt(vagaDestinoField.getText());
				vagaDestinoField.setText("");
				
				try {
					estacionamento.transferir(vagaOrigem, vagaDestino);
					JOptionPane.showMessageDialog(null, "Vaga transferida de " + vagaOrigem + " para a vaga " + vagaDestino);
					frame.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(181, 204, 137, 38);
		frame.getContentPane().add(btnNewButton);
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
