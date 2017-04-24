package service;

import java.util.List;

import dao.VoluntarioDAO;
import model.Voluntario;

public class VoluntarioService {
	private VoluntarioDAO voluntarioDAO;
	
	public VoluntarioService(){
		voluntarioDAO = new VoluntarioDAO();
	}
	
	public Integer inserir(Voluntario voluntario){
		return voluntarioDAO.inserir(voluntario);
	}
	
	public void alterar(Voluntario voluntario){
		voluntarioDAO.alterar(voluntario);
	}
	
	public void deletar(Voluntario voluntario){
		voluntarioDAO.deletar(voluntario);
	}
	
	public Voluntario selecionar(Integer id){
		return voluntarioDAO.selecionar(id);
	}
	
	public List<Voluntario> selecionarTodos(){
		return voluntarioDAO.selecionarTodos();
	}
	
	public void salvar(Voluntario voluntario){
		voluntarioDAO.salvar(voluntario);
	}
}
