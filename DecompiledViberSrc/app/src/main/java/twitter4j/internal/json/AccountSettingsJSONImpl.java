package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.AccountSettings;
import twitter4j.Location;
import twitter4j.TimeZone;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class AccountSettingsJSONImpl extends TwitterResponseImpl
  implements Serializable, AccountSettings
{
  private static final long serialVersionUID = 7983363611306383416L;
  private final boolean ALWAYS_USE_HTTPS;
  private final boolean DISCOVERABLE_BY_EMAIL;
  private final boolean GEO_ENABLED;
  private final String LANGUAGE;
  private final String SCREEN_NAME;
  private final String SLEEP_END_TIME;
  private final String SLEEP_START_TIME;
  private final boolean SLEEP_TIME_ENABLED;
  private final TimeZone TIMEZONE;
  private final Location[] TREND_LOCATION;

  AccountSettingsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    this(paramHttpResponse, paramHttpResponse.asJSONObject());
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
    }
  }

  private AccountSettingsJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject)
    throws TwitterException
  {
    super(paramHttpResponse);
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("sleep_time");
      this.SLEEP_TIME_ENABLED = z_T4JInternalParseUtil.getBoolean("enabled", localJSONObject);
      this.SLEEP_START_TIME = localJSONObject.getString("start_time");
      this.SLEEP_END_TIME = localJSONObject.getString("end_time");
      if (paramJSONObject.isNull("trend_location"))
        this.TREND_LOCATION = new Location[0];
      while (true)
      {
        this.GEO_ENABLED = z_T4JInternalParseUtil.getBoolean("geo_enabled", paramJSONObject);
        this.LANGUAGE = paramJSONObject.getString("language");
        this.ALWAYS_USE_HTTPS = z_T4JInternalParseUtil.getBoolean("always_use_https", paramJSONObject);
        this.DISCOVERABLE_BY_EMAIL = z_T4JInternalParseUtil.getBoolean("discoverable_by_email", paramJSONObject);
        this.TIMEZONE = new TimeZoneJSONImpl(paramJSONObject.getJSONObject("time_zone"));
        this.SCREEN_NAME = paramJSONObject.getString("screen_name");
        return;
        JSONArray localJSONArray = paramJSONObject.getJSONArray("trend_location");
        this.TREND_LOCATION = new Location[localJSONArray.length()];
        while (i < localJSONArray.length())
        {
          this.TREND_LOCATION[i] = new LocationJSONImpl(localJSONArray.getJSONObject(i));
          i++;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }

  AccountSettingsJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    this(null, paramJSONObject);
  }

  public String getLanguage()
  {
    return this.LANGUAGE;
  }

  public String getScreenName()
  {
    return this.SCREEN_NAME;
  }

  public String getSleepEndTime()
  {
    return this.SLEEP_END_TIME;
  }

  public String getSleepStartTime()
  {
    return this.SLEEP_START_TIME;
  }

  public TimeZone getTimeZone()
  {
    return this.TIMEZONE;
  }

  public Location[] getTrendLocations()
  {
    return this.TREND_LOCATION;
  }

  public boolean isAlwaysUseHttps()
  {
    return this.ALWAYS_USE_HTTPS;
  }

  public boolean isDiscoverableByEmail()
  {
    return this.DISCOVERABLE_BY_EMAIL;
  }

  public boolean isGeoEnabled()
  {
    return this.GEO_ENABLED;
  }

  public boolean isSleepTimeEnabled()
  {
    return this.SLEEP_TIME_ENABLED;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.AccountSettingsJSONImpl
 * JD-Core Version:    0.6.2
 */