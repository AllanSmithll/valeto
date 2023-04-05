/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Testador criado por nós para o nosso projeto
*/
import classes.Estacionamento;

public class TestadorProprio {

	public static void main(String[] args) throws Exception{
		Estacionamento estacionamento = new Estacionamento(10);	//10 vaga

		try {
			System.out.println("Listar geral:");
			for(String s : estacionamento.listarGeral()) {
				System.out.println(s);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			estacionamento.entrar("AAA1111",11);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			estacionamento.entrar("AAA2222",2);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			estacionamento.sair(1);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			estacionamento.entrar("AAA3333", 3);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			estacionamento.transferir(3, 4);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			int vagaPosicao = estacionamento.consultarPlaca("AAA2222");
			System.out.println("vaga da placa AAA2222 = "+vagaPosicao);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			estacionamento.entrar("adi2345", 6);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			estacionamento.sair(6);
			System.out.println("Listar geral novamente:");
			for(String vagas : estacionamento.listarGeral()) {
				System.out.println(vagas);
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
