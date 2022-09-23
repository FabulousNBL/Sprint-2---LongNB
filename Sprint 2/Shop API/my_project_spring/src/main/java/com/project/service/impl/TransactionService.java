package com.project.service.impl;

import com.project.dto.TransactionDto;
import com.project.model.Transaction;
import com.project.repository.ITransactionRepository;
import com.project.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;
    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getLastTransaction() {
        return transactionRepository.getLastTransaction();
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public void createTransaction(TransactionDto transactionDto) {
        transactionRepository.createTransaction(transactionDto.getPayment(), transactionDto.getPaymentMethod(), transactionDto.getStartDate(), transactionDto.getCustomer().getId());
    }

    @Override
    public List<Transaction> getHistory() {
        return transactionRepository.getHistory();
    }
}
