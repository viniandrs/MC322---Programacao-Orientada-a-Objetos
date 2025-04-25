/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;
import java.util.ArrayList;
import java.util.List;

import lab02.caracteristicadeevento.CaracteristicaDeEvento;
import lab02.exceptions.IngressoEsgotadoException;

public abstract class Evento {
    protected String nome;
    protected Local local;
    protected double precoIngresso; // preço base do ingresso
    protected Organizadora organizadora;
    protected String data;
    protected int ingressos_disponiveis;
    private List<CaracteristicaDeEvento> caracteriscas;

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     */
    public Evento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data) {
        this.nome = nome;
        this.local = local;
        this.precoIngresso = precoIngresso; // modificar para representar o preço base do ingresso
        this.organizadora = organizadora;
        this.data = data;
        this.ingressos_disponiveis = local.getCapacidade();
        this.caracteriscas = new ArrayList<>();
    }

    public void venderIngresso(Cliente cliente, Ingresso ingresso) throws IngressoEsgotadoException {
        if(this.getIngressosDisponiveis() == 0) {
            throw new IngressoEsgotadoException("Ingressos esgotados para o evento " + this.nome);
        } 
        cliente.adicionarIngresso(ingresso);
        this.ingressos_disponiveis--;
    }

    /**
     * Adiciona uma característica ao evento
     * @param caracteristica a característica a ser adicionada
     */
    public void adicionarCaracteristica(CaracteristicaDeEvento caracteristica) {
        this.caracteriscas.add(caracteristica);
    }

    public void descricaoDoEvento() {
        System.out.println("Evento: " + this.nome);
        System.out.println("Local: " + this.local.getNome());
        System.out.println("Data: " + this.data);
        System.out.println("Preço do ingresso: R$" + this.precoIngresso);
        System.out.println("Ingressos disponíveis: " + this.ingressos_disponiveis);
        System.out.println("Características:");
        for (CaracteristicaDeEvento caracteristica : this.caracteriscas) {
            caracteristica.descricao();
        }
    }

    /**
     * Retorna a lista de características do evento
     */
    public List<CaracteristicaDeEvento> getCaracteristicas() {
        return this.caracteriscas;
    }

    /**
     * Retorna a quantidade de ingressos disponíveis
     * @return a quantidade de ingressos disponíveis
     */
    public int getIngressosDisponiveis() {
        return this.ingressos_disponiveis;
    }
    /**
     * Altera a quantidade de ingressos disponíveis para `ingressos_disponiveis` 
     * @param ingressos_disponiveis a nova quantidade de ingressos disponíveis
     */
    public void setIngressosDisponiveis(int ingressos_disponiveis) {
        this.ingressos_disponiveis = ingressos_disponiveis;
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Altera o local do Evento para `local` 
     * @param local o novo local do Evento
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    public String descricao(){
        return "Evento: " + this.nome + " - Local: " + this.local;
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public String getData() {
        return data;
    }


}