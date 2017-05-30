import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OutboundProxy")
public class OutboundProxy {
	public String BASE_URL= "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/OutboundProxy";
	
}
