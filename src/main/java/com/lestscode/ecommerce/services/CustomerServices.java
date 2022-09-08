package com.lestscode.ecommerce.services;

import com.lestscode.ecommerce.models.customer.Customer;
import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.models.forms.AtualizarCustomerForm;
import com.lestscode.ecommerce.models.forms.CustomerForm;
import com.lestscode.ecommerce.repositories.CustomerRepository;
import com.lestscode.ecommerce.repositories.OrderRepository;
import com.lestscode.ecommerce.services.interfaces.ICustomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServices implements ICustomeService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<CustomerDto> listAll() {

        return customerRepository.findAll()
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());


    }

    @Override
    public CustomerDto getById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            return new CustomerDto(customer.get());
        }
        return null;
    }

    @Override
    @Transactional
    public CustomerDto create(CustomerForm form) {
        Customer customer = new Customer(form);
        customerRepository.save(customer);
        return new CustomerDto(customer);

    }

    @Override
    @Transactional
    public CustomerDto update(Long id, AtualizarCustomerForm form) {
        Customer customer = customerRepository.findById(id).get();
        if (form.getName() != null) {
            customer.setName(form.getName());
        }
        if (form.getCpf() != null) {
            customer.setCpf(form.getCpf());
        }
        if (form.getDdd() != null && form.getPhoneNumber() != null) {
            customer.setPhone(form.getDdd()+form.getPhoneNumber());
        }
        if (form.getEmailAddress() != null) {
            customer.setEmail(form.getEmailAddress());
        }
        if (form.getCep() != null &&
                form.getLogadouro() != null  &&
                form.getBairro() != null  &&
                form.getUf() != null &&
                form.getCidade() != null &&
                form.getNumero() != null) {
            customer.setAddress(form.getLogadouro()+", "+form.getNumero()+" - "+", "+form.getBairro()+", "+form.getCidade()+", "+form.getUf()+", "+form.getCep());
        }



        return new CustomerDto(customer);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteByCustomer_Id(id);
        customerRepository.removeById(id);

    }
}

