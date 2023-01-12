package pl.edu.pjwstk.projekt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projekt.model.Ticket;
import pl.edu.pjwstk.projekt.model.enums.TicketCategory;
import pl.edu.pjwstk.projekt.service.TicketService;
import java.util.List;

@RestController
@RequestMapping("/ticket/")
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getTickets());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @GetMapping("/get?id=0")
    public ResponseEntity<Ticket> getTicketByIdRequestParam(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }


    //http://localhost:8080/ticket/?id=0
    @DeleteMapping
    public ResponseEntity<String> deleteTicketById(@RequestParam("id") Long id) {
        ticketService.deleteTicketById(id);
        return ResponseEntity.ok("ok");
    }

    //http://localhost:8080/ticket/0
    @PutMapping("{id}")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketService.updateTicket(id, ticket));
    }

    //http://localhost:8080/ticket/?Category=NORMAL
    @GetMapping("/Category")
    public ResponseEntity<List<Ticket>> findTicketByTicketCategory(@RequestParam(name = "job") TicketCategory ticketCategory) {
        return ResponseEntity.ok(ticketService.findTicketByTicketCategory(ticketCategory));
    }
}
