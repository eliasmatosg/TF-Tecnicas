package TF01.TF.Adapters.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import TF01.TF.Business.Entities.*;
import TF01.TF.Business.Repositories.*;
import TF01.TF.Adapters.Application.DTOs.*;
import TF01.TF.Adapters.Application.UseCases.*;
import TF01.TF.Application.UseCases.IsOfficialOrganUC;
import TF01.TF.Application.UseCases.RegisterUserUC;

@RestController
@RequestMapping("/user")
public class UserController {
    private RegisterUserUC registerUserUc;
    private IsOfficialOrganUC officialOrganUC;

    @Autowired
    public UserController(RegisterUserUC registerUserUc, IsOfficialOrganUC officialOrganUC) {
        this.registerUserUc = registerUserUc;
        this.officialOrganUC = officialOrganUC;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public boolean cadastraUsuario(@RequestBody final User user) {
        return registerUserUc.run(user);
    }

    @GetMapping("/isOfficialOrgan")
    @CrossOrigin(origins = "*")
    public boolean isUserOfficialOrgan(@RequestParam final String userID) {
        return officialOrganUC.run(userID);
    }
}