package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.UserService;
import TF01.TF.Business.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RegisterUserUC {
	private UserService userService;

	@Autowired
	public RegisterUserUC(UserService userService){
		this.userService = userService;
	}

	public void run(User user){
		userService.register(user);
	}
	
}
