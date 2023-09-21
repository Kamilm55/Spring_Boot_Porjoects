//package com.example.account.dto.converter;
//
//import com.example.account.dto.AccountDto;
//import com.example.account.dto.CustomerAccountDto;
//import com.example.account.model.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class AccountDtoConverter {
//    private final CustomerDtoConverter customerDtoConverter;
//    private final TransactionDtoConverter transactionDtoConverter;
//
////    @Autowired
//    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
//        this.customerDtoConverter = customerDtoConverter;
//        this.transactionDtoConverter = transactionDtoConverter;
//    }
//
//
//    public AccountDto convert(Account account){
//        return new AccountDto(
//                account.getId(),
//                account.getAmount(),
//                account.getCreationDate(),
//                customerDtoConverter.convertToAccountCustomerDto(account.getCustomer()),
//                transactionDtoConverter.convertToTransactionDtoSet(account.getTransactions())
//
//        );
//    }
//
//    public Set<CustomerAccountDto> convertToCustomerAccountDto(Set<Account> from){
//        HashSet<CustomerAccountDto> customerAccountDtoHashSet = new HashSet<>();
//
//        for(Account account : from){
//           CustomerAccountDto c = new CustomerAccountDto();
//           c.setId(account.getId());
//           c.setAmount(account.getAmount());
//           c.setCreationDate(account.getCreationDate());
//
//           // not set transactions , costumer => user cannot see transaction in Customer>account>transactions , costumer
//            customerAccountDtoHashSet.add(c);
//        }
//
//        return customerAccountDtoHashSet;
//    }
//}
