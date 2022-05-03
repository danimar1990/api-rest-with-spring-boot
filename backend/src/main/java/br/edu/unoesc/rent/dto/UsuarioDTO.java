package br.edu.unoesc.rent.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import br.edu.unoesc.rent.entities.Perfil;
import br.edu.unoesc.rent.entities.Usuario;

public class UsuarioDTO {

	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	private String usuario;
	@NotBlank(message = "A senha é obrigatória")
	private String senha;

	private Set<PerfilDTO> perfilsDTO;

	private PerfilDTO perfilDTO;

	private int id_perfil;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario toUsuario() {
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setNome(nome);
		user.setSenha(senha);
		user.setId(id);
		return user;
	}

	Set<Perfil> prepararSetPerfils() {
		Set<Perfil> perfils = new HashSet<Perfil>();
		perfils.add(perfilDTO.toPerfil());
		return perfils;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<PerfilDTO> getPerfilsDTO() {
		return perfilsDTO;
	}

	public void setPerfilsDTO(Set<PerfilDTO> perfils) {
		this.perfilsDTO = perfils;
		for (PerfilDTO p : perfilsDTO) {
			this.id_perfil = (int) (long) p.getId();
		}
	}

	public PerfilDTO getPerfilDTO() {
		return perfilDTO;
	}

	public void setPerfilDTO(PerfilDTO perfilDTO) {
		this.perfilDTO = perfilDTO;
	}

	public int getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}

}
