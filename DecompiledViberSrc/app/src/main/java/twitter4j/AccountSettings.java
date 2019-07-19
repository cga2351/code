package twitter4j;

import java.io.Serializable;

public abstract interface AccountSettings extends Serializable, TwitterResponse
{
  public abstract String getLanguage();

  public abstract String getScreenName();

  public abstract String getSleepEndTime();

  public abstract String getSleepStartTime();

  public abstract TimeZone getTimeZone();

  public abstract Location[] getTrendLocations();

  public abstract boolean isAlwaysUseHttps();

  public abstract boolean isDiscoverableByEmail();

  public abstract boolean isGeoEnabled();

  public abstract boolean isSleepTimeEnabled();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.AccountSettings
 * JD-Core Version:    0.6.2
 */