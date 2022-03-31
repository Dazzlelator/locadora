package classes;

import java.util.HashMap;
import java.util.Map;

public class Quadrado{
	

	private Double alt;
	private Double larg;
	
	public Quadrado(Double alt, Double larg) {
		this.alt = alt;
		this.larg = larg;
	}
	
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public double getLarg() {
		return larg;
	}
	public void setLarg(double larg) {
		this.larg = larg;
	}
	
	public boolean equals(Quadrado q) {
		if(alt.equals(q.alt) && larg.equals(q.larg)) {
			return true;
		}else {
			return false;
		}
	}

}



