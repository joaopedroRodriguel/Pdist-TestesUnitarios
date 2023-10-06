package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void NaoPodeCadastrarAlunoComMesmaMatricula(){
        Aluno alunonovo = new Aluno(1, "Gustavo", 30, "22334455667", "6655");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("22334455667");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunonovo));

    }

    @Test
    public void NaoPodeCadastrarAlunoComMesmoCPF(){
        Aluno alunonovo = new Aluno(1, "Gustavo", 30, "22334455667", "6655");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("6655");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunonovo));
    }

    @Test void NaoPodeCadastrarAlunoMenorIdade(){
        Aluno alunonovo = new Aluno(1, "Gustavo", 17, "22334455667", "6655");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunonovo));
    }
}
