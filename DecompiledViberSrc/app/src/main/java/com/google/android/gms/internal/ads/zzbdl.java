package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@TargetApi(16)
public final class zzbdl
{

  @VisibleForTesting
  private static int zzefe;

  @VisibleForTesting
  private static int zzeff;
  private zzge zzefg;
  private zzhd zzefh;
  private zzgn zzefi;
  private zzbdp zzefj;
  private final zzbdo zzefk = new zzbdo(this, null);
  private final zzbdq zzefl = new zzbdq(this, null);
  private final zzbdn zzefm = new zzbdn(this, null);

  public zzbdl()
  {
    Preconditions.checkMainThread("ExoPlayer must be created on the main UI thread.");
    if (zzaxa.zzvj())
    {
      String str = String.valueOf(this);
      zzaxa.zzds(29 + String.valueOf(str).length() + "AdExoPlayerHelper initialize " + str);
    }
    zzefe = 1 + zzefe;
    this.zzefg = zzgg.zzn(2);
    this.zzefg.zza(this.zzefk);
  }

  private final void zzm(String paramString1, String paramString2)
  {
    try
    {
      if (this.zzefj != null)
        this.zzefj.zzl(paramString1, paramString2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static int zzyp()
  {
    return zzefe;
  }

  public static int zzyq()
  {
    return zzeff;
  }

  public final void finalize()
    throws Throwable
  {
    zzefe = -1 + zzefe;
    if (zzaxa.zzvj())
    {
      String str = String.valueOf(this);
      zzaxa.zzds(27 + String.valueOf(str).length() + "AdExoPlayerHelper finalize " + str);
    }
  }

  public final void removeListener()
  {
    try
    {
      this.zzefj = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzbdp paramzzbdp)
  {
    try
    {
      this.zzefj = paramzzbdp;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzgh paramzzgh, zzhh paramzzhh, zzgq paramzzgq)
  {
    this.zzefk.zzb(paramzzgh);
    this.zzefl.zza(paramzzhh);
    this.zzefm.zza(paramzzgq);
  }

  public final boolean zza(zzhn paramzzhn)
  {
    if (this.zzefg == null)
      return false;
    this.zzefh = new zzhd(paramzzhn, 1, 0L, zzaxj.zzdvx, this.zzefl, -1);
    this.zzefi = new zzgn(paramzzhn, zzaxj.zzdvx, this.zzefm);
    zzhp[] arrayOfzzhp = new zzhp[2];
    arrayOfzzhp[0] = this.zzefh;
    arrayOfzzhp[1] = this.zzefi;
    this.zzefg.zza(arrayOfzzhp);
    zzeff = 1 + zzeff;
    return true;
  }

  public final void zzyr()
  {
    if (this.zzefg != null)
    {
      this.zzefg.release();
      this.zzefg = null;
      zzeff = -1 + zzeff;
    }
  }

  public final zzge zzys()
  {
    return this.zzefg;
  }

  public final zzhd zzyt()
  {
    return this.zzefh;
  }

  public final zzgn zzyu()
  {
    return this.zzefi;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdl
 * JD-Core Version:    0.6.2
 */