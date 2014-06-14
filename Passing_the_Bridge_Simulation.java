package homework4;

public class Simulation_Problem3 {
       public static void main(String []args){
    	   FootbridgeProblem();
       }
       
       
       public static void FootbridgeProblem(){
    	    final double a = 3; 
    	    final double b = 7; 
    	    final double L = 84; 
    	    final double conversion = 60.0;    
    	    
    	    //since this is a Poisson Process with lambda 3, the interarrival time is Exponential with lambda 0.333
    	    final double lambda = 0.333; 
    	    
    	    Native [] Natives = new Native [10001];   
    	    for (int i = 1; i <=10000; i++){Natives[i]= new Native();}
    	    
    	    for (int i = 1; i <=10000; i++){
    	         double randInter = Math.random(); 
    	         double randServ = Math.random();
    	         Natives[i].ServiceTime = L/(a+(b-a)*randServ);   
    	         
    	         if(i == 1){
    	        	 Natives[i].InterArrivalTime = 0.0;
    	        	 Natives[i].ArrivalTime = 0.0; 
    	        	 Natives[i].ServiceTimeBegin = 0.0; 
    	        	 Natives[i].ServiceTimeEnd = Natives[i].ServiceTime; 
    	        	 Natives[i].TimeWaitInQueue = 0.0; 
    	        	 Natives[i].WaitorNot = false; 
    	        	 Natives[i].TimeSpendInSystem = Natives[i].ServiceTime; 
    	        	 Natives[i].ServiceIdleTime = 0.0;  
    	         }else{
    	             Natives[i].InterArrivalTime = Math.log(randInter)*lambda*(-1.0)*conversion; 
    	             Natives[i].ArrivalTime = Natives[i-1].ArrivalTime + Natives[i].InterArrivalTime; 
    	             Natives[i].ServiceTimeBegin = Math.max(Natives[i].ArrivalTime, Natives[i-1].ServiceTimeEnd);
    	             Natives[i].ServiceTimeEnd = Natives[i].ServiceTimeBegin + Natives[i].ServiceTime; 
    	             Natives[i].TimeWaitInQueue = Natives[i].ServiceTimeBegin - Natives[i].ArrivalTime; 
    	             Natives[i].TimeSpendInSystem = Natives[i].TimeWaitInQueue + Natives[i].ServiceTime; 
    	             Natives[i].ServiceIdleTime = Natives[i].ServiceTimeBegin - Natives[i-1].ServiceTimeEnd; 
    	             if(Natives[i].TimeWaitInQueue>0){Natives[i].WaitorNot = true;}
      		         else{Natives[i].WaitorNot = false;}
    	         }    
    	    }
    	    
    	    double sumServiceTime = 0.0;              
    	    double sumWaitingTime = 0.0; 
    	    double sumSpendinSystem = 0.0; 
    	    for(int i = 1; i <=10000; i++){
    	    	sumServiceTime+= Natives[i].ServiceTime; 
    	    	sumWaitingTime+= Natives[i].TimeWaitInQueue; 
    	    	sumSpendinSystem+= Natives[i].TimeSpendInSystem; 
    	    }
    	    
    	    //question (a)
    	    System.out.print("average time it takes to cross the footbridge: ");
    	    System.out.println(sumServiceTime/10000.0);
    	    //question (c)
    	    System.out.print("long-term average time for a given native will be waiting in line to cross the footbridge: ");
    	    System.out.println(sumWaitingTime/10000.0);
    	    //question (d)
    	    System.out.print("average time for a native to get out of village: ");
    	    System.out.println(sumSpendinSystem/10000.0);
    	    
       }
}
