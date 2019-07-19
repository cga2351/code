package twitter4j.internal.http;

import twitter4j.TwitterException;

public abstract interface HttpClient
{
  public abstract HttpResponse request(HttpRequest paramHttpRequest)
    throws TwitterException;

  public abstract void shutdown();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpClient
 * JD-Core Version:    0.6.2
 */