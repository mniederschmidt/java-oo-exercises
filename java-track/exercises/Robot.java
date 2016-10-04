
public class Robot {
	
	private String name;
	private int[] position;		// how to set as 2-dimensional array?
	private int speed;
	private int orientation;  // consider implementing as an enum?
	
	public void move(int blocks) {
		switch (orientation) {
			case 0:
				if (position[1] - blocks) < 0) {
					position[1] = 0;
				}
				else {
					position[1] -= blocks;
				}
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:

				break;
		}
	}
	
	// consider implementing direction as an enum?
	// 0 = north
	// 1 = east
	// 2 = south
	// 3 = west
	public void rotate(String direction) {
		
		if (direction.equals("left")) {
			if (orientation == 0) {
				orientation = 3;
			}
			else {
				orientation -=1;
			}
		}
		else {
			if (orientation == 3) {
				orientation = 0;
			}
			else {
				orientation += 1;
			}
		}
	}
	
	public double determineDistance(Robot r) {
		
	}
	
	public String toString() {
		return "Name: " + this.name + 
			   "\nPosition: " + this.position[0] + "," + this.position[1] + 
			   "\nSpeed: " + this.speed + 
			   "\nOrientation: " + this.orientation;
	}
	
	// initial position of Robot
	public Robot(String name, int x, int y) {
		this.name = name;
		position[0] = x;
		position[1] = y;
		orientation = 0;
	}
	
	public Robot(String name) {
		this(name, 0, 0);
	}

	public static void main(String[] args) {
		Robot bert = new Robot("Bert", 1,1);
		Robot ernie = new Robot("Ernie", 5,5);
	}

}
