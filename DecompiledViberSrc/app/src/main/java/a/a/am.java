package a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.a.b;
import com.appboy.e.a;
import com.appboy.f.c;
import com.appboy.f.h;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationServices;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class am
{
  private static final String j = c.a(am.class);
  final au a;
  final SharedPreferences b;
  final List<a> c;
  final PendingIntent d;
  final PendingIntent e;
  an f;
  bf g;
  boolean h = false;
  int i;
  private final Context k;
  private final b l;
  private final dd m;
  private final Object n = new Object();

  public am(Context paramContext, String paramString, au paramau, b paramb, dd paramdd)
  {
    this.k = paramContext.getApplicationContext();
    this.a = paramau;
    this.b = paramContext.getSharedPreferences(b(paramString), 0);
    this.l = paramb;
    this.m = paramdd;
    boolean bool1 = dl.a(this.m);
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = a(paramContext);
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    this.h = bool2;
    this.i = dl.b(this.m);
    this.c = dl.a(this.b);
    this.d = dl.a(paramContext);
    this.e = dl.b(paramContext);
    this.f = new an(paramContext, paramString, paramdd);
    a(true);
  }

  static String b(String paramString)
  {
    return "com.appboy.managers.geofences.storage." + paramString;
  }

  a a(String paramString)
  {
    synchronized (this.n)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a().equals(paramString))
          return locala;
      }
      return null;
    }
  }

  public void a()
  {
    c.b(j, "Request to set up geofences received.");
    if ((dl.a(this.m)) && (a(this.k)));
    for (boolean bool = true; ; bool = false)
    {
      this.h = bool;
      a(false);
      b(true);
      return;
    }
  }

  public void a(bf parambf)
  {
    if (!this.h)
      c.b(j, "Appboy geofences not enabled. Not requesting geofences.");
    while (parambf == null)
      return;
    this.g = new bk(parambf.a(), parambf.b(), parambf.c(), parambf.d());
    this.a.a(this.g);
  }

  public void a(by paramby)
  {
    if (paramby == null)
    {
      c.d(j, "Could not configure geofence manager from server config. Server config was null.");
      return;
    }
    boolean bool1 = paramby.i();
    c.b(j, "Geofences enabled server config value " + bool1 + " received.");
    boolean bool2;
    if ((bool1) && (a(this.k)))
    {
      bool2 = true;
      if (bool2 == this.h)
        break label211;
      this.h = bool2;
      c.c(j, "Geofences enabled status newly set to " + this.h + " during server config update.");
      if (!this.h)
        break label200;
      a(false);
      b(true);
    }
    while (true)
    {
      int i1 = paramby.h();
      if (i1 >= 0)
      {
        this.i = i1;
        c.c(j, "Max number to register newly set to " + this.i + " via server config.");
      }
      this.f.a(paramby);
      return;
      bool2 = false;
      break;
      label200: a(this.d);
      continue;
      label211: c.b(j, "Geofences enabled status " + this.h + " unchanged during server config update.");
    }
  }

  protected void a(PendingIntent paramPendingIntent)
  {
    c.b(j, "Tearing down geofences.");
    if (paramPendingIntent != null)
    {
      c.b(j, "Unregistering any Braze geofences from Google Play Services.");
      LocationServices.getGeofencingClient(this.k).removeGeofences(paramPendingIntent);
    }
    synchronized (this.n)
    {
      c.b(j, "Deleting locally stored geofences.");
      SharedPreferences.Editor localEditor = this.b.edit();
      localEditor.clear();
      this.c.clear();
      localEditor.apply();
      return;
    }
  }

  public void a(List<a> paramList)
  {
    if (paramList == null)
    {
      c.d(j, "Appboy geofence list was null. Not adding new geofences to local storage.");
      return;
    }
    if (!this.h)
    {
      c.d(j, "Appboy geofences not enabled. Not adding new geofences to local storage.");
      return;
    }
    if (this.g != null)
    {
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        a locala2 = (a)localIterator2.next();
        locala2.a(ds.a(this.g.a(), this.g.b(), locala2.f(), locala2.g()));
      }
      Collections.sort(paramList);
    }
    synchronized (this.n)
    {
      c.b(j, "Received new geofence list of size: " + paramList.size());
      SharedPreferences.Editor localEditor = this.b.edit();
      localEditor.clear();
      this.c.clear();
      Iterator localIterator1 = paramList.iterator();
      int i1 = 0;
      a locala1;
      if (localIterator1.hasNext())
      {
        locala1 = (a)localIterator1.next();
        if (i1 == this.i)
          c.b(j, "Reached maximum number of new geofences: " + this.i);
      }
      else
      {
        localEditor.apply();
        c.b(j, "Added " + this.c.size() + " new geofences to local storage.");
        this.f.a(paramList);
        a(true);
        return;
      }
      this.c.add(locala1);
      c.b(j, "Adding new geofence to local storage: " + locala1.toString());
      localEditor.putString(locala1.a(), locala1.k().toString());
      i1++;
    }
  }

  protected void a(List<a> paramList, PendingIntent paramPendingIntent)
  {
    dm.a(this.k, paramList, paramPendingIntent);
  }

  protected void a(boolean paramBoolean)
  {
    if (!this.h)
      c.b(j, "Appboy geofences not enabled. Geofences not set up.");
    do
    {
      return;
      c.b(j, "Location permissions and Google Play Services available. Location collection and Geofencing enabled via config.");
    }
    while (!paramBoolean);
    synchronized (this.n)
    {
      a(this.c, this.d);
      return;
    }
  }

  protected boolean a(Context paramContext)
  {
    if (!ao.a(this.l))
    {
      c.b(j, "Location collection not available. Geofences not enabled.");
      return false;
    }
    if (!h.a(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
    {
      c.c(j, "Fine grained location permissions not found. Geofences not enabled.");
      return false;
    }
    if (!dn.a(paramContext))
    {
      c.b(j, "Google Play Services not available. Geofences not enabled.");
      return false;
    }
    ClassLoader localClassLoader = am.class.getClassLoader();
    try
    {
      if (Class.forName("com.google.android.gms.location.LocationServices", false, localClassLoader) == null)
        throw new RuntimeException("com.google.android.gms.location.LocationServices not found.");
    }
    catch (Exception localException)
    {
      c.b(j, "Google Play Services Location API not found. Geofences not enabled.");
      return false;
    }
    return true;
  }

  boolean a(String paramString, gt paramgt)
  {
    synchronized (this.n)
    {
      a locala = a(paramString);
      if (locala != null)
      {
        if (paramgt.equals(gt.a))
        {
          boolean bool2 = locala.b();
          return bool2;
        }
        if (paramgt.equals(gt.b))
        {
          boolean bool1 = locala.c();
          return bool1;
        }
      }
    }
    return false;
  }

  public void b()
  {
    if (!this.h)
    {
      c.b(j, "Appboy geofences not enabled. Not un-registering geofences.");
      return;
    }
    c.b(j, "Tearing down all geofences.");
    a(this.d);
  }

  protected void b(PendingIntent paramPendingIntent)
  {
    dm.a(this.k, paramPendingIntent);
  }

  public void b(String paramString, gt paramgt)
  {
    if (!this.h)
      c.d(j, "Appboy geofences not enabled. Not posting geofence report.");
    while (true)
    {
      return;
      try
      {
        bp localbp = bp.a(paramString, paramgt.toString().toLowerCase(Locale.US));
        if (a(paramString, paramgt))
          this.a.a(localbp);
        if (this.f.a(di.a(), a(paramString), paramgt))
        {
          this.a.b(localbp);
          return;
        }
      }
      catch (Exception localException)
      {
        c.c(j, "Failed to record geofence transition.", localException);
      }
    }
  }

  public void b(boolean paramBoolean)
  {
    if (!this.h)
      c.b(j, "Appboy geofences not enabled. Not requesting geofences.");
    while (!this.f.a(paramBoolean, di.a()))
      return;
    b(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.am
 * JD-Core Version:    0.6.2
 */