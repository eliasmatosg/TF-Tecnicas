package TF01.TF.Adapters.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import TF01.TF.Business.Entities.*;
import TF01.TF.Business.Repositories.*;
import TF01.TF.Adapters.Application.DTOs.*;
import TF01.TF.Adapters.Application.UseCases.*;
import TF01.TF.Application.DTOs.StatisticsDTO;
import TF01.TF.Application.UseCases.RegisterCommentUC;
import TF01.TF.Application.UseCases.RegisterComplaintUC;
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

    @Autowired
    public Controller(RegisterUserUC registerUserUC, IsOfficialOrganUC isOfficialOrganUC, ViewComplaint viewComplaintUC, ViewComment viewCommentUC, RegisterComplaintUC registerComplaintUC, RegisterCommentUC registerCommentUC, UpdateComplaint updateComplaintUC, ToggleOfficialUserUC toggleOfficialUserUC, StatisticsUC statisticsUC) {
        this.registerUserUC = registerUserUC;
        this.officialOrganUC = officialOrganUC;
        this.viewCommentUC = viewCommentUC;
        this.viewComplaintUC = viewCommentUC;
        this.registerComplaintUC = registerUserUC;
        this.registerCommentUC = registerCommentUC;
        this.updateComplaintUC = updateComplaintUC;
        this.toggleOfficialUserUC = toggleOfficialUserUC;
        this.statisticsUC = statisticsUC;
    }

    @PostMapping("/registerUser")
    @CrossOrigin(origins = "*")
    public boolean cadastraUsuario(@RequestBody final User user) {
        return registerUserUc.run(user);
    }

    @PostMapping("/updateUser")
    @CrossOrigin(origins = "*")
    public boolean atualizaUsuario(@RequestParam final String userID) {
        return toggleOfficialUserUC.run(userID);
    }

    @PostMapping("/registerComplaint")
    @CrossOrigin(origins = "*")
    public boolean cadastraComplaint(@RequestBody final Complaint complaint) {
        return registerComplaintUC.run(complaint);
    }

    @PostMapping("/updateComplaint")
    @CrossOrigin(origins = "*")
    public boolean atualizaComplaint(@RequestParam final String complaintID, @RequestBody final Complaint complaint) {
        return updateComplaintUC.run(complaintID, complaint);
    }

    @PostMapping("/commentOnComplaint")
    @CrossOrigin(origins = "*")
    public boolean comentaComplaint(@RequestParam final String complaintID, @RequestBody final Comment comment, @RequestBody final boolean hasBeenSolved) {
        return registerCommentUC.run(complaintID, comment, hasBeenSolved);
    }

    @GetMapping("/isUserOfficialOrgan")
    @CrossOrigin(origins = "*")
    public boolean isUserOfficialOrgan(@RequestParam final String userID) {
        return officialOrganUC.run(userID);
    }

    @GetMapping("/viewComplaints")
    @CrossOrigin(origins = "*")
    public boolean viewComplaints() {
        return viewComplaintUC.run();
    }

    @GetMapping("/viewComplaint")
    @CrossOrigin(origins = "*")
    public boolean viewComplaint(@RequestParam final String complaintID) {
        return viewComplaintUC.run(complaintID);
    }

    @GetMapping("/viewCommentsOnComplaint")
    @CrossOrigin(origins = "*")
    public boolean viewComments(@RequestParam final String complaintID) {
        return viewComplaintUC.run(complaintID);
    }

    @GetMapping("/getStatistics")
    @CrossOrigin(origins = "*")
    public boolean viewStatistics(@RequestBody final String category) {
        return statisticsUC.run(category);
    }
    
}