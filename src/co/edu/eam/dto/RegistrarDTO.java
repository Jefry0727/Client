package co.edu.eam.dto;

import java.io.Serializable;

public class RegistrarDTO implements Serializable {

	private String user;
	private String password;
	
	public RegistrarDTO(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
