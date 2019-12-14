
[Try Restcomm Cloud NOW for FREE!](https://www.restcomm.com/sign-up/) Zero download and install required.


All Restcomm [docs](https://www.restcomm.com/docs/) and [downloads](https://www.restcomm.com/downloads/) are now available at [Restcomm.com](https://www.restcomm.com).

### RCML Example of Use

This example assumes you have a Java development environment with a Web server capable of running Java servlets, and the restcomm-sdk-java library.

```java
import org.restcomm.connect.java.sdk.rcml.Response;
import org.restcomm.connect.java.sdk.rcml.Say;
import org.restcomm.connect.java.sdk.rcml.VoiceType;

/**
 * This servlet represent a demo of use the Restcomm Java RCML library.
 * @author Ricardo Limonta
 */
@WebServlet(name = "AgentDemo", urlPatterns = {"/agent"})
public class AgentDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Define a response content type
        response.setContentType("application/xml");
        
        //Create a RCML verb and return our welcome message
        Response rcml = new Response().say(new Say()
                                        .text("Welcome to Restcomm Connect!")
                                        .language("en")
                                        .voice(VoiceType.WOMAN)).build();
        //Process response
        response.getWriter().print(rcml.toXML());
    }
}
```


The result of the servlet execution will be:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Response>
    <Say voice="woman" language="en">Welcome to Restcomm Connect!</Say>
</Response>
```
