import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFilesInFolder {
    public static void main(String[] args) throws IOException {
        // Create a File object for the directory where the files are located
        File folder = new File("./data");

        // Get a list of all the files in the directory
        File[] files = folder.listFiles();

        // Loop through each file in the list
        for (File file : files) {
            // Create a BufferedReader object to read the contents of the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
                   
            // Read the contents of the file
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(file.getName());
                // Process the contents of the file as required
                System.out.println(line);
            }

            // Close the BufferedReader object
            reader.close();
        }
    }
}

    
