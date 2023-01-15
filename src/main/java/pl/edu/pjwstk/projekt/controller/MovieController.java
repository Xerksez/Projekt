package pl.edu.pjwstk.projekt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.projekt.model.Movie;
import pl.edu.pjwstk.projekt.model.Ticket;
import pl.edu.pjwstk.projekt.model.enums.MovieType;
import pl.edu.pjwstk.projekt.model.enums.TicketCategory;
import pl.edu.pjwstk.projekt.service.MovieService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movie/")
public class MovieController {
    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    //http://localhost:8080/movie/?id=0
    @DeleteMapping
    public ResponseEntity<String> deleteMovieById(@RequestParam("id") Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok("ok");
    }

    //http://localhost:8080/movie/0
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    //http://localhost:8080/movie/?Type=NORMAL
    @GetMapping("/Type")
    public ResponseEntity<List<Movie>> findMovieByMovieType(@RequestParam(name = "Type") MovieType movieType) {
        return ResponseEntity.ok(movieService.findMovieByMovieType(movieType));
    }

//    //http://localhost:8080/movie/?Date=2007-12-03T10:15:30
//    @GetMapping("/Date")
//    public ResponseEntity<List<Movie>> findMovieByMovieDate(@RequestParam(name ="Date") LocalDateTime movieDate) {
//        return ResponseEntity.ok(movieService.findMovieByMovieDate(movieDate));
//    }

    //http://localhost:8080/movie/?name=Shrek
        @GetMapping("/{name}")
        public ResponseEntity<Movie> findByMovieName(@PathVariable("name") String movieName) {
            return ResponseEntity.ok(movieService.findByMovieName(movieName));
        }

}
