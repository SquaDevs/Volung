package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.OrganizacaoSocial;
import model.Projeto;

public class ProjetoDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(Projeto projeto){
		String sql = "insert into projetos(idOS, idAreas, nome, descricao, datasTrabalhos) values(?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, projeto.getOrganizacaoSocial().getId());
			stm.setInt(2, projeto.getArea().getId());
			stm.setString(3, projeto.getNome());
			stm.setString(4, projeto.getDescricao());
			stm.setString(5, projeto.getDatasTrabalhos());
			
			stm.execute();
			
			return ultimoIdInserido();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(Projeto projeto){
		String sql = "update projetos set nome=?, descricao=?, datasTrabalhos=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, projeto.getNome());
			stm.setString(2, projeto.getDescricao());
			stm.setString(3, projeto.getDatasTrabalhos());
			stm.setInt(4, projeto.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Projeto projeto){
		String sql = "delete from projetos where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, projeto.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Projeto selecionar(Integer id){
		String sql = "select id, idOS, idAreas, nome, descricao, datasTrabalhos from projetos where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Projeto projeto = new Projeto();
				projeto.setOrganizacaoSocial(new OrganizacaoSocial());
				projeto.getOrganizacaoSocial().setId(rs.getInt("idOs"));
				
				projeto.setId(rs.getInt("id"));
				projeto.setNome(rs.getString("nome"));
				projeto.setDescricao(rs.getString("descricao"));
				projeto.setDatasTrabalhos(rs.getString("datasTrabalhos"));
				
				return projeto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Projeto> selecionarPorOs(Integer id){
		String sql = "select id, idOS, idAreas, nome, descricao, datasTrabalhos from projetos where idOS=?";
		List<Projeto> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Projeto projeto = new Projeto();
				projeto.setOrganizacaoSocial(new OrganizacaoSocial());
				projeto.getOrganizacaoSocial().setId(rs.getInt("idOs"));
				
				projeto.setId(rs.getInt("id"));
				projeto.setNome(rs.getString("nome"));
				projeto.setDescricao(rs.getString("descricao"));
				projeto.setDatasTrabalhos(rs.getString("datasTrabalhos"));
				
				lista.add(projeto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Projeto> selecionarTodos(){
		String sql = "select idOS, idAreas, nome, descricao, datasTrabalhos from projetos";
		List<Projeto> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Projeto projeto = new Projeto();
				projeto.setOrganizacaoSocial(new OrganizacaoSocial());
				projeto.getOrganizacaoSocial().setId(rs.getInt("idOs"));
				
				projeto.setId(rs.getInt("id"));
				projeto.setNome(rs.getString("nome"));
				projeto.setDescricao(rs.getString("descricao"));
				projeto.setDatasTrabalhos(rs.getString("datasTrabalhos"));
				
				lista.add(projeto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void salvar(Projeto projeto){
		if(projeto.getId() != null && projeto.getId() > 0){
			alterar(projeto);
		}else{
			inserir(projeto);
		}
	}
	
	private Integer ultimoIdInserido(){
		String sql = "select last_insert_id()";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Integer id = rs.getInt(1);
				
				return id;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
