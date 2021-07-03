package TF01.TF.Application.DTOs;

import java.util.List;

public class UserDTO {
	private String name;
	private boolean isAdmin;
	private boolean isOfficialOrgan;

	public UserDTO(String name, boolean isAdmin, boolean isOfficialOrgan)
	{
		this.name = name;
		this.isAdmin = isAdmin;
		this.isOfficialOrgan = isOfficialOrgan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isOfficialOrgan() {
		return isOfficialOrgan;
	}

	public void setOfficialOrgan(boolean isOfficialOrgan) {
		this.isOfficialOrgan = isOfficialOrgan;
	}
	
}
