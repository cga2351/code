package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityInfo;

final class zzv
  implements CapabilityApi.CapabilityListener
{
  private final String zzbc;
  private final CapabilityApi.CapabilityListener zzbs;

  zzv(CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    this.zzbs = paramCapabilityListener;
    this.zzbc = paramString;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzv localzzv;
    boolean bool2;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool1;
          bool1 = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool1 = false;
      }
      while (localClass1 != localClass2);
      localzzv = (zzv)paramObject;
      bool2 = this.zzbs.equals(localzzv.zzbs);
      bool1 = false;
    }
    while (!bool2);
    return this.zzbc.equals(localzzv.zzbc);
  }

  public final int hashCode()
  {
    return 31 * this.zzbs.hashCode() + this.zzbc.hashCode();
  }

  public final void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
    this.zzbs.onCapabilityChanged(paramCapabilityInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzv
 * JD-Core Version:    0.6.2
 */