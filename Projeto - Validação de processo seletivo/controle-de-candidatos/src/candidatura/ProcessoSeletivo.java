package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Hugo", "Emi", "João", "Marcio", "Jorge"};
        for(String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }  

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }

        } while (continuarTentando && tentativasRealizadas < 3);
        
        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + "° tentativa");
        } else {
            System.out.println("Não conseuimos contato com " + candidato + ", número máximo de tentativas " + tentativasRealizadas + " realizada");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados () {
        String [] candidatos = {"Hugo", "Emi" , "João", "Marcio", "Jorge"};
        
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        
        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de n° " + (indice + 1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação for each");

        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }

    static void selecaoDeCandidatos() {
        String [] candidatos = {"Hugo", "João", "Marcio", "Jorge", "Flavio", "Guilherme", "Enzo", "Emi", "Endell", "Edu"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário" + salarioPretendido);
            
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            } 
            candidatoAtual++;
        }
    }

    static double valorPretendido () {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }
}
