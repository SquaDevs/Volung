package service;

import java.util.List;

import dao.HorarioDisponivelDAO;
import model.HorarioDisponivel;

public class HorarioDisponivelService {
	
	private HorarioDisponivelDAO horarioDisponivelDAO;
	
	public HorarioDisponivelService(){
		horarioDisponivelDAO = new HorarioDisponivelDAO(); 
	}
	
	public Integer inserir(HorarioDisponivel disponivel){
		return horarioDisponivelDAO.inserir(disponivel);
	}
	
	public void alterar(HorarioDisponivel disponivel){
		horarioDisponivelDAO.alterar(disponivel);
	}
	
	public void deletar(HorarioDisponivel disponivel){
		horarioDisponivelDAO.alterar(disponivel);
	}
	
	public HorarioDisponivel selecionar(Integer id){
		return horarioDisponivelDAO.selecionar();
	}
	
	public List<HorarioDisponivel> selecionarTodos(){
		return horarioDisponivelDAO.selecionarTodos();
	}
	
	public void salvar(HorarioDisponivel disponivel){
		horarioDisponivelDAO.salvar(disponivel);
	}
}
