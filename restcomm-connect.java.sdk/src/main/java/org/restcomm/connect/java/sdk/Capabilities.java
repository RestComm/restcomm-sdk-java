package org.restcomm.connect.java.sdk;

public class Capabilities
{
    protected String mms_capable;

    protected String fax_capable;

    protected String sms_capable;

    protected String voice_capable;

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
}