package com.security.br.controllers;

import com.security.br.models.PessoaModel;
import com.security.br.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController // cria a camada de controle onde seram passadas todas as rotas da API
@RequestMapping("/pessoas") // cria um endpoint para a API
public class PessoaController {

    @Autowired // injeta dependências
    private PessoaService pessoaService;

    //POST cria uma pessoa
    @PostMapping
    public ResponseEntity<PessoaModel> criarPessoa(@RequestBody PessoaModel pessoaModel){
        PessoaModel request = pessoaService.criarPessoa(pessoaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("id")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET lista uma pessoa
    @GetMapping
    public ResponseEntity<List<PessoaModel>> findAll(){
        List<PessoaModel> list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id} busca uma pessoa pelo id
    @GetMapping("{id}")
    public PessoaModel buscarPessoa(@PathVariable Long id){
        return pessoaService.buscarPessoa(id);
    }

    //PUT modifica uma pessoa
    @PutMapping
    public PessoaModel atualizarPessoa(@PathVariable Long id, @RequestBody PessoaModel pessoaModel) {
        return pessoaService.atualizarPessoa(id, pessoaModel);
    }

    //DELETE {id} deleta a pessoa pelo id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

}
