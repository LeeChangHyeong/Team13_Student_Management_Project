import Exceptions.BadStatusException;

import java.util.*;
import java.io.*;


public class StudentRegistration {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private StudentListManager studentListManager = new StudentListManager(studentArrayList);


    // 메인 클래스 내에서 객체화 시켜 사용하면 되는 메소드
    public void start() throws BadStatusException, IOException {
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("수강생 등록 (1)");
            System.out.println("정보 보기 (2)");
            System.out.println("정보 수정 (3)");
            System.out.println("정보 삭제 (4)");
            System.out.println("프로그램 종료 (5)");
            System.out.print("입력 : ");
            String choice = br.readLine();
            System.out.println("-----------------------------------------");
            if (choice.equals("1")) {
                Student student = new Student();
                Subjects subjects = new Subjects();

                addStudentName(student);
                addStudentId(student);
                addStudentSubject(student, subjects);
                addStudentStatus(student);

                studentArrayList.add(student);
            } else if (choice.equals("2")) {
                while (true) {
                    System.out.println("전체 수강생 조회 (1)");
                    System.out.println("상태별 수강생 조회 (2)");
                    System.out.println("돌아가기 (3)");
                    System.out.print("입력 : ");
                    String str = br.readLine();
                    System.out.println("-----------------------------------------");
                    if (str.equals("1")) {
                        studentListManager.printStudentList();
                    } else if (str.equals("2")) {
                        System.out.print("조회하고 싶은 수강생 상태를 입력 (Green, Yellow, Red 중 하나를 입력하세요.): ");
                        studentListManager.printStudentListByStatus(br.readLine());
                    } else if (str.equals("3")) {
                        break;
                    } else {
                        System.out.println("올바른 숫자를 입력해주세요.");
                    }
                }
            } else if (choice.equals("3")) {
                System.out.println("수정하고 싶은 수강생 고유번호 입력: ");
                studentListManager.modifyStudent(Integer.parseInt(br.readLine()));
            } else if (choice.equals("4")) {
                System.out.println("삭제하고 싶은 수강생 고유번호 입력: ");
                studentListManager.deleteStudentData(Integer.parseInt(br.readLine()));
            } else if (choice.equals("5")) {
                return;
            } else {
                System.out.println("정확한 번호를 입력하세요");
            }
        }
    }

    //학생 이름 배열에 저장, 숫자 입력시 재입력 요구
    public void addStudentName(Student student) throws IOException {
        while (true) {
            System.out.print("등록할 학생명 입력 : ");
            String name = br.readLine();
            boolean isString = false;

            // 받은 문자열 하나씩 검사하는 부분
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    isString = true;
                    break;
                }
            }
            // 조규성 : 학생 이름에 숫자 + 문자가 올 경우 등록이 되는 버그 발생
            // 조규성 : 위에 if (Character.hasDigit(c)) 을 if (Character.isDigit(c)) 으로 변경.
            if (isString) {
                System.out.println("학생이름에는 숫자가 입력될 수 없습니다.");
            } else {
                student.setName(name);
                break;
            }
        }
    }

    // 학생의 과목 이름 배열에 저장. 필수과목, 선택과목 나눠서 받기
    public void addStudentSubject(Student student, Subjects subjects) throws IOException {
        ArrayList<String> mainSubjectList = new ArrayList<>();
        ArrayList<String> choiceSubjectList = new ArrayList<>();

        A:
        while (true) {
            System.out.print("등록할 학생의 필수 과목 3개이상 입력 (그만 입력 하시려면 exit을 입력하세요.): ");
            String subject = br.readLine();
            switch (subject) {
                case "Java":
                case "객체지향":
                case "Spring":
                case "JPA":
                case "MySQL":
                    mainSubjectList.add(subject);
                    break;
                case "exit":
                    if (subject.equals("exit") && mainSubjectList.size() >= 3) {
                        break A;
                    } else {
                        System.out.println("-----------------------------------------");
                        System.out.println("필수 과목을 3가지 이상 입력해주세요.");
                        System.out.println("-----------------------------------------");
                        break;
                    }
                default:
                    System.out.println("-----------------------------------------");
                    System.out.println("정확한 필수 과목명 입력");
                    System.out.println("-----------------------------------------");
            }
        }
        // 필수 과목 저장
        subjects.setMainSubjects(mainSubjectList);

        // 선택과목 두가지 선택하는 로직
        A:
        while (true) {
            System.out.print("학생의 선택과목 2개이상 입력 (그만 입력 하시려면 exit을 입력하세요.): ");
            String subject = br.readLine();
            switch (subject) {
                case "디자인 패턴":
                case "Spring Security":
                case "Redis":
                case "MongoDB":
                    choiceSubjectList.add(subject);
                    break;
                case "exit":
                    if (subject.equals("exit") && choiceSubjectList.size() >= 2) {
                        break A;
                    } else {
                        System.out.println("선택 과목을 2가지 이상 입력해주세요.");
                        break;
                    }
                default:
                    System.out.println("정확한 선택과목명 입력");
            }
        }
        // 선택 과목 저장
        subjects.setChoiceSubjcetList(choiceSubjectList);

        // 학생 객체에 과목들 저장
        student.setSubjects(subjects);
    }

    // 학생의 고유번호 배열에 저장.
    public void addStudentId(Student student) throws IOException {
        while (true) {
            System.out.print("등록할 학생의 고유번호 입력 : ");
            String id = br.readLine();
            if (isInteger(id)) {
                // TODO: 나중에 Student 배열 관리할때 다시 구현 해야합니다.
                if (studentListManager.idCheck(Integer.parseInt(id))) {
                    System.out.println("-----------------------------------------");
                    System.out.println("중복된 고유번호 입니다.");
                    System.out.println("-----------------------------------------");
                    continue;
                } else {
                    student.setId(Integer.parseInt(id));
                }
                break;
            } else {
                System.out.println("고유번호는 숫자만 입력이 가능합니다.");
            }
        }
    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // 학생의 상태 저장
    // 조규성 : 학생의 상태 오입력시 재입력 요구 코드 추가
    public void addStudentStatus(Student student) throws BadStatusException, IOException {
        while (true) {
            System.out.print("등록할 학생의 상태 입력 (Green, Yellow, Red 중 한 가지를 입력해주세요.): ");
            String statusColor = br.readLine();
            if (statusColor.equals("Green")
                    || statusColor.equals("Yellow")
                    || statusColor.equals("Red")) {
                student.setStatus(statusColor);
                break;
            } else {
                System.out.println("정확한 상태명을 입력해주세요");
            }
        }
    }
}
