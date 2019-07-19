package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.MeasureSpec;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzare
@TargetApi(14)
public final class zzbce extends zzbcp
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener
{
  private static final Map<Integer, String> zzeax = new HashMap();
  private final zzbdh zzeay;
  private final boolean zzeaz;
  private int zzeba = 0;
  private int zzebb = 0;
  private MediaPlayer zzebc;
  private Uri zzebd;
  private int zzebe;
  private int zzebf;
  private int zzebg;
  private int zzebh;
  private int zzebi;
  private zzbde zzebj;
  private boolean zzebk;
  private int zzebl;
  private zzbco zzebm;

  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      zzeax.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
      zzeax.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
      zzeax.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
      zzeax.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
      zzeax.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
    }
    zzeax.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
    zzeax.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
    zzeax.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
    zzeax.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
    zzeax.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
    zzeax.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
    zzeax.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
    zzeax.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
    zzeax.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
    if (Build.VERSION.SDK_INT >= 19)
    {
      zzeax.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
      zzeax.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }
  }

  public zzbce(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, zzbdf paramzzbdf, zzbdh paramzzbdh)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.zzeay = paramzzbdh;
    this.zzebk = paramBoolean1;
    this.zzeaz = paramBoolean2;
    this.zzeay.zzb(this);
  }

  private final void zzam(boolean paramBoolean)
  {
    zzaxa.zzds("AdMediaPlayerView release");
    if (this.zzebj != null)
    {
      this.zzebj.zzxx();
      this.zzebj = null;
    }
    if (this.zzebc != null)
    {
      this.zzebc.reset();
      this.zzebc.release();
      this.zzebc = null;
      zzcw(0);
      if (paramBoolean)
      {
        this.zzebb = 0;
        this.zzebb = 0;
      }
    }
  }

  private final void zzcw(int paramInt)
  {
    if (paramInt == 3)
    {
      this.zzeay.zzyl();
      this.zzebu.zzyl();
    }
    while (true)
    {
      this.zzeba = paramInt;
      return;
      if (this.zzeba == 3)
      {
        this.zzeay.zzym();
        this.zzebu.zzym();
      }
    }
  }

  private final void zzd(float paramFloat)
  {
    if (this.zzebc != null);
    try
    {
      this.zzebc.setVolume(paramFloat, paramFloat);
      return;
      zzaxa.zzep("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  private final void zzxh()
  {
    zzaxa.zzds("AdMediaPlayerView init MediaPlayer");
    SurfaceTexture localSurfaceTexture1 = getSurfaceTexture();
    if ((this.zzebd == null) || (localSurfaceTexture1 == null))
      return;
    zzam(false);
    try
    {
      zzk.zzlw();
      this.zzebc = new MediaPlayer();
      this.zzebc.setOnBufferingUpdateListener(this);
      this.zzebc.setOnCompletionListener(this);
      this.zzebc.setOnErrorListener(this);
      this.zzebc.setOnInfoListener(this);
      this.zzebc.setOnPreparedListener(this);
      this.zzebc.setOnVideoSizeChangedListener(this);
      this.zzebg = 0;
      if (this.zzebk)
      {
        this.zzebj = new zzbde(getContext());
        this.zzebj.zza(localSurfaceTexture1, getWidth(), getHeight());
        this.zzebj.start();
        localSurfaceTexture2 = this.zzebj.zzxy();
        if (localSurfaceTexture2 != null)
        {
          this.zzebc.setDataSource(getContext(), this.zzebd);
          zzk.zzlx();
          Surface localSurface = new Surface(localSurfaceTexture2);
          this.zzebc.setSurface(localSurface);
          this.zzebc.setAudioStreamType(3);
          this.zzebc.setScreenOnWhilePlaying(true);
          this.zzebc.prepareAsync();
          zzcw(1);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        String str = String.valueOf(this.zzebd);
        zzaxa.zzd(36 + String.valueOf(str).length() + "Failed to initialize MediaPlayer at " + str, localIOException);
        onError(this.zzebc, 1, 0);
        return;
        this.zzebj.zzxx();
        this.zzebj = null;
        SurfaceTexture localSurfaceTexture2 = localSurfaceTexture1;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label223;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label223: break label223;
    }
  }

  private final void zzxi()
  {
    if (!this.zzeaz);
    while ((!zzxj()) || (this.zzebc.getCurrentPosition() <= 0) || (this.zzebb == 3))
      return;
    zzaxa.zzds("AdMediaPlayerView nudging MediaPlayer");
    zzd(0.0F);
    this.zzebc.start();
    int i = this.zzebc.getCurrentPosition();
    long l = zzk.zzln().currentTimeMillis();
    while ((zzxj()) && (this.zzebc.getCurrentPosition() == i) && (zzk.zzln().currentTimeMillis() - l <= 250L));
    this.zzebc.pause();
    zzxk();
  }

  private final boolean zzxj()
  {
    return (this.zzebc != null) && (this.zzeba != -1) && (this.zzeba != 0) && (this.zzeba != 1);
  }

  public final int getCurrentPosition()
  {
    if (zzxj())
      return this.zzebc.getCurrentPosition();
    return 0;
  }

  public final int getDuration()
  {
    if (zzxj())
      return this.zzebc.getDuration();
    return -1;
  }

  public final int getVideoHeight()
  {
    if (this.zzebc != null)
      return this.zzebc.getVideoHeight();
    return 0;
  }

  public final int getVideoWidth()
  {
    if (this.zzebc != null)
      return this.zzebc.getVideoWidth();
    return 0;
  }

  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.zzebg = paramInt;
  }

  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    zzaxa.zzds("AdMediaPlayerView completion");
    zzcw(5);
    this.zzebb = 5;
    zzaxj.zzdvx.post(new zzbch(this));
  }

  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    String str1 = (String)zzeax.get(Integer.valueOf(paramInt1));
    String str2 = (String)zzeax.get(Integer.valueOf(paramInt2));
    zzaxa.zzep(38 + String.valueOf(str1).length() + String.valueOf(str2).length() + "AdMediaPlayerView MediaPlayer error: " + str1 + ":" + str2);
    zzcw(-1);
    this.zzebb = -1;
    zzaxj.zzdvx.post(new zzbci(this, str1, str2));
    return true;
  }

  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    String str1 = (String)zzeax.get(Integer.valueOf(paramInt1));
    String str2 = (String)zzeax.get(Integer.valueOf(paramInt2));
    zzaxa.zzds(37 + String.valueOf(str1).length() + String.valueOf(str2).length() + "AdMediaPlayerView MediaPlayer info: " + str1 + ":" + str2);
    return true;
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getDefaultSize(this.zzebe, paramInt1);
    int j = getDefaultSize(this.zzebf, paramInt2);
    int k;
    int m;
    int n;
    if ((this.zzebe > 0) && (this.zzebf > 0) && (this.zzebj == null))
    {
      k = View.MeasureSpec.getMode(paramInt1);
      m = View.MeasureSpec.getSize(paramInt1);
      n = View.MeasureSpec.getMode(paramInt2);
      j = View.MeasureSpec.getSize(paramInt2);
      if ((k != 1073741824) || (n != 1073741824))
        break label226;
      if (j * this.zzebe >= m * this.zzebf)
        break label189;
      i = j * this.zzebe / this.zzebf;
    }
    label392: 
    while (true)
    {
      setMeasuredDimension(i, j);
      if (this.zzebj != null)
        this.zzebj.zzm(i, j);
      if (Build.VERSION.SDK_INT == 16)
      {
        if (((this.zzebh > 0) && (this.zzebh != i)) || ((this.zzebi > 0) && (this.zzebi != j)))
          zzxi();
        this.zzebh = i;
        this.zzebi = j;
      }
      return;
      label189: if (j * this.zzebe > m * this.zzebf)
      {
        j = m * this.zzebf / this.zzebe;
        i = m;
        continue;
        label226: int i3;
        if (k == 1073741824)
        {
          i3 = m * this.zzebf / this.zzebe;
          if ((n == -2147483648) && (i3 > j))
            i = m;
        }
        else if (n == 1073741824)
        {
          i = j * this.zzebe / this.zzebf;
          if ((k == -2147483648) && (i > m))
            i = m;
        }
        else
        {
          int i1 = this.zzebe;
          int i2 = this.zzebf;
          if ((n == -2147483648) && (i2 > j));
          for (i = j * this.zzebe / this.zzebf; ; i = i1)
          {
            if ((k != -2147483648) || (i <= m))
              break label392;
            j = m * this.zzebf / this.zzebe;
            i = m;
            break;
            j = i2;
          }
          continue;
          j = i3;
          i = m;
        }
      }
      else
      {
        i = m;
      }
    }
  }

  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    zzaxa.zzds("AdMediaPlayerView prepared");
    zzcw(2);
    this.zzeay.zzhd();
    zzaxj.zzdvx.post(new zzbcg(this));
    this.zzebe = paramMediaPlayer.getVideoWidth();
    this.zzebf = paramMediaPlayer.getVideoHeight();
    if (this.zzebl != 0)
      seekTo(this.zzebl);
    zzxi();
    int i = this.zzebe;
    int j = this.zzebf;
    zzaxa.zzeo(62 + "AdMediaPlayerView stream dimensions: " + i + " x " + j);
    if (this.zzebb == 3)
      play();
    zzxk();
  }

  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    zzaxa.zzds("AdMediaPlayerView surface created");
    zzxh();
    zzaxj.zzdvx.post(new zzbcj(this));
  }

  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    zzaxa.zzds("AdMediaPlayerView surface destroyed");
    if ((this.zzebc != null) && (this.zzebl == 0))
      this.zzebl = this.zzebc.getCurrentPosition();
    if (this.zzebj != null)
      this.zzebj.zzxx();
    zzaxj.zzdvx.post(new zzbcl(this));
    zzam(true);
    return true;
  }

  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    int i = 1;
    zzaxa.zzds("AdMediaPlayerView surface changed");
    int j;
    if (this.zzebb == 3)
    {
      j = i;
      if ((this.zzebe != paramInt1) || (this.zzebf != paramInt2))
        break label113;
    }
    while (true)
    {
      if ((this.zzebc != null) && (j != 0) && (i != 0))
      {
        if (this.zzebl != 0)
          seekTo(this.zzebl);
        play();
      }
      if (this.zzebj != null)
        this.zzebj.zzm(paramInt1, paramInt2);
      zzaxj.zzdvx.post(new zzbck(this, paramInt1, paramInt2));
      return;
      j = 0;
      break;
      label113: i = 0;
    }
  }

  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.zzeay.zzc(this);
    this.zzebt.zza(paramSurfaceTexture, this.zzebm);
  }

  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    zzaxa.zzds(57 + "AdMediaPlayerView size changed: " + paramInt1 + " x " + paramInt2);
    this.zzebe = paramMediaPlayer.getVideoWidth();
    this.zzebf = paramMediaPlayer.getVideoHeight();
    if ((this.zzebe != 0) && (this.zzebf != 0))
      requestLayout();
  }

  protected final void onWindowVisibilityChanged(int paramInt)
  {
    zzaxa.zzds(58 + "AdMediaPlayerView window visibility changed to " + paramInt);
    zzaxj.zzdvx.post(new zzbcf(this, paramInt));
    super.onWindowVisibilityChanged(paramInt);
  }

  public final void pause()
  {
    zzaxa.zzds("AdMediaPlayerView pause");
    if ((zzxj()) && (this.zzebc.isPlaying()))
    {
      this.zzebc.pause();
      zzcw(4);
      zzaxj.zzdvx.post(new zzbcn(this));
    }
    this.zzebb = 4;
  }

  public final void play()
  {
    zzaxa.zzds("AdMediaPlayerView play");
    if (zzxj())
    {
      this.zzebc.start();
      zzcw(3);
      this.zzebt.zzxm();
      zzaxj.zzdvx.post(new zzbcm(this));
    }
    this.zzebb = 3;
  }

  public final void seekTo(int paramInt)
  {
    zzaxa.zzds(34 + "AdMediaPlayerView seek " + paramInt);
    if (zzxj())
    {
      this.zzebc.seekTo(paramInt);
      this.zzebl = 0;
      return;
    }
    this.zzebl = paramInt;
  }

  public final void setVideoPath(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    zzvt localzzvt = zzvt.zze(localUri);
    if ((localzzvt == null) || (localzzvt.url != null))
      if (localzzvt != null)
        break label48;
    while (true)
    {
      this.zzebd = localUri;
      this.zzebl = 0;
      zzxh();
      requestLayout();
      invalidate();
      return;
      label48: localUri = Uri.parse(localzzvt.url);
    }
  }

  public final void stop()
  {
    zzaxa.zzds("AdMediaPlayerView stop");
    if (this.zzebc != null)
    {
      this.zzebc.stop();
      this.zzebc.release();
      this.zzebc = null;
      zzcw(0);
      this.zzebb = 0;
    }
    this.zzeay.onStop();
  }

  public final String toString()
  {
    String str1 = getClass().getName();
    String str2 = Integer.toHexString(hashCode());
    return 1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + "@" + str2;
  }

  public final void zza(float paramFloat1, float paramFloat2)
  {
    if (this.zzebj != null)
      this.zzebj.zzb(paramFloat1, paramFloat2);
  }

  public final void zza(zzbco paramzzbco)
  {
    this.zzebm = paramzzbco;
  }

  public final String zzxg()
  {
    if (this.zzebk);
    for (String str1 = " spherical"; ; str1 = "")
    {
      String str2 = String.valueOf(str1);
      if (str2.length() == 0)
        break;
      return "MediaPlayer".concat(str2);
    }
    return new String("MediaPlayer");
  }

  public final void zzxk()
  {
    zzd(this.zzebu.getVolume());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbce
 * JD-Core Version:    0.6.2
 */