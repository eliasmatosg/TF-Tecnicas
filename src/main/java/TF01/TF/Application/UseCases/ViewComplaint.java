package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;

import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Business.Entities.Complaint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ViewComplaint {
	private ComplaintService complaintService; 

	@Autowired
	public ViewComplaint(ComplaintService complaintService){
		this.complaintService = complaintService;
	}

	public Complaint run(String filter){
		return complaintService.specificComplaint(filter);
	}
	
	public List<Complaint> run(){
		return complaintService.allComplaints();
	}
}
