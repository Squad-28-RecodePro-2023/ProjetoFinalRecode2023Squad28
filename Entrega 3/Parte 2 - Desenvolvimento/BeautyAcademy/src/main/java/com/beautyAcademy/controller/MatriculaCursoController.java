package com.beautyAcademy.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beautyAcademy.entities.Aluno;
import com.beautyAcademy.entities.Curso;
import com.beautyAcademy.entities.MatriculaCurso;
import com.beautyAcademy.services.AlunoService;
import com.beautyAcademy.services.CursoService;
import com.beautyAcademy.services.MatriculaCursoService;

@Controller
public class MatriculaCursoController {

	private final MatriculaCursoService matriculaCursoService;

	@Autowired
	private AlunoService alunoService; // Certifique-se de ter um serviço para alunos
	@Autowired
	private CursoService cursoService; // Certifique-se de ter um serviço para cursos

	@GetMapping("/obter-matriculas-aluno")
	@ResponseBody
	public List<String> obterMatriculasAluno() {
		List<Aluno> alunos = alunoService.listarTodosAlunos();
		List<String> matriculas = alunos.stream().map(aluno -> String.valueOf(aluno.getMatricula()))
				.collect(Collectors.toList());
		return matriculas;
	}

	@GetMapping("/obter-ids-cursos")
	@ResponseBody
	public List<Integer> obterIdsCursos() {
		List<Curso> cursos = cursoService.listarTodosCursos(); // Substitua pelo método correto do seu serviço
		List<Integer> idsCursos = cursos.stream().map(curso -> curso.getIdCurso()).collect(Collectors.toList());
		return idsCursos;
	}

	@Autowired
	public MatriculaCursoController(MatriculaCursoService matriculaCursoService) {
		this.matriculaCursoService = matriculaCursoService;
	}

	@GetMapping("/MatriculaCurso.html")
	public String matriculaCurso(Model model) {
		List<MatriculaCurso> matriculaCurso = matriculaCursoService.listarTodasMatriculasCursos();
		List<Aluno> alunos = alunoService.listarTodosAlunos();
		List<Curso> cursos = cursoService.listarTodosCursos();
		model.addAttribute("matriculaCurso", matriculaCurso);
		model.addAttribute("alunos", alunos);
		model.addAttribute("cursos", cursos);

		return "MatriculaCurso.html";
	}

	@PostMapping("/cadastrar-matriculacurso")
	public String cadastrarMatriculaCurso(@ModelAttribute("matriculacurso") MatriculaCurso matriculacurso,
			Model model) {
		MatriculaCurso matriculacursoCadastrado = matriculaCursoService.cadastrarMatriculaCurso(matriculacurso);
		model.addAttribute("matriculacurso", matriculacursoCadastrado);
		return "redirect:/MatriculaCurso.html?sucesso=true";
	}

	@DeleteMapping("/excluirmatriculacurso/{idMatriculaCurso}")
	public ResponseEntity<Void> excluirMatriculaCurso(@PathVariable int idMatriculaCurso) {
		matriculaCursoService.excluirMatriculaCurso(idMatriculaCurso);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/editar-matriculacurso/{idMatriculaCurso}")
	@ResponseBody
	public MatriculaCurso obterMatriculaCursoParaEdicao(@PathVariable int idMatriculaCurso) {
		return matriculaCursoService.buscarPorId(idMatriculaCurso).orElseThrow();
	}

	@GetMapping("/obter-matriculas-cursos")
	@ResponseBody
	public List<MatriculaCurso> obterMatriculasCursos() {
		return matriculaCursoService.listarTodasMatriculasCursos();
	}
}
