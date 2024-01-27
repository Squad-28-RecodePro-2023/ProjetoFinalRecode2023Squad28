package com.beautyAcademy.controller;

import com.beautyAcademy.entities.Aluno;
import com.beautyAcademy.entities.Cargo;
import com.beautyAcademy.services.AlunoService;
import com.beautyAcademy.services.CargoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlunoController {

	private final AlunoService alunoService;

	@Autowired
	private CargoService cargoService; // Certifique-se de ter um serviço para cargos

	@GetMapping("/obter-cargos")
	@ResponseBody
	public List<Cargo> obterCargos() {
		return cargoService.getAllCargos();
	}

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/Aluno.html")
	public String aluno(Model model) {
		List<Aluno> alunos = alunoService.listarTodosAlunos();
		List<Cargo> cargos = cargoService.getAllCargos();
		model.addAttribute("alunos", alunos);
		model.addAttribute("cargos", cargos);
		return "Aluno.html";
	}

	@PostMapping("/cadastrar-aluno")
	public String cadastrarAluno(Aluno aluno, Model model) {
		Aluno alunoCadastrado = alunoService.cadastrarAluno(aluno);
		model.addAttribute("aluno", alunoCadastrado);
		return "redirect:/Aluno.html?sucesso=true"; // Redireciona para a página "Aluno.html" com o parâmetro de sucesso
	}

	@DeleteMapping("/excluir-aluno/{matricula}")
	public ResponseEntity<Void> excluirAluno(@PathVariable int matricula) {
		alunoService.excluirAluno(matricula);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/editar-aluno/{matricula}")
	@ResponseBody
	public Aluno obterAlunoParaEdicao(@PathVariable int matricula) {
		return alunoService.buscarPorMatricula(matricula).orElseThrow();
	}

}
