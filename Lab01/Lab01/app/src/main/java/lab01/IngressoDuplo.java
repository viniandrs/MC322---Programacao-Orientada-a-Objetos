/*
 * IngressoDuplo.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um combo de dois Ingressos com preço inteiro.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class IngressoDuplo extends Ingresso{
    /**
     * Construtor da classe Ingresso duplo
     * @param evento o evento associado ao Ingresso
     */
    public IngressoDuplo(Evento evento) {
        super(evento);
        this.setTipo("Duplo");
    }

    /**
     * Retorna duas vezes o preço do Ingresso inteiro
     * @return duas vezes o preço do Ingresso inteiro
     */
    @Override
    public float getPreco() {
        return this.getEvento().getPrecoIngresso() * 2;
    }

    public IngressoInteira getIngressoInteira() {
        return new IngressoInteira(this.getEvento());
    }
    
}
