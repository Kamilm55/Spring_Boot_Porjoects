package com.example.account;

import com.example.account.dto.CustomerDto;
import com.example.account.model.Account;
import com.example.account.model.Customer;
import com.example.account.model.Transaction;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.CustomerRepository;
import com.example.account.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;


    public DemoApplication(CustomerRepository customerRepository, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//test joined tables in memory database (h2 database)


    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer("Kamil","Memmedov");
        Customer customer2 = new Customer("Customer 2" , "Surname 2");
        Customer customer3 = new Customer("Customer 3" , "Surname 3");




//        Transaction transaction = new Transaction();
//        transaction.setAmount(BigDecimal.valueOf(1030.55));
//        transaction.setAccount(account);
        customerRepository.saveAll(List.of(customer,customer2,customer3));// save this and change state to detached



        Account account = new Account();
        account.setCustomer(customer);
        account.setAmount(BigDecimal.valueOf(100.25));

        Account account2 = new Account();
        account2.setCustomer(customer);
        account2.setAmount(BigDecimal.valueOf(300));

        Account account3 = new Account();
        account3.setCustomer(customer);
        account3.setAmount(BigDecimal.valueOf(18920));



//        System.out.println(account + " " +account2 + " " + account3);
        accountRepository.saveAll(List.of(account,account2,account3));
//        accountRepository.save(account);

//        transactionRepository.save(transaction);

//        System.out.println(customerRepository.findById(customer.getId()));
//        System.out.println(account);
//        System.out.println(transaction);
    }
}
