package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;

import TF01.TF.Business.Services.ComplaintService;
import TF01.TF.Application.DTOs.ComplaintDTO;
import TF01.TF.Business.Entities.Complaint;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ViewComplaint {
	private ComplaintService complaintService; 

	@Autowired
	public ViewComplaint(ComplaintService complaintService){
		this.complaintService = complaintService;
	}

	public Optional<Complaint> run(Long filter){
		return complaintService.specificComplaint(filter);
	}
	
	public List<ComplaintDTO> run(){
		return complaintService.allComplaintsDTO();
	}
}
