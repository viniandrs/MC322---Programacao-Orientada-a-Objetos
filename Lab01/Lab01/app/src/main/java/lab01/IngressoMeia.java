/*
 * IngressoMeia.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um Ingresso com metade do preço.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class IngressoMeia extends Ingresso{
    /**
     * Construtor da classe Ingresso meia
     * @param evento o evento associado ao Ingresso
     */
    public IngressoMeia(Evento evento) {
        super(evento);
        this.setTipo("Meia");
    }

    /**
     * Retorna metade do preço do Ingresso inteiro 
     * @return metade do preço do Ingresso inteiro
     */
    @Override
    public float getPreco() {
        return this.getEvento().getPrecoIngresso() / 2;
    }
    
}
