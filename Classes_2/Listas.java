package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Listas {

	private JFrame frame;
	private Estacionamento estacionamento;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Listas window = new Listas();
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
		JLabel Listas = new JLabel("Listagens");
		Listas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
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
					if(i == listaGeral.length/2) {
						textArea.append( i + "º["+ vaga +"]" + "\n");
					}
					else {
					textArea.append( i + "º["+ vaga +"] ");}
					}
			}
		});
		ListaGeralButton.setBounds(73, 124, 157, 58);
		frame.getContentPane().add(ListaGeralButton);
		
		JButton VagasLivresButton = new JButton("Vagas Livres");
		VagasLivresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				int i = 0;
				ArrayList<Integer> vagasLivres = estacionamento.listarLivres();					
				for(int vaga : vagasLivres ) { i++;
				if(i == vagasLivres.size()/2) {
					textArea.append("[Vaga: " +  vaga +"]" + "\n");
				}
				else {
				textArea.append("[Vaga: " +  vaga +"]");}}
			}
		});
		VagasLivresButton.setBounds(334, 124, 157, 58);
		frame.getContentPane().add(VagasLivresButton);
		

		Listas.setHorizontalAlignment(SwingConstants.CENTER);
		Listas.setBounds(148, 32, 303, 45);
		frame.getContentPane().add(Listas);
		
		
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(73, 217, 469, 69);
		frame.getContentPane().add(textArea);
		
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
