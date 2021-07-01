package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.UserService;
import TF01.TF.Business.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class IsOfficialOrganUC {
	private UserService userService;

	@Autowired
	public IsOfficialOrganUC(UserService userService){
		this.userService = userService;
	}

	public boolean run(String id){
		User user = userService.specificUser(id).get(0);
        return user.getIsOfficialOrgan();
	}
}
