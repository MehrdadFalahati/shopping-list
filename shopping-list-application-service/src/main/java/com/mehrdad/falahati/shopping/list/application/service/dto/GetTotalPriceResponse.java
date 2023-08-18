package com.mehrdad.falahati.shopping.list.application.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record GetTotalPriceResponse(@NotNull UUID ShoppingListId, @NotNull Double totalPrice) {
}
