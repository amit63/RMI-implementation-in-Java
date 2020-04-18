package RemoteCalls;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


//Name: Amitesh Mathur ID: 1001563299
//Refrred code from: 1)  https://github.com/kgole/RMI/tree/master/src   


public class NotifierSystem {

	/**
	 * @param args
	 */
	

	
	//The method creates instance of a remote object implementation, exports the remote object and then binds that instance to a name in Java RMI registry.
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Registry reg = LocateRegistry.getRegistry("localhost", 2000);
		final MQSInterface mqsi = (MQSInterface) reg.lookup("MQS");
	
		mqsi.notifier();  //this is a Remote call to the notify service method of  MessageQueuingServer class.
			
		
	}

}
