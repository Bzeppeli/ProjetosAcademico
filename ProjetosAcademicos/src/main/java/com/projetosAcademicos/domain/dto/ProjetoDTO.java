package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Professor;
import com.projetosAcademicos.domain.Projeto;
import lombok.Data;

import java.util.List;

@Data
public class ProjetoDTO {

    private Long id;
    private String titulo;
    private Professor professorResponsavel;
    private List<Aluno> aluno;
    private String areaProjeto;
    private String resumo;
    private String palavraChave1;
    private String palavraChave2;
    private String palavraChave3;
    private String urlDocumento;

    public ProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.titulo = projeto.getTitulo();
        this.professorResponsavel = projeto.getProfessorResponsavel();
        this.aluno = projeto.getAluno();
        this.areaProjeto = projeto.getAreaProjeto();
        this.resumo = projeto.getResumo();
        this.palavraChave1 = projeto.getPalavraChave1();
        this.palavraChave2 = projeto.getPalavraChave2();
        this.palavraChave3 = projeto.getPalavraChave3();
        this.urlDocumento = projeto.getUrlDocumento();
    }
}
