package a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.appboy.e.a;
import com.appboy.f.c;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public final class dm
{
  private static final String a = c.a(dm.class);

  public static void a(Context paramContext)
  {
    c.b(a, "Deleting registered geofence cache.");
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.appboy.support.geofences", 0).edit();
    localEditor.clear();
    localEditor.apply();
  }

  public static void a(Context paramContext, PendingIntent paramPendingIntent)
  {
    try
    {
      c.b(a, "Requesting single location update from Google Play Services.");
      LocationRequest localLocationRequest = LocationRequest.create();
      localLocationRequest.setPriority(100);
      localLocationRequest.setNumUpdates(1);
      if (Looper.myLooper() == null)
        Looper.prepare();
      LocationServices.getFusedLocationProviderClient(paramContext).requestLocationUpdates(localLocationRequest, paramPendingIntent);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      c.c(a, "Failed to request location update due to security exception from insufficient permissions.", localSecurityException);
      return;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to request location update due to exception.", localException);
    }
  }

  public static void a(Context paramContext, List<a> paramList, PendingIntent paramPendingIntent)
  {
    SharedPreferences localSharedPreferences;
    List localList;
    try
    {
      localSharedPreferences = paramContext.getSharedPreferences("com.appboy.support.geofences", 0);
      localList = dl.a(localSharedPreferences);
      if (!paramList.isEmpty())
        break label222;
      localArrayList1 = new ArrayList();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
      {
        a locala1 = (a)localIterator1.next();
        localArrayList1.add(locala1.a());
        c.b(a, "Obsolete geofence will be un-registered: " + locala1.a());
      }
    }
    catch (SecurityException localSecurityException)
    {
      ArrayList localArrayList1;
      c.d(a, "Security exception while adding geofences.", localSecurityException);
      return;
      if (!localArrayList1.isEmpty())
      {
        LocationServices.getGeofencingClient(paramContext).removeGeofences(localArrayList1);
        localSharedPreferences.edit().clear().apply();
        c.b(a, "No new geofences to register. Cleared " + localList.size() + " previously registered geofences.");
        return;
      }
    }
    catch (Exception localException)
    {
      c.d(a, "Exception while adding geofences.", localException);
      return;
    }
    c.b(a, "No new geofences to register. No geofences are currently registered.");
    return;
    label222: ArrayList localArrayList2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator2 = paramList.iterator();
    a locala4;
    int i;
    Iterator localIterator6;
    if (localIterator2.hasNext())
    {
      locala4 = (a)localIterator2.next();
      localHashSet.add(locala4.a());
      i = 1;
      localIterator6 = localList.iterator();
    }
    while (true)
    {
      if (localIterator6.hasNext())
      {
        a locala5 = (a)localIterator6.next();
        if ((locala4.a().equals(locala5.a())) && (locala4.a(locala5)))
        {
          j = 0;
          break label785;
        }
      }
      else
      {
        if (i == 0)
          break;
        c.b(a, "New geofence will be registered: " + locala4.a());
        localArrayList2.add(locala4);
        break;
        ArrayList localArrayList3 = new ArrayList();
        Iterator localIterator3 = localList.iterator();
        while (localIterator3.hasNext())
        {
          a locala3 = (a)localIterator3.next();
          if (!localHashSet.contains(locala3.a()))
          {
            localArrayList3.add(locala3.a());
            c.b(a, "Obsolete geofence will be un-registered: " + locala3.a());
          }
        }
        if (!localArrayList3.isEmpty())
        {
          SharedPreferences.Editor localEditor2 = localSharedPreferences.edit();
          Iterator localIterator5 = localArrayList3.iterator();
          while (localIterator5.hasNext())
            localEditor2.remove((String)localIterator5.next());
          localEditor2.apply();
          c.b(a, "Un-registering " + localArrayList3.size() + " obsolete geofences from Google Play Services.");
          LocationServices.getGeofencingClient(paramContext).removeGeofences(localArrayList3);
        }
        while (!localArrayList2.isEmpty())
        {
          ArrayList localArrayList4 = new ArrayList();
          SharedPreferences.Editor localEditor1 = localSharedPreferences.edit();
          Iterator localIterator4 = localArrayList2.iterator();
          while (true)
            if (localIterator4.hasNext())
            {
              a locala2 = (a)localIterator4.next();
              localArrayList4.add(locala2.j());
              localEditor1.putString(locala2.a(), locala2.k().toString());
              continue;
              c.b(a, "No obsolete geofences need to be unregistered from Google Play Services.");
              break;
            }
          localEditor1.apply();
          c.b(a, "Registering " + localArrayList2.size() + " new geofences with Google Play Services.");
          b(paramContext, localArrayList4, paramPendingIntent);
          return;
        }
        c.b(a, "No new geofences need to be registered with Google Play Services.");
        return;
      }
      int j = i;
      label785: i = j;
    }
  }

  private static void b(Context paramContext, List<Geofence> paramList, PendingIntent paramPendingIntent)
  {
    GeofencingRequest localGeofencingRequest = new GeofencingRequest.Builder().addGeofences(paramList).setInitialTrigger(0).build();
    LocationServices.getGeofencingClient(paramContext).addGeofences(localGeofencingRequest, paramPendingIntent).addOnSuccessListener(new OnSuccessListener()
    {
      public void a(Void paramAnonymousVoid)
      {
        c.b(dm.a(), "Geofences successfully registered with Google Play Services.");
      }
    }).addOnFailureListener(new OnFailureListener()
    {
      public void onFailure(Exception paramAnonymousException)
      {
        if ((paramAnonymousException instanceof ApiException))
        {
          int i = ((ApiException)paramAnonymousException).getStatusCode();
          switch (i)
          {
          default:
            c.d(dm.a(), "Geofence pending result returned unknown status code: " + i);
            return;
          case 1001:
            c.d(dm.a(), "Geofences not registered with Google Play Services due to GEOFENCE_TOO_MANY_GEOFENCES: " + i);
            return;
          case 1002:
            c.d(dm.a(), "Geofences not registered with Google Play Services due to GEOFENCE_TOO_MANY_PENDING_INTENTS: " + i);
            return;
          case 1000:
            c.d(dm.a(), "Geofences not registered with Google Play Services due to GEOFENCE_NOT_AVAILABLE: " + i);
            return;
          case 0:
          }
          c.b(dm.a(), "Received Geofence registration success code in failure block with Google Play Services.");
          return;
        }
        c.d(dm.a(), "Geofence exception encountered while adding geofences.", paramAnonymousException);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dm
 * JD-Core Version:    0.6.2
 */