package com.exercises.transaction.dto;

import com.exercises.transaction.model.Transaction;
import com.exercises.transaction.model.TransactionStatus;
import com.exercises.transaction.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse {
    private double value;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private String number;
    private Integer agency;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    public TransactionResponse(Transaction transaction){
        this.value = transaction.getValue();
        this.transactionType = transaction.getTransactionType();
        this.transactionStatus = transaction.getTransactionStatus();
        this.number = transaction.getNumber();
        this.agency = transaction.getAgency();
        this.createdDate = transaction.getCreatedDate();
        this.updatedDate = transaction.getUpdatedDate();
    }

    public static List<TransactionResponse> toResponse(List<Transaction> transactions){
        return transactions.stream().map(TransactionResponse::new).collect(Collectors.toList());
    }
}
