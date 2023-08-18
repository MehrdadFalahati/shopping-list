package com.mehrdad.falahati.shopping.list.application.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateShoppingItemCommand(@NotNull UUID shoppingListId,
                                        @NotNull String productName,
                                        @NotNull Double price,
                                        @NotNull Integer quantity) {
}
