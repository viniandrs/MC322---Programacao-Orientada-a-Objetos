package lab3ex1;

public class Filme {
    private String titulo;
    private double nota;
    private String genero;

    public Filme(String titulo, double nota, String genero) {
        this.titulo = titulo;
        this.nota = nota;
        this.genero = genero;

    }

    /**
     * @return O título do filme
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return A nota do filme
     */
    public double getNota() {
        return nota;
    }   
}
