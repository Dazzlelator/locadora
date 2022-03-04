package classes;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static boolean existe(List x, Funcionario y) {
		return x.contains(y);
	}
	

	
	public static List<Funcionario> retornaDados(String [] listaFuncionarios) {
		List<Funcionario> funcionarios = new ArrayList<>();
		
		for(int i = 0; i < listaFuncionarios.length; i++) {
			String stringFuncionario = listaFuncionarios[i];
			String [] funcionario = stringFuncionario.split("#");
			
			if("A".equals(funcionario[3].toUpperCase())) {
				AnalistaSistemas analista = new AnalistaSistemas(Integer.valueOf(funcionario[0]));
				analista.setNome(funcionario[1]);
				analista.setSalario(Double.valueOf(funcionario[2]));
				funcionarios.add(analista);
			}
			if("P".equals(funcionario[3].toUpperCase())) {
				Programador programador = new Programador(Integer.valueOf(funcionario[0]));
				programador.setNome(funcionario[1]);
				programador.setSalario(Double.valueOf(funcionario[2]));
				funcionarios.add(programador);
			}		
			
		}
		return funcionarios;
		
	}



	public static void retornaDados(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}
