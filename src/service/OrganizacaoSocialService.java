package service;

import java.util.List;

import dao.OrganizacaoSocialDAO;
import model.OrganizacaoSocial;

public class OrganizacaoSocialService {
	private OrganizacaoSocialDAO organizacaoSocialDAO;
	
	public OrganizacaoSocialService(){
		organizacaoSocialDAO = new OrganizacaoSocialDAO();
	}
	
	public Integer inserir(OrganizacaoSocial organizacaoSocial){
		return organizacaoSocialDAO.inserir(organizacaoSocial);
	}
	
	public void alterar(OrganizacaoSocial organizacaoSocial){
		organizacaoSocialDAO.alterar(organizacaoSocial);
	}
	
	public void deletar(OrganizacaoSocial organizacaoSocial){
		organizacaoSocialDAO.deletar(organizacaoSocial);
	}
	
	public OrganizacaoSocial selecionar(Integer id){
		return organizacaoSocialDAO.selecionar(id);
	}
	
	public List<OrganizacaoSocial> selecionarTodos(){
		return organizacaoSocialDAO.selecionarTodos();
	}
	
	public void salvar(OrganizacaoSocial organizacaoSocial){
		organizacaoSocialDAO.salvar(organizacaoSocial);
	}
}
