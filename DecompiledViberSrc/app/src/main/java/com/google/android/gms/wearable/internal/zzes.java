package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzes<T> extends zzgm<Status>
{
  private WeakReference<Map<T, zzhk<T>>> zzec;
  private WeakReference<T> zzed;

  zzes(Map<T, zzhk<T>> paramMap, T paramT, BaseImplementation.ResultHolder<Status> paramResultHolder)
  {
    super(paramResultHolder);
    this.zzec = new WeakReference(paramMap);
    this.zzed = new WeakReference(paramT);
  }

  public final void zza(Status paramStatus)
  {
    Map localMap = (Map)this.zzec.get();
    Object localObject1 = this.zzed.get();
    if ((!paramStatus.getStatus().isSuccess()) && (localMap != null) && (localObject1 != null));
    try
    {
      zzhk localzzhk = (zzhk)localMap.remove(localObject1);
      if (localzzhk != null)
        localzzhk.clear();
      zza(paramStatus);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzes
 * JD-Core Version:    0.6.2
 */