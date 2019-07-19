package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

public final class zzx
  implements CapabilityApi.GetAllCapabilitiesResult
{
  private final Map<String, CapabilityInfo> zzbu;
  private final Status zzp;

  public zzx(Status paramStatus, Map<String, CapabilityInfo> paramMap)
  {
    this.zzp = paramStatus;
    this.zzbu = paramMap;
  }

  public final Map<String, CapabilityInfo> getAllCapabilities()
  {
    return this.zzbu;
  }

  public final Status getStatus()
  {
    return this.zzp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzx
 * JD-Core Version:    0.6.2
 */