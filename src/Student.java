import java.util.ArrayList;

public class Student {
    private int number;
    private String name;
    private Status status;
    private ArrayList<String> subjectLists;

    // Student 객체가 생성될때 학생 정보 초기화
    public Student(int number, String name, Status status, ArrayList<String> subjectLists) {
        this.number = number;
        this.name = name;
        this.status = status;
        this.subjectLists = subjectLists;
    }
    // number getter
    public int getNumber() {
        return this.number;
    }
    // name getter
    public String getName() {
        return this.name;
    }
    // status getter
    public Status getStatus() {
        return this.status;
    }
    // list getter
    public ArrayList<String> getSubjectLists() {
        return this.subjectLists;
    }
}
