package pl.edu.pjwstk.projekt.model;
import pl.edu.pjwstk.projekt.model.enums.MovieType;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private MovieType movieType;
    @Column
    private String movieName;
    @Column
    private LocalDateTime movieDate;

    public Movie(){}

    public Movie(Long id, MovieType movieType, String movieName,LocalDateTime movieDate) {
        this.id = id;
        this.movieType = movieType;
        this.movieName = movieName;
        this.movieDate = movieDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(LocalDateTime movieDate) {
        this.movieDate = movieDate;
    }
}