package com.mehrdad.falahati.shopping.list.data.access.mapper;

import com.mehrdad.falahati.shopping.list.data.access.entity.ShoppingItemEntity;
import com.mehrdad.falahati.shopping.list.data.access.entity.ShoppingListEntity;
import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingItem;
import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingList;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingItemId;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingListId;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ShoppingListDataAccessMapper {

    public ShoppingListEntity shoppingListToShoppingListEntity(ShoppingList shoppingList) {
        return ShoppingListEntity.builder()
                .id(shoppingList.getId().getValue())
                .shoppingItems(shoppingItemsToShoppingItemEntities(shoppingList.getShoppingItems()))
                .build();
    }

    public ShoppingList shoppingListEntityToShoppingList(ShoppingListEntity entity) {
        var shoppingList = new ShoppingList();
        shoppingList.setId(new ShoppingListId(entity.getId()));
        shoppingList.setShoppingItems(shoppingItemEntitiesToShoppingItems(entity.getShoppingItems()));
        return shoppingList;
    }

    private Set<ShoppingItemEntity> shoppingItemsToShoppingItemEntities(Set<ShoppingItem> shoppingItems) {
        return shoppingItems.stream()
                .map(this::shoppingItemToShoppingItemEntity)
                .collect(Collectors.toSet());
    }

    private ShoppingItemEntity shoppingItemToShoppingItemEntity(ShoppingItem shoppingItem) {
        return ShoppingItemEntity.builder()
                .id(shoppingItem.getId().getValue())
                .price(shoppingItem.getPrice())
                .productName(shoppingItem.getProductName())
                .quantity(shoppingItem.getQuantity())
                .build();
    }

    private Set<ShoppingItem> shoppingItemEntitiesToShoppingItems(Set<ShoppingItemEntity> shoppingItems) {
        return shoppingItems.stream()
                .map(this::shoppingItemEntityToShoppingItem)
                .collect(Collectors.toSet());
    }

    private ShoppingItem shoppingItemEntityToShoppingItem(ShoppingItemEntity shoppingItemEntity) {
        return ShoppingItem.builder()
                .id(new ShoppingItemId(shoppingItemEntity.getId()))
                .productName(shoppingItemEntity.getProductName())
                .quantity(shoppingItemEntity.getQuantity())
                .price(shoppingItemEntity.getPrice())
                .build();
    }
}
