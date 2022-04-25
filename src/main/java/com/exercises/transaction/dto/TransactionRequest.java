package com.exercises.transaction.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    @NotNull
    private double value;
    @NotNull
    private String transactionType;
    @NotNull
    private String number;
    @NotNull
    private Integer agency;
}
