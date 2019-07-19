package com.appboy.receivers;

import a.a.bk;
import a.a.gt;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.appboy.a;
import com.appboy.b;
import com.appboy.f.c;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.LocationResult;
import java.util.Iterator;
import java.util.List;

public class AppboyActionReceiver extends BroadcastReceiver
{
  private static final String a = c.a(AppboyActionReceiver.class);

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      c.d(a, "AppboyActionReceiver received null intent. Doing nothing.");
      return;
    }
    new Thread(new a(paramContext.getApplicationContext(), paramIntent, goAsync())).start();
  }

  static class a
    implements Runnable
  {
    private final String a;
    private final Context b;
    private final BroadcastReceiver.PendingResult c;
    private final Intent d;

    a(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
    {
      this.b = paramContext;
      this.d = paramIntent;
      this.a = paramIntent.getAction();
      this.c = paramPendingResult;
    }

    static boolean a(Context paramContext, GeofencingEvent paramGeofencingEvent)
    {
      if (paramGeofencingEvent.hasError())
      {
        int j = paramGeofencingEvent.getErrorCode();
        c.e(AppboyActionReceiver.a(), "AppboyLocation Services error: " + j);
        return false;
      }
      int i = paramGeofencingEvent.getGeofenceTransition();
      List localList = paramGeofencingEvent.getTriggeringGeofences();
      if (1 == i)
      {
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
          b.a(paramContext, ((Geofence)localIterator2.next()).getRequestId(), gt.a);
        return true;
      }
      if (2 == i)
      {
        Iterator localIterator1 = localList.iterator();
        while (localIterator1.hasNext())
          b.a(paramContext, ((Geofence)localIterator1.next()).getRequestId(), gt.b);
        return true;
      }
      c.d(AppboyActionReceiver.a(), "Unsupported transition type received: " + i);
      return false;
    }

    static boolean a(Context paramContext, LocationResult paramLocationResult)
    {
      try
      {
        Location localLocation = paramLocationResult.getLastLocation();
        b.a(paramContext, new bk(localLocation.getLatitude(), localLocation.getLongitude(), Double.valueOf(localLocation.getAltitude()), Double.valueOf(localLocation.getAccuracy())));
        return true;
      }
      catch (Exception localException)
      {
        c.d(AppboyActionReceiver.a(), "Exception while processing location result", localException);
      }
      return false;
    }

    boolean a()
    {
      if (this.a == null)
      {
        c.b(AppboyActionReceiver.a(), "Received intent with null action. Doing nothing.");
        return false;
      }
      c.b(AppboyActionReceiver.a(), "Received intent with action " + this.a);
      if (this.a.equals("com.appboy.action.receiver.DATA_SYNC"))
      {
        c.a(AppboyActionReceiver.a(), "Requesting immediate data flush from AppboyActionReceiver.", false);
        a.a(this.b).f();
        return true;
      }
      if (this.a.equals("com.appboy.action.receiver.APPBOY_GEOFENCE_LOCATION_UPDATE"))
      {
        if (LocationResult.hasResult(this.d))
        {
          c.b(AppboyActionReceiver.a(), "AppboyActionReceiver received intent with location result: " + this.a);
          return a(this.b, LocationResult.extractResult(this.d));
        }
        c.d(AppboyActionReceiver.a(), "AppboyActionReceiver received intent without location result: " + this.a);
        return false;
      }
      if (this.a.equals("com.appboy.action.receiver.APPBOY_GEOFENCE_UPDATE"))
      {
        c.b(AppboyActionReceiver.a(), "AppboyActionReceiver received intent with geofence transition: " + this.a);
        return a(this.b, GeofencingEvent.fromIntent(this.d));
      }
      c.d(AppboyActionReceiver.a(), "Unknown intent received in AppboyActionReceiver with action: " + this.a);
      return false;
    }

    public void run()
    {
      try
      {
        a();
        this.c.finish();
        return;
      }
      catch (Exception localException)
      {
        while (true)
          c.d(AppboyActionReceiver.a(), "Caught exception while performing the AppboyActionReceiver work. Action: " + this.a + " Intent: " + this.d, localException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.receivers.AppboyActionReceiver
 * JD-Core Version:    0.6.2
 */