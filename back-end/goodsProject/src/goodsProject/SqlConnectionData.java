package goodsProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SqlConnectionData {
	public String getFile(int num) {
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("C:\\Users\\gupo9\\Desktop\\제비\\sql비밀번호.txt"));
			if (num == 0) {
				return lines.get(0);
			} else if (num == 1) {
				return lines.get(1);
			} else if (num == 2) {
				return lines.get(2);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
