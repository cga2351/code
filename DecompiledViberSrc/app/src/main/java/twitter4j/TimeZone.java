package twitter4j;

import java.io.Serializable;

public abstract interface TimeZone extends Serializable
{
  public abstract String getName();

  public abstract String tzinfoName();

  public abstract int utcOffset();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.TimeZone
 * JD-Core Version:    0.6.2
 */