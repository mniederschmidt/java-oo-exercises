package Studio1;

public class Fraction {

	private int numerator;
	private int denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction add(Fraction otherFraction) {
		int newDenominator = this.denominator * otherFraction.denominator;
		int newNumerator = this.numerator * otherFraction.denominator + otherFraction.numerator * this.denominator;
		Fraction sum = new Fraction(newNumerator, newDenominator);
		sum.simplify();
		return sum;
	}
	
	public Fraction multiply(Fraction otherFraction) {
		Fraction product = new Fraction(this.numerator * otherFraction.numerator, this.denominator * otherFraction.denominator);
		product.simplify();
		return product;
	}
	
	public Fraction reciprocal() {
		return new Fraction(this.denominator, this.numerator);
	}
	
	public void simplify() {
		int smaller;
		
		if (this.numerator < this.denominator) {
			smaller = this.numerator;
		}
		else {
			smaller = this.denominator;
		}
		
		for (int i=smaller; i>1; i--) {
			if (this.numerator % i == 0 &&
				this.denominator % i == 0) {
				// if both are evenly divisible by i, divide both by i
				this.numerator = this.numerator / i;
				this.denominator = this.denominator / i;
				break;
			}
		}
	}
	
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction myFraction = new Fraction(6,8);
		myFraction.simplify();
		System.out.println(myFraction);

	}

}
