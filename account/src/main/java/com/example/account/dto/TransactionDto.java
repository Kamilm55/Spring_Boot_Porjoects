package com.example.account.dto;

import com.example.account.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private UUID id;
    private TransactionType transactionType = TransactionType.INITIAL ;
    private BigDecimal amount;
    private LocalDate transactionDate;
//    private AccountDto account;
}
