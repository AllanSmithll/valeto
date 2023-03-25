/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Classe Estacionamento
*/
package classes;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// As propriedades precisam ser melhoradas
public class Estacionamento {
	private String[] placas;
	
	// Construtor
	public Estacionamento(int vagasTotais) throws Exception {
		if(vagasTotais <= 0) {
			throw new Exception("Quantidade de vagas inválida. Tem que ter pelo menos uma vaga.");
		}
		placas = new String[vagasTotais];
		
		for(int i=0; i<placas.length; i++) {
			placas[i] = "livre";
		}
	}
	
	// Método para adicionar um carro a uma vaga, e registrar no histórico
	public void entrar(String placa, int vaga) throws Exception{
		if (!placas[vaga-1].equals("livre")) {
			throw new Exception("A vaga está ocupada.");
		}
		if(vaga < 1 || vaga > this.placas.length) {
			throw new Exception(" A vaga está fora do intervalo de 1 a " + this.placas.length);
		}
		
		else {
			FileWriter historicoMovimentacao = new FileWriter("./data/historico.csv", true);
			LocalDateTime dataAtual = LocalDateTime.now();
			DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String dataFormatada = dataAtual.format(formatacaoData);
			
			placas[vaga-1] = placa;
			
			historicoMovimentacao.write(String.format("%s;%s;%s;%s%n", dataFormatada, vaga, placa, "Entrada"));
			historicoMovimentacao.flush();
			historicoMovimentacao.close();
		}
	}

	public void sair(int vaga) {
		placas[vaga-1] = "livre";
	}

	public void transferir(int origem, int destino) {
		if(placas[destino] == "livre") {
			String variavelAuxiliar = placas[origem];
			placas[origem] = "livre";
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
	
	public void gravarDados() {
		
	}
	
	public void lerDados() {
		
	}
}
