package files;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileHandler{

    public List<String> readFile(String fileName) throws FileNotFoundException, IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            File file = new File(fileName);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            return bufferedReader.lines().toList();
        }finally{
            if(fileReader!= null) {
                fileReader.close();
            }
            if(bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    public void saveFile(String fileName, List<String> lines) throws FileNotFoundException{
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(fileName);
            for(String line: lines){
                writer.println(line);
            }
            writer.flush();
        }finally{
            if(writer != null)
                writer.close(); // Closing here ensures the contents of the file is saved to disk.      
        }
    }
}
