package homework2;

public class Simulation1 {
     public static void main(String []args){
    	 TaskTimeSimulation();
     }
     
     public static void TaskTimeSimulation (){
    	  final int lamda1 = 60; 
	      final int lamda2 = 60; 
	      final int lamda3 = 60; 
	      final double p1 = 0.4; 
	      final double p2 = 0.3; 
	      final double p3 = 0.2; 
	      final double p4 = 0.1;
	      final double p1Time = 20.0; 
	      final double p2Time = 30.0; 
	      final double p3Time = 40.0;    
	      final double p4Time = 50.0; 
	      
	      int countOver200 = 0; 
    	 
    	  for(int simulation = 0; simulation < 2000; simulation++){
    		      
    		   
    		      double task1 = Math.log(Math.random())*(-1.0)*lamda1; 
    		      double task2 = Math.log(Math.random())*(-1.0)*lamda2;
    		      double task3 = Math.log(Math.random())*(-1.0)*lamda3;
    		      
    		      double task4 = 0.0; 
    		      double randTask4 = Math.random(); 
    		      if(randTask4<p1){task4 = p1Time;}
    		      else if((randTask4>=p1)&&(randTask4<(p1+p2))){task4 = p2Time;}
    		      else if((randTask4>=(p1+p2))&&(randTask4<(p1+p2+p3))){task4 = p3Time;}
    		      else{task4 = p4Time;}
    		      
    		      if((task1+task2+task3+task4)>200.0){
    		    	  countOver200++;
    		      }
    		      
    	   }   
    	   System.out.print("the probability that it takes more than 200 minutes is: ");
    	   System.out.println((countOver200*1.0)/2000.0);
     }
}
