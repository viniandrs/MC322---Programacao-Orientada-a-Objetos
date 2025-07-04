/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

import lab03.eventos.Evento;

/**
 * Contém a estrutura de implementação de um Ingresso.
 */
public class Ingresso {

    private Evento evento;
    private double preco;

    /**
     * Construtor da classe Ingresso
     * @param preco o preço do Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public Ingresso(Evento evento, double preco) {
        this.evento = evento;
        this.preco = preco;
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public double getPreco() {

        return this.preco;
    }

    /**
     * Retorna o evento associado ao Ingresso
     * @return o evento associado ao Ingresso
     */
    public Evento getEvento() {
        return this.evento;
    }
     
    /**
     * Define o evento associado ao Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
