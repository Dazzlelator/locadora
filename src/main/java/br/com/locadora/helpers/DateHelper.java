package br.com.locadora.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {
	private GregorianCalendar gc;
	private Date dataParaManipular;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	public DateHelper(Date data) {
		if(data != null) {
			this.gc = new GregorianCalendar();
			this.gc.setTime(data);
			this.dataParaManipular = data;
			
		}else {
			System.out.println("Data nula");
			return;
		}	
	}

	public DateHelper(String data){
        try {
        	
	        this.gc = new GregorianCalendar();
	        Date dataFormatada = formatter.parse(data);	        
	        this.dataParaManipular = dataFormatada;
	        this.gc.setTime(dataFormatada);
	        
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public Date getData() {
		
		return this.dataParaManipular;
	}

	public void addUtil(int quantidade) {
		gc.setTime(dataParaManipular);
		
		for(int i = 0; i < quantidade; i++) {
			int diaSemana = gc.get(Calendar.DAY_OF_WEEK);
			if(diaSemana == 7) {				
				this.adicionarDias(1);
			}
			this.adicionarDias(1);
		}		
	}
	
	public long subtrairDias(Date dia1, Date dia2) {
		long primeiroDia = dia1.getTime();
		long segundoDia = dia2.getTime();
		
		return segundoDia - primeiroDia;
	}
	
	public void adicionarDias(int quantidade) {
		
		adicionar(quantidade, Calendar.DAY_OF_MONTH);
	}

	public void adicionarMeses(int quantidade) {
		adicionar(quantidade, Calendar.MONTH);
	}

	public void adicionarAnos(int quantidade) {
		adicionar(quantidade, Calendar.YEAR);
	}

	private void adicionar(int quantidade, int tipoCampo) {
		gc.add(tipoCampo, quantidade);
		dataParaManipular = gc.getTime();
	}
	
	public int getMinutos() {
		return getCampo(Calendar.MINUTE);
	}

	public int getHoras() {
		return getCampo(Calendar.HOUR);
	}

	private int getCampo(int tipoCampo) {
		return gc.get(tipoCampo);
	}

	public Integer comparar(String data) {
		try {
			return comparar(formatter.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int comparar(Date data) {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return gc.compareTo(c);
	}

	public String getAsString() {
		return formatter.format(dataParaManipular);
	}
	
	public String pegarComoString() {
		return formatador.format(dataParaManipular);
	}
	
	public java.sql.Date getAsSQL(){
		
		if(this.dataParaManipular != null) {
			java.sql.Date sqlDate = new java.sql.Date(this.dataParaManipular.getTime());
			return sqlDate;		
		}else{
			return null;
		}		 
	}
}
