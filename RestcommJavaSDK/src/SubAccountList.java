import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Accounts")
public class SubAccountList {
	private static String BASE_URL = Constants.COMMON_URL+"Accounts";
	@XmlElement(name = "Account")
	private ArrayList<SubAccount> List;

	public ArrayList<SubAccount> getList() {
		return List;
	}

	public void setList(ArrayList<SubAccount> list) {
		List = list;
	}
	 public SubAccountList getSubAccountList() throws IOException
	    {
			Request request = new Request(BASE_URL);
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			//System.out.println(object.getSMS().getSMSMessages()[0].getSid());
			return object.getSubAccountList();
		}
	
}
