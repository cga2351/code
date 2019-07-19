package com.appnexus.opensdk.utils;

import android.location.Location;
import android.os.Build;
import com.appnexus.opensdk.MediaType;
import com.appnexus.opensdk.R.string;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class Settings
{
  public static final String AN_UUID = "uuid2";
  public static final int DEFAULT_INTERSTITIAL_CLOSE_BUTTON_DELAY = 10000;
  public static final int DEFAULT_REFRESH = 30000;
  public static final int FETCH_THREAD_COUNT = 4;
  public static final int HTTP_CONNECTION_TIMEOUT = 15000;
  public static final int HTTP_SOCKET_TIMEOUT = 20000;
  public static final long MEDIATED_NETWORK_TIMEOUT = 15000L;
  public static final int MIN_PERCENTAGE_VIEWED = 50;
  public static final int MIN_REFRESH_MILLISECONDS = 15000;
  public static final long NATIVE_AD_RESPONSE_EXPIRATION_TIME = 3600000L;
  public static final int NATIVE_AD_VISIBLE_PERIOD_MILLIS = 1000;
  public static final int VIDEO_AUTOPLAY_PERCENTAGE = 50;
  private static String d = "http://mediation.adnxs.com";
  private static String e = "http://mediation.adnxs.com/";
  private static String f = "http://mediation.adnxs.com/mob?";
  private static String g = "http://mediation.adnxs.com/install?";
  private static String h = "file:///android_res/raw/index.html";
  private static Settings i = null;
  private HashSet<String> a = new HashSet();
  public String aaid = null;
  public boolean aaidEnabled = true;
  public String app_id = null;
  private HashSet<String> b = new HashSet();
  private HashSet<String> c = new HashSet();
  public String carrierName = null;
  public boolean debug_mode = false;
  public final String dev_timezone = TimeZone.getDefault().getDisplayName(true, 0);
  public final String deviceMake = Build.MANUFACTURER;
  public final String deviceModel = Build.MODEL;
  public HashMap<String, String> externalMediationClasses = new HashMap();
  public boolean first_launch;
  public String hidmd5 = null;
  public String hidsha1 = null;
  public final String language = Locale.getDefault().getLanguage();
  public boolean limitTrackingEnabled = false;
  public Location location = null;
  public int locationDecimalDigits = -1;
  public boolean locationEnabled = true;
  public boolean locationEnabledForCreative = true;
  public String mcc;
  public String mnc;
  public final String sdkVersion = "4.11.2";
  public boolean test_mode = false;
  public String ua = null;
  public boolean useHttps = false;

  public static String getBaseUrl()
  {
    if (getSettings().useHttps)
      return e.replace("http:", "https:");
    return e;
  }

  public static String getCookieDomain()
  {
    return d;
  }

  public static String getInstallBaseUrl()
  {
    if (getSettings().useHttps)
      return g.replace("http:", "https:");
    return g;
  }

  public static String getRequestBaseUrl()
  {
    if (getSettings().useHttps)
      return f.replace("http:", "https:");
    return f;
  }

  public static Settings getSettings()
  {
    if (i == null)
    {
      i = new Settings();
      Clog.v(Clog.baseLogTag, Clog.getString(R.string.init));
    }
    return i;
  }

  public static String getVideoHtmlPage()
  {
    if (getSettings().debug_mode)
      return h.replace("index.html", "index.html?ast_debug=true");
    return h;
  }

  public static boolean isHttpsEnabled()
  {
    return getSettings().useHttps;
  }

  public void addInvalidNetwork(MediaType paramMediaType, String paramString)
  {
    if (!StringUtil.isEmpty(paramString));
    switch (1.a[paramMediaType.ordinal()])
    {
    default:
      return;
    case 1:
      this.a.add(paramString);
      return;
    case 2:
      this.b.add(paramString);
      return;
    case 3:
    }
    this.c.add(paramString);
  }

  public HashSet<String> getInvalidNetwork(MediaType paramMediaType)
  {
    switch (1.a[paramMediaType.ordinal()])
    {
    default:
      return null;
    case 1:
      return this.a;
    case 2:
      return this.b;
    case 3:
    }
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.Settings
 * JD-Core Version:    0.6.2
 */