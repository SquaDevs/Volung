package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Atuacao;
import model.Projeto;
import model.Voluntario;

public class AtuacaoDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(Atuacao atuacao){
		String sql = "insert into atuacao(idVoluntario, idProjeto, dataInscricao,dataencerramento, situacao) values(?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, atuacao.getVoluntario().getId());
			stm.setInt(2, atuacao.getProjeto().getId());
			stm.setString(3, atuacao.getDataInscricao());
			stm.setString(4, atuacao.getDataEncerremento());
			stm.setString(5, atuacao.getSituacao());
			
			stm.execute();
			
			return ultimoIdInserido();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(Atuacao atuacao){
		String sql = "update atuacao set dataEncerramento=?, situacao=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, atuacao.getDataEncerremento());
			stm.setString(2, atuacao.getSituacao());
			stm.setInt(3, atuacao.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Atuacao atuacao){
		String sql = "delete from atuacao where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, atuacao.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Atuacao selecionar(Integer id){
		String sql = "select id, idVoluntario, idProjeto, dataInscricao, dataEncerramento, situacao from Atuacao where id=?;";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Voluntario voluntario = new Voluntario();
				voluntario.setId(rs.getInt("idVoluntario"));
				
				Projeto projeto = new Projeto();
				projeto.setId(rs.getInt("idProjeto"));
				
				Atuacao atuacao = new Atuacao();
				atuacao.setId(rs.getInt("id"));
				atuacao.setVoluntario(voluntario);
				atuacao.setProjeto(projeto);
				atuacao.setDataInscricao(rs.getString("dataInscricao"));
				atuacao.setDataEncerremento(rs.getString("dataEncerramento"));
				atuacao.setSituacao(rs.getString("situacao"));
				
				return atuacao;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Atuacao> selecionarTodos(){
		String sql = "select idVoluntario, idProjeto, dataInscricao, dataEncerramento, situacao from Atuacao";
		List<Atuacao> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Voluntario voluntario = new Voluntario();
				voluntario.setId(rs.getInt("idVoluntario"));
				
				Projeto projeto = new Projeto();
				projeto.setId(rs.getInt("idProjeto"));
				
				Atuacao atuacao = new Atuacao();
				atuacao.setVoluntario(voluntario);
				atuacao.setProjeto(projeto);
				atuacao.setDataInscricao(rs.getString("dataInscricao"));
				atuacao.setDataEncerremento(rs.getString("dataEncerramento"));
				atuacao.setSituacao(rs.getString("situacao"));
				
				lista.add(atuacao);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void salvar(Atuacao atuacao){
		if(atuacao.getId() != null && atuacao.getId() > 0){
			alterar(atuacao);
		}else{
			inserir(atuacao);
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
