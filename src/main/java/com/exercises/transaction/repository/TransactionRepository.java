package com.exercises.transaction.repository;

import com.exercises.transaction.model.Transaction;
import com.exercises.transaction.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByNumber(String number);
    List<Transaction> findByTransactionType(TransactionType transactionType);
}
