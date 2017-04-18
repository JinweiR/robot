/*
 *  FileName: robot.java
 *  Author: Jinwei Ren    (jir017@ucsd.edu)
 *  Description: This file contains the definition of the robot class and 
 *  some useful member methods to manipulate the robot.
 *  Date: April 17, 2017
 */

import java.io.*;
/*
 *  ClassName: robot
 *  Author: Jinwei Ren    (jir017@ucsd.edu)
 *  Description: This class contains the definition and 
 *  some useful member methods to manipulate the robot.
 *  Date: April 17, 2017
 */
public class robot {
   public int x_location;           //x coordinate of the robot
   public int y_location;           //y coordinate of the robot
   char direction;                  //direction of the robot

   //Default constructor
   public robot(){}

   //The constructor we use to initialize the robot
   //Initialized by location and direction
   public robot(int xIndex, int yIndex, char dir){
      this.x_location = xIndex;
      this.y_location = yIndex;
      this.direction = dir;
   }

   /*
    * Method name: move
    * Return type: void
    * Param: char dir--the direction to move
    * Description: This method moves the robot by the given command
    * Return: void.
    */
   public void move (char dir){
      //Choose the right direction to move
      switch(dir){
         //Move forward by 1 step
         case 'M': 
            if(this.direction == 'N'){
               this.y_location++;
            }
            else if(this.direction == 'E'){
               this.x_location++;
            }
            else if(this.direction == 'S'){
               this.y_location--;
            }
            else if(this.direction == 'W'){
               this.x_location--;
            }
            break;
            //Turn left
         case 'L':
            if(this.direction == 'N'){
               this.direction = 'W';
            }
            else if(this.direction == 'E'){
               this.direction = 'N';
            }
            else if(this.direction == 'S'){
               this.direction = 'E';
            }
            else if(this.direction == 'W'){
               this.direction = 'S';
            }
            break;

            //Turn right
         case 'R':
            if(this.direction == 'N'){
               this.direction = 'E';
            }
            else if(this.direction == 'E'){
               this.direction = 'S';
            }
            else if(this.direction == 'S'){
               this.direction = 'W';
            }
            else if(this.direction == 'W'){
               this.direction = 'N';
            }
            break;
      }
   }
   /*
    * Method name: location
    * Return type: void
    * Param: None
    * Description: This method prints the basic information of a robot, 
    * including the position and the direction.
    * Return: void.
    */
   public void location (){
      System.out.println("Location: [" + this.x_location + ","
            + this.y_location + "]");
      System.out.println("Direction faced: " + this.direction );
   }

   /*
    * Method name: checkMove
    * Return type: boolean
    * Param: char dir -- direction to move
    * 		int x_size -- the x-size of map
    * 		int y_size -- the y-size of map
    * Description: This method checks whether the robot can move or not.
    * Return: true if can move. false if not.
    */ 
   public boolean checkMove (char dir, int x_size, int y_size){
      //Check direction
      switch(dir){
         //Move within the bound
         case 'M': 
            if(this.direction == 'N'){
               if(this.y_location >= y_size ){
                  return false;
               }
            }
            else if(this.direction == 'E'){
               if(this.x_location >= x_size ){
                  return false;
               }
            }
            else if(this.direction == 'S'){
               if(this.y_location == 0){
                  return false;
               }
            }
            else if(this.direction == 'W'){
               if(this.x_location == 0){
                  return false;
               }
            }
            else{
               return true;
            }
            //Can always turn left
         case 'L':
            return true;
            //Can always turn right
         case 'R':
            return true;			  
      }
      //When it cannot move
      return false;
   }
   /*
    * Method name: checkCommand
    * Return type: boolean
    * Param: char[] command -- The input movement command. 
    * Description: This method checks whether the command is valid.
    * Return: true if valid. false if not.
    */  
   public boolean checkCommand (char[] command){
      //Iterate through the command.
      for( int i = 0; i < command.length; i++ ){
         //return false if there is no match
         if(command[i] != 'L' && command[i] != 'R' && command[i] != 'M'){
            return false;
         }
      } 
      return true;
   }
}

