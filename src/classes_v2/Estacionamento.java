/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Classe Estacionamento
*/
package classes_v2;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Classe Base
public class Estacionamento {
	private String[] placas;
	
	// Construtor
	public Estacionamento(int vagasTotais) throws Exception {
		if(vagasTotais <= 0) {
			throw new Exception("Quantidade de vagas inválida. Tem que ter pelo menos uma vaga no construtor.");
		}
		placas = new String[vagasTotais];
		
		for(int i=0; i<placas.length; i++) {
			placas[i] = "livre";
		}
	}
	
	// Método para adicionar uma placa a uma vaga, e registrar no histórico
	public void entrar(String placa, int vaga) throws Exception{
		String placaUpperCase = placa.toUpperCase();
		if (!formatacaoPlacaDentroDoPadrao(placaUpperCase)) {
			throw new Exception("A placa possui formato diferente do padrão, que é AAA0000 (3 letras e 4 números). Por isso, nada foi inserido no Estacionamento.");
		}
		if (placaIgualJaInserida(placaUpperCase)) {
			throw new Exception("A placa digitada já foi inserida!");
		}
		if ((!estaLivre(vaga))) {
			throw new Exception("Não pode entrar! A vaga está ocupada.");
		}
		if (vagaNaoExiste(vaga)) {
			throw new Exception("A vaga está fora do intervalo de 1 a " + this.placas.length + "vagas.");
		}
		else {
			FileWriter historicoMovimentacao = new FileWriter("./data/historico.csv", false);
			LocalDateTime dataAtual = LocalDateTime.now();
			DateTimeFormatter formatacaoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String dataFormatada = dataAtual.format(formatacaoData);
			
			placas[vaga-1] = placaUpperCase;
			
			historicoMovimentacao.write(String.format("%s;%s;%s;%s%n", dataFormatada, vaga, placaUpperCase, "Entrada"));
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
		if(destino == origem) {
			throw new Exception("Vaga de destino igual à vaga de origem.");
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
	public int consultarPlaca(String placa) {
		String placaUpperCase = placa.toUpperCase();
		int getIndex = Arrays.asList(this.placas).indexOf(placaUpperCase);
		if (this.placas[getIndex].equals(placaUpperCase)) {
			return getIndex + 1;
		}
		return -1;
	}
	
	// Listar todas as vagas do Estacionamento
	public String[] listarGeral() {
		return Arrays.copyOf(placas, placas.length);
	}

	// Listar as vagas livres do Estacionamento
	public ArrayList<Integer> listarLivres() {
		ArrayList<Integer> vagasLivres = new ArrayList<>();

		for(int i = 0; i < this.placas.length; i++){
    		if(estaLivre(i+1)){
    			vagasLivres.add(i+1);
    		}   
		}
		return vagasLivres;
	}
	
	// Método que grava a placa e a vaga ocupada no momento, no arquivo placas.csv
	public void gravarDados() throws Exception {
		try {
			FileWriter placas = new FileWriter("./data/placas.csv", false);
			for(int i=0; i < this.placas.length; i++) {
				if(!estaLivre(i+1)) {
					placas.write(String.format("%s;%s%n", i+1, this.placas[i]));
				}
			}
			placas.flush();
			placas.close();	
		} catch (Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	// Método que serve para ler cada linha do arquivo placas.csv
	public void lerDados() throws Exception{
		try {
			File placas_file = new File("./data/placas.csv");

			if(placas_file.exists()) {
				Scanner sc = new Scanner("./data/placas.csv");
				String[] linhas_lidas_placas_csv = sc.nextLine().split(";");

				while(sc.hasNextLine()) {
					this.placas[Integer.parseInt(linhas_lidas_placas_csv[0]) - 1] = linhas_lidas_placas_csv[0];
				}

				sc.close();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// Método toString(), que serve para retornar os valores que estão na propriedade placas
	public String toString() {
		return "Estacionamento [placas=" + Arrays.toString(placas) + "]";
	}

	// MÉTODOS PRIVATE
	// Método para saber se uma vaga está livre
	private boolean estaLivre(int vaga) {return this.placas[vaga-1].equals("livre");}

	// Método para saber se a vaga existe
	private boolean vagaNaoExiste(int vaga) {return vaga < 1 || vaga > this.placas.length;}

	// Método para verificar se a placa do veículo que está entrando tem a mesma placa de um veículo que está dentro do Estacionamento
	private boolean placaIgualJaInserida(String placa) {
		for (String plac : placas) {
            if (plac != "livre" && plac.equals(placa)) return true;
        }
        return false;
	}

	// Método para saber se a placa está formatada
	private boolean formatacaoPlacaDentroDoPadrao(String placa) throws Exception {
		int TAMANHO_PADRAO_PLACA = 7;
		int QUANTIDADE_LETRAS = 3;
		int QUANTIDADE_NUMEROS = 4;

		// Verifica se a String possui exatamente o tamanho padrão
        if (placa.length() != TAMANHO_PADRAO_PLACA) {
            return false;
        }
        // Verifica se os primeiros três caracteres são letras
        for (int i = 0; i < QUANTIDADE_LETRAS; i++) {
            char c = placa.charAt(i);
            if (!Character.isLetter(c) || !Character.isUpperCase(c)) {
                return false;
            }
        }
        // Verifica se os últimos quatro caracteres são dígitos numéricos
        for (int i = QUANTIDADE_NUMEROS-1; i < TAMANHO_PADRAO_PLACA; i++) {
            char c = placa.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // Retorna true se a String atender a todas as regras de validação
        return true;
	}
}
