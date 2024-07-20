package com.serb.projectapp.Categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    /*** Inserir */
    public CategoriaModel Inserir(CategoriaModel categoria) {
        if( categoria.getNome() == null ){
            throw new IllegalArgumentException("Nome da categoria é obrigatório");
        }else if( categoria.getDescricao() == null ){
            throw new IllegalArgumentException("Descrição da categoria é obrigatório");
        }
        CategoriaModel servicoBanco = categoriaRepository.saveAndFlush(categoria);
        return servicoBanco;
    }

    /*** Listar Todos */
    public List<CategoriaModel> ListarTodos(){
        return categoriaRepository.findAll();
    }

    /*** Listar por ID */
    public CategoriaModel ListarById(long id){
        return categoriaRepository.findById(id).get();
    }

    /*** Alterar */
    public CategoriaModel Alterar(CategoriaModel categoria){
        if( categoria.getId() <= 0){
            throw new IllegalArgumentException("ID da categoria é obrigatório");
        }
        return categoriaRepository.saveAndFlush(categoria);
    }
    
    /*** Excluir */
    public void Excluir(long id){
        categoriaRepository.deleteById(id);
    }
    
}
