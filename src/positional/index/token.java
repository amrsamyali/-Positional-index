/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package positional.index;

/**
 *
 * @author fatma adel
 */
public class token {
    
 	String name ="";
	int doc_id =0;
	int [] tf_array = {0 , 0 , 0}  ; //to know in which doc this token is  for ex d1 = 0, d2 = 1, d3 =1
	double[] step3 = {0 , 0 , 0};
	double idf, tf = 0;

    public token() {
    }
        
        
        
       
}
