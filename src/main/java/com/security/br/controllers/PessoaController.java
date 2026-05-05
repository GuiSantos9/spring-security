package com.security.br.controllers;

import com.security.br.models.PessoaModel;
import com.security.br.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    //POST
    @PostMapping
    public ResponseEntity<PessoaModel> criarPessoa(@RequestBody PessoaModel pessoaModel){
        PessoaModel request = pessoaService.criarPessoa(pessoaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("id")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<PessoaModel>> findAll(){
        List<PessoaModel> list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //GET {id}
    @GetMapping("{id}")
    public PessoaModel buscarPessoa(@PathVariable Long id){
        return pessoaService.buscarPessoa(id);
    }

    //PUT
    @PutMapping
    public PessoaModel atualizarPessoa(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        return pessoaService.atualizarPessoa(id, produtoModel);
    }

    //DELETE {id}
    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

}
