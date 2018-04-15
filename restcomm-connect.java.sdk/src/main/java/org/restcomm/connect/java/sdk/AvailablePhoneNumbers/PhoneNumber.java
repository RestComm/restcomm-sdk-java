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
package org.restcomm.connect.java.sdk.AvailablePhoneNumbers;

import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.restcomm.connect.java.sdk.Restcomm;
import org.restcomm.connect.java.sdk.Utilities;
import org.restcomm.connect.java.sdk.http.*;

import org.restcomm.connect.java.sdk.Exceptions.*;

public class PhoneNumber{
	
	private String isoCountry;

    private String lata;

    private String friendlyName;

    private String region;

    private String postalCode;

    private String rateCenter;

    private String latitude;

    private String phoneNumber;

    private String longitude;

    private String addressRequirements;
    
    private String mms_capable="false";

    private String fax_capable="false";

    private String sms_capable="false";

    private String voice_capable="false";

    public String getMms_capable ()
    {
        return mms_capable;
    }

    protected void setMms_capable (String mms_capable)
    {
        this.mms_capable = mms_capable;
    }

    public String getFax_capable ()
    {
        return fax_capable;
    }

    protected void setFax_capable (String fax_capable)
    {
        this.fax_capable = fax_capable;
    }

    public String getSms_capable ()
    {
        return sms_capable;
    }

    protected void setSms_capable (String sms_capable)
    {
        this.sms_capable = sms_capable;
    }

    public String getVoice_capable ()
    {
        return voice_capable;
    }

    protected void setVoice_capable (String voice_capable)
    {
        this.voice_capable = voice_capable;
    }    
    public String getPhone_number ()
    {
        return phoneNumber;
    }

    private void setPhone_number (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    
/*    public String getCapabilities ()
    {
        return capabilities;
    }

    private void setCapabilities (String capabilities)
    {
        this.capabilities = capabilities;
    }
 */   
    public String getIsoCountry ()
    {
        return isoCountry;
    }

    private void setIsoCountry (String isoCountry)
    {
        this.isoCountry = isoCountry;
    }
    
    public String getRegion ()
    {
        return region;
    }
    private void setRegion (String region)
    {
        this.region = region;
    }
    
    private void setAddress_requirements (String addressRequirements)
    {
        this.addressRequirements = addressRequirements;
    }
    
    public String getAddress_requirements ()
    {
        return addressRequirements;
    }

    
    public String getPostal_code ()
    {
        return region;
    }

    private void setPostal_code (String region)
    {
        this.postalCode = region;
    }
    
    
    public String getLongitude ()
    {
        return longitude;
    }

    private void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }
    public String getLatitude ()
    {
        return latitude;
    }

    private void setLatitude (String Latitude)
    {
        this.latitude = Latitude;
    }
    
    public String getFriendlyName ()
    {
        return friendlyName;
    }
    private void setFriendlyName (String friendlyName)
    {
        this.friendlyName = friendlyName;
    }
    
    private void setLata (String lata)
    {
        this.lata = lata;
    }
    public String getLata ()
    {
        return lata;
    }

}
