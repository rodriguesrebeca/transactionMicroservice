package com.exercises.transaction.service;

import com.exercises.transaction.dto.TransactionRequest;
import com.exercises.transaction.dto.TransactionResponse;
import com.exercises.transaction.model.Transaction;
import com.exercises.transaction.model.TransactionType;

import java.util.List;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest transactionRequest) throws Exception;

    List<Transaction> getAll();

    TransactionResponse getTransactionByNumberAccount(String number);

    List<Transaction> getTransactionByTransactionType(TransactionType transactionType);

    Transaction getById(Integer id);

    void delete(Integer id);
}
