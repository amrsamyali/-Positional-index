/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package positional.index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author fatma adel
 */
public class PositionalIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        
        ArrayList<String> tokenss = new ArrayList<String>(); 
         ArrayList<Integer> document = new ArrayList<Integer>();
          
 String[] fileNames = new String[]{  "E:\\level 4\\IR\\doc1.txt", "E:\\level 4\\IR\\doc2.txt","E:\\level 4\\IR\\doc3.txt","E:\\level 4\\IR\\doc4.txt"};
 
     ArrayList indexdoc = new ArrayList();
     int j=1;
     

  for(String fileName: fileNames) {  
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      System.out.println("Start reading file : "+fileName);
      int i =0;
     String line = null;
      while(( line=reader.readLine())!= null){
        
          System.out.println("D : "+line);
                
          String delims = "[ .,:/]+";
          
          StringTokenizer st = new StringTokenizer(line,delims);
            while ( st.hasMoreTokens() )
            {                
            String token = (String)st.nextToken();
             tokenss.add(token);   
             document.add(j);
             indexdoc.add(i);
                i++;
            }
      }
        j++ ;
      reader.close();
  

    }
 
  
    System.out.print("Enter your Query: ");
  Scanner scanner = new Scanner(System.in);
  String query = scanner.nextLine();
   ArrayList qurList = new ArrayList();
      ArrayList docmentfrq1 = new ArrayList(); 
  String[] splits = query.split(" ");
  for(String split : splits){
   qurList.add(split);
}
   for (int a=0 ; a< qurList.size();a++){
             System.out.println(qurList.get(a).toString()+" ( ");
         for (int b = 0; b < tokenss.size(); b++) {
               if(qurList.get(a).equals(tokenss.get(b))){
                   docmentfrq1.add("D"+document.get(b).toString());
                   System.out.println(String.format("D%s :  %s  , ",document.get(b).toString(),indexdoc.get(b).toString(), ","));
                     
               }
         }
         System.out.println(" )");
   }
   System.out.println("  \n   ");
        
  /* for (int a=0 ; a< qurList.size();a++){
   for (int b = 0; b < tokenss.size(); b++){
       if(qurList.get(a).equals(tokenss.get(b))){
        if(qurList.get(a+1).equals(tokenss.get(b+1))){
        
          System.out.println( qurList.get(a).toString() +document.get(b)+ indexdoc.get(a));  
           System.out.println( qurList.get(a+1).toString() +document.get(b+1)+ indexdoc.get(a+1)); 
        }
       }
   }
   }*/
   
         int max = 0;
         int curr = 0;
      String currKey =  null;
      Set<String> unique = new HashSet<String>(docmentfrq1);

          for (String key : unique) {
                curr = Collections.frequency(docmentfrq1, key);
               if(max < curr){
                 max = curr;
                 currKey = key;
                }
            }
          System.out.println(currKey  +"  is the matched document "); 
    } 
   
    }
    


