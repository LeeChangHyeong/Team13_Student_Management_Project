import Exceptions.BadStatusException;

import javax.swing.text.Style;
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
        if (studentsList.size() < 1) {
            System.out.println("등록된 수강생이 없습니다.");
            System.out.println();
        } else {
            for (Student s : studentsList) {
                System.out.println("수강생 고유번호: " + s.getId());
                System.out.println("수강생 이름: " + s.getName());
                System.out.println("수강생 상태: " + s.getStatus());
                System.out.print(s.getName() + "님이 선택한 필수 과목명: ");
                s.getMainSubjects();
                System.out.print(s.getName() + "님이 선택한 선택 과목명: ");
                s.getChoiceSubjcetList();
                System.out.println();
            }
        }
    }

    // 번호와 맞는 수강생을 찾아 수정하는 메서드
    public void modifyStudent(int studentNumber) throws IOException, BadStatusException {
        Student student = null;
        String lastName = null;
        Status lastStatus = null;

        for (Student s : studentsList) {
            if (s.getId() == studentNumber) {
                student = s;
                lastName = s.getName();
                lastStatus = s.getStatus();
            }
        }

        if (student == null) {
            System.out.println("번호와 맞는 수강생이 없습니다.");
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("----------------------------------");
            System.out.println("현재 선택한 고유번호 정보");
            System.out.println("----------------------------------");
            System.out.println("수강생 고유번호: " + student.getId());
            System.out.println("수강생 이름: " + student.getName());
            System.out.println("수강생 상태: " + student.getStatus());
            System.out.print(student.getName() + "님이 선택한 필수 과목명: ");
            student.getMainSubjects();
            System.out.print(student.getName() + "님이 선택한 선택 과목명: ");
            student.getChoiceSubjcetList();
            System.out.println();

                System.out.print("수정할 이름을 입력하세요: ");
                    System.out.println("이름이 " + student.getName() + "으로 변경되었습니다.");
                System.out.print("수정할 상태를 입력하세요 (Green, Red, Yellow 중 하나를 입력하세요.): ");
                    System.out.println(student.getName() + "의 상태가 " + student.getStatus() + "(으)로 변경되었습니다.");
            System.out.println("변경된 정보");
            System.out.println("이름: " + lastName + " " + "->" + " " + student.getName());
            System.out.println("상태: " + lastStatus + " " + "->" + " " + student.getStatus());
        }
    }

    // 상태별 수강생 목록 조회
    // 조규성 : 수강생 상태 잘못 입력시 예외처리로 프로그램 꺼짐, 처리중.
    // 조규성 : 예외처리를 제거해서 if문으로만 오입력시 재입력 처리 요청 구축.
    public void printStudentListByStatus(String status) {
        System.out.println("-----------------------------------------");
        System.out.println("[" + status + "] 상태의 수강생 목록을 조회합니다.");
        System.out.println("-----------------------------------------");
        int count = 0;
        while (true) {
            if (status.equals("Green") || status.equals("Red") || status.equals("Yellow")) {

                for (Student s : studentsList) {
                    System.out.println("수강생 고유번호: " + s.getId());
                    System.out.println("수강생 이름: " + s.getName());
                    System.out.println("수강생 상태: " + s.getStatus());
                    System.out.print(s.getName() + "님이 선택한 필수 과목명: ");
                    s.getMainSubjects();
                    System.out.print(s.getName() + "님이 선택한 선택 과목명: ");
                    s.getChoiceSubjcetList();
                    System.out.println();
                    count++;
                }
                if (count == 0) {
                    System.out.println("[" + status + "] 상태인 수강생이 없습니다.");
                    System.out.println("-----------------------------------------");
                }
                System.out.println();
                break;
            } else {
                System.out.println("!!!!정확한 상태명을 입력하세요!!!!");
                System.out.println("-----------------------------------------");
                break;
            }
        }
    }

    // 수강생 데이터 삭제
    public void deleteStudentData(int studentNumber) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId() == studentNumber) {
                studentsList.remove(i);
                System.out.println("학생 데이터가 성공적으로 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 번호의 학생을 찾을 수 없습니다.");
    }

    // 수강생 중복 id 검사
    public boolean idCheck(int id) {
        boolean checkId = false;
        for (Student s : studentsList) {
            if (s.getId() == id) {
                checkId = true;
            }
        }
        return checkId;
    }
}
