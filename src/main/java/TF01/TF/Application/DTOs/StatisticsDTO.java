package TF01.TF.Application.DTOs;

public class StatisticsDTO {
	private int totalComplaints;
	private double averageComments;
	private double percentSolvedOrClosed;
	private double percentAnsweredAndClosedByGov;

	public StatisticsDTO(int totalComplaints, double averageComments, double percentSolvedOrClosed,double percentAnsweredAndClosedByGov){
		this.totalComplaints = totalComplaints;
		this.averageComments = averageComments;
		this.percentSolvedOrClosed = percentSolvedOrClosed;
		this.percentAnsweredAndClosedByGov = percentAnsweredAndClosedByGov;
	}

	public int getTotalComplaints() {
		return totalComplaints;
	}

	public double getAverageComments() {
		return averageComments;
	}

	public double getPercentSolvedOrClosed() {
		return percentSolvedOrClosed;
	}

	public double getPercentAnsweredAndClosedByGov() {
		return percentAnsweredAndClosedByGov;
	}
}
