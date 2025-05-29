package lab03.models;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import lab03.Ingresso;
import lab03.Local;
import lab03.OfertaIngresso;
import lab03.Organizadora;
import lab03.Utils;
import lab03.eventos.Evento;
import lab03.filters.EventoPorNomeFilter;
import lab03.filters.Filter;

// Singleton class to manage a database of organizers, locations ands events
public class Model {
    private static Model instance;
    
    // databases
    private List<Organizadora> organizadoras;
    private List<Local> lugares;
    private List<Evento> eventos;

    // client data
    private List<Ingresso> meusIngressos;
    private double saldo;

    // Initial state
    public Model() {
        // this.clientes = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.organizadoras = new ArrayList<>();
        this.lugares = new ArrayList<>();
        this.meusIngressos = new ArrayList<>();
        this.saldo = 10000.0;
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    private void loadOrgs(String filepath) {
        try {
            FileReader filereader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            csvReader.readNext(); // Skip the header
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord.length >= 3) {
                    // int id = Integer.parseInt(nextRecord[0]);
                    String nome = nextRecord[1];
                    String cnpj = nextRecord[2].trim();
                    String endereco = nextRecord[3].trim();
                    
                    EventoPorNomeFilter filtro = new EventoPorNomeFilter(nome);
                    this.organizadoras.add(new Organizadora(nome, cnpj, endereco));
                    System.out.println("Organizadora criada: " + nome);
                } else {
                    System.out.println("Organizadora ignorada: formato inválido.");
                }
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar organizadoras: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadLocations(String filepath) {
        try {
            FileReader filereader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            csvReader.readNext(); // Skip the header
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord.length >= 3) {
                    // int id = Integer.parseInt(nextRecord[0]);
                    String nome = nextRecord[1];
                    int capacidade = Integer.parseInt(nextRecord[2].trim());

                    this.lugares.add(new Local(nome, capacidade));
                    System.out.println("Lugar adicionado: " + nome);
                } else {
                    System.out.println("Lugar ignorado: formato inválido.");
                }
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar locais: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadEvents(String filepath) {
        try {
            FileReader filereader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            csvReader.readNext(); // Skip the header
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord.length >= 3) {
                    // read the event data
                    String nome = nextRecord[0];
                    int tipo = Integer.parseInt(nextRecord[1].trim());
                    Organizadora org = this.getOrganizadora(Integer.parseInt(nextRecord[2].trim()));
                    Local loc = this.getLocal(Integer.parseInt(nextRecord[3].trim()));
                    double preco = Double.parseDouble(nextRecord[4]);
                    String data = nextRecord[5];
                    String extraInfo = nextRecord[6];

                    // create the event based on its type
                    Evento ev = null;
                    switch (tipo) {
                        case 0 -> { // Evento jogo
                            List<String> teams = Utils.parseCommaSeparatedWords(extraInfo);
                            ev = org.criarEvento(nome, loc, preco, data, teams);
                        }
                        case 1 -> { // Evento festival
                            List<String> infos = Utils.parseCommaSeparatedWords(extraInfo);
                            List<String> artistas = new ArrayList<>(infos.subList(0, infos.size() - 1));
                            int duracao = Integer.parseInt(infos.remove(infos.size() - 1));
                            ev = org.criarEvento(nome, loc, preco, data, artistas, duracao);
                        }
                        case 2 -> { // Evento show
                            ev = org.criarEvento(nome, loc, preco, data, extraInfo);
                        }
                    }
                    
                    eventos.add(ev);
                    System.out.println("Evento adicionado: " + nome);
                } else {
                    System.out.println("Evento ignorado: formato inválido.");
                }
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar eventos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // load data from csv files
    public void loadData() {
        System.out.println("Starting to load data...");
        this.loadOrgs(getClass().getResource("/lab03/data/orgs.csv").getPath());
        this.loadLocations(getClass().getResource("/lab03/data/locations.csv").getPath());
        this.loadEvents(getClass().getResource("/lab03/data/events.csv").getPath());
        System.out.println("Finished loading data.");        
    }

    /**
     * Método para comprar um ingresso para um evento direto da lista de eventos
     * @param evento o evento para o qual o ingresso será comprado
     * @return true se a compra for bem-sucedida, false caso contrário
     */
    public boolean comprarIngresso(Evento evento) {
        if (evento.getPrecoIngresso() > this.saldo) {
            System.out.println("Saldo insuficiente para comprar o ingresso.");
            return false;
        }

        Ingresso ingresso = new Ingresso(evento, evento.getPrecoIngresso());
        this.meusIngressos.add(ingresso);
        this.saldo -= evento.getPrecoIngresso();

        return true;        
    }

    /**
     * Método para comprar um ingresso para um evento através do Marketplace
     * @param oferta a oferta de ingresso para o evento
     * @return true se a compra for bem-sucedida, false caso contrário
     */
    public boolean comprarIngresso(OfertaIngresso oferta) {
        meusIngressos.add(new Ingresso(oferta.getEvento(), oferta.getEvento().getPrecoIngresso()));
        this.saldo -= oferta.getPreco();
        return true;
    }

    /**
     * Método para simular a venda de um ingresso no Marketplace
     * @param oferta a oferta de ingresso a ser vendida
     */
    public void simularVenda(OfertaIngresso oferta) {
        // Simula a venda de um ingresso, removendo-o da lista de ingressos do usuário
        meusIngressos.removeIf(ingresso -> ingresso.getEvento().equals(oferta.getEvento()));
        this.saldo += oferta.getPreco();
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

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Ingresso> getMeusIngressos() {
        return meusIngressos;
    }

    public Organizadora getOrganizadora(int index) {
        return organizadoras.get(index);
    }

    public Local getLocal(int index) {
        return lugares.get(index);
    }

    public double getSaldo() {
        return saldo;
    }
}