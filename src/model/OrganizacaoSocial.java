package model;

import java.util.ArrayList;

public class OrganizacaoSocial {
	
	private Integer id;
	private String nome;
	private String razaoSocial;
	private String cnpj;
	private String endereco;
	private String telefone;
	private String email;
	private String dataInicio;
	private String situacao;
	private ArrayList<Gestor> listaDeGestores;
	private ArrayList<Projeto> listaDeProjetos;
	private ArrayList<Area> listaDeAreas;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public ArrayList<Gestor> getListaDeGestores() {
		return listaDeGestores;
	}
	
	public void setListaDeGestores(ArrayList<Gestor> listaDeGestores) {
		this.listaDeGestores = listaDeGestores;
	}
	
	public ArrayList<Projeto> getListaDeProjetos() {
		return listaDeProjetos;
	}
	
	public void setListaDeProjetos(ArrayList<Projeto> listaDeProjetos) {
		this.listaDeProjetos = listaDeProjetos;
	}
	
	public ArrayList<Area> getListaDeAreas() {
		return listaDeAreas;
	}
	
	public void setListaDeAreas(ArrayList<Area> listaDeAreas) {
		this.listaDeAreas = listaDeAreas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaDeAreas == null) ? 0 : listaDeAreas.hashCode());
		result = prime * result + ((listaDeGestores == null) ? 0 : listaDeGestores.hashCode());
		result = prime * result + ((listaDeProjetos == null) ? 0 : listaDeProjetos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizacaoSocial other = (OrganizacaoSocial) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaDeAreas == null) {
			if (other.listaDeAreas != null)
				return false;
		} else if (!listaDeAreas.equals(other.listaDeAreas))
			return false;
		if (listaDeGestores == null) {
			if (other.listaDeGestores != null)
				return false;
		} else if (!listaDeGestores.equals(other.listaDeGestores))
			return false;
		if (listaDeProjetos == null) {
			if (other.listaDeProjetos != null)
				return false;
		} else if (!listaDeProjetos.equals(other.listaDeProjetos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrganizacaoSocial [id=" + id + ", nome=" + nome + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", dataInicio="
				+ dataInicio + ", situacao=" + situacao + ", listaDeGestores=" + listaDeGestores + ", listaDeProjetos="
				+ listaDeProjetos + ", listaDeAreas=" + listaDeAreas + "]";
	}
	
	
}
