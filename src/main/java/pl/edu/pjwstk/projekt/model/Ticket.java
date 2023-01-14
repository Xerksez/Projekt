package pl.edu.pjwstk.projekt.model;

import pl.edu.pjwstk.projekt.model.enums.TicketCategory;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Ticket_category")
    private TicketCategory ticketCategory;
    @ManyToOne()
    @JoinColumn( name="movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne()
    @JoinColumn( name="hall_id", referencedColumnName = "id", insertable = false, updatable = false)

    private Hall hall;

    public Ticket(){}

    public Ticket(Long id, TicketCategory ticketCategory, Movie movie, Hall hall) {
        this.id = id;
        this.ticketCategory = ticketCategory;
        this.movie=movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}