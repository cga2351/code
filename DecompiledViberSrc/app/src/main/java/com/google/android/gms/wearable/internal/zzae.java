package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.google.android.gms.wearable.CapabilityInfo;

final class zzae
  implements CapabilityClient.OnCapabilityChangedListener
{
  private final String zzbc;
  private final CapabilityClient.OnCapabilityChangedListener zzby;

  zzae(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString)
  {
    this.zzby = paramOnCapabilityChangedListener;
    this.zzbc = paramString;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzae localzzae;
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
      localzzae = (zzae)paramObject;
      bool2 = this.zzby.equals(localzzae.zzby);
      bool1 = false;
    }
    while (!bool2);
    return this.zzbc.equals(localzzae.zzbc);
  }

  public final int hashCode()
  {
    return 31 * this.zzby.hashCode() + this.zzbc.hashCode();
  }

  public final void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
    this.zzby.onCapabilityChanged(paramCapabilityInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzae
 * JD-Core Version:    0.6.2
 */