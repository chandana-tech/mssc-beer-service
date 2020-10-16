package chand.springframework.msscbeerservice;

import chand.springframework.msscbeerservice.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID customerId);

    void createCustomer(CustomerDTO customer);

    void deleteCustomer(UUID customerId);

    void updateCustomer(UUID customerId, CustomerDTO customer);
}
