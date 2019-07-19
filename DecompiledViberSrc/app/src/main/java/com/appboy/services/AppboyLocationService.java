package com.appboy.services;

import android.content.Context;
import com.appboy.b;
import com.appboy.f.c;

public class AppboyLocationService
{
  private static final String a = c.a(AppboyLocationService.class);

  public static void requestInitialization(Context paramContext)
  {
    c.b(a, "Location permissions were granted. Requesting geofence initialization.");
    b.a(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.services.AppboyLocationService
 * JD-Core Version:    0.6.2
 */