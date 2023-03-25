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
		if ((!estaLivre(vaga))) {
			throw new Exception("Não pode entrar! A vaga está ocupada.");
		}

		if (vagaNaoExiste(vaga)) {
			throw new Exception(" A vaga está fora do intervalo de 1 a " + this.placas.length + "vagas.");
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

	// Método para remover uma placa de onde está estacionada e gravar no histórico
	public void sair(int vaga) throws Exception{
		if(estaLivre(vaga)) {
			throw new Exception("A vaga já está desocupada. Tente desocupar por outro número de vaga existente.");
		}
		if (vagaNaoExiste(vaga)) {
			throw new Exception("A vaga está fora do intervalo de 1 a " + this.placas.length + "vagas.");
		}

		else {
			FileWriter historicoMovimentacao = new FileWriter("./data/historico.csv", true);
			LocalDateTime dataAtual = LocalDateTime.now();
			DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String dataFormatada = dataAtual.format(formatacaoData);
			
			historicoMovimentacao.write(String.format("%s;%s;%s;%s%n", dataFormatada, vaga,placas[vaga-1], "Saida"));
			placas[vaga-1] = "livre";
			historicoMovimentacao.flush();
			historicoMovimentacao.close();
		}
	}

	// Transferir uma placa de uma vaga para outra
	public void transferir(int origem, int destino) throws Exception{
		if(vagaNaoExiste(origem) && vagaNaoExiste(destino)) {
			throw new Exception("Pelo menos uma das vagas são inexistentes.");
		}

		if(!estaLivre(origem)) {
			if (estaLivre(destino)) {
				placas[destino-1] = placas[origem-1];
				placas[origem-1] = "livre";
			}
			else {
				throw new Exception("Não foi possível transferir, pois a vaga de destino está ocupada.");
			}
		}
		else {
			throw new Exception("Não foi possível transferir, pois a vaga de origem está livre (vazia).");
		}

	}
	
	// Consultar uma placa específica do Estacionamento
	public int consultarPlaca(String placa) throws Exception{
		try {
			int contador = 0;
			for(String plac : placas) {
				if(plac != "livre" & plac.equals(placa)) {
					return contador + 1;
				}
				contador++;
			}
			return -1;
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public String[] listarGeral() {
		return placas;
	}
	
	public void gravarDados() {
		
	}
	
	public void lerDados() {
		
	}

	// MÉTODOS PRIVATE
	private boolean estaLivre(int vaga) {return this.placas[vaga-1].equals("livre");}
	private boolean vagaNaoExiste(int vaga) {return vaga < 1 || vaga > this.placas.length;}
}
