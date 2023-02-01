package visao;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        int digito;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("\n");
            System.out.print("|--------------------------------------------------------|\n");
            System.out.print("|                  SISTEMA BIBLIOTECÁRIO                 |\n");
            System.out.print("|--------------------------------------------------------|\n");
            System.out.print("|                       MENU PRINCIPAL                   |\n"
                    + "|--------------------------------------------------------|\n"
                    + "| ESCOLHA UMA OPÇÃO ABAIXO:                              |\n"
                    + "|--------------------------------------------------------|\n"
                    + "| 1 - LIVRO                                              |\n"
                    + "| 2 - LEITOR                                             |\n"
                    + "| 3 - FUNCIONÁRIO                                        |\n"
                    + "| 4 - EMPRÉSTIMO                                         |\n"
                    + "| 5 - SAIR DO SISTEMA                                    |\n"
                    + "|--------------------------------------------------------|\n");

            digito = teclado.nextInt();
            switch(digito) {
                case 1:
                	
                	break;
            }
            
        }while(digito != 5);
        
	}
}
            
