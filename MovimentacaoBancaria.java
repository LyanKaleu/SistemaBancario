public interface MovimentacaoBancaria {
	abstract void depositar(double valor);
	abstract void sacar(double valor) throws SaldoInsuficienteException;
}
