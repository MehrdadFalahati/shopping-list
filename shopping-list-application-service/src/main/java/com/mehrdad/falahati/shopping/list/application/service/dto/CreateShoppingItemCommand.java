package com.mehrdad.falahati.shopping.list.application.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateShoppingItemCommand(@NotNull String productName,
                                        @NotNull Double price,
                                        @NotNull Integer quantity) {
}
