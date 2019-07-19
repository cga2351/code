package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemBuffer;

final class zzgw extends zzgm<DataItemBuffer>
{
  public zzgw(BaseImplementation.ResultHolder<DataItemBuffer> paramResultHolder)
  {
    super(paramResultHolder);
  }

  public final void zzb(DataHolder paramDataHolder)
  {
    zza(new DataItemBuffer(paramDataHolder));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgw
 * JD-Core Version:    0.6.2
 */