package model;

public class Gestor extends Usuario{	
	
	private OrganizacaoSocial ong;

	public OrganizacaoSocial getOng() {
		return ong;
	}

	public void setOng(OrganizacaoSocial ong) {
		this.ong = ong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ong == null) ? 0 : ong.hashCode());
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
		Gestor other = (Gestor) obj;
		if (ong == null) {
			if (other.ong != null)
				return false;
		} else if (!ong.equals(other.ong))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gestor["+super.toString() +", ong=" + ong + "]";
	}
	
	
}
