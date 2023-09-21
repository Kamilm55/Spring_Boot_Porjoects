//package com.example.account.dto.converter;
//
//import com.example.account.dto.AccountCustomerDto;
//import com.example.account.dto.CustomerDto;
//import com.example.account.model.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomerDtoConverter {
//    private final AccountDtoConverter accountDtoConverter;
//
//    @Autowired
//    public CustomerDtoConverter(AccountDtoConverter accountDtoConverter) {
//        this.accountDtoConverter = accountDtoConverter;
//    }
//
//    public CustomerDto convert(Customer from){
//        return new CustomerDto(
//               from.getId(),
//               from.getName(),
//               from.getSurname(),
//               accountDtoConverter.convertToCustomerAccountDto(from.getAccounts())
//        );
//    }
//
//
//    public AccountCustomerDto convertToAccountCustomerDto(Customer customer){
//        return new AccountCustomerDto(
//                customer.getId(),
//                customer.getName(),
//                customer.getSurname()
//        );
//    }
//}
