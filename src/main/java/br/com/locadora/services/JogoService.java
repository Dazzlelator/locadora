package br.com.locadora.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.locadora.helpers.DateHelper;
import br.com.locadora.model.Jogo;
import br.com.locadora.model.dao.ConnectionFactory;
import br.com.locadora.model.dao.JogoDAO;

public class JogoService {
	private JogoDAO jogoDao;

	public JogoService() {
		Connection con = new ConnectionFactory().recuperarConexao();
		this.jogoDao = new JogoDAO(con);
	}

	public void salvar(Jogo jogo) {
		this.jogoDao.salvar(jogo);
	}

	public void updateById(Integer id, Jogo jogo) {
		this.jogoDao.updateJogosById(id, jogo);
	}

	public void updateStatus(Integer id, Integer status) {

		Jogo jogoAtual = this.jogoDao.getJogoById(id);
		String statusAtual = jogoAtual.getStatus();

		ProdutoService pc = new ProdutoService();

		switch (status) {
		case 1:
			if (!statusAtual.equals("disponivel")) {
				jogoAtual.setStatus("disponivel");
				pc.entrada(jogoAtual.getIdProduto());
				this.jogoDao.updateJogosById(id, jogoAtual);
			}
			System.out.println("Jogo já está " + statusAtual);
			break;
		case 2:
			if (!statusAtual.equals("alugado")) {
				jogoAtual.setStatus("alugado");
				pc.retirada(jogoAtual.getIdProduto());
				this.jogoDao.updateJogosById(id, jogoAtual);
			}
			System.out.println("Jogo já está " + statusAtual);
			break;
		case 3:
			if (!statusAtual.equals("vendido")) {
				jogoAtual.setStatus("vendido");
				pc.retirada(jogoAtual.getIdProduto());
				this.jogoDao.updateJogosById(id, jogoAtual);
			}
			System.out.println("Jogo já está " + statusAtual);
			break;
		case 4:
			if (!statusAtual.equals("extraviado")) {
				jogoAtual.setStatus("extraviado");
				pc.retirada(jogoAtual.getIdProduto());
				this.jogoDao.updateJogosById(id, jogoAtual);
			}
			System.out.println("Jogo já está " + statusAtual);
			break;
		default:
			System.out.println("Válidos números de 1 a 4 no segundo parametro");
			System.out.println("1 -  disponivel; 2 - alugado; 3 - vendido, 4 - extraviado");
			break;
		}

	}

	public List<Jogo> getAll() {
		return this.jogoDao.getAllJogos();
	}
	
	public List<Jogo> getGroupByIdProduto(){
		return this.jogoDao.getJogosGroupByIdProduto();
	}

	public Jogo getById(Integer id) {
		return this.jogoDao.getJogoById(id);
	}

	public List<Jogo> getLancamento(Integer tempoDeLancamentoEmMeses) {

		// atributos adicionam dias a data de lancamento e verificam se o filme pode ser
		// classificado como lancamento;

		List<Jogo> jogos = this.getGroupByIdProduto();
		List<Jogo> lancamentos = new ArrayList<>();
		Long dataAtual = new Date().getTime();

		for (int i = 0; i < jogos.size(); i++) {

			Date dataLancamento = jogos.get(i).getDataLancamento();
			DateHelper dataParaAdd = new DateHelper(dataLancamento);
			if (dataLancamento != null) {
				dataParaAdd.adicionarMeses(tempoDeLancamentoEmMeses);
//				dataParaAdd.adicionarMeses(tempoDeLancamentoEmDias);
				if (dataParaAdd.getData().getTime() > dataAtual) {
						lancamentos.add(jogos.get(i));
				}
			}
		}
		for (int j = 0; j < lancamentos.size(); j++) {
			System.out.println(lancamentos.get(j).getDataLancamento());
		}
		return lancamentos;
	}

	public void deletar(Integer id) {
		this.jogoDao.deletarById(id);
	}
}
