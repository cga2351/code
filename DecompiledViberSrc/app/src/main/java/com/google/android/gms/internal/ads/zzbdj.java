package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

@zzare
@TargetApi(14)
public final class zzbdj
  implements AudioManager.OnAudioFocusChangeListener
{
  private float zzcv = 1.0F;
  private boolean zzecb;
  private final AudioManager zzefa;
  private final zzbdk zzefb;
  private boolean zzefc;
  private boolean zzefd;

  public zzbdj(Context paramContext, zzbdk paramzzbdk)
  {
    this.zzefa = ((AudioManager)paramContext.getSystemService("audio"));
    this.zzefb = paramzzbdk;
  }

  private final void zzyo()
  {
    int i = 1;
    int j;
    if ((this.zzecb) && (!this.zzefd) && (this.zzcv > 0.0F))
    {
      j = i;
      if ((j == 0) || (this.zzefc))
        break label94;
      if ((this.zzefa != null) && (!this.zzefc))
        break label67;
      this.zzefb.zzxk();
    }
    label67: label94: 
    while ((j != 0) || (!this.zzefc))
    {
      return;
      j = 0;
      break;
      if (this.zzefa.requestAudioFocus(this, 3, 2) == i);
      while (true)
      {
        this.zzefc = i;
        break;
        i = 0;
      }
    }
    if ((this.zzefa == null) || (!this.zzefc))
    {
      this.zzefb.zzxk();
      return;
    }
    if (this.zzefa.abandonAudioFocus(this) == 0);
    while (true)
    {
      this.zzefc = i;
      break;
      i = 0;
    }
  }

  public final float getVolume()
  {
    if (this.zzefd);
    for (float f = 0.0F; this.zzefc; f = this.zzcv)
      return f;
    return 0.0F;
  }

  public final void onAudioFocusChange(int paramInt)
  {
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.zzefc = bool;
      this.zzefb.zzxk();
      return;
    }
  }

  public final void setMuted(boolean paramBoolean)
  {
    this.zzefd = paramBoolean;
    zzyo();
  }

  public final void setVolume(float paramFloat)
  {
    this.zzcv = paramFloat;
    zzyo();
  }

  public final void zzyl()
  {
    this.zzecb = true;
    zzyo();
  }

  public final void zzym()
  {
    this.zzecb = false;
    zzyo();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdj
 * JD-Core Version:    0.6.2
 */