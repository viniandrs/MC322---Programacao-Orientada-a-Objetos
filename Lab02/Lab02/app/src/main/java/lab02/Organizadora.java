package lab02;
import java.util.ArrayList;
import java.util.List;

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
    
}
