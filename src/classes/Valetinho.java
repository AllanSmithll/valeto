package classes;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Valetinho {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_consultar;
	private JTextField vagaOrigemField;
	private JTextField vagaDestinoField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valetinho window = new Valetinho();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Valetinho() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		Estacionamento estacionamento = new Estacionamento(10);
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 29, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Vaga:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(110, 8, 46, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 29, 46, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		JLabel errorLabel = new JLabel("");
		errorLabel.setBackground(new Color(0, 255, 0));
		
		JButton btnNewButton = new JButton("Entrar ");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				
				String placa = textField.getText();
				int vaga = Integer.parseInt(textField_1.getText());
				try {
					estacionamento.entrar(placa, vaga);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					String error = e1.getMessage();
					errorLabel.setText("Error: " + error);
				
				}
				JOptionPane.showMessageDialog(null, "Placa: " + placa + "\nVaga: " + vaga);
			}
		});
		btnNewButton.setBounds(20, 60, 76, 26);
		frame.getContentPane().add(btnNewButton);
		
		
		errorLabel.setBounds(10, 285, 368, 49);
		frame.getContentPane().add(errorLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Nº da vaga à sair: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 112, 126, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 133, 51, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				int vaga = Integer.parseInt(textField_2.getText());		
				try {
					estacionamento.sair(vaga);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					String error = e1.getMessage();
					errorLabel.setText("Error: " + error);
				}
			}
		});
		btnNewButton_1.setBounds(67, 132, 59, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel Label_ConsultarTitle = new JLabel("Consultar Placa:");
		Label_ConsultarTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Label_ConsultarTitle.setBounds(10, 166, 103, 26);
		frame.getContentPane().add(Label_ConsultarTitle);
		
		textField_consultar = new JTextField();
		textField_consultar.setBounds(10, 192, 71, 20);
		frame.getContentPane().add(textField_consultar);
		textField_consultar.setColumns(10);
		
		JLabel consultarLabel = new JLabel("");
		consultarLabel.setBackground(new Color(0, 255, 0));
		consultarLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		consultarLabel.setBounds(10, 257, 208, 28);
		frame.getContentPane().add(consultarLabel);
		
		JButton consultarBotao = new JButton("Consultar");
		consultarBotao.setBackground(new Color(255, 255, 255));
		consultarBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				try {
				String vagaCaractere = textField_consultar.getText();
				String resposta = Integer.toString(estacionamento.consultarPlaca(vagaCaractere));
				consultarLabel.setText("Seu carro está na vaga: " + resposta+"º");
				}
				catch(Exception e1) {
					String error = e1.getMessage();
					errorLabel.setText("Error: " + error);
				}
			}
		});
		consultarBotao.setBounds(7, 223, 89, 36);
		frame.getContentPane().add(consultarBotao);
		
		JLabel lblNewLabel_4 = new JLabel("Transferir Veículo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(191, 11, 128, 36);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vaga Origem:");
		lblNewLabel_5.setBounds(191, 48, 71, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		vagaOrigemField = new JTextField();
		vagaOrigemField.setBounds(269, 45, 46, 20);
		frame.getContentPane().add(vagaOrigemField);
		vagaOrigemField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Vaga Destino:");
		lblNewLabel_6.setBounds(191, 76, 79, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		vagaDestinoField = new JTextField();
		vagaDestinoField.setBounds(269, 70, 46, 20);
		frame.getContentPane().add(vagaDestinoField);
		vagaDestinoField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Transferir!");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				try {
					int vagaOrigem = Integer.parseInt(vagaOrigemField.getText());
					vagaOrigemField.setText("");
					int vagaDestino = Integer.parseInt(vagaDestinoField.getText());
					vagaDestinoField.setText("");
					estacionamento.transferir(vagaOrigem, vagaDestino);
					
				}
				catch(Exception e1){
					String error = e1.getMessage();
					errorLabel.setText("Error: " + error);
				}
			}
		});
		btnNewButton_2.setBounds(191, 113, 103, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("Lista Vagas Geral:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(419, 11, 126, 36);
		frame.getContentPane().add(lblNewLabel_7);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(421, 46, 103, 107);
		frame.getContentPane().add(scrollPane);
		textArea = new JTextArea();
		textArea.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(textArea);
		textArea.setTabSize(11);
		
		JButton btnNewButton_3 = new JButton("Listar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				try {
				String[] listaGeral = estacionamento.listarGeral();
				textArea.setText("");
				int i = 0;
				for(String vaga : listaGeral ) {
					i++;
					textArea.append("Nº: " + i + " " + vaga +"\n");
					
					}
				
				}
					
				
				catch(Exception e1) {
					String error = e1.getMessage();
					errorLabel.setText("Error: " + error);
				}					
			}			
		}
		
				
		);
		btnNewButton_3.setBounds(543, 104, 94, 40);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("Lista Vaga Livres:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(419, 172, 126, 20);
		frame.getContentPane().add(lblNewLabel_8);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(421, 201, 103, 107);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(192, 192, 192));
		scrollPane_1.setViewportView(textArea_1);
		
		JButton btnNewButton_4 = new JButton("Vagas Livres");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				try {
					textArea_1.setText("");
					ArrayList<Integer> vagasLivres = estacionamento.listarLivres();					
					for(int vaga : vagasLivres ) { textArea_1.append("Nº:" + vaga +"\n");}
				}
				catch(Exception e1) {
					String error = e1.getMessage();
					errorLabel.setText("Error: " + error);
				}
			}
		});
		btnNewButton_4.setBounds(534, 267, 103, 41);
		frame.getContentPane().add(btnNewButton_4);
	
		
		
		
	
	}
}
