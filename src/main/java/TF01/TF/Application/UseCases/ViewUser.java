package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.NoSuchElementException;

import TF01.TF.Business.Services.UserService;
import TF01.TF.Application.DTOs.UserDTO;
import TF01.TF.Business.Entities.User;

import java.util.List;


@Component
public class ViewUser {
	private UserService userService; 

	@Autowired
	public ViewUser(UserService userService){
		this.userService = userService;
	}

	public List<UserDTO> run() {
		return userService.allUsers();
	}
	
	public UserDTO run(Long filter) {
		try {
			User user = userService.findById(filter).get();
			UserDTO returnUser = new UserDTO(user.getName(), user.getIsAdmin(), user.getIsOfficialOrgan());
			return returnUser;
		} catch (NoSuchElementException err) {
			System.out.println(err.getMessage());
			return null;
		} 
	}
}
