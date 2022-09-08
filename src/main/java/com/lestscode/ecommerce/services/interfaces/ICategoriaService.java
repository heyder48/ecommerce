package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.CategoriaDto;
import com.lestscode.ecommerce.models.forms.CategoriaForm;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaDto> listAll();
    CategoriaDto getById(Long id);
    CategoriaDto create(CategoriaForm form);
    CategoriaDto update(Long id, CategoriaForm form);
    void delete(Long id);
}
