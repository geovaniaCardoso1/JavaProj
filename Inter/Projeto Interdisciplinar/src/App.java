import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Livro[] livro = new Livro[500];
        Random codigoLivro = new Random();
        Scanner entrada = new Scanner(System.in);

        char resp;
        boolean rodar = true;

        while (rodar == true) {
            System.out.println(
                    "\n===============[LIVRARIA BOA LEITURA - MENU PRINCIPAL]===============\n| >> ESCOLHA UMA OPÇÃO\n=====================================================================");
            System.out.println(
                    "| 1. Cadastro de Livro\n| 2. Editar Informações de um Livro\n| 3. Consultar Inventário\n| 4. Remover item do Inventário\n| 0. Fechar Sistema");
            System.out.print(
                    "=====================================================================\n| >> Opção escolhida: ");

            int menuPrincipal = entrada.nextInt();
            entrada.nextLine();
            System.out.println();

            switch (menuPrincipal) { // Switch Case que comporta o sistema do menu principal da aplicação;
                case 1: // Opção Nº1, Casdastro de Livro; Variável "resp" utilizada para controle da
                        // repetição; loop "for" utilizado para percorrer o vetor;
                    for (int i = 0; i < livro.length; i++) {
                        if (livro[i] == null) { // Checagem do index para adicionar um livro novo no próximo index
                                                // livre;
                            System.out.println(
                                    "\n===============[LIVRARIA BOA LEITURA - MENU DE CADASTRO]===============\n| >> DADOS DO LIVRO A SER CADASTRADO\n=======================================================================");

                            System.out.print("| >> Nome do Livro: ");
                            String nomeLivro = entrada.nextLine();

                            System.out.print("| >> Nome do Autor: ");
                            String autorLivro = entrada.nextLine();

                            System.out.print("| >> Editora: ");
                            String editoraLivro = entrada.nextLine();

                            System.out.print("| >> Genêro: ");
                            String generoLivro = entrada.nextLine();

                            System.out.print("| >> Preço: R$");
                            double precoLivro = entrada.nextDouble();
                            int novoCodigo = codigoLivro.nextInt(89999) + 10000; // Gerador aleatório de um número entre
                                                                                 // 10000 e 99999 para servir como o
                                                                                 // código de registro do livro criado;

                            livro[i] = new Livro(nomeLivro, autorLivro, editoraLivro, generoLivro, precoLivro,
                                    novoCodigo); // Construtor do objeto do livro;

                            System.out.print(
                                    "=======================================================================\n| >> Deseja cadastrar outro livro (S/N)?: ");
                            resp = entrada.next().charAt(0); // Controlador de resposta para saída ou repetição do
                                                             // código acima;
                            if (resp == 'n' || resp == 'N') {
                                System.out.println();
                                break;
                            } else if (resp == 's' || resp == 'S') {
                                entrada.nextLine();
                                System.out.println();
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                    break;
                case 2: // Opção Nº2, Edição de Livro; loop "do while" utilizado para manter a edição em
                        // repetição caso o usuário deseje realizar inúmeras edições sequenciais;
                    do {
                        invLivraria(livro);
                        System.out.print("| >> Insira o código do livro a ser editado: ");
                        int codigoEdit = entrada.nextInt();
                        for (Livro livros : livro) { // Repetição "for each" para leitura do vetor que contém os livros
                                                     // armazenados;
                            if (livros != null) {
                                if (codigoEdit == livros.getCodigo()) { // Condição para conferir a validez do código
                                                                        // inserido;
                                    System.out.println(
                                            "\n===============[LIVRARIA BOA LEITURA - MENU DE EDIÇÃO]===============\n>>ESCOLHA UMA OPÇÃO\n=====================================================================");
                                    System.out.println("| 1. Nome\n| 2. Autor\n| 3. Editora\n| 4. Gênero\n| 5. Preço");
                                    System.out.print(
                                            "=====================================================================\n| >> Opção selecionada: ");
                                    int menuEditar = entrada.nextInt();

                                    switch (menuEditar) { // Switch Case que comporta o sistema do menu de edição;
                                        case 1: // Opção Nº1, Edição de Nome;
                                            System.out.print("| >> Novo Nome: ");
                                            entrada.nextLine();
                                            String nomeEditado = entrada.nextLine();
                                            for (Livro nomeEdicao : livro) {
                                                if (nomeEdicao != null) {
                                                    if (nomeEdicao.getCodigo() == codigoEdit) {
                                                        nomeEdicao.setNome(nomeEditado);
                                                        System.out.println();
                                                        System.out.printf(
                                                                "| >> Nome do livro #%d editado para %s com sucesso.\n",
                                                                livros.getCodigo(), nomeEdicao.getNome());
                                                    }
                                                }
                                            }
                                            break;
                                        case 2: // Opção N°2, Edição de Autor;
                                            System.out.print("| >> Novo Autor: ");
                                            entrada.nextLine();
                                            String autorEditado = entrada.nextLine();
                                            for (Livro edicaoAutor : livro) {
                                                if (edicaoAutor != null) {
                                                    if (edicaoAutor.getCodigo() == codigoEdit) {
                                                        edicaoAutor.setAutor(autorEditado);
                                                        System.out.println();
                                                        System.out.printf(
                                                                "| >> Autor do livro #%d editado para %s com sucesso.\n",
                                                                livros.getCodigo(), edicaoAutor.getAutor());
                                                    }
                                                }
                                            }
                                            break;

                                        case 3: // Opção N°3, Edição de Editora;
                                            System.out.print(">> Nova Editora: ");
                                            entrada.nextLine();
                                            String editoraEditado = entrada.nextLine();
                                            for (Livro edicaoEditora : livro) {
                                                if (edicaoEditora != null) {
                                                    if (edicaoEditora.getCodigo() == codigoEdit) {
                                                        edicaoEditora.setEditora(editoraEditado);
                                                        System.out.println();
                                                        System.out.printf(
                                                                ">> Editora do livro #%d editado para %s com sucesso.\n",
                                                                livros.getCodigo(), edicaoEditora.getEditora());
                                                    }
                                                }
                                            }
                                            break;

                                        case 4: // Opção N°4, Edição de Gênero;
                                            System.out.print("| >> Novo Gênero: ");
                                            entrada.nextLine();
                                            String generoEditado = entrada.nextLine();
                                            for (Livro edicaoGenero : livro) {
                                                if (edicaoGenero != null) {
                                                    if (edicaoGenero.getCodigo() == codigoEdit) {
                                                        edicaoGenero.setGenero(generoEditado);
                                                        System.out.println();
                                                        System.out.printf(
                                                                "| >> Gênero do livro #%d editado para %s com sucesso.\n",
                                                                livros.getCodigo(), edicaoGenero.getGenero());
                                                    }
                                                }
                                            }
                                            break;

                                        case 5: // Opção N°2, Edição de Preço;
                                            System.out.print("| >> Novo Preço: R$");
                                            entrada.nextLine();
                                            double precoEditado = entrada.nextDouble();
                                            for (Livro edicaoPreco : livro) {
                                                if (edicaoPreco != null) {
                                                    if (edicaoPreco.getCodigo() == codigoEdit) {
                                                        edicaoPreco.setPreco(precoEditado);
                                                        System.out.println();
                                                        System.out.printf(
                                                                "| >> Preço do livro #%d editado para R$%.2f com sucesso.\n",
                                                                livros.getCodigo(), edicaoPreco.getPreco());
                                                    }
                                                }
                                            }
                                            break;
                                    } // Fim do Swich Case para o Menu de Edição;
                                }
                            }
                        }
                        System.out.print("| >> Deseja editar outro livro? (S/N): ");
                        resp = entrada.next().charAt(0);
                    } while (resp != 'n' && resp != 'N');
                    break;
                case 3: // Opção Nº3, Consulta de Inventário; Faz uso do método "invLivraria()" para
                        // puxar o inventário em seu estado mais recente;
                    do {
                        invLivraria(livro);
                        System.out.print("| >> Insira qualquer caractere para retornar ao menu: ");
                        resp = entrada.next().charAt(0);
                        System.out.println();
                    } while (resp == ' '); // Laço de repetição "do while" inserido para que o programa não retorne
                                           // diretamente para o menu para fins de visualização mais limpa;
                    break;

                case 4: // Opção Nº4, Remoção de Livro; Método "invLivraria()" para mostrar o
                        // inventário; Laço "do while" para manter o usuário removendo livros até que
                        // tenha removido todos os desejados;
                    invLivraria(livro);
                    do {
                        System.out.print("| >> Insira o código do livro que deseja remover: ");
                        int codigoRemove = entrada.nextInt();
                        for (int i = 0; i < livro.length; i++) { // Por conta do vetor ser fixo e imutável, o index
                                                                 // deletado adota um valor nulo e é omitido da
                                                                 // impressão seguinte graças ao método invLivraria();
                            if (livro[i] != null) {
                                if (livro[i].getCodigo() == codigoRemove) {
                                    livro[i] = null;
                                }
                            }
                        }
                        System.out.println("\n| >> Inventário atualizado. Livro removido com sucesso.\n");
                        invLivraria(livro);
                        System.out.print("| >> Deseja remover outro livro? (S/N): ");
                        resp = entrada.next().charAt(0);
                    } while (resp != 'n' && resp != 'N');

                    break;
                case 0: // Opção Nº5 (do menu), Fechamento do Sistema; Altera o valor booleado na
                        // variável "rodar" para falso, encerrando o sistema de gerenciamento;
                    System.out.println("| >> Desligando o sistema.");
                    rodar = false;
                    break;
            }
        }
        entrada.close();
    }

    public static void invLivraria(Livro[] livro) { // Método criado para enxutar o código em vários momentos no qual o
                                                    // conteúdo se repetia; Realiza a impressão do inventário formatado;
        System.out.println("==============[LIVRARIA BOA LEITURA - INVENTÁRIO GERAL]==============");
        for (Livro livros : livro) {
            if (livros != null) {
                System.out.printf(
                        "| >> Código: #%d | Nome: %s | Autor: %s | Editora: %s | Gênero: %s | Preço: R$%.2f\n",
                        livros.getCodigo(), livros.getNome(), livros.getAutor(), livros.getEditora(),
                        livros.getGenero(), livros.getPreco());
            }
        }
        System.out.println("=====================================================================");
    }
}

// UNIVERSIDADE CRUZEIRO DO SUL, ANÁLISE E DESENVOLVIMENTO DE SISTEMAS - PROJETO
// INTERDISCIPLINAR 2022/2;
// PROGRAMAÇÃO ORIENTADA A OBJETOS E TÉCNICAS E DESENVOLVIMENTO DE ALGORITMOS;
//
//
//
// PARTICIPANTES DO GRUPO;
// Código desenvolvido por Victor e William;
// Documentação escrita pro Waldenio Matheus;
// Pseudocódigo elaborado por Thiago e Geovânia;