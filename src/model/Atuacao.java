package model;

public class Atuacao {
	
	private Integer id;
	private String dataInscricao;
	private String dataEncerremento;
	private String situacao;
	private Projeto projeto;
	private Voluntario voluntario;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataInscricao() {
		return dataInscricao;
	}
	
	public void setDataInscricao(String dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	
	public String getDataEncerremento() {
		return dataEncerremento;
	}
	
	public void setDataEncerremento(String dataEncerremento) {
		this.dataEncerremento = dataEncerremento;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Voluntario getVoluntario() {
		return voluntario;
	}
	
	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEncerremento == null) ? 0 : dataEncerremento.hashCode());
		result = prime * result + ((dataInscricao == null) ? 0 : dataInscricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((voluntario == null) ? 0 : voluntario.hashCode());
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
		Atuacao other = (Atuacao) obj;
		if (dataEncerremento == null) {
			if (other.dataEncerremento != null)
				return false;
		} else if (!dataEncerremento.equals(other.dataEncerremento))
			return false;
		if (dataInscricao == null) {
			if (other.dataInscricao != null)
				return false;
		} else if (!dataInscricao.equals(other.dataInscricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (voluntario == null) {
			if (other.voluntario != null)
				return false;
		} else if (!voluntario.equals(other.voluntario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atuacao [id=" + id + ", dataInscricao=" + dataInscricao + ", dataEncerremento=" + dataEncerremento
				+ ", situacao=" + situacao + ", \nprojeto=" + projeto + ", \nvoluntario=" + voluntario + "]";
	}
	
}
