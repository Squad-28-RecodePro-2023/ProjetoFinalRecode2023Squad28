package com.beautyAcademy.services;

import com.beautyAcademy.entities.Aluno;
import com.beautyAcademy.repositories.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;

	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	// Operação de Criação (Create)
	public Aluno cadastrarAluno(Aluno aluno) {
		Aluno existsAluno = alunoRepository.findByEmail(aluno.getEmail());

		if (existsAluno != null) {
			throw new Error("Usuario não existe!");
		}

		aluno.setSenha(passwordEncoder().encode(aluno.getSenha()));

		Aluno createdAluno = alunoRepository.save(aluno);

		return createdAluno;
	}

	// Operação de Leitura (Read)
	public List<Aluno> listarTodosAlunos() {
		return alunoRepository.findAll();
	}

	public Optional<Aluno> buscarPorMatricula(int matricula) {
		return alunoRepository.findById(matricula);
	}

	// Operação de Atualização (Update)
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	// Operação de Exclusão (Delete)
	public void excluirAluno(int matricula) {
		alunoRepository.deleteById(matricula);
	}
}
