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
		
		Restcomm.COMMON_URL = "http://localhost:8080/";
		Restcomm.init("AC13b4372c92ed5c07d951cf842e2664ff", "cb0936cfee986d3e3ec6d1d77cc57888");
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
