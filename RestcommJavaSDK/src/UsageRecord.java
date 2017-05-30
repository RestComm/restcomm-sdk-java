import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UsageRecord")
public class UsageRecord extends Resource{
	String BASE_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Usage/Records/";
}
