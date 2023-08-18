package com.mehrdad.falahati.shopping.list.domain.valueobject;

import com.mehrdad.falahati.common.domain.valueobject.BaseId;

import java.util.UUID;

public class ShoppingListId extends BaseId<UUID> {
    public ShoppingListId(UUID value) {
        super(value);
    }
}
