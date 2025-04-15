/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;
import lab02.exceptions.CapacidadeInsuficienteException;
import lab02.exceptions.LocalIndisponivelException;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Gabriel Leite - 216180
 */
public class Local{
    private String nome;
    private int capacidadeMaxima;
    private boolean alocado;
    private Evento eventoAlocado;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     */
    public Local(String nome, int capacidadeMaxima){
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alocado = false;  
    }

    public void alocarParaEvento(Evento evento) throws LocalIndisponivelException, CapacidadeInsuficienteException {
        if (evento.getIngressosDisponiveis() > this.capacidadeMaxima) {
            throw new CapacidadeInsuficienteException("Capacidade insuficiente para o evento " + evento.getNome());
        }
        
        if (this.alocado) {
            throw new LocalIndisponivelException("Local já alocado para o evento " + this.eventoAlocado.getNome());
        }
        this.alocado = true;
        this.eventoAlocado = evento;
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public int getCapacidade(){
        return this.capacidadeMaxima;
    }
    
    /**
     * Altera a capacidade máxima do local para `capacidadeMaxima` 
     * @param capacidadeMaxima a nova capacidade máxima do local
     */
    public void setCapacidade(int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
    }
}
