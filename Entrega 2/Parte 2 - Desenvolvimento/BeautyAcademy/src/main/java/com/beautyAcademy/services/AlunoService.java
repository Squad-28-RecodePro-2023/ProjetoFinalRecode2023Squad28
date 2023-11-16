package com.beautyAcademy.services;

import com.beautyAcademy.entities.Aluno;
import com.beautyAcademy.repositories.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

	@Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Operação de Criação (Create)
    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
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
