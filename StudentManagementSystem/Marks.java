package entities;

public class Marks {
    private String subjectId;
    private String subjectName;
    private int marks;
    private String grade;

    public Marks(String subjectId, String subjectName, int marks, String grade) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.marks = marks;
        this.grade = grade;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

