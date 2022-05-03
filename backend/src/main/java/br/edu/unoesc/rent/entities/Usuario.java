package br.edu.unoesc.rent.entities;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.edu.unoesc.rent.dto.PerfilDTO;
import br.edu.unoesc.rent.dto.UsuarioDTO;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String usuario;
	private String senha;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "users_perfil", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Perfil> perfils = new HashSet<>();

	public Usuario(Long id, String nome, String usuario, String senha, Set<Perfil> perfils) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.perfils = perfils;
	}

	public Usuario() {
	}

	public Boolean isUser() {
		Boolean result = false;
		for (Perfil perfil : perfils) {
			result = perfil.getTipo().equals("USER");
		}
		return result;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UsuarioDTO toUsuarioDTO() {
		UsuarioDTO userDTO = new UsuarioDTO();
		userDTO.setUsuario(usuario);
		userDTO.setNome(nome);
		userDTO.setSenha(senha);
		userDTO.setId(id);
		userDTO.setPerfilsDTO(prepararSetPerfilsDTO());
		return userDTO;
	}

	Set<PerfilDTO> prepararSetPerfilsDTO() {
		Set<PerfilDTO> perfilsDTO = new HashSet<PerfilDTO>();
		for (Perfil perfil : this.perfils) {
			perfilsDTO.add(perfil.toPerfilDTO());
		}
		return perfilsDTO;
	}

	public Set<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(Set<Perfil> perfil) {
		this.perfils = perfil;
	}

	public void setPerfils(Optional<Perfil> perfil) {
		perfils.add(perfil.get());
	}

}
