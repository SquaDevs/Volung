package service;

import java.util.List;

import dao.AreaDAO;
import model.Area;

public class AreaService {
	private AreaDAO areaDAO;
	
	public AreaService(){
		areaDAO = new AreaDAO();
	}
	
	public Integer inserir(Area area){
		return areaDAO.inserir(area);
	}
	
	public void alterar(Area area){
		areaDAO.alterar(area);
	}
	
	public void deletar(Area area){
		areaDAO.deletar(area);
	}
	
	public Area selecionar(Integer id){
		return areaDAO.selecionar(id);
	}
	
	public List<Area> selecionarTodos(){
		return areaDAO.selecionarTodos();
	}
	
	public void salvar(Area area){
		areaDAO.salvar(area);
	}
}
