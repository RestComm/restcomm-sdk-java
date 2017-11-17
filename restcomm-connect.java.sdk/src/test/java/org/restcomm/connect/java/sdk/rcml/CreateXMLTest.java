package org.restcomm.connect.java.sdk.rcml;



import org.junit.Test;

public class CreateXMLTest {
	
	@Test
	public void test(){
		try {
			Response response = new Response()
					.ussdCollect(
							new UssdCollect()
							.ussdMessage(new UssdMessage().text("teste2"))
							.ussdMessage(new UssdMessage().text("teste0")))
					.build();
			System.out.println(response.toXML());
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

}
