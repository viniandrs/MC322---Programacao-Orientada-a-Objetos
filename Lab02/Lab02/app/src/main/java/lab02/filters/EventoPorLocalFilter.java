package lab02.filters;
import lab02.Evento;

public class EventoPorLocalFilter implements Filter<Evento> {
    private final String local;

    public EventoPorLocalFilter(String nomeLocal) {
        this.local = nomeLocal;
    }

    @Override
    public boolean filtrar(Evento evento) {
        return evento.getLocal().getNome().equalsIgnoreCase(this.local);
    }
}