/*

 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03.eventos;

import lab03.Local;

public class EventoShow extends Evento {
        
    private String artista;
    
    /**
    * Construtor da classe EventocShow
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param artista o artista do Evento
    * @param organizadora a organizadora do Evento
    */
    public EventoShow(String nome, Local local, double precoIngresso, String data, String artista) {
        super(nome, local, precoIngresso, data);
        this.artista = artista;

    }

    @Override
    public String getDescricao() {
        return "Nome do evento: " + this.nome + "\n" +
               "Local: " + this.local.getNome() + "\n" +
               "Data: " + this.data + "\n" +
               "Artista: " + this.artista + "\n" +
               "Preço do ingresso: R$ " + this.precoIngresso + "\n";
    }

    /**
     * Retorna o artista do Evento
     * @return o artista do Evento 
     */
    public String getArtista() {
        return artista;
    }
}
