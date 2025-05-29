package lab02.notificavel;

public class Email extends Mensagem implements Notificavel {
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

    @Override
    public void visualizar() {
        this.setReadStatus(true);
        System.out.println("Email:");
        System.out.println("Remetente: "    + this.remetente);
        System.out.println("Destinatario: " + this.destinatario);
        System.out.println("Assunto: "      + this.assunto);
        System.out.println("Conteudo: "     + this.conteudo);
        System.out.println();
    }

    @Override
    public void notificar() {
        if (this.getReadStatus()==false) {
            System.out.println("<NOTIFICACAO> Novo email:");
            System.out.println("Remetente: "    + this.remetente);
            System.out.println("Destinatario: " + this.destinatario);
            System.out.println();
        }
        else {
            System.out.println("Email já visualizado.");
        }
    }
}