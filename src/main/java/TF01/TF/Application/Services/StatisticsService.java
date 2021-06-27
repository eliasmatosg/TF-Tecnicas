package TF01.TF.Application.Services;

import java.util.List;
import java.util.stream.Collectors;
import TF01.TF.Application.DTOs.*;
import TF01.TF.Business.Entities.*;
import TF01.TF.Business.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsService{
	private IComplaintRepo complaintRep;

	//entidades recomendadas usuários reclamacao e comentários
	@Autowired
	public StatisticsService(IComplaintRepo complaintRepo){
		this.complaintRep = complaintRepo;
	}

	public StatisticsDTO getStatistics(String filter){
		int totalComplaints =  complaintRep
			.allComplaints()
			.size();
		
		int totalComments = complaintRep
		.allComments()
		.size();
		

	
	}
	
	

}