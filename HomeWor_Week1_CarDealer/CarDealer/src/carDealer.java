/*
You are a car dealer. Create a hash map of vehicles.
The model is the Key, the make is the Value.
Ask the customer what car (model) they are looking for. Use the Hash Map to determine if you have that vehicle, and what make it is.
(e.g. “Oh, you’re looking for a Civic? Our Honda selection is right over here...“)
 */

import java.util.HashMap;
import java.util.Scanner;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Or;


 public class carDealer {
     public static HashMap setHmap(){
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("civic", "honda");
        hmap.put("accord", "honda");
        hmap.put("sonanat", "hyundai");
        hmap.put("santa_Fe", "hyundai");
        hmap.put("tundara", "toyota");
        hmap.put("corolla", "toyota");
        return hmap;
     }

     
    public static void main(String[] args) throws Exception {
        
        //Create hmap and call HashMap function to get initial values
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap = setHmap();

        String runAgain = "y";

        //keep looping until user inputs anything except y or Y
        do{
            Scanner reader = new Scanner(System.in);

            System.out.println("enter the model of vehicle you want to lookup");
            String model = reader.next();
            
            try{
                String carMake = hmap.get(model);
                System.out.println(carMake.toLowerCase());
                System.out.println("Oh!  You're looking for a " + model + "!  Our " + carMake + " selection is over here!");
            }catch(Exception e){
                //Ask the user if they want to see all models and print if y or Y
                System.out.println("We do not have those");
                System.out.println("Do you want to see all of our available models? (Y/N)");
                String viewAllModels = "n";
                viewAllModels = reader.next();

                //Display all models
                if(viewAllModels.equalsIgnoreCase("y")){
                    System.out.println(hmap.keySet());
                }
            }finally{}

            

            System.out.println("Run Again? (Y/N): ");
            runAgain = reader.next();

        }while(runAgain.equalsIgnoreCase("y"));

        
    }
}
