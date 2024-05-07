import Exceptions.BadStatusException;

import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private Status status;
    private ArrayList<String> subjectLists;

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

    // list getter
    public ArrayList<String> getSubjectLists() {
        return this.subjectLists;
    }
}
