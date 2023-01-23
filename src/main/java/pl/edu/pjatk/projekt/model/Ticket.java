package pl.edu.pjatk.projekt.model;

import pl.edu.pjwstk.projekt.model.Customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Start_date")
    private LocalDate startDate;
    @Column(name="End_date")
    private LocalDate endDate;
    @Column(name="Ticket_category")
    private TicketCategory ticketCategory;

    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;


    public Ticket(){

    }

    public Ticket(Long id, LocalDate startDate, LocalDate endDate, TicketCategory ticketCategory, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategory = ticketCategory;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

}