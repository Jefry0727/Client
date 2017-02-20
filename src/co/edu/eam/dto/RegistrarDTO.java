package co.edu.eam.dto;

import java.io.Serializable;

public class RegistrarDTO implements Serializable{

	private String user;
	private String password;
	private String ip;
	
	public RegistrarDTO(String user, String password,String ip) {
		super();
		this.user = user;
		this.password = password;
		this.ip = ip;
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

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	
}
