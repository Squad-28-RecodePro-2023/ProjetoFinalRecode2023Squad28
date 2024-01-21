package com.beautyAcademy.services;

import com.beautyAcademy.entities.MatriculaCurso;
import com.beautyAcademy.repositories.MatriculaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaCursoService {

	private final MatriculaCursoRepository matriculaCursoRepository;

	@Autowired
	public MatriculaCursoService(MatriculaCursoRepository matriculaCursoRepository) {
		this.matriculaCursoRepository = matriculaCursoRepository;
	}

	// Operação de Criação (Create)
	public MatriculaCurso cadastrarMatriculaCurso(MatriculaCurso matriculaCurso) {
		return matriculaCursoRepository.save(matriculaCurso);
	}

	// Operação de Leitura (Read)
	public List<MatriculaCurso> listarTodasMatriculasCursos() {
		return matriculaCursoRepository.findAll();
	}

	public Optional<MatriculaCurso> buscarPorId(int idMatriculaCurso) {
		return matriculaCursoRepository.findById(idMatriculaCurso);
	}

	// Operação de Atualização (Update)
	public MatriculaCurso atualizarMatriculaCurso(MatriculaCurso matriculaCurso) {
		return matriculaCursoRepository.save(matriculaCurso);
	}

	// Operação de Exclusão (Delete)
	public void excluirMatriculaCurso(int idMatriculaCurso) {
		matriculaCursoRepository.deleteById(idMatriculaCurso);
	}
}
