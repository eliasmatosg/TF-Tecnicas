package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Business.Entities.Complaint;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RegisterComplaintUC {
	private ComplaintService complaintService;

	@Autowired
	public RegisterComplaintUC(ComplaintService complaintService){
		this.complaintService = complaintService;
	}

	public void run(long userId, Complaint complaint){
		complaintService.register(userId, complaint);
	}
		
}
