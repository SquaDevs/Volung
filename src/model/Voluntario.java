package model;

import java.util.ArrayList;

public class Voluntario extends Usuario{
	
	private String endereco;
	private String genero;
	private String estadoCivil;
	private ArrayList<HorarioDisponivel> listaDeHorarios;
	private ArrayList<Area> listaDeAreas;
	private ArrayList<Atuacao> listaDeAtuacao;
	private String situacao;
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public ArrayList<HorarioDisponivel> getListaDeHorarios() {
		return listaDeHorarios;
	}
	
	public void setListaDeHorarios(ArrayList<HorarioDisponivel> listaDeHorarios) {
		this.listaDeHorarios = listaDeHorarios;
	}
	
	public ArrayList<Area> getListaDeAreas() {
		return listaDeAreas;
	}
	
	public void setListaDeAreas(ArrayList<Area> listaDeAreas) {
		this.listaDeAreas = listaDeAreas;
	}
	
	public ArrayList<Atuacao> getListaDeAtuacao() {
		return listaDeAtuacao;
	}
	
	public void setListaDeAtuacao(ArrayList<Atuacao> listaDeAtuacao) {
		this.listaDeAtuacao = listaDeAtuacao;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((listaDeAreas == null) ? 0 : listaDeAreas.hashCode());
		result = prime * result + ((listaDeAtuacao == null) ? 0 : listaDeAtuacao.hashCode());
		result = prime * result + ((listaDeHorarios == null) ? 0 : listaDeHorarios.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voluntario other = (Voluntario) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (listaDeAreas == null) {
			if (other.listaDeAreas != null)
				return false;
		} else if (!listaDeAreas.equals(other.listaDeAreas))
			return false;
		if (listaDeAtuacao == null) {
			if (other.listaDeAtuacao != null)
				return false;
		} else if (!listaDeAtuacao.equals(other.listaDeAtuacao))
			return false;
		if (listaDeHorarios == null) {
			if (other.listaDeHorarios != null)
				return false;
		} else if (!listaDeHorarios.equals(other.listaDeHorarios))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voluntario["+super.toString() +", endereco=" + endereco + ", genero=" + genero + ", estadoCivil=" + estadoCivil
				+ ", listaDeHorarios=" + listaDeHorarios + ", listaDeAreas=" + listaDeAreas + ", listaDeAtuacao="
				+ listaDeAtuacao + ", situacao=" + situacao + "]";
	}
}
