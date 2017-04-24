package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Gestor;
import model.OrganizacaoSocial;

public class GestorDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(Gestor gestor){
		String sql = "insert into gestores(idOS, nome, email, senha, cpf, telefone, dataNascimento) values(?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, gestor.getOng().getId());
			stm.setString(2, gestor.getNome());
			stm.setString(3, gestor.getEmail());
			stm.setString(4, gestor.getSenha());
			stm.setString(5, gestor.getCpf());
			stm.setString(6, gestor.getTelefone());
			stm.setString(7, gestor.getDataNascimento());
			
			stm.execute();
			
			return ultimoIdInserido();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(Gestor gestor){
		String sql = "update gestores set nome=?, email=?, senha=?, cpf=?, telefone=?, dataNascimento=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, gestor.getNome());
			stm.setString(2, gestor.getEmail());
			stm.setString(3, gestor.getSenha());
			stm.setString(4, gestor.getCpf());
			stm.setString(5, gestor.getTelefone());
			stm.setString(6, gestor.getDataNascimento());
			stm.setInt(7, gestor.getId());
			
			stm.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Gestor gestor){
		String sql = "delete from gestores where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, gestor.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Gestor selecionar(Integer id){
		String sql = "select id, idOS, nome, email, senha, cpf, telefone, dataNascimento from gestores where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Gestor gestor = new Gestor();
				gestor.setOng(new OrganizacaoSocial());
				gestor.getOng().setId(rs.getInt("idOS"));
				
				gestor.setId(rs.getInt("id"));
				gestor.setNome(rs.getString("nome"));
				gestor.setEmail(rs.getString("email"));
				gestor.setSenha(rs.getString("senha"));
				gestor.setCpf(rs.getString("cpf"));
				gestor.setTelefone(rs.getString("telefone"));
				gestor.setDataNascimento(rs.getString("dataNascimento"));
				
				
				return gestor;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Gestor> selecionarTodos(){
		String sql = "select id, idOS, nome, email, senha, cpf, telefone, dataNascimento";
		List<Gestor> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Gestor gestor = new Gestor();
				gestor.setOng(new OrganizacaoSocial());
				gestor.getOng().setId(rs.getInt("idOS"));
				
				gestor.setId(rs.getInt("id"));
				gestor.setNome(rs.getString("nome"));
				gestor.setEmail(rs.getString("email"));
				gestor.setSenha(rs.getString("senha"));
				gestor.setCpf(rs.getString("cpf"));
				gestor.setTelefone(rs.getString("telefone"));
				gestor.setDataNascimento(rs.getString("dataNascimento"));
				
				lista.add(gestor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void salvar(Gestor gestor){
		if(gestor.getId() != null && gestor.getId() > 0){
			alterar(gestor);
		}else{
			inserir(gestor);
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
