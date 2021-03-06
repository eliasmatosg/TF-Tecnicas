package TF01.TF.Application.Services;

import java.util.stream.Collectors;

import TF01.TF.Application.DTOs.StatisticsDTO;
import TF01.TF.Business.Repositories.IComplaintRepo;
import TF01.TF.Business.Repositories.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsService{
	private ICommentRepo commentRep;
	private IComplaintRepo complaintRep;
	//private IUserRepo userRep;

	//entidades recomendadas usuários reclamacao e comentários
	@Autowired
	public StatisticsService(ICommentRepo commentRep, IComplaintRepo complaintRep){
		this.commentRep = commentRep;
		this.complaintRep = complaintRep;
		//this.userRep = userRep;
	}

	public StatisticsDTO run(String filter){
		long totalComplaints =  complaintRep
			.allComplaints()
			.stream()
			.filter(s -> s.getCategory().equalsIgnoreCase(filter))
			.count();
		
		int totalComments = commentRep
		.allComments()
		.size();

		int filteredComments = complaintRep
		.allComplaints()
		.stream()
		.filter(s -> s.getCategory().equalsIgnoreCase(filter))
		.collect(Collectors.toList())
		.size();
		// .collect(Collectors.summingInt(Employee::getSalary)));
		double averageComments = totalComments/filteredComments;

		long allSolvedByFilter = complaintRep
		.allComplaints()
		.stream()
		.filter(s -> s.getCategory().equalsIgnoreCase(filter))
		.filter(s -> s.getHasBeenSolved() == true)
		.count();
		double percentSolved = ((int)allSolvedByFilter*100)/(int)totalComplaints;

		long solvedByGov = complaintRep
		.allComplaints()
		.stream()
		.filter(s -> s.getHasBeenSolved() == true && s.isSolvedByOfficialOrgan() == true)
		.count();	
		double solvedByGovPercentage = ((int)solvedByGov*100)/(int)totalComplaints;

		return new StatisticsDTO((int)totalComplaints, averageComments, percentSolved, solvedByGovPercentage);
	}
}