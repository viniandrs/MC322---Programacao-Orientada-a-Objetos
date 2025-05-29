package lab02.filters;
import lab02.Evento;

public class AndFilter implements Filter<Evento> {
    private Filter filtro_a;
    private Filter filtro_b;

    public AndFilter(Filter filtro1, Filter filtro2) {
        this.filtro_a = filtro1;
        this.filtro_b = filtro2;
    }

    @Override
    public boolean filtrar(Evento evento) {
        return filtro_a.filtrar(evento) && filtro_b.filtrar(evento);
    }
}