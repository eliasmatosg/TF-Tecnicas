package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;

import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Business.Entities.Complaint;
import TF01.TF.Business.Entities.Comment;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ViewCommentsOnComplaint {
	private ComplaintService complaintService; 

	@Autowired
	public ViewCommentsOnComplaint(ComplaintService complaintService){
		this.complaintService = complaintService;
	}

	public List<Comment> run(Long filter){
		Complaint complaint = complaintService.specificComplaint(filter).get();
		return complaint.comments();
	}
}
