package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.CustomerDto;

import java.util.List;

public interface ICustomeService {

    List<CustomerDto> listAll();
}
