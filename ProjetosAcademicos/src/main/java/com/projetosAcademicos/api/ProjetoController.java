package com.projetosAcademicos.api;

import com.projetosAcademicos.domain.Projeto;
import com.projetosAcademicos.domain.dto.ProjetoDTO;
import com.projetosAcademicos.domain.Service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> get(){

        return ResponseEntity.ok(projetoService.getProjeto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> get(@PathVariable("id") Long id){

        Optional<Projeto> projeto = projetoService.getProjetoById(id);
        return projeto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String cadastrar(@RequestBody Projeto projeto){
        Projeto projetoCadastrado = projetoService.cadastrarProjeto(projeto);
        return "Projeto Salvo com Sucesso" + projetoCadastrado;
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable("id") Long id,@RequestBody Projeto projeto){
        Projeto projetoAtualizado = projetoService.atualizarProjeto(projeto, id);
        return "Projeto Atualizado com sucesso" + projetoAtualizado;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id){
        projetoService.removerProjeto(id);
        return "Projeto Removido com sucesso";
    }
}
