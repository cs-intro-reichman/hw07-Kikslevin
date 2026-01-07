/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double h = Math.sqrt(3) / 2;
		sierpinski(n, 0.0, 1.0, 0.5, 0.0, 0.0, h);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
			double[] x = {x1, x2, x3};
			double[] y = {y1, y2, y3};
			StdDraw.polygon(x, y);
		} else {
			double xMid1 = (x1 + x2) / 2;
			double xMid2 = (x2 + x3) / 2;
			double xMid3 = (x1 + x3) / 2;

			double yMid1 = (y1 + y2) / 2;
			double yMid2 = (y2 + y3) / 2;
			double yMid3 = (y1 + y3) / 2;

			sierpinski(n - 1, x1, xMid1, xMid3, y1, yMid1, yMid3);
			sierpinski(n - 1, xMid1, x2, xMid2, yMid1, y2, yMid2);
			sierpinski(n - 1, xMid3, xMid2, x3, yMid3, yMid2, y3);
		}
	}
}
