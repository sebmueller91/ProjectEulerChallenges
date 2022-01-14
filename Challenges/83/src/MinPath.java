import java.util.ArrayList;

public class MinPath {
	private enum Direction {Left, Up, Right, Down};
	
	private int[][] _matrix;
	private Integer[][] _shortestPaths;
	
	public MinPath(int[][] matrix) {
		_matrix = matrix;
		_shortestPaths = new Integer[matrix.length][matrix[0].length];
	}
	
	public ArrayList<Cell>  getMinPathFourWays() {
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
		dirsMinValues[0] = (col-1 >= 0) ? getMinValueForCell(row,col-1) : Integer.MAX_VALUE; // Left
		dirsMinValues[1] = (row-1 >= 0) ? getMinValueForCell(row-1,col) : Integer.MAX_VALUE; // Up
		dirsMinValues[2] = (col+1 < _shortestPaths[row].length) ? getMinValueForCell(row,col+1) : Integer.MAX_VALUE; // Right
		dirsMinValues[3] = (row+1 < _shortestPaths.length) ? getMinValueForCell(row+1,col) : Integer.MAX_VALUE; // Down
		
		int minIndex = getIndexOfMinValue(dirsMinValues);	
		
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
		
		for (int i = 0; i < _matrix.length; i++) {
			for (int j = 0; j < _matrix.length; j++) {
				System.out.print(_matrix[i][j]+",");
			}
			System.out.println();
			
		}
		return ;
	//	getMinPathFourWaysHelper(path);
	}
	
	private Integer getMinValueForCell(int row, int col) {
		boolean[][] alreadyTraversed = new boolean[_matrix.length][_matrix[0].length];
		return getMinValueForCellHelper(row, col, alreadyTraversed);
	}
	
	private Integer getMinValueForCellHelper(int row, int col, boolean[][] alreadyTraversed) {
		alreadyTraversed[row][col] = true;
		_shortestPaths[row][col] = _matrix[row][col];
		
		if (row == _matrix.length && col == _matrix[row].length) {
			return _shortestPaths[row][col];
		} else {
			int[] dirsMinValues = new int[4];
			
			// Left
			if (col-1 >= 0 && alreadyTraversed[row][col-1]) {
				boolean[][] alreadyTraversedCopy = copyArray(alreadyTraversed);
				dirsMinValues[0] = getMinValueForCellHelper(row,col-1, alreadyTraversedCopy);
			} else {
				dirsMinValues[0] = Integer.MAX_VALUE;
			}
			
			// Up
			if (row-1 >= 0 && alreadyTraversed[row-1][col]) {
				boolean[][] alreadyTraversedCopy = copyArray(alreadyTraversed);
				dirsMinValues[0] = getMinValueForCellHelper(row-1,col, alreadyTraversedCopy);
			} else {
				dirsMinValues[0] = Integer.MAX_VALUE;
			}
			
			// Right
			if (col+1 < _shortestPaths[row].length && alreadyTraversed[row][col+1]) {
				boolean[][] alreadyTraversedCopy = copyArray(alreadyTraversed);
				dirsMinValues[0] = getMinValueForCellHelper(row,col+1, alreadyTraversedCopy);
			} else {
				dirsMinValues[0] = Integer.MAX_VALUE;
			}
			
			//Down
			if (row+1 < _shortestPaths.length && alreadyTraversed[row+1][col]) {
				boolean[][] alreadyTraversedCopy = copyArray(alreadyTraversed);
				dirsMinValues[0] = getMinValueForCellHelper(row+1,col, alreadyTraversedCopy);
			} else {
				dirsMinValues[0] = Integer.MAX_VALUE;
			}
			
			int minIndex = getIndexOfMinValue(dirsMinValues);	
			System.out.println(row+ " " +col + " "+ minIndex);
			System.out.println(_shortestPaths[row][col]);
			System.out.println(dirsMinValues);
			_shortestPaths[row][col] += dirsMinValues[minIndex];
		}
			
		return _shortestPaths[row][col];
	}
	
	private boolean[][] copyArray(boolean[][] source) {
		boolean[][] dest = new boolean[source.length][source[0].length];
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				dest[i][j] = source[i][j];
			}
		}
		return dest;
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
