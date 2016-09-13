package com.uic.ids520.bean;

public class RegistrationBean {
	private UserBean user;
	private CourseBean course;
	
	public CourseBean getCourse() {
		return course;
	}
	public void setCourse(CourseBean course) {
		this.course = course;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
}
