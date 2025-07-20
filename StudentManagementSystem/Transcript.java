package entities;

import java.util.List;
import java.util.ArrayList;

public class Transcript {

    private Student student;
    private List<Marks> markList;

    public Transcript(Student student, List<Marks> marks) {
        this.student = student;
        this.markList = marks;
    }

    public void printTranscript(){
        for(String s : generateLines()){
            System.out.println(s);
        }
    }

    //reused between printing to console and printing in file
    public List<String> generateLines(){
        List<String> formattedLines = new ArrayList<>();
        formattedLines.add(String.format("################ STUDENT ID   : %s ################" ,this.student.getId() ));
        formattedLines.add(String.format("################ STUDENT NAME : %s ################" , this.student.getName() ));
        formattedLines.add(String.format("################ COURSE NAME  : %s ################" , this.student.getCourseName()) );
        formattedLines.add(String.format("--------------------------------------------------------------------" ));
        formattedLines.add(String.format("%15s%40s%8s%8s","SUBJECT CODE", "SUBJECT NAME","MARKS","GRADES"));
        formattedLines.add(String.format("--------------------------------------------------------------------" ));
        for(Marks mark : this.markList){
            formattedLines.add(String.format("%15s%40s%8s%8s",mark.getSubjectId(),mark.getSubjectName(),mark.getMarks(), mark.getGrade()));
        }
        return formattedLines;
    }



}

