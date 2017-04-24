package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.AreaDAO;
import model.Area;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaTest {
	Area area, copia;
	AreaDAO areaDAO;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setup");
		area = new Area();
		area.setId(id);
		area.setNome("AreaTeste");
		
		copia = new Area();
		copia.setId(id);
		copia.setNome("AreaTeste");
		areaDAO = new AreaDAO();
		
		System.out.println(area);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Selecionar(){
		System.out.println("selecionar");
		Area fixture = new Area();
		fixture.setId(1);
		fixture.setNome("Saude");
		
		AreaDAO novoDAO = new AreaDAO();
		Area novo = novoDAO.selecionar(1);
		assertEquals("teste selecionar", novo, fixture);
	}

	@Test
	public void test01Inserir(){
		System.out.println("inserir");
		id = areaDAO.inserir(area);
		System.out.println(id);
		area = areaDAO.selecionar(id);
		copia.setId(id);
		assertEquals("teste inserir", area, copia);
	}
	
	@Test
	public void test02Alterar(){
		System.out.println("alterar");
		area.setNome("TesteAlterarArea");
		copia.setNome("TesteAlterarArea");
		areaDAO.alterar(area);
		area =  areaDAO.selecionar(area.getId());
		assertEquals("teste alterar", area, copia);
	}
	
	@Test
	public void test03Deletar(){
		System.out.println("deletar");
		copia = null;
		areaDAO.deletar(area);
		area = areaDAO.selecionar(id);
		assertEquals("teste deletar", area, copia);
	}
}
