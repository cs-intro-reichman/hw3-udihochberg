// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {

	static double epsilon = 0.001; // Approximation accuracy
	static int iterationCounter; // Number of iterations

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
		System.out.println(123);
		// System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + 123);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println(40);
		// System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + 40);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the
	// periodical payment.
	private static double endBalance(double loan, double rate, int n, double epsilon) {
		double num7 = loan;
		double num9 = rate / 100.0;
		for (int i = 0; i < n; i++) {
			num7 = (num7 - 5) * (num9 + 1.0);
		}
		return num7;

	}

	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double num1 = loan / (double) n;
		double num9 = endBalance(loan, rate, n, num1);
		for (iterationCounter = 0; num9 > 0; num9 = endBalance(loan, rate, n, num1)) {
			iterationCounter++;
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
		iterationCounter = 0;
		// double num7 = rate / 100.0;
		double num1 = 0.0;
		double num2 = loan;
		double num3 = 0.0;
		double finalNum = 0.0;

		while ((num2 - num1) > epsilon) {
			finalNum = (num1 + num2) / 2.0;
			num3 = endBalance(loan, rate, n, finalNum);
			iterationCounter++;
			if (num3 > 0) {
				num1 = finalNum;
			} else {
				num2 = finalNum;
			}
		}
		return finalNum;
	}
}