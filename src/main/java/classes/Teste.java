package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
//    	Funcionario funcionario1 = new Funcionario(1);
//    	Funcionario funcionario2 = new Funcionario(2);
//    	Funcionario funcionario3 = new Funcionario(3);
//    	AnalistaSistemas as = new AnalistaSistemas(4);
//    	
//    	
//    	funcionario1.setNome("teste1");
//    	funcionario1.setSalario(15658.00);
//    	
//    	as.setNome("Raphael");
//    	as.setSalario(10000.00);
//    	
//    	
//    	System.out.println(as.getClass().getSimpleName());
    	String [] funcionarios = {"12#Raphael Monteiro#12353.25#P", "15#Gabriel Monteiro#12113.12#A"};
    	
    	
    	
    	System.out.println(Utils.retornaDados(funcionarios).get(1).getNome());
    	
    }
  
}
