package br.edu.unoesc.rent.dto;

import br.edu.unoesc.rent.entities.Perfil;

public class PerfilDTO {

	private Long id;
	private String tipo;

	public Perfil toPerfil() {
		Perfil perfil = new Perfil();
		perfil.setId(id);
		perfil.setTipo(tipo);
		return perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
