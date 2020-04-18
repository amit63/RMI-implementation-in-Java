package RemoteCalls;
import java.rmi.Remote;
import java.rmi.RemoteException;


//Name: Amitesh Mathur ID: 1001563299
//Refrred code from: 1)  https://github.com/kgole/RMI/tree/master/src   

//Refrred code from: 1)  https://github.com/kgole/RMI/tree/master/src   


// This remote interface extends the interface java.rmi.Remote and declares a set of remote methods. 
 // Each remote method must declare java.rmi.RemoteException (or a superclass of RemoteException) in its throws clause, 
 //in addition to any application-specific exceptions
public interface MQSInterface extends Remote{
	public void insertion(String data) throws Exception;
	public void depict() throws Exception;
	public boolean isEmpty() throws Exception;
	public void RanResp() throws Exception;
	public void notifier() throws Exception;
	public void remove() throws Exception;
}