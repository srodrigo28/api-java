package com.serb.projectapp.Taxa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxaService {
    
    @Autowired
    private TaxaRepository taxaRepository;

    public TaxaModel inserir(TaxaModel taxa) {
        return taxaRepository.save(taxa);
    }

    public List<TaxaModel> listarTodos() {
        return taxaRepository.findAll();
    }

    public TaxaModel buscarPorId(Long id) {
        return taxaRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        taxaRepository.deleteById(id);
    }

    public TaxaModel atualizar(TaxaModel taxa) {
        return taxaRepository.save(taxa);
    }

}
