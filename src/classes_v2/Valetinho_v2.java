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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class Valetinho_v2 {

	private JFrame frame;
	private Estacionamento  estacionamento = new Estacionamento(10);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valetinho_v2 window = new Valetinho_v2();
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
	public Valetinho_v2() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 649, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Estacionamento");
		JLabel errorArea = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 22, 199, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrar userEntry = new Entrar(estacionamento);

			}
		});
		btnNewButton.setBounds(151, 69, 89, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorArea.setText("");
				try {
				String aux = JOptionPane.showInputDialog("Qual vaga sairá? ");	
				if(aux == null)
				{
					errorArea.setText("");
				}
				else {
					int vaga = Integer.parseInt(aux);	
						estacionamento.sair(vaga);
						
				}}
				
					catch (Exception e1) {
						// TODO Auto-generated catch block
						errorArea.setText(e1.getMessage());
					}
				}
				
				
			}
		);
		sairButton.setBounds(151, 133, 89, 40);
		frame.getContentPane().add(sairButton);
		
		JButton btnNewButton_2 = new JButton("Tranferir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transferir userTransferir = new Transferir(estacionamento);
				
			}
		});
		btnNewButton_2.setBounds(342, 69, 89, 40);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton consultaButton = new JButton("Consultar");
		consultaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorArea.setText("");
				try {
					String vagaConsulta = JOptionPane.showInputDialog("Qual placa Deseja consultar? ");
					
					if(vagaConsulta == null ) {
						errorArea.setText("");
					}
					else {
						
						int aux  = estacionamento.consultarPlaca(vagaConsulta);

						if(aux < 0 ) {
							errorArea.setText("Placa não está no nosso estacionamento!");
						}
						else {
						JOptionPane.showMessageDialog(null,aux);
						String resposta = "Está na Nº: " +  Integer.toString(aux) +  "vaga";
						JOptionPane.showMessageDialog(null, resposta);}
					}
					
				}
				catch(Exception e1) {		
					
					
				}
			}
		});
		consultaButton.setBounds(342, 133, 89, 40);
		frame.getContentPane().add(consultaButton);
		
		JButton ListagemButton = new JButton("Listagens");
		ListagemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listas listaUser = new Listas(estacionamento);
			}
		});
		ListagemButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ListagemButton.setBounds(252, 213, 110, 40);
		frame.getContentPane().add(ListagemButton);
		
		
		errorArea.setHorizontalAlignment(SwingConstants.CENTER);
		errorArea.setBounds(45, 285, 532, 41);
		frame.getContentPane().add(errorArea);
	}
}
