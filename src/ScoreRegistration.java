import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ScoreRegistration {
    static ArrayList<Score> scoreEntries = new ArrayList<>(); // 저장할 리스트 생성
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void setScore() throws IOException {
        // 사용자가 종료를 입력할 때까지 반복
        A:
        while (true) {
            try {
                System.out.print("성적을 등록할 수강생의 고유 번호 입력: ");
                int id = Integer.parseInt(br.readLine());

                boolean studentFound = false;       // 수강생이 있는지 여부를 나타내는 변수
                // 수강생 고유 번호 검색
                for (Student student : StudentRegistration.studentArrayList) {
                    if (student.getId() == id) {
                        studentFound = true;
                        break;
                    }
                }
                if (!studentFound) {
                    System.out.println("");
                    System.out.println("!오류: 고유번호가 없습니다. ");
                    System.out.println("");
                    continue A;
                }
                System.out.println("| 번호 | 타입 | 과목명 |");
                System.out.println("         V");
                for (Subject s : Main.subjects) {

                    System.out.println("| " + s.getId() + " | " + s.getType() + " | " + s.getName() + " |");
                }

                System.out.print("과목 고유 번호 입력: ");
                int subjectId = Integer.parseInt(br.readLine());
                boolean subjectFound = false;
                while (!subjectFound) {
                    for (Subject s : Main.subjects) {
                        if (s.getId() == subjectId) {
                            subjectFound = true;
                            break;
                        }
                    }
                    if (!subjectFound) {
                        System.out.println("");
                        System.out.println("!오류: 과목 고유번호가 없습니다. 다시입력하세요");
                        System.out.println("");
                        System.out.print("과목 고유 번호 입력 : ");
                        subjectId = Integer.parseInt(br.readLine());
                    }
                }

                System.out.println("회차를 입력하세요 (1 ~ 10 사이의 숫자): ");
                int round = Integer.parseInt(br.readLine());
                if (round < 1 || round > 10) {
                    System.out.println("");
                    System.out.println("!오류: 회차는 1부터 10 사이의 숫자여야 합니다.");
                    System.out.println("");
                    continue; // 잘못된 입력이면 반복문의 처음으로 돌아감
                }


                System.out.println("점수를 입력하세요 (0 ~ 100 사이의 숫자): ");
                int score = Integer.parseInt(br.readLine());
                if (score < 0 || score > 100) {
                    System.out.println("");
                    System.out.println("!오류: 점수는 0부터 100 사이의 숫자여야 합니다.");
                    System.out.println("");
                    continue; // 잘못된 입력이면 반복문의 처음으로 돌아감
                }

                // 이미 등록된 회차인지 확인
                boolean isDuplicate = false;
                for (Score entry : scoreEntries) {
                    if (entry.getSubjectName() == entry.getSubjectNameToId(subjectId) && entry.getRound() == round) {
                        System.out.println("");
                        System.out.println("!오류: 이미 등록된 회차입니다.");
                        System.out.println("");
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) {
                    continue; // 이미 등록된 회차이면 반복문의 처음으로 돌아감
                }

                // 새로운 Score 객체 생성 및 리스트에 추가
                Score newEntry = new Score(subjectId, id, round, score);
                scoreEntries.add(newEntry);

                // 사용자에게 성공적으로 등록되었음을 알림
                System.out.println("[" + round + "]" + "회차의 점수가 성공적으로 등록되었습니다. (등급: " + newEntry.getGrade() + " )");

                while (true) {
                    System.out.print("성적을 더 추가하시겠습니까? (1. 예, 2. 메인으로 돌아가기) ");
                    String str = br.readLine();
                    if ("1".equals(str)) {
                        break;
                    } else {
                        break A;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.println("!오류: 숫자를 입력해주세요  ");
                System.out.println("");
            }
        }
        //반복문으로 되돌아감
    }
}