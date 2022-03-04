package br.com.locadora.helpers;

public class NumberHelper {
	
	private String numFormatado;
	private Double numero;
	
	public NumberHelper(Double numero) {
		this.numero = numero;
	}
	public NumberHelper(Float numero) {
		this.numero = Double.valueOf(numero);
	}
	public NumberHelper(Integer numero) {
		this.numero = Double.valueOf(numero);
	}
	public NumberHelper(String numero) {
		this.numero = Double.valueOf(numero);
	}
	public NumberHelper() {
		
	}
	
	public String pontoToVirgula() {
	
		String decimalFormatado = String.format("%,.2f", this.numero);
		return decimalFormatado;
	}
	
	public String pontoToVirgula(Double numero) {
		this.numero = numero;
		
		String decimalFormatado = String.format("%,.2f", this.numero);
		return decimalFormatado;
	}
	
	public Double virgulaToponto(String numero) {
		String formatado = numero.replace(",", ".");
		return Double.valueOf(formatado);
	}
	
	
	
}
