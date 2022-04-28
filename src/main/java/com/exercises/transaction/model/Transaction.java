package com.exercises.transaction.model;

import com.exercises.transaction.dto.TransactionRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(name = "transaction")
@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private double value;

    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Column(name = "transaction_status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name = "number")
    private String number;

    @Column(name = "agency")
    private Integer agency;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public Transaction(TransactionRequest transactionRequest) {
        value = transactionRequest.getValue();
        transactionType = TransactionType.valueOf(transactionRequest.getTransactionType());
        number = transactionRequest.getNumber();
        agency = transactionRequest.getAgency();
    }

}
