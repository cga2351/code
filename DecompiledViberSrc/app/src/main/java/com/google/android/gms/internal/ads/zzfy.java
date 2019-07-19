package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzfy extends zzfn
  implements zzfx
{
  public static zzfx zza(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
    if ((localIInterface instanceof zzfx))
      return (zzfx)localIInterface;
    return new zzfz(paramIBinder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfy
 * JD-Core Version:    0.6.2
 */