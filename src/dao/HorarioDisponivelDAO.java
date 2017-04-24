package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.HorarioDisponivel;
import model.Voluntario;

public class HorarioDisponivelDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(HorarioDisponivel disponivel){
		String sql = "insert into horariosdisponiveis (idVolutarios, diasemana, turno) values( ?, ?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, disponivel.getVoluntario().getId());
			stm.setString(2, disponivel.getDiaSemana());
			stm.setString(3, disponivel.getTurno());
			
			stm.execute();
			
			return ultimoIdInserido();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void alterar(HorarioDisponivel disponivel){
		String sql = "update horariosdisponiveis set diasemana=? turno=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, disponivel.getDiaSemana());
			stm.setString(2, disponivel.getTurno());
			stm.setInt(3, disponivel.getVoluntario().getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(HorarioDisponivel disponivel){
		String sql = "delete from horariosdisponiveis where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, disponivel.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public HorarioDisponivel selecionar(){
		String sql = "select id, idVolutarios, diasemana, turno from horariosdisponiveis where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				HorarioDisponivel disponivel = new HorarioDisponivel();
				disponivel.setVoluntario(new Voluntario());
				disponivel.getVoluntario().setId(rs.getInt("idVolutarios"));
				
				disponivel.setId(rs.getInt("id"));
				disponivel.setDiaSemana(rs.getString("diasemana"));
				disponivel.setTurno(rs.getString("turno"));
				
				return disponivel;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<HorarioDisponivel> selecionarTodos(){
		String sql = "select id, idVolutarios, diasemana, turno from horariosdisponiveis";
		List<HorarioDisponivel> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				HorarioDisponivel disponivel = new HorarioDisponivel();
				disponivel.setVoluntario(new Voluntario());
				disponivel.getVoluntario().setId(rs.getInt("idVolutarios"));
				
				disponivel.setId(rs.getInt("id"));
				disponivel.setDiaSemana(rs.getString("diasemana"));
				disponivel.setTurno(rs.getString("turno"));
				
				lista.add(disponivel);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void salvar(HorarioDisponivel disponivel){
		if(disponivel.getId() != null && disponivel.getId() > 0){
			alterar(disponivel);
		}else{
			inserir(disponivel);
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
