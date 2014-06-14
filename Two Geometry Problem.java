package homework1;

public class Problem2 {
       public static void main(String []args){
    	   System.out.print("the probability of obtuse triangle is: ");
    	   System.out.println(ObtuseTriangle());
    	   System.out.print("the average area is: ");
    	   System.out.println(AverageArea());  
       }
       
       
       public static double ObtuseTriangle(){
    	     int countObuse = 0; 
    	     for(int simulation = 1; simulation <= 3000; simulation++){
    	    	  double randX1 = Math.random();   
    	    	  double randY1 = Math.random(); 
    	    	  double randX2 = Math.random(); 
    	    	  double randY2 = Math.random(); 
    	    	  double randX3 = Math.random(); 
    	    	  double randY3 = Math.random(); 
    	    	  
    	    	  double a = Math.sqrt((randX1-randX2)*(randX1-randX2)+(randY1-randY2)*(randY1-randY2)); 
    	    	  double b = Math.sqrt((randX2-randX3)*(randX2-randX3)+(randY2-randY3)*(randY2-randY3));
    	    	  double c = Math.sqrt((randX3-randX1)*(randX3-randX1)+(randY3-randY1)*(randY3-randY1));
    	    	  
    	    	  if((a*a+b*b<c*c)||(a*a+c*c<b*b)||(b*b+c*c<a*a)){
    	    		  countObuse++; 
    	    	  }
    	     }
    	     return countObuse/3000.00; 
       }
       
       
       public static double AverageArea(){
    	     double sumArea = 0.0; 
	  	     for(int simulation = 1; simulation <= 3000; simulation++){ 
	  	    	  double randX1 = Math.random();    
	  	    	  double randY1 = Math.random(); 
	  	    	  double randX2 = Math.random(); 
	  	    	  double randY2 = Math.random(); 
	  	    	  double randX3 = Math.random(); 
	  	    	  double randY3 = Math.random(); 
	  	    	  
	  	    	  double area = Math.abs((randX1*(randY2-randY3)+randX2*(randY3-randY1)+randX3*(randY1-randY2))/2.0);
	  	    	  sumArea += area; 
	  	     }
	  	     return sumArea/3000.00; 
       }
}
