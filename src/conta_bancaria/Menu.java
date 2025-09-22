package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
		// Instanciar Objetos da Classe Conta
		
		Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 500000.00f);
		
		Conta c2 = new Conta(2, 123, 2, "Priscila Lins", 500000.00f);

		System.out.println("O Saldo da conta é: " + c1.getSaldo());
		
		c1.setSaldo(600000.00f);
		
		System.out.println("O Saldo da conta é: " + c1.getSaldo());
		
		c1.visualizar();
		
		c2.visualizar();
		
		System.out.println(c1.sacar(1000));
		System.out.println("O Saldo da conta é: " + c1.getSaldo());
		
		System.out.println(c2.sacar(1000000));
		System.out.println("O Saldo da conta é: " + c2.getSaldo());
		
		c1.depositar(5000);
		System.out.println("O Saldo da conta é: " + c1.getSaldo());


		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
				    + "╔══════════════════════ BRBANK  ════════════════════╗" + Cores.TEXT_RESET);

				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [1] Criar Conta                                    " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [2] Listar todas as Contas                         " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [3] Buscar Conta por Número                        " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [4] Atualizar Dados da Conta                       " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [5] Apagar Conta                                   " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [6] Sacar                                          " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [7] Depositar                                      " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [8] Transferir valores entre Contas                " + Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND + "  [0] Sair                                           " + Cores.TEXT_YELLOW_BOLD);

				System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
				    + "╚═══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);

				System.out.print(Cores.TEXT_YELLOW_BRIGHT + "\nEntre com a opção desejada: " + Cores.TEXT_RESET);



		    opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\nGoodBank - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
	    System.out.println(Cores.TEXT_YELLOW_BOLD + 
	        "\n══════════════════════════════════════════════════════" + Cores.TEXT_RESET);
	    System.out.println(Cores.TEXT_YELLOW_BOLD + "Projeto Desenvolvido por: Jessica Tinguely " + Cores.TEXT_RESET);
	    System.out.println(Cores.TEXT_YELLOW_BOLD + "jessicatinguely@icloud.com" + Cores.TEXT_RESET);
	    System.out.println(Cores.TEXT_YELLOW_BOLD + "https://github.com/jessicatinguely/conta_bancaria" + Cores.TEXT_RESET);
	    System.out.println(Cores.TEXT_YELLOW_BOLD + 
	        "══════════════════════════════════════════════════════" + Cores.TEXT_RESET);
	}


}