package org.restcomm.connect.java.sdk.rcml;

import org.junit.Assert;
import org.junit.Test;

public class GatherTest {

	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<Response>"
				+ "<Gather action=\"handle-user-input.php\" numDigits=\"1\">"
				+ "<Say>Welcome to TPS.</Say>"
				+ "<Say>For store hours, press 1.</Say>"
				+ "<Say>To check your package status, press 3.</Say>"
				+ "</Gather>"
				+ "<Say>Sorry, I didn't get your response.</Say>"
				+ "<Redirect>handle-incoming-call.xml</Redirect></Response>";
		Response response = new Response()
				.gather(new Gather().action("handle-user-input.php").numDigits(1)
						.say(new Say().text("Welcome to TPS."))
						.say(new Say().text("For store hours, press 1."))
						.say(new Say().text("To check your package status, press 3.")))
				.say(new Say().text("Sorry, I didn't get your response."))
				.redirect(new Redirect().address("handle-incoming-call.xml"))
				.build();
		Assert.assertEquals(xml, response.toXML());
	}
	
}
