package twitter4j;

import java.io.Serializable;

public abstract interface URLEntity extends Serializable, TweetEntity
{
  public abstract String getDisplayURL();

  public abstract int getEnd();

  public abstract String getExpandedURL();

  public abstract int getStart();

  public abstract String getText();

  public abstract String getURL();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.URLEntity
 * JD-Core Version:    0.6.2
 */