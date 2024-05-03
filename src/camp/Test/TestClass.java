package camp.Test;
import java.util.Scanner;
import java.util.ArrayList;

public class TestClass {
    Scanner sc = new Scanner(System.in);
    public ArrayList<String> studentName;
    public ArrayList<Integer> studentId;
    public ArrayList<String> studentSubject;

    public TestClass() {
        studentName = new ArrayList<>();
        studentId = new ArrayList<>();
        studentSubject = new ArrayList<>();
    }

    //학생 이름 배열에 저장
    public void addStudentName() {
        System.out.print("등록할 학생명 입력 : ");
        String name = sc.next();
        studentName.add(name);
    }

    public ArrayList<String> getStudentName() {
        return studentName;
    }

    // 학생의 과목 이름 배열에 저장.
    public void addStudentSubject() {
        System.out.print("등록할 학생의 과목명 입력 : ");
        String subject = sc.next();
        studentSubject.add(subject);
    }

    public ArrayList<String> getStudentSubject() {
        return studentSubject;
    }

    // 학생의 고유번호 배열에 저장.
    public void addStudentId() {
        while (true) {
            System.out.print("등록할 학생의 고유번호 입력 : ");
            int id = sc.nextInt();
            if (studentId.contains(id)) {
                System.out.println("이미 존재하는 고유 번호 입니다.");
//                return;
            } else {
                studentId.add(id);
                break;
            }
        }
    }

    public ArrayList<Integer> getStudentId() {
        return studentId;
    }
    // 모든 학생의 정보를 표시하는 부분. 구현할지 고민중.
    public void showAllStudent() {

    }
}
