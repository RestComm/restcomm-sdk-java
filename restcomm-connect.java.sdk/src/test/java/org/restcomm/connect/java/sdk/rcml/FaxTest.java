package org.restcomm.connect.java.sdk.rcml;

import org.junit.Assert;
import org.junit.Test;

public class FaxTest {

	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<Response><Fax>This is a test fax.</Fax></Response>";
		Response response = new Response()
				.fax(new Fax()
						.text("This is a test fax.")
						).build();
		Assert.assertEquals(xml, response.toXML());
	}
	
}
