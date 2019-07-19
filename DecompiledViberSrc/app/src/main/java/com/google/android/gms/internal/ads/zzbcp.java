package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@zzare
@TargetApi(14)
public abstract class zzbcp extends TextureView
  implements zzbdk
{
  protected final zzbcz zzebt = new zzbcz();
  protected final zzbdj zzebu = new zzbdj(paramContext, this);

  public zzbcp(Context paramContext)
  {
    super(paramContext);
  }

  public abstract int getCurrentPosition();

  public abstract int getDuration();

  public abstract int getVideoHeight();

  public abstract int getVideoWidth();

  public abstract void pause();

  public abstract void play();

  public abstract void seekTo(int paramInt);

  public abstract void setVideoPath(String paramString);

  public abstract void stop();

  public abstract void zza(float paramFloat1, float paramFloat2);

  public abstract void zza(zzbco paramzzbco);

  public void zzb(String paramString, String[] paramArrayOfString)
  {
    setVideoPath(paramString);
  }

  public void zzcy(int paramInt)
  {
  }

  public void zzcz(int paramInt)
  {
  }

  public void zzda(int paramInt)
  {
  }

  public void zzdb(int paramInt)
  {
  }

  public void zzdc(int paramInt)
  {
  }

  public abstract String zzxg();

  public abstract void zzxk();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcp
 * JD-Core Version:    0.6.2
 */