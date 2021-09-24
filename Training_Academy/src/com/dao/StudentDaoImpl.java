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
	/*public Map<String,Integer> getStudentWiseCount()
	{
		HashMap<String,Integer> hm=new HashMap<>();
		try(Connection connection=DBConnect.getConnection();
				Statement s=connection.createStatement())
		{
			ResultSet rs=s.executeQuery("select count(*) , st.marks, s.sname from student_test st inner join student s on s.student_id = st.student_id  group by s.student_id;");
				while(rs.next())
				{
					hm.put(rs.getString(1), rs.getInt(2));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hm;
	}
*/
	@Override
	public void meritListTopFive(int batch_id) {
		try(Connection connection= DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select s.student_id , s.student_name , r.marks from student s inner join student_test r on s.student_id = r.student_id where batch_id = ? and marks > 25 order by marks desc limit 5");
		    )
		{
			   pst.setInt(1, batch_id);
			ResultSet rs = pst.executeQuery();
			System.out.println("Top Five Merit list:- ");
			
			while(rs.next())
			{
				System.out.println("Student-Id:- "+rs.getInt("student_id"));
				System.out.println("Studnet-Name:- "+rs.getString("student_name"));
				System.out.println("Marks:- "+rs.getInt("marks"));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void meritListTopTen() {
		// TODO Auto-generated method stub
		try(Connection connection= DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select s.student_id , s.student_name , r.marks , b.batch_name from student s inner join student_test r on s.student_id = r.student_id inner join batch b on b.batch_id = s.batch_id where marks>25 order by marks desc limit 10");
		    )
		{
			  // pst.setInt(1, batch_id);
			ResultSet rs = pst.executeQuery();
			System.out.println("Top Ten Merit list:- ");
			
			while(rs.next())
			{
				System.out.println("Student-Id:- "+rs.getInt("student_id"));
				System.out.println("Studnet-Name:- "+rs.getString("student_name"));
				System.out.println("Marks:- "+rs.getInt("marks"));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		
	}

	@Override
	public void bestResult() {
		// TODO Auto-generated method stub
		try(Connection connection= DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select trainer_name ,batch_name,avg(marks) from batch b,student s,student_test st,trainer t where \r\n" + 
						"s.batch_id=b.batch_id and st.student_id=s.student_id and t.trainer_id=b.trainer_id group by batch_name order by avg(marks) desc limit 1 ");
		    )
		{
			  // pst.setInt(1, batch_id);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				System.out.println("Trainer-Name:- "+rs.getString("trainer_name"));
				System.out.println("Batch-Name:- "+rs.getString("batch_name"));
				//System.out.println("Avg(Marks):- "+rs.getInt("marks"));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void batchName() {
		// TODO Auto-generated method stub
		try(Connection connection= DBConnect.getConnection();
				PreparedStatement pst = connection.prepareStatement("select s.batch_id, r.batch_name from student s inner join batch r on s.batch_id = r.batch_id \r\n" + 
						"inner join student_test st on st.student_id=s.student_id  where marks<25 order by marks desc;");
		    )
		{
			  // pst.setInt(1, batch_id);
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				//System.out.println("Batch-id:- "+rs.getInt("batch_id"));
				System.out.println("Batch-Name:- "+rs.getString("batch_name"));
				//System.out.println("Avg(Marks):- "+rs.getInt("marks"));
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
