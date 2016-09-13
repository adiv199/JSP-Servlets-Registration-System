package com.uic.ids520.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uic.ids520.bean.*;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ReportServlet/*")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

    /**
     * Default constructor. 
     */
    public ReportServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
      /*  ServletContext context = config.getServletContext();
        
        ar = new ArrayList<TestBean>();
		ar = df.selectAll();
		
		for(TestBean a : ar)
		{
			System.out.println("From servlet int: "+ a.getFirstName());
		}
		//context.setAttribute("list", ar);*/
        
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		doPost(request, response);
		 
		/*RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/serverReports.jsp");
		requestDispatcher.forward(request, response);*/
		
		
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String base = "/jsp/";
	    String url = "index.jsp";
		String action = request.getParameter("action");
		
		if(action.equals("studentByCourse"))
		{
			ReportOperations df = new ReportOperations();
	        List<CourseBean> ar = new ArrayList<CourseBean>();
	        ArrayList<String> stud = new ArrayList<String>();
			ar = df.selectAllCourses();
			
			
			request.setAttribute("list", ar);
			
			String selectedvalue  =  request.getParameter("courses");
			if(selectedvalue==null)
			{
				stud.add("You need to select a value!");
			}
			else
			{
				request.setAttribute("answer", "Students for course: "+selectedvalue);
				stud = df.selectRegisteredStudents(selectedvalue);
				if(stud.isEmpty())
					stud.add("No student has taken this course");
				
				
			}
			request.setAttribute("studentlist", stud);
			url = "ReportByCourse.jsp";
		}
		else if(action.equals("courseByStudent"))
		{
			ReportOperations df = new ReportOperations();
			List<UserBean> ar = new ArrayList<UserBean>();
			ArrayList<String> cour = new ArrayList<String>();
			ar = df.selectAll();
			
			
		request.setAttribute("list", ar);
		
		String selectedvalue  =  request.getParameter("students");
		System.out.println("This is the selected value"+selectedvalue);
		if(selectedvalue==null)
		{
			cour.add("You need to select a student!");
		}
		else
		{
			request.setAttribute("answer", "courses for: "+selectedvalue);
			cour = df.selectRegisteredCourses(selectedvalue);
			if(cour.isEmpty())
			{
				cour.add("This student has not selected any course");
			}
			
		}
			request.setAttribute("courselist", cour);
			url = "reportByStudent.jsp";
		}
		
		else if(action.equals("studentAndCourse"))
		{
			ReportOperations df = new ReportOperations();
			List<String[]> ar = new ArrayList<String[]>();
			
			ar = df.selectAllRegistered();
			
			request.setAttribute("list", ar);
		
			url = "CourseAndStudents.jsp";
		}
		else if(action.equals("goBack")||action.equals("goToReportsMenu"))
		{
		
			url = "reports.jsp";
		}
		else if(action.equals("goBackToHome"))
		{
		
			url = "homePage.jsp";
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/"+url);
		requestDispatcher.forward(request, response);
		
	
            
      }
	
	
	
}


