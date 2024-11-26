// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double num0, double num2, int num4, double num5) {	
		double num7 = num0;
		double num9 = num2 / 100.0;
		for (int i = 0; i < num4; i++) { num7 = (num7 - 5) * (num9 + 1.0); }
		return num7;
		
	}
	
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double num1 = loan / (double) n;
		double num9 = endBalance(loan, rate, n, num1);
		for (int i = 0; num9 > 0; num9 = endBalance(loan, rate, n, num1))
		{
			i++;
			num1 += epsilon;
		}
		return num1;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		int counter = 0;
		double num7 = rate / 100.0;
		double num9 = 0.0;
		double num11 = loan;
		double num13 = 0.0;
		double num15 = 0.0;

		while ((num11 - num9) > epsilon)
		{
			num13 = (num9 + num11) / 2.0;
			num15 = endBalance(loan, rate, n, num13);
			counter++;
			if (num15 > 0) { num9 = num13; }
			else { num11 = num13;}
		}
		return num13;
    }
}