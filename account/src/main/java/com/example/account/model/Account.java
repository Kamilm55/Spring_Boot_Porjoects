package com.example.account.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
public class Account {
    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid" , strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private BigDecimal amount = BigDecimal.valueOf(0);
    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "account")
    private Set<Transaction> transactions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(id, account.id) && Objects.equals(amount, account.amount) && Objects.equals(creationDate, account.creationDate) && Objects.equals(customer, account.customer) && Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, creationDate);
    }
}
