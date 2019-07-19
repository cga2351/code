package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;

public final class zzacb extends zzaat
{
  private final VideoController.VideoLifecycleCallbacks zzaaw;

  public zzacb(VideoController.VideoLifecycleCallbacks paramVideoLifecycleCallbacks)
  {
    this.zzaaw = paramVideoLifecycleCallbacks;
  }

  public final void onVideoEnd()
  {
    this.zzaaw.onVideoEnd();
  }

  public final void onVideoMute(boolean paramBoolean)
  {
    this.zzaaw.onVideoMute(paramBoolean);
  }

  public final void onVideoPause()
  {
    this.zzaaw.onVideoPause();
  }

  public final void onVideoPlay()
  {
    this.zzaaw.onVideoPlay();
  }

  public final void onVideoStart()
  {
    this.zzaaw.onVideoStart();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzacb
 * JD-Core Version:    0.6.2
 */