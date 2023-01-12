package pl.edu.pjwstk.projekt.model;

import pl.edu.pjwstk.projekt.model.enums.TicketCategory;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    private Ticket ticket;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName,Ticket ticket) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticket = ticket;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}


