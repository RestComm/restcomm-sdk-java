# restcomm-sdk-java
The Java SDK for RestComm REST API

- To build the Project, after downloading the zip and extracting it from GitHub, navigate to the folder containing the pom.xml 
file and buiild the project using the following command in the terminal

```sh
$ mvn package
```
- Now when this command is executed, the compilation,validation and testing will be done and after the successful completion of them, a jar file will be generated in the target folder.

- Include the jar file in your build path to get Started.

Java version: 1.8.0_131

This is an SDK for RestComm REST API,
To know more about Restcomm, please refer to http://documentation.telestax.com/

Regarding issues, please refer to https://github.com/RestComm/restcomm-sdk-java/issues 

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
        response.setContentType("application/xm");
        
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
