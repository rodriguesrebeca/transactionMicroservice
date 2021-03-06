package com.exercises.transaction.controller;

import com.exercises.transaction.dto.TransactionRequest;
import com.exercises.transaction.dto.TransactionResponse;
import com.exercises.transaction.model.Transaction;
import com.exercises.transaction.model.TransactionType;
import com.exercises.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public TransactionResponse create(@RequestBody TransactionRequest transactionRequest) throws Exception {
        return transactionService.createTransaction(transactionRequest);
    }

    @GetMapping("/{number}")
    public TransactionResponse getByNumber(@RequestParam String number){
        return transactionService.getTransactionByNumberAccount(number);
    }

    @GetMapping("/all/{transaction}")
    public List<Transaction> getByTransactionType(@RequestParam TransactionType transactiontype){
        return transactionService.getTransactionByTransactionType(transactiontype);
    }

    @GetMapping("/all")
    public List<TransactionResponse> getAllTransactions(){
        return TransactionResponse.toResponse(transactionService.getAll());
    }

    @GetMapping("/{id}")
    public Transaction getById(@RequestParam Integer id){
        return transactionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        transactionService.delete(id);
    }
}
