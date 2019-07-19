package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class zzhb extends zzgm<DataApi.DataItemResult>
{
  private final List<FutureTask<Boolean>> zzev;

  zzhb(BaseImplementation.ResultHolder<DataApi.DataItemResult> paramResultHolder, List<FutureTask<Boolean>> paramList)
  {
    super(paramResultHolder);
    this.zzev = paramList;
  }

  public final void zza(zzfu paramzzfu)
  {
    zza(new zzcg(zzgd.zzb(paramzzfu.statusCode), paramzzfu.zzdy));
    if (paramzzfu.statusCode != 0)
    {
      Iterator localIterator = this.zzev.iterator();
      while (localIterator.hasNext())
        ((FutureTask)localIterator.next()).cancel(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzhb
 * JD-Core Version:    0.6.2
 */