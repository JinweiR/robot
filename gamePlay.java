/*
 *  FileName: gamePlay.java
 *  Author: Jinwei Ren    (jir017@ucsd.edu)
 *  Description: This file is the driver program of the robot game
 *  The user can interact with the game by some basic command.
 *  Date: April 17, 2017
 */
import java.io.*;
import java.util.Scanner;
/*
 *  ClassName: gamePlay
 *  Author: Jinwei Ren    (jir017@ucsd.edu)
 *  Description: This class is the driver of the robot game and contains
 *  the main method.
 *  Date: April 17, 2017
 */
public class gamePlay {
   public static void main(String[] args){
      int x_size = 9;              //The game size (x)
      int y_size = 9;              //The game size (y)
      int temp = 0;                //Temp value to store int
      int x_location = 0;          //The x location of the robot
      int y_location = 0;          //The y location of the robot
      char direction = 'N';        //Direction of robot
      boolean conti1 = true;       //Flag to heck the loop condition
      boolean conti2 = true;       //Flag to heck the loop condition
      boolean conti3 = true;       //Flag to heck the loop condition
      boolean err = false;         //Record error
      String temp2 = new String(); //Store user input
      String command = new String();  //The command String
      String buffer = new String();

      //Prompt user
      Scanner in = new Scanner(System.in);
      //Ask for input
      while( conti1 ){
         System.out.println("Please enter the initial horizontal location: ");
         //Record the x coordinate
         if( in.hasNextInt() ){
            temp = in.nextInt();
            //Check range
            if( temp > 0 && temp < x_size ){
               x_location = temp;
               conti1 = false;
            }
            else{
               System.out.println(temp + " is not in range. ");
            }
         }
         else{
            System.out.println("Not valid.");
            buffer = in.next();
         }

      }
      conti1 = true;
      //Ask for input
      while(conti1){
         System.out.println("Please enter the initial vertical location: ");
         if( in.hasNextInt() ){	
            temp = in.nextInt();
            //Check range
            if( temp > 0 && temp < y_size ){
               y_location = temp;
               conti1 = false;
            }
            //Print the result
            else{
               System.out.println(temp + " is not in range.");
            }
         }
         else{
            System.out.println("Not valid.");
            buffer = in.next();
         }
         //Reprompt the user
      }	

      //Prompt the user
      while( conti2 ){
         System.out.println("Please enter the initial facing direction:");
         if( in.hasNext() ){
            temp2 = in.next();
            //Check validity of direction
            if(temp2.equals("E")||temp2.equals("W")||
                  temp2.equals("S")||temp2.equals("N")){
               direction = temp2.charAt(0);
               conti2 = false;
            }
            //Prompt the user
            else{
               System.out.println("Not valid, Please enter: E, W, S or N.");
            }
         }
      }
      //Initialize the robot
      robot player = new robot(x_location, y_location, direction);
      //Ask for command string
      while( conti3 ){
         System.out.println("Please enter command: ");
         if( in.hasNext() ){
            command = in.next();
         }
         //Change the string to char array
         char[]commands = command.toCharArray();
         //Check validity
         if(player.checkCommand(commands)){
            for( int i = 0; i < commands.length; i++ ){
               //Check validity of movement
               if(player.checkMove(commands[i], x_size, y_size)){
                  player.move(commands[i]);
               }
               else{
                  System.out.println("Cannot move out of bound." +  
                        " Stop at the bound");
                  break;
               }
            }
            player.location();
         }
         //Prompt the user
         else{
            System.out.println("Not valid, Please enter commands " + 
                  "containing only: L, R or W.");
         }
      }
      //Close the scanner
      in.close();
   }
}
