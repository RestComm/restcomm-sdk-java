/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.restcomm.connect.java.sdk.rcml;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ricardo Limonta limonta@hashtech.com.br
 */
public class UssdCollectTest {

    @Test
    public void test() {
        Response response = new Response()
                .ussdCollect(new UssdCollect().action("http://my.controller.net")
                .ussdMessage(new UssdMessage().text("1 for first option"))
                .ussdMessage(new UssdMessage().text("2 for first option"))
                .ussdMessage(new UssdMessage().text("3 for first option"))).build();
        Assert.assertEquals(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Response><UssdCollect action=\"http://my.controller.net\"><UssdMessage>1 for first option</UssdMessage><UssdMessage>2 for first option</UssdMessage><UssdMessage>3 for first option</UssdMessage></UssdCollect></Response>", 
                response.toXML());
    }
}
