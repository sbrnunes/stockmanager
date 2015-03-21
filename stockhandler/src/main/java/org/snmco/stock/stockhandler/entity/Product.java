package org.snmco.stock.stockhandler.entity;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @NotNull
    private String id;

    @Version
    private int version;

    @NotNull
    private Integer stock;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @JsonIgnore
    public Company getCompany() {
        return company;
    }

    @JsonIgnore
    protected void setCompany(Company company) {
        this.company = company;
    }

    // TODO HATOAS : return company resource
    @JsonGetter("companyId")
    public String getCompanyId()
    {
        return company.getId();
    }
}
