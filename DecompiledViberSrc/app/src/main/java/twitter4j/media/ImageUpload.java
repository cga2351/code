package twitter4j.media;

import java.io.File;
import java.io.InputStream;
import twitter4j.TwitterException;

public abstract interface ImageUpload
{
  public abstract String upload(File paramFile)
    throws TwitterException;

  public abstract String upload(File paramFile, String paramString)
    throws TwitterException;

  public abstract String upload(String paramString, InputStream paramInputStream)
    throws TwitterException;

  public abstract String upload(String paramString1, InputStream paramInputStream, String paramString2)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.ImageUpload
 * JD-Core Version:    0.6.2
 */