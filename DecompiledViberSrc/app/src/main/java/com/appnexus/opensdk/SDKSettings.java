package com.appnexus.opensdk;

import android.location.Location;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.Settings;

public class SDKSettings
{
  public static String getAAID()
  {
    return Settings.getSettings().aaid;
  }

  public static Location getLocation()
  {
    return Settings.getSettings().location;
  }

  public static int getLocationDecimalDigits()
  {
    return Settings.getSettings().locationDecimalDigits;
  }

  public static boolean getLocationEnabled()
  {
    return Settings.getSettings().locationEnabled;
  }

  public static boolean isHttpsEnabled()
  {
    return Settings.getSettings().useHttps;
  }

  public static boolean isLocationEnabledForCreative()
  {
    return Settings.getSettings().locationEnabledForCreative;
  }

  public static void setAAID(String paramString, boolean paramBoolean)
  {
    if (Settings.getSettings().aaidEnabled)
    {
      Settings.getSettings().aaid = paramString;
      Settings.getSettings().limitTrackingEnabled = paramBoolean;
    }
  }

  public static void setAAIDEnabled(boolean paramBoolean)
  {
    Settings.getSettings().aaidEnabled = paramBoolean;
  }

  public static void setLocation(Location paramLocation)
  {
    if (getLocationEnabled())
    {
      if ((getLocationDecimalDigits() != -1) && (paramLocation != null))
      {
        double d = Math.pow(10.0D, getLocationDecimalDigits());
        paramLocation.setLatitude(Math.round(d * paramLocation.getLatitude()) / d);
        paramLocation.setLongitude(Math.round(d * paramLocation.getLongitude()) / d);
      }
      Settings.getSettings().location = paramLocation;
      return;
    }
    Settings.getSettings().location = null;
  }

  public static void setLocationDecimalDigits(int paramInt)
  {
    if (paramInt > 6)
    {
      Settings.getSettings().locationDecimalDigits = 6;
      Clog.w(Clog.baseLogTag, "Out of range input " + paramInt + ", set location digits after decimal to maximum 6");
      return;
    }
    if (paramInt >= -1)
    {
      Settings.getSettings().locationDecimalDigits = paramInt;
      return;
    }
    Settings.getSettings().locationDecimalDigits = -1;
    Clog.w(Clog.baseLogTag, "Negative input " + paramInt + ", set location digits after decimal to default");
  }

  public static void setLocationEnabled(boolean paramBoolean)
  {
    Settings.getSettings().locationEnabled = paramBoolean;
  }

  public static void setLocationEnabledForCreative(boolean paramBoolean)
  {
    Settings.getSettings().locationEnabledForCreative = paramBoolean;
  }

  public static void useHttps(boolean paramBoolean)
  {
    Settings.getSettings().useHttps = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.SDKSettings
 * JD-Core Version:    0.6.2
 */