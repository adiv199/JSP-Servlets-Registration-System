package com.uic.ids520.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uic.ids520.bean.CourseBean;
import com.uic.ids520.bean.DatabaseAccessBean;
import com.uic.ids520.bean.ErrorMessageBean;
import com.uic.ids520.bean.UserBean;

/**
 * Servlet implementation class RetrieveCourses
 */
@WebServlet("/RetrieveCourses/*")
public class RetrieveCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CourseBean> courseList = null;
		String nextUrl = "homePage.jsp";
		HttpSession session = request.getSession();
		ErrorMessageBean errorMessageBean = new ErrorMessageBean();
		DatabaseAccessBean databaseAccessBean = new DatabaseAccessBean(errorMessageBean);
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		// TO BE REMOVED
		if(databaseAccessBean.connect().equals("SUCCESS")){
			String query="SELECT eligible_major, course_number, course_name FROM course ORDER BY eligible_major";
			if(databaseAccessBean.processQuery(query).equals("SUCCESS"))
			{
				courseList = new ArrayList<CourseBean>();
				try{
				while(databaseAccessBean.getResultSet().next()){
					CourseBean cb = new CourseBean();
					cb.setCourseNumber(databaseAccessBean.getResultSet().getString("course_number"));
					cb.setCourseName(databaseAccessBean.getResultSet().getString("course_name"));
					cb.setCourseMajor(databaseAccessBean.getResultSet().getString("eligible_major"));
					courseList.add(cb);
				}
				}
				catch(SQLException e){
					errorMessageBean.setErrorMessage(e.getErrorCode(),e.getSQLState(),e.getMessage());
					e.printStackTrace();
				}
				session.setAttribute("userBean", userBean);
				session.setAttribute("courseList", courseList);
				request.setAttribute("errorMessageBean", errorMessageBean);
				nextUrl = "courseregistration.jsp";
			}
			else{
				errorMessageBean.setErrorMessage("Trouble retrieving course information. Please try again or contact the website administrator if the problem persist.");
			}
			databaseAccessBean.closeDBResources();;
		}
		else{
			errorMessageBean.setErrorMessage("Trouble connecting to database. Please try again or contact the website administrator if the problem persist.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextUrl);
		dispatcher.forward(request, response);
	}
}
