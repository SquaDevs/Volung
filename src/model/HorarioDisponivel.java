package model;

public class HorarioDisponivel {
	
	private Integer id;
	private Voluntario voluntario;
	private String diaSemana;
	private String turno;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Voluntario getVoluntario() {
		return voluntario;
	}
	
	public void setVoluntario(Voluntario voluntario) {
		this.voluntario = voluntario;
	}
	
	public String getDiaSemana() {
		return diaSemana;
	}
	
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
