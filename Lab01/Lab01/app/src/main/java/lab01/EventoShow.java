/*
 * EventoShow.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab01;

/**
 * Contém a estrutura de implementação de um evento de show.
 * 
 * @author Vinicius Andreossi - 195125
 */
public class EventoShow extends Evento implements FiltroEventos {
    private String generoMusical;
    private String artista;

    /**
     * Construtor da classe EventoShow
     * @param generoMusical o gênero musical do show
     * @param artista o artista que tocará no show
     */
    public EventoShow(String nome, Local local, float precoIngresso, String generoMusical, String artista){
        super(nome, local, precoIngresso);
        this.generoMusical = generoMusical;
        this.artista = artista;
        this.setCategoria("Show");
    }    

    /**
     * Verifica se o evento é um show
     * @param evento o evento a ser verificado
     */
    @Override
    public boolean filtrar(Class filtro){
        if (filtro.isInstance(this)) {
            return true;
        }
        return false;
    }

    /**
     * Retorna o gênero musical do show
     * @return o gênero musical do show
     */
    public String getGeneroMusical(){
        return this.generoMusical;
    }

    /**
     * Altera o genero musical do evento para genero
     * @param esporte o novo genero musical do evento
     */
    public void setGeneroMusical(String genero){
        this.generoMusical = genero;
    }    

    /**
     * Retorna o artista que tocará no show
     * @return o artista que tocará no show
     */
    public String getArtista(){
        return this.artista;
    }

    /**
     * Altera o artista do evento para artista
     * @param esporte o novo artista do evento
     */
    public void setArtista(String artista){
        this.artista = artista;
    }    

    /**
     * Escrita dos atributos do evento de show
     */
    public void exibirDetalhes() {
        System.out.println("Nome do evento: " + this.getNome());
        System.out.println("Local: " + this.getLocal().getNome());
        System.out.println("Preço do ingresso: " + this.getPrecoIngresso());
        System.out.println("Gênero musical: " + this.getGeneroMusical());
        System.out.println("Artista: " + this.getArtista());
    }
}
