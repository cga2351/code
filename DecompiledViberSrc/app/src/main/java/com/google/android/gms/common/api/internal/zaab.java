package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zaab
{
  private final Map<BasePendingResult<?>, Boolean> zafj = Collections.synchronizedMap(new WeakHashMap());
  private final Map<TaskCompletionSource<?>, Boolean> zafk = Collections.synchronizedMap(new WeakHashMap());

  private final void zaa(boolean paramBoolean, Status paramStatus)
  {
    HashMap localHashMap1;
    synchronized (this.zafj)
    {
      localHashMap1 = new HashMap(this.zafj);
    }
    HashMap localHashMap2;
    synchronized (this.zafk)
    {
      localHashMap2 = new HashMap(this.zafk);
      Iterator localIterator1 = localHashMap1.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
        if ((paramBoolean) || (((Boolean)localEntry2.getValue()).booleanValue()))
        {
          ((BasePendingResult)localEntry2.getKey()).zab(paramStatus);
          continue;
          localObject1 = finally;
          throw localObject1;
        }
      }
    }
    Iterator localIterator2 = localHashMap2.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      if ((paramBoolean) || (((Boolean)localEntry1.getValue()).booleanValue()))
        ((TaskCompletionSource)localEntry1.getKey()).trySetException(new ApiException(paramStatus));
    }
  }

  final void zaa(BasePendingResult<? extends Result> paramBasePendingResult, boolean paramBoolean)
  {
    this.zafj.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zaac(this, paramBasePendingResult));
  }

  final <TResult> void zaa(TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean)
  {
    this.zafk.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zaad(this, paramTaskCompletionSource));
  }

  final boolean zaag()
  {
    return (!this.zafj.isEmpty()) || (!this.zafk.isEmpty());
  }

  public final void zaah()
  {
    zaa(false, GoogleApiManager.zahw);
  }

  public final void zaai()
  {
    zaa(true, zacp.zakw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaab
 * JD-Core Version:    0.6.2
 */