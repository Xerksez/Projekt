package pl.edu.pjwstk.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.StaffMember;
import pl.edu.pjwstk.projekt.model.enums.StaffType;
import pl.edu.pjwstk.projekt.repository.StaffMemberRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StaffMemberService {

    StaffMemberRepository staffMemberRepository;

    @Autowired
    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    public StaffMember createStaffMember(StaffMember staffMember){
        return staffMemberRepository.save(staffMember);
    }
    public List<StaffMember> getStaffMembers() {
        return staffMemberRepository.findAll();
    }

    public StaffMember findStaffMemberByFirstNameAndLastName(String firstName, String lastName){
        Optional<StaffMember> staffMember = staffMemberRepository.findStaffMemberByFirstNameAndLastName(firstName, lastName);
        if(staffMember.isPresent()){
            return staffMember.get();
        }
        throw new IllegalArgumentException();
    }

    public StaffMember updateStaffMember(Long id, StaffMember updatedStaffMember) {
        StaffMember staffMemberToUpdate = getStaffMemberById(id);

        if (updatedStaffMember.getFirstName() != null) {
            staffMemberToUpdate.setFirstName(updatedStaffMember.getFirstName());
        }

        if (updatedStaffMember.getLastName() != null) {
            staffMemberToUpdate.setLastName(updatedStaffMember.getLastName());
        }

        if (updatedStaffMember.getStaffType() != null) {
            staffMemberToUpdate.setStaffType(updatedStaffMember.getStaffType());
        }

        return staffMemberRepository.save(staffMemberToUpdate);

    }

    public StaffMember getStaffMemberById(Long id){
        return staffMemberRepository.getReferenceById(id);
    }

    public void deleteStaffMemberById(Long id){
        staffMemberRepository.deleteById(id);
    }

    public List<StaffMember> findStaffMemberByStaffType(StaffType staffType) {
        return staffMemberRepository.findStaffMemberByStaffType(staffType);
    }

    public List<StaffMember> findStaffMemberByFirstName(String firstName) {
        return staffMemberRepository.findStaffMemberByFirstName(firstName);
    }
}
