import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileSqlReader {
	List<String> lines;
	public String getFile(int num) {
		try {
			lines = Files.readAllLines(Paths.get("C:\\Users\\text\\secret.txt"));
			if (num == 0) {
				return lines.get(0);
			} else if (num == 1) {
				return lines.get(1);
			} else if (num == 2) {
				return lines.get(2);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
