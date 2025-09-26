package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		int opcao;

		criarContasTeste();

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
				cadastrarConta();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				procurarContaPorNumero();
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				atualizarConta();
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				deletarConta();
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
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1_000_000.00f, 100_000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1_000_000.00f, 10));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Sofia Gomes", 1_000_000.00f, 100_000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Cintia Dourado", 1_000_000.00f, 10));
	}

	private static void listarContas() {
		contaController.listarToda();
	}

	private static void cadastrarConta() {
		System.out.println("Digite o numero da Agencia: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("Digite o Tipo da conta (1 - CC ou 2- CP): ");
		int tipo = leia.nextInt();

		System.out.println("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversario da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta invalida!" + Cores.TEXT_RESET);
		}

	}

	private static void procurarContaPorNumero() {

		System.out.println("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);
	}

	private static void deletarConta() {

		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {

			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				contaController.deletar(numero);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}

	private static void atualizarConta() {
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {
			
			int agencia = conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			System.out.printf("A Agencia atual: %d%nNova Agencia (Pressione ENTER para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);

			System.out.printf("O nome do Titular atual: %s%n Novo Titular:(Pressione ENTER para manter o valor atual): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;

			System.out.printf("O Saldo atual: %.2f%n Novo Saldo (Pressione ENTER para manter o valor atual): ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);

			switch (tipo) {
			case 1 -> {
				float limite = ((ContaCorrente) conta).getLimite();
				
				System.out.println("Digite o limite inicial (Pressione ENTER para manter o valor atual): ");
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				
				ContaCorrente atualizada = new ContaCorrente(numero, agencia, tipo, titular, saldo, limite);
				
				contaController.atualizar(atualizada);
				
				System.out.printf("\nA conta corrente número %d foi atualizada, dados: ", numero);
				
				atualizada.visualizar();
			}
			case 2 -> {
				
				int aniversario = ((ContaPoupanca)conta).getAniversario();
				System.out.printf("O aniversàrio atual: %d%nNova Aniversario (Pressione ENTER para manter o valor atual): ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				
				ContaPoupanca atualizada = new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario);
				
				System.out.printf("\nA conta poupança número %d foi atualizada, dados: ", numero);
				
				atualizada.visualizar();
				
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta invalida!" + Cores.TEXT_RESET);
			}
			
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);

		}
	}
}