import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * GraphExperimental class  generates the dataset.txt file that contains nodes and edges and their cost and finds the performs dijkstra  operations  
 * All the  methods are immutable.They cannot be changed  outside the GraphExperimetntal class except the .
 * 
 * @author Talifhani Nemaangani
 */
public class DatasetGenerator{

    private static int [] numNodes = {10,20,30,40,50};
    private static int[] numEdges = {10,15,20,35,50,65,80,85,90,100};
    private static Random random_1 = new Random();
    static Random random_2= new Random();
    private static ArrayList<String> Vertex = new ArrayList<String>();
    private static ArrayList<String> Edges = new ArrayList<String>();

    /**
     * The createNodes method creates a random vertex and adds it to the array list  
     * @param length takes in an integer value
     * 
     */

    public static void createNodes(int length) 
    {
        for (int i = 0; i<length;i++){
            
            String node = "node"+i;
            Vertex.add(node);

        
        }
        
    }
    

    /**
     * The method that creates possible edges for the nodes and includes the cost  and adds it to the array list 
     *  and ,ake it in this form NodeX NodeY Z  
     * @param length takes in an integer value
     * 
     */
    
    public static void makeEdges(int length) {

         for(int i=0;i<length;i++){

            int position_1 = random_1.nextInt(Vertex.size()-1);
            int position_2 = random_2.nextInt(Vertex.size() - 1);

                while(position_1 == position_2){
                    position_2 = random_2.nextInt(Vertex.size() - 1);
                  }

            int cost = random_2.nextInt(10)+1;
        
             Edges.add(Vertex.get(position_1)+ " "+Vertex.get(position_2)+ " "+Integer.toString(cost));
       
          }     
     }
     
        /**
     * The method that writes the data into the file and store the dataset.txt files on data folder 
     *  
     * @param vertex takes in an integer value
     * @param arc takes in an integer 
     * 
     */
  
    public static void filewrite(int vertex,int arc )throws IOException  {

        File file = new File("data/","dataset"+vertex+"."+arc+".txt");
            try (FileWriter f = new FileWriter(file)){
                for (String i:Edges){
                    f.write(i+"\n");
                    f.flush();
                
                }
             }
     }

    

    public static void main(String args[]) throws IOException {
         
         for(int j: numNodes){   

              for(int i : numEdges){
            
                createNodes(j);
                 makeEdges(i);  
                filewrite(j,i); 
                Edges.clear();
                Vertex.clear();    
        
                 }
            
             }
            
  

      }//end main
}
             
  
    

