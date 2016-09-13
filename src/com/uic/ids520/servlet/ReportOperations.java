package com.uic.ids520.servlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.uic.ids520.bean.*;

public class ReportOperations {
	ResultSet rs;
	ErrorMessageBean eb;
	DatabaseAccessBean da;
	
	public ReportOperations() {
		super();
		eb = new ErrorMessageBean();
		da = new DatabaseAccessBean(eb);
		
	}

	public ArrayList<UserBean> selectAll()
	  {
		ArrayList<UserBean> tests = new ArrayList<UserBean>();
		UserBean tb;
		if(da.connect().equals("SUCCESS")){
			String query="SELECT * from student";
			if(da.processQuery(query).equals("SUCCESS"))
			{				

				try {
					rs = da.getResultSet();
					while(rs.next())
					{
				
						tb = new UserBean();
						tb.setFirstName(rs.getString(2));
						tb.setLastName(rs.getString(3));
						tb.setMajor(rs.getString(5));
						tb.setPassword(rs.getString(4));
						tb.setUserId(rs.getString(1));
						tests.add(tb);
					
					}
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 return tests;
	  }
	
	public ArrayList<String> selectRegisteredCourses(String studentId)
	{
		ArrayList<String> al = new ArrayList<String>();
		if(da.connect().equals("SUCCESS")){
			String query="SELECT course_name from registration r, course c" +
					" where r.course_number=c.course_number and r.user_id='"+studentId+"'";
			if(da.processQuery(query).equals("SUCCESS"))
			{
		
				try {
					rs = da.getResultSet();
					while(rs.next())
					{
						al.add(rs.getString(1));
					}
			
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		return al;
		
	}
	
	public ArrayList<CourseBean> selectAllCourses()
	{
		  CourseBean tb;
		  ArrayList<CourseBean> tests = new ArrayList<CourseBean>();
		  
		  if(da.connect().equals("SUCCESS")){
				String query="SELECT * from course";
				if(da.processQuery(query).equals("SUCCESS"))
				{
					try {
						rs = da.getResultSet();
						while(rs.next())
						{
							tb = new CourseBean();
							tb.setCourseNumber(rs.getString(1));
							tb.setCourseName(rs.getString(2));
							tb.setCourseMajor(rs.getString(3));
							tests.add(tb);			
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		  }
	  
	  	return tests;
		
	}
	
	public ArrayList<String> selectRegisteredStudents(String courseID)
	{
		ArrayList<String> al = new ArrayList<String>();
		if(da.connect().equals("SUCCESS")){
			String query="SELECT c.user_id,first_name,last_name from registration r, student c" +
					" where r.user_id=c.user_id and r.course_number='"+courseID+"'";
			if(da.processQuery(query).equals("SUCCESS"))
			{  
				try {
					rs = da.getResultSet();
					while(rs.next())
					{
						al.add(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
					}
			
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return al;
		
	}
	
	public ArrayList<String[]> selectAllRegistered()
	{
		ArrayList<String[]> al = new ArrayList<String[]>();
		if(da.connect().equals("SUCCESS")){
			String query="SELECT s.user_id,s.first_name,s.last_name, c.course_number, c.course_name "+
					"from registration r, student s, course c" +
					" where r.user_id=s.user_id and r.course_number=c.course_number";
			if(da.processQuery(query).equals("SUCCESS"))
			{   
				try {
					rs = da.getResultSet();
					String[] result;
					while(rs.next())
					{
						result = new String[5];
						for(int i=1;i<=5;i++)
						{
							result[i-1]=rs.getString(i);
							System.out.println(result[i-1]);
						}
						al.add(result);
					}
			
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return al;
	}
	/*  public static void main(String args[])
	  {
		  ReportOperations dop = new ReportOperations();
		  ArrayList<UserBean> al = new ArrayList<UserBean>();
		  ArrayList<CourseBean> bn = new ArrayList<CourseBean>();
		  ArrayList<String> bl = new ArrayList<String>();
		  ArrayList<String> an = new ArrayList<String>();
		  ArrayList<String[]> arb = new ArrayList<String[]>();
		  al = dop.selectAll();
		  bn = dop.selectAllCourses();
		  bl = dop.selectRegisteredCourses("avishw4");
		  an = dop.selectRegisteredStudents("BUS 401");
		  arb = dop.selectAllRegistered();
		  al = dop.selectAll();
		  for (int i=0;i<al.size();i++)
		  {
			  System.out.println(al.get(i).getPassword());
			  
		  }
		  
		  for (int i=0;i<bl.size();i++)
		  {
			  System.out.println(bl.get(i));
			  
		  }
		  
		  for(int i=0;i<bn.size();i++)
		  {
			  System.out.println(bn.get(i).getCourseName());
		  }
		  
		  for(int i=0;i<an.size();i++)
		  {
			  System.out.println(an.get(i));
		  }
		 
		  for(int i=0;i<arb.size();i++)
		  {
			  for(int j=0;j<arb.get(i).length;j++)
			  {
				  System.out.print(arb.get(i)[j]+" ");
			  }
			  System.out.println();
		  }
	  }*/
}
