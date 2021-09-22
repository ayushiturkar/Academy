package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configuration.DBConnect;
import com.model.Student;
import com.mysql.cj.xdevapi.Statement;

public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean addStudent(Student s) {
		
		try(Connection connection = DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("insert into student values(?,?,?,?)"))
		{
			pst.setInt(1, s.getStudent_id());
			pst.setString(2, s.getStudent_name());
			pst.setLong(3, s.getMobile());
	        pst.setInt(4, s. getBatch_id());
			
			pst.executeUpdate();
			System.out.println("Data added successfully.....");
		} catch (SQLException e) {

			System.out.println("Plz add sufficient data.....");
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		 try {
			 try(Connection connection = DBConnect.getConnection();
			 PreparedStatement pst = connection.prepareStatement("delete from student where student_id=?"))
		       {
				 pst.setInt(1, id);
				 pst.executeUpdate();
		    return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		try {
	    	Connection connection = DBConnect.getConnection();
	        PreparedStatement pst = connection.prepareStatement("UPDATE student SET student_name=?, mobile=?, batch_id=? WHERE student_id=?");
	       
			pst.setString(1, s.getStudent_name());
			pst.setLong(2, s.getMobile());
	        pst.setInt(3, s. getBatch_id());
	        pst.setInt(4, s.getStudent_id());
	       int recordUpdate = pst.executeUpdate();
	     if(recordUpdate > 0)
	    	 return true;
	    
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		return false;
	}

	@Override
	public List<Student> getAllStudent() {
		try(Connection connection= DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select * from student"))
		{
			ArrayList<Student> studentlist = new ArrayList<>();
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Student s = new Student();
				s.setStudent_id(rs.getInt(1));
				s.setStudent_name(rs.getString(2));
				s.setMobile(rs.getLong(3));
				s.setBatch_id(rs.getInt(4));
				studentlist.add(s);
			}
			return studentlist;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return null;
	}

}
