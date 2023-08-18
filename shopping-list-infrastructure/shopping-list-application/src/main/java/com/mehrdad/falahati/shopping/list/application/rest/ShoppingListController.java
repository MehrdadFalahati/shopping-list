package com.mehrdad.falahati.shopping.list.application.rest;

import com.mehrdad.falahati.shopping.list.application.service.ShoppingListApplicationService;
import com.mehrdad.falahati.shopping.list.application.service.dto.CreateShoppingItemCommand;
import com.mehrdad.falahati.shopping.list.application.service.dto.GetTotalPriceResponse;
import com.mehrdad.falahati.shopping.list.application.service.dto.ShoppingListIdResponse;
import com.mehrdad.falahati.shopping.list.application.service.dto.TotalPriceQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

import static com.mehrdad.falahati.shopping.list.application.rest.ShoppingListController.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
@RequiredArgsConstructor
public class ShoppingListController {
    protected static final String BASE_URI = "/api/v1/shopping-lists";

    private final ShoppingListApplicationService shoppingListService;

    @PostMapping("/")
    public ResponseEntity<ShoppingListIdResponse> createShoppingList() {
        return ResponseEntity.ok(shoppingListService.createShoppingList());
    }

    @PutMapping("/{shoppingListId}/items")
    public ResponseEntity<ShoppingListIdResponse> addItemToTheShoppingList(@PathVariable UUID shoppingListId,
                                                      @RequestBody CreateShoppingItemCommand command) {
        return ResponseEntity.ok(shoppingListService.addItemToTheShoppingList(shoppingListId, command));
    }

    @GetMapping("/{shoppingListId}/total-price")
    public ResponseEntity<GetTotalPriceResponse> getTotalPrice(@PathVariable UUID shoppingListId) {
        return ResponseEntity.ok().body(shoppingListService.getTotalPrice(new TotalPriceQuery(shoppingListId)));
    }
}
