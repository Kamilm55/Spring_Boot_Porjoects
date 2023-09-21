//package com.example.account.dto.converter;
//
//import com.example.account.dto.TransactionDto;
//import com.example.account.model.Transaction;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class TransactionDtoConverter {
//
//    public TransactionDto convert(Transaction from){
//        return new TransactionDto(
//                from.getId(),
//                from.getTransactionType(),
//                from.getAmount(),
//                from.getTransactionDate()
//        );
//    }
//
//
//    public Set<TransactionDto> convertToTransactionDtoSet(Set<Transaction> transactions) {
//        Set<TransactionDto> transactionDtoSet = new HashSet<>();
//
//        for(Transaction t : transactions){
//            TransactionDto transactionDto = new TransactionDto(t.getId(),t.getTransactionType(),t.getAmount(),t.getTransactionDate());
//            transactionDtoSet.add(transactionDto);
//        }
//        return transactionDtoSet;
//    }
//}
