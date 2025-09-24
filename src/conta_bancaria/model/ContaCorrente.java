package conta_bancaria.model;


//Classe: ContaCorrente
//É uma subclasse (filha) da classe Conta
//Representa uma conta corrente, com um atributo extra (limite)

public class ContaCorrente extends Conta { 
	
	// Atributo (variável de instância)
	// ➝ Guarda o valor do limite disponível para a conta corrente
	private float limite;
	
	// Construtor
	// Cria uma nova ContaCorrente
	// Chama o construtor da superclasse Conta (com "super")
	// Inicializa também o atributo limite
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	// Métodos de acesso (getter e setter)
	// Permitem ler e modificar o valor do atributo limite
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	// Método sobrescrito (override)
	// Altera a forma como o saque funciona em relação à classe mãe
	// Agora, o saque considera também o limite disponível
	
	@Override //Sempre acontece em uma subclasse
	
	public boolean sacar(float valor) {
		
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		
		return true;
	}
	
	// Método sobrescrito (override)
	// Mostra as informações da conta normal (da classe mãe)
	// E acrescenta o valor do limite disponível
	
	@Override //Sempre acontece em uma subclasse
	public void visualizar() {
		super.visualizar();
		System.out.printf("Limite da conta R$ %.2f%n", this.limite);
		
	}
	
}
