package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.UserService;
import TF01.TF.Business.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Component
public class ToggleOfficialUserUC {
	private UserService userService;

	@Autowired
	public ToggleOfficialUserUC(UserService userService){
		this.userService = userService;
	}

	public boolean run(Long id){
		User user = userService.findById(id).get();
        user.toggleIsOfficialOrgan();
        return true;
	}
}
