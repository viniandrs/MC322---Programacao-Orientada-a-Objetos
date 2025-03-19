/*
 * IngressoVIP.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um Ingresso 50% mais caro que o ingresso inteiro.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class IngressoVIP extends Ingresso{
    /**
     * Construtor da classe Ingresso VIP
     * @param evento o evento associado ao Ingresso
     */
    public IngressoVIP(Evento evento) {
        super(evento);
    }

    /**
     * Retorna 150% do preço do Ingresso inteiro 
     * @return 150% do preço do Ingresso inteiro
     */
    @Override
    public float getPreco() {
        return this.getEvento().getPrecoIngresso() * (float) (1.5);
    }
    
}
