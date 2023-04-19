/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Classe Valetinho
*/
package classes;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Valetinho {

	private JFrame frame;
	private Estacionamento  estacionamento = new Estacionamento(10);

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
		frame = new JFrame();
		frame.setTitle("Valetinho - Sistema de Estacionamento");
		frame.setBounds(100, 100, 649, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("O que deseja fazer?");
		JLabel errorArea = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 22, 199, 25);
		frame.getContentPane().add(lblNewLabel);
		
		// Botão de entrada
		JButton btnNewButton = new JButton("Entrada");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrar userEntry = new Entrar(estacionamento);
			}
		});
		btnNewButton.setBounds(151, 69, 110, 54);
		frame.getContentPane().add(btnNewButton);
		
		// Botão de saída
		JButton sairButton = new JButton("Saída");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorArea.setText("");
				String vagaSaida = JOptionPane.showInputDialog("De qual vaga sairá? ");
				if(vagaSaida==null) {System.out.println("Nenhuma operação realizada."); return;}
				if(vagaSaida.isEmpty()) {
    				JOptionPane.showMessageDialog(null, "Digite um valor para saída!", "Ajuda", JOptionPane.INFORMATION_MESSAGE); 
				}
				else {
    				try {
						errorArea.setText("");
						int vaga = Integer.parseInt(vagaSaida);    
						estacionamento.sair(vaga);
					} catch (NumberFormatException ex) { 
						errorArea.setText("Error: digite um número válido para vaga!");
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					} catch (Exception e1) {
						errorArea.setText("Error: "+e1.getMessage());
						}
					}
				}
			}
		);
		sairButton.setBounds(151, 133, 110, 54);
		frame.getContentPane().add(sairButton);
		
		// Botão de transferência
		JButton btnNewButton_2 = new JButton("Transferência");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transferir userTransferir = new Transferir(estacionamento);
			}
		});
		btnNewButton_2.setBounds(342, 69, 110, 54);
		frame.getContentPane().add(btnNewButton_2);
		
		// Botão de consultar placa
		JButton consultaButton = new JButton("Consulta");
		consultaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorArea.setText("");
				try {
					String vagaConsulta = JOptionPane.showInputDialog("Qual placa deseja consultar? ");
					if(vagaConsulta==null) {System.out.println("Nenhuma operação realizada."); return;}
					while(vagaConsulta.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Digite uma placa para consultar!", "Ajuda", JOptionPane.INFORMATION_MESSAGE);
						vagaConsulta = JOptionPane.showInputDialog("De qual vaga sairá? ");
					}
					int aux  = estacionamento.consultarPlaca(vagaConsulta);
					if(aux < 0 ) {
						errorArea.setText("Error: placa inexistente.");
					} else {
						String resposta = "A placa está na vaga Nº" +  Integer.toString(aux);
						JOptionPane.showMessageDialog(null, resposta);
					}
				}
				catch(Exception e1) {
					errorArea.setText("Error: ocorreu um erro ao consultar a placa!");
				}
			}
		});
		consultaButton.setBounds(342, 133, 110, 54);
		frame.getContentPane().add(consultaButton);
		
		// Botão de listagem
		JButton ListagemButton = new JButton("Listagens");
		ListagemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listas listaUser = new Listas(estacionamento);
			}
		});
		ListagemButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ListagemButton.setBounds(246, 207, 116, 54);
		frame.getContentPane().add(ListagemButton);
		
		
		errorArea.setHorizontalAlignment(SwingConstants.CENTER);
		errorArea.setBounds(45, 285, 532, 41);
		frame.getContentPane().add(errorArea);
		
		// Gravar dados após fechar a aplicação
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        int resposta = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja sair?", "Sair da aplicação", JOptionPane.YES_NO_OPTION);
	        if (resposta == JOptionPane.YES_OPTION) {
	          System.out.println("Fechando a aplicação...");
	          try { estacionamento.gravarDados(); } catch (Exception e1) { e1.printStackTrace();}
	          System.out.println("Finalizado!");
	          System.exit(0);
	        }
	      }
	    });
	}
}