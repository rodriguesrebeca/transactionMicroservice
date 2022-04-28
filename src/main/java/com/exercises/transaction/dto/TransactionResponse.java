package com.exercises.transaction.dto;

import com.exercises.transaction.dto.account.Account;
import com.exercises.transaction.model.Transaction;
import com.exercises.transaction.model.TransactionStatus;
import com.exercises.transaction.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse{
    private double value;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private String number;
    private Integer agency;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Account[] account;

    public TransactionResponse(Transaction transaction){
        value = transaction.getValue();
        transactionType = transaction.getTransactionType();
        transactionStatus = transaction.getTransactionStatus();
        number = transaction.getNumber();
        agency = transaction.getAgency();
        createdDate = transaction.getCreatedDate();
        updatedDate = transaction.getUpdatedDate();
    }

    public TransactionResponse(Transaction transaction, Account[] account) {
        value = transaction.getValue();
        transactionType = transaction.getTransactionType();
        transactionStatus = transaction.getTransactionStatus();
        number = transaction.getNumber();
        agency = transaction.getAgency();
        createdDate = transaction.getCreatedDate();
        updatedDate = transaction.getUpdatedDate();
        this.account = account;
    }

    public static List<TransactionResponse> toResponse(List<Transaction> transactions){
        return transactions.stream().map(TransactionResponse::new).collect(Collectors.toList());
    }

}
