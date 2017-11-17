package org.restcomm.connect.java.sdk.rcml;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Response><Dial><Client>Alice</Client></Dial></Response>";
		
		Response response = new Response().dial(new Dial().client(new Client().name("Alice"))).build();
		
		System.out.println(response.toXML());
				
				
		
		
	}
	
}
