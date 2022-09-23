package com.project.controller;

import com.project.dto.OrderDto;
import com.project.dto.TransactionDto;
import com.project.model.*;
import com.project.service.ICustomerService;
import com.project.service.IOrderService;
import com.project.service.ITransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TransactionController {
    @Autowired
    private ITransactionService iTransactionService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/transaction")
    private ResponseEntity<?> saveTransaction(@RequestBody TransactionDto transactionDto){
        iTransactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/order")
    private ResponseEntity<?> addProductToOrder(@RequestBody OrderDto orderDto){

        iOrderService.createOrder(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/transaction/list")
    private ResponseEntity<?> getAll(){
        return new ResponseEntity<>(iTransactionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("order/list")
    private ResponseEntity<?> getAllOrder(){
        List<Order> orders = iOrderService.getListOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/transaction/history")
    private ResponseEntity<?> getHistory(){
        List<Transaction> transactions = iTransactionService.getHistory();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
