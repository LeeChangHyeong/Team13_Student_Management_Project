package camp.Test;

import java.util.Scanner;
// 배열 여러개를 만들어서 각각 요소들을 배치한 로직.
// 같은 자리의 인덱스끼리는 모두 같은 학생의 정보를 가지고 있다.
public class Main {
    public static void main(String[] args) {
        TestClass tClass = new TestClass();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("학생을 등록하려면 1번 프로그램 종료는 2번 입력 : ");
            int choice = sc.nextInt();
            if (choice == 1) {

                tClass.addStudentName();

                tClass.addStudentId();

                tClass.addStudentSubject();

                System.out.println("저장된 학생의 이름 : " + tClass.getStudentName());
                System.out.println("저장된 학생의 고유번호 : " + tClass.getStudentId());
                System.out.println("저장된 학생의 과목명 : " + tClass.getStudentSubject());
            } else if (choice == 2) {
                return;
            } else {
                System.out.println("1번 또는 2번만 입력하세요");
            }
        }
    }
}
