package com.example.account.dto.converter;

import com.example.account.dto.AccountDto;
import com.example.account.dto.CustomerAccountDto;
import com.example.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AccountDtoConverter {



    public Set<CustomerAccountDto> convertToCustomerAccountDto(Set<Account> from){
        HashSet<CustomerAccountDto> customerAccountDtoHashSet = new HashSet<>();

        for(Account account : from){
           CustomerAccountDto c = new CustomerAccountDto();
           c.setId(account.getId());
           c.setAmount(account.getAmount());
           c.setCreationDate(account.getCreationDate());

           // not set transactions , costumer => user cannot see transaction in Customer>account>transactions , costumer
            customerAccountDtoHashSet.add(c);
        }

        return customerAccountDtoHashSet;
    }
}
