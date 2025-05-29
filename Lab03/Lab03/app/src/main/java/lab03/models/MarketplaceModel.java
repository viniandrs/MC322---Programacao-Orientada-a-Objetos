package lab03.models;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import lab03.OfertaIngresso;
import lab03.eventos.Evento;
import lab03.filters.EventoPorNomeFilter;

// Singleton class to manage a database of organizers, locations ands events
public class MarketplaceModel {
    private static MarketplaceModel instance;
    
    // databases
    private List<OfertaIngresso> ofertas;

    // Initial state
    public MarketplaceModel() {
        this.ofertas = new ArrayList<>();
        loadData();
    }

    public static MarketplaceModel getInstance() {
        if (instance == null) {
            instance = new MarketplaceModel();
        }
        return instance;
    }

    private void loadOffers(String filepath) {
        Model model = Model.getInstance();
        try {
            FileReader filereader = new FileReader(filepath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            csvReader.readNext(); // Skip the header
            while ((nextRecord = csvReader.readNext()) != null) {
                if (nextRecord.length >= 3) {
                    // int id = Integer.parseInt(nextRecord[0]);
                    String nome = nextRecord[0];
                    String owner = nextRecord[1].trim();
                    double preco = Double.parseDouble(nextRecord[2]);
   
                    Evento evento = model.buscarEventos(new EventoPorNomeFilter(nome)).get(0);                  
                    this.ofertas.add(new OfertaIngresso(evento, owner, preco));
                    System.out.println("Oferta criada: " + nome);
                } else {
                    System.out.println("Organizadora ignorada: formato inválido.");
                }
            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar ofertas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // load data from csv files
    public void loadData() {
        System.out.println("Starting to load data...");
        this.loadOffers(getClass().getResource("/lab03/data/offers.csv").getPath());
        System.out.println("Finished loading data.");        
    }

    public void criarOferta(Evento evento, double preco, String anunciante) {
        OfertaIngresso oferta = new OfertaIngresso(evento, anunciante, preco);
        oferta.setCreatedByUser(true); // Mark as created by user
        this.ofertas.add(oferta);
    }

    // Method to buy a ticket from the marketplace
    public void comprarIngresso(OfertaIngresso oferta) throws Exception {
        Model model = Model.getInstance();

        // check if balance is sufficient
        if (model.getSaldo() < oferta.getPreco()) {
            throw new Exception("Saldo insuficiente para comprar o ingresso.");
        }

        // check if the offer is from the user
        if (oferta.isCreatedByUser()) {
            throw new Exception("Você já possui este ingresso.");
        }

        model.comprarIngresso(oferta);
        ofertas.remove(oferta); // Remove the offer from the marketplace
    }

    // Method to simulate a sale of a ticket from an offer created by the user
    public void simularVenda(OfertaIngresso oferta) throws Exception {
        // check if the offer is from the user
        if (!oferta.isCreatedByUser()) {
            throw new Exception("Você não pode simular a venda de um ingresso que não foi criado por você.");
        }

        Model.getInstance().simularVenda(oferta);
        ofertas.remove(oferta); // Remove the offer from the marketplace
    }

    public List<OfertaIngresso> getOfertas() {
        return ofertas;
    }
}