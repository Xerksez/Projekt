package pl.edu.pjwstk.projekt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.Ticket;
import pl.edu.pjwstk.projekt.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer customerToUpdate = getCustomerById(id);

        if (updatedCustomer.getFirstName() != null) {
            customerToUpdate.setFirstName(updatedCustomer.getFirstName());
        }

        if (updatedCustomer.getLastName() != null) {
            customerToUpdate.setLastName(updatedCustomer.getLastName());
        }

        return customerRepository.save(customerToUpdate);

    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> a = customerRepository.findById(id);
        if (a.isPresent()) {
            return a.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    public Customer findCustomerByFirstNameAndLastName(String firstName, String lastName){
        Optional<Customer> customer = customerRepository.findCustomerByFirstNameAndLastName(firstName, lastName);
        if(customer.isPresent()){
            return customer.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Customer> findCustomerByFirstName(String firstName) {
        return customerRepository.findCustomerByFirstName(firstName);
    }

//    public Customer findCustomerByTicket(Ticket ticket) {
//        return customerRepository.findCustomerByTicket(ticket);
//    }

}
