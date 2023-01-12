package pl.edu.pjwstk.projekt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projekt.model.Ticket;
import pl.edu.pjwstk.projekt.model.enums.TicketCategory;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketByTicketCategory(TicketCategory ticketCategory);

}