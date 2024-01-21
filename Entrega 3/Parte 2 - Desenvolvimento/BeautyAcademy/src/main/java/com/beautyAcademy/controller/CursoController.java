package com.beautyAcademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beautyAcademy.entities.Curso;
import com.beautyAcademy.services.CursoService;

@Controller
public class CursoController {

    private final CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/Curso.html")
    public String curso(Model model) {
        List<Curso> cursos = cursoService.listarTodosCursos();
        model.addAttribute("cursos", cursos);
        return "Curso.html";
    }
    
    @GetMapping("/PCursos.html")
    public String pcurso(Model model) {
        List<Curso> cursos = cursoService.listarTodosCursos();
        model.addAttribute("cursos", cursos);
        return "PCursos.html";
    }

    @PostMapping("/cadastrar-curso")
    public String cadastrarCurso(Curso curso, Model model) {
        Curso cursoCadastrado = cursoService.cadastrarCurso(curso);
        model.addAttribute("curso", cursoCadastrado);
        return "redirect:/Curso.html?sucesso=true"; // Redireciona para a página "Curso.html" com o parâmetro de sucesso
    }

    @DeleteMapping("/excluir-curso/{idCurso}")
    public ResponseEntity<Void> excluirCurso(@PathVariable int idCurso) {
        cursoService.excluirCurso(idCurso);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/editar-curso/{idCurso}")
    @ResponseBody
    public Curso obterCursoParaEdicao(@PathVariable int idCurso) {
        return cursoService.buscarPorId(idCurso).orElseThrow();
    }
    
    @GetMapping("/{idCurso}")
    public String cursos(@PathVariable Long idCurso) {
        // Retorne o nome da página HTML correspondente ao ID do curso
        return "/cursos/" + idCurso + ".html";
    }
}
