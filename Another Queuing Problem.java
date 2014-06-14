//This class (Problem5) will invoke one helper class (CustomerP5)
package homework1;

public class Problem5 {
       public static void main(String []args){
    	   QueuingProblem(); 
       }
       public static void QueuingProblem (){
    	   
    	   //You can change the input here   
    	   //customer interarrival time   
    	   double a = 2.0; 
    	   double b = 7.0; 
    	   
    	   //task probability 
    	   double pk1 = 0.3; 
    	   double pk2 = 0.5; 
    	   double pk3 = 0.2; 
    	   
    	   //service time 
    	   double ak1 = 1.0; 
    	   double bk1 = 5.0; 
    	   double ak2 = 3.0; 
    	   double bk2 = 7.0; 
    	   double ak3 = 2.0; 
    	   double bk3 = 6.0; 
    	   //You can change the input here 
    	      
    	   //initialization of customers       
    	   CustomerP5 [] customers = new CustomerP5[101];
    	   for(int i = 1; i<=100; i++){customers[i] = new CustomerP5();}
    	   
    	   //simulation 
    	   for(int i = 1; i<=100; i++){
    		   double taskRand = Math.random();
    		   if(taskRand<=pk1) {customers[i].ServiceTimes = ak1+Math.random()*(bk1-ak1);}
    		   else if(taskRand>pk1 && taskRand<=(pk1+pk2)){customers[i].ServiceTimes = ak2+Math.random()*(bk2-ak2);}
    		   else{customers[i].ServiceTimes = ak3+Math.random()*(bk3-ak3);}  
    		   
    		   if(i==1){   
    			   customers[i].InterArrivalTime = 0.0; 
    			   customers[i].ArrivalTimes = 0.0;
    			   customers[i].ServiceTimesBegin = 0.0; 
    			   customers[i].ServiceTimesEnd = customers[i].ServiceTimes;
    			   customers[i].TimeWaitInQueue = 0.0; 
    			   customers[i].WaitOrNot = false; 
    			   customers[i].TimeSpendInSystem = customers[i].ServiceTimes;
    			   customers[i].ServerIdleTime = 0.0; 
    		   }else{  
    		       customers[i].InterArrivalTime = a + Math.random()*(b-a); 
    		       customers[i].ArrivalTimes = customers[i-1].ArrivalTimes+customers[i].InterArrivalTime; 
    		       customers[i].ServiceTimesBegin = Math.max(customers[i].ArrivalTimes, customers[i-1].ServiceTimesEnd);
    		       customers[i].ServiceTimesEnd = customers[i].ServiceTimesBegin + customers[i].ServiceTimes; 
    		       customers[i].TimeWaitInQueue = customers[i].ServiceTimesBegin - customers[i].ArrivalTimes; 
    		       customers[i].TimeSpendInSystem = customers[i].TimeWaitInQueue+customers[i].ServiceTimes; 
    		       customers[i].ServerIdleTime = customers[i].ServiceTimesBegin - customers[i-1].ServiceTimesEnd; 
    		       if(customers[i].TimeWaitInQueue>0){customers[i].WaitOrNot = true;}
    		       else{customers[i].WaitOrNot = false;}
    		   }
    	   }
    	   
    	   //after storage, we start to calculate each problem 
    	   int countWait = 0; 
    	   double sumWaitingTime = 0.0;
    	   double sumSpendInSystem = 0.0; 
    	   double sumIdleTime = 0.0; 
    	   for(int i = 1; i <= 100; i++){
    		   if(customers[i].WaitOrNot) {
    			   countWait++;
    		   }
    		   sumWaitingTime+=customers[i].TimeWaitInQueue; 
    		   sumSpendInSystem += customers[i].TimeSpendInSystem; 
    		   sumIdleTime += customers[i].ServerIdleTime; 
    		   
    	   }
    	   
    	   //Question (a) 
    	   System.out.print("the probability of waiting is: ");
    	   System.out.println(countWait/99.00); 
    	   System.out.print("the average waiting time per customer is: ");
    	   System.out.println(sumWaitingTime/99.00); 
    	   
    	   //Question (b)  
    	   System.out.print("the average waiting time per customer who has to wait: ");
    	   System.out.println(sumWaitingTime/(countWait*1.0)); 
    	   
    	   //Question (c) 
    	   System.out.print("the average time customer spends in a system: ");
    	   System.out.println(sumSpendInSystem/100.00); 
    	   
    	   //Question (d)
    	   System.out.print("fraction of the time the server is idle: ");
    	   System.out.println(sumIdleTime/customers[100].ServiceTimesEnd); 
    	   
       }
}
