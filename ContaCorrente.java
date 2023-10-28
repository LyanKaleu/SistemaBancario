public class ContaCorrente extends ContaBancaria implements MovimentacaoBancaria{

	private double limiteChequeEspecial;

	public ContaCorrente(String numeroConta, double saldo, double limiteChequeEspecial) {
		super(numeroConta, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public void sacar(double valor) throws SaldoInsuficienteException {
		if(valor > getSaldo() + limiteChequeEspecial) {
			throw new SaldoInsuficienteException("Saldo insuficiente para conta");
		}
		setSaldo(getSaldo() - valor);
	}
	
	
}
