package org.restcomm.connect.java.sdk.rcml;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Response><Dial><Client>Alice</Client></Dial></Response>";
		Response response = new Response().dial(new Dial().client(new Client().value("Alice"))).build();
		Assert.assertEquals(xml, response.toXML());
	}
	
}
