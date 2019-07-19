package twitter4j.media;

import java.util.Map;
import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.logging.Logger;

class PlixiUpload extends AbstractImageUploadImpl
{
  public PlixiUpload(Configuration paramConfiguration, String paramString, OAuthAuthorization paramOAuthAuthorization)
  {
    super(paramConfiguration, paramString, paramOAuthAuthorization);
    logger.warn("Lockerz is no longer providing API.");
    this.uploadUrl = "http://api.plixi.com/api/upload.aspx";
  }

  protected String postUpload()
    throws TwitterException
  {
    if (this.httpResponse.getStatusCode() != 201)
      throw new TwitterException("Plixi image upload returned invalid status code", this.httpResponse);
    String str1 = this.httpResponse.asString();
    if (str1.contains("<Error><ErrorCode>"))
    {
      String str2 = str1.substring(str1.indexOf("<ErrorCode>") + "<ErrorCode>".length(), str1.lastIndexOf("</ErrorCode>"));
      throw new TwitterException("Plixi image upload failed with this error message: " + str2, this.httpResponse);
    }
    if (str1.contains("<Status>OK</Status>"))
      return str1.substring(str1.indexOf("<MediaUrl>") + "<MediaUrl>".length(), str1.indexOf("</MediaUrl>"));
    throw new TwitterException("Unknown Plixi response", this.httpResponse);
  }

  protected void preUpload()
    throws TwitterException
  {
    String str = generateVerifyCredentialsAuthorizationHeader("https://api.twitter.com/1.1/account/verify_credentials.json");
    this.headers.put("X-Auth-Service-Provider", "https://api.twitter.com/1.1/account/verify_credentials.json");
    this.headers.put("X-Verify-Credentials-Authorization", str);
    if (this.apiKey == null)
      throw new IllegalStateException("No API Key for Plixi specified. put media.providerAPIKey in twitter4j.properties.");
    HttpParameter[] arrayOfHttpParameter1 = new HttpParameter[2];
    arrayOfHttpParameter1[0] = new HttpParameter("api_key", this.apiKey);
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
 * Qualified Name:     twitter4j.media.PlixiUpload
 * JD-Core Version:    0.6.2
 */