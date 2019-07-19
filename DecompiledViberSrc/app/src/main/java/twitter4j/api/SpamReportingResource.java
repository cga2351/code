package twitter4j.api;

import twitter4j.TwitterException;
import twitter4j.User;

public abstract interface SpamReportingResource
{
  public abstract User reportSpam(long paramLong)
    throws TwitterException;

  public abstract User reportSpam(String paramString)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.api.SpamReportingResource
 * JD-Core Version:    0.6.2
 */