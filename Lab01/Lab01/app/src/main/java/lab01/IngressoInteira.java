/*
 * IngressoInteira.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um Ingresso com preço inteiro.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class IngressoInteira extends Ingresso{
    /**
     * Construtor da classe Ingresso inteiro
     * @param evento o evento associado ao Ingresso
     */
    public IngressoInteira(Evento evento) {
        super(evento);
    }

    /**
     * Retorna o preço do Ingresso inteiro
     * @return o preço do Ingresso inteiro
     */
    @Override
    public float getPreco() {
        return this.getEvento().getPrecoIngresso();
    }
    
}
