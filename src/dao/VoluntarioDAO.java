package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Voluntario;

public class VoluntarioDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(Voluntario voluntario){
		String sql = "insert into voluntarios(nome, email, senha, cpf, telefone, dataNascimento, genero, estadoCivil, enderecoVol, situacao) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, voluntario.getNome());
			stm.setString(2, voluntario.getEmail());
			stm.setString(3, voluntario.getSenha());
			stm.setString(4, voluntario.getCpf());
			stm.setString(5, voluntario.getTelefone());
			stm.setString(6, voluntario.getDataNascimento());
			stm.setString(7, voluntario.getGenero());
			stm.setString(8, voluntario.getEstadoCivil());
			stm.setString(9, voluntario.getEndereco());
			stm.setString(10, voluntario.getSituacao());
			
			stm.execute();
			
			return ultimoIdInserido();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(Voluntario voluntario){
		String sql = "update voluntarios set nome=?, email=?, senha=?, telefone=?, genero=?, estadoCivil=?, enderecoVol=?, situacao=?, datanascimento=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, voluntario.getNome());
			stm.setString(2, voluntario.getEmail());
			stm.setString(3, voluntario.getSenha());
			stm.setString(4, voluntario.getTelefone());
			stm.setString(5, voluntario.getGenero());
			stm.setString(6, voluntario.getEstadoCivil());
			stm.setString(7, voluntario.getEndereco());
			stm.setString(8, voluntario.getSituacao());
			stm.setString(9, voluntario.getDataNascimento());
			stm.setInt(10, voluntario.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(Voluntario voluntario){
		String sql = "delete from voluntarios where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, voluntario.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Voluntario selecionar(Integer id){
		String sql = "select id, nome, email, senha, cpf, telefone, dataNascimento, genero, estadoCivil, enderecoVol, situacao "
				+ "from voluntarios where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Voluntario voluntario = new Voluntario();
				voluntario.setId(rs.getInt("id"));
				voluntario.setNome(rs.getString("nome"));
				voluntario.setEmail(rs.getString("email"));
				voluntario.setSenha(rs.getString("senha"));
				voluntario.setCpf(rs.getString("cpf"));
				voluntario.setTelefone(rs.getString("telefone"));
				voluntario.setDataNascimento(rs.getString("dataNascimento"));
				voluntario.setGenero(rs.getString("genero"));
				voluntario.setEstadoCivil(rs.getString("estadoCivil"));
				voluntario.setEndereco(rs.getString("enderecoVol"));
				voluntario.setSituacao((rs.getString("situacao")));
				
				return voluntario;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Voluntario> selecionarTodos(){
		String sql = "select id, nome, email, senha, cpf, telefone, dataNascimento, genero, estadoCivil, enderecoVol, situacao "
				+ "from voluntarios";
		
		List<Voluntario> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				Voluntario voluntario = new Voluntario();
				voluntario.setId(rs.getInt("id"));
				voluntario.setNome(rs.getString("nome"));
				voluntario.setEmail(rs.getString("email"));
				voluntario.setSenha(rs.getString("senha"));
				voluntario.setCpf(rs.getString("cpf"));
				voluntario.setTelefone(rs.getString("telefone"));
				voluntario.setDataNascimento(rs.getString("dataNascimento"));
				voluntario.setGenero(rs.getString("genero"));
				voluntario.setEstadoCivil(rs.getString("estadoCivil"));
				voluntario.setEndereco(rs.getString("enderecoVol"));
				voluntario.setSituacao((rs.getString("situacao")));
				
				lista.add(voluntario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void salvar(Voluntario voluntario){
		if(voluntario.getId() != null && voluntario.getId() > 0){
			alterar(voluntario);
		}else{
			inserir(voluntario);
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
