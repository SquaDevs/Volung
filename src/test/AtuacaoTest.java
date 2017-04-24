package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.AtuacaoDAO;
import dao.ProjetoDAO;
import dao.VoluntarioDAO;
import model.Atuacao;
import model.Projeto;
import model.Voluntario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtuacaoTest {
	Atuacao atuacao, copia;
	AtuacaoDAO atuacaoDAO;
	
	Voluntario voluntario;
	VoluntarioDAO voluntarioDAO;
	
	Projeto projeto;
	ProjetoDAO projetoDAO;
	
	static int id = 0;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setup");
		
		voluntarioDAO = new VoluntarioDAO();
		voluntario = voluntarioDAO.selecionar(1);
		
		projetoDAO = new ProjetoDAO();
		projeto = projetoDAO.selecionar(1);
		
		atuacao = new Atuacao();
		atuacao.setId(id);
		atuacao.setVoluntario(voluntario);
		atuacao.setProjeto(projeto);
		atuacao.setDataInscricao("02/03/2017");
		atuacao.setDataEncerremento("INDEFINIDO");
		atuacao.setSituacao("Ativo");
		
		copia = new Atuacao();
		copia.setId(id);
		copia.setVoluntario(voluntario);
		copia.setProjeto(projeto);
		copia.setDataInscricao("02/03/2017");
		copia.setDataEncerremento("INDEFINIDO");
		copia.setSituacao("Ativo");
		atuacaoDAO = new AtuacaoDAO();
		
		System.out.println(atuacao);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Selecionar(){
		System.out.println("selecionar");
		voluntario = voluntarioDAO.selecionar(2);
		projeto = projetoDAO.selecionar(1);
		
		Atuacao fixture = new Atuacao();
		fixture.setId(1);
		fixture.setVoluntario(voluntario);
		fixture.setProjeto(projeto);
		fixture.setDataInscricao("Indefinido");
		fixture.setDataEncerremento("Indefinido");
		fixture.setSituacao("A");
		
		AtuacaoDAO novoDAO = new AtuacaoDAO();
		Atuacao novo = novoDAO.selecionar(1);
		novo.setProjeto(projeto);
		novo.setVoluntario(voluntario);
		assertEquals("teste selecionar", novo, fixture);
	}
	
	@Test
	public void test01Inserir(){
		System.out.println("inserir");
		id = atuacaoDAO.inserir(atuacao);
		System.out.println(id);
		atuacao = atuacaoDAO.selecionar(id);
		atuacao.setProjeto(projeto);
		atuacao.setVoluntario(voluntario);
		copia.setId(id);
		assertEquals("teste inserir", atuacao, copia);
	}
	
	@Test
	public void test02Alterar(){
		System.out.println("alterar");
		atuacao.setDataEncerremento("TesteAlterarAtuacao");
		copia.setDataEncerremento("TesteAlterarAtuacao");
		atuacaoDAO.alterar(atuacao);
		atuacao = atuacaoDAO.selecionar(atuacao.getId());
		atuacao.setProjeto(projeto);
		atuacao.setVoluntario(voluntario);
		assertEquals("teste alterar", atuacao, copia);
	}
	
	@Test
	public void test03Deletar(){
		System.out.println("deletar");
		copia = null;
		atuacaoDAO.deletar(atuacao);
		atuacao = atuacaoDAO.selecionar(id);
		assertEquals("teste deletar", atuacao, copia);
	}
}
