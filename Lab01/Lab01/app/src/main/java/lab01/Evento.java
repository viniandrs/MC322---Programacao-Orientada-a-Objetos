/*
 * Evento.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

import java.util.ArrayList;
import java.util.List;

/**
 * Contém a estrutura de implementação de um Evento.
 * 
 * @author Gabriel Leite - 216180
 * @author Caio Rhoden - 214129
 * @author Vinicius Andreossi - 195125s
 */
public abstract class Evento {
    private final String nome;
    private final Local local;
    private final float precoIngresso;
    private String categoria;
    private final List<Ingresso> ingressosVendidos = new ArrayList<>();

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     * @param precoIngresso o preço do ingresso inteiro do Evento
     */
    public Evento(String nome, Local local, float precoIngresso){
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso;
    }

    /**
     * Vende um ingresso para o Evento
     * @param ingresso o ingresso a ser vendido
     * @param usuario o usuário que está comprando o ingresso
     */
    public void adicionarIngresso(Ingresso ingresso, Usuario usuario){
        usuario.adicionarIngresso(ingresso);
        ingressosVendidos.add(ingresso);
    }

    /**
     * Retorna o faturamento do Evento
     * @return o faturamento do Evento
     */
    public float calcularFaturamento(){
        float total = 0;
        for (int i = 0; i <= ingressosVendidos.size(); i++){
            total += ingressosVendidos.get(i).getPreco();
        }

        return total;
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public float getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Retorna o Local associado ao Evento
     * @return o Local associado ao Evento
     */
    public Local getLocal(){
        return this.local;
    }

    /**
     * Retorna a categoria do evento
     * @return a categoria do evento
     */
    public String getCategoria(){
        return this.categoria;
    }

    /**
     * Altera a categoria do evento para `categoria`
     * @param categoria a nova categoria do evento
     */
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }
}
