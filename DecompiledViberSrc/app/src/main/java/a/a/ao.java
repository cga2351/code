package a.a;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.f.h;
import com.appboy.f.i;

public class ao
  implements ax
{
  private static final String a = c.a(ao.class);
  private final Context b;
  private final String c;
  private final LocationManager d;
  private final au e;
  private final boolean f;
  private String g;
  private BroadcastReceiver h;

  public ao(Context paramContext, au paramau, b paramb, dd paramdd)
  {
    this.b = paramContext;
    this.c = paramContext.getPackageName();
    this.e = paramau;
    this.d = ((LocationManager)paramContext.getSystemService("location"));
    this.f = a(paramb);
    this.h = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent == null)
          c.e(ao.b(), "Location broadcast receiver received null intent.");
        while (!paramAnonymousIntent.getAction().endsWith(".SINGLE_APPBOY_LOCATION_UPDATE"))
          return;
        ao.a(ao.this, paramAnonymousIntent);
      }
    };
    IntentFilter localIntentFilter = new IntentFilter(this.c + ".SINGLE_APPBOY_LOCATION_UPDATE");
    this.b.registerReceiver(this.h, localIntentFilter);
  }

  private void a(Intent paramIntent)
  {
    try
    {
      c.c(a, "Single location update received from Appboy location manager: " + paramIntent.getAction());
      Location localLocation = (Location)paramIntent.getExtras().get("location");
      if (localLocation != null)
      {
        a(new bk(localLocation.getLatitude(), localLocation.getLongitude(), Double.valueOf(localLocation.getAltitude()), Double.valueOf(localLocation.getAccuracy())));
        return;
      }
      c.d(a, "Failed to process location update. Received location was null.");
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to process location update.", localException);
    }
  }

  public static boolean a(b paramb)
  {
    if (paramb.d())
    {
      c.c(a, "Location collection enabled via sdk configuration.");
      return true;
    }
    c.c(a, "Location collection disabled via sdk configuration.");
    return false;
  }

  private String c()
  {
    if (this.g != null)
      return this.g;
    Criteria localCriteria = new Criteria();
    localCriteria.setAccuracy(2);
    localCriteria.setPowerRequirement(1);
    this.g = this.d.getBestProvider(localCriteria, true);
    return this.g;
  }

  public boolean a()
  {
    if (!this.f)
    {
      c.c(a, "Did not request single location update. Location collection is disabled.");
      return false;
    }
    if ((!h.a(this.b, "android.permission.ACCESS_FINE_LOCATION")) && (!h.a(this.b, "android.permission.ACCESS_COARSE_LOCATION")))
    {
      c.c(a, "Did not request single location update. Fine grained location permissions not found.");
      return false;
    }
    if (h.a(this.b, "android.permission.ACCESS_FINE_LOCATION"));
    for (String str = "passive"; i.c(str); str = c())
    {
      c.b(a, "Could not request single location update. Android location provider not found.");
      return false;
    }
    try
    {
      c.b(a, "Requesting single location update.");
      Intent localIntent = new Intent(this.c + ".SINGLE_APPBOY_LOCATION_UPDATE");
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.b, 0, localIntent, 134217728);
      this.d.requestSingleUpdate(str, localPendingIntent);
      return true;
    }
    catch (SecurityException localSecurityException)
    {
      c.c(a, "Failed to request single location update due to security exception from insufficient permissions.", localSecurityException);
      return false;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to request single location update due to exception.", localException);
    }
    return false;
  }

  public boolean a(bf parambf)
  {
    try
    {
      bp localbp = bp.a(parambf);
      this.e.a(localbp);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to log location recorded event.", localException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ao
 * JD-Core Version:    0.6.2
 */