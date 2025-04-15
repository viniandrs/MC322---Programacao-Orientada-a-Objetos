package lab02;

public class Email {
    private final String remetente;
    private final String destinatario;
    private final String assunto;
    private final String conteudo;

    public Email(String remetente, String destinatario, String assunto, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public void print() {
        System.out.println("Remetente: "    + this.remetente);
        System.out.println("Destinatario: " + this.destinatario);
        System.out.println("Assunto: "      + this.assunto);
        System.out.println("Conteudo: "     + this.conteudo);
        System.out.println();
    }
}