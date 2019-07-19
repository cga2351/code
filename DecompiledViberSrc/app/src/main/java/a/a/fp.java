package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class fp
  implements fm
{
  private static final String a = c.a(fp.class);
  private final SharedPreferences b;
  private Map<String, Long> c;

  public fp(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext.getSharedPreferences("com.appboy.storage.triggers.re_eligibility" + i.a(paramContext, paramString1, paramString2), 0);
    this.c = a();
  }

  private Map<String, Long> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    Map localMap = this.b.getAll();
    if ((localMap == null) || (localMap.size() == 0))
      return localConcurrentHashMap;
    Set localSet = localMap.keySet();
    if ((localSet == null) || (localSet.size() == 0))
      return localConcurrentHashMap;
    try
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long l = this.b.getLong(str, 0L);
        c.b(a, "Retrieving triggered action id " + str + " eligibility information from local storage.");
        localConcurrentHashMap.put(str, Long.valueOf(l));
      }
    }
    catch (Exception localException)
    {
      c.d(a, "Encountered unexpected exception while parsing stored re-eligibility information.", localException);
    }
    return localConcurrentHashMap;
  }

  public void a(dy paramdy, long paramLong)
  {
    c.b(a, "Updating re-eligibility for action Id " + paramdy.b() + " to time " + paramLong + ".");
    this.c.put(paramdy.b(), Long.valueOf(paramLong));
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putLong(paramdy.b(), paramLong);
    localEditor.apply();
  }

  public void a(List<dy> paramList)
  {
    HashSet localHashSet1 = new HashSet();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
      localHashSet1.add(((dy)localIterator1.next()).b());
    HashSet localHashSet2 = new HashSet(this.c.keySet());
    SharedPreferences.Editor localEditor = this.b.edit();
    Iterator localIterator2 = localHashSet2.iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      if (!localHashSet1.contains(str))
      {
        c.b(a, "Deleting outdated triggered action id " + str + " from re-eligibility list.");
        this.c.remove(str);
        localEditor.remove(str);
      }
      else
      {
        c.b(a, "Retaining triggered action " + str + " in re-eligibility list.");
      }
    }
    localEditor.apply();
  }

  public boolean a(dy paramdy)
  {
    es locales = paramdy.c().f();
    if (locales.a())
    {
      c.b(a, "Triggered action id " + paramdy.b() + " always eligible via configuration. Returning true for eligibility status");
      return true;
    }
    if (!this.c.containsKey(paramdy.b()))
    {
      c.b(a, "Triggered action id " + paramdy.b() + " always eligible via never having been triggered. Returning true for eligibility status");
      return true;
    }
    if (locales.b())
    {
      c.b(a, "Triggered action id " + paramdy.b() + " no longer eligible due to having been triggered in the past and is only eligible once.");
      return false;
    }
    long l = ((Long)this.c.get(paramdy.b())).longValue();
    if (di.a() + paramdy.c().d() >= l + locales.c().intValue())
    {
      c.b(a, "Trigger action is re-eligible for display since " + (di.a() - l) + " seconds have passed since the last time it was triggered (minimum interval: " + locales.c() + ").");
      return true;
    }
    c.b(a, "Trigger action is not re-eligible for display since only " + (di.a() - l) + " seconds have passed since the last time it was triggered (minimum interval: " + locales.c() + ").");
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fp
 * JD-Core Version:    0.6.2
 */