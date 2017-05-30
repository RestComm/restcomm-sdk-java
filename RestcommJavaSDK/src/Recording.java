import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Recording")
public class Recording extends Resource{

		String BASE_URL = "https://cloud.restcomm.com/restcomm/2012-04-24/Accounts/"+Credentials.getAuthID()+"/Recordings/";
		
		public Recording getRecording(String sid) throws IOException
		{
			Request request = new Request(BASE_URL+sid);
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			System.out.println(object);
			return object.getRecording();
		}
		public Recording downloadRecording(String sid) throws IOException
		{
			Request request = new Request(BASE_URL+sid+".wav");
			HttpMethod http = new HttpMethod("GET",request);
			Response object = http.execute();
			System.out.println(object);
			return object.getRecording();
		}
		
		
}
