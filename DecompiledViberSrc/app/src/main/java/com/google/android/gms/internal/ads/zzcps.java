package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzcps extends zzzj
  implements zzbte
{
  private final ViewGroup zzfgt;
  private final zzbjn zzgbc;

  @GuardedBy("this")
  private zzbne zzgdo;
  private final Context zzgdr;

  @GuardedBy("this")
  private final zzcxw zzgds = new zzcxw();
  private final zzcpv zzgef = new zzcpv();
  private final zzcpu zzgeg = new zzcpu();
  private final zzcpx zzgeh = new zzcpx();
  private final zzbta zzgei;

  @GuardedBy("this")
  private zzadn zzgej;

  @GuardedBy("this")
  private zzbbi<zzbne> zzgek;

  public zzcps(zzbjn paramzzbjn, Context paramContext, zzyb paramzzyb, String paramString)
  {
    this.zzfgt = new FrameLayout(paramContext);
    this.zzgbc = paramzzbjn;
    this.zzgdr = paramContext;
    this.zzgds.zzd(paramzzyb).zzft(paramString);
    this.zzgei = paramzzbjn.zzacg();
    this.zzgei.zza(this, this.zzgbc.zzace());
  }

  private final zzbob zzb(zzcxu paramzzcxu)
  {
    try
    {
      zzbob localzzbob = this.zzgbc.zzacj().zzb(new zzbqx.zza().zzbt(this.zzgdr).zza(paramzzcxu).zzagh()).zzb(new zzbtu.zza().zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgeg, this.zzgbc.zzace()).zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgef, this.zzgbc.zzace()).zza(this.zzgeh, this.zzgbc.zzace()).zzagt()).zza(new zzcov(this.zzgej)).zzb(new zzbxj(zzbzb.zzfpd, null)).zza(new zzbow(this.zzgei)).zza(new zzbnb(this.zzfgt)).zzads();
      return localzzbob;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void destroy()
  {
    try
    {
      Preconditions.checkMainThread("destroy must be called on the main UI thread.");
      if (this.zzgdo != null)
        this.zzgdo.destroy();
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
      zzbne localzzbne = this.zzgdo;
      if (localzzbne == null);
      String str;
      for (Object localObject2 = null; ; localObject2 = str)
      {
        return localObject2;
        str = this.zzgdo.getMediationAdapterClassName();
      }
    }
    finally
    {
    }
  }

  public final zzaap getVideoController()
  {
    try
    {
      Preconditions.checkMainThread("getVideoController must be called from the main thread.");
      if (this.zzgdo != null)
      {
        zzaap localzzaap2 = this.zzgdo.getVideoController();
        localzzaap1 = localzzaap2;
        return localzzaap1;
      }
      zzaap localzzaap1 = null;
    }
    finally
    {
    }
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
    return false;
  }

  public final void pause()
  {
    try
    {
      Preconditions.checkMainThread("pause must be called on the main UI thread.");
      if (this.zzgdo != null)
        this.zzgdo.zzafy().zzbp(null);
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
      if (this.zzgdo != null)
        this.zzgdo.zzafy().zzbq(null);
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
      Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
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
  }

  public final void zza(zzyb paramzzyb)
  {
    try
    {
      Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
      this.zzgds.zzd(paramzzyb);
      if (this.zzgdo != null)
        this.zzgdo.zza(this.zzfgt, paramzzyb);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzyu paramzzyu)
  {
    Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
    this.zzgeg.zzb(paramzzyu);
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

  public final void zzagk()
  {
    try
    {
      ViewParent localViewParent = this.zzfgt.getParent();
      boolean bool;
      if (!(localViewParent instanceof View))
      {
        bool = false;
        if (!bool)
          break label61;
        zzb(this.zzgds.zzamo());
      }
      while (true)
      {
        return;
        View localView = (View)localViewParent;
        bool = zzk.zzlg().zza(localView, localView.getContext());
        break;
        label61: this.zzgei.zzdk(60);
      }
    }
    finally
    {
    }
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
      zzbbi localzzbbi = this.zzgek;
      if (localzzbbi != null);
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        zzcxz.zze(this.zzgdr, paramzzxx.zzcgr);
        zzbob localzzbob = zzb(this.zzgds.zzg(paramzzxx).zzamq());
        this.zzgek = localzzbob.zzadu();
        zzbas.zza(this.zzgek, new zzcpt(this, localzzbob), this.zzgbc.zzace());
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
      zzbne localzzbne = this.zzgdo;
      if (localzzbne == null);
      String str;
      for (Object localObject2 = null; ; localObject2 = str)
      {
        return localObject2;
        str = this.zzgdo.zzpj();
      }
    }
    finally
    {
    }
  }

  public final IObjectWrapper zzpl()
  {
    Preconditions.checkMainThread("destroy must be called on the main UI thread.");
    return ObjectWrapper.wrap(this.zzfgt);
  }

  public final void zzpm()
  {
    try
    {
      Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
      if (this.zzgdo != null)
        this.zzgdo.zzpm();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzyb zzpn()
  {
    try
    {
      Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
      zzyb localzzyb2;
      if (this.zzgdo != null)
        localzzyb2 = zzcxx.zza(this.zzgdr, Collections.singletonList(this.zzgdo.zzafj()));
      zzyb localzzyb1;
      for (Object localObject2 = localzzyb2; ; localObject2 = localzzyb1)
      {
        return localObject2;
        localzzyb1 = this.zzgds.zzpn();
      }
    }
    finally
    {
    }
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcps
 * JD-Core Version:    0.6.2
 */