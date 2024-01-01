package day02;

import java.math.BigDecimal;
import java.util.Map;

public class StudentDTO {

	private String studentId;
	private Map<String, BigDecimal> marksMap;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Map<String, BigDecimal> getMarksMap() {
		return marksMap;
	}

	public void setMarksMap(Map<String, BigDecimal> marksMap) {
		this.marksMap = marksMap;
	}

	public void addMark(String subject, BigDecimal mark) {
		// write your code to add subject and marks to the map
		marksMap.put(subject, mark);
	}

	// test with / without overriding equals and hashcode methods

	// override toString method

}