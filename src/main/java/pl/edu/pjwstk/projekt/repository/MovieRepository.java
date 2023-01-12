package pl.edu.pjwstk.projekt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projekt.model.Movie;
import pl.edu.pjwstk.projekt.model.enums.MovieType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findMovieByMovieDate(LocalDateTime movieDate);
    Optional<Movie> findMovieByMovieName(String movieName);
    List<Movie> findMovieByMovieType(MovieType movieType);
}
