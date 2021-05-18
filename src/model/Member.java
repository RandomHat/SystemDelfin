package model;
//defining the variables
public class Member {
    private String name;
    private String dateofbirth;
    private String gender;
    private boolean isactivemember;
    private int phone;
    private String email;
    private String adress;
    private int id;

//constructor
public Member(String name, String dateofbirth, String gender, boolean isactivemember, int phone, String email, String adress, int id){
    this.name = name;
    this.dateofbirth = dateofbirth;
    this.gender = gender;
    this.isactivemember = isactivemember;
    this.phone = phone;
    this.email = email;
    this.adress = adress;
    this.id = id;
}
//getters and setters
public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}
public String getDateofbirth(){
    return dateofbirth;
}
public void setDateofbirth(String dateofbirth){
    this.dateofbirth = dateofbirth;
}
public String getGender(){
    return gender;
}
public void setGender(String gender){
    this.gender = gender;
}
public boolean isIsactivemember(){
    return isactivemember;
}
public void setIsactivemember(boolean isactivemember){
    this.isactivemember = isactivemember;
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
    public String toString(){return id + " " + name + " " + dateofbirth + " " + gender;}
}
