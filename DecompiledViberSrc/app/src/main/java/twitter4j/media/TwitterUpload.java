package twitter4j.media;

import java.io.File;
import java.io.InputStream;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;

class TwitterUpload
  implements ImageUpload
{
  private Twitter twitter;

  public TwitterUpload(Configuration paramConfiguration, OAuthAuthorization paramOAuthAuthorization)
  {
    this.twitter = new TwitterFactory(paramConfiguration).getInstance(paramOAuthAuthorization);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TwitterUpload localTwitterUpload;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTwitterUpload = (TwitterUpload)paramObject;
      if (this.twitter == null)
        break;
    }
    while (this.twitter.equals(localTwitterUpload.twitter));
    while (true)
    {
      return false;
      if (localTwitterUpload.twitter == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.twitter != null)
      return this.twitter.hashCode();
    return 0;
  }

  public String toString()
  {
    return "TwitterUpload{twitter=" + this.twitter + '}';
  }

  public String upload(File paramFile)
    throws TwitterException
  {
    return this.twitter.updateStatus(new StatusUpdate("").media(paramFile)).getText();
  }

  public String upload(File paramFile, String paramString)
    throws TwitterException
  {
    return this.twitter.updateStatus(new StatusUpdate(paramString).media(paramFile)).getText();
  }

  public String upload(String paramString, InputStream paramInputStream)
    throws TwitterException
  {
    return this.twitter.updateStatus(new StatusUpdate("").media(paramString, paramInputStream)).getText();
  }

  public String upload(String paramString1, InputStream paramInputStream, String paramString2)
    throws TwitterException
  {
    return this.twitter.updateStatus(new StatusUpdate(paramString2).media(paramString1, paramInputStream)).getText();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.TwitterUpload
 * JD-Core Version:    0.6.2
 */