import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 * Account represents  the information of the Account profile
 * The profile account details are immutable.They cannot be changed  outside the Acoount class.
 * 
 * @author Talifhani Nemaangani
 */
public class Account implements  Comparable <Account> {

  private String acc_name;
  private String sentence;
  private String  description;
  private String filename;
  private ArrayList<Post> posts ;

/**
 * constructor takes in the entire  line for creating an account and performs operations  on the line and intializes the account details with associated array posts list declared. 
 * @param sentence line that creates an account from the dataset.txt file .
 */

public Account(String sentence){
      this.sentence = sentence;
      acc_name = remove_Create().substring(0,remove_Create().indexOf(","));
      description = remove_Create().substring(remove_Create().indexOf(",")+1);
      posts = new ArrayList<Post>();
    }
/**
 * Constructor .Intializes the account details and the assosiated Post Array list is declared. 
 * @param accname account name
 * @param description account description
 */
public Account(String accname ,String description){
  this.acc_name = accname;
  this.description = description;
  posts = new ArrayList<Post>();
}

/**
 * CompareTo method compares the account names ,which allows us to be able to implement the comparable interface for bst 
 * @param acc other Account object
 * @return returns an int datatype
 */

public int compareTo(Account acc){
  return this.acc_name.compareTo(acc.acc_name);
}

/**
 * remove_Create method perform operations to remove the create word  from the line eg. "Create Greedo4 latching fertilizer photon's" --> "Greedo4 latching fertilizer photon's" 
 * @return String sentence eg. "Greedo4 latching fertilizer photon's" 
 */

  private String remove_Create(){
    if (sentence.startsWith("Create")){
      sentence = sentence.replaceFirst(" ", ",");
      sentence = sentence.replaceFirst(" ", ",");
     sentence = sentence.substring(("Create").length()+1);
    }
  return sentence;
  }

  /**
   * Addpost method adds the post object to the arraylist associated with Account object.
   * @param post Post object
   */

  public void AddPost(Post post){
    posts.add(post);

  }
   /**
    * getPosts method allows external classes access the posts  array list instead of an actual variable/refernce
    * @return ArrayList<Post>
    */
public ArrayList<Post> getPosts(){
  return posts;
}

@Override
 public String toString(){
  return "The profile description is: "+ acc_name +" is " + description;
 }
    
}//end class
