package com.beautyAcademy.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import enums.Perfil;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Aluno aluno;

	public UserDetailsImpl(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Perfil perfil = aluno.getCargo().getNome().equals("ADMIN") ? Perfil.ADMIN : Perfil.USER;

		return AuthorityUtils.createAuthorityList(perfil.toString());
	}

	@Override
	public String getPassword() {
		return aluno.getSenha();
	}

	@Override
	public String getUsername() {
		return aluno.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
