package com.mehrdad.falahati.shopping.list.application.service.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TotalPriceQuery(@NotNull UUID shoppingListId) {
}
