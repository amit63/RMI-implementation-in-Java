package RemoteCalls;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class AdvisorFile {

	/**
	 * @param args
	 * @throws Exception 
	 */
	


	//Name: Amitesh Mathur ID: 1001563299

	
	// The main method will create the instance of remote object implementation. Then  will be exporting a remote object and then binds that instance to a name a Java RMI registry.
	
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		Registry reg = LocateRegistry.getRegistry("localhost", 2000);
		final MQSInterface mqsi = (MQSInterface) reg.lookup("MQS");
		if(mqsi.isEmpty())			//Condition for when the Queue is Empty
		{
			System.out.println("No request from the student for registering a course have been received yet, try running the class later after sometime");
			
		}
		else
		{	
			//this is a Remote call that displays all the requests received from the student.
			mqsi.depict();		
			//this is a Remote call that generates a random response based on those requests received.
			mqsi.RanResp();	
			//Once the decision is finalized this function will clear the contents of the queue.
			mqsi.remove();			
			
		}
		
	}

}