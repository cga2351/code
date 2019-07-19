package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.e.a;
import com.appboy.f.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class an
{
  private static final String h = c.a(an.class);
  final SharedPreferences a;
  final SharedPreferences b;
  Map<String, Long> c;
  long d;
  long e;
  int f;
  int g;

  an(Context paramContext, String paramString, dd paramdd)
  {
    this.a = paramContext.getSharedPreferences("com.appboy.managers.geofences.eligibility.global." + paramString, 0);
    this.b = paramContext.getSharedPreferences("com.appboy.managers.geofences.eligibility.individual." + paramString, 0);
    this.c = a(this.b);
    this.d = this.a.getLong("last_request_global", 0L);
    this.e = this.a.getLong("last_report_global", 0L);
    this.f = paramdd.c();
    this.g = paramdd.d();
  }

  String a(String paramString)
  {
    try
    {
      String str = paramString.split("_", 2)[1];
      return str;
    }
    catch (Exception localException)
    {
      c.b(h, "Exception trying to parse re-eligibility id: " + paramString, localException);
    }
    return null;
  }

  String a(String paramString, gt paramgt)
  {
    return paramgt.toString().toLowerCase(Locale.US) + "_" + paramString;
  }

  Map<String, Long> a(SharedPreferences paramSharedPreferences)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Map localMap = paramSharedPreferences.getAll();
    if ((localMap == null) || (localMap.size() == 0))
      return localConcurrentHashMap;
    Set localSet = localMap.keySet();
    if (localSet.size() == 0)
      return localConcurrentHashMap;
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l = paramSharedPreferences.getLong(str, 0L);
      c.b(h, "Retrieving geofence id " + a(str) + " eligibility information from local storage.");
      localConcurrentHashMap.put(str, Long.valueOf(l));
    }
    return localConcurrentHashMap;
  }

  void a(by paramby)
  {
    int i = paramby.f();
    if (i >= 0)
    {
      this.f = i;
      c.c(h, "Min time since last geofence request reset via server configuration: " + i + "s.");
    }
    int j = paramby.g();
    if (j >= 0)
    {
      this.g = j;
      c.c(h, "Min time since last geofence report reset via server configuration: " + j + "s.");
    }
  }

  void a(List<a> paramList)
  {
    HashSet localHashSet1 = new HashSet();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
      localHashSet1.add(((a)localIterator1.next()).a());
    HashSet localHashSet2 = new HashSet(this.c.keySet());
    SharedPreferences.Editor localEditor = this.b.edit();
    Iterator localIterator2 = localHashSet2.iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      if (!localHashSet1.contains(a(str)))
      {
        c.b(h, "Deleting outdated re-eligibility id " + str + " from re-eligibility list.");
        this.c.remove(str);
        localEditor.remove(str);
      }
      else
      {
        c.b(h, "Retaining re-eligibility id " + str + " in re-eligibility list.");
      }
    }
    localEditor.apply();
  }

  boolean a(long paramLong, a parama, gt paramgt)
  {
    if (parama == null)
    {
      c.d(h, "Geofence passed into getReportEligible() was null.");
      return false;
    }
    String str1 = parama.a();
    String str2 = a(str1, paramgt);
    if (paramgt.equals(gt.a));
    long l1;
    for (int i = parama.d(); ; i = parama.e())
    {
      l1 = paramLong - this.e;
      if (this.g <= l1)
        break;
      c.b(h, "Geofence report suppressed since only " + l1 + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.g + "). id:" + str1);
      return false;
    }
    if (this.c.containsKey(str2))
    {
      long l2 = paramLong - ((Long)this.c.get(str2)).longValue();
      if (i > l2)
      {
        c.b(h, "Geofence report suppressed since only " + l2 + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + i + "). id:" + str1 + " transition:" + paramgt);
        return false;
      }
      c.b(h, l2 + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + i + "). id:" + str1 + " transition:" + paramgt);
    }
    while (true)
    {
      c.b(h, "Geofence report eligible since " + l1 + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.g + "). id:" + str1);
      this.c.put(str2, Long.valueOf(paramLong));
      SharedPreferences.Editor localEditor1 = this.b.edit();
      localEditor1.putLong(str2, paramLong);
      localEditor1.apply();
      this.e = paramLong;
      SharedPreferences.Editor localEditor2 = this.a.edit();
      localEditor2.putLong("last_report_global", paramLong);
      localEditor2.apply();
      return true;
      c.b(h, "Geofence report eligible since this geofence/transition combination has never reported. id:" + str1 + " " + paramgt);
    }
  }

  protected boolean a(boolean paramBoolean, long paramLong)
  {
    long l = paramLong - this.d;
    if ((!paramBoolean) && (this.f > l))
    {
      c.b(h, "Geofence request suppressed since only " + l + " seconds have passed since the last time geofences were requested (minimum interval: " + this.f + ").");
      return false;
    }
    if (paramBoolean)
      c.b(h, "Geofence request eligible. Ignoring rate limit for this geofence request. Elapsed time since last request:" + l);
    while (true)
    {
      this.d = paramLong;
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putLong("last_request_global", this.d);
      localEditor.apply();
      return true;
      c.b(h, "Geofence request eligible since " + l + " seconds have passed since the last time geofences were requested (minimum interval: " + this.f + ").");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.an
 * JD-Core Version:    0.6.2
 */