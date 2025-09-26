package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

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
