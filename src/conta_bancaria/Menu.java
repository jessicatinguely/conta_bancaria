package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

<<<<<<< Updated upstream
import conta_bancaria.model.Conta;
=======
import conta_bancaria.controller.ContaController;
>>>>>>> Stashed changes
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		int opcao;

<<<<<<< Updated upstream
		// Instanciar Objetos da Classe Conta

		Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 500000.00f);

		Conta c2 = new Conta(2, 123, 2, "Priscila Lins", 500000.00f);

		Conta c3 = new Conta();

		System.out.println("O Saldo da conta é: " + c1.getSaldo());

		c1.setSaldo(60_0000.00f);

		System.out.println("O Saldo da conta é: " + c1.getSaldo());

		// Visualização dos dados das contas
		c1.visualizar();

		c2.visualizar();

		// Operações básicas (saque/deposito) na Conta
		System.out.println(c1.sacar(1_000));
		System.out.println("O Saldo da conta é: " + c1.getSaldo());

		System.out.println(c2.sacar(1_000_000));
		System.out.println("O Saldo da conta é: " + c2.getSaldo());

		c1.depositar(5000);
		System.out.println("O Saldo da conta é: " + c1.getSaldo());

		// Demonstração: ContaCorrente com limite + operações sobrescritas
		ContaCorrente cc1 = new ContaCorrente(3, 456, 1, "Thuany Silva", 1_000_000.00f, 100_000.00f);

		// Saques e depósitos na ContaCorrente (considera limite)
		cc1.visualizar();

		System.out.println(cc1.sacar(2_000_000.00f));
		cc1.visualizar();

		System.out.println(cc1.sacar(2_000.00f));
		cc1.visualizar();

		
		cc1.depositar(5_000.00f);
		cc1.visualizar();

		// Demonstração: Conta Poupança 
		ContaPoupanca cp1 = new ContaPoupanca(4, 456, 1, "Rafael Cortez", 2_000_000.00f, 24);

		// Saques e depósitos na Conta Poupança
		cp1.visualizar();

		System.out.println(cp1.sacar(200_000.00f));
		cp1.visualizar();

		System.out.println(cp1.sacar(20_000.00f));
		cp1.visualizar();

		cp1.depositar(5_000.00f);
		cp1.visualizar();

		// Laço principal do menu até "Sair"
=======
		criarContasTeste();
		
>>>>>>> Stashed changes
		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "╔══════════════════════ BRBANK  ════════════════════╗" + Cores.TEXT_RESET);
			
			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "                                                     " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [1] Criar Conta                                    " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [2] Listar todas as Contas                         " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [3] Buscar Conta por Número                        " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [4] Atualizar Dados da Conta                       " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [5] Apagar Conta                                   " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [6] Sacar                                          " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [7] Depositar                                      " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [8] Transferir valores entre Contas                " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "  [0] Sair                                           " + Cores.TEXT_YELLOW_BOLD);
			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "                                                     " + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "╚═══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);

			// Entrada do usuário
			System.out.print(Cores.TEXT_YELLOW_BRIGHT + "\nEntre com a opção desejada: " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				leia.nextLine();
			}
			// Condição de parada do loop (encerra aplicação)

			if (opcao == 0) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\nGoodBank - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			// Controle de fluxo do menu
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				// TODO: Implementar cadastro de conta
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				// TODO: Implementar busca por número
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				// TODO: Implementar atualização
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				// TODO: Implementar remoção
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				// TODO: Implementar operação de saque via menu
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				// TODO: Implementar operação de depósito via menu
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				// TODO: Implementar transferência entre contas
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	// Método utilitário: sobre()
	// Exibe informações do projeto/desenvolvedor
	public static void sobre() {
		System.out.println(
				Cores.TEXT_YELLOW_BOLD + "\n══════════════════════════════════════════════════════" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_YELLOW_BOLD + "Projeto Desenvolvido por: Jessica Tinguely " + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_YELLOW_BOLD + "jessicatinguely@icloud.com" + Cores.TEXT_RESET);
		System.out.println(
				Cores.TEXT_YELLOW_BOLD + "https://github.com/jessicatinguely/conta_bancaria" + Cores.TEXT_RESET);
		System.out.println(
				Cores.TEXT_YELLOW_BOLD + "══════════════════════════════════════════════════════" + Cores.TEXT_RESET);
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
		
	}

	private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(1, 456, 1, "Thuany Silva", 1_000_000.00f, 100_000.00f));
		contaController.cadastrar(new ContaPoupanca(2, 456, 1, "Marcia Condarco", 1_000_000.00f, 10));
	}
	
	private static void listarContas() {
		contaController.listarToda();
	}
}