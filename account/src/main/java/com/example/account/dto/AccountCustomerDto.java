package com.example.account.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class AccountCustomerDto {
    private UUID id;
    private String name;
    private  String surname;
    private Set<AccountDto> accounts;
}
