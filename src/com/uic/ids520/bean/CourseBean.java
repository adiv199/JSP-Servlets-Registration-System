package com.uic.ids520.bean;

public class CourseBean {
	private String courseName;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseMajor() {
		return courseMajor;
	}
	public void setCourseMajor(String courseMajor) {
		this.courseMajor = courseMajor;
	}
	private String courseNumber;
	private String courseMajor;
}
