package com.dal.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {
	private  String link;
	private  String username;
	private  String password;
	
	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


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

	

	public MyDbConnection() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MyDbConnection(String link, String username, String password) {
		super();
		this.link = link;
		this.username = username;
		this.password = password;
	}



	@Override
	public String toString() {
		return "MyDbConnection [link=" + link + ", username=" + username + ", password=" + password + "]";
	}


	static Connection con=null;
	
	public Connection getMyConnection() {

		try {
			//System.out.println(link);
			//System.out.println(username);
			//System.out.println(password);
			con = DriverManager.getConnection(link,username,password);
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "312phani");
			//System.out.println(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}
	

	/*public static void main(String[] args) {
		System.out.println(getMyConnection());

	}*/

}
