package com.project.service;

import com.project.dto.TransactionDto;
import com.project.model.Transaction;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransactionService {
    void save(Transaction transaction);

    Transaction getLastTransaction();

    List<Transaction> findAll();

    void createTransaction(TransactionDto transactionDto);

    List<Transaction> getHistory();
}
