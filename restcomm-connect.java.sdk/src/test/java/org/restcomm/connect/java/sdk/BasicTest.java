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
package org.restcomm.connect.java.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;


import org.restcomm.connect.java.sdk.Restcomm;

public class BasicTest {

	@BeforeClass
    public static void runOnceBeforeClass() {
		
		Restcomm.setCommonUrl("http://localhost:8080/");
		Restcomm.init("AC13b4372c92ed5c07d951cf842e2664ff", "7bec2769d3b48e9132e596b60a558d65");
		//System.out.println("@BeforeClass - runOnceBeforeClass");
    }
	@AfterClass
    public static void runOnceAfterClass() {
        
		Restcomm.invalidate();
		//System.out.println("@AfterClass - runOnceAfterClass");
    
	}
	protected String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
}
/*curl GET -X AC13b4372c92ed5c07d951cf842e2664ff:7bec2769d3b48e9132e596b60a558d65@cloud.restcomm.com/restcomm/2012-04-24/Accounts/AC13b4372c92ed5c07d951cf842e2664ff/Notifications.json
*/