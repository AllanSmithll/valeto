/**
 * TSI - POO - Prof fausto Ayres
 * Teste da classe Estacionamento
 */
import classes.Estacionamento;
public class AplicacaoConsole1 {

	public static void main(String[] args) {
		try {
			Estacionamento estacionamento = new Estacionamento(10);	//10 vagas

			System.out.println("listar geral");
			for(String s : estacionamento.listarGeral()) {
				System.out.println(s);
			}
			System.out.println("listar vagas livres");
			for(int i : estacionamento.listarLivres()) {
				System.out.println(i);
			}
			estacionamento.entrar("AAA1111",1);
			estacionamento.entrar("AAA2222",2);
			estacionamento.entrar("AAA5555",5);
			estacionamento.entrar("AAA6666",6);
			estacionamento.sair(1);
			estacionamento.entrar("BBB1111",1);
			estacionamento.sair(2);
			estacionamento.entrar("BBB2222",2);
			estacionamento.sair(6);
			estacionamento.entrar("BBB6666",6);
			estacionamento.sair(1);
			estacionamento.transferir(5,10);

			int vaga = estacionamento.consultarPlaca("AAA5555");
			System.out.println("vaga da placa AAA5555 = "+vaga);

			System.out.println("listar vagas geral");
			for(String s : estacionamento.listarGeral()) {
				System.out.println(s);
			}
			
			System.out.println("listar vagas livres");
			for(int i : estacionamento.listarLivres()) {
				System.out.println(i);
			}

			System.out.println("gravar dados no arquivo");
			estacionamento.gravarDados();
			System.out.println("ler dados do arquivo");
			estacionamento.lerDados();
			
			System.out.println("listar vagas geral");
			for(String s : estacionamento.listarGeral()) {
				System.out.println(s);
			}
			System.out.println("listar vagas livres");
			for(int i : estacionamento.listarLivres()) {
				System.out.println(i);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}