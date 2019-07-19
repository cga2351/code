package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zak
{
  private final ArrayMap<zai<?>, ConnectionResult> zaay = new ArrayMap();
  private final ArrayMap<zai<?>, String> zada = new ArrayMap();
  private final TaskCompletionSource<Map<zai<?>, String>> zadb = new TaskCompletionSource();
  private int zadc;
  private boolean zadd = false;

  public zak(Iterable<? extends GoogleApi<?>> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      GoogleApi localGoogleApi = (GoogleApi)localIterator.next();
      this.zaay.put(localGoogleApi.zak(), null);
    }
    this.zadc = this.zaay.keySet().size();
  }

  public final Task<Map<zai<?>, String>> getTask()
  {
    return this.zadb.getTask();
  }

  public final void zaa(zai<?> paramzai, ConnectionResult paramConnectionResult, String paramString)
  {
    this.zaay.put(paramzai, paramConnectionResult);
    this.zada.put(paramzai, paramString);
    this.zadc = (-1 + this.zadc);
    if (!paramConnectionResult.isSuccess())
      this.zadd = true;
    if (this.zadc == 0)
    {
      if (this.zadd)
      {
        AvailabilityException localAvailabilityException = new AvailabilityException(this.zaay);
        this.zadb.setException(localAvailabilityException);
      }
    }
    else
      return;
    this.zadb.setResult(this.zada);
  }

  public final Set<zai<?>> zap()
  {
    return this.zaay.keySet();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zak
 * JD-Core Version:    0.6.2
 */