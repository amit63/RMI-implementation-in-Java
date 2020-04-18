package RemoteCalls;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



//Name: Amitesh Mathur ID: 1001563299
//Refrred code from: 1)  https://github.com/kgole/RMI/tree/master/src   

// This class is to be run by students when they want to send a request to the advisor to register a course.
public class StudentFile {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*main method here creates the instance of the remote object implementation,
		 exports the remote object, and then binds that instance to a name in a Java RMI registry*/
		
		Registry reg = LocateRegistry.getRegistry("localhost", 2000);
		final MQSInterface mqsi = (MQSInterface) reg.lookup("MQS");
	
		
		// Input taken from the student that is the name and the course he wants to get cleared for registering
		//the name and course are combined and stored in the string called request and then inserted in the Queue from the MessageQueuingServer
		
		char chr;
		String course,name,request;
    	Scanner sc = new Scanner(System.in);
    	
    	char Chrz='c';
		if(Chrz == 'c' || Chrz== 'C' )
		{System.out.println("  .  ");}
		do
		{
			
            System.out.println("Please Enter your name:- \n ");
            name = sc.next();
            System.out.println("Please Enter the course number you want cleared:- ");
            course = sc.next();
        	//Concatenation of two entries
            request = name.concat(course);
           //remote call to the insert method from class MessageQueuingServer 
            mqsi.insertion( request );			
            System.out.println("Data has been sent!");
            
        	
			System.out.println("\n If you wish to add more courses Press Y or Presss N ");
	
	        chr = sc.next().charAt(0);
	        
	       
        
		}while(chr == 'y'|| chr == 'Y');
		
		
		 
		if(chr == 'n' || chr == 'N')
	    {
	        	System.out.println("All the requests by you have been sent to the advisor, check the Notifications for dthe decision \n");	//When the user wishes to stop sending requests
	        	System.exit(0);
	     }
		
		char Chrz1='a';
		if(Chrz1 == 'a' || Chrz== 'A' )
		{System.out.println("  .  ");}
	}

}
