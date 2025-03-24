/*
 * EventoTeatro.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um evento de teatro.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class EventoTeatro extends Evento implements FiltroEventos {
    private String diretor;
    private int duracao;

    /**
     * Construtor da classe EventoTeatro
     * @param diretor o diretor da peça de teatro
     * @param duracao a duração da peça de teatro em horas
     */
    public EventoTeatro(String nome, Local local, float precoIngresso, String diretor, int duracao){
        super(nome, local, precoIngresso);
        this.diretor = diretor;
        this.duracao = duracao;
        this.setCategoria("Teatro");
    }    

    /**
     * Verifica se o evento é uma peca de teatro
     * @param evento o evento a ser verificado
     */
    @Override
    public boolean filtrar(Evento evento){
        if (evento instanceof EventoTeatro) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o diretor da peça de teatro
     * @return o diretor da peça de teatro
     */
    public String getDiretor(){
        return this.diretor;
    }

    /**
     * Altera o diretor da peca para diretor
     * @param esporte o novo diretor da peca
     */
    public void setDiretor(String diretor){
        this.diretor = diretor;
    }    

    /**
     * Retorna a duracao da peça de teatro
     * @return a duracao da peça de teatro
     */
    public int getDuracao(){
        return this.duracao;
    }

    /**
     * Altera a duracao da peca para duracao
     * @param duracao a duracao da peca em horas
     */
    public void setDiretor(int duracao){
        this.duracao = duracao;
    }    

    /**
     * Escrita dos atributos do evento de teatro
     */
    public void dump() {
        System.out.println("Nome do evento: " + this.getNome());
        System.out.println("Local: " + this.getLocal().getNome());
        System.out.println("Preço do ingresso: " + this.getPrecoIngresso());
        System.out.println("Diretor da peça: " + this.getDiretor());
        System.out.println("Duracao em horas: " + this.getDuracao());
    }
}
