package com.project.service;

import com.project.model.Customer;

public interface ICustomerService {
    Customer findByUsername(String username);
}
