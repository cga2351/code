package twitter4j.internal.http;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import twitter4j.auth.Authorization;

public final class HttpRequest
  implements Serializable
{
  private static final HttpParameter[] NULL_PARAMETERS = new HttpParameter[0];
  private static final long serialVersionUID = -3463594029098858381L;
  private final Authorization authorization;
  private final RequestMethod method;
  private final HttpParameter[] parameters;
  private Map<String, String> requestHeaders;
  private final String url;

  public HttpRequest(RequestMethod paramRequestMethod, String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, Map<String, String> paramMap)
  {
    this.method = paramRequestMethod;
    if ((paramRequestMethod != RequestMethod.POST) && (paramArrayOfHttpParameter != null) && (paramArrayOfHttpParameter.length != 0))
      this.url = (paramString + "?" + HttpParameter.encodeParameters(paramArrayOfHttpParameter));
    for (this.parameters = NULL_PARAMETERS; ; this.parameters = paramArrayOfHttpParameter)
    {
      this.authorization = paramAuthorization;
      this.requestHeaders = paramMap;
      return;
      this.url = paramString;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    HttpRequest localHttpRequest;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localHttpRequest = (HttpRequest)paramObject;
      if (this.authorization != null)
      {
        if (this.authorization.equals(localHttpRequest.authorization));
      }
      else
        while (localHttpRequest.authorization != null)
          return false;
      if (!Arrays.equals(this.parameters, localHttpRequest.parameters))
        return false;
      if (this.requestHeaders != null)
      {
        if (this.requestHeaders.equals(localHttpRequest.requestHeaders));
      }
      else
        while (localHttpRequest.requestHeaders != null)
          return false;
      if (this.method != null)
      {
        if (this.method.equals(localHttpRequest.method));
      }
      else
        while (localHttpRequest.method != null)
          return false;
      if (this.url == null)
        break;
    }
    while (this.url.equals(localHttpRequest.url));
    while (true)
    {
      return false;
      if (localHttpRequest.url == null)
        break;
    }
  }

  public Authorization getAuthorization()
  {
    return this.authorization;
  }

  public RequestMethod getMethod()
  {
    return this.method;
  }

  public HttpParameter[] getParameters()
  {
    return this.parameters;
  }

  public Map<String, String> getRequestHeaders()
  {
    return this.requestHeaders;
  }

  public String getURL()
  {
    return this.url;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i1;
    if (this.method != null)
    {
      i = this.method.hashCode();
      int j = i * 31;
      if (this.url == null)
        break label131;
      k = this.url.hashCode();
      int m = 31 * (k + j);
      if (this.parameters == null)
        break label136;
      n = Arrays.hashCode(this.parameters);
      i1 = 31 * (n + m);
      if (this.authorization == null)
        break label142;
    }
    label131: label136: label142: for (int i2 = this.authorization.hashCode(); ; i2 = 0)
    {
      int i3 = 31 * (i2 + i1);
      Map localMap = this.requestHeaders;
      int i4 = 0;
      if (localMap != null)
        i4 = this.requestHeaders.hashCode();
      return i3 + i4;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("HttpRequest{requestMethod=").append(this.method).append(", url='").append(this.url).append('\'').append(", postParams=");
    if (this.parameters == null);
    for (Object localObject = null; ; localObject = Arrays.asList(this.parameters))
      return localObject + ", authentication=" + this.authorization + ", requestHeaders=" + this.requestHeaders + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpRequest
 * JD-Core Version:    0.6.2
 */