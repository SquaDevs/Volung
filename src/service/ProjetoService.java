package service;

import java.util.List;

import dao.ProjetoDAO;
import model.Projeto;

public class ProjetoService {
	private ProjetoDAO projetoDAO;
	
	public ProjetoService(){
		projetoDAO = new ProjetoDAO();
	}
	
	public Integer inserir(Projeto projeto){
		return projetoDAO.inserir(projeto);
	}
	
	public void alterar(Projeto projeto){
		projetoDAO.alterar(projeto);
	}
	
	public void deletar(Projeto projeto){
		projetoDAO.deletar(projeto);
	}
	
	public Projeto selecionar(Integer id){
		return projetoDAO.selecionar(id);
	}
	
	public List<Projeto> selecionarPorOs(Integer id){
		return projetoDAO.selecionarPorOs(id);
	}
	
	public List<Projeto> selecionarTodos(){
		return projetoDAO.selecionarTodos();
	}
	
	public void salvar(Projeto projeto){
		projetoDAO.salvar(projeto);
	}
}
