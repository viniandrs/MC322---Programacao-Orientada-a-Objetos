package lab02;
import java.util.ArrayList;
import java.util.List;

import lab02.filters.Filter;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;
    private List<Evento> eventos;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
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
    public boolean criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, List<String> times) {
        Evento evento = new EventoJogo(nome, local, precoIngresso, organizadora, data, times);
        return eventos.add(evento);
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
    public boolean criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, List<String> lineup, int duracao) {
        Evento evento = new EventoFestival(nome, local, precoIngresso, organizadora, data, lineup, duracao);
        return eventos.add(evento);
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
    public boolean criarEvento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, String artista) {
        Evento evento = new EventoShow(nome, local, precoIngresso, organizadora, data, artista);
        return eventos.add(evento);
    }
    
    /**
     * Busca eventos na lista de eventos da organizadora com base no filtro fornecido
     * @param filtro o filtro a ser aplicado na busca
     * @return uma lista de eventos que atendem ao filtro
     */
    public List<Evento> buscarEventos(Filter<Evento> filtro) {
        List<Evento> eventosFiltrados = new ArrayList<>();
        for (Evento evento : this.eventos) {
            if (filtro.filtrar(evento)) {
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
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
