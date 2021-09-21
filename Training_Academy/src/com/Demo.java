package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/academy", "root", "root");
			//establish connection
			Statement st = con.createStatement();
			int i = st.executeUpdate("insert into Trainer values(101, 'Deepa',1234567890) ");
			System.out.println("Record added succussfully "+i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
