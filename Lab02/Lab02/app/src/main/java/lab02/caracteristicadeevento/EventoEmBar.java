package lab02.caracteristicadeevento;

public class EventoEmBar extends CaracteristicaDeEvento {
    private final String nomeBar;
    private final String inicioHappyHour;
    private final String duracaoHappyHour;

    public EventoEmBar(String nomeBar, String inicioHappyHour, String duracaoHappyHour) {
        this.nomeBar = nomeBar;
        this.inicioHappyHour = inicioHappyHour;
        this.duracaoHappyHour = duracaoHappyHour;
    }

    @Override
    public void descricao() {
        System.out.println("Evento no bar " + this.nomeBar + ", Happy Hour Inicio: " + this.inicioHappyHour + ", Duração: " + this.duracaoHappyHour);
    }
}