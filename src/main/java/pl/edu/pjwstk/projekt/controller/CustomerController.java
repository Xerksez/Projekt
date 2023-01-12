package pl.edu.pjwstk.projekt.controller;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Customer> getCustomerByIdRequestParam(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    //http://localhost:8080/customer/?id=0
    @DeleteMapping
    public ResponseEntity<String> deleteCustomerById(@RequestParam("id") Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("ok");
    }

    //http://localhost:8080/customer/0
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    //http://localhost:8080/customer/firstName=cos
    @GetMapping("/firstName")
    public ResponseEntity<List<Customer>> findCustomerByFirstName(@RequestParam(name = "firstName")String firstName){
        return ResponseEntity.ok(customerService.findCustomerByFirstName(firstName));
    }

    //http://localhost:8080/customer/hubert/labuda
    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<Customer> findCustomerByFirstNameAndLastName(@PathVariable("firstName") String firstName , @PathVariable("lastName") String lastname){
        return  ResponseEntity.ok(customerService.findCustomerByFirstNameAndLastName(firstName, lastname));
    }
    }

