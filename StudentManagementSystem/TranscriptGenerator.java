
import entities.*;
import files.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranscriptGenerator {

    public static void main(String[] args){
        String studentFile = args[0];
        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);

        try {
            //read the student lines 
            List<String> studentLines = fileHandler.readFile(studentFile);
            List<Transcript> transcriptList = new ArrayList<>();

            //iterate over each student line
            for(String line: studentLines){

                //create a new student object
                String[] params= line.split(",");
                Student student = new Student(Integer.parseInt(params[0]), params[1],params[2]);

                //read the marks file 
                String marksFileName = "marks_"+student.getId() + ".csv";
                List<String> marksLines = fileHandler.readFile(marksFileName);

                //iterate over each marks line to create a list of marks object
                List<Marks> marksList = new ArrayList<>();
                for(String markLine : marksLines){
                    try {
                        String[] markParams = markLine.split(",");
                        marksList.add(new Marks(markParams[0], markParams[1], Integer.parseInt(markParams[2]), markParams[3]));
                    }catch(ArrayIndexOutOfBoundsException ex){
                        System.out.println("Incorrect marks in marks file: "+marksFileName+". Skipping line.");
                    }
                }

                //create a new stranscript for each student
                transcriptList.add(new Transcript(student,marksList));
            }

            //prompt the user to select a student id and print their transcript
            System.out.println("Select a student id from 1 to 5 to view the transcript");
            int id = Integer.parseInt(scanner.nextLine());
            transcriptList.get(id-1).printTranscript();

            System.out.println("Do you want to save the transcript?");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("Y")){
                fileHandler.saveFile("transcript_"+id+".csv",transcriptList.get(id-1).generateLines() );
                System.out.println("File saved");
            }
            System.out.println("Exiting Program");
        } catch (IOException e) {
            System.out.println("Invalid student file. Quitting Program");
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Incorrect student in a file. Quitting Program");
        }
        scanner.close();


    }

}

