package twitter4j.internal.http;

import twitter4j.TwitterException;
import twitter4j.auth.Authorization;

public final class HttpResponseEvent
{
  private HttpRequest request;
  private HttpResponse response;
  private TwitterException twitterException;

  HttpResponseEvent(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, TwitterException paramTwitterException)
  {
    this.request = paramHttpRequest;
    this.response = paramHttpResponse;
    this.twitterException = paramTwitterException;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    HttpResponseEvent localHttpResponseEvent;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localHttpResponseEvent = (HttpResponseEvent)paramObject;
      if (this.request != null)
      {
        if (this.request.equals(localHttpResponseEvent.request));
      }
      else
        while (localHttpResponseEvent.request != null)
          return false;
      if (this.response == null)
        break;
    }
    while (this.response.equals(localHttpResponseEvent.response));
    while (true)
    {
      return false;
      if (localHttpResponseEvent.response == null)
        break;
    }
  }

  public HttpRequest getRequest()
  {
    return this.request;
  }

  public HttpResponse getResponse()
  {
    return this.response;
  }

  public TwitterException getTwitterException()
  {
    return this.twitterException;
  }

  public int hashCode()
  {
    if (this.request != null);
    for (int i = this.request.hashCode(); ; i = 0)
    {
      int j = i * 31;
      HttpResponse localHttpResponse = this.response;
      int k = 0;
      if (localHttpResponse != null)
        k = this.response.hashCode();
      return j + k;
    }
  }

  public boolean isAuthenticated()
  {
    return this.request.getAuthorization().isEnabled();
  }

  public String toString()
  {
    return "HttpResponseEvent{request=" + this.request + ", response=" + this.response + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpResponseEvent
 * JD-Core Version:    0.6.2
 */