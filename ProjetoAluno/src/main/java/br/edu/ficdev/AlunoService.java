package br.edu.ficdev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    // Método para retornar todos os alunos
    public List<Aluno> getAllAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        alunoRepository.findAll().forEach(alunos::add);
        return alunos;
    }

    // Método para retornar um aluno específico pelo ID
    public Optional<Aluno> getAluno(Long id) {
        return alunoRepository.findById(id);
    }

    // Método para adicionar um aluno
    public void addAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    // Método para atualizar um aluno
    public void updateAluno(Aluno aluno, Long id) {
        Optional<Aluno> optionalAluno = getAluno(id);
        if (optionalAluno.isPresent()) {
            aluno.setId(id);
            alunoRepository.save(aluno);
        }
    }

    // Método para deletar um aluno
    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
