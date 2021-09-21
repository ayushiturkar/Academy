package com.controller;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.model.Student;

public class MainEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StudentDao sdao=new StudentDaoImpl();
				
				
		do
		{
			System.out.println(" ******* Welcome To Training Academy ******");
			System.out.println("1.Add new student");
			System.out.println("2.Delete/Deactivate student");
			System.out.println("3.Modify student details");
			System.out.println("4.Add marks of students  ");

			System.out.println("5.Update marks of students ");
			System.out.println("6.Delete results of students. ");
			System.out.println("0-Exit");
		
			System.out.println("enter your choice::");
			int ch = sc.nextInt();
			
			switch (ch) 
			{
			case 1:
				System.out.println("Enter Student_id , Student_name , Mobile_no , batch_id ");
				int sid= sc.nextInt();
				String nm = sc.nextLine();
				int mob = sc.nextInt();
				int batch = sc.nextInt();
				Student s = new Student(sid,nm,mob,batch);
				
				boolean isinsert = sdao.addStudent(s);
				if(isinsert)
					System.out.println("Record added successfully");
				else
					System.out.println("Unsuccessful insertion");
				break;

			case 2:
			
			}	
			if(ch==0)
				break;
			
		} while (true);
		System.out.println("Thanks!!");
		}
	

	}


