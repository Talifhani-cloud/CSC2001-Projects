  /**
 * Post represents  the information of the posts associated with Account
 * The profile post details are immutable.They cannot be changed  outside the post class.
 * 
 * @author Talifhani Nemaangani
 */

public class Post implements  Comparable <Post>  {
    

   private String sentence_2;
   private  String sentence_3;
   private  String sentence_4;
   private   String  name;
   private  String  title;
   private   String  video;
   private  int  likes;


   /**
 * constructor takes in the entire  line for creating a Post and performs operations  on the line and intializes the post details. 
 * @param sentence line  that startswith  Add in the dataset.txt
 */

    public Post(String sentence){
      this.sentence_2=sentence;
        this.name = remove_Add().substring(0,remove_Add().indexOf(","));
        this.video = remove_Name().substring(0,remove_Name().indexOf(","));
        this.likes = Integer.parseInt(remove_Video().substring(0,remove_Video().indexOf(",")));
        this.title = (remove_Video().substring(remove_Video().indexOf(",")+1)).replace(',',' ');
    }
         // Add hussein video34.mpg 34 Yet Another video of cats
     /**
      * Constructor.Initialize The post dettails
      * @param name account name
      * @param video video 
      * @param likes number of likes
      * @param title Title of the post
      */

   public Post (String name , String video ,int likes , String title){
    this.name = name;
    this.video = video ;
    this.likes = likes ;
    this.title = title ;
   }

  
/**
 * CompareTo method compares the account names and videos of the post,which allows us to be able to implement the comparable interface for bst 
 * @param post  other post object
 * @return returns an int datatype
 */
   public int compareTo(Post post){
  return (name+video).compareTo(post.name +post.video);
}


/**
 * remove_Add method perform operations to remove the Add word  from the line eg. "Add Zuckuss5 video3670.mpg 9963 by Petaluma sign's Giauque's dugouts" --> "Zuckuss5 video3670.mpg 9963 by Petaluma sign's Giauque's dugouts"
 * @return String sentence eg. Zuckuss5 video3670.mpg 9963 by Petaluma sign's Giauque's dugouts
 */
   
     private String remove_Add(){
        if (sentence_2.startsWith("Add")){
          sentence_2 = sentence_2.replaceFirst(" ", ",");
          sentence_2 = sentence_2.replaceFirst(" ", ",");
          sentence_2 = sentence_2.substring(("Add").length()+1);
        }
      return sentence_2;
    }//end remove

    /**
     * the remove_name performs operation to remove the account name in a sentence eg."Zuckuss5 video3670.mpg 9963 by Petaluma sign's Giauque's dugouts" -->"video3670.mpg 9963 by Petaluma sign's Giauque's dugouts"
     * @return String sentence e.g "video3670.mpg 9963 by Petaluma sign's Giauque's dugouts"
     */
    
    private String remove_Name(){
        if (remove_Add().startsWith(get_Name())){
          sentence_3 = sentence_2.replaceFirst(" ", ",");
          sentence_3 = sentence_3.replaceFirst(" ", ",");
          sentence_3 = sentence_3.substring((get_Name()).length()+1);
        }
      return sentence_3;
    }//end remove name

  /**
     * the remove_name performs operation to remove the Video name in a sentence eg."video3670.mpg 9963 by Petaluma sign's Giauque's dugouts" -->"9963 by Petaluma sign's Giauque's dugouts"
     * @return String sentence e.g "9963 by Petaluma sign's Giauque's dugouts"
     */
    private String remove_Video(){
        if (remove_Name().startsWith(get_Video())){
           sentence_4 = sentence_3.replaceFirst(" ", ",");
          //sentence_4 = sentence_4.replaceFirst(" ", ",");
          sentence_4 = sentence_4.substring((get_Video()).length()+1);
        }
      return sentence_4;
    }//end remove Video


  /**
    * get_Name method allows external classes access the account name instead of an actual variable/refernce
    * @return accountname
    */
    public String get_Name(){
      return name;
    }// end name

    /**
    * get_Video method allows external classes access the video instead of an actual variable/refernce
    * @return video 
    */
    
    public String get_Video(){
        return video;

    }// end video

    /**
    * get_likes method allows external classes access the likes instead of an actual variable/refernce
    * @return likes
    */

    public int get_likes(){
        return likes;
    }// end likes

    /**
    * get_Title method allows external classes access the post Title instead of an actual variable/refernce
    * @return accountname
    */

    public String get_Title(){
        return title;
    }

    @Override
    public String toString(){
        return "Title: "+get_Title()+"\n"+
        "Video: "+get_Video()+"\n" +
        "Number of likes: "+ get_likes();
    }
 
}//end posts