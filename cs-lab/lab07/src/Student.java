
public class Student {
	String name;
	float avgGrades;
	
	Student(String name, float avgGrades) {
		this.name = name;
		this.avgGrades = avgGrades;
	}
	
	public String toString() {
		return "Student: " + this.name + " " + this.avgGrades;
	}
	
	public boolean equals(Student s) {
		return false;
	}
}
