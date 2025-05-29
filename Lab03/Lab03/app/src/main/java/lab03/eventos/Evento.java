/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.eventos;
import java.util.ArrayList;
import java.util.List;

import lab03.Ingresso;
import lab03.Local;
import lab03.caracteristicadeevento.CaracteristicaDeEvento;

public abstract class Evento {
    protected String nome;
    protected Local local;
    private List<Ingresso> ingressosVendidos;
    protected double precoIngresso; // preço base do ingresso
    protected String data;
    // protected int ingressos_disponiveis;
    private List<CaracteristicaDeEvento> caracteriscas;

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     */
    public Evento(String nome, Local local, double precoIngresso, String data) {
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso; // modificar para representar o preço base do ingresso
        this.data = data;
        this.caracteriscas = new ArrayList<>();
    }

    public String getDescricao(){
        System.out.println("Implementar uma descricao com as principais informacoes do evento.");
        return "Não implementado";
    }

    /**
     * Adiciona uma característica ao evento
     * @param caracteristica a característica a ser adicionada
     */
    public void adicionarCaracteristica(CaracteristicaDeEvento caracteristica) {
        this.caracteriscas.add(caracteristica);
    }

    /**
     * Retorna a lista de características do evento
     */
    public List<CaracteristicaDeEvento> getCaracteristicas() {
        return this.caracteriscas;
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public String getData() {
        return data;
    }


}