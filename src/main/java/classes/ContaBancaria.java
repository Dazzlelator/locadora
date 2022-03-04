package classes;

public class ContaBancaria {

	private Double saldo = 0.0;
	private Data dataAbertura;

	public ContaBancaria(Double saldo, Data dataAbertura) {
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
	}

	public ContaBancaria(Data dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public ContaBancaria() {
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Data getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Data dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getDataAberturaFormatada() {
		return this.dataAbertura.getStringData();
	}

	public String getSaldoFormatado() {

		Double intDecimal = (this.saldo * 100);
		Integer casaDecimal = (int) (intDecimal % 100);

		return "R$ " + formatadorNumero(this.saldo.intValue()) + "," + casaDecimal.toString();
	}
	

	private String formatadorNumero(Integer numero) {
		Integer sobra = (int) (numero % 1000);
	
		if (numero <= 1000) {
			return sobra.toString();
		}

		return this.formatadorNumero(numero / 1000) + "." + String.format("%03d", sobra);
	}
	
	public void depositar(Double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void sacar(Double valor) {
		if(valor <= saldo) {
			this.saldo = this.saldo - valor;
		}else {
			System.out.println("Saldo insuficiente!");
			System.out.println("Saldo atual: " + this.getSaldoFormatado());
		}
	}

}
