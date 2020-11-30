package com.app.entities;

public class GeneralUserDTO {

    private String username;
    private String UID;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}
}