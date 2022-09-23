package com.project.controller;

import com.project.dto.Cart;
import com.project.model.CartDto;
import com.project.model.Customer;
import com.project.model.Product;
import com.project.service.impl.CustomerService;
import com.project.service.impl.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CartController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/cart")
    public ResponseEntity<?> watchList(@RequestBody List<Product> storageList){
        List<CartDto> cartList = new ArrayList<>();
        Product product;
        Cart cart;
        for (int i = 0; i < storageList.size(); i++) {
            product = storageList.get(i);
            CartDto cartDto = new CartDto();
            BeanUtils.copyProperties(product, cartDto);
            cartList.add(cartDto);
        }
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @GetMapping("/customer")
    public ResponseEntity<?> getCustomerByName(@RequestParam String name){
        Customer customer = customerService.findByUsername(name);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
