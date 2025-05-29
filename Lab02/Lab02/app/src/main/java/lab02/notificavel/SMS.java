package lab02.notificavel;

public class SMS extends Mensagem implements Notificavel {
    private final String numero_remetente;
    private final String numero_destinatario;
    private final String conteudo;

    public SMS(String remetente, String destinatario, String conteudo) {
        // checa se remetente possui apenas dígitos (função feita com IA)
        if (!remetente.matches("[0-9]+") || !destinatario.matches("[0-9]+")) {
            throw new IllegalArgumentException("Remetente e destinario devem conter apenas dígitos.");
        }

        this.numero_remetente = remetente;
        this.numero_destinatario = destinatario;
        this.conteudo = conteudo;
    }

    @Override
    public void visualizar() {
        this.setReadStatus(true);
        System.out.println("Email:");
        System.out.println("Remetente: "    + this.numero_remetente);
        System.out.println("Destinatario: " + this.numero_destinatario);
        System.out.println("Conteudo: "     + this.conteudo);
        System.out.println();
    }

    @Override
    public void notificar() {
        if (this.getReadStatus()== false) {
            System.out.println("Novo SMS:");
            System.out.println("Remetente: "    + this.numero_remetente);
            System.out.println("Destinatario: " + this.numero_destinatario);
            System.out.println();
        }
    }
}