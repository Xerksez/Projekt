package pl.edu.pjwstk.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projekt.model.StaffMember;
import pl.edu.pjwstk.projekt.model.Ticket;
import pl.edu.pjwstk.projekt.model.enums.TicketCategory;
import pl.edu.pjwstk.projekt.repository.TicketRepository;


import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }


    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Ticket ticketToUpdate = getTicketById(id);

        if (updatedTicket.getMovie() != null) {
            ticketToUpdate.setMovie(updatedTicket.getMovie());
        }

        if (updatedTicket.getTicketCategory() != null) {
            ticketToUpdate.setTicketCategory(updatedTicket.getTicketCategory());
        }

        return ticketRepository.save(ticketToUpdate);

    }

    public  Ticket getTicketById(Long id) {
        Optional<Ticket> a = ticketRepository.findById(id);
        if (a.isPresent()) {
            return a.get();
        }
        throw new IllegalArgumentException();
    }
    public void deleteTicketById(Long id){
       ticketRepository.deleteById(id);
    }

    public List<Ticket> findTicketByTicketCategory(TicketCategory ticketCategory) {
        return ticketRepository.findTicketByTicketCategory(ticketCategory);
    }
}
