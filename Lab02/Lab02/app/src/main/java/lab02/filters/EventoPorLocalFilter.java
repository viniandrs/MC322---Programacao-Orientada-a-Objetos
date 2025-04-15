package lab02.filters;
import lab02.Evento;
import lab02.Local;

public class EventoPorLocalFilter implements Filter<Evento> {
    private final String local;

    public EventoPorLocalFilter(Local local) {
        this.local = local.getNome();
    }

    @Override
    public boolean filtrar(Evento evento) {
        return evento.getLocal().getNome().equalsIgnoreCase(this.local);
    }
}