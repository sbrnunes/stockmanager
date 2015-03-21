package org.snmco.stock.productmanager.search;


import org.springframework.util.StringUtils;

public class SellSearch {

    private String productId;
    private String customerId;

    public String getProductId() {
        return productId;
    }

    private void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isCustomerAndProduct() {
        return isCustomer() && isProduct();
    }

    public boolean isCustomer(){
        return !StringUtils.isEmpty(customerId);
    }

    public boolean isProduct(){
        return !StringUtils.isEmpty(productId);
    }

}
