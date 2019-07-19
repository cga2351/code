package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzes extends zzfk
{
  public zzes(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 24);
  }

  private final void zzda()
  {
    AdvertisingIdClient localAdvertisingIdClient = this.zzvd.zzct();
    if (localAdvertisingIdClient == null);
    while (true)
    {
      return;
      try
      {
        AdvertisingIdClient.Info localInfo = localAdvertisingIdClient.getInfo();
        String str = zzef.zzap(localInfo.getId());
        if (str != null)
          synchronized (this.zzzm)
          {
            this.zzzm.zzaf(str);
            this.zzzm.zzb(localInfo.isLimitAdTrackingEnabled());
            this.zzzm.zzb(zzbp.zza.zzc.zzhu);
            return;
          }
      }
      catch (IOException localIOException)
      {
      }
    }
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.zzvd.zzcl())
    {
      zzda();
      return;
    }
    synchronized (this.zzzm)
    {
      zzbp.zza.zza localzza2 = this.zzzm;
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.zzvd.getContext();
      localzza2.zzaf((String)localMethod.invoke(null, arrayOfObject));
      return;
    }
  }

  public final Void zzcz()
    throws Exception
  {
    if (this.zzvd.isInitialized())
      return super.zzcz();
    if (this.zzvd.zzcl())
      zzda();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzes
 * JD-Core Version:    0.6.2
 */