public class Conta extends ContaAbstrata{
		
	public Conta(String numero, double saldo){
		super(numero, saldo);
	}

	@Override	
	public void debitar(double valor) {
		double saldo = getSaldo();
		saldo -= valor;
		setSaldo(saldo);
	}
}
