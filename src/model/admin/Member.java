package model.admin;
// @author Mads Rasmussen

import model.coach.SwimmerProfile;

//defining the variables
public class Member {
    private String name;
    private int age;
    private String gender;
    private boolean activeMember;
    private int phone;
    private String email;
    private String adress;
    private int id;
    private SwimmerProfile swimmerprofile; //new
    private boolean isCompetitionSwimmer; //new

public Member(int id, String name, int age, String gender, boolean isactivemember, int phone, String email, String adress, boolean isCompetitionSwimmer){
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.activeMember = isactivemember;
    this.phone = phone;
    this.email = email;
    this.adress = adress;
    this.isCompetitionSwimmer = isCompetitionSwimmer;
    if (isCompetitionSwimmer){
        this.swimmerprofile = new SwimmerProfile();
    }
}

//getters and setters
public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}
public int getAge(){
    return age;
}
public void setAge(int age){
    this.age = age;
}
public String getGender(){
    return gender;
}
public void setGender(String gender){
    this.gender = gender;
}
public boolean isActiveMember(){
    return activeMember;
}
public void setActiveMember(boolean isactivemember){
    this.activeMember = isactivemember;
}
public int getPhone(){
    return phone;
}
public void setPhone(int phone){
    this.phone = phone;
}
public String getEmail(){
    return email;
}
public void setEmail(String email){
    this.email = email;
}
public String getAdress(){
    return adress;
}
public void setAdress(String adress){
    this.adress = adress;
}
public int getId(){
    return id;
}
public void setId(int id){
    this.id = id;
}
@Override
    public String toString(){return "[" + id + "] " + name + " Age: " + age + " Gender: " + gender;}

    public void setCompetitionSwimmer(boolean competitionSwimmer) { // new added
        isCompetitionSwimmer = competitionSwimmer;
    }

    public boolean isCompetitionSwimmer() { // new added
        return isCompetitionSwimmer;
    }

    public SwimmerProfile getSwimmerprofile() { //new added
        return swimmerprofile;
    }

}
