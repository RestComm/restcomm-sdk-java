package org.restcomm.connect.java.sdk.rcml;

import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Response><Email from=\"****@gmail.com\" to=\"****@hotmail.com\" cc=\"someone2@localhost.com,test@localhost.com,test3@localhost.com\" subject=\"This is the subject\">This is the body!!</Email></Response>";
		Response response = new Response()
				.email(
					new Email()
					.from("****@gmail.com")
					.to("****@hotmail.com")
					.cc("someone2@localhost.com")
					.cc("test@localhost.com")
					.cc("test3@localhost.com")
					.subject("This is the subject")
					.text("This is the body!!")
				).build();
		Assert.assertEquals(xml, response.toXML());
	}
	
}
