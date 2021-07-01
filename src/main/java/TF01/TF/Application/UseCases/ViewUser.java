package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import TF01.TF.Business.Services.UserService;
import TF01.TF.Business.Entities.User;

import java.util.List;


@Component
public class ViewUser {
	private UserService userService; 

	@Autowired
	public ViewUser(UserService userService){
		this.userService = userService;
	}

	public List<User> run(){
		return userService.allUsers();
	}
	
	public List<User> run(String filter){
		return userService.specificUser(filter);
	}
}
