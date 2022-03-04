package classes;



public class Data {
	private Integer dia;
	private Integer mes;
	private Integer ano;
	
	public Data (Integer dia, Integer mes, Integer ano) {
		Boolean checkDia = false;
		Boolean checkMes = false;
		Boolean checkAno = false;
		if(dia > 0 && dia <= 31) {
			checkDia = true;
		}
		if(mes > 0 && mes <= 12) {
			checkMes = true;
		}
		if(ano > 0) {
			checkAno = true;
		}
		
		if(checkDia && checkMes && checkAno) {
			
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
			
		}else {
			System.out.println("valor fornecido incorreto");
		}
		
	}
	
	public String getStringData() {
		return this.dia + "/" + this.mes +"/" + this.ano;
	}
}
