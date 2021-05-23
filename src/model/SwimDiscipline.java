package model;

public class SwimDiscipline {

    private int distance;
    private String type;

    public SwimDiscipline(int distance, String type){
        this.distance = distance;
        this.type = type;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public String getType() {
        return type;
    }
}