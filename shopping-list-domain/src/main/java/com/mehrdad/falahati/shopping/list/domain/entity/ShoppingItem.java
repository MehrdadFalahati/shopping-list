package com.mehrdad.falahati.shopping.list.domain.entity;

import com.mehrdad.falahati.common.domain.entity.BaseEntity;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingItemId;

public class ShoppingItem extends BaseEntity<ShoppingItemId> {
    private final String productName;

    private final Double price;

    private final int quantity;

    private ShoppingItem(Builder builder) {
        setId(builder.id);
        productName = builder.productName;
        price = builder.price;
        quantity = builder.quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getSubtotalPrice() {
        return price * quantity;
    }

    public static final class Builder {
        private ShoppingItemId id;
        private String productName;
        private Double price;
        private int quantity;

        private Builder() {
        }

        public Builder id(ShoppingItemId val) {
            id = val;
            return this;
        }

        public Builder productName(String val) {
            productName = val;
            return this;
        }

        public Builder price(Double val) {
            price = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public ShoppingItem build() {
            return new ShoppingItem(this);
        }
    }
}
