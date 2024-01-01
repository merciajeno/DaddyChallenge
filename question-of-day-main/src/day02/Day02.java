package day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 
 * @author Issac.Rajan@gmail.com
 *
 */
public class Day02 {

	HashMap<String,StudentDTO> students =new HashMap<>();//to record the student ids
	public static void main(String[] args) throws IOException {
		Day02 day02 = new Day02();
		day02.readFileAndAddToStudentList();
		day02.print();

	}

	public void readFileAndAddToStudentList() throws IOException {
		// TODO update your file name here..
		String fileNameWithPath = "D:\\DaddyChallenge\\question-of-day-main\\src\\day02\\student.txt";
		BufferedReader br = new BufferedReader(new FileReader(new File(fileNameWithPath)));
       
        
		String line;
		while ((line = br.readLine()) != null) {
			// write your code here
			// logic
			// Split line using , as delimiter
			String[] parts = line.split(",");
			if(students.containsKey(parts[0]))
			{
				StudentDTO exists = students.get(parts[0]);
				//System.out.println(parts[2]);
				exists.addMark(parts[1], new BigDecimal(parts[2].trim()));
			}
			else
			{
				StudentDTO dto = new StudentDTO();
				dto.setStudentId(parts[0]);
				HashMap<String,BigDecimal> marksMap = new HashMap<>();
				marksMap.put(parts[1],new BigDecimal(parts[2].trim()));
				dto.setMarksMap(marksMap);
				students.put(parts[0], dto);
			}
			// find student Id in the list
			// if found, add subject/mark to the map
			// if not found, NEW record the list and add subject/mark to the map
			
		}

		// close the BufferedReader
        br.close();
	}

	public void print() {
		// write your code here
		for(String key:students.keySet())
		{
			Map<String,BigDecimal> studMap = students.get(key).getMarksMap();
			System.out.println(key);
			System.out.println(studMap);
		}
	}
}