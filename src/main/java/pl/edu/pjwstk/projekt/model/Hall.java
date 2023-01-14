package pl.edu.pjwstk.projekt.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long seatsLimit;

    @ManyToMany(mappedBy = "halls")
    private Set<StaffMember> staffMembers = new HashSet<>();

    public Hall(){}

    public Hall(Long hall_id, Long seatsLimit, Set<StaffMember> staffMembers) {
        this.id = id;
        this.seatsLimit = seatsLimit;
        this.staffMembers = staffMembers;
    }

    public Long getSeatsLimit() {
        return seatsLimit;
    }

    public void setSeatsLimit(Long seatsLimit) {
        this.seatsLimit = seatsLimit;
    }

    public Set<StaffMember> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(Set<StaffMember> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}