/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Classe Estacionamento
*/
package classes;

// As propriedades precisam ser melhoradas
public class Estacionamento {
	private String[] placas;
	
	// Queria saber se as propriedades e o construtor estão corretos
	public Estacionamento(int vagasTotais) throws Exception {
		if(vagasTotais <= 0) {
			throw new Exception("Quantidade de vagas inválida. Tem que ter pelo menos uma vaga.");
		}
		placas = new String[vagasTotais];
		
		for(int i=0; i<placas.length; i++) {
			placas[i] = "livre";
		}
	}
	
	public void entrar(String placa, int vaga) {
		placas[vaga-1] = placa;
	}
	
	public void sair(int vaga) {
		placas[vaga-1] = "vago";
	}

	public void transferir(int origem, int destino) {
		if(placas[destino] == "vago") {
			String variavelAuxiliar = placas[origem];
			placas[origem] = "vago";
			placas[destino] = variavelAuxiliar;
		}
	}
	
	// Melhorar a consulta da placa
	public int consultarPlaca(String placa) {
		for(int i=0; i < placas.length; i++) {
			if( placa == placas[i])
				return i + 1;
		}
		return -1;
	}
	
	public String[] listarGeral() {
		return placas;
	}
	
	private boolean estaLivre(int vaga) {
		return this.placas[vaga] == "livre";
	}
}
