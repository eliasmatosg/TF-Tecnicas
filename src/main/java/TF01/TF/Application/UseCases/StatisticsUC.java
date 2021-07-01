package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Application.Services.StatisticsService;
import TF01.TF.Application.DTOs.StatisticsDTO;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class StatisticsUC {
	private StatisticsService statisticsService;

	@Autowired
	public StatisticsUC(StatisticsService statisticsService){
		this.statisticsService = statisticsService;
	}

	public StatisticsDTO run(String filter) {
		return statisticsService.run(filter);
	}
}
