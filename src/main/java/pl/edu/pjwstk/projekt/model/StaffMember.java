package pl.edu.pjwstk.projekt.model;
import pl.edu.pjwstk.projekt.model.enums.StaffType;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "staff_members")
public class StaffMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long staff_id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private StaffType staffType;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "hall_Staff",
            joinColumns = { @JoinColumn(name = "staff_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    Set<Hall> halls= new HashSet<>();

    public StaffMember() {
    }

    public StaffMember(Long staff_id, String firstName, String lastName, StaffType staffType, Set<Hall> halls) {
        this.staff_id = staff_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffType = staffType;
        this.halls = halls;
    }

    public void setId(Long staff_id) {
        this.staff_id = staff_id;
    }

    public Long getId() {
        return staff_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public Set<Hall> gethalls() {
        return halls;
    }

    public void sethalls(Set<Hall> halls) {
        this.halls = halls;
    }
}


