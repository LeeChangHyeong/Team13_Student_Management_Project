import java.util.LinkedList;

public class ViewStudentList {
    // 규성님한테 받아올 학생 정보 리스트입니다.
    private LinkedList<String[]> studentList;

    // studentList 초기화
    public ViewStudentList (LinkedList<String[]> studentList) {
        this.studentList = studentList;
    }

    // 수강생 목록 조회 메서드
    public void printStudentList() {
        System.out.println("-----------------------------------------");
        System.out.println("수강생 목록을 조회합니다.");
        System.out.println("-----------------------------------------");
        for(String[] s: studentList) {
            String studentNumber = s[0];
            String studentName = s[1];

            System.out.println("수강생 고유번호: " + studentNumber);
            System.out.println("수강생 이름: " + studentName);
            System.out.println();
        }
    }
}
