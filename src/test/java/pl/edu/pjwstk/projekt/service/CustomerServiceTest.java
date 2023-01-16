package pl.edu.pjwstk.projekt.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.Ticket;
import pl.edu.pjwstk.projekt.repository.CustomerRepository;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Customer a = new Customer();
        //when
        when(customerRepository.save(any())).thenReturn(new Customer(90L,"Adam","Adamowicz", new Ticket()));
        a = customerService.createCustomer(a);
        //then
        assertEquals("Adam", a.getFirstName());
        assertEquals("Adamowicz", a.getLastName());
    }

    @Test
    void Should_ThrowIllegalArgumentExceptionWhenNotFound() {
        //given

        //when
        when(customerRepository.findCustomerByFirstNameAndLastName(anyString(), anyString()))
                .thenReturn(Optional.empty());
        //then
        assertThrows(IllegalArgumentException.class, () -> {
            customerService.findCustomerByFirstNameAndLastName(anyString(), anyString());
        });
    }

    @Test
    void Should_RerunAllAuthors() {
        //given
        List<Customer> customers_expected = new ArrayList<>();
        customers_expected.add(new Customer());
        customers_expected.add(new Customer());
        customers_expected.add(new Customer());
        //when
        when(customerRepository.findAll())
                .thenReturn(customers_expected);
        List<Customer> customers_actual = customerService.getCustomers();
        //then
        assertEquals(customers_expected, customers_actual);

    }

    @Test
    void Should_ReturnOneAuthorWithCorrectInput() {
        //given
        Customer customer_expected = new Customer(10L, "Adam", "Adamowicz",new Ticket());
        //when
        when(customerRepository.getReferenceById(anyLong()))
                .thenReturn(customer_expected);
        Customer customer_actual = customerService.getCustomerById(1L);
        //then
        assertEquals(customer_expected, customer_actual);
    }

}