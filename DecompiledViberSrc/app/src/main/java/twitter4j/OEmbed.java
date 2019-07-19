package twitter4j;

import java.io.Serializable;

public abstract interface OEmbed extends Serializable, TwitterResponse
{
  public abstract String getAuthorName();

  public abstract String getAuthorURL();

  public abstract long getCacheAge();

  public abstract String getHtml();

  public abstract String getURL();

  public abstract String getVersion();

  public abstract int getWidth();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.OEmbed
 * JD-Core Version:    0.6.2
 */