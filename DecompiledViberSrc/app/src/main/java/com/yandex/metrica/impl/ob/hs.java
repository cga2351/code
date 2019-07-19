package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class hs
{
  static final Set<String> a = new HashSet(Arrays.asList(new String[] { "gps" }));
  private Context b;
  private LocationManager c;
  private iv d;

  public hs(Context paramContext, LocationManager paramLocationManager, iv paramiv)
  {
    this.b = paramContext;
    this.c = paramLocationManager;
    this.d = paramiv;
  }

  public Location a()
  {
    LocationManager localLocationManager = this.c;
    Object localObject1 = null;
    if (localLocationManager != null)
    {
      boolean bool1 = this.d.a(this.b);
      boolean bool2 = this.d.b(this.b);
      List localList = this.c.getAllProviders();
      localObject1 = null;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        Object localObject2 = null;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!a.contains(str))
          {
            if (bool1);
            while (true)
            {
              try
              {
                if ((!"passive".equals(str)) || (bool2))
                {
                  Location localLocation2 = this.c.getLastKnownLocation(str);
                  localLocation1 = localLocation2;
                  if ((localLocation1 == null) || (!hq.a(localLocation1, (Location)localObject2, hq.a, 200L)))
                    break;
                  localObject2 = localLocation1;
                }
              }
              catch (Exception localException)
              {
              }
              Location localLocation1 = null;
            }
          }
        }
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hs
 * JD-Core Version:    0.6.2
 */