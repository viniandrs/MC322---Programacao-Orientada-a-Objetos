package lab03;
import lab03.eventos.Evento;


public class OfertaIngresso {
    private final double preco;
    private final Evento evento;
    private final String anunciante;
    private boolean createdByUser = false;

    public OfertaIngresso(Evento evento, String anunciante, double precoPedido) {
        this.evento = evento;
        this.preco = precoPedido;
        this.anunciante = anunciante;
    }

    public double getPreco() {
        return this.preco;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public String getAnunciante() {
        return this.anunciante;
    }

    public boolean isCreatedByUser() {
        return this.createdByUser;
    }

    public void setCreatedByUser(boolean createdByUser) {
        this.createdByUser = createdByUser;
    }
}