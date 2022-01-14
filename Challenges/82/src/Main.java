import java.util.ArrayList;

public class Main {
	private static final int[][] testMatrix = new int[][] {{131,673,234,103,18},{201,96,342,965,150},{630,803,746,422,111},{537,699,497,121,956},{805,732,524,37,331}};
	
	public static void main(String[] args) {
		int[][] matrix = Utils.readInMatrix("matrix.txt");
		MinPath minPath = new MinPath(matrix);
		ArrayList<Cell> path =minPath.getMinPathTwoWays();
		printPath(path, matrix);
	}
	
	private static void printPath(ArrayList<Cell> path, int[][] matrix) {
		String string = "";
		int sum = 0;
		for (int i = 0; i < path.size(); i++) {
			sum += matrix[path.get(i).getX()][path.get(i).getY()];
			string += "(" + + path.get(i).getX() + "," + path.get(i).getY() + "," + sum + ")";
			if (i < path.size()-1) {
				string += ",";
			}
		}
		System.out.println(string);
	}
}
