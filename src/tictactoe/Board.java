/**
 * 
 */
package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class Board {
	int board[][];
	Point computerMove;
	int computer;
	int human;

	void displayBoard() {
		IntStream.range(0, 3).forEach(action -> {
			IntStream.range(0, 3).forEach(col -> {
				System.out.print(board[action][col]);
			});
			System.out.println();
		});
	}

	List<Point> getAvailableCells() {
		List<Point> list = new ArrayList<>();
		IntStream.range(0, 3).forEach(i -> {
			IntStream.range(0, 3).forEach(j -> {
				if (board[i][j] == 0)
					list.add(new Point(i, j));
			});
		});
		return list;
	}

	Board(int computer, int human) {
		this.computer = computer;
		this.human = human;
		board = new int[3][3];
	}

	boolean hasPlayerWon(int player) {
		if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player)
				|| (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player)) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player)
					|| (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player))
				return true;
		}

		return false;
	}

	boolean isGameOver() {
		return hasPlayerWon(computer) || hasPlayerWon(human) || getAvailableCells().isEmpty();
	}

	boolean placeAMove(Point point, int player) {
		if (board[point.x][point.y] != 0)
			return false;
		board[point.x][point.y] = player;
		return true;
	}

	int minimax(int depth, int player) {
		if (hasPlayerWon(computer))
			return 1;
		if (hasPlayerWon(human))
			return -1;
		List<Point> poi = getAvailableCells();
		if (poi.isEmpty())
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < poi.size(); i++) {
			if (player == computer) {
				placeAMove(poi.get(i), computer);
				int currentScore = minimax(depth + 1, human);
				max = Math.max(currentScore, max);

				if (currentScore >= 0 && depth == 0)
					computerMove = poi.get(i);
				if (currentScore == 1) {
					board[poi.get(i).x][poi.get(i).y] = 0;
					break;
				}
				if (i == poi.size() - 1 && max < 0 && depth == 0)
					computerMove = poi.get(i);
			} else if (player == human) {
				placeAMove(poi.get(i), human);
				int currentScore = minimax(depth + 1, computer);
				min = Math.min(currentScore, min);
				if (min == -1) {
					board[poi.get(i).x][poi.get(i).y] = 0;
					break;
				}
			}
			board[poi.get(i).x][poi.get(i).y] = 0;
		}
		return player == computer ? max : min;
	}

	public static void main(String[] s) {
		Random ran = new Random();
		System.out.println("Note: Computer is 1 & human is 2");
		System.out.println("Do you want to start first?? input yes or no");
		Scanner out = new Scanner(System.in);
		String choice = null;
		if (out.hasNext()) {
			choice = out.next();
		} else {
			System.out.println("Wrong Input::: Restarting the game!!!");
		}

		Board b = new Board(1, 2);
		b.displayBoard();
		if ("No".equalsIgnoreCase(choice)) {
			Point com = new Point(ran.nextInt(3), ran.nextInt(3));
			b.placeAMove(com, b.computer);
			System.out.println("Computer move :: " + com.x + ", " + com.y);
			b.displayBoard();
		}

		while (!b.isGameOver()) {
			System.out.println("::Your move::    enter rownum and enter colnum");
			if (!out.hasNextInt())
				continue;
			int i = out.nextInt();
			if (!out.hasNextInt())
				continue;
			int j = out.nextInt();
			Point poi = new Point(i, j);
			b.placeAMove(poi, b.human);
			b.displayBoard();
			if (b.isGameOver())
				break;
			b.minimax(0, b.computer);
			System.out.println("Computer move :: " + b.computerMove.x + ", " + b.computerMove.y);
			b.placeAMove(b.computerMove, b.computer);
			b.displayBoard();
		}

		if (b.hasPlayerWon(b.computer))
			System.out.println("You lose!!!");
		else if (b.hasPlayerWon(b.human))
			System.out.println("You win Master!!!");
		else
			System.out.println("It's draw genius!!!");

		System.out.println("Do you want to play again? \nInput 1. restart \n 0. quit");
		if (out.hasNextInt() && out.nextInt() == 1) {
			main(null);
		} else {
			System.out.println("Have a nice day champ!!");
		}
	}
}
