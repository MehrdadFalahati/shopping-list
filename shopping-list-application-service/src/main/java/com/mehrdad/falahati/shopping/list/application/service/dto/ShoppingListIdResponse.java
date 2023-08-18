package com.mehrdad.falahati.shopping.list.application.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;
@Builder
public record ShoppingListIdResponse(@NotNull UUID shoppingListId) {
}
