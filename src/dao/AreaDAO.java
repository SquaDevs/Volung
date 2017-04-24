package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Area;

public class AreaDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(Area area){
		String sql = "insert into areas(nome) values(?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, area.getNome());
			
			stm.execute();
			
			return ultimoIdInserido();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(Area area){
		String sql = "update areas set nome=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, area.getNome());
			stm.setInt(2, area.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Area area){
		String sql = "delete from areas where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, area.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Area selecionar(Integer id){
		String sql = "select id, nome from areas where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Area area = new Area();
				area.setId(rs.getInt("id"));
				area.setNome(rs.getString("nome"));
				
				return area;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}
	
	public List<Area> selecionarTodos(){
		String sql = "select id, nome from areas";
		List<Area> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Area area = new Area();
				area.setId(rs.getInt("id"));
				area.setNome(rs.getString("nome"));
				
				lista.add(area);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return lista;
	}
	
	public void salvar(Area area){
		if(area.getId() != null && area.getId() > 0){
			alterar(area);
		}else{
			inserir(area);
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
