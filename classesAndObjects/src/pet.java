/*
Submit: Classes and Objects
pet.java
Create a Pet Class with the following instance variables: 
name (PRIVATE)
age (PRIVATE)
location (PRIVATE)
type (PRIVATE) 
two constructors
empty
all attributes
Code to be able to access the following (Get Methods):name
age
type
Code to be able to change (Set Methods):name
age
location
*/

public class pet {
    private String name;
    private int age;
    private String location;
    private String type;

    public pet(){}

    public pet(String name,int age,String location,String type){
        this.name = name;
        this.age = age;
        this.location = location;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getType(){
        return type;
    }

    public String setName(String name){
        //name = name;
        return name;
    }

    public int setAge(int age){
        //age = age;
        return age;
    }

    public String setLocation(String location){
        //location = location;
        return location;
    }

}
