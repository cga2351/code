package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzbmf
  implements zzbrk, zzbrv, zzbsq, zzxp
{
  private final zzcxt zzffc;
  private final zzdad zzffd;
  private final zzcxl zzffe;

  @GuardedBy("this")
  private boolean zzfff;

  @GuardedBy("this")
  private boolean zzffg;

  public zzbmf(zzcxt paramzzcxt, zzcxl paramzzcxl, zzdad paramzzdad)
  {
    this.zzffc = paramzzcxt;
    this.zzffe = paramzzcxl;
    this.zzffd = paramzzdad;
  }

  public final void onAdClicked()
  {
    this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzdfg);
  }

  public final void onAdClosed()
  {
  }

  public final void onAdImpression()
  {
    try
    {
      if (!this.zzffg)
      {
        this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzdfh);
        this.zzffg = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onAdLeftApplication()
  {
  }

  public final void onAdLoaded()
  {
    try
    {
      if (this.zzfff)
      {
        ArrayList localArrayList = new ArrayList(this.zzffe.zzdfh);
        localArrayList.addAll(this.zzffe.zzgka);
        this.zzffd.zza(this.zzffc, this.zzffe, true, localArrayList);
      }
      while (true)
      {
        this.zzfff = true;
        return;
        this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzgkc);
        this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzgka);
      }
    }
    finally
    {
    }
  }

  public final void onAdOpened()
  {
  }

  public final void onRewardedVideoCompleted()
  {
    this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzgkb);
  }

  public final void onRewardedVideoStarted()
  {
    this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzdoa);
  }

  public final void zzb(zzass paramzzass, String paramString1, String paramString2)
  {
    this.zzffd.zza(this.zzffc, this.zzffe, this.zzffe.zzdob, paramzzass);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmf
 * JD-Core Version:    0.6.2
 */