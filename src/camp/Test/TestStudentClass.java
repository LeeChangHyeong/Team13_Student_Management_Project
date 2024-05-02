package camp.Test;
// 이 클래스의 객체를 계속 생성해서 배열 하나당 한명분의 데이터가 들어가게끔 하기.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestStudentClass {
    public String name;
    public int id;
    public List<String> subjects;

    public TestStudentClass(String name, int id, List<String> subjects) {
        this.name = name;
        this.id = id;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getSubject() {
        return subjects;
    }

    public void setSubject(List<String> subjects) {
        this.subjects = subjects;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("이름: ").append(name).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("수강중인 과목 \n");
        for (String subject : subjects) {
            sb.append("- ").append(subject).append("\n");
        }
        return sb.toString();
    }
}
