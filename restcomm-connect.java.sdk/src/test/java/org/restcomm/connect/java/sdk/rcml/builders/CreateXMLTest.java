package org.restcomm.connect.java.sdk.rcml.builders;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.restcomm.connect.java.sdk.rcml.verbs.Response;

public class CreateXMLTest {
	
	@Test
	public void test(){
		try {
			Response response = new ResponseBuilder()
					.say(new SayBuilder().text("seila").voice("woman"))
					.pause(new PauseBuilder().length(10))
					.say(new SayBuilder().text("x").voice("man"))
					.email(new EmailBuilder().bcc("x"))
					.gather(new GatherBuilder().say("Ola").say("seja bem vindo").action("action").finishOnKey("#")) 
					.sms(new SmsBuilder().text("SMS"))
					.redirect(new RedirectBuilder().method("Post"))
					.hangup().build();
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(response, sw);
			System.out.println(sw.toString());
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

}
