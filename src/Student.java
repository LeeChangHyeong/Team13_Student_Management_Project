import java.util.ArrayList;

public class Student {
    private int number;
    private String name;
    private Status status;
    private ArrayList<String[]> subjectLists;

    public Student(int number, String name, Status status, ArrayList<String[]> subjectLists) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.subjectLists = subjectLists;
    }
}
