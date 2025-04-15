/*
 * EventoEsporte.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um evento de esporte.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class EventoEsporte extends Evento implements FiltroEventos {
    private int lotacao;
    private String esporte;

    /**
     * Construtor da classe EventoEsporte
     * @param lotacao a lotacao do evento
     * @param esporte o esporte do evento
     */
    public EventoEsporte(String nome, Local local, float precoIngresso, int lotacao, String esporte){
        super(nome, local, precoIngresso);
        this.lotacao = lotacao;
        this.esporte = esporte;
        this.setCategoria("Esporte");
    }    

    /**
     * Verifica se o evento é de esporte
     * @param evento o evento a ser verificado
     */
    @Override
    public boolean filtrar(Class filtro){
        if (filtro.isInstance(this)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a lotacao do evento
     * @return a lotacao do evento
     */
    public int getLotacao(){
        return this.lotacao;
    }
    
    /**
     * Altera a lotacao do evento para lotacao
     * @param lotacao a nova lotacao do evento
     */
    public void setLotacao(int lotacao){
        this.lotacao = lotacao;
    }        

    /**
     * Retorna o tipo de esporte do evento
     * @return o tipo de esporte do evento
     */
    public String getEsporte(){
        return this.esporte;
    }

    /**
     * Altera o esporte do evento para esporte
     * @param esporte o novo esporte do evento
     */
    public void setEsporte(String esporte){
        this.esporte = esporte;
    }       

    /**
     * Escrita dos atributos do evento de esporte
     */
    public void exibirDetalhes() {
        System.out.println("Nome do evento: " + this.getNome());
        System.out.println("Local: " + this.getLocal().getNome());
        System.out.println("Preço do ingresso padrao: " + this.getPrecoIngresso());
        System.out.println("Lotacao: " + this.getLotacao());
        System.out.println("Esporte: " + this.getEsporte());
    }
}
