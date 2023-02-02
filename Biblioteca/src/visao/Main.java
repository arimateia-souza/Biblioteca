package visao;

import java.util.Scanner;

import dominio.Emprestimo;
import dominio.Funcionario;
import dominio.Leitor;
import dominio.Livro;
import persistencia.EmprestimoDAO;
import persistencia.FuncionarioDAO;
import persistencia.LeitorDAO;
import persistencia.LivroDAO;

public class Main {
	
	static Livro livro = new Livro();
	static LivroDAO livroDAO = new LivroDAO();
	static Leitor leitor = new Leitor();
	static LeitorDAO leitorDAO = new LeitorDAO();
	static Funcionario funcionario = new Funcionario();
	static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	static Emprestimo emprestimo = new Emprestimo();
	static EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
	
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
                            	 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("|                   CADASTRO DE LIVRO                    |");
                                 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("| DIGITE O TÍTULO DO LIVRO:                              |");
                                 System.out.println("|--------------------------------------------------------|");
                                 livro.setTitulo(teclado.nextLine());
                                 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("| DIGITE O AUTOR DO LIVRO:                               |");
                                 System.out.println("|--------------------------------------------------------|");
                                 livro.setAutor(teclado.nextLine());
                                 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("| DIGITE O ANO DE PUBLICAÇÃO DO LIVRO:                   |");
                                 System.out.println("|--------------------------------------------------------|");
                                 livro.setAnoPublicacao(teclado.nextLine());
                               
                                

                                 livroDAO.insert(livro);

                                 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                                 System.out.println("|--------------------------------------------------------|");
                                 
                                 break;
                                 
							case 2:
								   System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|            ALTERAÇÃO DE CADASTRO DE LIVRO              |");
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("| DIGITE O ID DO LIVRO QUE DESEJA ALTERAR:               |");
	                                System.out.println("|--------------------------------------------------------|");
	                                int idAlterarLivro = teclado.nextInt();

	                                var livro_busca = livroDAO.buscar(idAlterarLivro);
	                                
	                                if (livro_busca == null) {
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                } else {
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| TÍTULO:" + livro_busca.getTitulo());
	                                    System.out.println("| AUTOR: " + livro_busca.getAutor());
	                                    System.out.println("| ANO DE PUBLICAÇÃO:" + livro_busca.getAnoPublicacao());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| 1 - TÍTULO                                             |");
	                                    System.out.println("| 2 - AUTOR                                              |");
	                                    System.out.println("| 3 - ANO DE PUBLICAÇÃO                                  |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    var opc = teclado.nextInt();

	                                    teclado.nextLine();
	                                    
	                                    switch (opc) {
                                        case 1:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE TÍTULO                 |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O TÍTULO DO LIVRO:" + livro_busca.getTitulo());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO TÍTULO DO LIVRO:                         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String tituloAlterado = teclado.nextLine();
                                            
                                            livro.setTitulo(tituloAlterado);

                                            String autorliv = livro_busca.getAutor();
                                            livro.setAutor(autorliv);

                                            String anopubliv = livro_busca.getAnoPublicacao();
                                            livro.setAnoPublicacao(anopubliv);

                                            livro.setId(idAlterarLivro);

                                            livroDAO.alteracao(livro, idAlterarLivro);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|               TÍTULO ALTERADO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 2:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                   ALTERAÇÃO DE AUTOR                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O AUTOR DO LIVRO: " + livro_busca.getTitulo());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO AUTOR DO LIVRO:                          |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String autorAlterado = teclado.nextLine();
                                            livro.setAutor(autorAlterado);

                                            String tituloliv = livro_busca.getTitulo();
                                            livro.setTitulo(tituloliv);

                                            String anopublicliv = livro_busca.getAnoPublicacao();
                                            livro.setAnoPublicacao(anopublicliv);

                                            livro.setId(idAlterarLivro);

                                            livroDAO.alteracao(livro, idAlterarLivro);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                AUTOR ALTERADO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;

                                        case 3:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             ALTERAÇÃO DE ANO DE PUBLICAÇÃO             |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O ANO DE PUBLICAÇÃO DO LIVRO: " + livro_busca.getTitulo());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO ANO DE PUBLICAÇÃO DO LIVRO:              |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String anoAlterado = teclado.nextLine();
                                            livro.setAnoPublicacao(anoAlterado);

                                            String titulolivr = livro_busca.getTitulo();
                                            livro.setTitulo(titulolivr);

                                            String autorlivr = livro_busca.getAutor();
                                            livro.setAutor(autorlivr);
                                            
                                            livro.setId(idAlterarLivro);

                                            livroDAO.alteracao(livro, idAlterarLivro);
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|         ANO DE PUBLICAÇÃO ALTERADO COM SUCESSO         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;
                                            
                                        default:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                            System.out.println("|--------------------------------------------------------|");


                                    }
                                }
                                break;

							case 3:
									System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|               BUSCAR CADASTRO DE LIVRO                 |");
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("| DIGITE O ID DO LIVRO:                                  |");
	                                System.out.println("|--------------------------------------------------------|");
	                                int idBuscaLivro = teclado.nextInt();
	                                teclado.nextLine();

	                                var liv = livroDAO.buscar(idBuscaLivro);


	                                if (liv != null) {
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ID: " + liv.getId());
	                                    System.out.println("| TÍTULO: " + liv.getTitulo());
	                                    System.out.println("| AUTOR: " + liv.getAutor());
	                                    System.out.println("| ANO DE PUBLICAÇÃO: " + liv.getAnoPublicacao());
	                                    System.out.println("|--------------------------------------------------------|");
	                                } else {
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                }
								break;
								
								
							case 4:
								   System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|            EXCLUSÃO DE CADASTRO DE LIVRO               |");
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("| DIGITE O ID DO LIVRO:                                  |");
	                                System.out.println("|--------------------------------------------------------|");
	                                var idExcluirLiv = teclado.nextInt();
	                                livro.setId(idExcluirLiv);

	                                var verificaExcLiv = livroDAO.buscar(idExcluirLiv);

	                                if (verificaExcLiv != null) {
	                                    teclado.nextLine();
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|          CADASTRO DO LIVRO QUE SERÁ EXCLUÍDO:          |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ID: " + verificaExcLiv.getId());
	                                    System.out.println("| TÍTULO: " + verificaExcLiv.getTitulo());
	                                    System.out.println("| AUTOR: " + verificaExcLiv.getAutor());
	                                    System.out.println("| ANO DE PUBLICAÇÃO: " + verificaExcLiv.getAnoPublicacao());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    var respEx = teclado.nextLine();

	                                    switch (respEx) {
	                                        case "S", "s":
	                                            livroDAO.exclusao(idExcluirLiv);
	                                            System.out.println("|--------------------------------------------------------|");
	                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
	                                            System.out.println("|--------------------------------------------------------|");
	                                            break;
	                                            
	                                        case "N", "n":
	                                            System.out.println("|--------------------------------------------------------|");
	                                            System.out.println("|       O CADASTRO NÃO SERÁ EXCLUÍDO - VOTE AO MENU      |");
	                                            System.out.println("|--------------------------------------------------------|");
	                                            break;
	                                            
	                                        default:
	                                            System.out.println("|--------------------------------------------------------|");
	                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
	                                            System.out.println("|--------------------------------------------------------|");
	                                    }

	                                }else{
	                                	 System.out.println("|--------------------------------------------------------|");
                                         System.out.println("|              ID INVÁLIDO, TENTE NOVAMENTE              |");
                                         System.out.println("|--------------------------------------------------------|");
	                                }
								break;

							case 5:
								   System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|                     LISTA DE LIVROS                    |");
	                                System.out.println("|--------------------------------------------------------|");

	                                for (Livro livroList : livroDAO.listar()) {
	                                    System.out.println("| ID: " + livroList.getId());
	                                    System.out.println("| TÍTULO: " + livroList.getTitulo());
	                                    System.out.println("| AUTOR: " + livroList.getAutor());
	                                    System.out.println("| ANO DE PUBLICAÇÃO: " + livroList.getAnoPublicacao());
	                                    System.out.println("|--------------------------------------------------------|");
	                                }

	                                break;
	                                
							 case 6:
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|                SAIR DO MENU DE LIVROS                  |");
	                                System.out.println("|--------------------------------------------------------|");
	                                break;

	                         default:
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
	                                System.out.println("|--------------------------------------------------------|");
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
	                 			  System.out.println("|--------------------------------------------------------|");
	                              System.out.println("|                   CADASTRO DE LEITOR                   |");
	                              System.out.println("|--------------------------------------------------------|");
	                              System.out.println("| DIGITE O NOME DO LEITOR:                               |");
	                              System.out.println("|--------------------------------------------------------|");
	                              leitor.setNome(teclado.nextLine());
	                              System.out.println("|--------------------------------------------------------|");
	                              System.out.println("| DIGITE A IDADE DO LEITOR:                              |");
	                              System.out.println("|--------------------------------------------------------|");
	                              leitor.setIdade(teclado.nextInt());
	                              teclado.nextLine();
	                              System.out.println("|--------------------------------------------------------|");
	                              System.out.println("| DIGITE O ENDERECO DO LEITOR:                           |");
	                              System.out.println("|--------------------------------------------------------|");
	                              leitor.setEndereco(teclado.nextLine());
	                              System.out.println("|--------------------------------------------------------|");
	                              System.out.println("| DIGITE O TELEFONE DO LEITOR:                           |");
	                              System.out.println("|--------------------------------------------------------|");
	                              leitor.setTelefone(teclado.nextLine());

	                              leitorDAO.insert(leitor);

	                              System.out.println("|--------------------------------------------------------|");
	                              System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
	                              System.out.println("|--------------------------------------------------------|");
								break;
								
							case 2:
								 	System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|            ALTERAÇÃO DE CADASTRO DE LEITOR             |");
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("| DIGITE O ID DO LEITOR QUE DESEJA ALTERAR:              |");
	                                System.out.println("|--------------------------------------------------------|");
	                                int idAlterarLeitor = teclado.nextInt();

	                                var leitor_busca = leitorDAO.buscar(idAlterarLeitor);

	                                if (leitor_busca == null) {
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                } else {
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| NOME:" + leitor_busca.getNome());
	                                    System.out.println("| IDADE: " + leitor_busca.getIdade());
	                                    System.out.println("| ENDEREÇO:" + leitor_busca.getEndereco());
	                                    System.out.println("| TELEFONE:" + leitor_busca.getTelefone());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| 1 - NOME                                               |");
	                                    System.out.println("| 2 - IDADE                                              |");
	                                    System.out.println("| 3 - ENDEREÇO                                           |");
	                                    System.out.println("| 4 - TELEFONE                                           |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    var opc = teclado.nextInt();

	                                    teclado.nextLine();

	                                    switch (opc) {
                                        case 1:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE NOME                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O NOME DO LEITOR:" + leitor_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO NOME DO LEITOR:                          |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String nomeAlterado = teclado.nextLine();
                                            leitor.setNome(nomeAlterado);

                                            int idadeleitor = leitor_busca.getIdade();
                                            leitor.setIdade(idadeleitor);

                                            String enderecoleitor = leitor_busca.getEndereco();
                                            leitor.setEndereco(enderecoleitor);

                                            String telefoneleitor = leitor_busca.getTelefone();
                                            leitor.setTelefone(telefoneleitor);

                                            leitor.setId(idAlterarLeitor);

                                            leitorDAO.alteracao(leitor, idAlterarLeitor);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                NOME ALTERADO COM SUCESSO               |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;
                                            
                                        case 2:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                    ALTERAÇÃO DE IDADE                   |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO A IDADE DO LEITOR:" + leitor_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE A NOVA IDADE DO LEITOR:                         |");
                                            System.out.println("|--------------------------------------------------------|");
                                            int idadeAlterada = teclado.nextInt();
                                            leitor.setIdade(idadeAlterada);

                                            String nomeleitor = leitor_busca.getNome();
                                            leitor.setNome(nomeleitor);

                                            String enderecoleitor2 = leitor_busca.getEndereco();
                                            leitor.setEndereco(enderecoleitor2);

                                            String telefoneleitor2 = leitor_busca.getTelefone();
                                            leitor.setTelefone(telefoneleitor2);

                                            leitor.setId(idAlterarLeitor);

                                            leitorDAO.alteracao(leitor, idAlterarLeitor);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                IDADE ALTERADO COM SUCESSO              |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;
                                            
                                        case 3:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                  ALTERAÇÃO DE ENDEREÇO                 |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O ENDEREÇO DO LEITOR:" + leitor_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO ENDEREÇO DO LEITOR:                      |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String enderecoAlterado = teclado.nextLine();
                                            leitor.setEndereco(enderecoAlterado);

                                            String nomeleitor2 = leitor_busca.getNome();
                                            leitor.setNome(nomeleitor2);

                                            int idadeleitor2 = leitor_busca.getIdade();
                                            leitor.setIdade(idadeleitor2);

                                            String telefoneleitor3 = leitor_busca.getTelefone();
                                            leitor.setTelefone(telefoneleitor3);

                                            leitor.setId(idAlterarLeitor);

                                            leitorDAO.alteracao(leitor, idAlterarLeitor);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|               ENDEREÇO ALTERADO COM SUCESSO            |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;
                                            
                                        case 4:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|                  ALTERAÇÃO DE TELEFONE                 |");
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| ALTERANDO O TELEFONE DO LEITOR:" + leitor_busca.getNome());
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("| DIGITE O NOVO TELEFONE DO LEITOR:                      |");
                                            System.out.println("|--------------------------------------------------------|");
                                            String telefoneAlterado = teclado.nextLine();
                                            leitor.setTelefone(telefoneAlterado);

                                            String nomeleitor3 = leitor_busca.getNome();
                                            leitor.setNome(nomeleitor3);

                                            int idadeleitor3 = leitor_busca.getIdade();
                                            leitor.setIdade(idadeleitor3);

                                            String enderecoleitor3 = leitor_busca.getEndereco();
                                            leitor.setEndereco(enderecoleitor3);

                                            leitor.setId(idAlterarLeitor);

                                            leitorDAO.alteracao(leitor, idAlterarLeitor);

                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|               TELEFONE ALTERADO COM SUCESSO            |");
                                            System.out.println("|--------------------------------------------------------|");
                                            break;
                                           
                                        default:
                                            System.out.println("|--------------------------------------------------------|");
                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                            System.out.println("|--------------------------------------------------------|");
	                                    }
	                                }
	                                break;
							case 3:
								System.out.println("|--------------------------------------------------------|");
                                System.out.println("|               BUSCAR CADASTRO DE LEITOR                |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE O ID DO LEITOR:                                 |");
                                System.out.println("|--------------------------------------------------------|");
                                int idBuscaLeitor = teclado.nextInt();
                                teclado.nextLine();

                                var ltr = leitorDAO.buscar(idBuscaLeitor);


                                if (ltr != null) {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ID: " + ltr.getId());
                                    System.out.println("| NOME: " + ltr.getNome());
                                    System.out.println("| IDADE: " + ltr.getIdade());
                                    System.out.println("| ENDEREÇO: " + ltr.getEndereco());
                                    System.out.println("| TELEFONE: " + ltr.getTelefone());
                                    System.out.println("|--------------------------------------------------------|");
                                } else {
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                    System.out.println("|--------------------------------------------------------|");
                                }
							break;

							case 4:
								    System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|            EXCLUSÃO DE CADASTRO DE LEITOR              |");
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("| DIGITE O ID DO LEITOR:                                 |");
	                                System.out.println("|--------------------------------------------------------|");
	                                var idExcluirLeitor = teclado.nextInt();
	                                leitor.setId(idExcluirLeitor);

	                                var verificaExcLeitor = leitorDAO.buscar(idExcluirLeitor);

	                                if (verificaExcLeitor != null) {
	                                    teclado.nextLine();
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|          CADASTRO DO LEITOR QUE SERÁ EXCLUÍDO:         |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ID: " + verificaExcLeitor.getId());
	                                    System.out.println("| NOME: " + verificaExcLeitor.getNome());
	                                    System.out.println("| IDADE: " + verificaExcLeitor.getIdade());
	                                    System.out.println("| ENDEREÇO: " + verificaExcLeitor.getEndereco());
	                                    System.out.println("| TELEFONE: " + verificaExcLeitor.getTelefone());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    var respExc = teclado.nextLine();

	                                    switch (respExc) {
	                                        case "S", "s":
	                                            leitorDAO.exclusao(idExcluirLeitor);
	                                            System.out.println("|--------------------------------------------------------|");
	                                            System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
	                                            System.out.println("|--------------------------------------------------------|");
	                                            break;
	                                            
	                                        case "N", "n":
	                                            System.out.println("|--------------------------------------------------------|");
	                                            System.out.println("|       O CADASTRO NÃO SERÁ EXCLUÍDO - VOTE AO MENU      |");
	                                            System.out.println("|--------------------------------------------------------|");
	                                            break;
	                                            
	                                        default:
	                                            System.out.println("|--------------------------------------------------------|");
	                                            System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
	                                            System.out.println("|--------------------------------------------------------|");
	                                    }
	                                    	
	                                }else{
	                                	 System.out.println("|--------------------------------------------------------|");
                                         System.out.println("|              ID INVÁLIDO, TENTE NOVAMENTE              |");
                                         System.out.println("|--------------------------------------------------------|");
	                                }
	                                
								break;
								
							case 5:
								   System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|                    LISTA DE LEITORES                   |");
	                                System.out.println("|--------------------------------------------------------|");

	                                for (Leitor leitorList : leitorDAO.listar()) {
	                                    System.out.println("| ID: " + leitorList.getId());
	                                    System.out.println("| NOME: " + leitorList.getNome());
	                                    System.out.println("| IDADE: " + leitorList.getIdade());
	                                    System.out.println("| ENDEREÇO: " + leitorList.getEndereco());
	                                    System.out.println("| TELEFONE: " + leitorList.getTelefone());
	                                    System.out.println("|--------------------------------------------------------|");
	                                }

	                                break;
	                                
							 case 6:
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|               SAIR DO MENU DE LEITORES                 |");
	                                System.out.println("|--------------------------------------------------------|");
	                                break;

	                         default:
	                                System.out.println("|--------------------------------------------------------|");
	                                System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
	                                System.out.println("|--------------------------------------------------------|");
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
                    		System.out.println("|--------------------------------------------------------|");
                    		System.out.println("|                 CADASTRO DE FUNCIONÁRIO                |");
                    		System.out.println("|--------------------------------------------------------|");
                    		System.out.println("| DIGITE O NOME DO FUNCIONÁRIO:                          |");
                    		System.out.println("|--------------------------------------------------------|");
                    		funcionario.setNome(teclado.nextLine());
                    		System.out.println("|--------------------------------------------------------|");
                    		System.out.println("| DIGITE O ENDEREÇO DO FUNCIONÁRIO:                      |");
                    		System.out.println("|--------------------------------------------------------|");
                    		funcionario.setEndereco(teclado.nextLine());
                    		System.out.println("|--------------------------------------------------------|");
                    		System.out.println("| DIGITE O TELEFONE DO FUNCIONÁRIO:                      |");
                        	System.out.println("|--------------------------------------------------------|");
                        	funcionario.setTelefone(teclado.nextLine());
                      
                        	funcionarioDAO.insert(funcionario);

                        	System.out.println("|--------------------------------------------------------|");
                        	System.out.println("|            CADASTRO CONCLUÍDO COM SUCESSO              |");
                        	System.out.println("|--------------------------------------------------------|");
                        
                        	break;
                        	
						case 2:
							System.out.println("|--------------------------------------------------------|");
                            System.out.println("|          ALTERAÇÃO DE CADASTRO DE FUNCIONÁRIO          |");
                            System.out.println("|--------------------------------------------------------|");
                            System.out.println("| DIGITE O ID DO FUNCIONÁRIO QUE DESEJA ALTERAR:         |");
                            System.out.println("|--------------------------------------------------------|");
                            int idAlterarFunc = teclado.nextInt();

                            var func_busca = funcionarioDAO.buscar(idAlterarFunc);

                            if (func_busca == null) {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ATENÇÃO: ESSE ID NÃO FOI ENCONTRADO                    |");
                                System.out.println("|--------------------------------------------------------|");
                            } else {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|       INFORMAÇÕES RELACIONADAS AO ID ESCOLHIDO         |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| NOME:" + func_busca.getNome());
                                System.out.println("| ENDEREÇO:" + func_busca.getEndereco());
                                System.out.println("| TELEFONE:" + func_busca.getTelefone());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| 1 - NOME                                               |");
                                System.out.println("| 2 - ENDEREÇO                                           |");
                                System.out.println("| 3 - TELEFONE                                           |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
                                System.out.println("|--------------------------------------------------------|");
                                var opc = teclado.nextInt();

                                teclado.nextLine();

                                switch (opc) {
                                case 1:
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|                    ALTERAÇÃO DE NOME                   |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ALTERANDO O NOME DO FUNCIONÁRIO:" + func_busca.getNome());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE O NOVO NOME DO FUNCIONÁRIO:                     |");
                                    System.out.println("|--------------------------------------------------------|");
                                    String nomeAlteradof = teclado.nextLine();
                                    funcionario.setNome(nomeAlteradof);

                                    String enderecofunc = func_busca.getEndereco();
                                    funcionario.setEndereco(enderecofunc);

                                    String telefonefunc = func_busca.getTelefone();
                                    funcionario.setTelefone(telefonefunc);

                                    funcionario.setId(idAlterarFunc);

                                    funcionarioDAO.alteracao(funcionario, idAlterarFunc);

                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|                NOME ALTERADO COM SUCESSO               |");
                                    System.out.println("|--------------------------------------------------------|");
                                    break;
                                    
                                case 2:
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|                  ALTERAÇÃO DE ENDEREÇO                 |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ALTERANDO O ENDEREÇO DO FUNCIONÁRIO:" + func_busca.getNome());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE O NOVO ENDEREÇO DO FUNCIONÁRIO:                 |");
                                    System.out.println("|--------------------------------------------------------|");
                                    String enderecoAlterado2 = teclado.nextLine();
                                    funcionario.setEndereco(enderecoAlterado2);

                                    String nomefunc = func_busca.getNome();
                                    funcionario.setNome(nomefunc);

                                    String telefonefunc2 = func_busca.getTelefone();
                                    funcionario.setTelefone(telefonefunc2);

                                    funcionario.setId(idAlterarFunc);

                                    funcionarioDAO.alteracao(funcionario, idAlterarFunc);

                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|               ENDEREÇO ALTERADO COM SUCESSO            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    break;
                                    
                                case 3:
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|                  ALTERAÇÃO DE TELEFONE                 |");
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| ALTERANDO O TELEFONE DO FUNCIONÁRIO:" + func_busca.getNome());
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("| DIGITE O NOVO TELEFONE DO FUNCIONÁRIO:                      |");
                                    System.out.println("|--------------------------------------------------------|");
                                    String telefoneAlterado = teclado.nextLine();
                                    funcionario.setTelefone(telefoneAlterado);

                                    String nomefunc2 = func_busca.getNome();
                                    funcionario.setNome(nomefunc2);

                                    String enderecofunc2 = func_busca.getEndereco();
                                    funcionario.setEndereco(enderecofunc2);

                                    funcionario.setId(idAlterarFunc);

                                    funcionarioDAO.alteracao(funcionario, idAlterarFunc);

                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|               TELEFONE ALTERADO COM SUCESSO            |");
                                    System.out.println("|--------------------------------------------------------|");
                                    break;
                                   
                                default:
                                    System.out.println("|--------------------------------------------------------|");
                                    System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                    System.out.println("|--------------------------------------------------------|");
                                }
                            }
                            break;
						
						case 3:
							System.out.println("|--------------------------------------------------------|");
                            System.out.println("|            BUSCAR CADASTRO DE FUNCIONÁRIO              |");
                            System.out.println("|--------------------------------------------------------|");
                            System.out.println("| DIGITE O ID DO FUNCIONÁRIO:                            |");
                            System.out.println("|--------------------------------------------------------|");
                            int idBuscaFuncionario = teclado.nextInt();
                            teclado.nextLine();

                            var func = funcionarioDAO.buscar(idBuscaFuncionario);


                            if (func != null) {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ID: " + func.getId());
                                System.out.println("| NOME: " + func.getNome());
                                System.out.println("| ENDEREÇO: " + func.getEndereco());
                                System.out.println("| TELEFONE: " + func.getTelefone());
                                System.out.println("|--------------------------------------------------------|");
                            } else {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                System.out.println("|--------------------------------------------------------|");
                            }
							break;
						case 4:
						    System.out.println("|--------------------------------------------------------|");
                            System.out.println("|          EXCLUSÃO DE CADASTRO DE FUNCIONÁRIO           |");
                            System.out.println("|--------------------------------------------------------|");
                            System.out.println("| DIGITE O ID DO FUNCIONÁRIO:                            |");
                            System.out.println("|--------------------------------------------------------|");
                            var idExcluirFuncionario = teclado.nextInt();
                            funcionario.setId(idExcluirFuncionario);

                            var verificaExcFunc = funcionarioDAO.buscar(idExcluirFuncionario);

                            if (verificaExcFunc != null) {
                                teclado.nextLine();
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|        CADASTRO DO FUNCIONÁRIO QUE SERÁ EXCLUÍDO:      |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ID: " + verificaExcFunc.getId());
                                System.out.println("| NOME: " + verificaExcFunc.getNome());
                                System.out.println("| ENDEREÇO: " + verificaExcFunc.getEndereco());
                                System.out.println("| TELEFONE: " + verificaExcFunc.getTelefone());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
                                System.out.println("|--------------------------------------------------------|");
                                var respExc = teclado.nextLine();

                                switch (respExc) {
                                    case "S", "s":
                                        leitorDAO.exclusao(idExcluirFuncionario);
                                        System.out.println("|--------------------------------------------------------|");
                                        System.out.println("|             CADASTRO EXCLUÍDO COM SUCESSO              |");
                                        System.out.println("|--------------------------------------------------------|");
                                        break;
                                        
                                    case "N", "n":
                                        System.out.println("|--------------------------------------------------------|");
                                        System.out.println("|       O CADASTRO NÃO SERÁ EXCLUÍDO - VOTE AO MENU      |");
                                        System.out.println("|--------------------------------------------------------|");
                                        break;
                                        
                                    default:
                                        System.out.println("|--------------------------------------------------------|");
                                        System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                        System.out.println("|--------------------------------------------------------|");
                                }
                                
                            }else{
                               	 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("|              ID INVÁLIDO, TENTE NOVAMENTE              |");
                                 System.out.println("|--------------------------------------------------------|");
                            }
							break;
							
						case 5:
							 System.out.println("|--------------------------------------------------------|");
                             System.out.println("|                  LISTA DE FUNCIONÁRIOS                 |");
                             System.out.println("|--------------------------------------------------------|");

                             for (Funcionario funcList : funcionarioDAO.listar()) {
                                 System.out.println("| ID: " + funcList.getId());
                                 System.out.println("| NOME: " + funcList.getNome());
                                 System.out.println("| ENDEREÇO: " + funcList.getEndereco());
                                 System.out.println("| TELEFONE: " + funcList.getTelefone());
                                 System.out.println("|--------------------------------------------------------|");
                             }

                             break;
						 case 6:
                             System.out.println("|--------------------------------------------------------|");
                             System.out.println("|              SAIR DO MENU DE FUNCIONÁRIOS              |");
                             System.out.println("|--------------------------------------------------------|");
                             break;

                      default:
                             System.out.println("|--------------------------------------------------------|");
                             System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                             System.out.println("|--------------------------------------------------------|");
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
	                    	 System.out.println("|--------------------------------------------------------|");
	                         System.out.println("|                CADASTRO DE EMPRÉSTIMOS                 |");
	                         System.out.println("|--------------------------------------------------------|");
	                         System.out.println("| DIGITE O ID DO LEITOR QUE IRÁ ALOCAR O LIVRO:          |");
	                         System.out.println("|--------------------------------------------------------|");
	                         emprestimo.setLeitor(teclado.nextInt());
	                         System.out.println("|--------------------------------------------------------|");
	                         System.out.println("| DIGITE O ID DO LIVRO QUE IRÁ SER ALOCADO:              |");
	                         System.out.println("|--------------------------------------------------------|");
	                         emprestimo.setLivro(teclado.nextInt());
	                         System.out.println("|--------------------------------------------------------|");
	                         System.out.println("| DIGITE O ID DO FUNCIONÁRIO QUE ESTÁ RESPONSÁVEL        |"
	                         		        + "\n| PELO EMPRÉSTIMO:                                       |");
	                         System.out.println("|--------------------------------------------------------|");
	                         emprestimo.setFuncionario(teclado.nextInt());
	                         teclado.nextLine();
	                         System.out.println("|--------------------------------------------------------|");
	                         System.out.println("| DIGITE A DATA DO EMPRÉSTIMO DO LIVRO                   |");
	                         System.out.println("|--------------------------------------------------------|");
	                         emprestimo.setDataEmprestimo(teclado.nextLine());
	                         System.out.println("|--------------------------------------------------------|");
	                         System.out.println("| DIGITE A DATA DE DEVOLUÇÃO DO LIVRO:                   |");
	                         System.out.println("|--------------------------------------------------------|");
	                         emprestimo.setDataDevolucao(teclado.nextLine());
	
	                         emprestimoDAO.insert(emprestimo);
	
	                         System.out.println("|--------------------------------------------------------|");
	                         System.out.println("|           EMPRÉSTIMO CONCLUÍDO COM SUCESSO             |");
	                         System.out.println("|--------------------------------------------------------|");
	                         
	                         break;
                        
						case 2:
							System.out.println("|--------------------------------------------------------|");
                            System.out.println("|            ALTERAÇÃO DE EMPRÉSTIMO DO LIVRO            |");
                            System.out.println("|--------------------------------------------------------|");
                            System.out.println("| DIGITE O CÓDIGO DO EMPRÉSTIMO QUE DESEJA ALTERAR:      |");
                            System.out.println("|--------------------------------------------------------|");
                            int idAlterarEmp = teclado.nextInt();

                            var emp_busca = emprestimoDAO.buscar(idAlterarEmp);

                            if (emp_busca == null) {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ATENÇÃO: ESSE CÓDIGO NÃO FOI ENCONTRADO                |");
                                System.out.println("|--------------------------------------------------------|");
                            } else {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|    INFORMAÇÕES RELACIONADAS AO EMPRÉSTIMO ESCOLHIDO    |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ID DO LEITOR: " + emp_busca.getLeitor());
                                System.out.println("| ID DO LIVRO: " + emp_busca.getLivro());
                                System.out.println("| FUNCIONÁRIO: " + emp_busca.getFuncionario());
                                System.out.println("| DATA DO EMPRÉSTIMO: " + emp_busca.getDataEmprestimo());
                                System.out.println("| DATA DE DEVOLUÇÃO: " + emp_busca.getDataDevolucao());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| O QUE PRECISA SER ALTERADO?                            |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| 1 - LEITOR                                             |");
                                System.out.println("| 2 - LIVRO                                              |");
                                System.out.println("| 3 - FUNCIONÁRIO                                        |");
                                System.out.println("| 4 - DATA DO EMPRÉSTIMO                                 |");
                                System.out.println("| 4 - DATA DE DEVOLUÇÃO                                  |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| DIGITE A OPÇÃO DESEJADA:                               |");
                                System.out.println("|--------------------------------------------------------|");
                                var opc = teclado.nextInt();

                                teclado.nextLine();

                                switch (opc) {
	                                case 1:
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|                   ALTERAÇÃO DE LEITOR                  |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ALTERANDO O ID DO LEITOR:" + emp_busca.getLeitor());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE O ID DO LEITOR:                                 |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    int idAlterado = teclado.nextInt();
	                                    emprestimo.setLeitor(idAlterado);
	
	                                    int livro = emp_busca.getLivro();
	                                    emprestimo.setLivro(livro);
	                                    
	                                    int func = emp_busca.getFuncionario();
	                                    emprestimo.setFuncionario(func);
	
	                                    String dataemp = emp_busca.getDataEmprestimo();
	                                    emprestimo.setDataEmprestimo(dataemp);
	
	                                    String datadev = emp_busca.getDataDevolucao();
	                                    emprestimo.setDataDevolucao(datadev);
	                                    
	                                    emprestimo.setId(idAlterarEmp);
	
	                                    emprestimoDAO.alteracao(emprestimo, idAlterarEmp);
	
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|               LEITOR ALTERADO COM SUCESSO              |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    break;
	                                    
	                                case 2:
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|                   ALTERAÇÃO DE LIVRO                   |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ALTERANDO O ID DO LIVRO:" + emp_busca.getLivro());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE O ID DO LIVRO:                                  |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    int idAlterado2 = teclado.nextInt();
	                                    emprestimo.setLivro(idAlterado2);
	
	                                    int leitor = emp_busca.getLeitor();
	                                    emprestimo.setLeitor(leitor);
	                                    
	                                    int func2 = emp_busca.getFuncionario();
	                                    emprestimo.setFuncionario(func2);
	
	                                    String dataemp2 = emp_busca.getDataEmprestimo();
	                                    emprestimo.setDataEmprestimo(dataemp2);
	
	                                    String datadev2 = emp_busca.getDataDevolucao();
	                                    emprestimo.setDataDevolucao(datadev2);
	                                    
	                                    emprestimo.setId(idAlterarEmp);
	
	                                    emprestimoDAO.alteracao(emprestimo, idAlterarEmp);
	
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|                LIVRO ALTERADO COM SUCESSO              |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    break;
	                                    
	                                case 3:
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|                ALTERAÇÃO DE FUNCIONÁRIO                |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ALTERANDO O ID DO FUNCIONÁRIO: " + emp_busca.getLivro());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE O ID DO FUNCIONÁRIO:                            |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    int idAlterado3 = teclado.nextInt();
	                                    emprestimo.setFuncionario(idAlterado3);
	
	                                    int leitor2 = emp_busca.getLeitor();
	                                    emprestimo.setLeitor(leitor2);
	                                  
	                                    int livro2 = emp_busca.getLivro();
	                                    emprestimo.setLivro(livro2);
	
	                                    String dataemp3 = emp_busca.getDataEmprestimo();
	                                    emprestimo.setDataEmprestimo(dataemp3);
	
	                                    String datadev3 = emp_busca.getDataDevolucao();
	                                    emprestimo.setDataDevolucao(datadev3);
	                                    
	                                    emprestimo.setId(idAlterarEmp);
	
	                                    emprestimoDAO.alteracao(emprestimo, idAlterarEmp);
	
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|             FUNCIONÁRIO ALTERADO COM SUCESSO           |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    break;
	                                    
	                                case 4:
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|             ALTERAÇÃO DE DATA DE EMPRÉSTIMO            |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ALTERANDO A DATA DE EMPRÉSTIMO: " + emp_busca.getLivro());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE A DATA DE EMPRÉSTIMO:                           |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    String dataempAlt = teclado.nextLine();
	                                    emprestimo.setDataEmprestimo(dataempAlt);

	                                    int leitor3 = emp_busca.getLeitor();
	                                    emprestimo.setLeitor(leitor3);
	                                  
	                                    int livro3 = emp_busca.getLivro();
	                                    emprestimo.setLivro(livro3);
	                                    
	                                    int func3 = emp_busca.getFuncionario();
	                                    emprestimo.setFuncionario(func3);
	
	                                    String datadev4 = emp_busca.getDataDevolucao();
	                                    emprestimo.setDataDevolucao(datadev4);
	                                    
	                                    emprestimo.setId(idAlterarEmp);
	
	                                    emprestimoDAO.alteracao(emprestimo, idAlterarEmp);
	
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|         DATA DE EMPRÉSTIMO ALTERADA COM SUCESSO        |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    break;
	                                    
	                                case 5:
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|             ALTERAÇÃO DE DATA DE DEVOLUÇÃO             |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| ALTERANDO A DATA DE DEVOLUÇÃO: " + emp_busca.getLivro());
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("| DIGITE A DATA DE DEVOLUÇÃO:                            |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    String datadevAlt = teclado.nextLine();
	                                    emprestimo.setDataDevolucao(datadevAlt);

	                                    int leitor4 = emp_busca.getLeitor();
	                                    emprestimo.setLeitor(leitor4);
	                                  
	                                    int livro4 = emp_busca.getLivro();
	                                    emprestimo.setLivro(livro4);
	                                    
	                                    int func4 = emp_busca.getFuncionario();
	                                    emprestimo.setFuncionario(func4);
	                                    
	                                    String dataemp4 = emp_busca.getDataEmprestimo();
	                                    emprestimo.setDataEmprestimo(dataemp4);
	                                    
	                                    emprestimo.setId(idAlterarEmp);
	
	                                    emprestimoDAO.alteracao(emprestimo, idAlterarEmp);
	
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|          DATA DE DEVOLUÇÃO ALTERADA COM SUCESSO        |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                    break;
	                                    
	                                default:
	                                    System.out.println("|--------------------------------------------------------|");
	                                    System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
	                                    System.out.println("|--------------------------------------------------------|");
	                                }
	                            }
							break;
							
						case 3:
							
							System.out.println("|--------------------------------------------------------|");
                            System.out.println("|              BUSCAR EMPRÉSTIMO DE LIVRO                |");
                            System.out.println("|--------------------------------------------------------|");
                            System.out.println("| DIGITE O ID DO EMPRÉSTIMO:                             |");
                            System.out.println("|--------------------------------------------------------|");
                            int idBuscaEmp = teclado.nextInt();
                            teclado.nextLine();

                            var emp = emprestimoDAO.buscar(idBuscaEmp);


                            if (emp != null) {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ID DO EMPRÉSTIMO: " + emp.getId());
                                System.out.println("| ID DO LIVRO: " + emp.getLivro());
                                System.out.println("| ID DO LEITOR: " + emp.getLeitor());
                                System.out.println("| ID DO FUNCIONÁRIO QUE CADASTROU: " + emp.getFuncionario());
                                System.out.println("| DATA DO EMPRÉSTIMO: " + emp.getDataEmprestimo());
                                System.out.println("| DATA DA DEVOLUÇÃO: " + emp.getDataDevolucao());
                                System.out.println("|--------------------------------------------------------|");
                            } else {
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ATENÇÃO: ESSE ID NÃO ENCONTRADO                        |");
                                System.out.println("|--------------------------------------------------------|");
                            }
							break;
						case 4:
						    System.out.println("|--------------------------------------------------------|");
                            System.out.println("|                 EXCLUSÃO DE EMPRÉSTIMO                 |");
                            System.out.println("|--------------------------------------------------------|");
                            System.out.println("| DIGITE O ID DO EMPRÉSTIMO:                            |");
                            System.out.println("|--------------------------------------------------------|");
                            var idExcluirEmp = teclado.nextInt();
                            emprestimo.setId(idExcluirEmp);

                            var verificaExcEmp = emprestimoDAO.buscar(idExcluirEmp);

                            if (verificaExcEmp != null) {
                                teclado.nextLine();
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("|               EMPRÉSTIMO QUE SERÁ EXCLUÍDO:            |");
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ID DO EMPRÉSTIMO: " + verificaExcEmp.getId());
                                System.out.println("| ID DO LIVRO: " + verificaExcEmp.getLivro());
                                System.out.println("| ID DO LEITOR: " + verificaExcEmp.getLeitor());
                                System.out.println("| ID DO FUNCIONÁRIO QUE CADASTROU: " + verificaExcEmp.getFuncionario());
                                System.out.println("| DATA DO EMPRÉSTIMO: " + verificaExcEmp.getDataEmprestimo());
                                System.out.println("| DATA DA DEVOLUÇÃO: " + verificaExcEmp.getDataDevolucao());
                                System.out.println("|--------------------------------------------------------|");
                                System.out.println("| ATENÇÃO: DESEJA EXCLUIR ESSE CADASTRO? DIGITE: S ou N  |");
                                System.out.println("|--------------------------------------------------------|");
                                var respExc = teclado.nextLine();

                                switch (respExc) {
                                    case "S", "s":
                                        leitorDAO.exclusao(idExcluirEmp);
                                        System.out.println("|--------------------------------------------------------|");
                                        System.out.println("|            EMPRÉSTIMO EXCLUÍDO COM SUCESSO             |");
                                        System.out.println("|--------------------------------------------------------|");
                                        break;
                                        
                                    case "N", "n":
                                        System.out.println("|--------------------------------------------------------|");
                                        System.out.println("|       O CADASTRO NÃO SERÁ EXCLUÍDO - VOTE AO MENU      |");
                                        System.out.println("|--------------------------------------------------------|");
                                        break;
                                        
                                    default:
                                        System.out.println("|--------------------------------------------------------|");
                                        System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                                        System.out.println("|--------------------------------------------------------|");
                                }
                                
                            }else{
                               	 System.out.println("|--------------------------------------------------------|");
                                 System.out.println("|              ID INVÁLIDO, TENTE NOVAMENTE              |");
                                 System.out.println("|--------------------------------------------------------|");
                            }
							break;
							
						case 5:
							 System.out.println("|--------------------------------------------------------|");
                             System.out.println("|                  LISTA DE EMPRÉSTIMOS                  |");
                             System.out.println("|--------------------------------------------------------|");

                             for (Emprestimo empList : emprestimoDAO.listar()) {
                            	  System.out.println("| ID DO EMPRÉSTIMO: " + empList.getId());
                                  System.out.println("| ID DO LIVRO: " + empList.getLivro());
                                  System.out.println("| ID DO LEITOR: " + empList.getLeitor());
                                  System.out.println("| ID DO FUNCIONÁRIO QUE CADASTROU: " + empList.getFuncionario());
                                  System.out.println("| DATA DO EMPRÉSTIMO: " + empList.getDataEmprestimo());
                                  System.out.println("| DATA DA DEVOLUÇÃO: " + empList.getDataDevolucao());
                                 System.out.println("|--------------------------------------------------------|");
                             }

                             break;
						 case 6:
                             System.out.println("|--------------------------------------------------------|");
                             System.out.println("|              SAIR DO MENU DE EMPRÉSTIMOS               |");
                             System.out.println("|--------------------------------------------------------|");
                             break;

                      default:
                             System.out.println("|--------------------------------------------------------|");
                             System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
                             System.out.println("|--------------------------------------------------------|");
                    }
			    
			    
		    } while (digitoEmprestimo != 6);
			  
               break;
               
           case 6:
               System.out.println("|--------------------------------------------------------|");
               System.out.println("|                   SAINDO DO SISTEMA                    |");
               System.out.println("|--------------------------------------------------------|");
               break;

           default:
               System.out.println("|--------------------------------------------------------|");
               System.out.println("|             OPÇÃO INVÁLIDA, TENTE NOVAMENTE            |");
               System.out.println("|--------------------------------------------------------|");
            
            }
        
        }while(digito != 5);
       
	}
}