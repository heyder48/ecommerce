package com.lestscode.ecommerce.services;

import com.lestscode.ecommerce.models.dto.CategoriaDto;
import com.lestscode.ecommerce.models.forms.CategoriaForm;
import com.lestscode.ecommerce.models.product.Categoria;
import com.lestscode.ecommerce.repositories.CategoriaRepository;
import com.lestscode.ecommerce.services.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<CategoriaDto> listAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDto getById(Long id) {
        return new CategoriaDto(categoriaRepository.findById(id).get());
    }

    @Override
    @Transactional
    public CategoriaDto create(CategoriaForm form) {

        Categoria categoria = new Categoria(form);

        categoriaRepository.save(categoria);

        return new CategoriaDto(categoria);


    }

    @Override
    public CategoriaDto update(Long id, CategoriaForm form) {
        Categoria categoria = categoriaRepository.findById(id).get();

        if (form.getName() != null) {
            categoria.setName(form.getName());
        }


        return new CategoriaDto(categoria);
    }

    @Override
    public void delete(Long id) {

        categoriaRepository.deleteById(id);

    }
}
