public class ScoreManager {
    public static void inquiryAverageGradeBySubject() {
        // 과목별 총 점수의 합을 저장할 배열
        int[] sum = new int[9];
        // 과목별 응시생 수를 저장할 배열
        int[] count = new int[9];

        for (Score s : ScoreRegistration.scoreEntries) {
            int subjectId = s.getSubjectId();
            // 과목별 총 점수의 합과 응시생 수 누적
            sum[subjectId] += s.getScore();
            count[subjectId]++;
        }

        System.out.println("------------------------------");
        System.out.println("과목별 평균 등급 조회");
        System.out.println("------------------------------");

        // 과목별 평균 등급 출력
        for (int i = 0; i < 9; i++) {
            if (count[i] == 0) {
                System.out.println("[" + Score.getSubjectNameToId(i) + "]" + " 응시생 없음.");
            } else {
                int average = sum[i] / count[i];
                System.out.println("[" + Score.getSubjectNameToId(i) + "]의 평균 등급: " + Score.calculateGradeWithId(average, i));
            }
        }
    }

    public static void inquiryAverageGradeByStatus(String status) {
        System.out.println("-----------------------------------------");
        System.out.println("[" + status + "] 상태의 수강생 필수 과목 평균 등급을 조회합니다.");
        System.out.println("-----------------------------------------");
        int count = 0;

        for (Student s : StudentRegistration.studentArrayList) {
            if (s.getStatus() == Status.getStatusByString(status)) {
                System.out.println("수강생 이름: " + s.getName());
                System.out.print(s.getName() + "님이 선택한 필수 과목명: ");
                s.getMainSubjects();
                System.out.println(s.getName() + "닝의 필수 과목 평균 등급: " + getAverageGradeById(s.getId()));
                System.out.println();
                count++;
            }
        }

        if (count == 0) {
            System.out.println();
            System.out.println("!오류: [" + status + "] 상태인 수강생이 없습니다.");
            System.out.println();
        }
    }

    // 수강생 id로 필수 과목 평균 등급 구하는 메서드
    public static String getAverageGradeById(int id) {
        int sum = 0;
        int count = 0;

        for (Score s : ScoreRegistration.scoreEntries) {
            if (s.getStudentId() == id && s.getType() == "필수") {
                sum += s.getScore();
                count++;
            }
        }

        if (count == 0) {
            System.out.println();
            return "!오류: 아직 시험에 응시하지 않아 등급을 낼 수 없습니다.";
        } else {
            int score = sum / count;

            if (score >= 95) {
                return "A";
            } else if (score >= 90) {
                return "B";
            } else if (score >= 80) {
                return "C";
            } else if (score >= 70) {
                return "D";
            } else if (score >= 60) {
                return "F";
            } else {
                return "N";
            }
        }
    }
}