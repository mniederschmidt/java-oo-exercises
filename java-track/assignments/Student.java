import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student {
	
	private String firstName;
	private String lastName;
	private int studentID;
	private int credits;
	private double GPA;
	private double qualityScoreTotal;
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentID = studentID;
		this.credits = 0;
		this.GPA = 0;
		this.qualityScoreTotal = 0;
	}
	
	public Student(Student mom, Student dad) {
		this.firstName = mom.getName();
		this.lastName = dad.getName();
		this.studentID = mom.getStudentID() + dad.getStudentID();
		this.GPA = (mom.getGPA() + dad.getGPA()) / 2;
		if (mom.getCredits() > dad.getCredits()) {
			this.credits = mom.getCredits();
		} 
		else {
			this.credits = dad.getCredits();
		}
		this.qualityScoreTotal = this.credits * this.GPA;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getStudentID() {
		return this.studentID;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public double getGPA() {
		return this.GPA;
	}
	
	private double calculateGPA() {
		if (this.credits > 0) {
			return round((this.qualityScoreTotal / this.credits), 3);
		} 
		else {
			return 0;
		}
	}
	
	public String getClassStanding() {
		if (this.credits < 30) {
			return "Freshman";
		} else if (this.credits < 60) {
			return "Sophomore";
		} else if (this.credits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	// Update: credits, qualityScoreTotal, and GPA
	public void submitGrade(double grade, int credits) {
		this.qualityScoreTotal += credits * grade;
		this.credits += credits;
		this.GPA = calculateGPA();
	}
	
	public double computeTuition() {
		double currentSemesterCost = 20000;
		int semestersStudied = this.credits / 15;
		int partialCredits = this.credits % 15;
		
		double totalCost = semestersStudied * currentSemesterCost;
		if (partialCredits > 0) {
			totalCost += partialCredits * 1333.33;
		}

		return totalCost;
		
//		BigDecimal costPerCreditHour = new BigDecimal(currentSemesterCost / 15);
//		BigDecimal credits = new BigDecimal(this.credits);
//		BigDecimal tuitionCalculated = costPerCreditHour.multiply(credits);
//	    tuitionCalculated.setScale(2, RoundingMode.FLOOR);
//		double tuition = tuitionCalculated.doubleValue();
//		System.out.println("tuition calculated: " + tuitionCalculated);
//		return tuition;
	}
	
	public Student createLegacy(Student mom, Student dad) {
		return new Student(mom, dad);		
	}
	
	public String toString() {
		return "First Name: " + this.firstName + 
			   "\nLast Name:" + this.lastName +
			   "\nStudent ID: " + this.studentID +
			   "\nCredits: " + this.credits +
			   "\nGPA: " + this.GPA +
			   "\nPoints Earned: " + this.qualityScoreTotal;
	}
	
	public static void main(String[] args) {
		Student myStudent = new Student("Mary", "Niederschmidt", 123456);
		myStudent.submitGrade(2.0, 3);
		System.out.println(myStudent);
	}
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
}
