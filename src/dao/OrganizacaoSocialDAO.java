package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.OrganizacaoSocial;

public class OrganizacaoSocialDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	
	public Integer inserir(OrganizacaoSocial organizacaoSocial){
		String sql = "insert into OrganizacoesSociais(nome, razaoSocial, cnpj, telefone, email, dataInicio, situacao, enderecoOng) "
				+ "values(?, ? , ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, organizacaoSocial.getNome());
			stm.setString(2, organizacaoSocial.getCnpj());
			stm.setString(3, organizacaoSocial.getRazaoSocial());
			stm.setString(4, organizacaoSocial.getTelefone());
			stm.setString(5, organizacaoSocial.getEmail());
			stm.setString(6, organizacaoSocial.getDataInicio());
			stm.setString(7, organizacaoSocial.getSituacao());
			stm.setString(8, organizacaoSocial.getEndereco());
			
			stm.execute();
			
			return ultimoIdInserido();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterar(OrganizacaoSocial organizacaoSocial){
		String sql = "update OrganizacoesSociais set nome=?, cnpj=?, telefone=?, email=?, situacao=?, enderecoOng=?, datainicio=? where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setString(1, organizacaoSocial.getNome());
			stm.setString(2, organizacaoSocial.getCnpj());
			stm.setString(3, organizacaoSocial.getTelefone());
			stm.setString(4, organizacaoSocial.getEmail());
			stm.setString(5, organizacaoSocial.getSituacao());
			stm.setString(6, organizacaoSocial.getEndereco());
			stm.setString(7, organizacaoSocial.getDataInicio());
			stm.setInt(8, organizacaoSocial.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(OrganizacaoSocial organizacaoSocial){
		String sql = "delete from OrganizacoesSociais where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, organizacaoSocial.getId());

			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public OrganizacaoSocial selecionar(Integer id){
		String sql = "select id, nome, razaoSocial, cnpj, telefone, email, dataInicio, situacao, enderecoOng from OrganizacoesSociais where id=?";
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				OrganizacaoSocial organizacaoSocial = new OrganizacaoSocial();
				organizacaoSocial.setId(rs.getInt("id"));
				organizacaoSocial.setNome(rs.getString("nome"));
				organizacaoSocial.setRazaoSocial(rs.getString("razaoSocial"));
				organizacaoSocial.setCnpj(rs.getString("cnpj"));
				organizacaoSocial.setTelefone(rs.getString("telefone"));
				organizacaoSocial.setEmail(rs.getString("email"));
				organizacaoSocial.setDataInicio(rs.getString("dataInicio"));
				organizacaoSocial.setSituacao(rs.getString("situacao"));
				organizacaoSocial.setEndereco(rs.getString("enderecoOng"));
				
				return organizacaoSocial;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<OrganizacaoSocial> selecionarTodos(){
		String sql = "select id, nome, razaoSocial, cnpj, telefone, email, dataInicio, situacao, enderecoOng from OrganizacoesSociais";
		List<OrganizacaoSocial> lista = new ArrayList<>();
		
		try(PreparedStatement stm = con.prepareStatement(sql);){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				OrganizacaoSocial organizacaoSocial = new OrganizacaoSocial();
				organizacaoSocial.setId(rs.getInt("id"));
				organizacaoSocial.setNome(rs.getString("nome"));
				organizacaoSocial.setRazaoSocial(rs.getString("razaoSocial"));
				organizacaoSocial.setCnpj(rs.getString("cnpj"));
				organizacaoSocial.setTelefone(rs.getString("telefone"));
				organizacaoSocial.setEmail(rs.getString("email"));
				organizacaoSocial.setDataInicio(rs.getString("dataInicio"));
				organizacaoSocial.setSituacao(rs.getString("situacao"));
				organizacaoSocial.setEndereco(rs.getString("enderecoOng"));
				
				lista.add(organizacaoSocial);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void salvar(OrganizacaoSocial organizacaoSocial){
		if(organizacaoSocial.getId() != null && organizacaoSocial.getId() > 0){
			alterar(organizacaoSocial);
		}else{
			inserir(organizacaoSocial);
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
