package Default;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="IncomingPhoneNumbers")
public class IncomingPhoneNumberList {
	public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/IncomingPhoneNumbers";
	 @XmlElement(name="IncomingPhoneNumbers")
	 private ArrayList<IncomingPhoneNumber> List;
	 public ArrayList<IncomingPhoneNumber> getList ()
	    {
	        return List;
	    }

	    public void setList (ArrayList<IncomingPhoneNumber> List)
	    {
	        this.List= List;
	    
	    }
}
