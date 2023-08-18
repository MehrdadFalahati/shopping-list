package com.mehrdad.falahati.shopping.list.data.access.adapter;

import com.mehrdad.falahati.shopping.list.data.access.mapper.ShoppingListDataAccessMapper;
import com.mehrdad.falahati.shopping.list.data.access.repository.ShoppingListJpaRepository;
import com.mehrdad.falahati.shopping.list.domain.entity.ShoppingList;
import com.mehrdad.falahati.shopping.list.domain.repository.ShoppingListRepository;
import com.mehrdad.falahati.shopping.list.domain.valueobject.ShoppingListId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShoppingListRepositoryImpl implements ShoppingListRepository {

    private final ShoppingListJpaRepository shoppingListJpaRepository;
    private final ShoppingListDataAccessMapper shoppingListDataAccessMapper;

    @Override
    public ShoppingList save(ShoppingList shoppingList) {
        return shoppingListDataAccessMapper.shoppingListEntityToShoppingList(shoppingListJpaRepository
                .save(shoppingListDataAccessMapper.shoppingListToShoppingListEntity(shoppingList)));
    }

    @Override
    public Optional<ShoppingList> findById(ShoppingListId id) {
        return shoppingListJpaRepository.findById(id.getValue())
                .map(shoppingListDataAccessMapper::shoppingListEntityToShoppingList);
    }

    @Override
    public void deleteAll() {
        shoppingListJpaRepository.deleteAll();
    }
}
