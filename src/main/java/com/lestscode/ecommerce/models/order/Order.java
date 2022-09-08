package com.lestscode.ecommerce.models.order;

import com.lestscode.ecommerce.models.customer.Customer;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCreated;
    private LocalDate dateModified;
    @OneToMany(mappedBy = "pk.order")
    private List<OrderItem> items = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)

    //@JoinColumn(name = "customer_id" , referencedColumnName = "id")
    private Customer customer;
    private BigDecimal total;

    public Order(){}

    public Order(List<OrderItem> items, Customer customer) {

        this.items = items;
        this.customer = customer;
        this.total = BigDecimal.valueOf(items.stream().mapToDouble(OrderItem::getTotalPrice).sum());
    }
    @PrePersist
    void OnCreated(){
        this.setDateCreated(LocalDate.now());
        this.setDateModified(LocalDate.now());
        this.setStatus(OrderStatus.CREATED);

    }
    @PreUpdate
    void OnUpdate(){
        this.setDateModified(LocalDate.now());
    }



    @Transient
    public int getNumberOfItems(){
        return items.size();
    }

}
