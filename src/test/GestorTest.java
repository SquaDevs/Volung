package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.GestorDAO;
import dao.OrganizacaoSocialDAO;
import model.Gestor;
import model.OrganizacaoSocial;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestorTest {
	Gestor gestor, copia;
	GestorDAO gestorDAO;
	static int id = 0;
	
	OrganizacaoSocial organizacaoSocial;
	OrganizacaoSocialDAO organizacaoSocialDAO;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setup");
		
		organizacaoSocialDAO = new OrganizacaoSocialDAO();
		organizacaoSocial = organizacaoSocialDAO.selecionar(1);
		
		gestor = new Gestor();
		gestor.setId(id);
		gestor.setOng(organizacaoSocial);
		gestor.setNome("GestorTeste");
		gestor.setEmail("GestorTeste");
		gestor.setSenha("GestorTeste");
		gestor.setCpf("GestorTeste");
		gestor.setDataNascimento("GestorTeste");
		gestor.setTelefone("GestorTeste");
		
		copia = new Gestor();
		copia.setId(id);
		copia.setOng(organizacaoSocial);
		copia.setNome("GestorTeste");
		copia.setEmail("GestorTeste");
		copia.setSenha("GestorTeste");
		copia.setCpf("GestorTeste");
		copia.setDataNascimento("GestorTeste");
		copia.setTelefone("GestorTeste");
		gestorDAO = new GestorDAO();
		
		System.out.println(gestor);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Selecionar(){
		System.out.println("selecionar");
		
		Gestor fixture = new Gestor();
		fixture.setId(1);
		fixture.setNome("Samuel");
		fixture.setEmail("sam@email.com");
		fixture.setSenha("192");
		fixture.setCpf("101112131");
		fixture.setDataNascimento("11/02/1986");
		fixture.setTelefone("1000-0000");
		fixture.setOng(new OrganizacaoSocial());
		fixture.getOng().setId(1);
		
		GestorDAO novoDAO = new GestorDAO();
		Gestor novo = novoDAO.selecionar(1);
		assertEquals("teste selecionar", novo, fixture);
	}
	
	@Test
	public void test01Inserir(){
		System.out.println("inserir");
		id = gestorDAO.inserir(gestor);
		System.out.println(id);
		gestor = gestorDAO.selecionar(id);
		gestor.setOng(organizacaoSocial);
		copia.setId(id);
		assertEquals("teste inserir", gestor, copia);
	}
	
	@Test
	public void test02Alterar(){
		System.out.println("alterar");
		gestor.setNome("TesteAlterarGestor");
		copia.setNome("TesteAlterarGestor");
		gestorDAO.alterar(gestor);
		gestor = gestorDAO.selecionar(gestor.getId());
		gestor.setOng(organizacaoSocial);
		assertEquals("teste alterar", gestor, copia);
	}
	
	@Test
	public void test03Deletar(){
		System.out.println("deletar");
		copia = null;
		gestorDAO.deletar(gestor);
		gestor = gestorDAO.selecionar(id);
		assertEquals("teste deletar", gestor, copia);
	}
}
