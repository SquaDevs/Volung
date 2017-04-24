package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.OrganizacaoSocialDAO;
import model.OrganizacaoSocial;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganizacaoSocialTest {
	OrganizacaoSocial organizacaoSocial, copia;
	OrganizacaoSocialDAO organizacaoSocialDAO;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setup");
		
		organizacaoSocial = new OrganizacaoSocial();
		organizacaoSocial.setId(id);
		organizacaoSocial.setNome("OsTeste");
		organizacaoSocial.setRazaoSocial("OsTeste");
		organizacaoSocial.setEmail("OsTeste");
		organizacaoSocial.setCnpj("OsTeste");
		organizacaoSocial.setEndereco("OsTeste");
		organizacaoSocial.setTelefone("OsTeste");
		organizacaoSocial.setDataInicio("OsTeste");
		organizacaoSocial.setSituacao("OsTeste");
		
		copia = new OrganizacaoSocial();
		copia.setId(id);
		copia.setNome("OsTeste");
		copia.setRazaoSocial("OsTeste");
		copia.setEmail("OsTeste");
		copia.setCnpj("OsTeste");
		copia.setEndereco("OsTeste");
		copia.setTelefone("OsTeste");
		copia.setDataInicio("OsTeste");
		copia.setSituacao("OsTeste");
		organizacaoSocialDAO = new OrganizacaoSocialDAO();
		
		System.out.println(organizacaoSocial);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Selecionar(){
		System.out.println("selecionar");

		OrganizacaoSocial fixture = new OrganizacaoSocial();
		fixture.setId(1);
		fixture.setNome("ONG");
		fixture.setRazaoSocial("ONG MultiSp");
		fixture.setCnpj("987456123");
		fixture.setTelefone("1234-5678");
		fixture.setEmail("multiSp@email.com");
		fixture.setDataInicio("01/08/2004");
		fixture.setSituacao("A");
		fixture.setEndereco("Estrada do M'Boi Mirim");
		
		OrganizacaoSocialDAO novoDAO = new OrganizacaoSocialDAO();
		OrganizacaoSocial novo = novoDAO.selecionar(1);
		assertEquals("teste selecionar", novo, fixture);
	}
	
	@Test
	public void test01Inserir(){
		System.out.println("inserir");
		id = organizacaoSocialDAO.inserir(organizacaoSocial);
		System.out.println(id);
		organizacaoSocial = organizacaoSocialDAO.selecionar(id);
		copia.setId(id);
		assertEquals("teste inserir", organizacaoSocial, copia);
	}
	
	@Test
	public void test02Alterar(){
		System.out.println("alterar");
		organizacaoSocial.setNome("TestOSAlterar");
		copia.setNome("TestOSAlterar");
		organizacaoSocialDAO.alterar(organizacaoSocial);
		organizacaoSocial = organizacaoSocialDAO.selecionar(organizacaoSocial.getId());
		assertEquals("teste alterar", organizacaoSocial, copia);
	}
	
	@Test
	public void test03Deletar(){
		System.out.println("deletar");
		copia = null;
		organizacaoSocialDAO.deletar(organizacaoSocial);
		organizacaoSocial = organizacaoSocialDAO.selecionar(id);
		assertEquals("teste deletar", organizacaoSocial, copia);
	}
	
}
