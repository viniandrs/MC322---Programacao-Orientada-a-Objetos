package lab02.caracteristicadeevento;

public class EventoMusicaAoVivo extends CaracteristicaDeEvento {
    private final String nomeArtista;
    private final String generoMusical;

    public EventoMusicaAoVivo(String nomeArtista, String generoMusical) {
        this.nomeArtista = nomeArtista;
        this.generoMusical = generoMusical;
    }

    @Override
    public void descricao() {
        System.out.println("Música ao vivo com " + this.nomeArtista + " tocando " + this.generoMusical);
    }
}