package lab03;
import java.util.ArrayList;
import java.util.List;

import lab03.eventos.Evento;
import lab03.eventos.EventoFestival;
import lab03.eventos.EventoJogo;
import lab03.eventos.EventoShow;

public class Organizadora {

    private String nome;
    private String cnpj;
    private String endereco;
    private List<Evento> eventos;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.eventos = new ArrayList<>();
    }

    /**
     * Adiciona um evento de jogo à lista de eventos da organizadora
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param organizadora a organizadora do evento
     * @param data a data do evento
     * @param times os times que participarão do evento
     * @return true se o evento foi adicionado com sucesso, false caso contrário
     */
    public EventoJogo criarEvento(String nome, Local local, double precoIngresso, String data, List<String> times) {
        EventoJogo evento = new EventoJogo(nome, local, precoIngresso, data, times);
        eventos.add(evento);
        return evento;
    }

    /**
     * Adiciona um evento de festival à lista de eventos da organizadora
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param organizadora a organizadora do evento
     * @param data a data do evento
     * @param lineup a lista de artistas que se apresentarão no festival
     * @param duracao a duração do festival em dias
     * @return true se o evento foi adicionado com sucesso, false caso contrário
     */
    public EventoFestival criarEvento(String nome, Local local, double precoIngresso, String data, List<String> lineup, int duracao) {
        EventoFestival evento = new EventoFestival(nome, local, precoIngresso, data, lineup, duracao);
        eventos.add(evento);
        return evento;
    }

    /**
     * Adiciona um evento de show à lista de eventos da organizadora
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param organizadora a organizadora do evento
     * @param data a data do evento
     * @param artista o artista que se apresentará no show
     * @return true se o evento foi adicionado com sucesso, false caso contrário
     */
    public EventoShow criarEvento(String nome, Local local, double precoIngresso, String data, String artista) {
        EventoShow evento = new EventoShow(nome, local, precoIngresso, data, artista);
        eventos.add(evento);
        return evento;
    }

    /**
     * Escreve os eventos da organizadora no console
     */
    public void listEventos() {
        System.out.println("Eventos da organizadora " + this.nome + ":");
        for (Evento evento : eventos) {
            System.out.println("  > " + evento.getNome() + " - " + evento.getLocal().getNome() + " - " + evento.getData());
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public String getNome() {
        return this.nome;
    }
}
