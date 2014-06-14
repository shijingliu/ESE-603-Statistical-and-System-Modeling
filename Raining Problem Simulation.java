//The file simulate problem (c). It also returns the probability of getting wet

package homework3;       

public class SimulationProblem2 {
       public static void main(String []args){
    	   simulation();   
       }
      								
       public static void simulation (){
    	     //p, q value can be changed randomly here 
    	     final double p = 0.3;
    	     final double q = 0.4;    
    	    
             //set up the initial office umbrella and initial home umbrella    
    	     final int InitialOfficeUmbrella = 1;
    	     final int InitialHomeUmbrella = 1;    
    	     
    	     int [] HomeAtTheBeginning = new int [5000];
    	     int [] HomeAtTheEnd = new int [5000];
    	     int [] OfficeAtTheBeginning = new int [5000];   
    	     int [] OfficeAtTheEnd = new int [5000]; 
    	     int countGetWet = 0; 
    	     
    	     //initialize data         
    	     for (int simulation = 0; simulation < 5000; simulation++){
    	    	 HomeAtTheBeginning[simulation] = 0; 
    	    	 HomeAtTheEnd[simulation] = 0; 
    	    	 OfficeAtTheBeginning[simulation]=0; 
    	    	 OfficeAtTheEnd[simulation]=0;
    	     }   
    	     
    	     //set up the first day    
    	     HomeAtTheBeginning[0] = InitialHomeUmbrella;
    	     OfficeAtTheBeginning[0] = InitialOfficeUmbrella; 
    	     
    	     for (int simulation = 0; simulation < 4999; simulation++){  
    	     //go to work from home      		 
        	     double randRain1 = Math.random();     
        	     if(randRain1 < p){
        	    	 if((HomeAtTheBeginning[simulation] >0 && HomeAtTheBeginning[simulation] <=2)){
        	    		 HomeAtTheEnd[simulation] = HomeAtTheBeginning[simulation]-1;    
        	    		 OfficeAtTheEnd[simulation] = 2 - HomeAtTheEnd[simulation]; 
        	    	 }else{
        	    		 HomeAtTheEnd[simulation] = 0;
            	    	 OfficeAtTheEnd[simulation] = 2;
            	    	 
            	    	 //this is the situation that the man gets wet   
            	    	 countGetWet++; 
        	    	 }
        	     }else{
        	    	 HomeAtTheEnd[simulation] = HomeAtTheBeginning[simulation];  
        	    	 OfficeAtTheEnd[simulation] = OfficeAtTheBeginning[simulation];
        	     }
    	     
        	     //go to home from work         
        	     double randRain2 = Math.random();
        	     if(randRain2 < q){
        	    	 if((OfficeAtTheEnd[simulation]>0 && OfficeAtTheEnd[simulation] <=2)){
        	    		 OfficeAtTheBeginning[simulation+1] = OfficeAtTheEnd[simulation] -1; 
        	    		 HomeAtTheBeginning[simulation+1] = 2 - OfficeAtTheBeginning[simulation+1]; 
        	    	 }else{      
        	    		 OfficeAtTheBeginning[simulation+1] = 0;
            	    	 HomeAtTheBeginning[simulation+1] = 2; 
            	    	 
            	    	 //this is another situation that the man gets wet 
            	    	 countGetWet++; 
        	    	 }
        	     }else{  
        	    	 OfficeAtTheBeginning[simulation+1] = OfficeAtTheEnd[simulation];
        	    	 HomeAtTheBeginning[simulation+1] = HomeAtTheEnd[simulation]; 
        	     }  
    	     }
    	 
    	     int countHomeZero = 0; 
    	     int countHomeOne = 0; 
    	     int countHomeTwo = 0; 
    	     int countOfficeZero = 0; 
    	     int countOfficeOne = 0;    
    	     int countOfficeTwo = 0;    
    	     for (int index = 0; index < 5000; index++){
    	    	 if(HomeAtTheBeginning[index] == 0){
    	    		 countHomeZero++; 
    	    	 }
    	    	 if(HomeAtTheBeginning[index] == 1){
    	    		 countHomeOne++; 
    	    	 }
    	    	 if(HomeAtTheBeginning[index] == 2){
    	    		 countHomeTwo++; 
    	    	 }
    	    	 if(OfficeAtTheEnd[index] == 0){   
    	    		 countOfficeZero++; 
    	    	 }
    	    	 if(OfficeAtTheEnd[index] == 1){
    	    		 countOfficeOne++; 
    	    	 }
    	    	 if(OfficeAtTheEnd[index] == 2){   
    	    		 countOfficeTwo++; 
    	    	 }
    	     }
    	    
             System.out.println("Long-Term H value:");
    	     System.out.println(countHomeZero/5000.0);
    	     System.out.println(countHomeOne/5000.0);
    	     System.out.println(countHomeTwo/5000.0);
    	     System.out.println("Long-Term O value:");
    	     System.out.println(countOfficeZero/5000.0);
    	     System.out.println(countOfficeOne/5000.0);
    	     System.out.println(countOfficeTwo/5000.0);
    	     System.out.println("The Probability of getting wet:");     
    	     System.out.println(countGetWet/5000.0);
       }
       
}
