package TF01.TF.Adapters.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import TF01.TF.Business.Entities.*;
//import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Repositories.*;
import TF01.TF.Application.DTOs.*;
import TF01.TF.Application.UseCases.*;
import TF01.TF.Application.DTOs.StatisticsDTO;
import TF01.TF.Application.UseCases.IsOfficialOrganUC;
import TF01.TF.Application.UseCases.RegisterCommentUC;
import TF01.TF.Application.UseCases.RegisterComplaintUC;
import TF01.TF.Application.UseCases.RegisterUserUC;
import TF01.TF.Application.UseCases.StatisticsUC;
import TF01.TF.Application.UseCases.ToggleOfficialUserUC;
import TF01.TF.Application.UseCases.UpdateComplaint;
import TF01.TF.Application.UseCases.ViewComment;
import TF01.TF.Application.UseCases.ViewComplaint;

@RestController
@RequestMapping("/TFendpoint")
public class Controller {
    private RegisterUserUC registerUserUC;
    private IsOfficialOrganUC officialOrganUC;
    private ViewComplaint viewComplaintUC;
    private ViewComment viewCommentUC;
    private RegisterComplaintUC registerComplaintUC;
    private RegisterCommentUC registerCommentUC;
    private UpdateComplaint updateComplaintUC;
    private ToggleOfficialUserUC toggleOfficialUserUC;
    private StatisticsUC statisticsUC;
    private ViewCommentsOnComplaint viewCommentsOnComplaint;
    private ViewUser viewUser;

    @Autowired
    public Controller(ViewUser viewUser, RegisterUserUC registerUserUC, IsOfficialOrganUC isOfficialOrganUC, ViewComplaint viewComplaintUC, ViewComment viewCommentUC, RegisterComplaintUC registerComplaintUC, RegisterCommentUC registerCommentUC, UpdateComplaint updateComplaintUC, ToggleOfficialUserUC toggleOfficialUserUC, StatisticsUC statisticsUC, ViewCommentsOnComplaint viewCommentsOnComplaint) {
        this.viewUser = viewUser;
        this.registerUserUC = registerUserUC;
        this.officialOrganUC = officialOrganUC;
        this.viewCommentUC = viewCommentUC;
        this.viewComplaintUC = viewComplaintUC;
        this.registerComplaintUC = registerComplaintUC;
        this.registerCommentUC = registerCommentUC;
        this.updateComplaintUC = updateComplaintUC;
        this.toggleOfficialUserUC = toggleOfficialUserUC;
        this.statisticsUC = statisticsUC;
        this.viewCommentsOnComplaint = viewCommentsOnComplaint;
    }

    @PostMapping("/registerUser")
    @CrossOrigin(origins = "*")
    public boolean cadastraUsuario(@RequestBody final User user) {
        return registerUserUC.run(user);
    }

    @PostMapping("/updateUser")
    @CrossOrigin(origins = "*")
    public boolean atualizaUsuario(@RequestParam Long userID) {
        return toggleOfficialUserUC.run(userID);
    }

    @PostMapping("/registerComplaint")
    @CrossOrigin(origins = "*")
    public boolean cadastraComplaint(Long userId, @RequestBody Complaint complaint) {
        return registerComplaintUC.run(userId, complaint);
    }

    @PostMapping("/updateComplaint")
    @CrossOrigin(origins = "*")
    public void atualizaComplaint(Long complaintId, Long userId, @RequestBody final Complaint complaint) {
        updateComplaintUC.run(complaintId, userId, complaint);
    }

    @PostMapping("/commentOnComplaint")
    @CrossOrigin(origins = "*")
    public boolean comentaComplaint(Long complaintId, Long userId, @RequestBody final Comment comment) {
        return registerCommentUC.run(complaintId, userId, comment);
    }

    @PostMapping("/commentOnComplaintOfficial")
    @CrossOrigin(origins = "*")
    public boolean comentaComplaintOfficial(Long complaintId, Long userId, boolean hasBeenSolved, @RequestBody final Comment comment) {
        return registerCommentUC.run(complaintId, userId, hasBeenSolved, comment);
    }

    @GetMapping("/isUserOfficialOrgan")
    @CrossOrigin(origins = "*")
    public boolean isUserOfficialOrgan(@RequestParam final Long userID) {
        return officialOrganUC.run(userID);
    }

    @GetMapping("/viewComplaints")
    @CrossOrigin(origins = "*")
    public List<ComplaintDTO> viewComplaints() {
        return viewComplaintUC.run();
    }

    @GetMapping("/viewComplaint")
    @CrossOrigin(origins = "*")
    public Complaint viewComplaint(@RequestParam final Long complaintID) {
        return viewComplaintUC.run(complaintID).get();
    }

    @GetMapping("/viewCommentsOnComplaint")
    @CrossOrigin(origins = "*")
    public List<Comment> viewComments(@RequestParam final Long complaintID) {
        return viewCommentsOnComplaint.run(complaintID);
    }

  //  @GetMapping("/getStatistics")
  //  @CrossOrigin(origins = "*")
  //  public StatisticsDTO viewStatistics(@RequestBody final String category) {
  //      return statisticsUC.run(category);
  //  }

    @GetMapping("/users")
    @CrossOrigin(origins = "*")
    public List<UserDTO> viewAllUsers(){
        return viewUser.run();
    }

    @GetMapping("/user")
    @CrossOrigin(origins = "*")
    public UserDTO specificUser(@RequestParam Long userId){
        return viewUser.run(userId);
    }

    @GetMapping("/viewAllComments")
    @CrossOrigin(origins = "*")
    public List<Comment> run(){
        return viewCommentUC.run();
    }

    @GetMapping("/statistics")
    @CrossOrigin(origins = "*")
    public StatisticsDTO viewStatistics(@RequestParam String filter){
        return statisticsUC.run(filter);
    }
}