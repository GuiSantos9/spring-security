package com.security.br.services;

import com.security.br.models.PessoaModel;
import com.security.br.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // cria uma camada de serviços que definem as regras de negócio
public class PessoaService {

    @Autowired // injeta dependencias
    private PessoaRepository pessoaRepository;

    //POST molda a função de criação de pessoas
    public PessoaModel criarPessoa(PessoaModel pessoaModel){
        return pessoaRepository.save(pessoaModel);
    }

    //GET molda a função de listagem de pessoas
    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    //GET molda a função de buscar por id de pessoas
    public PessoaModel buscarPessoa(Long id){
        return pessoaRepository.findById(id).get();
    }

    //PUT molda a função de modificação de pessoas
    public PessoaModel atualizarPessoa(Long id, PessoaModel pessoaModel){
        PessoaModel newPessoaModel = pessoaRepository.findById(id).get();
        newPessoaModel.setId(pessoaModel.getId());
        return pessoaRepository.save(newPessoaModel);
    }

    //DELETE molda a função de deletar por id de pessoas
    public void deletarPessoa(Long id){
        pessoaRepository.deleteById(id);
    }

}
