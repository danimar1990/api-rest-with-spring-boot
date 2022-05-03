package br.edu.unoesc.rent.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD:backend/src/main/java/br/edu/unoesc/rent/config/WebSecurityConfig.java
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
=======
import org.springframework.core.env.Environment;
>>>>>>> 02c77975d692d6960e72b23c6ac1020e7c1d45eb:backend/src/main/java/br/edu/unoesc/rent/config/SecurityConfig.java
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
<<<<<<< HEAD:backend/src/main/java/br/edu/unoesc/rent/config/WebSecurityConfig.java
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
>>>>>>> 02c77975d692d6960e72b23c6ac1020e7c1d45eb:backend/src/main/java/br/edu/unoesc/rent/config/SecurityConfig.java
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
<<<<<<< HEAD:backend/src/main/java/br/edu/unoesc/rent/config/WebSecurityConfig.java

		http.headers().frameOptions().disable();

		http
			.authorizeRequests()
				//.antMatchers("/cars").hasAnyAuthority("ADMIN", "USER")
				.antMatchers("/**").permitAll();
					
		http
			.formLogin()
			.loginPage("/login")
			.usernameParameter("usuario")
			.passwordParameter("senha")
			.defaultSuccessUrl("/").permitAll()
			.and()
			.logout().permitAll()
			.and()
		      .httpBasic();
=======
		//http.authorizeRequests().anyRequest().permitAll();
		http.headers().frameOptions().disable();
        http
	        .csrf().disable()
	        .authorizeRequests()
		        .antMatchers("/admin/**").hasRole("ADMIN")
		        .antMatchers("/anonymous*").anonymous()
		        .antMatchers("/login*", "/**").permitAll()
		        .anyRequest().authenticated()
	        .and()
		        .formLogin()
			        .loginPage("/login.html")
			        .loginProcessingUrl("/perform_login")
			        .defaultSuccessUrl("/home.html", true)
	        .and()
		        .logout()
			        .logoutUrl("/perform_logout")
			        .deleteCookies("JSESSIONID");
	}
	
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
	        .and()
	        .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
>>>>>>> 02c77975d692d6960e72b23c6ac1020e7c1d45eb:backend/src/main/java/br/edu/unoesc/rent/config/SecurityConfig.java
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
