package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;

final class zzgr extends zzgm<CapabilityApi.GetCapabilityResult>
{
  public zzgr(BaseImplementation.ResultHolder<CapabilityApi.GetCapabilityResult> paramResultHolder)
  {
    super(paramResultHolder);
  }

  public final void zza(zzdk paramzzdk)
  {
    Status localStatus = zzgd.zzb(paramzzdk.statusCode);
    if (paramzzdk.zzdq == null);
    for (Object localObject = null; ; localObject = new zzw(paramzzdk.zzdq))
    {
      zza(new zzy(localStatus, (CapabilityInfo)localObject));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgr
 * JD-Core Version:    0.6.2
 */