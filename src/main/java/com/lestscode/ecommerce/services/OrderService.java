package com.lestscode.ecommerce.services;

import com.lestscode.ecommerce.models.customer.Customer;
import com.lestscode.ecommerce.models.dto.OrderDto;
import com.lestscode.ecommerce.models.forms.OrderForm;
import com.lestscode.ecommerce.models.forms.OrderItemForm;
import com.lestscode.ecommerce.models.forms.UpdateOrderForm;
import com.lestscode.ecommerce.models.order.Order;
import com.lestscode.ecommerce.models.order.OrderItem;
import com.lestscode.ecommerce.models.product.Product;
import com.lestscode.ecommerce.repositories.CustomerRepository;
import com.lestscode.ecommerce.repositories.OrderItemRepository;
import com.lestscode.ecommerce.repositories.OrderRepository;
import com.lestscode.ecommerce.services.interfaces.IOrderService;
import com.lestscode.ecommerce.services.interfaces.IProductService;
import com.lestscode.ecommerce.utils.OrderStatusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private IProductService productService;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<OrderDto> listAll() {
        orderRepository.findAll().forEach(o ->{
            System.out.println(o.getItems());
        });
        return orderRepository.findAll()
                .stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto create(OrderForm form) {

        List<OrderItem> orderItems = form.getItems()
                .stream()
                .map(this::createOrderItem)
                .collect(Collectors.toList());

        Customer customer = customerRepository.findById(form.getCustomerId()).get();

        Order order = new Order(orderItems, customer);

        orderRepository.save(order);

        order.getItems().forEach(item -> item.getPk().setOrder(order));

        order.getItems().forEach(orderItemRepository::save);



        return new OrderDto(order);

    }

    @Override
    public OrderDto getById(Long id) {
        return new OrderDto(orderRepository.findById(id).get());
    }

    @Override
    @Transactional
    public OrderDto updateStatus(Long id, UpdateOrderForm orderForm) {
        Order order = orderRepository.findById(id).get();
        OrderStatusConverter converter = new OrderStatusConverter();
        order.setStatus(converter.convert(orderForm.getStatus()));

        return new OrderDto(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Order order = orderRepository.findById(id).get();
        List<OrderItem> items = order.getItems();

        for (OrderItem orderItem : items) {
            orderItemRepository.delete(orderItem);
        }

        orderRepository.delete(order);

    }

    private OrderItem createOrderItem(OrderItemForm form){

        Product product = new Product(productService.getById(form.getProductId()));
        Order order = new Order();

        return new OrderItem(order, product, form.getQuantity());

    }
}
