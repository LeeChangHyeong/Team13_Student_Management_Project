import java.util.ArrayList;

public class Subjects {
    // 필수 과목 리스트
    private ArrayList<String> mainSubjectList;

    // 선택 과목 리스트
    private ArrayList<String> choiceSubjcetList;

    public void setMainSubjects(ArrayList<String> mainSubjectList) {
        this.mainSubjectList = mainSubjectList;
    }

    public void getMainSubjects() {
        System.out.println("필수 과목 조회: " + mainSubjectList);
    }

    public void setChoiceSubjcetList(ArrayList<String> mainSubjectList) {
        this.mainSubjectList = mainSubjectList;
    }

    public void getChoiceSubjcetList() {
        System.out.println("선택 과목 조회: " + choiceSubjcetList);
    }

    // 전체 출력
    public void getAllSubjectList() {
        ArrayList<String> allSubjectList = new ArrayList<>();
        for(String s: mainSubjectList) {
            allSubjectList.add(s);
        }

        for(String s: choiceSubjcetList) {
            allSubjectList.add(s);
        }

        System.out.println("전체 과목 조회: " + allSubjectList);
    }
}
