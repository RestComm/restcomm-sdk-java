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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Kleber Damasco kleber.damasco@hashtech.com.br
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Notification implements GenericBuilder<Notification> {

	@XmlAttribute
	private String deviceIdentifier;

	@XmlAttribute
	private String eventGeofencingLatitude;

	@XmlAttribute
	private String eventGeofencingLongitude;

	@XmlAttribute
	private Integer geofenceRange;

	@XmlAttribute
	private String geofenceEvent;

	@XmlAttribute
	private String method;
	
	@XmlAttribute
	private String action;

	public Notification deviceIdentifier(String deviceIdentifier) {
		this.deviceIdentifier = deviceIdentifier;
		return this;
	}
	public Notification eventGeofencingLatitude(String eventGeofencingLatitude) {
		this.eventGeofencingLatitude = eventGeofencingLatitude;
		return this;
	}
	public Notification eventGeofencingLongitude(String eventGeofencingLongitude) {
		this.eventGeofencingLongitude = eventGeofencingLongitude;
		return this;
	}
	public Notification geofenceRange(Integer geofenceRange) {
		this.geofenceRange = geofenceRange;
		return this;
	}
	public Notification geofenceEvent(GeofenceEventType geofenceEvent) {
		this.geofenceEvent = geofenceEvent.getName();
		return this;
	}
	public Notification method(MethodType method) {
		this.method = method.name();
		return this;
	}
	public Notification action(String action) {
		this.action = action;
		return this;
	}
	public Notification build() {
		return this;
	}
	@Override
	public String toString() {
		return "Notification [deviceIdentifier=" + deviceIdentifier + ", eventGeofencingLatitude="
				+ eventGeofencingLatitude + ", eventGeofencingLongitude=" + eventGeofencingLongitude
				+ ", geofenceRange=" + geofenceRange + ", geofenceEvent=" + geofenceEvent + ", method=" + method
				+ ", action=" + action + "]";
	}
}
