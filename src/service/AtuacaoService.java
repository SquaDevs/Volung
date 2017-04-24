package service;

import java.util.List;

import dao.AtuacaoDAO;
import model.Atuacao;

public class AtuacaoService {
	private AtuacaoDAO atuacaoDAO;
	
	public AtuacaoService(){
		atuacaoDAO = new AtuacaoDAO();
	}
	
	public Integer inserir(Atuacao atuacao){
		return atuacaoDAO.inserir(atuacao);
	}
	
	public void alterar(Atuacao atuacao){
		atuacaoDAO.alterar(atuacao);
	}
	
	public void deletar(Atuacao atuacao){
		atuacaoDAO.deletar(atuacao);
	}
	
	public Atuacao selecionar(Integer id){
		return atuacaoDAO.selecionar(id);
	}
	
	public List<Atuacao> selecionarTodos(){
		return atuacaoDAO.selecionarTodos();
	}
	
	public void salvar(Atuacao atuacao){
		atuacaoDAO.salvar(atuacao);
	}
}
