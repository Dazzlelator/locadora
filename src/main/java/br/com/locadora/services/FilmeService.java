package br.com.locadora.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Filme;
import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.FilmeDAO;

public class FilmeService {
	private FilmeDAO filmeDao;

	public FilmeService() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.filmeDao = new FilmeDAO(con);
	}

	public void salvar(Filme filme) {
		this.filmeDao.salvar(filme);
	}

	public void updateById(Integer id, Filme filme) {
		this.filmeDao.updateFilmeById(id, filme);
	}

	public void updateStatus(Integer id, Integer status) {

		Filme filmeAtual = this.filmeDao.getFilmeById(id);
		String statusAtual = filmeAtual.getStatus();

		ProdutoService pc = new ProdutoService();

		switch (status) {
		case 1:
			if (!statusAtual.equals("disponivel")) {
				filmeAtual.setStatus("disponivel");
				pc.entrada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está " + statusAtual);
			break;
		case 2:
			if (!statusAtual.equals("alugado")) {
				filmeAtual.setStatus("alugado");
				pc.retirada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está " + statusAtual);
			break;
		case 3:
			if (!statusAtual.equals("vendido")) {
				filmeAtual.setStatus("vendido");
				pc.retirada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está " + statusAtual);
			break;
		case 4:
			if (!statusAtual.equals("extraviado")) {
				filmeAtual.setStatus("extraviado");
				pc.retirada(filmeAtual.getIdProduto());
				this.filmeDao.updateFilmeById(id, filmeAtual);
			}
			System.out.println("Filme já está " + statusAtual);
			break;
		default:
			System.out.println("Válidos números de 1 a 4 no segundo parametro");
			System.out.println("1 -  disponivel; 2 - alugado; 3 - vendido, 4 - extraviado");
			break;
		}

	}

	public List<Filme> getAll() {
		return this.filmeDao.getAllFilmes();
	}
	
	public List<Filme> getGroupByIdProduto(){
		return this.filmeDao.getFilmeGroupByIdProduto();
	}

	public Filme getById(Integer id) {
		return this.filmeDao.getFilmeById(id);
	}

	public List<Filme> getLancamento(Integer tempoDeLancamentoEmMeses) {
		
		//atributos adicionam dias a data de lancamento e verificam se o filme pode ser classificado como lancamento;

		List<Filme> filmes = this.getGroupByIdProduto();
		List<Filme> lancamentos = new ArrayList<>();
		Long dataAtual = new Date().getTime();

		for (int i = 0; i < filmes.size(); i++) {
			
			Date dataLancamento = filmes.get(i).getDataLancamento();
			DateHelper dataParaAdd = new DateHelper(dataLancamento);
			if(dataLancamento != null) {				
				dataParaAdd.adicionarMeses(tempoDeLancamentoEmMeses);
//				dataParaAdd.adicionarMeses(tempoDeLancamentoEmDias);
				if (dataParaAdd.getData().getTime() > dataAtual) {	
						lancamentos.add(filmes.get(i));
				}
			}
		}
		for(int j = 0; j < lancamentos.size(); j++) {
			System.out.println(lancamentos.get(j).getDataLancamento());
		}
		return lancamentos;
	}

	public void deletar(Integer id) {
		this.filmeDao.deletarFilmeById(id);

	}
}
