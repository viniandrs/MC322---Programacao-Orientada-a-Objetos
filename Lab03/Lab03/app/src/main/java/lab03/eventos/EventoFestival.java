/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.eventos;

import java.util.List;

import lab03.Local;

public class EventoFestival extends Evento {
        
    private List<String> lineup;
    private final int duracao;
    
    /**
    * Construtor da classe EventoFestival
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param dataInicio a data de início do Festival
    * @param dataFim a data de fim do Festival
    */
    public EventoFestival(String nome, Local local, double precoIngresso, String data, List<String> lineup, int duracao) {
        super(nome, local, precoIngresso, data);
        this.lineup = lineup;
        this.duracao = duracao;
    }

    @Override
    public String getDescricao() {
        return "Nome do evento: " + this.nome + "\n" +
               "Local: " + this.local.getNome() + "\n" +
               "Data: " + this.data + "\n" +
               "Lineup: " + String.join(", ", this.lineup) + "\n" +
               "Duração: " + this.duracao + " dias\n" +
               "Preço do ingresso: R$ " + this.precoIngresso + "\n";
    }

    /**
    * Retorna a lista com os nomes dos artistas que se apresentarão no Festival
    * @return a lista com os nomes dos artistas do Festival
    */
    public List<String> getLineup() {
        return this.lineup;
    }
    
    /**
    * Retorna a dura o do Festival em dias
    * @return a dura o do Festival
    */
    public int getDuracao() {
        return this.duracao;
    }
}
