package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.configuration.DBConnect;
import com.model.StudentTest;
import com.mysql.cj.xdevapi.Statement;


public class StudentTestDaoImpl implements StudentTestDao {
	
	

		@Override
		public boolean addStudentMarks(StudentTest st) {
			
			try(Connection connection = DBConnect.getConnection();
					PreparedStatement pst = connection.prepareStatement("insert into student_test values(?,?,?)"))
			{
				pst.setInt(1, st.getStudent_id());
				pst.setInt(2, st.getTest_id());
				pst.setInt(3, st.getMarks());
				
				pst.executeUpdate();
				System.out.println("Data added successfully.....");
			} catch (SQLException e) {

				System.out.println("Plz add sufficient data.....");
				e.printStackTrace();
			}

			return false;
		}

		@Override
		public boolean deleteStudentMarks(int id) {
			 try {
				 try(Connection connection = DBConnect.getConnection();
				 PreparedStatement pst = connection.prepareStatement("delete from student_test where student_id=?"))
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
		public boolean updateStudentMarks(StudentTest st) {
			try {
		    	Connection connection = DBConnect.getConnection();
		        PreparedStatement pst = connection.prepareStatement("UPDATE student_test SET marks=? WHERE student_id=? and test_id=?");
		       
		        pst.setInt(1, st.getMarks());
				pst.setInt(2,st.getStudent_id());
				pst.setInt(3, st.getTest_id());
				 int recordUpdate = pst.executeUpdate();
			     if(recordUpdate > 0)
			    	 return true;
			    
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
				return false;
		}

		

		
		 public List<StudentTest> getAllStudentTest() {
			try(Connection connection= DBConnect.getConnection();
					PreparedStatement pst = connection.prepareStatement("select * from student_test"))
			{
				ArrayList<StudentTest> studentTestlist = new ArrayList<>();
				ResultSet rest = pst.executeQuery();
				
				while(rest.next())
				{
					StudentTest test = new StudentTest();
					test.setStudent_id(rest.getInt(1));
					test.setTest_id(rest.getInt(2));
					test.setMarks(rest.getInt(3));
					studentTestlist.add(test);
				}
				return studentTestlist;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
			return null;
		} 
		 
			

	}  


