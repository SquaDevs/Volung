package model;

public class Projeto {
	
	private Integer id;
	private String nome;
	private String descricao;
	private String datasTrabalhos;
	//private String periodoEscolha;
	//private Integer quantVoluntario;
	private Area area;
	private OrganizacaoSocial organizacaoSocial;
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDatasTrabalhos() {
		return datasTrabalhos;
	}
	
	public void setDatasTrabalhos(String datasTrabalhos) {
		this.datasTrabalhos = datasTrabalhos;
	}
	
	/*public String getPeriodoEscolha() {
		return periodoEscolha;
	}

	public void setPeriodoEscolha(String periodoEscolha) {
		this.periodoEscolha = periodoEscolha;
	}

	public Integer getQuantVoluntario() {
		return quantVoluntario;
	}

	public void setQuantVoluntario(Integer quantVoluntario) {
		this.quantVoluntario = quantVoluntario;
	}*/

	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	public OrganizacaoSocial getOrganizacaoSocial() {
		return organizacaoSocial;
	}
	
	public void setOrganizacaoSocial(OrganizacaoSocial organizacaoSocial) {
		this.organizacaoSocial = organizacaoSocial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((datasTrabalhos == null) ? 0 : datasTrabalhos.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((organizacaoSocial == null) ? 0 : organizacaoSocial.hashCode());
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
		Projeto other = (Projeto) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (datasTrabalhos == null) {
			if (other.datasTrabalhos != null)
				return false;
		} else if (!datasTrabalhos.equals(other.datasTrabalhos))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (organizacaoSocial == null) {
			if (other.organizacaoSocial != null)
				return false;
		} else if (!organizacaoSocial.equals(other.organizacaoSocial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", datasTrabalhos="
				+ datasTrabalhos + ", area=" + area + ", organizacaoSocial=" + organizacaoSocial + "]";
	}
	
	
}
