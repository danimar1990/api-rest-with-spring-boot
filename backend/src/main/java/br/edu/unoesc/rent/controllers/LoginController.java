package br.edu.unoesc.rent.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.unoesc.rent.dto.LoginDTO;
import br.edu.unoesc.rent.entities.Usuario;
import br.edu.unoesc.rent.repositories.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	private UsuarioRepository userRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String singIn(@Valid LoginDTO loginDTO, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "login";
		}
		String acesso = "";
		Usuario user = userRepository.findByUsuario(loginDTO.getUsuario());
		if (user != null) {
			if (user.getSenha().equals(loginDTO.getSenha())) {
				acesso = "redirect:/";
			} else {
				redirectAttributes.addFlashAttribute("message", "Check your password and try again!");
				redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
				redirectAttributes.addFlashAttribute(loginDTO);
				acesso = "redirect:/login";
			}
		} else {
			redirectAttributes.addFlashAttribute("message", "The user does not exist!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			redirectAttributes.addFlashAttribute(loginDTO);
			acesso = "redirect:/login";
		}
		return acesso;
	}

}
