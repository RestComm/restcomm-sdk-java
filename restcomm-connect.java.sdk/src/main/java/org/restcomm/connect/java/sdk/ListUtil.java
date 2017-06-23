package org.restcomm.connect.java.sdk;


public class ListUtil {
	
	protected String previouspageuri;
	protected String uri;
	protected String nextpageuri;
	protected String firstpageuri;
	protected String lastpageuri;
	

	public String geturi()
    {
        return uri;
    }
	private void seturi (String List)
    {
        this.uri = List;
    }
	public String getfirstpageuri()
    {
        return firstpageuri;
    }
	private void setfirstpageuri (String List)
    {
        this.firstpageuri = List;
    }
	public String getnextpageuri()
    {
        return nextpageuri;
    }
	private void setnextpageuri (String List)
    {
        this.nextpageuri = List;
    }
	public String getlastpageuri()
    {
        return lastpageuri;
    }
	private void setlastpageuri (String List)
    {
        this.lastpageuri = List;
    }
    public String getpreviouspageuri()
    {
        return previouspageuri;
    }
    private void setpreviouspageuri (String List)
    {
        this.previouspageuri = List;
    }
    
    
    
    
    
	
}