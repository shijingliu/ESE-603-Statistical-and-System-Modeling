package homework1;

public class Problem4 {
       public static void main(String[] args){
    	   System.out.print("The probability that two will meet is: ");
    	   System.out.println(TwoArrivalStreams());
       }
       
       public static double TwoArrivalStreams(){
    	   int countMeet = 0; 
    	   for(int simulation = 1; simulation <= 1000; simulation++){
    		    double rand1 = Math.random(); 
    		    double rand2 = Math.random(); 
    		    
    		    double ArrivalMarry = rand1*30.0; 
    		    double ArrivalJohn = rand2*30.0; 
    		    
    		    
    		    //judge if John and Marry will meet     
    		    //"neither of them will wait past 4:00 PM" is not a condition, because neither of them will arrive after 4:00Pm
    		    if(((ArrivalJohn < ArrivalMarry)&&(ArrivalMarry<=ArrivalJohn+7.0))||((ArrivalMarry< ArrivalJohn)&&(ArrivalJohn<=ArrivalMarry+5.0))){
    		    	countMeet++; 
    		    }      
    	   }    
    	   return countMeet/1000.00; 
       }
}
