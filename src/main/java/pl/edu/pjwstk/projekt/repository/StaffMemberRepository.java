package pl.edu.pjwstk.projekt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.projekt.model.StaffMember;
import pl.edu.pjwstk.projekt.model.enums.StaffType;
import java.util.List;
import java.util.Optional;

@Repository
public interface StaffMemberRepository extends JpaRepository<StaffMember, Long> {
    Optional<StaffMember> findStaffMemberByFirstNameAndLastName(String firstName, String lastName);
    List<StaffMember> findStaffMemberByFirstName(String firstName);
    List<StaffMember> findStaffMemberByStaffType(StaffType staffType);

}
