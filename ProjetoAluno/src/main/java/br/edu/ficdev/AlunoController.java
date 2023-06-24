package br.edu.ficdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    // Endpoint para retornar todos os alunos
    @GetMapping("/alunos")
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    // Endpoint para retornar um aluno pelo ID
    @GetMapping("/alunos/{id}")
    public Optional<Aluno> getAluno(@PathVariable Long id) {
        return alunoService.getAluno(id);
    }

    // Endpoint para adicionar um novo aluno
    @PostMapping("/alunos")
    public void addAluno(@RequestBody Aluno aluno) {
        alunoService.addAluno(aluno);
    }

    // Endpoint para atualizar um aluno existente
    @PutMapping("/alunos/{id}")
    public void updateAluno(@RequestBody Aluno aluno, @PathVariable Long id) {
        alunoService.updateAluno(aluno, id);
    }

    // Endpoint para deletar um aluno
    @DeleteMapping("/alunos/{id}")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }
}
