package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpo extends zzzb
{
  private final zzbjn zzgbc;
  private final Context zzgdr;
  private final zzcxw zzgds;
  private final zzbzb zzgdu;
  private final zzcpv zzgdv = new zzcpv();
  private final zzbrn zzgdw;

  @GuardedBy("this")
  private zzbpj zzgdx;

  @GuardedBy("this")
  private String zzgdy;

  @GuardedBy("this")
  private String zzgdz;

  public zzcpo(Context paramContext, zzbjn paramzzbjn, zzcxw paramzzcxw, zzbzb paramzzbzb, zzyx paramzzyx)
  {
    this.zzgdr = paramContext;
    this.zzgbc = paramzzbjn;
    this.zzgds = paramzzcxw;
    this.zzgdu = paramzzbzb;
    this.zzgdv.zzc(paramzzyx);
    this.zzgdw = new zzcpq(this.zzgdv, paramzzbzb.zzaim());
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzgdy;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean isLoading()
    throws RemoteException
  {
    try
    {
      if (this.zzgdx != null)
      {
        boolean bool2 = this.zzgdx.isLoading();
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  public final void zza(zzxx paramzzxx)
  {
    zza(paramzzxx, 1);
  }

  public final void zza(zzxx paramzzxx, int paramInt)
  {
    try
    {
      if (this.zzgds.zzamp() == null)
      {
        zzaxa.zzen("Ad unit ID should not be null for AdLoader.");
        this.zzgbc.zzace().execute(new zzcpp(this));
      }
      while (true)
      {
        return;
        zzcxz.zze(this.zzgdr, paramzzxx.zzcgr);
        this.zzgdy = null;
        this.zzgdz = null;
        zzcxu localzzcxu = this.zzgds.zzg(paramzzxx).zzdp(paramInt).zzamq();
        zzbxn localzzbxn = this.zzgbc.zzacl().zza(new zzbqx.zza().zzbt(this.zzgdr).zza(localzzcxu).zzagh()).zza(new zzbtu.zza().zza(this.zzgdv, this.zzgbc.zzace()).zza(this.zzgdw, this.zzgbc.zzace()).zza(this.zzgdv, this.zzgbc.zzace()).zza(this.zzgdv, this.zzgbc.zzace()).zza(this.zzgdv, this.zzgbc.zzace()).zza(localzzcxu.zzgli, this.zzgbc.zzace()).zzagt()).zza(new zzbxj(this.zzgdu, this.zzgdv.zzald())).zzacy();
        localzzbxn.zzadc().zzdq(1);
        this.zzgdx = localzzbxn.zzacz();
        this.zzgdx.zza(new zzcpr(this, localzzbxn));
      }
    }
    finally
    {
    }
  }

  public final String zzpj()
  {
    try
    {
      String str = this.zzgdz;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpo
 * JD-Core Version:    0.6.2
 */