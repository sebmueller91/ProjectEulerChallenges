import java.util.ArrayList;

public class MinPath {

	private int[][] _matrix;
	private Integer[][] _shortestPaths;
	
	public MinPath(int[][] matrix) {
		_matrix = matrix;
		_shortestPaths = new Integer[matrix.length][matrix[0].length];
	}
	
	public ArrayList<Cell>  getMinPathTwoWays() {
		ArrayList<Cell> path = new ArrayList<Cell>();
		path.add(new Cell(0,0));
		getMinPathTwoWaysHelper(path);
		
		return path;
	}
	
	private void getMinPathTwoWaysHelper(ArrayList<Cell>  path) {
		
		Cell curCell = path.get(path.size()-1);
		int row = curCell.getX();
		int col = curCell.getY();
		Cell nextCell = null;	
		
		if (row+1 >= _matrix.length && col+1 >= _matrix[row].length) {
			return;
		} else if (row+1 >= _matrix.length) {
			nextCell = new Cell(row, col+1);
		} else if (col+1 >= _matrix[row].length) {
			nextCell = new Cell(row+1, col);
		} else if (getMinPathForCell(row+1,col) <= getMinPathForCell(row,col+1)){
			nextCell = new Cell(row+1, col);
		} else {
			nextCell = new Cell(row, col+1);
		}
		
		path.add(nextCell);
		getMinPathTwoWaysHelper(path);
	}
	
	private Integer getMinPathForCell(int row, int col) {
		if (_shortestPaths[row][col] != null) {
			return _shortestPaths[row][col];
		}
		
		Integer shortestPathDown = (row+1 < _shortestPaths.length) ? getMinPathForCell(row+1,col) : null;
		Integer shortestPathRight = (col+1 < _shortestPaths[row].length) ? getMinPathForCell(row,col+1) : null;
		
		_shortestPaths[row][col] = _matrix[row][col];
		if (shortestPathDown == null && shortestPathRight == null) {
			_shortestPaths[row][col] += 0;
		} else if (shortestPathDown == null) {
			_shortestPaths[row][col] += shortestPathRight;
		} else if (shortestPathRight == null) {
			_shortestPaths[row][col] += shortestPathDown;
		} else {
			_shortestPaths[row][col] += (shortestPathDown < shortestPathRight) ? shortestPathDown : shortestPathRight;
		}
		
		return _shortestPaths[row][col];
	}
}
