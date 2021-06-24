package TF01.TF.Application.DTOs;

public class StatisticsDTO {
	private int totalComplaints;
	private double averageComments;
	private double percentSolvedOrClosed;
	private double percentAnsweredAndClosedComplaints;

	public StatisticsDTO(int totalComplaints, double averageComments, double percentSolvedOrClosed,double percentAnsweredAndClosedComplaints){
		this.totalComplaints = totalComplaints;
		this.averageComments = averageComments;
		this.percentSolvedOrClosed = percentSolvedOrClosed;
		this.percentAnsweredAndClosedComplaints = percentAnsweredAndClosedComplaints;
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

	public double getPercentAnsweredAndClosedComplaints() {
		return percentAnsweredAndClosedComplaints;
	}
}
