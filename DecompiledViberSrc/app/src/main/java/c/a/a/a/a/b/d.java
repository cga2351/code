package c.a.a.a.a.b;

import android.content.Context;
import c.a.a.a.c;
import c.a.a.a.l;
import java.lang.reflect.Method;

class d
  implements f
{
  private final Context a;

  public d(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  private String b()
  {
    try
    {
      String str = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(d(), new Object[0]);
      return str;
    }
    catch (Exception localException)
    {
      c.g().d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }
    return null;
  }

  private boolean c()
  {
    try
    {
      boolean bool = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(d(), new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      c.g().d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }
    return false;
  }

  private Object d()
  {
    try
    {
      Method localMethod = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] { Context.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.a;
      Object localObject = localMethod.invoke(null, arrayOfObject);
      return localObject;
    }
    catch (Exception localException)
    {
      c.g().d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }
    return null;
  }

  public b a()
  {
    if (a(this.a))
      return new b(b(), c());
    return null;
  }

  boolean a(Context paramContext)
  {
    try
    {
      int i = ((Integer)Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).intValue();
      return i == 0;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.d
 * JD-Core Version:    0.6.2
 */