package Default;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Capabilities")
public class Capabilities
{
	@XmlElement(name="Sms")
    private String Sms;
	@XmlElement(name="Voice")
    private String Voice;
	@XmlElement(name="Mms")
    private String Mms;
	@XmlElement(name="Fax")
    private String Fax;

    public String getSms ()
    {
        return Sms;
    }

    public void setSms (String Sms)
    {
        this.Sms = Sms;
    }

    public String getVoice ()
    {
        return Voice;
    }

    public void setVoice (String Voice)
    {
        this.Voice = Voice;
    }

    public String getMms ()
    {
        return Mms;
    }

    public void setMms (String Mms)
    {
        this.Mms = Mms;
    }

    public String getFax ()
    {
        return Fax;
    }

    public void setFax (String Fax)
    {
        this.Fax = Fax;
    }

    
}
			
			