package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbjj extends zzfn
  implements zzbji
{
  public static zzbji zzal(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
    if ((localIInterface instanceof zzbji))
      return (zzbji)localIInterface;
    return new zzbjk(paramIBinder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjj
 * JD-Core Version:    0.6.2
 */