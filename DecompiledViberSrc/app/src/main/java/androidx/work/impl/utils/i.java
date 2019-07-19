package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class i
{
  private static final String a = androidx.work.i.a("WakeLocks");
  private static final WeakHashMap<PowerManager.WakeLock, String> b = new WeakHashMap();

  public static PowerManager.WakeLock a(Context paramContext, String paramString)
  {
    PowerManager localPowerManager = (PowerManager)paramContext.getApplicationContext().getSystemService("power");
    String str = "WorkManager: " + paramString;
    PowerManager.WakeLock localWakeLock = localPowerManager.newWakeLock(1, str);
    synchronized (b)
    {
      b.put(localWakeLock, str);
      return localWakeLock;
    }
  }

  public static void a()
  {
    HashMap localHashMap = new HashMap();
    synchronized (b)
    {
      localHashMap.putAll(b);
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)localIterator.next();
        if ((localWakeLock != null) && (localWakeLock.isHeld()))
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localHashMap.get(localWakeLock);
          String str = String.format("WakeLock held for %s", arrayOfObject);
          androidx.work.i.a().d(a, str, new Throwable[0]);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.i
 * JD-Core Version:    0.6.2
 */