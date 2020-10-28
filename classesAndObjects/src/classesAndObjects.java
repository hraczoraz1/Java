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


public class classesAndObjects {
    public static void main(String[] args) throws Exception {
        
        //PET SECTION
        //invoke pet constructors
        pet allAttributes = new pet("test",2,"home","poodle");
        pet noAttributes = new pet();

        //PET getters
        System.out.println("Pet name in getter is:  " +allAttributes.getName());
        System.out.println("Pet age in getter is:   " +allAttributes.getAge());
        System.out.println("Pet type in getter is:  " +allAttributes.getType());

        //PET setters
        System.out.println("Pet name in setter is:    " +allAttributes.setName("newName"));
        System.out.println("Pet name in setter is:    " +allAttributes.setAge(500));
        System.out.println("Pet location in setter is:" +allAttributes.setLocation("newHome"));


        //PHONE SECTION
        //invoke constructors
        phone threeAttri = new phone("Apple","Iphone", 7, false);
        phone twoAttri = new phone("Apple", "Iphone");

        //Print vendor
        System.out.println("Phone vendor in getter is: " +threeAttri.getVendor());

        //Print Phone status Old or New
        if(threeAttri.getPhoneCondition()==true) {
            System.out.println("Value via a return Bool: " +" New Phone!!!");
        }else{
            System.out.println("Value via a return Bool: " + "Old Phone!!!");
        }


        //two variable
        System.out.println("Value via 2 variables passed:  " +twoAttri.getVendor());

        //Phone setters
        System.out.println("Value for Phone vendor via a setter:  "+threeAttri.setVendor("Google"));
        System.out.println("Value for Phone type via a setter:  "+threeAttri.setType("Pixel"));
        System.out.println("Value for Phone size via a setter:  "+threeAttri.setSize(60));
    }
}
