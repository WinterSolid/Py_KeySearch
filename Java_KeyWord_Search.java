import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeywordSearch {

    public static List<String> searchKeywordsInFiles(String directory, String[] keywords) {
        List<String> found = new ArrayList<>();
        File folder = new File(directory);
        File[] files = folder.listFiles();
        
        if (files == null) {
            System.err.println("Invalid directory: " + directory);
            return found;
        }
        
        for (File file : files) {
            if (file.isFile()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    int lineNumber = 0;
                    while ((line = br.readLine()) != null) {
                        lineNumber++;
                        for (String keyword : keywords) {
                            if (line.contains(keyword)) {
                                found.add(file.getName() + " (line " + lineNumber + "): " + line);
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        String directory = "/path/to/your/files";
        String[] keywords = {"keyword1", "keyword2", "keyword3"};
        List<String> results = searchKeywordsInFiles(directory, keywords);

        for (String result : results) {
            System.out.println(result);
        }
    }
}
