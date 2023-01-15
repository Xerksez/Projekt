package pl.edu.pjwstk.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.Ticket;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
    List<Customer> findCustomerByFirstName(String firstName);
//    Customer findCustomerByTicket (Ticket ticket);
}
