package chand.springframework.msscbeerservice;

import chand.springframework.msscbeerservice.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .firstName("Chandana")
                .lastName("Ekanayake")
                .age(40)
                .location("Kadawatha").build();
    }

    @Override
    public void createCustomer(CustomerDTO customer) {
        log.debug("Creating a customer" + customer.getId().toString());
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting a customer..");
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customer) {
        log.debug("Updating customer.. " + customerId.toString());
    }
}
