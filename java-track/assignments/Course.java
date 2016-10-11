
public class Course {

	private String name;
	private int credits;
	private int seats;
	private int seatsRemaining;
	private Student[] studentRoster;
	
	public Course(String name, int credits, int seats) {
		this.name = name;
		this.credits = credits;
		this.studentRoster = new Student[seats];
		this.seats = seats;
		this.seatsRemaining = seats;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getRemainingSeats() {
		return this.seatsRemaining;
	}
	
	public int getFilledSeats() {
		return this.seats - this.seatsRemaining;
	}
	
	
	public boolean addStudent(Student newStudent) {
		int filledSeats = this.getFilledSeats();
		
		// check that seats are available
		if (this.seatsRemaining == 0) {
			return false;
		}
		
		// check that student is not already enrolled
		for (int i = 0; i < filledSeats; ++i) {
			if (this.studentRoster[i].getName().equals(newStudent.getName())) {
				return false;
			}
		}
		
		// enroll student
		this.studentRoster[filledSeats] = newStudent;
		this.seatsRemaining--;
		return true;
	}
	
	public double averageGPA() {
		double sumGPA = 0;
		int filledSeats = this.getFilledSeats();
		
		for (int i = 0; i < filledSeats; ++i) {
			sumGPA += this.studentRoster[i].getGPA();
		}
		
		return sumGPA / filledSeats;
	}
	
	public String generateRoster() {
		String roster = "Class Roster: ";
		int filledSeats = this.getFilledSeats();
		
		for (int i = 0; i < filledSeats; ++i) {
			roster = roster + "\n" + this.studentRoster[i].getName();
		}	
		return roster;
	}
	
	public String toString() {
		return "Name: " + this.name + 
			   "\nCredits:" + this.credits +
			   "\nSeats Remaining: " + this.seatsRemaining +
			   "\n" + this.generateRoster();
	}
}
