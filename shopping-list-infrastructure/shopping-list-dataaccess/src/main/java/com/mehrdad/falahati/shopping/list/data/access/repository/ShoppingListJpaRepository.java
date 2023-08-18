package com.mehrdad.falahati.shopping.list.data.access.repository;

import com.mehrdad.falahati.shopping.list.data.access.entity.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoppingListJpaRepository extends JpaRepository<ShoppingListEntity, UUID> {
}
