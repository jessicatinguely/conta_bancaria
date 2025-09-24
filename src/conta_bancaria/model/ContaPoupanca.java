package conta_bancaria.model;

//Classe: ContaPoupanca
//É uma subclasse (filha) da classe Conta
//Representa uma conta poupança, com um atributo extra (aniversario)
public class ContaPoupanca extends Conta {
	
	// Atributo (variável de instância)
	// Guarda o dia de aniversário da poupança
	
	private int aniversario;

	//Construtor
	//Cria uma nova ContaPoupanca
	//Chama o construtor da superclasse Conta (com "super")
	//Inicializa também o atributo aniversario

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	// Métodos de acesso (getter e setter)
	//Permitem ler e modificar o valor do atributo aniversario
	
	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	//Método sobrescrito (override)
	//Reaproveita o método visualizar da classe mãe (super.visualizar())
	//E adiciona a exibição do atributo aniversario
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + this.aniversario);
		
	}
	
	
}
