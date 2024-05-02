package camp.Test;

import java.util.ArrayList;

public class TestClass {
    public ArrayList<String> studentName;
    public ArrayList<Integer> studentId;
    public ArrayList<String> studentSubject;

    public TestClass() {
        studentName = new ArrayList<>();
        studentId = new ArrayList<>();
        studentSubject = new ArrayList<>();
    }

    //학생 이름 배열에 저장
    public void addStudentName(String name) {
        studentName.add(name);
    }

    public ArrayList<String> getStudentName() {
        return studentName;
    }

    // 학생의 과목 이름 배열에 저장.
    public void addStudentSubject(String subject) {
        studentSubject.add(subject);
    }

    public ArrayList<String> getStudentSubject() {
        return studentSubject;
    }

    // 학생의 고유번호 배열에 저장.
    public void addStudentId(int id) {
        for (Integer idCase : studentId) {
            if (idCase == id) {
                System.out.println("이미 존재하는 고유 번호 입니다.");
                return;
            }
        }
        studentId.add(id);
    }

    public ArrayList<Integer> getStudentId() {
        return studentId;
    }
}
