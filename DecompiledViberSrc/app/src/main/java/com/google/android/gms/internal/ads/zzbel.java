package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.Executor;

@zzare
@TargetApi(16)
public final class zzbel extends zzbcp
  implements TextureView.SurfaceTextureListener, zzbfj
{
  private Surface zzaez;
  private final zzbdh zzeay;
  private final boolean zzeaz;
  private int zzebe;
  private int zzebf;
  private int zzebh;
  private int zzebi;
  private zzbde zzebj;
  private final boolean zzebk;
  private zzbco zzebm;
  private final zzbdg zzebv;
  private String[] zzeci;
  private float zzefp;
  private final zzbdf zzefr;
  private String zzeft;
  private boolean zzefu;
  private int zzefv = 1;
  private boolean zzefw;
  private boolean zzefx;
  private zzbfb zzegl;

  public zzbel(Context paramContext, zzbdh paramzzbdh, zzbdg paramzzbdg, boolean paramBoolean1, boolean paramBoolean2, zzbdf paramzzbdf)
  {
    super(paramContext);
    this.zzeaz = paramBoolean2;
    this.zzebv = paramzzbdg;
    this.zzeay = paramzzbdh;
    this.zzebk = paramBoolean1;
    this.zzefr = paramzzbdf;
    setSurfaceTextureListener(this);
    this.zzeay.zzb(this);
  }

  private final void zza(float paramFloat, boolean paramBoolean)
  {
    if (this.zzegl != null)
    {
      this.zzegl.zzb(paramFloat, paramBoolean);
      return;
    }
    zzaxa.zzep("Trying to set volume before player is initalized.");
  }

  private final void zza(Surface paramSurface, boolean paramBoolean)
  {
    if (this.zzegl != null)
    {
      this.zzegl.zza(paramSurface, paramBoolean);
      return;
    }
    zzaxa.zzep("Trying to set surface before player is initalized.");
  }

  private final void zzp(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0);
    for (float f = paramInt1 / paramInt2; ; f = 1.0F)
    {
      if (this.zzefp != f)
      {
        this.zzefp = f;
        requestLayout();
      }
      return;
    }
  }

  private final boolean zzyv()
  {
    return (this.zzegl != null) && (!this.zzefu);
  }

  private final boolean zzyw()
  {
    return (zzyv()) && (this.zzefv != 1);
  }

  private final void zzyy()
  {
    if (this.zzefw);
    do
    {
      return;
      this.zzefw = true;
      zzaxj.zzdvx.post(new zzbem(this));
      zzxk();
      this.zzeay.zzhd();
    }
    while (!this.zzefx);
    play();
  }

  private final zzbfb zzzh()
  {
    return new zzbfb(this.zzebv.getContext(), this.zzefr);
  }

  private final String zzzi()
  {
    return zzk.zzlg().zzq(this.zzebv.getContext(), this.zzebv.zzyh().zzbsy);
  }

  private final void zzzj()
  {
    if (this.zzegl != null)
      break label7;
    label7: 
    while ((this.zzeft == null) || (this.zzaez == null))
      return;
    zzbfu localzzbfu;
    if (this.zzeft.startsWith("cache:"))
    {
      localzzbfu = this.zzebv.zzet(this.zzeft);
      if ((localzzbfu instanceof zzbgq))
        this.zzegl = ((zzbgq)localzzbfu).zzaaa();
    }
    while (true)
    {
      this.zzegl.zza(this);
      zza(this.zzaez, false);
      this.zzefv = this.zzegl.zzzt().getPlaybackState();
      if (this.zzefv != 3)
        break;
      zzyy();
      return;
      if ((localzzbfu instanceof zzbgp))
      {
        zzbgp localzzbgp = (zzbgp)localzzbfu;
        String str4 = zzzi();
        ByteBuffer localByteBuffer = localzzbgp.getByteBuffer();
        boolean bool = localzzbgp.zzzv();
        String str5 = localzzbgp.getUrl();
        if (str5 == null)
        {
          zzaxa.zzep("Stream cache URL is null.");
          return;
        }
        this.zzegl = zzzh();
        zzbfb localzzbfb = this.zzegl;
        Uri[] arrayOfUri2 = new Uri[1];
        arrayOfUri2[0] = Uri.parse(str5);
        localzzbfb.zza(arrayOfUri2, str4, localByteBuffer, bool);
      }
      else
      {
        String str2 = String.valueOf(this.zzeft);
        if (str2.length() != 0);
        for (String str3 = "Stream cache miss: ".concat(str2); ; str3 = new String("Stream cache miss: "))
        {
          zzaxa.zzep(str3);
          return;
        }
        this.zzegl = zzzh();
        String str1 = zzzi();
        Uri[] arrayOfUri1 = new Uri[this.zzeci.length];
        for (int i = 0; i < this.zzeci.length; i++)
          arrayOfUri1[i] = Uri.parse(this.zzeci[i]);
        this.zzegl.zza(arrayOfUri1, str1);
      }
    }
  }

  private final void zzzk()
  {
    zzp(this.zzebe, this.zzebf);
  }

  private final void zzzl()
  {
    if (this.zzegl != null)
      this.zzegl.zzap(true);
  }

  private final void zzzm()
  {
    if (this.zzegl != null)
      this.zzegl.zzap(false);
  }

  public final int getCurrentPosition()
  {
    if (zzyw())
      return (int)this.zzegl.zzzt().zzdn();
    return 0;
  }

  public final int getDuration()
  {
    if (zzyw())
      return (int)this.zzegl.zzzt().getDuration();
    return 0;
  }

  public final int getVideoHeight()
  {
    return this.zzebf;
  }

  public final int getVideoWidth()
  {
    return this.zzebe;
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if ((this.zzefp != 0.0F) && (this.zzebj == null))
    {
      float f = i / j;
      if (this.zzefp > f)
        j = (int)(i / this.zzefp);
      if (this.zzefp < f)
        i = (int)(j * this.zzefp);
    }
    setMeasuredDimension(i, j);
    if (this.zzebj != null)
      this.zzebj.zzm(i, j);
    zzkv localzzkv;
    if (Build.VERSION.SDK_INT == 16)
      if (((this.zzebh > 0) && (this.zzebh != i)) || ((this.zzebi > 0) && (this.zzebi != j) && (this.zzeaz) && (zzyv())))
      {
        localzzkv = this.zzegl.zzzt();
        if ((localzzkv.zzdn() > 0L) && (!localzzkv.zzdm()))
          break label201;
      }
    while (true)
    {
      this.zzebh = i;
      this.zzebi = j;
      return;
      label201: zza(0.0F, true);
      localzzkv.zzd(true);
      long l1 = localzzkv.zzdn();
      long l2 = zzk.zzln().currentTimeMillis();
      while ((zzyv()) && (localzzkv.zzdn() == l1) && (zzk.zzln().currentTimeMillis() - l2 <= 250L));
      localzzkv.zzd(false);
      zzxk();
    }
  }

  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.zzebk)
    {
      this.zzebj = new zzbde(getContext());
      this.zzebj.zza(paramSurfaceTexture, paramInt1, paramInt2);
      this.zzebj.start();
      SurfaceTexture localSurfaceTexture = this.zzebj.zzxy();
      if (localSurfaceTexture != null)
        paramSurfaceTexture = localSurfaceTexture;
    }
    else
    {
      this.zzaez = new Surface(paramSurfaceTexture);
      if (this.zzegl != null)
        break label130;
      zzzj();
      label79: if ((this.zzebe != 0) && (this.zzebf != 0))
        break label156;
      zzp(paramInt1, paramInt2);
    }
    while (true)
    {
      zzaxj.zzdvx.post(new zzber(this));
      return;
      this.zzebj.zzxx();
      this.zzebj = null;
      break;
      label130: zza(this.zzaez, true);
      if (this.zzefr.zzeee)
        break label79;
      zzzl();
      break label79;
      label156: zzzk();
    }
  }

  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    pause();
    if (this.zzebj != null)
    {
      this.zzebj.zzxx();
      this.zzebj = null;
    }
    if (this.zzegl != null)
    {
      zzzm();
      if (this.zzaez != null)
        this.zzaez.release();
      this.zzaez = null;
      zza(null, true);
    }
    zzaxj.zzdvx.post(new zzbet(this));
    return true;
  }

  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.zzebj != null)
      this.zzebj.zzm(paramInt1, paramInt2);
    zzaxj.zzdvx.post(new zzbes(this, paramInt1, paramInt2));
  }

  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.zzeay.zzc(this);
    this.zzebt.zza(paramSurfaceTexture, this.zzebm);
  }

  protected final void onWindowVisibilityChanged(int paramInt)
  {
    zzaxa.zzds(57 + "AdExoPlayerView3 window visibility changed to " + paramInt);
    zzaxj.zzdvx.post(new zzbeu(this, paramInt));
    super.onWindowVisibilityChanged(paramInt);
  }

  public final void pause()
  {
    if (zzyw())
    {
      if (this.zzefr.zzeee)
        zzzm();
      this.zzegl.zzzt().zzd(false);
      this.zzeay.zzym();
      this.zzebu.zzym();
      zzaxj.zzdvx.post(new zzbeq(this));
    }
  }

  public final void play()
  {
    if (zzyw())
    {
      if (this.zzefr.zzeee)
        zzzl();
      this.zzegl.zzzt().zzd(true);
      this.zzeay.zzyl();
      this.zzebu.zzyl();
      this.zzebt.zzxm();
      zzaxj.zzdvx.post(new zzbep(this));
      return;
    }
    this.zzefx = true;
  }

  public final void seekTo(int paramInt)
  {
    if (zzyw())
      this.zzegl.zzzt().seekTo(paramInt);
  }

  public final void setVideoPath(String paramString)
  {
    if (paramString != null)
    {
      this.zzeft = paramString;
      this.zzeci = new String[] { paramString };
      zzzj();
    }
  }

  public final void stop()
  {
    if (zzyv())
    {
      this.zzegl.zzzt().stop();
      if (this.zzegl != null)
      {
        zza(null, true);
        if (this.zzegl != null)
        {
          this.zzegl.zza(null);
          this.zzegl.release();
          this.zzegl = null;
        }
        this.zzefv = 1;
        this.zzefu = false;
        this.zzefw = false;
        this.zzefx = false;
      }
    }
    this.zzeay.zzym();
    this.zzebu.zzym();
    this.zzeay.onStop();
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

  public final void zza(String paramString, Exception paramException)
  {
    String str1 = paramException.getClass().getCanonicalName();
    String str2 = paramException.getMessage();
    String str3 = 2 + String.valueOf(paramString).length() + String.valueOf(str1).length() + String.valueOf(str2).length() + paramString + "/" + str1 + ":" + str2;
    String str4 = String.valueOf(str3);
    if (str4.length() != 0);
    for (String str5 = "ExoPlayerAdapter error: ".concat(str4); ; str5 = new String("ExoPlayerAdapter error: "))
    {
      zzaxa.zzep(str5);
      this.zzefu = true;
      if (this.zzefr.zzeee)
        zzzm();
      zzaxj.zzdvx.post(new zzbeo(this, str3));
      return;
    }
  }

  public final void zzb(String paramString, String[] paramArrayOfString)
  {
    if (paramString != null)
    {
      if (paramArrayOfString == null)
        setVideoPath(paramString);
      this.zzeft = paramString;
      this.zzeci = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
      zzzj();
    }
  }

  public final void zzcy(int paramInt)
  {
    if (this.zzegl != null)
      this.zzegl.zzzu().zzdg(paramInt);
  }

  public final void zzcz(int paramInt)
  {
    if (this.zzegl != null)
      this.zzegl.zzzu().zzdh(paramInt);
  }

  public final void zzd(boolean paramBoolean, long paramLong)
  {
    if (this.zzebv != null)
      zzbbn.zzeag.execute(new zzbev(this, paramBoolean, paramLong));
  }

  public final void zzda(int paramInt)
  {
    if (this.zzegl != null)
      this.zzegl.zzzu().zzda(paramInt);
  }

  public final void zzdb(int paramInt)
  {
    if (this.zzegl != null)
      this.zzegl.zzzu().zzdb(paramInt);
  }

  public final void zzdc(int paramInt)
  {
    if (this.zzegl != null)
      this.zzegl.zzdc(paramInt);
  }

  public final void zzde(int paramInt)
  {
    if (this.zzefv != paramInt)
      this.zzefv = paramInt;
    switch (paramInt)
    {
    default:
      return;
    case 3:
      zzyy();
      return;
    case 4:
    }
    if (this.zzefr.zzeee)
      zzzm();
    this.zzeay.zzym();
    this.zzebu.zzym();
    zzaxj.zzdvx.post(new zzben(this));
  }

  public final void zzo(int paramInt1, int paramInt2)
  {
    this.zzebe = paramInt1;
    this.zzebf = paramInt2;
    zzzk();
  }

  public final String zzxg()
  {
    String str1 = String.valueOf("ExoPlayer/3");
    if (this.zzebk);
    for (String str2 = " spherical"; ; str2 = "")
    {
      String str3 = String.valueOf(str2);
      if (str3.length() == 0)
        break;
      return str1.concat(str3);
    }
    return new String(str1);
  }

  public final void zzxk()
  {
    zza(this.zzebu.getVolume(), false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbel
 * JD-Core Version:    0.6.2
 */