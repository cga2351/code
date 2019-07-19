package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqi extends zzasy
{
  private zzbsr zzfsq;
  private final zzbjn zzgbc;
  private final Context zzgdr;

  @GuardedBy("this")
  private final zzcxw zzgds = new zzcxw();
  private final zzcpx zzgeh = new zzcpx();

  @GuardedBy("this")
  private zzbbi<zzcda> zzgek;

  @GuardedBy("this")
  private boolean zzgez = false;

  @GuardedBy("this")
  private zzcda zzgfc;
  private boolean zzgfg = false;
  private final zzcqb zzgfl = new zzcqb();
  private final zzcpw zzgfm = new zzcpw();

  public zzcqi(zzbjn paramzzbjn, Context paramContext)
  {
    this.zzgbc = paramzzbjn;
    this.zzgdr = paramContext;
  }

  private final boolean zzalf()
  {
    try
    {
      if (this.zzgfc != null)
      {
        boolean bool2 = this.zzgfc.isClosed();
        if (!bool2)
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

  public final void destroy()
    throws RemoteException
  {
    zzn(null);
  }

  public final Bundle getAdMetadata()
  {
    Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
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
    Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
    return zzalf();
  }

  public final void pause()
    throws RemoteException
  {
    zzl(null);
  }

  public final void resume()
    throws RemoteException
  {
    zzm(null);
  }

  public final void setAppPackageName(String paramString)
    throws RemoteException
  {
  }

  public final void setCustomData(String paramString)
    throws RemoteException
  {
    try
    {
      zzaci localzzaci = zzact.zzcox;
      boolean bool = ((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue();
      if (!bool);
      while (true)
      {
        return;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzgds.zzfv(paramString);
      }
    }
    finally
    {
    }
  }

  public final void setImmersiveMode(boolean paramBoolean)
  {
    try
    {
      Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
      this.zzgez = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setUserId(String paramString)
    throws RemoteException
  {
    try
    {
      Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
      this.zzgds.zzfu(paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void show()
    throws RemoteException
  {
    try
    {
      zzk(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzasv paramzzasv)
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
    this.zzgfl.zzb(paramzzasv);
  }

  public final void zza(zzatc paramzzatc)
    throws RemoteException
  {
    Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
    this.zzgfl.zzb(paramzzatc);
  }

  public final void zza(zzati paramzzati)
    throws RemoteException
  {
    try
    {
      Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
      this.zzgfg = false;
      if (paramzzati.zzchl == null)
      {
        zzaxa.zzen("Ad unit ID should not be null for rewarded video ad.");
        this.zzgbc.zzace().execute(new zzcqj(this));
      }
      while (true)
      {
        return;
        if ((!zzacv.zzcg(paramzzati.zzchl)) && (this.zzgek == null))
          if (zzalf())
          {
            zzaci localzzaci = zzact.zzcvi;
            if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
          }
          else
          {
            zzcxz.zze(this.zzgdr, paramzzati.zzdlm.zzcgr);
            this.zzgfc = null;
            zzcxu localzzcxu = this.zzgds.zzft(paramzzati.zzchl).zzd(zzyb.zzou()).zzg(paramzzati.zzdlm).zzamq();
            zzcde localzzcde = this.zzgbc.zzacm().zzd(new zzbqx.zza().zzbt(this.zzgdr).zza(localzzcxu).zzfg(null).zzagh()).zzd(new zzbtu.zza().zza(this.zzgfl, this.zzgbc.zzace()).zza(new zzcqm(this, this.zzgfl), this.zzgbc.zzace()).zza(this.zzgfl, this.zzgbc.zzace()).zza(this.zzgfm, this.zzgbc.zzace()).zza(this.zzgeh, this.zzgbc.zzace()).zzagt()).zzaeh();
            this.zzfsq = localzzcde.zzaei();
            this.zzgek = localzzcde.zzadu();
            zzbas.zza(this.zzgek, new zzcqk(this, localzzcde), this.zzgbc.zzace());
          }
      }
    }
    finally
    {
    }
  }

  public final void zza(zzzn paramzzzn)
  {
    Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
    this.zzgfm.zzb(new zzcql(this, paramzzzn));
  }

  final void zzalg()
  {
    this.zzgfg = true;
  }

  final void zzalh()
  {
    this.zzgfm.onAdMetadataChanged();
  }

  public final void zzk(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    while (true)
    {
      try
      {
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        zzcda localzzcda = this.zzgfc;
        if (localzzcda == null)
          return;
        Activity localActivity;
        if (paramIObjectWrapper != null)
        {
          Object localObject2 = ObjectWrapper.unwrap(paramIObjectWrapper);
          if ((localObject2 instanceof Activity))
          {
            localActivity = (Activity)localObject2;
            this.zzgfc.zzb(this.zzgez, localActivity);
            continue;
          }
        }
      }
      finally
      {
      }
      localActivity = null;
    }
  }

  public final void zzl(IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      Preconditions.checkMainThread("pause must be called on the main UI thread.");
      if (this.zzgfc != null)
        if (paramIObjectWrapper != null)
          break label35;
      label35: for (Context localContext = null; ; localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper))
      {
        this.zzgfc.zzadd().zzbp(localContext);
        return;
      }
    }
    finally
    {
    }
  }

  public final void zzm(IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      Preconditions.checkMainThread("resume must be called on the main UI thread.");
      if (this.zzgfc != null)
        if (paramIObjectWrapper != null)
          break label35;
      label35: for (Context localContext = null; ; localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper))
      {
        this.zzgfc.zzadd().zzbq(localContext);
        return;
      }
    }
    finally
    {
    }
  }

  public final void zzn(IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      Preconditions.checkMainThread("destroy must be called on the main UI thread.");
      this.zzgfm.zzb(null);
      this.zzgfg = false;
      Context localContext;
      if (this.zzgfc != null)
      {
        localContext = null;
        if (paramIObjectWrapper != null)
          break label48;
      }
      while (true)
      {
        this.zzgfc.zzadd().zzbr(localContext);
        return;
        label48: localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqi
 * JD-Core Version:    0.6.2
 */