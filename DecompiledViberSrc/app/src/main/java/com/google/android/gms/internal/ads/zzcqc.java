package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzcqc extends zzzj
{
  private final Executor zzffu;
  private final zzbjn zzgbc;
  private final Context zzgdr;

  @GuardedBy("this")
  private final zzcxw zzgds = new zzcxw();
  private final zzcpv zzgef = new zzcpv();
  private final zzcpx zzgeh = new zzcpx();

  @GuardedBy("this")
  private zzadn zzgej;

  @GuardedBy("this")
  private zzbbi<zzbvw> zzgek;
  private final zzcqb zzgex = new zzcqb();

  @GuardedBy("this")
  private zzbvw zzgey;

  @GuardedBy("this")
  private boolean zzgez = false;

  public zzcqc(zzbjn paramzzbjn, Context paramContext, zzyb paramzzyb, String paramString)
  {
    this.zzgbc = paramzzbjn;
    this.zzgds.zzd(paramzzyb).zzft(paramString);
    this.zzffu = paramzzbjn.zzace();
    this.zzgdr = paramContext;
  }

  private final boolean zzalf()
  {
    try
    {
      if (this.zzgey != null)
      {
        boolean bool2 = this.zzgey.isClosed();
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
  {
    try
    {
      Preconditions.checkMainThread("destroy must be called on the main UI thread.");
      if (this.zzgey != null)
        this.zzgey.zzadd().zzbr(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final Bundle getAdMetadata()
  {
    Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
    return new Bundle();
  }

  public final String getAdUnitId()
  {
    try
    {
      String str = this.zzgds.zzamp();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      zzbvw localzzbvw = this.zzgey;
      if (localzzbvw == null);
      String str;
      for (Object localObject2 = null; ; localObject2 = str)
      {
        return localObject2;
        str = this.zzgey.getMediationAdapterClassName();
      }
    }
    finally
    {
    }
  }

  public final zzaap getVideoController()
  {
    return null;
  }

  public final boolean isLoading()
  {
    try
    {
      if (this.zzgek != null)
      {
        boolean bool2 = this.zzgek.isDone();
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

  public final boolean isReady()
  {
    try
    {
      Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
      boolean bool = zzalf();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void pause()
  {
    try
    {
      Preconditions.checkMainThread("pause must be called on the main UI thread.");
      if (this.zzgey != null)
        this.zzgey.zzadd().zzbp(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void resume()
  {
    try
    {
      Preconditions.checkMainThread("resume must be called on the main UI thread.");
      if (this.zzgey != null)
        this.zzgey.zzadd().zzbq(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
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

  public final void setManualImpressionsEnabled(boolean paramBoolean)
  {
    try
    {
      Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
      this.zzgds.zzbc(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setUserId(String paramString)
  {
  }

  public final void showInterstitial()
  {
    try
    {
      Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
      zzbvw localzzbvw = this.zzgey;
      if (localzzbvw == null);
      while (true)
      {
        return;
        if (this.zzgey.zzagz())
          this.zzgey.show(this.zzgez);
      }
    }
    finally
    {
    }
  }

  public final void stopLoading()
  {
  }

  public final void zza(zzaav paramzzaav)
  {
  }

  public final void zza(zzacc paramzzacc)
  {
    try
    {
      this.zzgds.zzc(paramzzacc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzadn paramzzadn)
  {
    try
    {
      Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
      this.zzgej = paramzzadn;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzaqo paramzzaqo)
  {
  }

  public final void zza(zzaqu paramzzaqu, String paramString)
  {
  }

  public final void zza(zzatc paramzzatc)
  {
    this.zzgex.zzb(paramzzatc);
  }

  public final void zza(zzyb paramzzyb)
  {
  }

  public final void zza(zzyu paramzzyu)
  {
  }

  public final void zza(zzzn paramzzzn)
  {
    Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
  }

  public final void zza(zzzq paramzzzq)
  {
    Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
    this.zzgeh.zzb(paramzzzq);
  }

  public final void zzb(zzyx paramzzyx)
  {
    Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
    this.zzgef.zzc(paramzzyx);
  }

  public final void zzb(zzzw paramzzzw)
  {
    try
    {
      Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
      this.zzgds.zzd(paramzzzw);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean zzb(zzxx paramzzxx)
  {
    try
    {
      Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
      if (this.zzgek == null)
      {
        boolean bool2 = zzalf();
        if (!bool2)
          break label31;
      }
      for (boolean bool1 = false; ; bool1 = true)
      {
        return bool1;
        label31: zzcxz.zze(this.zzgdr, paramzzxx.zzcgr);
        this.zzgey = null;
        zzcxu localzzcxu = this.zzgds.zzg(paramzzxx).zzamq();
        zzbtu.zza localzza = new zzbtu.zza();
        if (this.zzgex != null)
          localzza.zza(this.zzgex, this.zzgbc.zzace()).zza(this.zzgex, this.zzgbc.zzace()).zza(this.zzgex, this.zzgbc.zzace());
        zzbwr localzzbwr = this.zzgbc.zzack().zzc(new zzbqx.zza().zzbt(this.zzgdr).zza(localzzcxu).zzagh()).zzc(localzza.zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgeh, this.zzgbc.zzace()).zzagt()).zzb(new zzcov(this.zzgej)).zzaed();
        this.zzgek = localzzbwr.zzadu();
        zzbas.zza(this.zzgek, new zzcqd(this, localzzbwr), this.zzffu);
      }
    }
    finally
    {
    }
  }

  public final void zzbt(String paramString)
  {
  }

  public final String zzpj()
  {
    try
    {
      zzbvw localzzbvw = this.zzgey;
      if (localzzbvw == null);
      String str;
      for (Object localObject2 = null; ; localObject2 = str)
      {
        return localObject2;
        str = this.zzgey.zzpj();
      }
    }
    finally
    {
    }
  }

  public final IObjectWrapper zzpl()
  {
    return null;
  }

  public final void zzpm()
  {
  }

  public final zzyb zzpn()
  {
    return null;
  }

  public final zzzq zzpo()
  {
    return this.zzgeh.zzale();
  }

  public final zzyx zzpp()
  {
    return this.zzgef.zzald();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcqc
 * JD-Core Version:    0.6.2
 */