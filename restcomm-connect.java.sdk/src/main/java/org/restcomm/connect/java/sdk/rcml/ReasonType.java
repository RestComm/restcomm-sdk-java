package org.restcomm.connect.java.sdk.rcml;

public enum ReasonType {
	
	REJECTED("rejected"), BUSY("busy");
	
	private final String name;
	
	private ReasonType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
