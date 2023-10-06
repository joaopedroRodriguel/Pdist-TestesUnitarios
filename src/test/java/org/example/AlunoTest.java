package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    @Test
    public void NaoDeveAlterarMatriculaInferior11Digitos(){
        Aluno aluno = new Aluno(1, "Gustavo", 30, "22334455667", "6655");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("121416"));
    }

    @Test
    public void NaoDeveAlterarMatriculaSeConterCaracterEspecial(){
        Aluno aluno = new Aluno(1, "Gustavo", 30, "22334455667", "6655");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("223344556#@"));
    }
}
