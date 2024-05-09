import java.util.LinkedHashMap;
import java.util.Map;

public class GradeSearch {
    // 과목별 회차 등급 나타내주는 메서드
    public static void gradeSearch(int id, String subject) {
        int count = 0;
        // HashMap 대신 LinkedHashMap 사용
        Map<Integer, String> map = new LinkedHashMap<>();

        for(Score s: ScoreRegistration.scoreEntries) {
            if (s.getStudentId() == id && s.getSubjectName().equals(subject)) {
                map.put(s.getRound(), s.getGrade());
                count++;
            }
        }

        if (count == 0) {
            System.out.println();
            System.out.println("!오류: 등록된 점수가 없습니다.");
            System.out.println();
        } else {
            map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> System.out.println(entry.getKey() + "회차 등급: " + entry.getValue()));
        }
    }
}
