import Exceptions.BadStatusException;

import java.util.ArrayList;

public class Student {
    private int number;
    private String name;
    private Status status;
    private ArrayList<String> subjectLists;

    // number getter
    public int getNumber() {
        return this.number;
    }

    // name getter
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // status getter
    public Status getStatus() {
        return this.status;
    }

    // status setter
    public void setStatus(String status) throws BadStatusException {
        this.status = Status.getStatusByString(status);
    }

    // list getter
    public ArrayList<String> getSubjectLists() {
        return this.subjectLists;
    }
}
