package entities;

public class Student {

    private int id;
    private String name;
    private String courseName;

    public Student(int id, String name, String courseName) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

