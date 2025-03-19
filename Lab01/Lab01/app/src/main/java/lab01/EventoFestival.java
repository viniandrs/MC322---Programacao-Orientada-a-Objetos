/*
 * EventoFestival.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um evento de festival.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class EventoFestival extends Evento implements FiltroEventos {
    private int duracao;
    private String tema;

    /**
     * Construtor da classe EventoEsporte
     * @param duracao a duracao em dias do evento
     * @param tema o tema do festival
     */
    public EventoFestival(String nome, Local local, float precoIngresso, int duracao, String tema){
        super(nome, local, precoIngresso);
        this.duracao = duracao;
        this.tema = tema;
        this.setCategoria("Festival");
    }    

    /**
     * Verifica se o evento é um festival
     * @param evento o evento a ser verificado
     */
    @Override
    public boolean filtrar(Evento evento){
        if (evento instanceof EventoFestival) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a duracao do evento
     * @return a duracao do evento
     */
    public int getDuracao(){
        return this.duracao;
    }

    /**
     * Altera a duracao do evento para `duracao` 
     * @param duracao a nova duracao do evento
     */
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }

    /**
     * Retorna o tema do festival
     * @return o tema do festival
     */
    public String getTema(){
        return this.tema;
    }

    /**
     * Altera o tema do festival para `tema`
     * @param tema o novo tema do evento
     */
    public void setTema(String tema){
        this.tema = tema;
    }

    /**
     * Escrita dos atributos do evento de festival
     */
    public void dump() {
        System.out.println("Nome do evento: " + this.getNome());
        System.out.println("Local: " + this.getLocal().getNome());
        System.out.println("Preço do ingresso padrao: " + this.getPrecoIngresso());
        System.out.println("Duracao: " + this.getDuracao());
        System.out.println("Tema: " + this.getTema());
    }
}
