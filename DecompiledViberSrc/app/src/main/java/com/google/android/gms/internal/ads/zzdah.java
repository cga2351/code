package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzdah extends zzfn
  implements zzdag
{
  public static zzdag zzam(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
    if ((localIInterface instanceof zzdag))
      return (zzdag)localIInterface;
    return new zzdai(paramIBinder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdah
 * JD-Core Version:    0.6.2
 */