package br.edu.unoesc.rent.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unoesc.rent.dto.PerfilDTO;

@Entity
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;

	public Perfil() {

	}

	public PerfilDTO toPerfilDTO() {
		PerfilDTO perfilDTO = new PerfilDTO();
		perfilDTO.setId(id);
		perfilDTO.setTipo(tipo);
		return perfilDTO;
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

	public Perfil(Long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

}
