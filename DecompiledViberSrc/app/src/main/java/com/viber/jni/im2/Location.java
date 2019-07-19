package com.viber.jni.im2;

import com.viber.jni.LocationInfo;

public class Location
{
  public final int latitude;
  public final int longitude;

  public Location(int paramInt1, int paramInt2)
  {
    this.longitude = paramInt1;
    this.latitude = paramInt2;
    init();
  }

  public static Location fromLegacyLocation(LocationInfo paramLocationInfo)
  {
    if (paramLocationInfo != null)
      return new Location(paramLocationInfo.getNativeLongitude(), paramLocationInfo.getNativeLatitude());
    return null;
  }

  private void init()
  {
  }

  public LocationInfo toLegacyLocation()
  {
    return new LocationInfo(this.latitude, this.longitude);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Location
 * JD-Core Version:    0.6.2
 */