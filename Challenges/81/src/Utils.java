import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
	public static int[][] readInMatrix(String filepath) {
		String content = readFileContentAsString(filepath);
		String[][] splittedContent = parseContent(content);
		return convertContent(splittedContent);
	}

	private static String readFileContentAsString(String filepath) {
		String content = "";

		try {
			content = new String(Files.readAllBytes(Paths.get(filepath)));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		return content;
	}
	
	private static String[][] parseContent(String content) {
		String[]contentByLines = content.split("\n");
		String[][] splittedContent = new String[contentByLines.length][];
		
		for (int i = 0; i < contentByLines.length; i++) {
			splittedContent[i] = contentByLines[i].split(",");
		}
		
		return splittedContent;
	}
	
	private static int[][] convertContent(String[][] content) {
		int[][] convertedContent = new int[content.length][content[0].length];
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < content[i].length; j++) {
				convertedContent[i][j] = Integer.parseInt(content[i][j]);
			}
		}
		return convertedContent;
	}
}
