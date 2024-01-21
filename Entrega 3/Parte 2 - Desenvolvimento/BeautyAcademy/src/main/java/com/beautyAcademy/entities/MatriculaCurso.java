package com.beautyAcademy.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MatriculaCurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idMatriculaCurso;

	@ManyToOne
	@JoinColumn(name = "matriculaAluno")
	private Aluno aluno; // Alterado para o tipo da entidade Aluno

	@ManyToOne
	@JoinColumn(name = "idCurso")
	private Curso curso; // Alterado para o tipo da entidade Curso

	public MatriculaCurso() {
	}

	public MatriculaCurso(int idMatriculaCurso, Aluno aluno, Curso curso) {
		this.idMatriculaCurso = idMatriculaCurso;
		this.aluno = aluno;
		this.curso = curso;
	}

	public int getIdMatriculaCurso() {
		return idMatriculaCurso;
	}

	public void setIdMatriculaCurso(int idMatriculaCurso) {
		this.idMatriculaCurso = idMatriculaCurso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMatriculaCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaCurso other = (MatriculaCurso) obj;
		return idMatriculaCurso == other.idMatriculaCurso;
	}

}
