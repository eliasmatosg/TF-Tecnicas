package TF01.TF.Application.UseCases;

import org.springframework.stereotype.Component;
import TF01.TF.Business.Services.UserService;
import TF01.TF.Business.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class IsOfficialOrganUC {
	private UserService userService;

	@Autowired
	public IsOfficialOrganUC(UserService userService){
		this.userService = userService;
	}

	public boolean run(Long id){
		try {
			User user = userService.findById(id).get();
        	return user.getIsOfficialOrgan();
		} catch (NoSuchElementException err) {
			System.out.println(err.getMessage());
			return false;
		}
		
	}
}
