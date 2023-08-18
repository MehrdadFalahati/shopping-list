package com.mehrdad.falahati.shopping.list.application.service.mapper;

import com.mehrdad.falahati.shopping.list.application.service.dto.CreateShoppingItemCommand;
import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingItem;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingItemId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShoppingListDataMapper {
    public ShoppingItem createShoppingItemCommandToShoppingItem(CreateShoppingItemCommand shoppingItemCommand) {
        return ShoppingItem.builder()
                .id(new ShoppingItemId(UUID.randomUUID()))
                .price(shoppingItemCommand.price())
                .productName(shoppingItemCommand.productName())
                .quantity(shoppingItemCommand.quantity())
                .build();
    }
}
