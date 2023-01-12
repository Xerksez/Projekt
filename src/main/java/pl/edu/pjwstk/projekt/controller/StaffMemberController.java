package pl.edu.pjwstk.projekt.controller;
import pl.edu.pjwstk.projekt.model.Customer;
import pl.edu.pjwstk.projekt.model.StaffMember;
import pl.edu.pjwstk.projekt.model.enums.StaffType;
import pl.edu.pjwstk.projekt.service.StaffMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staffMember/")
public class StaffMemberController {
    StaffMemberService staffMemberService;

    @Autowired
    public StaffMemberController(StaffMemberService staffMemberService) {
        this.staffMemberService = staffMemberService;
    }

    @GetMapping
    public ResponseEntity<List<StaffMember>> getAllStaffMembers() {
        return ResponseEntity.ok(staffMemberService.getStaffMembers());
    }

    @PostMapping
    public ResponseEntity<StaffMember> createStaffMember(@RequestBody StaffMember staffMember) {
        return ResponseEntity.ok(staffMemberService.createStaffMember(staffMember));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffMember> getStaffMemberById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(staffMemberService.getStaffMemberById(id));
    }

    @GetMapping("/get")
    public ResponseEntity<StaffMember> getStaffMemberByIdRequestParam(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(staffMemberService.getStaffMemberById(id));
    }


    //http://localhost:8080/staffMember/?id=0
    @DeleteMapping
    public ResponseEntity<String> deleteStaffMemberById(@RequestParam("id") Long id) {
        staffMemberService.deleteStaffMemberById(id);
        return ResponseEntity.ok("ok");
    }

    //http://localhost:8080/staffMember/0
    @PutMapping("{id}")
    public ResponseEntity<StaffMember> updateStaffMember(@RequestBody StaffMember staffMember, @PathVariable("id") Long id) {
        return ResponseEntity.ok(staffMemberService.updateStaffMember(id, staffMember));
    }

    //http://localhost:8080/staffMember/?job=Seller
    @GetMapping("/job")
    public ResponseEntity<List<StaffMember>> findStaffMemberByStaffType(@RequestParam(name = "job") StaffType staffType) {
        return ResponseEntity.ok(staffMemberService.findStaffMemberByStaffType(staffType));
    }

    //http://localhost:8080/staffMember/firstName=cos
    @GetMapping("/firstName")
    public ResponseEntity <List<StaffMember>> findStaffMemberByFirstName(@RequestParam(name = "firstName")String firstName){
        return ResponseEntity.ok(staffMemberService.findStaffMemberByFirstName(firstName));
    }

    //http://localhost:8080/staffMember/hubert/labuda
    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<StaffMember> findStaffMemberByFirstNameAndLastName(@PathVariable("firstName") String firstName , @PathVariable("lastName") String lastName){
        return  ResponseEntity.ok(staffMemberService.findStaffMemberByFirstNameAndLastName(firstName, lastName));
    }
}


