package streamsapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertOneObjectToOther {
	
	
	   public static void main(String args[]) {
		   
		   List<Student> students = Arrays.asList(new Student(1, "saeed ahmed", "sheikh", 500),
				         new Student(2, "zain ali", "sheikh", 900),
				         new Student(3, "hamad ali", "sheikh", 900),
				         new Student(1, "majid ali", "joyo", 400));
		   
		   List<PassedStudents> passedStudents = students.stream().filter(student -> student.getScore() >= 500).map(student -> {
			     PassedStudents passStudent = new PassedStudents();
			     passStudent.setId(student.getId());
			     passStudent.setName(student.getName());
			     passStudent.setScore(student.getScore());
			     return passStudent;
		   }).collect(Collectors.toList());
		   
		   passedStudents.forEach(student -> {
			   System.out.println(student.getId() + " " + student.getName());
		   });
		   
	   }

}

class Student{
	  
	   private int id;
	   private String name;
	   private String lastName;
	   private double score;
	public Student(int id, String name, String lastName, double score) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.score = score;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	   
}

class PassedStudents{
	  private int id;
	   private String name;
	   private double score;
	public PassedStudents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassedStudents(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	   
	   
}
