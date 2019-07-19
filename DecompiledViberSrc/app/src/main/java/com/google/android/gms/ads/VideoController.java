package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaap;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzbae;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class VideoController
{

  @KeepForSdk
  public static final int PLAYBACK_STATE_ENDED = 3;

  @KeepForSdk
  public static final int PLAYBACK_STATE_PAUSED = 2;

  @KeepForSdk
  public static final int PLAYBACK_STATE_PLAYING = 1;

  @KeepForSdk
  public static final int PLAYBACK_STATE_READY = 5;

  @KeepForSdk
  public static final int PLAYBACK_STATE_UNKNOWN;
  private final Object lock = new Object();

  @GuardedBy("lock")
  private zzaap zzaav;

  @GuardedBy("lock")
  private VideoLifecycleCallbacks zzaaw;

  public final float getAspectRatio()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return 0.0F;
    }
    try
    {
      float f = this.zzaav.getAspectRatio();
      return f;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call getAspectRatio on video controller.", localRemoteException);
    }
    return 0.0F;
  }

  @KeepForSdk
  public final int getPlaybackState()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return 0;
    }
    try
    {
      int i = this.zzaav.getPlaybackState();
      return i;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call getPlaybackState on video controller.", localRemoteException);
    }
    return 0;
  }

  public final VideoLifecycleCallbacks getVideoLifecycleCallbacks()
  {
    synchronized (this.lock)
    {
      VideoLifecycleCallbacks localVideoLifecycleCallbacks = this.zzaaw;
      return localVideoLifecycleCallbacks;
    }
  }

  public final boolean hasVideoContent()
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.zzaav != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public final boolean isClickToExpandEnabled()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return false;
    }
    try
    {
      boolean bool = this.zzaav.isClickToExpandEnabled();
      return bool;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call isClickToExpandEnabled.", localRemoteException);
    }
    return false;
  }

  public final boolean isCustomControlsEnabled()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return false;
    }
    try
    {
      boolean bool = this.zzaav.isCustomControlsEnabled();
      return bool;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call isUsingCustomPlayerControls.", localRemoteException);
    }
    return false;
  }

  public final boolean isMuted()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return true;
    }
    try
    {
      boolean bool = this.zzaav.isMuted();
      return bool;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call isMuted on video controller.", localRemoteException);
    }
    return true;
  }

  public final void mute(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return;
    }
    try
    {
      this.zzaav.mute(paramBoolean);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Unable to call mute on video controller.", localRemoteException);
    }
  }

  public final void pause()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return;
    }
    try
    {
      this.zzaav.pause();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Unable to call pause on video controller.", localRemoteException);
    }
  }

  public final void play()
  {
    synchronized (this.lock)
    {
      if (this.zzaav == null)
        return;
    }
    try
    {
      this.zzaav.play();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Unable to call play on video controller.", localRemoteException);
    }
  }

  public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks paramVideoLifecycleCallbacks)
  {
    Preconditions.checkNotNull(paramVideoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
    synchronized (this.lock)
    {
      this.zzaaw = paramVideoLifecycleCallbacks;
      if (this.zzaav == null)
        return;
    }
    try
    {
      this.zzaav.zza(new zzacb(paramVideoLifecycleCallbacks));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", localRemoteException);
    }
  }

  public final void zza(zzaap paramzzaap)
  {
    synchronized (this.lock)
    {
      this.zzaav = paramzzaap;
      if (this.zzaaw != null)
        setVideoLifecycleCallbacks(this.zzaaw);
      return;
    }
  }

  public final zzaap zzdh()
  {
    synchronized (this.lock)
    {
      zzaap localzzaap = this.zzaav;
      return localzzaap;
    }
  }

  public static class VideoLifecycleCallbacks
  {
    public void onVideoEnd()
    {
    }

    public void onVideoMute(boolean paramBoolean)
    {
    }

    public void onVideoPause()
    {
    }

    public void onVideoPlay()
    {
    }

    public void onVideoStart()
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.VideoController
 * JD-Core Version:    0.6.2
 */