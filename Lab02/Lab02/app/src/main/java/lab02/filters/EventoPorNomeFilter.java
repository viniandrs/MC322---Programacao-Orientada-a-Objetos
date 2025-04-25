package lab02.filters;
import lab02.Evento;

public class EventoPorNomeFilter implements Filter<Evento> {
    private final String nomeDoEvento;

    public EventoPorNomeFilter(String nome) {
        this.nomeDoEvento = nome;
    }

    @Override
    public boolean filtrar(Evento evento) {
        return evento.getNome().equalsIgnoreCase(this.nomeDoEvento);
    }
}