package com.viber.voip.messages.controller.publicaccount;

import android.location.Location;

public final class a
{
  public static final Location a = new Location("");
  public static final Location b;

  static
  {
    a.setLatitude(0.777D);
    a.setLongitude(0.777D);
    b = new Location("");
    b.setLatitude(0.666D);
    b.setLongitude(0.666D);
  }

  public static boolean a(Location paramLocation)
  {
    return (a.equals(paramLocation)) || (b.equals(paramLocation));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.a
 * JD-Core Version:    0.6.2
 */