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
                    + "| 1 - LIVROS                                             |\n"
                    + "| 2 - LEITORES                                           |\n"
                    + "| 3 - FUNCIONÁRIOS                                       |\n"
                    + "| 4 - EMPRÉSTIMOS                                        |\n"
                    + "| 5 - SAIR DO SISTEMA                                    |\n"
                    + "|--------------------------------------------------------|\n");

            digito = teclado.nextInt();
            switch(digito) {
                case 1:
                    int digitoLivro;
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                       MENU DE LIVROS                   |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE LIVROS                             |\n"
                                + "|--------------------------------------------------------|\n");
                        digitoLivro = teclado.nextInt();
                        teclado.nextLine();

                        switch (digitoLivro) {
                            	case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
			}
			    
		    } while (digitoLivro != 6);
			  break;
			    
		case 2:
		     int digitoLeitor;
		     do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                      MENU DE LEITORES                  |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE LEITORES                           |\n"
                                + "|--------------------------------------------------------|\n");
                        digitoLeitor = teclado.nextInt();
                        teclado.nextLine();

                        switch (digitoLeitor) {
                            	case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
			}
			    
		    } while (digitoLeitor != 6);
			    break;
		case 3:
                    int digitoFuncionario;
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                    MENU DE FUNCIONÁRIOS                |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE FUNCIONÁRIOS                       |\n"
                                + "|--------------------------------------------------------|\n");
                        digitoFuncionario = teclado.nextInt();
                        teclado.nextLine();

                        switch (digitoFuncionario) {
                            	case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
			}
			    
		    } while (digitoFuncionario != 6);
			  break;
		case 4:
                    int digitoEmprestimo;
                    do {
                        teclado.nextLine();
                        System.out.println("\n|--------------------------------------------------------|\n"
                                + "|                    MENU DE EMPRÉSTIMOS                 |\n"
                                + "|--------------------------------------------------------|\n"
                                + "| 1 - CADASTRAR                                          |\n"
                                + "| 2 - ALTERAR                                            |\n"
                                + "| 3 - BUSCAR                                             |\n"
                                + "| 4 - REMOVER                                            |\n"
                                + "| 5 - LISTAR                                             |\n"
                                + "| 6 - SAIR DO MENU DE EMPRÉSTIMOS                        |\n"
                                + "|--------------------------------------------------------|\n");
                        digitoEmprestimo = teclado.nextInt();
                        teclado.nextLine();

                        switch (digitoEmprestimo) {
                            	case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				default:
			}
			    
		    } while (digitoEmprestimo != 6);
			  break;
            }
            
        }while(digito != 5);
}
            
