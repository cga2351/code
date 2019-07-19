package twitter4j.media;

import java.util.Map;
import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;

class TwitgooUpload extends AbstractImageUploadImpl
{
  public TwitgooUpload(Configuration paramConfiguration, OAuthAuthorization paramOAuthAuthorization)
  {
    super(paramConfiguration, paramOAuthAuthorization);
  }

  protected String postUpload()
    throws TwitterException
  {
    if (this.httpResponse.getStatusCode() != 200)
      throw new TwitterException("Twitgoo image upload returned invalid status code", this.httpResponse);
    String str1 = this.httpResponse.asString();
    if (str1.contains("<rsp status=\"ok\">"))
    {
      int k = str1.indexOf("<mediaurl>");
      if (k != -1)
      {
        int m = str1.indexOf("</mediaurl>", k + "<mediaurl>".length());
        if (m != -1)
          return str1.substring(k + "<mediaurl>".length(), m);
      }
    }
    else if (str1.contains("<rsp status=\"fail\">"))
    {
      int i = str1.indexOf("msg=\"");
      if (i != -1)
      {
        int j = str1.indexOf("\"", i + "msg=\"".length());
        if (j != -1)
        {
          String str2 = str1.substring(i + "msg=\"".length(), j);
          throw new TwitterException("Invalid Twitgoo response: " + str2);
        }
      }
    }
    throw new TwitterException("Unknown Twitgoo response", this.httpResponse);
  }

  protected void preUpload()
    throws TwitterException
  {
    this.uploadUrl = "http://twitgoo.com/api/uploadAndPost";
    String str = generateVerifyCredentialsAuthorizationHeader("https://api.twitter.com/1/account/verify_credentials.json");
    this.headers.put("X-Auth-Service-Provider", "https://api.twitter.com/1/account/verify_credentials.json");
    this.headers.put("X-Verify-Credentials-Authorization", str);
    HttpParameter[] arrayOfHttpParameter1 = new HttpParameter[2];
    arrayOfHttpParameter1[0] = new HttpParameter("no_twitter_post", "1");
    arrayOfHttpParameter1[1] = this.image;
    if (this.message != null)
    {
      HttpParameter[] arrayOfHttpParameter2 = new HttpParameter[1];
      arrayOfHttpParameter2[0] = this.message;
      arrayOfHttpParameter1 = appendHttpParameters(arrayOfHttpParameter2, arrayOfHttpParameter1);
    }
    this.postParameter = arrayOfHttpParameter1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.TwitgooUpload
 * JD-Core Version:    0.6.2
 */