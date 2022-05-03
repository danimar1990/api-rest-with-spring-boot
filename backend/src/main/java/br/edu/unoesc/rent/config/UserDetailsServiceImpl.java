package br.edu.unoesc.rent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.unoesc.rent.entities.Usuario;
import br.edu.unoesc.rent.repositories.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsuario(usuario);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}

		return new MyUserDetails(user);
	}

}
