package a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.appboy.e.a;
import com.appboy.f.c;
import com.appboy.f.i;
import com.appboy.receivers.AppboyActionReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class dl
{
  private static final String a = c.a(dl.class);

  public static PendingIntent a(Context paramContext)
  {
    return PendingIntent.getBroadcast(paramContext, 0, new Intent("com.appboy.action.receiver.APPBOY_GEOFENCE_UPDATE").setClass(paramContext, AppboyActionReceiver.class), 134217728);
  }

  public static List<a> a(SharedPreferences paramSharedPreferences)
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap = paramSharedPreferences.getAll();
    if ((localMap == null) || (localMap.size() == 0))
    {
      c.b(a, "Did not find stored geofences.");
      return localArrayList;
    }
    Set localSet = localMap.keySet();
    if ((localSet == null) || (localSet.size() == 0))
    {
      c.d(a, "Failed to find stored geofence keys.");
      return localArrayList;
    }
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = paramSharedPreferences.getString(str1, null);
      try
      {
        if (i.c(str2))
          c.d(a, "Received null or blank serialized  geofence string for geofence id " + str1 + " from shared preferences. Not parsing.");
      }
      catch (JSONException localJSONException)
      {
        c.d(a, "Encountered Json exception while parsing stored geofence: " + str2, localJSONException);
        continue;
        localArrayList.add(new a(new JSONObject(str2)));
      }
      catch (Exception localException)
      {
        c.d(a, "Encountered unexpected exception while parsing stored geofence: " + str2, localException);
      }
    }
    return localArrayList;
  }

  public static boolean a(dd paramdd)
  {
    if (paramdd.a())
    {
      if (paramdd.b())
      {
        c.c(a, "Geofences enabled in server configuration.");
        return true;
      }
      c.c(a, "Geofences explicitly disabled via server configuration.");
      return false;
    }
    c.c(a, "Geofences implicitly disabled via server configuration.");
    return false;
  }

  public static int b(dd paramdd)
  {
    if (paramdd.e() > 0)
      return paramdd.e();
    return 20;
  }

  public static PendingIntent b(Context paramContext)
  {
    return PendingIntent.getBroadcast(paramContext, 0, new Intent("com.appboy.action.receiver.APPBOY_GEOFENCE_LOCATION_UPDATE").setClass(paramContext, AppboyActionReceiver.class), 134217728);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dl
 * JD-Core Version:    0.6.2
 */