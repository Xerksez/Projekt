package pl.edu.pjwstk.projekt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projekt.model.Hall;
import pl.edu.pjwstk.projekt.service.HallService;
import java.util.List;

@RestController
@RequestMapping("/api/hall/")
public class HallController {
    HallService hallService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    public ResponseEntity<List<Hall>> getAllHalls() {
        return ResponseEntity.ok(hallService.getHalls());
    }

    @PostMapping
    public ResponseEntity<Hall> createHall(@RequestBody Hall hall) {
        return ResponseEntity.ok(hallService.createHall(hall));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(hallService.getHallById(id));
    }

    //http://localhost:8080/hall/?id=0
    @DeleteMapping
    public ResponseEntity<String> deleteHallById(@RequestParam("id") Long id) {
        hallService.deleteHallById(id);
        return ResponseEntity.ok("ok");
    }

    //http://localhost:8080/hall/0
    @PutMapping("{id}")
    public ResponseEntity<Hall> updateHall(@RequestBody Hall hall, @PathVariable("id") Long id) {
        return ResponseEntity.ok(hallService.updateHall(id,hall));
    }

    //http://localhost:8080/hall/?seatsLimit=50
    @GetMapping("/seatsLimit")
    public ResponseEntity<List<Hall>> findHallBySeatsLimit(@RequestParam(name = "seatsLimit")Long seatsLimit){
        return ResponseEntity.ok(hallService.findHallBySeatsLimit(seatsLimit));
    }

}
