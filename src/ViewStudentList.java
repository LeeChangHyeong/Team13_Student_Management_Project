import java.util.LinkedList;

public class ViewStudentList {
    // 규성님한테 받아올 학생 정보 리스트입니다.
    private LinkedList<Student> studentsList;

    // studentList 초기화
    public ViewStudentList(LinkedList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    // 수강생 목록 조회 메서드
    public void printStudentList() {
        System.out.println("-----------------------------------------");
        System.out.println("수강생 목록을 조회합니다.");
        System.out.println("-----------------------------------------");
//        for (Student s : studentList) {
//
//
//            System.out.println("수강생 고유번호: " + studentNumber);
//            System.out.println("수강생 이름: " + studentName);
//            System.out.println();
//        }
    }
}
