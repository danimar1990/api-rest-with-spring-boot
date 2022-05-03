package br.edu.unoesc.rent.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecuredPasswordGenerator {
	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "rentcar";
		String encodedPassword = encoder.encode(rawPassword);

		System.out.println(encodedPassword);
	}
}
