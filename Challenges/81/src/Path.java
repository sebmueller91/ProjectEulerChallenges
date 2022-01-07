import java.util.ArrayList;

public class Path {
	private ArrayList<Cell> m_Path;

	public ArrayList<Cell> getPath() {
		return m_Path;
	}

	public void setPath(ArrayList<Cell> m_Path) {
		this.m_Path = m_Path;
	}
	
	public String toString() { 
		String string = "";
		if (getPath() == null) {
			return string;
		}
		for (int i = 0; i < getPath().size(); i++) {
			string += "(" + + getPath().get(i).getX() + "," + getPath().get(i).getY() + ")";
			if (i < getPath().size()-1) {
				string += ",";
			}
		}
		return string;
	}
}
