package hello;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author kxhb130
 *
 */
public class  extends String {
	private int[] denominations = { 2000, 500, 100 };
	private int[] availableCounts = { 10, 20, 30 };
	private int[] result = { 0, 0, 0 };
	private int[] resetResult = { 0, 0, 0 };
	private int totalCorpus;
	private int hundreds;

	public Atm() {
		totalCorpus = 0;
		hundreds = 500;
		this.calculateTotalCorpus();
	}

	private void calculateTotalCorpus() {
		for (int i = 0; i < denominations.length; i++) {
			totalCorpus += denominations[i] * availableCounts[i];
		}
	}

	private void validateAmount(int amount, Scanner scr, Atm atm) {
		if (amount < 0 || amount % 100 != 0) {
			System.out.println("Please enter valid amount in multiples of 100!");
			wrapper(scr, atm);
		} else if (amount > totalCorpus) {
			System.out.println("Out of Cash!");
		} else {
			cashDispenser(amount);
		}
	}

	private void cashDispenser(int amount) {
		int actuals = amount;
		if ((amount % hundreds == 0) && (amount > hundreds * 2)) {
			actuals = amount - hundreds;
			result[2] = 5;
		}
		if (actuals > 0) {
			for (int i = 0; i < denominations.length; i++) {
				if (actuals >= denominations[i]) {
					int count = actuals / denominations[i];
					int given = availableCounts[i] < count ? availableCounts[i] : count;
					result[i] += given;
					availableCounts[i] -= availableCounts[i] < count ? availableCounts[i] : count;
					totalCorpus -= (denominations[i] * given);
					actuals -= (denominations[i] * given);
				}
			}
			if (actuals > 0) {
				result = resetResult;
				System.out.println("Out of Cash!" + actuals);
				return;
			}
		}
		printCounts();
	}

	private void printCounts() {
		for (int i = 0; i < denominations.length; i++)
			System.out.println(denominations[i] + "*" + result[i]);
	}

	private void wrapper(Scanner scr, Atm atm) {
		int amount = 0;
		if (scr.hasNextInt()) {
			amount = scr.nextInt();
			atm.validateAmount(amount, scr, atm);
		}
	}

	public static void main(String[] s) {
		Scanner scr = new Scanner(System.in);
		System.out.println("Welcome to Surith ATM");
		System.out.println("Please enter amount in multiples of 100!");
		Atm atm = new Atm();
		atm.wrapper(scr, atm);
		atm = null;
		scr.close();
	}
}
