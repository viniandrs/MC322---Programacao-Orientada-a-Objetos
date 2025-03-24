/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um Ingresso.
 * 
 * @author Gabriel Leite - 216180
 * @author Caio Rhoden - 214129
 * @author Vinicius Andreossi - 195125
 */
public abstract class Ingresso {

    private final Evento evento;

    /**
     * Construtor da classe Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public Ingresso(Evento evento){
        this.evento = evento;
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public abstract float getPreco();

    /**
     * Retorna o evento associado ao Ingresso
     * @return o evento associado ao Ingresso
     */
    public Evento getEvento(){
        return this.evento;
    }
    
}
