public class ContaPoupanca extends ContaBancaria {
	
	private double taxaRendimemto;

	public ContaPoupanca(String numeroConta, double saldo, double taxaRendimemto) {
		super(numeroConta, saldo);
		this.taxaRendimemto = taxaRendimemto;
	}

	public double getTaxaRendimemto() {
		return taxaRendimemto;
	}

	public void setTaxaRendimemto(double taxaRendimemto) {
		this.taxaRendimemto = taxaRendimemto;
	}

	public double calcularRendimento() {
		return getSaldo() * taxaRendimemto;
	}
}
