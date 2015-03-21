package org.snmco.stock.productmanager.document;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "buy", type = "buydef")
public class Buy {

    @Id
    private String id;

    @Field(type = FieldType.String)
    private String prodcutId;

    @Field(type = FieldType.String)
    private String companyId;

    @Field(type = FieldType.String)
    private Integer amount;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type = FieldType.String)
    private String note;

    @Field(type = FieldType.Date)
    private DateTime buyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdcutId() {
        return prodcutId;
    }

    public void setProdcutId(String prodcutId) {
        this.prodcutId = prodcutId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DateTime getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(DateTime buyDate) {
        this.buyDate = buyDate;
    }
}
