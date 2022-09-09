package com.lestscode.ecommerce.services;

import com.lestscode.ecommerce.models.customer.Customer;
import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.models.forms.AtualizarCustomerForm;
import com.lestscode.ecommerce.models.forms.CustomerForm;
import com.lestscode.ecommerce.models.forms.UpdatePasswordForm;
import com.lestscode.ecommerce.models.order.Order;
import com.lestscode.ecommerce.models.order.OrderItem;
import com.lestscode.ecommerce.repositories.CustomerRepository;
import com.lestscode.ecommerce.repositories.OrderItemRepository;
import com.lestscode.ecommerce.repositories.OrderRepository;
import com.lestscode.ecommerce.services.interfaces.ICustomeService;
import com.lestscode.ecommerce.utils.Utils;
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

    @Autowired
    private OrderItemRepository orderItemRepository;

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
        if (form.getName() != null && !form.getName().isEmpty()) {
            customer.setName(form.getName());
        }
        if (form.getCpf() != null && !form.getCpf().isEmpty()) {
            customer.setCpf(form.getCpf());
        }
        if (form.getDdd() != null  && !form.getDdd().isEmpty() ) {
            String phone = form.getDdd() + customer.getPhone().substring(2);
            customer.setPhone(phone);

        }

        if (form.getPhoneNumber() != null && !form.getPhoneNumber().isEmpty()) {
            String phone = customer.getPhone().substring(0, 2) + form.getPhoneNumber();
            customer.setPhone(phone);
        }
        if (form.getEmailAddress() != null && !form.getEmailAddress().isEmpty()) {
            customer.setEmail(form.getEmailAddress());
        }
        if (form.getLogadouro() != null && !form.getLogadouro().isEmpty()) {
            String newAddress = updateAddress(customer.getAddress(),form.getLogadouro(),0);
            customer.setAddress(newAddress);
        }

        if(form.getNumero() != null && !form.getNumero().isEmpty()){
            String newAddress = updateAddress(customer.getAddress(),form.getNumero(),1);
            customer.setAddress(newAddress);
        }

        if(form.getBairro() != null && !form.getBairro().isEmpty()){
            String newAddress = updateAddress(customer.getAddress(),form.getBairro(),2);
            customer.setAddress(newAddress);
        }

        if(form.getCidade() != null && !form.getCidade().isEmpty()){
            String newAddress = updateAddress(customer.getAddress(),form.getCidade(),3);
            customer.setAddress(newAddress);
        }

        if(form.getUf() != null && !form.getUf().isEmpty()){
            String newAddress = updateAddress(customer.getAddress(),form.getUf(),4);
            customer.setAddress(newAddress);
        }

        if(form.getCep() != null && !form.getCep().isEmpty()){
            String newAddress = updateAddress(customer.getAddress(),form.getCep(),5);
            customer.setAddress(newAddress);
        }



        return new CustomerDto(customer);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        List<Order> orders = orderRepository.findAllByCustomerId(id);
        for (Order order : orders) {
            List<OrderItem> orderItems = orderItemRepository.findAllByPkOrderId(order.getId());
            for (OrderItem orderItem : orderItems) {
                orderItemRepository.delete(orderItem);
            }

             orderRepository.delete(order);
        }
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            customerRepository.delete(customer.get());
        }



    }

    @Override
    @Transactional
    public Boolean updatePassword(Long id, UpdatePasswordForm form) {
        Customer customer = customerRepository.findById(id).get();
        if(Utils.criptografarSenha(form.getOldPassword()).equals(customer.getPassword())){
            if(form.getNewPassword().equals(form.getNewPasswordConfirm())){
                customer.setPassword(Utils.criptografarSenha(form.getNewPassword()));

                return true;

            }
        }

        return false;
    }

    private String updateAddress(String AtualAddress ,String newParam, int index){

        String[] address = AtualAddress.split(",");
        StringBuilder newAddress = new StringBuilder();

        for (int i = 0; i < address.length ; i++) {
            if(i == index){
                newAddress.append(newParam);
            }else{
                newAddress.append(address[i]);
            }
            if(i < address.length - 1){
                newAddress.append(",");
            }
        }
        return newAddress.toString();

    }

}

