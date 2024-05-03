import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentListManager {
    // 규성님한테 받아올 학생 정보 리스트입니다.
    private ArrayList<Student> studentsList;

    // studentList 초기화
    public StudentListManager(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    // 수강생 목록 조회 메서드
    public void printStudentList() {
        System.out.println("-----------------------------------------");
        System.out.println("수강생 목록을 조회합니다.");
        System.out.println("-----------------------------------------");
        for (Student s : studentsList) {
            System.out.println("수강생 고유번호: " + s.getNumber());
            System.out.println("수강생 이름: " + s.getName());
            System.out.println("수강생 상태: " + s.getStatus());
            System.out.println(s.getName() + "님이 선택한 과목명: " + s.getSubjectLists());
            System.out.println();
        }
    }

    // 번호와 맞는 수강생을 찾아 수정하는 메서드
    public void modifyStudent(int studentNumber) throws IOException {
        Student student = null;
        String lastName = null;
        Status lastStatus = null;

        for (Student s : studentsList) {
            if (s.getNumber() == studentNumber) {
                student = s;
                lastName = s.getName();
                lastStatus = s.getStatus();
            }
        }
        if (student == null) {
            System.out.println("번호와 맞는 수강생이 없습니다.");
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("수정할 이름을 입력하세요: ");
            student.setName(br.readLine());
            System.out.println("이름이 " + student.getName() + "으로 변경되었습니다.");
            System.out.print("수정할 상태를 입력하세요 (Green, Red, Yellow 중 하나를 입력하세요.): ");
            student.setStatus(br.readLine());
            System.out.println();
            System.out.println(student.getName() + "의 상태가 " + student.getName() + "(으)로 변경되었습니다.");
            System.out.println();
            System.out.println("변경된 정보");

            System.out.println("이름: " + lastName + " " + "->" + " " + student.getName());
            System.out.println("상태: " + lastStatus + " " + "->" + " " + student.getStatus());
        }
    }

}