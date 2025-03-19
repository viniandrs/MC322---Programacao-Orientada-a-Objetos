package atividadelab1;
import java.util.Random;
import java.util.Scanner;

//IMPLEMENTE O EXERCICIO ABAIXO
class AdivinhaNumero {
    int numeroSecreto, palpite, tentativas = 0;

    public AdivinhaNumero() {
        Random random = new Random();
        this.numeroSecreto = random.nextInt(100) + 1; // Número entre 1 e 100
        
    }

    public void fazPalpite() {
        Scanner scanner = new Scanner(System.in);
        this.palpite = scanner.nextInt();
    }

    public boolean verificaPalpite() {
        if (this.palpite == this.numeroSecreto) {
            System.out.println("Acertou!");
            return true;
        } else if (this.palpite < this.numeroSecreto) {
            System.out.println("O número secreto é maior.");
        } else {
            System.out.println("O número secreto é menor.");
        }
        
        return false;
    }

    public void imprimeTentativas() {
        System.out.println("Tentativas: " + this.tentativas);
    }

    
}