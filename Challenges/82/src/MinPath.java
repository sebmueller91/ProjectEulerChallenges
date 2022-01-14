import java.util.ArrayList;

public class MinPath {
	private enum Direction {Left, Up, Right, Down};
	
	private int[][] _matrix;
	private Integer[][] _shortestPaths;
	
	public MinPath(int[][] matrix) {
		_matrix = matrix;
		_shortestPaths = new Integer[matrix.length][matrix[0].length];
	}
	
	public ArrayList<Cell>  getMinPathTwoWays() {
		ArrayList<Cell> path = new ArrayList<Cell>();
		path.add(new Cell(0,0));
		getMinPathFourWaysHelper(path);
		
		return path;
	}
	
	private void getMinPathFourWaysHelper(ArrayList<Cell>  path) {
		Cell curCell = path.get(path.size()-1);
		int row = curCell.getX();
		int col = curCell.getY();
		Cell nextCell = null;	
		
		if (row ==_matrix.length-1 && col == _matrix[row].length-1) {
			return;
		}
		
		Direction[] dirs = new Direction[] {Direction.Left, Direction.Up, Direction.Right, Direction.Down}; 
		int[] dirsMinValues = new int[4];
		dirsMinValues[0] = (col-1 >= 0) ? getMinPathForCell(row,col-1) : Integer.MAX_VALUE; // Left
		dirsMinValues[1] = (row-1 >= 0) ? getMinPathForCell(row-1,col) : Integer.MAX_VALUE; // Up
		dirsMinValues[2] = (col+1 < _shortestPaths[row].length) ? getMinPathForCell(row,col+1) : Integer.MAX_VALUE; // Right
		dirsMinValues[3] = (row+1 < _shortestPaths.length) ? getMinPathForCell(row+1,col) : Integer.MAX_VALUE; // Down
		
		int minIndex = getIndexOfMinValue(dirsMinValues);	
		_shortestPaths[row][col] += dirsMinValues[minIndex];
		
		switch (dirs[minIndex]) {
			case Left:
				nextCell = new Cell(row, col-1);
				break;
			case Up:
				nextCell = new Cell(row-1, col);
				break;
			case Right:
				nextCell = new Cell(row, col+1);
			default:
				nextCell = new Cell(row+1, col);
				break;
		}
		
		path.add(nextCell);
		getMinPathFourWaysHelper(path);
	}
	
	private Integer getMinPathForCell(int row, int col) {
		if (_shortestPaths[row][col] != null) {
			return _shortestPaths[row][col];
		}
		
		_shortestPaths[row][col] = 0;
		if (!(row == _matrix.length-1 && col == _matrix[row].length-1)) {		
			Direction[] dirs = new Direction[] {Direction.Left, Direction.Up, Direction.Right, Direction.Down};
			int[] dirsMinValues = new int[4];
			dirsMinValues[0] = (col-1 >= 0) ? getMinPathForCell(row,col-1) : Integer.MAX_VALUE; // Left
			dirsMinValues[1] = (row-1 >= 0) ? getMinPathForCell(row-1,col) : Integer.MAX_VALUE; // Up
			dirsMinValues[2] = (col+1 < _shortestPaths[row].length) ? getMinPathForCell(row,col+1) : Integer.MAX_VALUE; // Right
			dirsMinValues[3] = (row+1 < _shortestPaths.length) ? getMinPathForCell(row+1,col) : Integer.MAX_VALUE; // Down

			int minIndex = getIndexOfMinValue(dirsMinValues);		
			_shortestPaths[row][col] += dirsMinValues[minIndex];
		}
		return _shortestPaths[row][col];
	}
	
	private int getIndexOfMinValue(int[] a) {
		int minIndex = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
}
