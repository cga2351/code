package twitter4j.media;

import java.util.Map;
import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class TwitpicUpload extends AbstractImageUploadImpl
{
  public TwitpicUpload(Configuration paramConfiguration, String paramString, OAuthAuthorization paramOAuthAuthorization)
  {
    super(paramConfiguration, paramString, paramOAuthAuthorization);
  }

  protected String postUpload()
    throws TwitterException
  {
    if (this.httpResponse.getStatusCode() != 200)
      throw new TwitterException("Twitpic image upload returned invalid status code", this.httpResponse);
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
      throw new TwitterException("Invalid Twitpic response: " + str1, localJSONException);
    }
    throw new TwitterException("Unknown Twitpic response", this.httpResponse);
  }

  protected void preUpload()
    throws TwitterException
  {
    this.uploadUrl = "https://twitpic.com/api/2/upload.json";
    String str = generateVerifyCredentialsAuthorizationHeader("https://api.twitter.com/1.1/account/verify_credentials.json");
    this.headers.put("X-Auth-Service-Provider", "https://api.twitter.com/1.1/account/verify_credentials.json");
    this.headers.put("X-Verify-Credentials-Authorization", str);
    if (this.apiKey == null)
      throw new IllegalStateException("No API Key for Twitpic specified. put media.providerAPIKey in twitter4j.properties.");
    HttpParameter[] arrayOfHttpParameter1 = new HttpParameter[2];
    arrayOfHttpParameter1[0] = new HttpParameter("key", this.apiKey);
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
 * Qualified Name:     twitter4j.media.TwitpicUpload
 * JD-Core Version:    0.6.2
 */