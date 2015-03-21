package org.snmco.stock.productmanager.document;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.NotNull;

@Document(indexName = "sell", type = "selldef")
public class Sell {

    @Id
    private String id;

    @Field(type = FieldType.String)
    @NotNull
    private String productId;

    @Field(type = FieldType.String)
    @NotNull
    private String customerId;

    @Field(type = FieldType.String)
    @NotNull
    private String companyId;

    @Field(type = FieldType.String)
    @NotNull
    private Integer amount;

    @Field(type = FieldType.Double)
    private double price;

    @Field(type = FieldType.String)
    private String note;

    @Field(type = FieldType.Date)
    private DateTime sellDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public DateTime getSellDate() {
        return sellDate;
    }

    public void setSellDate(DateTime sellDate) {
        this.sellDate = sellDate;
    }

    public void initDate() {
        if (getSellDate() == null) {
            setSellDate(new DateTime());
        }
    }
}
