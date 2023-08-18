package com.mehrdad.falahati.shopping.list.domain.repository;

import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingList;
import com.mehrdad.falahati.shopping.list.domain.exception.ShoppingListDomainException;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingListId;

import java.util.Optional;

public interface ShoppingListRepository {
    ShoppingList save(ShoppingList shoppingList);

    Optional<ShoppingList> findById(ShoppingListId id);

    default ShoppingList findByIdOrFail(ShoppingListId id) {
        return findById(id)
                .orElseThrow(() -> new ShoppingListDomainException("Item with id: <" + id + "> not found!"));
    }

    void deleteAll();
}
