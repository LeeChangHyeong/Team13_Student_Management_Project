import Exceptions.BadStatusException;

import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private Status status;
    private Subjects subjects;

    // number getter
    public int getId() {
        return this.id;
    }

    // name getter
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    // status getter
    public Status getStatus() {
        return this.status;
    }

    // status setter
    public void setStatus(String status) throws BadStatusException {
        this.status = Status.getStatusByString(status);
    }
    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public void getMainSubjects() {
        subjects.getMainSubjects();
    }

    public void getChoiceSubjcetList() {
        subjects.getChoiceSubjcetList();
    }

}
