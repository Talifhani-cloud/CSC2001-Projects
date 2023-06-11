import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Operationresults {
           /**
     * The method that writes the data into the file and store the dataset.css files on disk 
     *  
     * @param Filename takes in a String value
     * 
     * 
     */
  


         public static int readfile(String Filename){
  
            String sourcenode = new String();
            Graph graph = new Graph( );
            
                 try
                 {   	
                     FileReader fin = new FileReader(Filename);
                     Scanner graphFile = new Scanner( fin );
         
                     // Read the edges and insert
                     String line;
                     
                     while( graphFile.hasNextLine( ) )
                     {
                         line = graphFile.nextLine( );
                         StringTokenizer st = new StringTokenizer( line );
         
                         try
                         {
                             if( st.countTokens( ) != 3 )
                             {
                                 System.err.println( "Skipping ill-formatted line " + line );
                                 continue;
                             }
                             String source  = st.nextToken( );
                             String dest    = st.nextToken( );
                             int    cost    = Integer.parseInt( st.nextToken( ) );
                             graph.addEdge( source, dest, cost );
                         }
                         catch( NumberFormatException e )
                           { System.err.println( "Skipping ill-formatted line " + line ); }
                        sourcenode = line.substring(0,line.indexOf(" "));
                    
                      }

                   graphFile.close();
                  }
                  catch( IOException e )
                    { System.err.println( e ); }
                // System.out.println(startnode);
                   
                graph.dijkstra(sourcenode); 
    
                System.out.println("The Number of operations  for this is : "+ graph.numOperations+"\n");
    
                
                return graph.numOperations;
                }
public static void main(String args[]) throws IOException {
    

        File folder = new File("./data/"); // path to data directory
        File file2 = new File("dataset.csv");
        FileWriter writer = new FileWriter(file2);
        File[] files = folder.listFiles();
    

            if(files !=null){
                for (File file : files) {
                    
                    System.out.print(file);
                    if (file.isFile()) {
                        System.out.println("\n The file that is being processesed: " + file.getName());
                        int op = readfile("./data/"+file.getName());
                       
            
                        String node = file.getName().substring(7, file.getName().indexOf("."));
                        String Edge = file.getName().substring(file.getName().indexOf(".")+1,file.getName().indexOf(".txt"));
    
                        writer.write(node +"," +Edge+","+ op +"\n");
                        writer.flush();
                        
                      }
                    }
                  writer.close();
                }
                  else {
                    System.out.println("File not found");

                  }
                
    
}

}
