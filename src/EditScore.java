import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class EditScore {
    public static void editScore(int studentNumber) throws IOException {
        Student student = null;

        for (Student s : StudentRegistration.studentArrayList) {
            if (s.getId() == studentNumber) {
                student = s;
            }
        }

        if (student == null) {
            System.out.println();
            System.out.println("!오류: 해당 고유번호로 등록된 수강생이 없습니다.");
            System.out.println();
            return;
        }

        System.out.print("수정하고 싶으신 과목을 입력해주세요: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String subject = br.readLine();


        if (StudentRegistration.mainSubjectOk(subject) || StudentRegistration.choiceSubjectOk(subject)) {
            Map<Integer, Integer> map = new LinkedHashMap<>();


            for (Score s : ScoreRegistration.scoreEntries) {
                if (s.getStudentId() == studentNumber && s.getSubjectName().equals(subject)) {
                    map.put(s.getRound(), s.getScore());
                }
            }

            if (!map.isEmpty()) {
                System.out.println("-------------------------------------------------");
                System.out.println("고유번호가 " + studentNumber + "인 수강생의 " + "'" + subject + "'" + " 과목 회차별 점수를 출력합니다.");
                System.out.println();
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEach(entry -> System.out.println(entry.getKey() + "회차 점수: " + entry.getValue()));

                System.out.println("수정하실 회차를 입력해 주세요.");
                String round = br.readLine();

                try {
                    int intRound = Integer.parseInt(round);
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("!오류: 회차는 숫자로만 입력해 주세요.");
                    System.out.println();
                    return;
                }

                int intRound = Integer.parseInt(round);

                if (map.containsKey(intRound)) {
                    while (true) {
                        System.out.println("수정하실 점수를 입력해주세요.");
                        String score = br.readLine();

                        try {
                            int intScore = Integer.parseInt(score);
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("!오류: 점수는 숫자로만 입력해주세요.");
                            System.out.println();
                            continue;
                        }

                        int intScore = Integer.parseInt(score);

                        for (Score s : ScoreRegistration.scoreEntries) {
                            if (s.getStudentId() == studentNumber && s.getSubjectName().equals(subject) && s.getRound() == intRound) {
                                System.out.println(s.getStudentId() + "번의" + subject + " " + s.getRound() + "회차 점수가 " + s.getScore() + "점 -> " + intScore + "으로 변경되었습니다.");
                                s.setScore(intScore);
                                s.setGrade(intScore);
                                break;
                            }
                        }
                        break;
                    }
                } else {
                    System.out.println();
                    System.out.println("!오류: 올바른 회차를 입력하세요.");
                    System.out.println();
                    return;
                }


            } else {
                System.out.println();
                System.out.println("!오류: '" + subject + "'" + " 과목에 데이터가 없습니다.");
                System.out.println();
                return;
            }
        } else {
            System.out.println();
            System.out.println("!오류: 올바른 과목을 입력해주세요.");
            System.out.println();
            return;
        }


        for (Score s : ScoreRegistration.scoreEntries) {
            if (s.getStudentId() == studentNumber) {

            }
        }
    }
}
