package com.controller;

import java.util.List;
import java.util.Scanner;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.StudentTestDao;
import com.dao.StudentTestDaoImpl;
import com.model.Student;
import com.model.StudentTest;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StudentDao sdao=new StudentDaoImpl();
		StudentTestDao sdtdao = new StudentTestDaoImpl();		
		do
		{
			System.out.println(" ******* Welcome To Training Academy ******");
			System.out.println("1|Add new student");
			System.out.println("2|Delete/Deactivate student");
			System.out.println("3|Modify student details");
			System.out.println("4|Veiw student list");
			System.out.println("*********************************************");
			System.out.println("5|Add marks of students ");
			System.out.println("6|Update marks of students");
			System.out.println("7|Delete results of students. ");
			System.out.println("8|Veiw Student Marks  list ");
			System.out.println("9||REPORT||");
			System.out.println("0|Exit");
		    System.out.println("**********************************************");
			System.out.println("enter your choice::");
			int ch = sc.nextInt();
			
			switch (ch) 
			{
			case 1:
				System.out.println("Enter Student_id , Student_name , Mobile , batch_id ");
				int sid= sc.nextInt();
				String nm = sc.next();
				long mob = sc.nextLong();
				int batch = sc.nextInt();
				Student s = new Student(sid,nm,mob,batch);
				
				boolean isinsert = sdao.addStudent(s);
				if(isinsert)
					System.out.println("Record added successfully");
				else
					System.out.println("Unsuccessful insertion");
				break;

			case 2:
				System.out.println("enter student id to delete");
				int stid=sc.nextInt();
				boolean isdelete = sdao.deleteStudent(stid);
					System.out.println("Row deleted....");
					break;
				
			case 3:
				System.out.println("Modification");
				System.out.println("Enter student id to update");
				int id = sc.nextInt();
				System.out.println("Enter name to update");
				String sname = sc.next();
				System.out.println("Enter mobile no to update");
				long mobile = sc.nextLong();
				System.out.println("Enter batch id to update");
				int bid = sc.nextInt();
				Student stu = new Student(id,sname,mobile,bid);
				
				boolean isupdated = sdao.updateStudent(stu);
				if(isupdated)
					System.out.println("Record update successfully");
				else
					System.out.println("Unsuccessful Modification");
				break;
				
			case 4:
				List<Student> list = sdao.getAllStudent();
				for(Student ss : list)
				{
					System.out.println(ss.getStudent_id()+ "||" +ss.getStudent_name()  +ss.getMobile()  +ss.getBatch_id());
				}
				break;	
				
			case 5:
				System.out.println("Enter Student_id , Test_id and Marks ");
				int stuid= sc.nextInt();
				int tid = sc.nextInt();
				int marks = sc.nextInt();
				StudentTest st = new StudentTest(stuid,tid,marks);
				
				boolean ismarksinsert = sdtdao.addStudentMarks(st);
				if(ismarksinsert)
					System.out.println("Record added successfully");
				else
					System.out.println("Unsuccessful insertion");
				break;	
				
			case 6:
				System.out.println("Modification");
				System.out.println("Enter student id to update");
				int s_id = sc.nextInt();
				System.out.println("Enter test_id to update");
				int t_id = sc.nextInt();
				System.out.println("Enter marks to update");
				int t_marks = sc.nextInt();
				StudentTest stupdate = new StudentTest(s_id,t_id,t_marks);
				
				boolean ismarksupdated = sdtdao.updateStudentMarks(stupdate);
				if(ismarksupdated)
					System.out.println("Record update successfully");
				else
					System.out.println("Unsuccessful Modification");
				break;
				
			case 7:
				System.out.println("enter student id to delete marks");
				int studid=sc.nextInt();
				boolean ismarksdelete = sdtdao.deleteStudentMarks(studid);
					System.out.println("Row deleted....");
					break;
			case 8:
				List<StudentTest> listmarks = sdtdao.getAllStudentTest();
				System.out.println("hey"+listmarks);
				for(StudentTest sstt : listmarks)
				{
					System.out.println(sstt.getStudent_id()+ "||" +sstt.getTest_id()  +sstt.getMarks());
				}
				break;		
			
			case 9 :
				System.out.println("Reports");
				System.out.println("1|Merit list of students for any given batch \n 2|Merit list of students for all batches \n 3|Show batch name and trainer name of the batch whose average percentage result is best  \n 4|Show name of the batch where maximum students have failed. ");
				int character = sc.nextInt();
				if(character ==1)
				{
					
				}
			}	
			
			if(ch==0)
				break;
			
		} while (true);
		System.out.println("Thanks!!");
		}
	

	}


