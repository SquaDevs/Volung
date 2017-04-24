package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.AreaDAO;
import dao.OrganizacaoSocialDAO;
import dao.ProjetoDAO;
import model.Area;
import model.OrganizacaoSocial;
import model.Projeto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjetoTest {
	Projeto projeto, copia;
	ProjetoDAO projetoDAO;
	static int id = 0;
	
	Area area;
	AreaDAO areaDAO;
	
	OrganizacaoSocial organizacaoSocial;
	OrganizacaoSocialDAO organizacaoSocialDAO;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setup");
		
		areaDAO = new AreaDAO();
		area = areaDAO.selecionar(2);
		
		organizacaoSocialDAO = new OrganizacaoSocialDAO();
		organizacaoSocial = organizacaoSocialDAO.selecionar(1);
		
		
		projeto = new Projeto();
		projeto.setId(id);
		projeto.setNome("TestProjeto");
		projeto.setArea(area);
		projeto.setOrganizacaoSocial(organizacaoSocial);
		projeto.setDescricao("TestProjeto");
		projeto.setDatasTrabalhos("TestProjeto");
		
		copia = new Projeto();
		copia.setId(id);
		copia.setNome("TestProjeto");
		copia.setArea(area);
		copia.setOrganizacaoSocial(organizacaoSocial);
		copia.setDescricao("TestProjeto");
		copia.setDatasTrabalhos("TestProjeto");
		projetoDAO = new ProjetoDAO();
		
		System.out.println(projeto);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Selecionar(){
		System.out.println("selecionar");
		
		Projeto fixture = new Projeto();
		fixture.setId(1);
		fixture.setNome("Sp mais esporte");
		fixture.setArea(area);
		fixture.setOrganizacaoSocial(organizacaoSocial);
		fixture.setDescricao("projeto esporte");
		fixture.setDatasTrabalhos("Indefinido");
		
		ProjetoDAO novoDAO = new ProjetoDAO();
		Projeto novo = novoDAO.selecionar(1);
		novo.setArea(area);
		novo.setOrganizacaoSocial(organizacaoSocial);
		assertEquals("teste selecionar", novo, fixture);
	}
	
	@Test
	public void test01Inserir(){
		System.out.println("inserir");
		id = projetoDAO.inserir(projeto);
		System.out.println(id);
		projeto = projetoDAO.selecionar(id);
		projeto.setArea(area);
		projeto.setOrganizacaoSocial(organizacaoSocial);
		copia.setId(id);
		assertEquals("teste inserir", projeto, copia);
	}
	
	@Test
	public void test02Alterar(){
		System.out.println("alterar");
		projeto.setNome("TestAlterarProjeto");
		copia.setNome("TestAlterarProjeto");
		projetoDAO.alterar(projeto);
		projeto = projetoDAO.selecionar(projeto.getId());
		projeto.setArea(area);
		projeto.setOrganizacaoSocial(organizacaoSocial);
		assertEquals("teste alterar", projeto, copia);
	}
	
	@Test
	public void test03Deletar(){
		System.out.println("deletar");
		copia = null;
		projetoDAO.deletar(projeto);
		projeto = projetoDAO.selecionar(id);
		assertEquals("teste deletar", projeto, copia);
	}
}
