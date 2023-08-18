package com.mehrdad.falahati.shopping.list.application.service;

import com.mehrdad.falahati.shopping.list.application.service.dto.CreateShoppingItemCommand;
import com.mehrdad.falahati.shopping.list.application.service.dto.GetTotalPriceResponse;
import com.mehrdad.falahati.shopping.list.application.service.dto.ShoppingListIdResponse;
import com.mehrdad.falahati.shopping.list.application.service.dto.TotalPriceQuery;
import com.mehrdad.falahati.shopping.list.application.service.mapper.ShoppingListDataMapper;
import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingItem;
import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingList;
import com.mehrdad.falahati.shopping.list.domain.repository.ShoppingListRepository;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingListId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@RequiredArgsConstructor
@Validated
public class ShoppingListApplicationService {
    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListDataMapper shoppingListDataMapper;

    @Transactional
    public ShoppingListIdResponse createShoppingList(){
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.initialShoppingList();
        shoppingListRepository.save(shoppingList);
        log.info("Created a new ShoppingList <id: {}>", shoppingList.getId());
        return new ShoppingListIdResponse(shoppingList.getId().getValue());
    }

    @Transactional
    public ShoppingListIdResponse addItemToTheShoppingList(@Valid CreateShoppingItemCommand shoppingItemCommand){
        ShoppingList shoppingList = shoppingListRepository.findByIdOrFail(new ShoppingListId(shoppingItemCommand.shoppingListId()));
        ShoppingItem shoppingItem = shoppingListDataMapper.createShoppingItemCommandToShoppingItem(shoppingItemCommand);
        shoppingList.addItem(shoppingItem);
        shoppingListRepository.save(shoppingList);
        log.info("Added a new item <{}> to the ShoppingList <id: {}>",
                shoppingItem, shoppingList.getId());
        return new ShoppingListIdResponse(shoppingList.getId().getValue());
    }

    @Transactional(readOnly = true)
    public GetTotalPriceResponse getTotalPrice(@Valid TotalPriceQuery totalPriceQuery){
        ShoppingList shoppingList = shoppingListRepository.findByIdOrFail(new ShoppingListId(totalPriceQuery.shoppingListId()));
        log.info("Retrieved the totalPrice={} for ShoppingList <id: {}>",
                shoppingList.getTotalPrice(), totalPriceQuery.shoppingListId());
        return new GetTotalPriceResponse(shoppingList.getId().getValue(), shoppingList.getTotalPrice());
    }
}
