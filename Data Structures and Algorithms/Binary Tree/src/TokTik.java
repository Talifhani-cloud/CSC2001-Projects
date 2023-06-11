import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;

public class TokTik {


    // The main method is the starting point of the program

    public static void main(String args[]) throws Exception{

        BinarySearchTree<Account> bt = new BinarySearchTree<Account>(); // creates an object for the BST
        BinaryTreeNode<Account> accNode;
        Scanner keyboard = new Scanner(System.in); // creates an object for Scanner
        int choice; // initializes the choice variable as an integer which will be declared when the
        String account_name;

        //interactive statemets for the user to select an option/choice
        
        System.out.println("Choose an action from the menu:");
        System.out.println("1. Find the profile description for a given account");
        System.out.println("2. List all accounts");
        System.out.println("3. Create an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Display all posts for a single account");
        System.out.println("6. Add a new post for an account");
        System.out.println("7. Load a file of actions from disk and process this");
        System.out.println("8. Quit");

        System.out.print("Enter your choice: ");
        choice = keyboard.nextInt();
        keyboard.nextLine();
        
       System.out.println("");
            

        while(choice !=8 ){
            switch (choice) {
                
                // case 1 allows the user to access their account description using their acccount name provided that the account exists in the bst 
                case 1: 
                    System.out.print("Enter the account name: ");
                    account_name = keyboard.next();

                    Account verify = new Account(account_name, "");

                    BinaryTreeNode<Account> node = bt.find(verify);

                    if (node != null) {

                        bt.visit(node);
                        
                    } else {
                        System.out.println("Accoount name not found! ");
                    }

                    break;
                
               // case 2 displays all the accounts objects which are stored in binary search tree in a sorted formarted 
                case 2:
                    bt.inOrder();

                    break;

              //  Case 3 allows the user  to create an account through the user interface and add the object in the bst.
                case 3:
            
                    System.out.print("Enter the account name : ");
                       String name = keyboard.nextLine();

                    System.out.print("Give the profile description : ");
                    String descri = keyboard.nextLine();

                    Account creatAccount = new Account(name,descri);

                    bt.insert(creatAccount);
                    System.out.println("Account has been successfully created");

                    break;

               // Case 4 allows the user to delete an account in the binary search tree
                case 4:
                   System.out.print("Enter the account name: ");
                      account_name = keyboard.next();
                    
                    Account delete = new Account(account_name, "");

                    if(bt.find(delete)!= null){
                        bt.delete(bt.find(delete).data);
                        System.out.println("Account succesfully deleted");
                    }
                
                    else {
                        System.out.println("The account name you entered does not exist");
                    }
                    

                    break;
                
               // case 5 allows the user to display posts associated with the account name given by the user
                case 5 :
                      System.out.print("Enter the account name: ");
                         account_name = keyboard.next();
              
                         accNode = bt.find(new Account(account_name,"")); 
                         Account acc = accNode.data;
                         
                         ArrayList<Post> postLists = acc.getPosts();
     
                         for(int i=0;i<postLists.size();i++){
                            
                             System.out.println(postLists.get(i));
                         }
                        
                    break;

             // case 6 allows the user to add posts associated with the account given .
                case 6 : 
                        
                  System.out.print("Enter the account name:");
                  String accname = keyboard.nextLine();

                  System.out.print("Tiltle:");
                  String Title = keyboard.nextLine();
                
                  System.out.print("Video:");
                  String Video = keyboard.nextLine();

            
                  System.out.print("Number of likes:");
                  int likes = keyboard.nextInt();
                  keyboard.nextLine();
                     

                Post post = new Post(accname, Video, likes, Title);

                Account accobj = bt.find(new Account(post.get_Name(),"")).data;
                // we first delete the node from the bst associated with the  object of interest and modify the data then we add the  object to the bst .
                bt.delete(accobj);
                accobj.AddPost(post);
                bt.insert(accobj);
                
                ;
                    break;

                //creates accounts with associated posts from the dataset.txt  then stores the m in the bts.

                case 7 :

                  try {
                    System.out.print("Enter file name: ");
                    String filename = "data/"+keyboard.next();
                 
                    FileInputStream file = new FileInputStream(filename);
                    Scanner sc = new Scanner(file); 
                    

                    while(sc.hasNextLine()){ 
                    String line = sc.nextLine();
                    //sc.close();

                    if(line.startsWith("Create")){
                        
                        Account ac = new Account(line);
                        bt.insert(ac);

                        }
                        else{
                            Post postobj = new Post(line);
                            Account accobject = bt.find(new Account(postobj.get_Name(), "")).data;
                            bt.delete(accobject);
                            accobject.AddPost(postobj);
                            bt.insert(accobject);
                            
                        } 
                    }

                  System.out.println("FIle has been successfully loaded");                  
                }
                 catch (Exception e) {
                    System.out.println("File not found");
                    System.exit(0);
                 }
               
                    break;

            }

          
        System.out.println("Choose an action from the menu:");
        System.out.println("1. Find the profile description for a given account");
        System.out.println("2. List all accounts");
        System.out.println("3. Create an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Display all posts for a single account");
        System.out.println("6. Add a new post for an account");
        System.out.println("7. Load a file of actions from disk and process this");
        System.out.println("8. Quit");

        System.out.print("Enter your choice: ");
        choice = keyboard.nextInt();
 
       keyboard.nextLine();
       System.out.print("");
        
      
   
      }
      keyboard.close();
      
      System.out.println("Bye!");


    }


    
}
