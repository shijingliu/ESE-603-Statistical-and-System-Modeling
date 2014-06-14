//this simulation use LinkedListNode class as the helper class   

package homework2;

public class Problem2 {
       public static void main(String[]arg)
       {   
    	   PickTheGoldRing();  
       }
       
       public static void PickTheGoldRing(){ 
              int countGold = 0; 	
              int countThreeHead = 0; 
              
    	      for(int simulation = 0; simulation < 2000; simulation++)
    	      {
	    	      //store four silver rings and one gold ring into a LinkedList in a random order  
	    	      int GoldNumber = (int) (Math.random()*5.0);
	    	      LinkedListNode head = new LinkedListNode ("silver"); 
	    	      if(GoldNumber == 0){
	    	    	  head.Data = "gold";
	    	    	  for(int i = 1; i<5; i++){
	    	    		  head.AppendToTail("silver");
	    	    	  }
	    	      }else{
	    	    	  for(int i = 1; i<GoldNumber; i++){
	    	    		  head.AppendToTail("silver");
	    	    	  }
	    	    	  head.AppendToTail("gold");  
	    	    	  for(int i = GoldNumber+1; i<5; i++){
	    	    		  head.AppendToTail("silver");
	    	    	  }
	    	      }
	    	   
	    	      //Now we try to obtain the number of rings to pick          
	    	      int countHead = 0; 
	    	      for(int coin = 0; coin<3; coin++){
	    	    	 double rand = Math.random(); 
	    	    	 if(rand>=0.5){countHead++;}
	    	      }
	    	      
	    	      //now we pick a random ring            
	    	      for(int pick = 0; pick <countHead; pick++){
	    	    	  int getNumber = (int) (Math.random()*(5-pick)*1.0); 
	    	    	  int index = 0; 
	    	    	  
	    	    	  //declare a new pointer   
	    	    	  LinkedListNode current = head;    
	    	    	  
	    	    	  //now we pick up a random ring        
	    	    	  while ((index < getNumber) && (current != null)){
	    	    		    index++; 
	    	    		    current = current.next; 
	    	    	  }  
	    	          
	    	    	  //if this ring is gold ring, we count it for once.    
	    	    	  if(current.Data == "gold")
	    	    	  {   
	    	    		  countGold++; 
	    	    		  
	    	    		  //if a gold ring in hand, compute the probability that three heads appeared 
	    	    		  if(countHead == 3){
	    	    			  countThreeHead++; 
	    	    		  }
	    	    	  }
	    	    	  
	    	    	  //since there is no replacement, we delete this node    
	    	          head.deleteNode(head, (index+1)); 
	    	      } 
    	      }
    	      System.out.print("the probability of picking up the gold ring is: ");
    	      System.out.println((countGold*1.0)/2000.0);    
    	      System.out.print("the probability that three heads appear is: ");
    	      System.out.println((countThreeHead*1.0)/(countGold*1.0));
       }
}
