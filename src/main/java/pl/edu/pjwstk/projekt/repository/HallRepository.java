package pl.edu.pjwstk.projekt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projekt.model.Hall;
import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    List<Hall> findHallBySeatsLimit(long seatsLimit);
}