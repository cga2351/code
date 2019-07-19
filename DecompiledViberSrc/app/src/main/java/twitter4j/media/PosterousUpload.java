package twitter4j.media;

import java.util.Map;
import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class PosterousUpload extends AbstractImageUploadImpl
{
  public PosterousUpload(Configuration paramConfiguration, OAuthAuthorization paramOAuthAuthorization)
  {
    super(paramConfiguration, paramOAuthAuthorization);
  }

  protected String postUpload()
    throws TwitterException
  {
    if (this.httpResponse.getStatusCode() != 200)
      throw new TwitterException("Posterous image upload returned invalid status code", this.httpResponse);
    String str1 = this.httpResponse.asString();
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      if (!localJSONObject.isNull("url"))
      {
        String str2 = localJSONObject.getString("url");
        return str2;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException("Invalid Posterous response: " + str1, localJSONException);
    }
    throw new TwitterException("Unknown Posterous response", this.httpResponse);
  }

  protected void preUpload()
    throws TwitterException
  {
    this.uploadUrl = "http://posterous.com/api2/upload.json";
    String str = generateVerifyCredentialsAuthorizationHeader("https://api.twitter.com/1/account/verify_credentials.json");
    this.headers.put("X-Auth-Service-Provider", "https://api.twitter.com/1/account/verify_credentials.json");
    this.headers.put("X-Verify-Credentials-Authorization", str);
    HttpParameter[] arrayOfHttpParameter1 = new HttpParameter[1];
    arrayOfHttpParameter1[0] = this.image;
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
 * Qualified Name:     twitter4j.media.PosterousUpload
 * JD-Core Version:    0.6.2
 */