package com.mehrdad.falahati.shopping.list.domain.entity;

import com.mehrdad.falahati.common.domain.entity.AggregateRoot;
import com.mehrdad.falahati.shopping.list.domain.exception.ShoppingListDomainException;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingItemId;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingListId;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class ShoppingList extends AggregateRoot<ShoppingListId> {
    private static final double SUBTOTAL_PRICE_BOUNDARY_FOR_FREE_SHIPPING = 100;
    protected static final double STANDARD_SHIPPING_COSTS = 10;
    private final Set<ShoppingItem> shoppingItems = new LinkedHashSet<>();

    public void initialShoppingList() {
        setId(new ShoppingListId(UUID.randomUUID()));
    }

    public void addItem(ShoppingItem shoppingItem) {
        shoppingItems.add(shoppingItem);
    }

    public int getSize() {
        return shoppingItems.size();
    }

    public void removeItem(ShoppingItem shoppingItem) {
        shoppingItems.remove(shoppingItem);
    }

    public ShoppingItem getItem(ShoppingItemId shoppingItemId) {
        return shoppingItems.stream()
                .filter(shoppingItem -> shoppingItem.getId().equals(shoppingItemId))
                .findFirst()
                .orElseThrow(() -> new ShoppingListDomainException("Item with id: <" + shoppingItemId.getValue() + "> not found!"));
    }

    public Double getTotalItems() {
        return shoppingItems.stream()
                .mapToDouble(ShoppingItem::getQuantity)
                .sum();
    }

    public Double getSubtotalPrice() {
        return shoppingItems.stream().mapToDouble(ShoppingItem::getSubtotalPrice).sum();
    }

    public Double getShippingCosts() {
        if (getTotalItems() == 0) {
            return 0d;
        }

        if (getSubtotalPrice() >= SUBTOTAL_PRICE_BOUNDARY_FOR_FREE_SHIPPING) {
            return 0d;
        }

        return STANDARD_SHIPPING_COSTS;
    }

    public Double getTotalPrice() {
        return getSubtotalPrice() + getShippingCosts();
    }
}
