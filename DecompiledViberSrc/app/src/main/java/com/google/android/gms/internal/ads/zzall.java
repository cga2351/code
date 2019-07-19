package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public final class zzall
{
  private final Object zzddg = new Object();
  private final Object zzddh = new Object();

  @GuardedBy("lockClient")
  private zzals zzddi;

  @GuardedBy("lockService")
  private zzals zzddj;

  private static Context zzk(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null)
      return paramContext;
    return localContext;
  }

  public final zzals zza(Context paramContext, zzbaj paramzzbaj)
  {
    synchronized (this.zzddh)
    {
      if (this.zzddj == null)
      {
        Context localContext = zzk(paramContext);
        zzaci localzzaci = zzact.zzckv;
        this.zzddj = new zzals(localContext, paramzzbaj, (String)zzyr.zzpe().zzd(localzzaci));
      }
      zzals localzzals = this.zzddj;
      return localzzals;
    }
  }

  public final zzals zzb(Context paramContext, zzbaj paramzzbaj)
  {
    synchronized (this.zzddg)
    {
      if (this.zzddi == null)
      {
        Context localContext = zzk(paramContext);
        zzaci localzzaci = zzact.zzckw;
        this.zzddi = new zzals(localContext, paramzzbaj, (String)zzyr.zzpe().zzd(localzzaci));
      }
      zzals localzzals = this.zzddi;
      return localzzals;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzall
 * JD-Core Version:    0.6.2
 */