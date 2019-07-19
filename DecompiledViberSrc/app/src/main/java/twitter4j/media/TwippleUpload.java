package twitter4j.media;

import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;

class TwippleUpload extends AbstractImageUploadImpl
{
  public TwippleUpload(Configuration paramConfiguration, OAuthAuthorization paramOAuthAuthorization)
  {
    super(paramConfiguration, paramOAuthAuthorization);
  }

  protected String postUpload()
    throws TwitterException
  {
    if (this.httpResponse.getStatusCode() != 200)
      throw new TwitterException("Twipple image upload returned invalid status code", this.httpResponse);
    String str1 = this.httpResponse.asString();
    if (str1.contains("<rsp stat=\"fail\">"))
    {
      String str2 = str1.substring(5 + str1.indexOf("msg"), str1.lastIndexOf("\""));
      throw new TwitterException("Twipple image upload failed with this error message: " + str2, this.httpResponse);
    }
    if (str1.contains("<rsp stat=\"ok\">"))
      return str1.substring(str1.indexOf("<mediaurl>") + "<mediaurl>".length(), str1.indexOf("</mediaurl>"));
    throw new TwitterException("Unknown Twipple response", this.httpResponse);
  }

  protected void preUpload()
    throws TwitterException
  {
    this.uploadUrl = "http://p.twipple.jp/api/upload";
    String str = generateVerifyCredentialsAuthorizationURL("https://api.twitter.com/1.1/account/verify_credentials.json");
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[2];
    arrayOfHttpParameter[0] = new HttpParameter("verify_url", str);
    arrayOfHttpParameter[1] = this.image;
    this.postParameter = arrayOfHttpParameter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.TwippleUpload
 * JD-Core Version:    0.6.2
 */