package pl.edu.pjwstk.projekt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.Hall;
import pl.edu.pjwstk.projekt.repository.HallRepository;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository HallRepository) {
        this.hallRepository = HallRepository;
    }

    public Hall createHall(Hall Hall){
        return hallRepository.save(Hall);
    }

    public List<Hall> getHalls() {
        return hallRepository.findAll();
    }


    public Hall updateHall(Long id, Hall updatedHall) {
        Hall hallToUpdate = getHallById(id);

        if (updatedHall.getSeatsLimit() != null) {
            hallToUpdate.setSeatsLimit(updatedHall.getSeatsLimit());
        }

        return hallRepository.save(hallToUpdate);

    }


    public Hall getHallById(Long id) {
        Optional<Hall> a = hallRepository.findById(id);
        if (a.isPresent()) {
            return a.get();
        }
        throw new IllegalArgumentException();
    }


    public void deleteHallById(Long id){hallRepository.deleteById(id);
    }
    public List<Hall> findHallBySeatsLimit(long seatsLimit) {
        return hallRepository.findHallBySeatsLimit(seatsLimit);
    }

}
