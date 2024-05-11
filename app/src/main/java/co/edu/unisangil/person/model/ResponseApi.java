package co.edu.unisangil.person.model;

import java.util.LinkedList;

public class ResponseApi {
    private LinkedList<PersonModel> person;

    public LinkedList<PersonModel> getPerson() {
        return person;
    }

    public void setPerson(LinkedList<PersonModel> person) {
        this.person = person;
    }
}
