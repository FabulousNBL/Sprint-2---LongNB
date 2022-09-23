package com.project.service.impl;

import com.project.dto.OrderDto;
import com.project.model.CartDto;
import com.project.model.Order;
import com.project.model.Product;
import com.project.model.Transaction;
import com.project.repository.IOrderRepository;
import com.project.service.IOrderService;
import com.project.service.ITransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private MailService mailService;
    @Autowired
    private ProductService productService;

    @Override
    public void saveOrder(List<CartDto> cartDtoList) {
        Transaction transaction = transactionService.getLastTransaction();
        Order order;
        for (int i = 0; i < cartDtoList.size(); i++) {
            CartDto productDto = cartDtoList.get(i);
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            product.setQuantity(product.getQuantity() - productDto.getQuantityOrder());
            productService.update(product);
            order = new Order(productDto.getQuantityOrder(), transaction, product);
            orderRepository.save(order);
        }
        mailService.sendMail(transaction.getCustomer().getEmail());
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        orderRepository.createOrder(orderDto.getQuantity(), orderDto.getProduct().getId(), orderDto.getTransactionOrder().getId());
    }

    @Override
    public List<Order> getListOrder() {
        return orderRepository.getListOrder();
    }


}
