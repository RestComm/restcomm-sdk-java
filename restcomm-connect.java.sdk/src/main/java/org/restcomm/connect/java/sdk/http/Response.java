package org.restcomm.connect.java.sdk.http;
import org.restcomm.connect.java.sdk.*;

import org.restcomm.connect.java.sdk.Accounts.Account;
import org.restcomm.connect.java.sdk.Accounts.SubAccountList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*import org.restcomm.connect.java.sdk.Gateway;
import org.restcomm.connect.java.sdk.GatewayList;
import org.restcomm.connect.java.sdk.IncomingPhoneNumber;
import org.restcomm.connect.java.sdk.IncomingPhoneNumberList;
import org.restcomm.connect.java.sdk.Notification;
import org.restcomm.connect.java.sdk.NotificationList;
import org.restcomm.connect.java.sdk.Recording;
import org.restcomm.connect.java.sdk.RecordingList;
import org.restcomm.connect.java.sdk.SMSMessage;
import org.restcomm.connect.java.sdk.SMSMessageList;
import org.restcomm.connect.java.sdk.UsageRecordList;*/
import org.restcomm.connect.java.sdk.Accounts.Account;
import org.restcomm.connect.java.sdk.Accounts.SubAccountList;
import org.restcomm.connect.java.sdk.Applications.Application;
import org.restcomm.connect.java.sdk.Applications.ApplicationList;
import org.restcomm.connect.java.sdk.Calls.Call;
import org.restcomm.connect.java.sdk.Calls.CallList;
import org.restcomm.connect.java.sdk.Clients.Client;
import org.restcomm.connect.java.sdk.Clients.ClientList;
import org.restcomm.connect.java.sdk.EmailMessages.EmailMessage;

import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="RestcommResponse")
@XmlAccessorType(XmlAccessType.FIELD)

public class Response {
	
	 private int HttpStatusCode;
	 
	 @XmlElement(name="Account")
	 private Account Account;
	  
	 @XmlElement(name="Accounts")
	 private SubAccountList SubAccountList;
	
	 @XmlElement(name="Application")
	 private Application Application;
	 
	 //@XmlElement(name="UsageRecords")
	 //private UsageRecordList UsageRecordList;
	
	 @XmlElement(name="Applications")
	 private ApplicationList ApplicationList;
	
	 /*@XmlElement(name="SMSMessage")
	 private SMSMessage SMSMessage;
	 
	 @XmlElement(name="SMSMessages")
	 private SMSMessageList SMS;*/
	
	 @XmlElement(name="Call")
	 private Call Call;
	 
	 @XmlElement(name="Calls")
	 private CallList CallList;
	 
	 /*@XmlElement(name="Gateway")
	 private Gateway Gateway;
	 
	 @XmlElement(name="Gateways")
	 private GatewayList GatewayList;
	 
	 @XmlElement(name="Notification")
	 private Notification Notification;
	 
	 @XmlElement(name="Notifications")
	 private NotificationList NotificationList;
	 
	 @XmlElement(name="Recordings")
	 private RecordingList RecordingList;
	 
	 @XmlElement(name="Recording")
	 private Recording Recording;
	 */
	 @XmlElement(name="EmailMessage")
	 private EmailMessage EmailMessage;
	 
	 	@XmlElement(name = "Client")
		private Client Client;
	 
	 	@XmlElement(name = "Clients")
		private ClientList Clients;
	 	/*@XmlElement(name = "IncomingPhoneNumber")
	 	private IncomingPhoneNumber IncomingPhoneNumber;
	 	
	 	@XmlElement(name = "IncomingPhoneNumbers")
	 	private IncomingPhoneNumberList IncomingPhoneNumberList;
	 	
	 	 public Notification getNotification ()
	     {
	         return Notification;
	     }

	     public void setNotification (Notification Notification)
	     {
	         this.Notification = Notification;
	     }

	     public NotificationList getNotificationList ()
	     {
	         return NotificationList;
	     }

	     public void setNotificationList (NotificationList NotificationList)
	     {
	         this.NotificationList= NotificationList;
	     }

	 	
	    public IncomingPhoneNumber getIncomingPhoneNumber ()
	    {
	        return IncomingPhoneNumber;
	    }

	    public void setIncomingPhoneNumber (IncomingPhoneNumber IncomingPhoneNumber)
	    {
	        this.IncomingPhoneNumber = IncomingPhoneNumber;
	    }
	    public IncomingPhoneNumberList getIncomingPhoneNumberList ()
	    {
	        return IncomingPhoneNumberList;
	    }

	    public void setIncomingPhoneNumberList (IncomingPhoneNumberList IncomingPhoneNumberList)
	    {
	        this.IncomingPhoneNumberList = IncomingPhoneNumberList;
	    }
	 	public Gateway getGateway ()
	    {
	        return Gateway;
	    }

	    public void setGateway (Gateway Gateway)
	    {
	        this.Gateway = Gateway;
	    }
	    public GatewayList getGatewayList ()
	    {
	    	return GatewayList;
	    }
		public void setGatewayList (GatewayList GatewayList)
		{
		   this.GatewayList = GatewayList;
		}*/
	    public ClientList getClientList ()
	    {
	        return Clients;
	    }

	    public void setClientList (ClientList Clients)
	    {
	        this.Clients = Clients;
	    }

	    public Client getClient ()
	    {
	        return Client;
	    }

	    public void setClient (Client Clients)
	    {
	        this.Client = Clients;
	    }
	    public EmailMessage getEmailMessage ()
	    {
	        return EmailMessage;
	    }

	    public void setEmailMessage (EmailMessage EmailMessage)
	    {
	        this.EmailMessage = EmailMessage;
	    }

	
	 public Call getCall ()
		{
		   return Call;
		}

		public void setCall (Call Call)
		{
		   this.Call = Call;
		}
	public CallList getCallList ()
	{
	   return CallList;
	}

	public void setCallList (CallList Calls)
	{
	   this.CallList = Calls;
	}
	public Account getAccount()
	{
		return Account;
	}
	public void setAccount(Account a)
	{
		this.Account=a;
	}
	
	public Application getApplication() {
		return Application;
	}
	public void setApplication(Application application) {
		Application = application;
	}
	public ApplicationList getApplicationList() {
		return ApplicationList;
	}
	public void setApplicationList(ApplicationList applicationList) {
		ApplicationList = applicationList;
	}/*
	public SMSMessage getSMSMessage() {
		return SMSMessage;
	}
	public void setSMSMessage(SMSMessage smsMessage) {
		SMSMessage = smsMessage;
	}
	public SMSMessageList getSMS() {
		// TODO Auto-generated method stub
		return SMS;
	}
	public void setSMS(SMSMessageList smsMessageList) {
		// TODO Auto-generated method stub
		this.SMS=smsMessageList;
	}

	public Recording getRecording() {
		return Recording;
	}

	public void setRecording(Recording recording) {
		Recording = recording;
	}

	public RecordingList getRecordingList() {
		return RecordingList;
	}

	public void setRecordingList(RecordingList recordingList) {
		RecordingList = recordingList;
	}

	public UsageRecordList getUsageRecordList() {
		// TODO Auto-generated method stub
		return UsageRecordList;
	}
	public void setUsageRecordList(UsageRecordList UsageRecordList) {
		this.UsageRecordList = UsageRecordList;
	}

	public int getHttpStatusCode() {
		return HttpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		HttpStatusCode = httpStatusCode;
	}
	*/
	public SubAccountList getSubAccountList() {
		return SubAccountList;
	}

	public void setSubAccountList(SubAccountList subAccountList) {
		SubAccountList = subAccountList;
	}
}
