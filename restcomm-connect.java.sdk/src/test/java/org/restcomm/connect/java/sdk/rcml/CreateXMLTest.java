package org.restcomm.connect.java.sdk.rcml;



import org.junit.Test;

public class CreateXMLTest {
	
	@Test
	public void test(){
		try {
			Response response = new Response().say(new Say().text("oi").voice(VoiceType.man))
			.pause(new Pause().length(10))
			.say(new Say().language("bp").text("teste"))
			.email(new Email().text("ola email"))
			.gather(
					new Gather().language(LanguageType.pt_BR)
					.method(MethodType.GET).say("Ola").say("seja bem vindo")
					.action("action").finishOnKey("#"))
			.sms(new Sms().text("SMS"))
			.redirect(new Redirect().method(MethodType.POST))
			.hangup().build();
			System.out.println(response.toXML());
		} catch (Exception ee) {
			ee.printStackTrace();
		}

	}

}
