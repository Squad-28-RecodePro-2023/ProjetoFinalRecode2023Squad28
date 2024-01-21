package com.beautyAcademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beautyAcademy.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
