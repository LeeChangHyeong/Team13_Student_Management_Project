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

    public void setName(String name) {
        this.name = name;
    }

    // status getter
    public Status getStatus() {
        return this.status;
    }

    // status setter
    public void setStatus(String status) {
        if(status.equals("Green")) {
            this.status = Status.Green;
        } else if (status.equals("Yellow")) {
            this.status = Status.Yellow;
        } else if (status.equals("Red")) {
            this.status = Status.Red;
        } else {
            // 다른 것이 들어왔을때 예외처리 해줘야 합니다.
            System.exit(1);
        }
    }

    // list getter
    public ArrayList<String> getSubjectLists() {
        return this.subjectLists;
    }
}