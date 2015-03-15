package org.snmco.stock.productmanager.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "product", type = "productdef")
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.String)
    private String name;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type = FieldType.Auto)
    private byte[] image;

    @Field(type = FieldType.String)
    private String profuctreference;

    @Field(type = FieldType.String)
    private String sqlid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getProfuctreference() {
        return profuctreference;
    }

    public void setProfuctreference(String profuctreference) {
        this.profuctreference = profuctreference;
    }

    public String getSqlid() {
        return sqlid;
    }

    public void setSqlid(String sqlid) {
        this.sqlid = sqlid;
    }
}
