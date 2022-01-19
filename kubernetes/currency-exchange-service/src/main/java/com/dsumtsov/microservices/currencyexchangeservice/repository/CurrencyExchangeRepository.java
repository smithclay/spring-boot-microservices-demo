package com.dsumtsov.microservices.currencyexchangeservice.repository;

import com.dsumtsov.microservices.currencyexchangeservice.model.CurrencyExchange;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findByFromAndTo(@NonNull String from, @NonNull String to);
}
