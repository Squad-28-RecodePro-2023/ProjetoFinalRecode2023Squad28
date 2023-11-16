package com.beautyAcademy.services;

import com.beautyAcademy.entities.Curso;
import com.beautyAcademy.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // Operação de Criação (Create)
    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Operação de Leitura (Read)
    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(int idCurso) {
        return cursoRepository.findById(idCurso);
    }

    // Operação de Atualização (Update)
    public Curso atualizarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Operação de Exclusão (Delete)
    public void excluirCurso(int idCurso) {
        cursoRepository.deleteById(idCurso);
    }
}
