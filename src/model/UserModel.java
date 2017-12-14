package model;

import java.util.ArrayList;

public class UserModel {
	String user;
	String pass;
	ArrayList<UserModel> userList;

	public UserModel(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	public UserModel() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserModel [user=" + user + ", pass=" + pass + "]";
	}

	public ArrayList<UserModel> listUser() {
		userList = new ArrayList<>();
		userList.add(new UserModel("Shika", "luan"));
		userList.add(new UserModel("Nhat", "123"));
		userList.add(new UserModel("Hankyung", "123"));
		userList.add(new UserModel("Tung-MTP", "123"));
		return userList;
	}
}
