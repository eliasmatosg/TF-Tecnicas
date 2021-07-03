package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Business.Entities.Complaint;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UpdateComplaint {
	private ComplaintService complaintService;

	@Autowired
	public UpdateComplaint(ComplaintService complaintService){
		this.complaintService = complaintService;
	}

	public void run(Long id, Long userId, Complaint complaint){
		complaintService.update(id, userId, complaint);
	}
}
