package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.BASE64Encoder;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpRequest;
import twitter4j.internal.http.HttpResponse;

public class OAuth2Authorization
  implements Serializable, Authorization, OAuth2Support
{
  private static final long serialVersionUID = 4274784415515174129L;
  private final Configuration conf;
  private String consumerKey;
  private String consumerSecret;
  private HttpClientWrapper http;
  private OAuth2Token token;

  public OAuth2Authorization(Configuration paramConfiguration)
  {
    this.conf = paramConfiguration;
    setOAuthConsumer(paramConfiguration.getOAuthConsumerKey(), paramConfiguration.getOAuthConsumerSecret());
    this.http = new HttpClientWrapper(paramConfiguration);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof OAuth2Authorization)));
    OAuth2Authorization localOAuth2Authorization;
    label60: 
    do
    {
      do
      {
        do
        {
          return false;
          localOAuth2Authorization = (OAuth2Authorization)paramObject;
          if (this.consumerKey == null)
            break;
        }
        while (!this.consumerKey.equals(localOAuth2Authorization.consumerKey));
        if (this.consumerSecret == null)
          break label92;
      }
      while (!this.consumerSecret.equals(localOAuth2Authorization.consumerSecret));
      if (this.token == null)
        break label101;
    }
    while (!this.token.equals(localOAuth2Authorization.token));
    label92: label101: 
    while (localOAuth2Authorization.token == null)
    {
      return true;
      if (localOAuth2Authorization.consumerKey == null)
        break;
      return false;
      if (localOAuth2Authorization.consumerSecret == null)
        break label60;
      return false;
    }
    return false;
  }

  public String getAuthorizationHeader(HttpRequest paramHttpRequest)
  {
    Object localObject;
    if (this.token == null)
      localObject = "";
    try
    {
      String str = URLEncoder.encode(this.consumerKey, "UTF-8") + ":" + URLEncoder.encode(this.consumerSecret, "UTF-8");
      localObject = str;
      label54: return "Basic " + BASE64Encoder.encode(((String)localObject).getBytes());
      return this.token.generateAuthorizationHeader();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label54;
    }
  }

  public OAuth2Token getOAuth2Token()
    throws TwitterException
  {
    if (this.token != null)
      throw new IllegalStateException("OAuth 2 Bearer Token is already available.");
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[1];
    arrayOfHttpParameter[0] = new HttpParameter("grant_type", "client_credentials");
    HttpResponse localHttpResponse = this.http.post(this.conf.getOAuth2TokenURL(), arrayOfHttpParameter, this);
    if (localHttpResponse.getStatusCode() != 200)
      throw new TwitterException("Obtaining OAuth 2 Bearer Token failed.", localHttpResponse);
    this.token = new OAuth2Token(localHttpResponse);
    return this.token;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.consumerKey != null)
    {
      i = this.consumerKey.hashCode();
      j = i * 31;
      if (this.consumerSecret == null)
        break label77;
    }
    label77: for (int k = this.consumerSecret.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      OAuth2Token localOAuth2Token = this.token;
      int n = 0;
      if (localOAuth2Token != null)
        n = this.token.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void invalidateOAuth2Token()
    throws TwitterException
  {
    if (this.token == null)
      throw new IllegalStateException("OAuth 2 Bearer Token is not available.");
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[1];
    arrayOfHttpParameter[0] = new HttpParameter("access_token", this.token.getAccessToken());
    OAuth2Token localOAuth2Token = this.token;
    try
    {
      this.token = null;
      HttpResponse localHttpResponse = this.http.post(this.conf.getOAuth2InvalidateTokenURL(), arrayOfHttpParameter, this);
      if (localHttpResponse.getStatusCode() != 200)
        throw new TwitterException("Invalidating OAuth 2 Bearer Token failed.", localHttpResponse);
    }
    finally
    {
      this.token = localOAuth2Token;
    }
  }

  public boolean isEnabled()
  {
    return this.token != null;
  }

  public void setOAuth2Token(OAuth2Token paramOAuth2Token)
  {
    this.token = paramOAuth2Token;
  }

  public void setOAuthConsumer(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      this.consumerKey = paramString1;
      if (paramString2 == null)
        break label25;
    }
    while (true)
    {
      this.consumerSecret = paramString2;
      return;
      paramString1 = "";
      break;
      label25: paramString2 = "";
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("OAuth2Authorization{consumerKey='").append(this.consumerKey).append('\'').append(", consumerSecret='******************************************'").append(", token=");
    if (this.token == null);
    for (String str = "null"; ; str = this.token.toString())
      return str + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.auth.OAuth2Authorization
 * JD-Core Version:    0.6.2
 */