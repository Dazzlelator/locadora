package classes;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    static List<Funcionario> funcionarios = new ArrayList<>();
    
    protected Integer id;
    protected String nome;
    protected Double salario;
    
    public Funcionario(Integer id) {
        this.id = id;
        Funcionario.funcionarios.add(this);
    }


	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	@Override
	public boolean equals (Object obj) {
		if(obj==null) return false;
		if(obj instanceof Funcionario) {
			Funcionario x = (Funcionario) obj;
			if(id!= null) {
				 return id.equals(x.getId());
			}
		}
		return false;
			
	}
	
	@Override
	public String toString() {
		return  id+", "+ nome +", " + salario;
	}
	
}
