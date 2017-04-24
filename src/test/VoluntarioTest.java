package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.VoluntarioDAO;
import model.Voluntario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VoluntarioTest {
	Voluntario voluntario, copia;
	VoluntarioDAO voluntarioDAO;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setup");
		
		voluntario = new Voluntario();
		voluntario.setId(id);
		voluntario.setNome("Joao");
		voluntario.setEmail("Joao.silva@email.com");
		voluntario.setSenha("12345");
		voluntario.setCpf("5436575754");
		voluntario.setEndereco("Rua Cassununga");
		voluntario.setDataNascimento("09/10/1959");
		voluntario.setEstadoCivil("C");
		voluntario.setGenero("M");
		voluntario.setTelefone("4544-9864");
		voluntario.setSituacao("Ocupado");
		
		copia = new Voluntario();
		copia.setId(id);
		copia.setNome("Joao");
		copia.setEmail("Joao.silva@email.com");
		copia.setSenha("12345");
		copia.setCpf("5436575754");
		copia.setEndereco("Rua Cassununga");
		copia.setDataNascimento("09/10/1959");
		copia.setEstadoCivil("C");
		copia.setGenero("M");
		copia.setTelefone("4544-9864");
		copia.setSituacao("Ocupado");
		voluntarioDAO = new VoluntarioDAO();
		
		System.out.println(voluntario);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Selecionar(){
		System.out.println("selecionar");
		Voluntario fixture = new Voluntario();
		fixture.setId(1);
		fixture.setNome("Maria");
		fixture.setEmail("maria@email.com");
		fixture.setSenha("123");
		fixture.setCpf("123456789");
		fixture.setTelefone("0000-0001");
		fixture.setDataNascimento("02/04/1984");
		fixture.setGenero("F");
		fixture.setEstadoCivil("S");
		fixture.setEndereco("Rua Conselheiro Furtado");
		fixture.setSituacao("Disponivel");
		
		VoluntarioDAO novoDAO = new VoluntarioDAO();
		Voluntario novo = novoDAO.selecionar(1);
		
		System.out.println("Teste \n\n\n");
		System.out.println(novo);
		System.out.println(fixture);
		
		assertEquals("teste selecionar", novo, fixture);
	}
	
	@Test
	public void test01Inserir(){
		System.out.println("inserir");
		id = voluntarioDAO.inserir(voluntario);
		System.out.println(id);
		voluntario = voluntarioDAO.selecionar(id);
		copia.setId(id);
		assertEquals("teste inserir", voluntario, copia);
	}
	
	@Test
	public void test02Alterar(){
		System.out.println("alterar");
		voluntario.setNome("Joao Silva");
		copia.setNome("Joao Silva");
		voluntarioDAO.alterar(voluntario);
		voluntario = voluntarioDAO.selecionar(voluntario.getId());
		System.out.println(voluntario);
		System.out.println(copia);
		assertEquals("teste alterar", voluntario, copia);
	}
	
	@Test
	public void test03Deletar(){
		System.out.println("deletar");
		copia = null;
		voluntarioDAO.deletar(voluntario);
		voluntario = voluntarioDAO.selecionar(id);
		assertEquals("teste deletar", voluntario, copia);
	}
}
