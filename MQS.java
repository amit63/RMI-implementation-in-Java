package RemoteCalls;


//Name: Amitesh Mathur ID: 1001563299
//Refrred code from: 1)  https://github.com/kgole/RMI/tree/master/src   

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;


//Using this class we create a queue using a linked list 

class MQS extends UnicastRemoteObject implements MQSInterface

{
	//Each remote method declare java.rmi.RemoteException in their throws clauses,in addition to any application-specific exceptions 
	
	
	 public int size;
     protected LinkedList start, ends;

   

 

    public MQS() throws RemoteException

    {

        start = null;
        ends = null;
        size = 0;

    }    
    
    
    
    //Here we create an instance of a remote object implementation.
    public static void main(String[] args) throws RemoteException 

    {
    	MQS mqsi = new MQS();
    	java.rmi.registry.LocateRegistry.createRegistry(2000).rebind("MQS", mqsi);
    	System.out.println("The Message Queueing serVer is now running!!");
    }
    

    //  This function gets the size of the Queue

    public int getSize()

    {
        return size;

    } 
  // This function checks if the Queue is empty 

    public boolean isEmpty()

    {  return start == null;

    }    
   

    //  Here we enter the data into the queue

    public void insertion(String desc) throws IOException 

    {

        LinkedList nodenp = new LinkedList(desc, null);
        File file = new File("WholeQueue.txt");
		FileWriter fw = new FileWriter(file);
        if (ends == null)

        {

            start = nodenp;

            ends = nodenp;

        }

        else

        {

            ends.setLink(nodenp);

            ends = ends.getLink();

        }

        size++ ;

    }    

    //  This Function to remove all elements from the queue.This is only called after the advisor has made the decision and stored in a file that will be used to notify the student 

    public void remove()

    {
    	 do
     	{
    	       LinkedList np = start;

    	       start = np.getLink();        

    	       if (start == null)

    	       ends = null;

    	        size-- ;
    	        
     	}while(start != null);
    	
    	 if (isEmpty())
    	 {
    		 System.out.println("The Requests have been cleared from the MessageQueuingServer");
    	 }

    }    

    //Function to display the requests they received in the Queue to the Advisor 

    public void depict()

    {

        System.out.print("\n Hi Advisor, You have received the following requests :- \n");

        if (size == 0)

        {

            System.out.print("You have not yet received any requests yet\n");

            return ;

        }

        LinkedList np = start;

        while (np != ends.getLink() )

        {

            System.out.print(np.getData()+"/t ");

            np = np.getLink();

        }

        System.out.println();        

    }
    
    
   
    
    /*This method is remotely called by the NotificationProcess class
     * Starts by looking up the file decision.txt that has the admission decision stored
     * Use the buffered reader then to store it in a string named line
     * Print it to the user*/
    
    public void notifier() throws IOException
    { 
    	try{
    		File file = new File("AdvisorAction.txt");
    		BufferedReader br = new BufferedReader(new FileReader("AdvisorAction.txt"));
    	
    	String line = null;
    	   while ((line = br.readLine()) != null) {
    		   System.out.println("\n Hey! the Advisor has deiced the output of his course ");
    		   System.out.println(line);
    	       file.delete();
    	   }
    	}
    	catch(FileNotFoundException e)
    	{
    	}
    }
    
   
    
    /*This Function firstly creates a file named decision.txt
    Then a random string is selected from the list responses[] that has the two decision 
   using the Random() function from java.util
   The decision is then written in the file decision.txt and it is closed*/
  
  public void RanResp() throws IOException
  {
  	char chars;
  	Scanner scan = new Scanner(System.in);
  	System.out.println("Do you want to generate a random response?? If yes please press Y/y If no please press N/n");
  	File f = new File("AdvisorAction.txt");
		FileWriter fileWriter = new FileWriter(f);
  	chars = scan.next().charAt(0);
  	if(chars == 'Y'|| chars == 'y')
  	{
	    	String responses[] = {
	    			"Congratulations, Your courses have been cleared :)",
	    			"Sorry, Your courses cannot be cleared :(",
	    			
	    	};
	    	
	    	Random rndm = new Random();
	    	
	    	String randomString = responses[rndm.nextInt(responses.length)];
	    	System.out.println("The randomly generated decision:- ");
	    	System.out.println(randomString);
	    	fileWriter.write(randomString);
	    	fileWriter.flush();
			fileWriter.close();
	   
	    	
  	}
  }

}