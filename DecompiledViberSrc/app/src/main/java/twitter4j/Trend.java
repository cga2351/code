package twitter4j;

import java.io.Serializable;

public abstract interface Trend extends Serializable
{
  public abstract String getName();

  public abstract String getQuery();

  public abstract String getURL();

  public abstract String getUrl();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.Trend
 * JD-Core Version:    0.6.2
 */