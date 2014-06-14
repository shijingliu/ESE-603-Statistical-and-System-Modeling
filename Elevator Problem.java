package homework1;

public class Problem1 {
      public static void main(String []args){
    	System.out.print("the average number of people are: "); 
    	System.out.println(elevatorProblem()[0]); 
    	System.out.print("the probability of empty floor is: "); 
    	System.out.println(elevatorProblem()[1]);
    	System.out.print("the proability of filled floor is: "); 
    	System.out.println(elevatorProblem()[2]);
      }
      
      public static double[] elevatorProblem(){
    	 double [] result = new double [3];
    	 double totalSum = 0.0; 
    	 double totalEmpty = 0.0; 
    	 double totalFilled = 0.0; 
    	 for(int simulation = 1; simulation <=100; simulation++)
    	 {
		    	 final int MaximumCapacity = 12; 
		    	 //the elevator goes up to the 10th floor     
		    	 int [] ElevatorUpPeople = new int[11]; 
		    	 int [] ElevatorDownPeople = new int [11];
		    	 int sumUp = 0;
		    	 int sumDown = 0;   
		    	 int recordEmpty = 0; 
		    	 int recordFilled = 0; 
		    	 for(int floor = 1; floor <= 10; floor++){
		    		 double RandOff = Math.random();  
		    		 double RandUp = Math.random(); 
		    		 int PeopleGetOff, PeopleGetOn; 
		    		 if(floor == 1)
		    		 {
		    			 //the elevator is empty at the beginning   
		    			 PeopleGetOff = 0; 
		    			 PeopleGetOn = (int) (RandUp*(MaximumCapacity+1));
		    			 ElevatorUpPeople[floor] = PeopleGetOn; 
		    		 }else{
		    		     PeopleGetOff = (int)((ElevatorUpPeople[floor-1]+1)*RandOff);
		    		     PeopleGetOn = (int) ((MaximumCapacity-(ElevatorUpPeople[floor-1]-PeopleGetOff)+1)*RandUp);
		    		     ElevatorUpPeople[floor] = ElevatorUpPeople[floor-1]-PeopleGetOff + PeopleGetOn; 
		    		 } 
		    		 //flag all the empty floors when going up; 
		    		 if(ElevatorUpPeople[floor]==0){
		    			 recordEmpty++; 
		    		 }
		    		 //flag all the filled floors when going up; 
		    		 if(ElevatorUpPeople[floor]==12){
		    			 recordFilled++;
		    		 }
		    		 sumUp += ElevatorUpPeople[floor];
		    	 }   
		    	 //then the elevator goes down to the 1st floor    
		    	 for (int floor = 9; floor >=1; floor--){
		    		 double RandOff = Math.random();  
		    		 double RandUp = Math.random(); 
		    		 int PeopleGetOff, PeopleGetOn; 
		    		 if(floor == 9){
		    			 PeopleGetOff = (int)((ElevatorUpPeople[10]+1)*RandOff); 
		    			 PeopleGetOn = (int)((MaximumCapacity -(ElevatorUpPeople[10] - PeopleGetOff)+1)*RandUp);
		    			 ElevatorDownPeople[floor] = ElevatorUpPeople[10] - PeopleGetOff + PeopleGetOn; 
		    	     }else{
		    			 PeopleGetOff = (int) ((ElevatorDownPeople[floor]+1)*RandOff);  
		    			 PeopleGetOn = (int) ((MaximumCapacity-(ElevatorDownPeople[floor-1]-PeopleGetOff)+1)*RandUp);
		    			 ElevatorDownPeople[floor] = ElevatorDownPeople[floor-1]-PeopleGetOff+PeopleGetOn; 
		    		 }
		    		 //flag all empty floors when going down 
		    		 if(ElevatorDownPeople[floor]==0){ 
		    			 recordEmpty++; 
		    		 }
		    		 //flag all filled floors when going down
		    		 if(ElevatorDownPeople[floor]==12){
		    			 recordFilled++; 
		    		 }
		    		 sumDown += ElevatorDownPeople[floor];
		    	 }
		    	 totalSum += (sumUp+sumDown); 
		    	 totalEmpty += recordEmpty; 
		    	 totalFilled += recordFilled; 
    	 }
    	 result [0] = totalSum/1900.00;
         result [1] = totalEmpty/1900.00; 
         result [2] = totalFilled/1900.00; 
         return result; 
      }
}
