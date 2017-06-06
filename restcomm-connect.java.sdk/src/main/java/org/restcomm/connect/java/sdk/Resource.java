package org.restcomm.connect.java.sdk;
import javax.xml.bind.annotation.XmlElement;

public class Resource {
	public String BASE_URL;
	
	@XmlElement(name="Lata")
	private String Lata;
	@XmlElement(name="RateCenter")
	private String RateCenter;
	@XmlElement(name="Latitude")
	private String Latitude;
	@XmlElement(name="Longitude")
	private String Longitude;
	@XmlElement(name="Region")
	private String Region;
	@XmlElement(name="PostalCode")
	private String PostalCode;
	@XmlElement(name="IsoCountry")
	private String IsoCountry;
	
	
	
	@XmlElement(name="VoiceCallerIdLookup")
	private String HasVoiceCallerIdLookup;
	@XmlElement(name="RcmlUrl")
	private String RcmlUrl;
	@XmlElement(name="Kind")
	private String Kind;
	@XmlElement(name="CountUnit")
	private String CountUnit;
	@XmlElement(name="Category")
	private String Category;
	@XmlElement(name="Description")
	private String Description;	
	@XmlElement(name="EndDate")
	private String EndDate;
	@XmlElement(name="Count")
	private String Count;
	@XmlElement(name="StartDate")
	private String StartDate;
	@XmlElement(name="UsageUnit")
	private String UsageUnit;
	@XmlElement(name="Usage")
	private String Usage;  
	@XmlElement(name="EmailAddress")
	private String EmailAddress;
	@XmlElement(name="AuthToken")
	private String AuthToken;
	@XmlElement(name="Role")
	private String Role;
	@XmlElement(name="RequestMethod")
    private String RequestMethod;
    @XmlElement(name="RequestVariables")
    private String RequestVariables;
    @XmlElement(name="RequestUrl")
    private String RequestUrl;
    @XmlElement(name="MoreInfo")
    private String MoreInfo;
    @XmlElement(name="MessageDate")
    private String MessageDate;
    @XmlElement(name="ResponseBody")
    private String ResponseBody;
    @XmlElement(name="Log")
    private String Log;
    @XmlElement(name="ErrorCode")
    private String ErrorCode;
    @XmlElement(name="ResponseHeaders")
    private String ResponseHeaders;
    @XmlElement(name="MessageText")
    private String MessageText;
    
    
	@XmlElement(name="UssdFallbackMethod")
    private String UssdFallbackMethod;
	@XmlElement(name="PhoneNumber")
    private String PhoneNumber;
	@XmlElement(name="VoiceApplicationSid")
    private String VoiceApplicationSid;
	@XmlElement(name="UssdMethod")
    private String UssdMethod;
	@XmlElement(name="ReferMethod")
    private String ReferMethod;
	@XmlElement(name="VoiceApplicationName")
    private String VoiceApplicationName;
	@XmlElement(name="SmsFallbackMethod")
    private String SmsFallbackMethod;

	@XmlElement(name="VoiceCallerIdLookUp")
    private String VoiceCallerIdLookup;
	@XmlElement(name="StatusCallbackMethod")
    private String StatusCallbackMethod;

    //private Capabilities Capabilities;
    @XmlElement(name="SmsMethod")
    private String SmsMethod;

	@XmlElement(name = "Login")
    private String Login;

    @XmlElement(name = "VoiceMethod")
    private String VoiceMethod;

    @XmlElement(name = "VoiceFallbackMethod")
    private String VoiceFallbackMethod;

    @XmlElement(name = "Password")
    private String Password;
    @XmlElement(name = "UserName")
    private String UserName;
    @XmlElement(name = "Proxy")
    private String Proxy;
    @XmlElement(name = "Register")
    private String Register;
    @XmlElement(name = "TTL")
    private String TTL;
    
    
	@XmlElement(name = "Body")
	    private String Body;
	    @XmlElement(name = "DateSent")
	    private String DateSent;
	    @XmlElement(name = "Subject")
	    private String Subject;
	@XmlElement(name = "Sid")
	private String Sid;
	@XmlElement(name="DateCreated")
	private String DateCreated;
	@XmlElement(name="DateUpdated")
	private String DateUpdated;
	@XmlElement(name="FriendlyName")
	private String FriendlyName;
	@XmlElement(name="AccountSid")
	private String AccountSid;
	@XmlElement(name="ApiVersion")
	private String ApiVersion;
	@XmlElement(name = "AnsweredBy")
	private String AnsweredBy;
	@XmlElement(name = "CallerName")
    private String CallerName;
	@XmlElement(name = "InstanceId")
    private String InstanceId;
	@XmlElement(name = "From")
    private String From;
	@XmlElement(name = "To")
    private String To;
	@XmlElement(name = "ParentCallSid")
    private String ParentCallSid;
	@XmlElement(name = "PriceUnit")
    private String PriceUnit;
	@XmlElement(name = "Direction")
    private String Direction;
	@XmlElement(name = "Status")
    private String Status;
	@XmlElement(name = "ForwardedFrom")
    private String ForwardedFrom;
	@XmlElement(name = "Ring__duration")
    private String Ring__duration;
	@XmlElement(name = "Duration")
    private String Duration;
	@XmlElement(name = "Price")
    private String Price;
	@XmlElement(name = "Uri")
    private String Uri;
	@XmlElement(name = "EndTime")
    private String EndTime;
	@XmlElement(name = "StartTime")
    private String StartTime;
	@XmlElement(name = "PhoneNumberSid")
	private String PhoneNumberSid;

    public String getLata ()
    {
        return Lata;
    }

    public void setLata (String CountUnit)
    {
        this.Lata = CountUnit;
    }

    public String getCountUnit ()
    {
        return CountUnit;
    }

    public void setCountUnit (String CountUnit)
    {
        this.CountUnit = CountUnit;
    }

    public String getCategory ()
    {
        return Category;
    }

    public void setCategory (String Category)
    {
        this.Category = Category;
    }

    public String getDescription ()
    {
        return Description;
    }

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getEndDate ()
    {
        return EndDate;
    }

    public void setEndDate (String EndDate)
    {
        this.EndDate = EndDate;
    }

    public String getCount ()
    {
        return Count;
    }

    public void setCount (String Count)
    {
        this.Count = Count;
    }

    public String getStartDate ()
    {
        return StartDate;
    }

    public void setStartDate (String StartDate)
    {
        this.StartDate = StartDate;
    }

    public String getUsageUnit ()
    {
        return UsageUnit;
    }

    public void setUsageUnit (String UsageUnit)
    {
        this.UsageUnit = UsageUnit;
    }

    public String getUsage ()
    {
        return Usage;
    }

    public void setUsage (String Usage)
    {
        this.Usage = Usage;
    }

    public String getRequestMethod ()
    {
        return RequestMethod;
    }

    public void setRequestMethod (String RequestMethod)
    {
        this.RequestMethod = RequestMethod;
    }

    public String getRequestVariables ()
    {
        return RequestVariables;
    }

    public void setRequestVariables (String RequestVariables)
    {
        this.RequestVariables = RequestVariables;
    }

    public String getRequestUrl ()
    {
        return RequestUrl;
    }

    public void setRequestUrl (String RequestUrl)
    {
        this.RequestUrl = RequestUrl;
    }

    public String getMoreInfo ()
    {
        return MoreInfo;
    }

    public void setMoreInfo (String MoreInfo)
    {
        this.MoreInfo = MoreInfo;
    }

    public String getMessageDate ()
    {
        return MessageDate;
    }

    public void setMessageDate (String MessageDate)
    {
        this.MessageDate = MessageDate;
    }

    public String getResponseBody ()
    {
        return ResponseBody;
    }

    public void setResponseBody (String ResponseBody)
    {
        this.ResponseBody = ResponseBody;
    }

    public String getLog ()
    {
        return Log;
    }

    public void setLog (String Log)
    {
        this.Log = Log;
    }


    public String getErrorCode ()
    {
        return ErrorCode;
    }

    public void setErrorCode (String ErrorCode)
    {
        this.ErrorCode = ErrorCode;
    }

    public String getResponseHeaders ()
    {
        return ResponseHeaders;
    }

    public void setResponseHeaders (String ResponseHeaders)
    {
        this.ResponseHeaders = ResponseHeaders;
    }

    public String getMessageText ()
    {
        return MessageText;
    }

    public void setMessageText (String MessageText)
    {
        this.MessageText = MessageText;
    }
    public String getUssdFallbackMethod ()
    {
        return UssdFallbackMethod;
    }

    public void setUssdFallbackMethod (String UssdFallbackMethod)
    {
        this.UssdFallbackMethod = UssdFallbackMethod;
    }


    public String getPhoneNumber ()
    {
        return PhoneNumber;
    }

    public void setPhoneNumber (String PhoneNumber)
    {
        this.PhoneNumber = PhoneNumber;
    }

    public String getVoiceApplicationSid ()
    {
        return VoiceApplicationSid;
    }

    public void setVoiceApplicationSid (String VoiceApplicationSid)
    {
        this.VoiceApplicationSid = VoiceApplicationSid;
    }

    public String getUssdMethod ()
    {
        return UssdMethod;
    }

    public void setUssdMethod (String UssdMethod)
    {
        this.UssdMethod = UssdMethod;
    }

    public String getReferMethod ()
    {
        return ReferMethod;
    }

    public void setReferMethod (String ReferMethod)
    {
        this.ReferMethod = ReferMethod;
    }

    public String getVoiceApplicationName ()
    {
        return VoiceApplicationName;
    }

    public void setVoiceApplicationName (String VoiceApplicationName)
    {
        this.VoiceApplicationName = VoiceApplicationName;
    }

    public String getSmsFallbackMethod ()
    {
        return SmsFallbackMethod;
    }

    public void setSmsFallbackMethod (String SmsFallbackMethod)
    {
        this.SmsFallbackMethod = SmsFallbackMethod;
    }

    public String getVoiceCallerIdLookup ()
    {
        return VoiceCallerIdLookup;
    }

    public void setVoiceCallerIdLookup (String VoiceCallerIdLookup)
    {
        this.VoiceCallerIdLookup = VoiceCallerIdLookup;
    }

    public String getStatusCallbackMethod ()
    {
        return StatusCallbackMethod;
    }

    public void setStatusCallbackMethod (String StatusCallbackMethod)
    {
        this.StatusCallbackMethod = StatusCallbackMethod;
    }

    /*public Capabilities getCapabilities ()
    {
        return Capabilities;
    }

    public void setCapabilities (Capabilities Capabilities)
    {
        this.Capabilities = Capabilities;
    }*/

    public String getSmsMethod ()
    {
        return SmsMethod;
    }

    public void setSmsMethod (String SmsMethod)
    {
        this.SmsMethod = SmsMethod;
    }
	public String getPassword ()
    {
        return Password;
    }

    public void setPassword (String Password)
    {
        this.Password = Password;
    }
	public String getVoiceMethod ()
    {
        return VoiceMethod;
    }

    public void setVoiceMethod (String VoiceMethod)
    {
        this.VoiceMethod = VoiceMethod;
    }
	public String getVoiceFallbackMethod ()
    {
        return VoiceFallbackMethod;
    }

    public void setVoiceFallbackMethod (String VoiceFallbackMethod)
    {
        this.VoiceFallbackMethod = VoiceFallbackMethod;
    }
	public String getLogin ()
    {
        return Login;
    }

    public void setLogin (String Login)
    {
        this.Login = Login;
    }
	public String getApiVersion() {
		return ApiVersion;
	}
	public void setApiVersion(String apiVersion) {
		ApiVersion = apiVersion;
	}
	public String getSid() {
		return Sid;
	}
	public void setSid(String sid) {
		Sid = sid;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public String getAccountSid() {
		return AccountSid;
	}
	public void setAccountSid(String accountSid) {
		AccountSid = accountSid;
	}
	
    public String getAnsweredBy ()
    {
        return AnsweredBy;
    }

    public void setAnsweredBy (String AnsweredBy)
    {
        this.AnsweredBy = AnsweredBy;
    }

    public String getCallerName ()
    {
        return CallerName;
    }

    public void setCallerName (String CallerName)
    {
        this.CallerName = CallerName;
    }

    public String getInstanceId ()
    {
        return InstanceId;
    }

    public void setInstanceId (String InstanceId)
    {
        this.InstanceId = InstanceId;
    }

    public String getTo ()
    {
        return To;
    }

    public void setTo (String To)
    {
        this.To = To;
    }


    public String getParentCallSid ()
    {
        return ParentCallSid;
    }

    public void setParentCallSid (String ParentCallSid)
    {
        this.ParentCallSid = ParentCallSid;
    }

    public String getPriceUnit ()
    {
        return PriceUnit;
    }

    public void setPriceUnit (String PriceUnit)
    {
        this.PriceUnit = PriceUnit;
    }

    public String getDirection ()
    {
        return Direction;
    }

    public void setDirection (String Direction)
    {
        this.Direction = Direction;
    }


    public String getStatus ()
    {
        return Status;
    }

    public void setStatus (String Status)
    {
        this.Status = Status;
    }

    public String getForwardedFrom ()
    {
        return ForwardedFrom;
    }

    public void setForwardedFrom (String ForwardedFrom)
    {
        this.ForwardedFrom = ForwardedFrom;
    }

    public String getRing__duration ()
    {
        return Ring__duration;
    }

    public void setRing__duration (String Ring__duration)
    {
        this.Ring__duration = Ring__duration;
    }

    public String getDuration ()
    {
        return Duration;
    }

    public void setDuration (String Duration)
    {
        this.Duration = Duration;
    }

    public String getPrice ()
    {
        return Price;
    }

    public void setPrice (String Price)
    {
        this.Price = Price;
    }

    public String getUri ()
    {
        return Uri;
    }

    public void setUri (String Uri)
    {
        this.Uri = Uri;
    }



    public String getEndTime ()
    {
        return EndTime;
    }

    public void setEndTime (String EndTime)
    {
        this.EndTime = EndTime;
    }

    public String getStartTime ()
    {
        return StartTime;
    }

    public void setStartTime (String StartTime)
    {
        this.StartTime = StartTime;
    }

    public String getPhoneNumberSid ()
    {
        return PhoneNumberSid;
    }

    public void setPhoneNumberSid (String PhoneNumberSid)
    {
        this.PhoneNumberSid = PhoneNumberSid;
    }

    public String getFrom ()
    {
        return From;
    }

    public void setFrom (String From)
    {
        this.From = From;
    }
    public String getBody ()
    {
        return Body;
    }

    public void setBody (String Body)
    {
        this.Body = Body;
    }

    public String getDateSent ()
    {
        return DateSent;
    }

    public void setDateSent (String DateSent)
    {
        this.DateSent = DateSent;
    }
    
	
	public String getHasVoiceCallerIdLookup() {
		return HasVoiceCallerIdLookup;
	}
	public void setHasVoiceCallerIdLookup(String hasVoiceCallerIdLookup) {
		HasVoiceCallerIdLookup = hasVoiceCallerIdLookup;
	}
	
	public String getRcmlUrl() {
		return RcmlUrl;
	}
	public void setRcmlUrl(String rcmlUrl) {
		RcmlUrl = rcmlUrl;
	}
	public String getKind() {
		return Kind;
	}
	public void setKind(String kind) {
		Kind = kind;
	}


    public String getSubject ()
    {
        return Subject;
    }

    public void setSubject (String Subject)
    {
        this.Subject = Subject;
    }

	public String getFriendlyName() {
		return FriendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		FriendlyName = friendlyName;
	}

	public String getEmailAddress()
	{
		return EmailAddress;
	}
	public void setEmailAddress(String a)
	{
		this.EmailAddress=a;
	}
	
	public String getAuthToken()
	{
		return AuthToken;
	}
	public void setAuthToken(String a)
	{
		this.AuthToken=a;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}

	public String getRateCenter() {
		return RateCenter;
	}

	public void setRateCenter(String rateCenter) {
		RateCenter = rateCenter;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getIsoCountry() {
		return IsoCountry;
	}

	public void setIsoCountry(String isoCountry) {
		IsoCountry = isoCountry;
	}
	

}
