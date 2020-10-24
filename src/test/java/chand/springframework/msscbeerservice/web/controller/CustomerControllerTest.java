package chand.springframework.msscbeerservice.web.controller;

import chand.springframework.msscbeerservice.CustomerService;
import chand.springframework.msscbeerservice.web.model.CustomerDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvn;

    @Autowired
    ObjectMapper objetMapper;

    @MockBean
    CustomerService customerService;

    @Test
    void getCustomerById() throws Exception {
        BDDMockito.given(customerService.getCustomerById(ArgumentMatchers.any())).willReturn(getCustomer());

        mockMvn.perform(MockMvcRequestBuilders.get("/api/v1/customer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    private CustomerDTO getCustomer() {
        return CustomerDTO.builder()
                .firstName("first")
                .lastName("lastname")
                .age(23)
                .location("Madipola")
                .id(UUID.randomUUID()).build();
    }

    @Test
    void createCustomer() throws Exception{
        mockMvn.perform(MockMvcRequestBuilders.post("/api/v1/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objetMapper.writeValueAsString(getCustomer())))
        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateCustomer() throws Exception {
        mockMvn.perform(MockMvcRequestBuilders.put("/api/v1/customer/" + UUID.randomUUID())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objetMapper.writeValueAsString(getCustomer()))).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvn.perform(MockMvcRequestBuilders.delete("/api/v1/customer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status()
                        .isNoContent());
    }
}