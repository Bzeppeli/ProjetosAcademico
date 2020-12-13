package com.projetosAcademicos.domain.Service;

import com.projetosAcademicos.domain.Projeto;
import com.projetosAcademicos.domain.dto.ProjetoDTO;
import com.projetosAcademicos.domain.Repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoDTO> getProjeto(){

        return projetoRepository.findAll().stream().map(ProjetoDTO::new).collect(Collectors.toList());
    }

    public Optional<Projeto> getProjetoById(Long id) {

        return projetoRepository.findById(id);
    }

    public Projeto cadastrarProjeto(Projeto projeto){

        return projetoRepository.save(projeto);
    }

    public Projeto atualizarProjeto(Projeto projeto, Long id){

        Optional<Projeto> projetoOptional = getProjetoById(id);

        if (projetoOptional.isPresent()){

            Projeto projetoBD = projetoOptional.get();

            projetoBD.setAluno(projeto.getAluno());
            projetoBD.setAreaProjeto(projeto.getAreaProjeto());
            projetoBD.setProfessorResponsavel(projeto.getProfessorResponsavel());
            projetoBD.setTitulo(projeto.getTitulo());
            projetoBD.setResumo(projeto.getResumo());
            projetoBD.setPalavraChave1(projeto.getPalavraChave1());
            projetoBD.setPalavraChave2(projeto.getPalavraChave2());
            projetoBD.setPalavraChave3(projeto.getPalavraChave3());
            projetoBD.setUrlDocumento(projeto.getUrlDocumento());

            projetoRepository.save(projetoBD);
            return projetoBD;

        }else {

            throw new RuntimeException("Não foi possivel Encontrar proejeto");

        }
    }

    public void removerProjeto(Long id){

        Optional<Projeto> optionalProjeto = getProjetoById(id);

        if (optionalProjeto.isPresent()){

            projetoRepository.deleteById(id);
        }
    }
}
