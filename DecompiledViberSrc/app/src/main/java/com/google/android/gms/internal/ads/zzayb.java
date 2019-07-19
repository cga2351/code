package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@zzare
public final class zzayb
{
  private float zzdmf = 1.0F;
  private boolean zzdml = false;

  public static float zzba(Context paramContext)
  {
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    if (localAudioManager == null)
      return 0.0F;
    int i = localAudioManager.getStreamMaxVolume(3);
    int j = localAudioManager.getStreamVolume(3);
    if (i == 0)
      return 0.0F;
    return j / i;
  }

  private final boolean zzwj()
  {
    try
    {
      float f = this.zzdmf;
      if (f >= 0.0F)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final void setAppMuted(boolean paramBoolean)
  {
    try
    {
      this.zzdml = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setAppVolume(float paramFloat)
  {
    try
    {
      this.zzdmf = paramFloat;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final float zzpq()
  {
    try
    {
      if (zzwj())
      {
        f = this.zzdmf;
        return f;
      }
      float f = 1.0F;
    }
    finally
    {
    }
  }

  public final boolean zzpr()
  {
    try
    {
      boolean bool = this.zzdml;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayb
 * JD-Core Version:    0.6.2
 */