package model;

import java.util.ArrayList;

public class CompetitionSwimmer extends Member {
    private String team;
    private ArrayList<Result> swimResults = new ArrayList<>();

    public CompetitionSwimmer(String name, String dateofbirth, String gender, boolean isactivemember, int phone, String email, String adress, int id) {
        super(name, dateofbirth, gender, isactivemember, phone, email, adress, id);
    }
}
