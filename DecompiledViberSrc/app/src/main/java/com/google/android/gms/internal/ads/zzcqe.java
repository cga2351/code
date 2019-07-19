package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqe extends zzatv
{
  private final String zzchl;

  @Nullable
  private zzbsr zzfsq;
  private final zzbjn zzgbc;

  @GuardedBy("this")
  private final zzcxw zzgds;

  @Nullable
  @GuardedBy("this")
  private zzbbi<zzcda> zzgek;

  @Nullable
  @GuardedBy("this")
  private zzcda zzgfc;
  private final zzcpz zzgfd = new zzcpz();
  private final zzcqa zzgfe = new zzcqa();
  private final zzcpy zzgff = new zzcpy();
  private boolean zzgfg = false;
  private final Context zzlj;

  public zzcqe(zzbjn paramzzbjn, Context paramContext, String paramString)
  {
    zzcxw localzzcxw = new zzcxw();
    localzzcxw.zzglj.add("new_rewarded");
    this.zzgds = localzzcxw;
    this.zzgbc = paramzzbjn;
    this.zzlj = paramContext;
    this.zzchl = paramString;
  }

  public final Bundle getAdMetadata()
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    if ((this.zzgfg) && (this.zzfsq != null))
      return this.zzfsq.getAdMetadata();
    return new Bundle();
  }

  public final String getMediationAdapterClassName()
    throws RemoteException
  {
    try
    {
      if (this.zzgfc != null)
      {
        String str2 = this.zzgfc.getMediationAdapterClassName();
        str1 = str2;
        return str1;
      }
      String str1 = null;
    }
    finally
    {
    }
  }

  public final boolean isLoaded()
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    return this.zzgfg;
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, boolean paramBoolean)
    throws RemoteException
  {
    try
    {
      Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
      if (this.zzgfc == null)
      {
        zzaxa.zzep("Rewarded can not be shown before loaded");
        this.zzgfd.zzcs(2);
      }
      while (true)
      {
        return;
        Activity localActivity = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
        this.zzgfc.zzb(paramBoolean, localActivity);
      }
    }
    finally
    {
    }
  }

  public final void zza(zzaam paramzzaam)
    throws RemoteException
  {
    this.zzgff.zzb(new zzcqg(this, paramzzaam));
  }

  public final void zza(zzatx paramzzatx)
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    this.zzgfd.zzb(paramzzatx);
  }

  public final void zza(zzauf paramzzauf)
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    this.zzgfd.zzb(paramzzauf);
  }

  public final void zza(zzaun paramzzaun)
    throws RemoteException
  {
    try
    {
      Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
      this.zzgds.zzfu(paramzzaun.zzdqu);
      zzaci localzzaci = zzact.zzcox;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        this.zzgds.zzfv(paramzzaun.zzdqv);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzxx paramzzxx, zzauc paramzzauc)
  {
    try
    {
      Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
      this.zzgfe.zza(paramzzauc);
      this.zzgfg = false;
      zzbbi localzzbbi = this.zzgek;
      if (localzzbbi != null);
      while (true)
      {
        return;
        if (this.zzgfc == null)
        {
          zzcxz.zze(this.zzlj, paramzzxx.zzcgr);
          zzcxu localzzcxu = this.zzgds.zzft(this.zzchl).zzd(zzyb.zzou()).zzg(paramzzxx).zzamq();
          zzcde localzzcde = this.zzgbc.zzacm().zzd(new zzbqx.zza().zzbt(this.zzlj).zza(localzzcxu).zzagh()).zzd(new zzbtu.zza().zza(this.zzgfd, this.zzgbc.zzace()).zza(new zzcqh(this, this.zzgfe), this.zzgbc.zzace()).zza(this.zzgfe, this.zzgbc.zzace()).zza(this.zzgfd, this.zzgbc.zzace()).zza(this.zzgff, this.zzgbc.zzace()).zza(new zzcpx(), this.zzgbc.zzace()).zzagt()).zzaeh();
          this.zzfsq = localzzcde.zzaei();
          this.zzgek = localzzcde.zzadu();
          zzbas.zza(this.zzgek, new zzcqf(this, localzzcde), this.zzgbc.zzace());
        }
      }
    }
    finally
    {
    }
  }

  final void zzalg()
  {
    this.zzgfg = true;
  }

  final void zzalh()
  {
    this.zzgff.onAdMetadataChanged();
  }

  public final void zzj(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    try
    {
      zza(paramIObjectWrapper, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public final zzatr zzqh()
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    if ((this.zzgfg) && (this.zzgfc != null))
      return this.zzgfc.zzqh();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqe
 * JD-Core Version:    0.6.2
 */