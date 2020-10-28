/*
\.java
Create a Custom Class (anything you want - car, phone, holiday, etc.).
Requirements:
Minimum 3 private instance variables
An empty constructor
A constructor that uses only 2 of your 3 variables
A constructor that uses all 3 of your instance variables
Get methods for all 3 of your instance variables
Set methods for all 3 of your instance variables
A method that returns a Boolean
A method that returns a String

*/

public class phone {
    private String vendor;
    private String type;
    private int size;
    private boolean newPhone;

    public phone(){}

    public phone(String vendor, String type, int size, boolean newPhone){
        this.vendor = vendor;
        this.type = type;
        this.size = size;
        this.newPhone = newPhone;
    }

    public phone(String vendor, String type){

        this.vendor = vendor;
        this.type = type;
    }

    public String getVendor(){
        return vendor;
    }

    public String getType(){
        return type;
    }

    public int getSize(){
        return size;
    }

    public String setVendor(String vendor){
        return vendor;
    }

    public String setType(String type){
        return type;
    }

    public int setSize(int size){
        return size;
    }

    public boolean getPhoneCondition(){
        if(newPhone == true){
            return true;
        }
        else{
            return false;
        }
    }
}
