//Since I don't know how many customers will be there, I will use LinkedList as my data structure 
//to simulate this problem. This class (problem3) will invoke two helper class (CustomerP3 and LinkedListNode)

package homework1;

public class Problem3 {
       public static void main (String []args){
    	     OptimizationProblem();
       }
       
       public static void OptimizationProblem (){
    	      final double a = 0.0; 
    	      final double b = 5.0; 
    	      
    	      final double c1 = 0.75;   
    	      final double c2 = 1.25;     
    	      final double c3 = 1.5; 
    	      
    	      final double p1 = 0.3; 
    	      final double p2 = 0.5; 
    	      final double p3 = 0.2; 
    	      
    	      final double C = 0.15; 
    	      final double S = 0.05; 
    	      final double TotalTime = 10.0*60.0; 
    	      
    	      //Now, through some simple analysis, we can know that there should be at least 10*60/5 = 120 Pretzels
    	      //for the upside, it could be infinite number of Pretzels. So we temporarily set it to be 10,000 Pretzels   
    	      
    	      double [] ProfitSum = new double [10000]; 
    	      for(int simulation = 120; simulation <10000; simulation++){
			    	      //record how many Pretzels the owner has ordered  
			    	      int recordNumOfPretzels = simulation; 
			    	      
			    	      //calculate the first customer here       
			    	      CustomerP3 first = new CustomerP3 (); 
			    	      first.InterArrivalTime = 0.0;
			    	      first.ArrivalTime = 0.0; 
			    	      double RandPretzelsFirst = Math.random(); 
			    	      if(RandPretzelsFirst<=p1){first.NumberofPretzels =1; first.Profit=c1-C; first.ExceedDemandPunishment = 0.0;}
			    	      else if((RandPretzelsFirst<=(p1+p2))&&(RandPretzelsFirst>p1)) {first.NumberofPretzels = 2; first.Profit =c2-2*C; first.ExceedDemandPunishment = 0.0;}
			    	      else {first.NumberofPretzels = 3; first.Profit = c3-3*C; first.ExceedDemandPunishment = 0.0; }
			    	      
			    	      LinkedListNode current = new LinkedListNode (first);    
			    	      //keep a pointer (head pointer) always points to the head of the LinkedList 
			    	      LinkedListNode head = current; 
			    	      
			    	      //calculate the later customers, the simulation will continue until the ArrivalTime 
			    	      //is less than TotalTime (600 minutes) 
			    	      while(current.data.ArrivalTime<TotalTime){
			    	    	  CustomerP3 newCustomer = new CustomerP3(); 
			    	    	  newCustomer.InterArrivalTime = a+Math.random()*(b-a);
			    	    	  newCustomer.ArrivalTime = newCustomer.InterArrivalTime+current.data.ArrivalTime; 
			    	    	  
			    	    	  //for the later situation, consider the case that there is not enough Pretzels  
			    	    	  //consider the situation that customer buys one Pretzels 
			    	    	  double RandPretzelsLater = Math.random(); 
			        	      if(RandPretzelsLater<=p1){
			        	    	  newCustomer.NumberofPretzels =1; 
			        	    	  if(recordNumOfPretzels>=1){
			        	    		  newCustomer.Profit=c1-C;
			        	    		  //no exceed demand, so no profit punishment 
			        	    		  newCustomer.ExceedDemandPunishment = 0.0; 
			        	    		  //get rid of one Pretzel
			        	    		  recordNumOfPretzels-=1; 
			        	    	  }else{
			        	    		  newCustomer.Profit = 0;
			        	    		  //lost profit punishment here 
			        	    		  newCustomer.ExceedDemandPunishment = c1-C; 
			        	    	  }
			        	      } 
			        	      //consider the situation that customer buys two Pretzels 
			        	      else if((RandPretzelsLater<=(p1+p2))&&(RandPretzelsLater>p1)) {
			        	    	  newCustomer.NumberofPretzels = 2; 
			        	    	  if(recordNumOfPretzels>=2){
			        	    		  newCustomer.Profit =c2-2*C;
			        	    		  //no exceed demand, so no profit punishment 
			        	    		  newCustomer.ExceedDemandPunishment = 0.0; 
			        	    		  //get rid of two Pretzels 
			        	    		  recordNumOfPretzels-=2; 
			        	    	  }else if(recordNumOfPretzels >=1 && recordNumOfPretzels <2){
			        	    		  newCustomer.Profit = c1-C;
			        	    		  //lost profit punishment here  
			        	    		  newCustomer.ExceedDemandPunishment = (c2-c1)-C; 
			        	    		  //get rid of one Pretzel 
			        	    		  recordNumOfPretzels-=1;   
			        	    	  }else{
			        	    		  newCustomer.Profit = 0.0;    
			        	    		  //lost profit punishment here    
			        	    		  newCustomer.ExceedDemandPunishment = c2-2*C; 
			        	    	  }
			        	    	  
			        	      }
			        	      //consider the situation that customer buys three Pretzels 
			        	      else {
			        	    	  newCustomer.NumberofPretzels = 3; 
			        	    	  if(recordNumOfPretzels >=3){
			        	    		  newCustomer.Profit = c3-3*C;
			        	    		  //no exceed demand, so no profit punishment 
			        	    		  newCustomer.ExceedDemandPunishment = 0.0; 
			        	    		  //get rid of three Pretzels 
			        	    		  recordNumOfPretzels -= 3; 
			        	    	  }else if(recordNumOfPretzels >=2 && recordNumOfPretzels <3){
			        	    		  newCustomer.Profit = c2-2*C; 
			        	    		  //lost profit punishment here 
			        	    		  newCustomer.ExceedDemandPunishment = (c3-c2)-C; 
			        	    		  //get rid of two Pretzels 
			        	    		  recordNumOfPretzels -= 2; 
			        	    	  }else if(recordNumOfPretzels >=1 && recordNumOfPretzels <2){
			        	    		  newCustomer.Profit = c1-C; 
			        	    		  //lost profit punishment here 
			        	    		  newCustomer.ExceedDemandPunishment = (c3-c1)-2*C; 
			        	    		  //get rid of one Pretzels  
			        	    		  recordNumOfPretzels -= 1; 
			        	    	  }else{
			        	    		  newCustomer.Profit = 0.0; 
			        	    		  //lost profit punishment here  
			        	    		  newCustomer.ExceedDemandPunishment = c3-3*C; 
			        	    	  }
			        	      }
			        	      current.appendToTail(newCustomer);
			        	      current = current.next; 
			               }
			    	      
			    	      //now we can calculate the profit from each customers    
			    	      //consider two cases: there is no Pretzels left, or there are still some Pretzels left
			    	     
			    	      if(recordNumOfPretzels ==0){
			    	    	   while(head.next != null){
			    	    		   ProfitSum[simulation] += (head.data.Profit - head.data.ExceedDemandPunishment);
			    	    		   head = head.next; 
			    	    	   }
			    	      }else{
			    	    	   while(head.next != null){
			    	    		   ProfitSum[simulation] += (head.data.Profit - head.data.ExceedDemandPunishment);
			    	    		   head = head.next; 
			    	    	   }
			    	    	   //get rid of the leftover with scrappy price  
			    	    	   ProfitSum[simulation] = ProfitSum[simulation] - recordNumOfPretzels*C + recordNumOfPretzels*S; 
			    	      }  
			    	     
    	      }
    	      
    	     
    	      //now we figure out the biggest profit index 
    	      double maximumProfit = -10000.00; 
        	  int PurchaseRecord = 120; 
    	      for(int i = 120; i<10000; i++){
    	           if(ProfitSum[i]>=maximumProfit){
    	        	   maximumProfit = ProfitSum[i]; 
    	        	   PurchaseRecord = i; 
    	           }
    	      }
    	      
    	      System.out.print("the number of purchase should be: ");
    	      System.out.println(PurchaseRecord); 
    	      System.out.print("the maximum profit is: ");
    	      System.out.println(maximumProfit);
    	      
       }
}
