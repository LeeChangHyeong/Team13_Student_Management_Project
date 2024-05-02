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

}
