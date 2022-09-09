package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.models.forms.AtualizarCustomerForm;
import com.lestscode.ecommerce.models.forms.CustomerForm;
import com.lestscode.ecommerce.models.forms.UpdatePasswordForm;

import java.util.List;

public interface ICustomeService {

    List<CustomerDto> listAll();

    CustomerDto getById(Long id);

    CustomerDto create(CustomerForm form);

    CustomerDto update(Long id, AtualizarCustomerForm form);

    void delete(Long id);

    Boolean updatePassword(Long id, UpdatePasswordForm form);
}
