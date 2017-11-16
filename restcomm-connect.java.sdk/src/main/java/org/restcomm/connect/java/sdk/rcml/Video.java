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
public class Video implements GenericBuilder<Video> {

	@XmlAttribute
	private Boolean enable;
	
	@XmlAttribute
	private String mode;

	@XmlAttribute
	private String resolution;
	
	@XmlAttribute
	private String layout;

	@XmlAttribute
	private String overlay;
	
	public Video enable(Boolean enable) {
		this.enable = enable;
		return this;
	}
	public Video mode(String mode) {
		this.mode = mode;
		return this;
	}
	public Video resolution(ResolutionType resolution) {
		this.resolution = resolution.getName();
		return this;
	}
	public Video resolution(LayoutType layout) {
		this.layout = layout.name();
		return this;
	}
	public Video overlay(String overlay) {
		this.overlay = overlay;
		return this;
	}
	
	public Video build() {
		return this;
	}
	@Override
	public String toString() {
		return "Video [enable=" + enable + ", mode=" + mode + ", resolution=" + resolution + ", layout=" + layout
				+ ", overlay=" + overlay + "]";
	}
	
}
