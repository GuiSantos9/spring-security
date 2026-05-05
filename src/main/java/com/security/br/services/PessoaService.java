package com.security.br.services;

import com.security.br.models.PessoaModel;
import com.security.br.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    //POST criar
    public PessoaModel criarPessoa(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    //GET listar
    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    //GET buscar por id
    public PessoaModel buscarPessoa(Long id){
        return pessoaRepository.findById(id).get();
    }

    //PUT atualizar
    public PessoaModel atualizarPessoa(Long id, PessoaModel pessoaModel){
        PessoaModel newPessoaModel = pessoaRepository.findById(id).get();
        newPessoaModel.setId(pessoaModel.getId());
        return pessoaRepository.save(newPessoaModel);
    }

    //DELETE deletar por id
    public void deletarPessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
