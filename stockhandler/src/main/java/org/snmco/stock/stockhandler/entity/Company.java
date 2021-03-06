package org.snmco.stock.stockhandler.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Version
    private int version;

    @NotNull
    private String name;

    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Product> products = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Customer> customers = new ArrayList<>();

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    protected void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    protected void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addProduct(Product product)
    {
        this.products.add(product);
        product.setCompany(this);
    }

    public void addCustomer(Customer customer)
    {
        this.customers.add(customer);
        customer.setCompany(this);
    }

    /**
     * As the entities are used as json object, it need protective cleanup
     */
    public void initForCreate() {
        this.id = null;
        products = new ArrayList<>();
        customers = new ArrayList<>();;
    }
}
