package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

//Controller é como vai ser seguido as regras da ContaRepository

public class ContaController implements ContaRepository {

	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void listarToda() {
		for(var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Conta Cadastrada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());
		if(buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
		}
		// Menu ja valida a existencia da conta na collection
//		else {
//			System.out.printf("A conta numero: %d näo foi encontrada!%n", conta.getNumero());
//		}
	}

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.printf("A conta numero: %d näo foi encontrada!%n", numero);
		}

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if(listaContas.remove(conta) == true) {
				System.out.printf("%nA conta numero %d foi deletada com sucesso!%n", numero);
			}
		}else {
			System.out.printf("A conta numero: %d näo foi encontrada!%n", numero);
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if(conta.sacar(valor) == true) {
				System.out.printf("O saque no valor de %.2f, na conta numero: %d foi efetuado com sucesso", valor, numero);
		}
		}else {
			System.out.printf("A conta numero: %d näo foi encontrada!%n", numero);
		}
	}

	@Override
	public void depositar(int numero, float valor) {
		
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			conta.depositar(valor);
				System.out.printf("O deposito no valor de %.2f, na conta numero: %d foi efetuado com sucesso", valor, numero);
		}else {
			System.out.printf("A conta numero: %d näo foi encontrada!%n", numero);
		}

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			if(contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.printf("%n"
						+ "A transferencia no valor de %.2f, da conta numero: %d para a conta numero: %d, foi efetuada com sucesso", 
						valor, numeroOrigem, numeroDestino);
		}
		}else {
			System.out.println("A Conta de Origem e/ou Conta de Destino nao foram encontrada!%n");
		}
	}
		@Override
		public void listarPorTitular(String titular) {
		
			List<Conta> listaTitulares = listaContas.stream()
					.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
					.collect(Collectors.toList());
					
					if(listaTitulares.isEmpty()) {
						System.out.printf("%nNenhuma conta foi encontrada para titulares que possuam o nome: %s", titular);
						
						
					}
					for(var conta : listaTitulares) {
						conta.visualizar();
						
					}
	}
	
	//Metodos Auxiliares 
	public int gerarNumero() {
		return ++ numero;
	}
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero()== numero) {
				return conta;
			}
		}
		return null;

		
	}
}
