package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import twitter4j.TwitterException;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.json.z_T4JInternalParseUtil;
import twitter4j.internal.org.json.JSONObject;

public class OAuth2Token
  implements Serializable
{
  private static final long serialVersionUID = 358222644448390610L;
  private String accessToken;
  private String tokenType;

  public OAuth2Token(String paramString1, String paramString2)
  {
    this.tokenType = paramString1;
    this.accessToken = paramString2;
  }

  OAuth2Token(HttpResponse paramHttpResponse)
    throws TwitterException
  {
    JSONObject localJSONObject = paramHttpResponse.asJSONObject();
    this.tokenType = z_T4JInternalParseUtil.getRawString("token_type", localJSONObject);
    try
    {
      this.accessToken = URLDecoder.decode(z_T4JInternalParseUtil.getRawString("access_token", localJSONObject), "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof OAuth2Token)));
    OAuth2Token localOAuth2Token;
    do
    {
      do
      {
        return false;
        localOAuth2Token = (OAuth2Token)paramObject;
        if (this.tokenType == null)
          break;
      }
      while (!this.tokenType.equals(localOAuth2Token.tokenType));
      if (this.accessToken == null)
        break label71;
    }
    while (!this.accessToken.equals(localOAuth2Token.accessToken));
    label71: 
    while (localOAuth2Token.accessToken == null)
    {
      return true;
      if (localOAuth2Token.tokenType == null)
        break;
      return false;
    }
    return false;
  }

  String generateAuthorizationHeader()
  {
    Object localObject = "";
    try
    {
      String str = URLEncoder.encode(this.accessToken, "UTF-8");
      localObject = str;
      label15: return "Bearer " + (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label15;
    }
  }

  public String getAccessToken()
  {
    return this.accessToken;
  }

  public String getTokenType()
  {
    return this.tokenType;
  }

  public int hashCode()
  {
    if (this.tokenType != null);
    for (int i = this.tokenType.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.accessToken;
      int k = 0;
      if (str != null)
        k = this.accessToken.hashCode();
      return j + k;
    }
  }

  public String toString()
  {
    return "OAuth2Token{tokenType='" + this.tokenType + '\'' + ", accessToken='" + this.accessToken + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.auth.OAuth2Token
 * JD-Core Version:    0.6.2
 */