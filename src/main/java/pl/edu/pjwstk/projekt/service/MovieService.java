package pl.edu.pjwstk.projekt.service;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.Hall;
import pl.edu.pjwstk.projekt.model.Movie;
import pl.edu.pjwstk.projekt.model.enums.MovieType;
import pl.edu.pjwstk.projekt.repository.MovieRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository MovieRepository) {
        this.movieRepository = MovieRepository;
    }

    public Movie createMovie(Movie Movie){
        return movieRepository.save(Movie);
    }
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie movieToUpdate = getMovieById(id);

        if (updatedMovie.getMovieType() != null) {
            movieToUpdate.setMovieType(updatedMovie.getMovieType());
        }

        if (updatedMovie.getMovieName() != null) {
            movieToUpdate.setMovieName(updatedMovie.getMovieName());
        }

        if (updatedMovie.getMovieDate() != null) {
            movieToUpdate.setMovieDate(updatedMovie.getMovieDate());
        }

        return movieRepository.save(movieToUpdate);

    }

    public Movie getMovieById(Long id){
        return movieRepository.getReferenceById(id);
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }

    public List<Movie> findMovieByMovieType(MovieType movieType) {
        return movieRepository.findMovieByMovieType(movieType);
    }

    public List<Movie> findMovieByMovieDate(LocalDateTime movieDate) {
        return movieRepository.findMovieByMovieDate(movieDate);
    }

    public Movie findByMovieName(String movieName){
        Optional<Movie> movie = movieRepository.findMovieByMovieName(movieName);
        if(movie.isPresent()){
            return movie.get();
        }
        throw new IllegalArgumentException();
    }
}
