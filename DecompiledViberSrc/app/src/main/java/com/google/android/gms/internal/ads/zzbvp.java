package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

public final class zzbvp extends zzbtr<VideoController.VideoLifecycleCallbacks>
{

  @GuardedBy("this")
  private boolean zzelz;

  protected zzbvp(Set<zzbuy<VideoController.VideoLifecycleCallbacks>> paramSet)
  {
    super(paramSet);
  }

  public final void onVideoEnd()
  {
    zza(zzbvr.zzfka);
  }

  public final void onVideoPause()
  {
    zza(zzbvq.zzfka);
  }

  public final void onVideoPlay()
  {
    try
    {
      if (!this.zzelz)
      {
        zza(zzbvt.zzfka);
        this.zzelz = true;
      }
      zza(zzbvu.zzfka);
      return;
    }
    finally
    {
    }
  }

  public final void onVideoStart()
  {
    try
    {
      zza(zzbvs.zzfka);
      this.zzelz = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbvp
 * JD-Core Version:    0.6.2
 */