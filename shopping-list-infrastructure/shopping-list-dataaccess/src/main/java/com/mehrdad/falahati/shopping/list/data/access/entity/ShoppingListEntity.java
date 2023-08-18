package com.mehrdad.falahati.shopping.list.data.access.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_list")
@Entity
public class ShoppingListEntity {
    @Id
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    private Set<ShoppingItemEntity> shoppingItems = new LinkedHashSet<>();
}
