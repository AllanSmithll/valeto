# Sistema-Estacionamento-POO - Requisitos do Projeto

## A classe Valetinho:

Aplicação Gráfica que usa a classe Estacionamento para gerenciar as N vagas de um estacionamento de veículos, através das seguintes opções:

1. Entrada: O manobrista digita uma vaga livre e a placa do veículo e o sistema registra a ocupação desta vaga com a placa.
2. Saída: O manobrista digita a vaga do veículo e o sistema registra a vaga como “livre”
3. Consulta de Placa: O manobrista digita a placa e o sistema exibe a vaga onde está o veículo ou “inexistente”
4. Transferência de Placa: O manobrista digita as vagas origem e destino e o sistema transfere a placa do veículo para a vaga destino, desocupando a vaga origem
5. Listagem Geral: O sistema exibe o conteúdo de todas as vagas do estacionamento (placa ou “livre”)
6. Listagem de vagas livres: O sistema exibe as vagas livres do estacionamento


## A classe Estacionamento:

### Atributos (private)

- `String[] placas` array para armazenar as placas dos veículos estacionados nas vagas 1 a N

### Métodos (public)

- `Estacionamento(n)` cria e inicializa as N vagas
- `void entrar(placa, vaga)` ocupa a vaga com a placa e grava data de entrada no arquivo “historico.csv”
- `void sair(vaga)` desocupa a vaga e grava data de saída no arquivo “historico.csv”
- `int consultarPlaca(placa)` retorna a vaga da placa, ou -1 caso a placa não exista.
- `void transferir(vaga1,vaga2)` move a placa da vaga1 para a vaga2
- `String[] listarGeral()` retorna o conteúdo das N vagas (placa ou “livre”)
- `ArrayList<Integer> listarLivres()` retorna os números das vagas livres
- `void gravarDados()` gravar no arquivo “placas.csv”, a placa de cada vaga ocupada no momento
- `void lerDados()` ler do arquivo “placas.csv”, a placa de cada vaga ocupada no momento

Obs:
- A especificação dos atributos e métodos não pode ser alterada
- O método construtor deve lançar exceção (objeto Exception) para N<=0
- Os métodos entrar, sair e transferir devem lançar exceção (objeto Exception) quando:
    - a vaga estiver fora do limite 1 a N
    - a vaga não puder ser ocupada por já estar ocupada
    - a vaga não puder ser desocupada por já estar desocupada
- A data de entrada e de saída deve ser obtida do computador através de LocalDateTime().now() e formatada com “dd/MM/yyyy hh:mm:ss”
- Arquivo placas.csv tem formato vaga;placa
- Arquivo historico.csv tem formato data;vaga;placa;”entrada ou saída”
- Testar a classe Estacionamento com as aplicações de teste fornecidas (console) 
