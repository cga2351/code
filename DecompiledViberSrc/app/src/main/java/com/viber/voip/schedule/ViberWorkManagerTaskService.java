package com.viber.voip.schedule;

import android.content.Context;
import android.os.Bundle;
import androidx.work.ListenableWorker.a;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.e.a;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ViberWorkManagerTaskService extends Worker
{
  private static final com.viber.common.a.e b = ViberEnv.getLogger();

  public ViberWorkManagerTaskService(Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
  }

  private Bundle a(androidx.work.e parame)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = parame.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((String)localEntry.getKey()).equals("operation_id"))
        a(localBundle, (String)localEntry.getKey(), localEntry.getValue());
    }
    return localBundle;
  }

  public static androidx.work.e a(int paramInt, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("operation_id", Integer.valueOf(paramInt));
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramBundle.get(str));
      }
    }
    return new e.a().a(localHashMap).a();
  }

  private void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    Class localClass = paramObject.getClass();
    if (localClass == Integer.class)
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    do
    {
      return;
      if (localClass == Long.class)
      {
        paramBundle.putLong(paramString, ((Long)paramObject).longValue());
        return;
      }
      if (localClass == String.class)
      {
        paramBundle.putString(paramString, (String)paramObject);
        return;
      }
      if (localClass == Float.class)
      {
        paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
        return;
      }
      if (localClass == Double.class)
      {
        paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
        return;
      }
      if (localClass == Boolean.class)
      {
        paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return;
      }
      if (localClass == [Ljava.lang.Integer.class)
      {
        paramBundle.putIntArray(paramString, (int[])paramObject);
        return;
      }
      if (localClass == [Ljava.lang.Long.class)
      {
        paramBundle.putLongArray(paramString, (long[])paramObject);
        return;
      }
      if (localClass == [Ljava.lang.String.class)
      {
        paramBundle.putStringArray(paramString, (String[])paramObject);
        return;
      }
      if (localClass == [Ljava.lang.Float.class)
      {
        paramBundle.putFloatArray(paramString, (float[])paramObject);
        return;
      }
      if (localClass == [Ljava.lang.Double.class)
      {
        paramBundle.putDoubleArray(paramString, (double[])paramObject);
        return;
      }
    }
    while (localClass != [Ljava.lang.Boolean.class);
    paramBundle.putBooleanArray(paramString, (boolean[])paramObject);
  }

  public ListenableWorker.a k()
  {
    androidx.work.e locale = c();
    f localf = p.a(locale.a("operation_id", -1), a());
    locale.a("re_schedule", false);
    Bundle localBundle = a(locale);
    if (localf != null)
    {
      if (localf.a(localBundle) == 0)
        return ListenableWorker.a.a();
      return ListenableWorker.a.c();
    }
    return ListenableWorker.a.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.ViberWorkManagerTaskService
 * JD-Core Version:    0.6.2
 */