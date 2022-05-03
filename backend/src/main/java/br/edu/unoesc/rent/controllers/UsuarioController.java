package br.edu.unoesc.rent.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.rent.dto.UsuarioDTO;
import br.edu.unoesc.rent.entities.Perfil;
import br.edu.unoesc.rent.entities.Usuario;
import br.edu.unoesc.rent.repositories.PerfilRepository;
import br.edu.unoesc.rent.repositories.UsuarioRepository;
import br.edu.unoesc.rent.services.UsuarioService;

@Controller
@RequestMapping("user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	UsuarioService usuarioService;

	@GetMapping("new")
	public String user_cad(UsuarioDTO userDTO, Model model, BindingResult result) {
		List<Perfil> listaPerfils = perfilRepository.findAll();

		model.addAttribute("listaPerfils", listaPerfils);
		return "user/form";
	}

	@GetMapping("/{id}")
	public String user_cad_edicao(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "Error registering user!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		Usuario user = userRepository.getOne(id);
		model.addAttribute("usuarioDTO", user.toUsuarioDTO());
		List<Perfil> listaPerfils = perfilRepository.findAll();
		model.addAttribute("listaPerfils", listaPerfils);
		redirectAttributes.addFlashAttribute("message", "User successfully changed!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "/user/form";
	}

	@PostMapping("/create")
	public String novo(@Valid UsuarioDTO userDTO, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {
		redirectAttributes.addFlashAttribute("message", "Error registering user!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		redirectAttributes.addFlashAttribute(userDTO);
		if (result.hasErrors()) {
			List<Perfil> listaPerfils = perfilRepository.findAll();
			model.addAttribute("listaPerfils", listaPerfils);
			model.addAttribute("userDTO", userDTO);
			return "user/form";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCriptografada = encoder.encode(userDTO.getSenha());
		userDTO.setSenha(senhaCriptografada);

		Usuario user = userDTO.toUsuario();
		Optional<Perfil> perfil;
		if (userDTO.getId_perfil() > 0) {
			perfil = perfilRepository.findById(Long.valueOf(userDTO.getId_perfil()));
		} else {
			perfil = perfilRepository.findById(Long.valueOf(3L));
		}
		user.setPerfils(perfil);
		String opcao = userDTO.getId() == null ? "created" : "updated";
		redirectAttributes.addFlashAttribute("message", "User " + opcao + " successfully!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		userRepository.save(user);
		redirectAttributes.addFlashAttribute(user.toUsuarioDTO());

		if (usuarioService.userIsAnonymous()) {
			redirectAttributes.addFlashAttribute("message", "User created successfully!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			return "redirect:/login";
		}
		return "redirect:/users/";
	}

	@GetMapping("/list")
	public String listarUsuarios(Model model) {
		List<Usuario> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "user/list";
	}

	@GetMapping("/delete/{id}")
	public String excluirUsuario(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message", "User removed sucessfully!");
		userRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		return "redirect:/user/list";
	}

}