package service;

import java.util.List;

import dao.GestorDAO;
import model.Gestor;

public class GestorService {
	private GestorDAO gestorDAO;
	
	public GestorService(){
		gestorDAO = new GestorDAO();
	}
	
	public Integer inserir(Gestor gestor){
		return gestorDAO.inserir(gestor);
	}
	
	public void alterar(Gestor gestor){
		gestorDAO.alterar(gestor);
	}
	
	public void deletar(Gestor gestor){
		gestorDAO.deletar(gestor);
	}
	
	public Gestor selecionar(Integer id){
		return gestorDAO.selecionar(id);
	}
	
	public List<Gestor> selecionarTodos(){
		return gestorDAO.selecionarTodos();
	}
	
	public void salvar(Gestor gestor){
		gestorDAO.salvar(gestor);
	}
}
