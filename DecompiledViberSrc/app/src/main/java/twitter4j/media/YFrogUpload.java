package twitter4j.media;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;

class YFrogUpload extends AbstractImageUploadImpl
{
  public YFrogUpload(Configuration paramConfiguration, OAuthAuthorization paramOAuthAuthorization)
  {
    super(paramConfiguration, paramOAuthAuthorization);
  }

  protected String postUpload()
    throws TwitterException
  {
    if (this.httpResponse.getStatusCode() != 200)
      throw new TwitterException("YFrog image upload returned invalid status code", this.httpResponse);
    String str1 = this.httpResponse.asString();
    if (str1.contains("<rsp stat=\"fail\">"))
    {
      String str2 = str1.substring(5 + str1.indexOf("msg"), str1.lastIndexOf("\""));
      throw new TwitterException("YFrog image upload failed with this error message: " + str2, this.httpResponse);
    }
    if (str1.contains("<rsp stat=\"ok\">"))
      return str1.substring(str1.indexOf("<mediaurl>") + "<mediaurl>".length(), str1.indexOf("</mediaurl>"));
    throw new TwitterException("Unknown YFrog response", this.httpResponse);
  }

  protected void preUpload()
    throws TwitterException
  {
    this.uploadUrl = "https://yfrog.com/api/xauth_upload";
    String str = generateVerifyCredentialsAuthorizationURL("https://api.twitter.com/1/account/verify_credentials.xml");
    Twitter localTwitter = new TwitterFactory().getInstance(this.oauth);
    HttpParameter[] arrayOfHttpParameter1 = new HttpParameter[4];
    arrayOfHttpParameter1[0] = new HttpParameter("auth", "oauth");
    arrayOfHttpParameter1[1] = new HttpParameter("username", localTwitter.verifyCredentials().getScreenName());
    arrayOfHttpParameter1[2] = new HttpParameter("verify_url", str);
    arrayOfHttpParameter1[3] = this.image;
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
 * Qualified Name:     twitter4j.media.YFrogUpload
 * JD-Core Version:    0.6.2
 */