package com.beautyAcademy.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int matricula;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private long celular;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCargo", nullable = false)
	private Cargo cargo;

	public Aluno() {
	}

	public Aluno(int matricula, String email, String senha, String nome, long celular, Cargo cargo) {
		this.matricula = matricula;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.celular = celular;
		this.cargo = cargo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return matricula == other.matricula;
	}

}
