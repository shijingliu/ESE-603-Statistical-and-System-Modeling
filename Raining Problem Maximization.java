package homework3;

public class SimulationProblem2_P_Maximization {
    public static void main(String []args){
    	
       //we run the simulation for 100 times to figure out the maximum p value
       //the step size is 0.01 each time    
    	double [] p_store = new double [100];
    	for (int i = 0; i < 100; i++){
    		 p_store[i] = simulation(i/100.0);  	
    	} 
    	
    	double Pwet = 0.0; 
    	double record = 0.0; 
        for (int i = 0; i < 100; i++){
        	if(p_store[i] > Pwet){
        		Pwet = p_store[i];  
        		record = i/100.0; 
        	}
        }
        System.out.print("the maximum value of p is:");
        System.out.println(record);
        System.out.print("the maximum Pwet is:");
        System.out.println(Pwet);   
    }
   								
    public static double simulation (double p_value){ 
 	     final double p = p_value;
 	     final double q = p_value;    
 	    
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
 	 
 	     return (countGetWet/5000.0);
    }
    
}
