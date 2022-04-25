package com.exercises.transaction.service.impl;

import com.exercises.transaction.dto.TransactionRequest;
import com.exercises.transaction.dto.TransactionResponse;
import com.exercises.transaction.model.Transaction;
import com.exercises.transaction.model.TransactionStatus;
import com.exercises.transaction.model.TransactionType;
import com.exercises.transaction.repository.TransactionRepository;
import com.exercises.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {

        Transaction transaction = new Transaction(transactionRequest);
        if (transaction.getValue() <= 0) {
            transaction.setTransactionStatus(TransactionStatus.REJECTED);
            transactionRepository.save(transaction);
        } else {
            transaction.setTransactionStatus(TransactionStatus.APPROVED);
            transactionRepository.save(transaction);
        }
        return new TransactionResponse(transaction);
    }

    @Override
    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionByNumberAccount(Integer number){
        return transactionRepository.findByNumber(number);

    }

    @Override
    public List<Transaction> getTransactionByTransactionType(TransactionType transactionType){
        return transactionRepository.findByTransactionType(transactionType);
    }

    @Override
    public Transaction getById(Integer id){
        return transactionRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id){
        Transaction transaction = transactionRepository.findById(id).orElseThrow();
        transactionRepository.delete(transaction);
    }
}
