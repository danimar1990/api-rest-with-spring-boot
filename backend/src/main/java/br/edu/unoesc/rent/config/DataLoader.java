package br.edu.unoesc.rent.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.edu.unoesc.rent.entities.Perfil;
import br.edu.unoesc.rent.entities.Usuario;
import br.edu.unoesc.rent.repositories.PerfilRepository;
import br.edu.unoesc.rent.repositories.UsuarioRepository;

@Component
public class DataLoader {

	private UsuarioRepository userRepository;
	private PerfilRepository perfilRepository;

	@Autowired
	public DataLoader(UsuarioRepository userRepository, PerfilRepository perfilRepository) {
		this.userRepository = userRepository;
		this.perfilRepository = perfilRepository;
		LoadPerfils();
		LoadUsers();
	}

	private void LoadUsers() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Set<Perfil> perfils = new HashSet<Perfil>();
		perfils.add(perfilRepository.getOne(Long.valueOf(1L)));
		userRepository.save(new Usuario(Long.valueOf(1L), "Administrador", "admin", encoder.encode("admin"), perfils));
	}

	private void LoadPerfils() {
		perfilRepository.save(new Perfil(Long.valueOf(1L), "ADMIN"));
		perfilRepository.save(new Perfil(Long.valueOf(2L), "USER"));
		perfilRepository.save(new Perfil(Long.valueOf(3L), "GUEST"));
	}
}
