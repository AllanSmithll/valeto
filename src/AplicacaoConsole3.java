/**
 * TSI - POO - Prof fausto Ayres
 * Teste da classe Estacionamento
 */
import classes.Estacionamento;
import java.util.Scanner;
import java.time.LocalDateTime;

public class AplicacaoConsole3 {
	public static void main(String[] args) {
		Estacionamento estacionamento = null;
		
		try {
			estacionamento = new Estacionamento(10);	//10 vagas
			estacionamento.lerDados();
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}


		String placa;
		int vaga;
		int op=0;
		Scanner teclado = new Scanner(System.in);
	
		do{
			try {
				System.out.println("\n---------------------------------------------------");
				System.out.println("VALETINHO DO IFPB  - " + LocalDateTime.now() );
				System.out.println("---------------------------------------------------");
				System.out.println("Menu:");
				System.out.println("0 - terminar programa");
				System.out.println("1 - entrar carro");
				System.out.println("2 - sair carro");
				System.out.println("3 - consultar placa");
				System.out.println("4 - transferir placa");
				System.out.println("5 - listar geral");
				System.out.println("6 - listar vagas livres");
				System.out.print("==>");
				op = Integer.parseInt(teclado.nextLine());

				switch(op) {
				case 0 : 
					System.out.println("Volte sempre!!!"); 
					break;
				case 1 : 
					System.out.print("Qual a placa para entrar? ");
					placa = teclado.nextLine();
					System.out.print("Qual a vaga para entrar? ");
					vaga = Integer.parseInt(teclado.nextLine());
					estacionamento.entrar(placa, vaga); 
					System.out.println("entrou");
					break;
				case 2 : 
					System.out.print("Qual a vaga para sair? ");
					vaga = Integer.parseInt(teclado.nextLine());
					estacionamento.sair(vaga); 
					System.out.println("saiu");
					break;
				case 3 : 
					System.out.print("Qual a placa para consultar? ");
					placa = teclado.nextLine();
					vaga = estacionamento.consultarPlaca(placa); 
					System.out.println("vaga="+vaga);
					break;
				case 4 : 
					System.out.print("Qual a vaga origem? ");
					vaga = Integer.parseInt(teclado.nextLine());
					System.out.print("Qual a vaga destino? ");
					int vagadestino = Integer.parseInt(teclado.nextLine());
					estacionamento.transferir(vaga, vagadestino); 
					System.out.println("transferiu");
					break;
				case 5 : 
					System.out.println("listar vagas geral");
					for(String s : estacionamento.listarGeral()) {
						System.out.println(s);
					}
					break;
				case 6 : 
					System.out.println("listar vagas livres");
					for(int i : estacionamento.listarLivres()) {
						System.out.println(i);
					}
					break;
				default: 
					System.out.println("Opção Invalida!");;
				}

			}//try
			catch(NumberFormatException e) {
				System.out.println("Numero invalido");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}while(op != 0);

		teclado.close();
		
		try {
			estacionamento.gravarDados();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());;
		}

	}
}