package com.beautyAcademy.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.beautyAcademy.services.UserDetailsServiceImpl;

import enums.Perfil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(authorizeConfig -> {
			authorizeConfig.requestMatchers("/", "/Home.html", "/QuemSomos.html", "/Manifesto.html", "/Contato.html",
					"/logout", "/css/**", "/js/**", "/images/**", "/plugins/**").permitAll();
			authorizeConfig.requestMatchers(HttpMethod.DELETE, "/excluir-aluno/{matricula}", "/excluir-curso/{idCurso}",
					"/excluirmatriculacurso/{idMatriculaCurso}").hasAuthority(Perfil.ADMIN.toString());
			authorizeConfig.requestMatchers(HttpMethod.POST, "/cadastrar-aluno", "/cadastrar-curso",
					"/cadastrar-matriculacurso").hasAuthority(Perfil.ADMIN.toString());
			authorizeConfig.requestMatchers(HttpMethod.GET, "/Aluno.html", "/editar-aluno/{matricula}", "/Curso.html",
					"/editar-curso/{idCurso}", "/obter-matriculas-aluno", "/obter-ids-cursos",
					"/MatriculaCurso.html", "/editar-matriculacurso/{idMatriculaCurso}", "/obter-matriculas-cursos")
					.hasAuthority(Perfil.ADMIN.toString());
			authorizeConfig.requestMatchers(HttpMethod.GET, "/PCursos.html", "/{idCurso}")
					.hasAnyAuthority(Perfil.USER.toString(), Perfil.ADMIN.toString());
			authorizeConfig.anyRequest().authenticated();
		}).formLogin(Customizer.withDefaults())
				.logout(logout -> logout
			            .logoutUrl("/logout")
			            .logoutSuccessUrl("/") // Redireciona para a página inicial após o logout
			        )
				.build();

	}
}