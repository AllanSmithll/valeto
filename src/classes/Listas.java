/**
 * @authors TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Swing class - Listas
*/
package classes;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Listas {

	private JFrame frame;
	private Estacionamento estacionamento;



	/**
	 * Create the application.
	 */
	public Listas(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane();
		frame.setTitle("Valetinho - Sistema de Estacionamento");
		JLabel Listas = new JLabel("Listagens");
		Listas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBounds(100, 100, 609, 387);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ListaGeralButton = new JButton("Lista Geral");
		ListaGeralButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] listaGeral = estacionamento.listarGeral();
				textArea.setText("");
				int i = 0;
				for(String vaga : listaGeral ) {
					i++;
					textArea.append( i + "ª["+ vaga +"] " + "\n");}
			}
		});
		ListaGeralButton.setBounds(236, 122, 157, 58);
		frame.getContentPane().add(ListaGeralButton);
		
		JButton VagasLivresButton = new JButton("Vagas Livres");
		VagasLivresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				ArrayList<Integer> vagasLivres = estacionamento.listarLivres();					
				for(int vaga : vagasLivres ) { 
					textArea.append("[Vaga: " + vaga +"]" + "\n");
				}
			}
		});
		VagasLivresButton.setBounds(236, 216, 157, 58);
		frame.getContentPane().add(VagasLivresButton);
		

		Listas.setHorizontalAlignment(SwingConstants.CENTER);
		Listas.setBounds(148, 32, 303, 45);
		frame.getContentPane().add(Listas);
		
	
		scrollPane.setBounds(69, 77, 157, 226);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		
		textArea.setBackground(new Color(240, 240, 240));
		
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
