package com.exercises.transaction.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TransactionType {

    TED("Ted"), PIX("Pix"), DEPOSIT("Deposit"), DOC("Doc");
    private String label;
}
