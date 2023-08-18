package com.mehrdad.falahati.shopping.list.domain.valueobject;

import com.mehrdad.falahati.common.domain.valueobject.BaseId;

import java.util.UUID;

public class ShoppingItemId extends BaseId<UUID> {
    public ShoppingItemId(UUID value) {
        super(value);
    }
}
