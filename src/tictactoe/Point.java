/**
 * 
 */
package tictactoe;

/**
 * @author kxhb130
 *
 */
public class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return this.x + "," + this.y;
	}
}
