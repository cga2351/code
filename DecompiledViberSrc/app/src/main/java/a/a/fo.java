package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.appboy.a.b;
import com.appboy.b.a.e;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class fo
  implements fk
{
  private static final String a = c.a(fo.class);
  private final Context b;
  private final au c;
  private final d d;
  private final long e;
  private final SharedPreferences f;
  private final fj g;
  private final fm h;
  private Map<String, dy> i;
  private volatile long j = 0L;
  private final Object k = new Object();

  public fo(Context paramContext, au paramau, d paramd, b paramb, String paramString1, String paramString2)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramau;
    this.d = paramd;
    this.e = paramb.g();
    this.f = paramContext.getSharedPreferences("com.appboy.storage.triggers.actions" + i.a(paramContext, paramString1, paramString2), 0);
    this.g = new fn(paramContext, paramString2);
    this.h = new fp(paramContext, paramString1, paramString2);
    this.i = b();
  }

  static void a(au paramau, String paramString, e parame)
  {
    c.c(a, "Trigger internal timeout exceeded. Attempting to log trigger failure: " + parame);
    if (i.c(paramString))
    {
      c.b(a, "Trigger ID is null or blank. Not logging trigger failure: " + parame);
      return;
    }
    if (paramau == null)
    {
      c.e(a, "Cannot log an trigger failure because the IAppboyManager is null. Trigger failure: " + parame);
      return;
    }
    try
    {
      paramau.a(bp.a(null, null, paramString, parame));
      return;
    }
    catch (JSONException localJSONException)
    {
      c.b(a, "Failed to log trigger failure event from trigger manager.", localJSONException);
      paramau.a(localJSONException);
    }
  }

  static boolean a(ez paramez, dy paramdy, long paramLong1, long paramLong2)
  {
    if ((paramez instanceof ff))
    {
      c.b(a, "Ignoring minimum time interval between triggered actions because the trigger event is a test.");
      return true;
    }
    long l1 = di.a() + paramdy.c().d();
    int m = paramdy.c().g();
    if (m != -1)
      c.b(a, "Using override minimum display interval: " + m);
    for (long l2 = paramLong1 + m; l1 >= l2; l2 = paramLong1 + paramLong2)
    {
      c.c(a, "Minimum time interval requirement met for matched trigger. Action display time: " + l1 + " . Next viable display time: " + l2);
      return true;
    }
    c.c(a, "Minimum time interval requirement and triggered action override time interval requirement of " + paramLong2 + " not met for matched trigger. Returning null. Next viable display time: " + l2 + ". Action display time: " + l1);
    return false;
  }

  public fm a()
  {
    return this.h;
  }

  public void a(long paramLong)
  {
    this.j = paramLong;
  }

  public void a(ez paramez)
  {
    c.b(a, "New incoming <" + paramez.b() + ">. Searching for matching triggers.");
    dy localdy = b(paramez);
    if (localdy != null)
      b(paramez, localdy);
  }

  public void a(final ez paramez, dy paramdy)
  {
    c.b(a, "Trigger manager received failed triggered action with id: <" + paramdy.b() + ">. Will attempt to perform fallback triggered actions, if present.");
    fr localfr = paramdy.e();
    if (localfr == null)
    {
      c.b(a, "Triggered action has no trigger metadata and cannot fallback. Doing nothing");
      return;
    }
    final dy localdy = localfr.a();
    if (localdy == null)
    {
      c.b(a, "Triggered action has no fallback action to perform. Doing nothing");
      return;
    }
    localdy.a(localfr);
    localdy.a(this.g.a(localdy));
    long l1 = paramez.d();
    et localet = localdy.c();
    long l2 = localet.e();
    long l3 = TimeUnit.SECONDS.toMillis(localet.d());
    if (l2 != -1L);
    for (final long l4 = l2 + l1; l4 < di.c(); l4 = l1 + l3 + TimeUnit.SECONDS.toMillis(30L))
    {
      c.b(a, "Fallback trigger has expired. Trigger id: " + localdy.b());
      a(this.c, localdy.b(), e.e);
      a(paramez, localdy);
      return;
    }
    long l5 = Math.max(0L, l1 + l3 - di.c());
    c.b(a, "Performing fallback triggered action with id: <" + localdy.b() + "> with a ms delay: " + l5);
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        localdy.a(fo.a(fo.this), fo.b(fo.this), paramez, l4);
      }
    }
    , l5);
  }

  public void a(List<dy> paramList)
  {
    int m = 0;
    ff localff = new ff();
    if (paramList == null)
    {
      c.d(a, "Received a null list of triggers in registerTriggeredActions(). Doing nothing.");
      return;
    }
    while (true)
    {
      synchronized (this.k)
      {
        this.i.clear();
        SharedPreferences.Editor localEditor = this.f.edit();
        localEditor.clear();
        c.b(a, "Registering " + paramList.size() + " new triggered actions.");
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          dy localdy = (dy)localIterator.next();
          c.b(a, "Registering triggered action id " + localdy.b());
          this.i.put(localdy.b(), localdy);
          localEditor.putString(localdy.b(), ((JSONObject)localdy.h()).toString());
          if (!localdy.a(localff))
            break label296;
          n = 1;
          break label299;
        }
        localEditor.apply();
        this.h.a(paramList);
        this.g.a(paramList);
        if (m != 0)
        {
          c.c(a, "Test triggered actions found, triggering test event.");
          a(localff);
          return;
        }
      }
      c.b(a, "No test triggered actions found.");
      return;
      label296: int n = m;
      label299: m = n;
    }
  }

  dy b(ez paramez)
  {
    Object localObject1 = this.k;
    int m = -2147483648;
    while (true)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.i.values().iterator();
        localObject3 = null;
        if (localIterator.hasNext())
        {
          dy localdy = (dy)localIterator.next();
          if ((!localdy.a(paramez)) || (!this.h.a(localdy)) || (!a(paramez, localdy, this.j, this.e)))
            break label372;
          c.b(a, "Found potential triggered action for incoming trigger event. Action id " + localdy.b() + ".");
          n = localdy.c().c();
          if (n <= m)
            break label362;
          localObject5 = localdy;
          localArrayList.add(localdy);
          localObject4 = localObject5;
          break label379;
        }
        if (localObject3 == null)
        {
          c.b(a, "Failed to match triggered action for incoming <" + paramez.b() + ">.");
          return null;
        }
        localArrayList.remove(localObject3);
        localObject3.a(new fr(localArrayList));
        String str1 = a;
        StringBuilder localStringBuilder = new StringBuilder().append("Found best triggered action for incoming trigger event ");
        if (paramez.e() != null)
        {
          str2 = dr.a((JSONObject)paramez.e().h());
          c.b(str1, str2 + ".\nMatched Action id: " + localObject3.b() + ".");
          return localObject3;
        }
      }
      finally
      {
      }
      String str2 = "";
      continue;
      label362: int n = m;
      Object localObject5 = localObject3;
      continue;
      label372: n = m;
      Object localObject4 = localObject3;
      label379: m = n;
      Object localObject3 = localObject4;
    }
  }

  Map<String, dy> b()
  {
    HashMap localHashMap = new HashMap();
    Map localMap = this.f.getAll();
    if ((localMap == null) || (localMap.size() == 0))
      return localHashMap;
    Set localSet = localMap.keySet();
    if ((localSet == null) || (localSet.size() == 0))
      return localHashMap;
    try
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        str2 = this.f.getString(str1, null);
        if (!i.c(str2))
          break label160;
        c.d(a, "Received null or blank serialized triggered action string for action id " + str1 + " from shared preferences. Not parsing.");
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        String str2;
        c.d(a, "Encountered Json exception while parsing stored triggered actions.", localJSONException);
        return localHashMap;
        dy localdy = fs.b(new JSONObject(str2), this.c);
        if (localdy != null)
        {
          localHashMap.put(localdy.b(), localdy);
          c.b(a, "Retrieving templated triggered action id " + localdy.b() + " from local storage.");
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
        label160: c.d(a, "Encountered unexpected exception while parsing stored triggered actions.", localException);
    }
  }

  void b(final ez paramez, final dy paramdy)
  {
    paramdy.a(this.g.a(paramdy));
    et localet = paramdy.c();
    if (localet.e() != -1);
    for (final long l = paramez.d() + localet.e(); ; l = -1L)
    {
      Handler localHandler = new Handler(Looper.getMainLooper());
      int m = localet.d();
      c.b(a, "Performing triggered action after a delay of " + m + " seconds.");
      localHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          paramdy.a(fo.a(fo.this), fo.b(fo.this), paramez, l);
        }
      }
      , m * 1000);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fo
 * JD-Core Version:    0.6.2
 */