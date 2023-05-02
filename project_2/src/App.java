import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
//Mya Moxley
//Project 2,3,4
public class App {
    static Scanner input = new Scanner(System.in);
   public static void main(String[] args) throws IOException{
      
   
    ArrayList<Task> numTask = new ArrayList<>();

    
      
    
    /////////////////////////////////////////////////////

    System.out.println("Reading in existing Tasks!");
    //File file = new File("data.json");
    BufferedReader br = new BufferedReader(new FileReader("data.json"));
    ObjectMapper map = new ObjectMapper();
    
    String st;
    String total="";
    while((st = br.readLine())!=null){
      total = total+st;
   }
   numTask = map.readValue(total, ArrayList.class);
    System.out.println(numTask);
    
   


      try{
      System.out.println("1. Add Task");
      System.out.println("2. Remove Task");
      System.out.println("3. Update Task");
      System.out.println("4. List all Tasks");
      System.out.println("5. List Tasks Based on Priotity");
      System.out.println("0. Exit");
      int selection = input.nextInt();
      input.nextLine();
      
      while(true){
      if (selection==1) {
         addTask(numTask);
      } else if (selection==2) {
         removeTask(numTask);
      } else if (selection==3) {
         updateTask(numTask);
      } else if (selection==4) {
         listAll(numTask);
      } else if (selection==0){
         map.writeValue(new File("data.json"),numTask);
         System.exit(0);
      } else if (selection==5){
         pri(numTask);
      }
      System.out.println("Please make a selection");
      selection = input.nextInt();
      input.nextLine();
   }
   }catch(InputMismatchException a){
      System.out.println("Problem, retry");
   }

   }

   

   



/* Add task */
   static ArrayList<Task> addTask(ArrayList<Task>a){
      System.out.println("Adding a task");
         String task = input.nextLine();

         System.out.println("Description of task: ");
         String b = input.nextLine();
         System.out.println("Priority 1-5: ");
         int c = input.nextInt();
         Task task1 = new Task(task,b,c);
         a.add(task1);
         System.out.println(task1);
         return a;


   }
/* Priority */ 
   static void pri(ArrayList<Task>a){
      for (Task item : a){
         System.out.println("What priority would you like to find: ");
         int userinput = input.nextInt();
         int prio = item.getPriority();
         if(prio==userinput){
            System.out.println(item);
         }
      }
  
}
   
/* Remove Task */
   static ArrayList<Task> removeTask(ArrayList<Task>a){
      System.out.println("Removing a Task by Index");
         int task = input.nextInt();
         a.remove(task);
         return a;
   }
/* Update Task */
   static ArrayList<Task> updateTask(ArrayList<Task>a){
      System.out.println("You chose : Update a Task");
      System.out.println("Whats the index of the task you'd like to remove?");
      int ind = input.nextInt();
      input.nextLine();

      System.out.println("What would you like to update it to");
         String task = input.nextLine();

         System.out.println("Description of task: ");
         String b = input.nextLine();
         System.out.println("Priority 1-5: ");
         int c = input.nextInt();
         Task task1 = new Task(task,b,c);
         a.add(task1);
         System.out.println(task1);
      

         a.set(ind, new Task(task,b,c));
         return a;
   }

/* List All Tasks */
static void listAll(ArrayList<Task> a){
   System.out.println("Print all Tasks");
      Collections.sort(a);
      System.out.println(a);

}



}

        