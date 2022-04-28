package com.exercises.transaction.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @JsonProperty("number")
    private String number;
    private Integer id;
    private Integer agency;
    private AccountType accountType;
    private BigDecimal balance;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
