/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */


package lab03.eventos;

import java.util.List;

import lab03.Local;

public class EventoJogo extends Evento {
        
    private List<String> times;
    /**
    * Construtor da classe EventoEsporte
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    */
    public EventoJogo(String nome, Local local, double precoIngresso, String data, List<String> times) {
        super(nome, local, precoIngresso, data);
        this.times = times;
    }

    @Override
    public String getDescricao() {
        return "Nome do evento: " + this.nome + "\n" +
               "Local: " + this.local.getNome() + "\n" +
               "Data: " + this.data + "\n" +
               "Times: " + String.join(" vs ", this.times) + "\n" +
               "Preço do ingresso: R$ " + this.precoIngresso + "\n";
    }

    /**
     * Retorna a lista com os nomes dos times que se enfrentam no Evento
     * @return a lista com os nomes dos times do Evento
     */
    public List<String> getTimes() {
        return times;
    }
    
}
