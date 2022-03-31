package classes;

import java.util.Map;

public class CalcularMedia {

	public CalcularMedia() {
		
		
	
	}
	
	public Double media (Map<String, Double> g, int cargo) {
		
		Double somatorio = 0.0;
		Integer counter = 0;
		
		for(Map.Entry<String, Double> entrada : g.entrySet()) {				
				
				
				String codigo = entrada.getKey();
				Double salario = entrada.getValue();
				
				String stringCargo = codigo.split("#")[1];
				Integer intCargo = Integer.valueOf(stringCargo);
				if(intCargo.equals(cargo)) {
					somatorio += salario;
					counter++;
				}		
			
			}
		return somatorio/counter;
	}

}
