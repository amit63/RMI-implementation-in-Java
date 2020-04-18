package RemoteCalls;


//Name: Amitesh Mathur ID: 1001563299
//Refrred code from: 1)  https://github.com/kgole/RMI/tree/master/src   

public class LinkedList {

	/*This class specifically defines the nodes that will compose the linked lists
	 * and their own methods*/

	

	    protected String desc;

	    protected LinkedList nd;

	 

	    /*  Constructor  */

	    public LinkedList()

	    {

	        nd = null;

	        desc = null;

	    }    

	    /*  Constructor  */

	    public LinkedList(String d,LinkedList n)

	    {

	        desc = d;

	        nd = n;

	    }    

	    /*  Function to set link to next Node  */

	    public void setLink(LinkedList n)

	    {

	        nd = n;

	    }    

	    /*  Function to set data to current Node  */

	    public void setData(String d)

	    {

	        desc = d;

	    }    

	    /*  Function to get link to next node  */

	    public LinkedList getLink()

	    {

	        return nd;

	    }    

	    /*  Function to get data from current Node  */

	    public String getData()

	    {

	        return desc;

	    }

	}

