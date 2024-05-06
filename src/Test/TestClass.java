package Test;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
// 추가해야하는 것들
//

public class TestClass {
    // 개행문자 처리를 위해 스캐너 객체를 두개로 나눔
    // 첫 번째 스캐너객체는 띄어쓰기 없는 문자열을 위해
    Scanner sc = new Scanner(System.in);
    // 두번째 스캐너 객체는 띄어쓰기가 있는 문자열을 위해
    Scanner sc1 = new Scanner(System.in);
    public ArrayList<String> studentName;
    public ArrayList<Integer> studentId;
    public ArrayList<String> studentSubject;

    // 셍성자를이용,TestClass 클래스의 객체를 생성하고 ArrayList로 초기화함.
    public TestClass() {
        studentName = new ArrayList<>();
        studentId = new ArrayList<>();
        studentSubject = new ArrayList<>();
    }

    //학생 이름 배열에 저장, 숫자 입력시 재입력 요구
    public void addStudentName() {
        while (true) {
            System.out.print("등록할 학생명 입력 : ");
            String name = sc.next();
            boolean isString = false;
            // 받은 문자열 하나씩 검사하는 부분
            for (char c : name.toCharArray()) {
                if (Character.isLetter(c)) {
                    isString = true;
                    break;
                }
            }
            // 위에 검사한 결과가 true일 경우에만 if 실행
            // 숫자가 하나라도 섞여있어서 false일 경우 else 실행
            if (isString == true) {
                studentName.add(name);
                break;
            } else {
                System.out.println("학생이름에는 숫자가 입력될 수 없습니다.");
            }
        }
    }

    // 학생 이름 getter
    public ArrayList<String> getStudentName() {
        return studentName;
    }

    // 학생의 과목 이름 배열에 저장. 필수과목, 선택과목 나눠서 받기 끝
    // 하지만 배열에 저장되는건 2가지 전부 한 인덱스에 저장
    public void addStudentSubject() {
        List<String> sublist = new ArrayList<>();
        while (sublist.size() < 3) {
            System.out.print("등록할 학생의 필수 과목 3개 입력 : ");
            String subject = sc.next();
            switch (subject) {
                case "자바":
                case "객체지향":
                case "Spring":
                case "JPA":
                case "MySQL":
                    sublist.add(subject);
                    break;
                default:
                    System.out.println("정확한 필수 과목명 입력");
            }
        }
        // 선택과목 두가지 선택하는 로직
        // 현재 띄어쓰기 때문에 수정중. 스캐너 객체를 하나 더 만들어서 해결.
        while (sublist.size() < 5) {
            System.out.print("학생의 선택과목 2개 입력 : ");
            String subject = sc1.nextLine();
            switch (subject) {
                case "디자인 패턴":
                case "Spring Security":
                case "Redis":
                case "MongoDB":
                    sublist.add(subject);
                    break;
                default:
                    System.out.println("정확한 선택과목명 입력");
            }
        }
        // 두가지 종류의 과목을 한번의 한 인덱스 안에 저장. / 로 구분
        studentSubject.add(String.join("/", sublist));
    }

    // 학생 과목명 getter
    public ArrayList<String> getStudentSubject() {
        return studentSubject;
    }

    // 학생의 고유번호 배열에 저장.
    public void addStudentId() {
        while (true) {
            System.out.print("등록할 학생의 고유번호 입력 : ");
            if (sc.hasNextInt()) {
                int id = sc.nextInt();
                if (studentId.contains(id) == true) {
                    System.out.println("중복된 고유번호입니다.");
                } else {
                    studentId.add(id);
                    break;
                }
            } else {
                System.out.println("고유번호는 숫자만 입력이 가능합니다.");
                sc.next();// 잘못 입력된 값을 버리는 부분.
            }
        }
    }

    public ArrayList<Integer> getStudentId() {
        return studentId;
    }

    // 사용자가 선택할 수 있는 선택지
    public void chooseWant() {
        System.out.println("----------------------------");
        System.out.println("저장된 모든 학생의 이름 : " + getStudentId());
        System.out.println("저장된 모든 학생의 고유번호 : " + getStudentSubject());
        System.out.println("저장된 모든 학생의 과목명 : " + getStudentId());
        System.out.println("----------------------------");
    }
    // 메인 클래스 내에서 객체화 시켜 사용하면 되는메소드
    public void start() {
        while (true) {
            System.out.println("학생 등록 (1)");
            System.out.println("정보 보기 (2)");
            System.out.println("프로그램 종료 (3)");
            System.out.print("입력 : ");

            String choice = sc.next();
            if (choice.equals("1")) {
                addStudentName();
                addStudentId();
                addStudentSubject();
            } else if (choice.equals("2")) {
                chooseWant();
            } else if (choice.equals("3")) {
                return;
            } else {
                System.out.println("정확한 번호를 입력하세요");
            }
        }
    }
}
