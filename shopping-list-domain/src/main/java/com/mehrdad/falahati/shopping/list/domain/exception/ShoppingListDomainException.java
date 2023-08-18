package com.mehrdad.falahati.shopping.list.domain.exception;

import com.mehrdad.falahati.common.domain.exception.DomainException;

public class ShoppingListDomainException extends DomainException {
    public ShoppingListDomainException(String message) {
        super(message);
    }

    public ShoppingListDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
