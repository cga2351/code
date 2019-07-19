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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.nio.ByteBuffer;
import javax.annotation.ParametersAreNonnullByDefault;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.SideEffectFree;

@zzare
@ParametersAreNonnullByDefault
@TargetApi(16)
public final class zzbdr extends zzbcp
  implements TextureView.SurfaceTextureListener
{
  private Surface zzaez;
  private float zzaft;
  private final zzbdh zzeay;
  private final boolean zzeaz;
  private int zzebe;
  private int zzebf;
  private int zzebh;
  private int zzebi;
  private zzbde zzebj;
  private boolean zzebk;
  private zzbco zzebm;
  private final zzbdg zzebv;
  private zzge zzefg;
  private zzhd zzefh;
  private zzgn zzefi;
  private float zzefp;
  private final int zzefq;
  private final zzbdf zzefr;
  private zzbdl zzefs;
  private String zzeft;
  private boolean zzefu;
  private int zzefv = 1;
  private boolean zzefw;
  private boolean zzefx;
  private final zzgh zzefy = new zzbef(this);
  private final zzhh zzefz = new zzbeg(this);
  private final zzgq zzega = new zzbeh(this);
  private final Context zzlj;

  public zzbdr(Context paramContext, zzbdh paramzzbdh, zzbdg paramzzbdg, int paramInt, boolean paramBoolean1, boolean paramBoolean2, zzbdf paramzzbdf)
  {
    super(paramContext);
    this.zzlj = paramContext;
    this.zzeaz = paramBoolean2;
    this.zzebv = paramzzbdg;
    this.zzefq = paramInt;
    this.zzeay = paramzzbdh;
    this.zzebk = paramBoolean1;
    this.zzefr = paramzzbdf;
    setSurfaceTextureListener(this);
    this.zzeay.zzb(this);
  }

  @SideEffectFree
  private final void zza(float paramFloat, boolean paramBoolean)
  {
    if ((this.zzefg != null) && (this.zzefi != null))
    {
      if (paramBoolean)
      {
        this.zzefg.zzb(this.zzefi, 1, Float.valueOf(paramFloat));
        return;
      }
      this.zzefg.zza(this.zzefi, 1, Float.valueOf(paramFloat));
      return;
    }
    zzaxa.zzep("Trying to set volume before player and renderers are initalized.");
  }

  @SideEffectFree
  private final void zza(Surface paramSurface, boolean paramBoolean)
  {
    if ((this.zzefg != null) && (this.zzefh != null))
    {
      if (paramBoolean)
      {
        this.zzefg.zzb(this.zzefh, 1, paramSurface);
        return;
      }
      this.zzefg.zza(this.zzefh, 1, paramSurface);
      return;
    }
    zzaxa.zzep("Trying to set surface before player and renderers are initalized.");
  }

  private final void zzb(int paramInt1, int paramInt2, float paramFloat)
  {
    if (paramInt2 == 0);
    for (float f = 1.0F; ; f = paramFloat * paramInt1 / paramInt2)
    {
      if (this.zzefp != f)
      {
        this.zzefp = f;
        requestLayout();
      }
      return;
    }
  }

  private final void zzn(String paramString1, String paramString2)
  {
    zzaxa.zzep(19 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "Error received: " + paramString1 + " : " + paramString2);
    this.zzefu = true;
    if (this.zzefr.zzeee)
      zzza();
    zzaxj.zzdvx.post(new zzbdz(this, paramString1, paramString2));
  }

  private final void zzyk()
  {
    zzaxa.zzds("Video ended.");
    if (this.zzefr.zzeee)
      zzza();
    this.zzeay.zzym();
    this.zzebu.zzym();
    zzaxj.zzdvx.post(new zzbdy(this));
  }

  @EnsuresNonNullIf(expression={"mPlayer"}, result=true)
  private final boolean zzyv()
  {
    return (this.zzefg != null) && (!this.zzefu);
  }

  @EnsuresNonNullIf(expression={"mPlayer"}, result=true)
  private final boolean zzyw()
  {
    return (zzyv()) && (this.zzefv != 1);
  }

  private final void zzyx()
  {
    int i = 1;
    label9: if (this.zzefg != null)
      break label9;
    while ((this.zzeft == null) || (this.zzaez == null))
      return;
    Object localObject2;
    label101: String str2;
    label141: ByteBuffer localByteBuffer;
    String str6;
    Object localObject5;
    zzig localzzig;
    label278: label334: zzjt localzzjt2;
    if (this.zzeft.startsWith("cache:"))
    {
      zzbfu localzzbfu = this.zzebv.zzet(this.zzeft);
      if ((localzzbfu != null) && ((localzzbfu instanceof zzbgm)))
      {
        zzbgm localzzbgm = (zzbgm)localzzbfu;
        localzzbgm.zzzx();
        localObject2 = localzzbgm.zzzy();
        ((zzbdl)localObject2).zza(this.zzefy, this.zzefz, this.zzega);
        this.zzefs = ((zzbdl)localObject2);
        if (this.zzefs != null)
          break label827;
        String str1 = String.valueOf(this.zzeft);
        if (str1.length() == 0)
          break label812;
        str2 = "AdExoPlayerHelper is null. Source: ".concat(str1);
        zzaxa.zzep(str2);
        return;
      }
      if ((localzzbfu instanceof zzbgh))
      {
        zzbgh localzzbgh = (zzbgh)localzzbfu;
        localByteBuffer = localzzbgh.getByteBuffer();
        str6 = localzzbgh.getUrl();
        boolean bool = localzzbgh.zzzv();
        zzbdl localzzbdl2 = new zzbdl();
        if ("video/webm".equals(null));
        for (localObject5 = new zzjg(); ; localObject5 = new zziv())
        {
          if ((!bool) || (localByteBuffer.limit() <= 0))
            break label334;
          byte[] arrayOfByte2 = new byte[localByteBuffer.limit()];
          localByteBuffer.get(arrayOfByte2);
          zzjo localzzjo = new zzjo(arrayOfByte2);
          localzzig = new zzig(Uri.parse(str6), localzzjo, (zzid)localObject5, 2, this.zzefr.zzeeg);
          localzzbdl2.zza(this.zzefy, this.zzefz, this.zzega);
          if (!localzzbdl2.zza(localzzig))
            zzn("AdExoPlayerHelper Error", "Prepare from ByteBuffer failed.");
          localObject2 = localzzbdl2;
          break;
        }
        String str7 = zzk.zzlg().zzq(this.zzebv.getContext(), this.zzebv.zzyh().zzbsy);
        localzzjt2 = new zzjt(this.zzebv.getContext(), str7);
        zzaci localzzaci2 = zzact.zzcts;
        if (!((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
          break label916;
      }
    }
    label648: label916: for (Object localObject6 = new zzbei(this.zzlj, localzzjt2, new zzbdt(this)); ; localObject6 = localzzjt2)
    {
      byte[] arrayOfByte1;
      if (localByteBuffer.limit() > 0)
      {
        arrayOfByte1 = new byte[localByteBuffer.limit()];
        localByteBuffer.get(arrayOfByte1);
      }
      for (Object localObject7 = new zzbek(new zzjo(arrayOfByte1), arrayOfByte1.length, (zzjp)localObject6); ; localObject7 = localObject6)
      {
        localzzig = new zzig(Uri.parse(str6), (zzjp)localObject7, (zzid)localObject5, 2, this.zzefr.zzeeg);
        break label278;
        String str4 = String.valueOf(this.zzeft);
        if (str4.length() != 0);
        for (String str5 = "Source is MD5 but not found in cache. Source: ".concat(str4); ; str5 = new String("Source is MD5 but not found in cache. Source: "))
        {
          zzaxa.zzep(str5);
          localObject2 = null;
          break;
        }
        Object localObject1;
        if (this.zzefq == i)
        {
          localObject1 = new zzgl(this.zzebv.getContext(), Uri.parse(this.zzeft), null, 2);
          zzbdl localzzbdl1 = new zzbdl();
          localzzbdl1.zza(this.zzefy, this.zzefz, this.zzega);
          if (!localzzbdl1.zza((zzhn)localObject1))
            zzn("AdExoPlayerHelper Error", "Prepare failed.");
          localObject2 = localzzbdl1;
          break label101;
        }
        zzjt localzzjt1;
        if (this.zzefq == 2)
        {
          Preconditions.checkArgument(i);
          String str3 = zzk.zzlg().zzq(this.zzebv.getContext(), this.zzebv.zzyh().zzbsy);
          localzzjt1 = new zzjt(this.zzebv.getContext(), str3);
          zzaci localzzaci1 = zzact.zzcts;
          if (!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
            break label902;
        }
        for (Object localObject3 = new zzbei(this.zzlj, localzzjt1, new zzbds(this)); ; localObject3 = localzzjt1)
        {
          if ("video/webm".equals(null));
          for (Object localObject4 = new zzjg(); ; localObject4 = new zziv())
          {
            localObject1 = new zzig(Uri.parse(this.zzeft), (zzjp)localObject3, (zzid)localObject4, 2, this.zzefr.zzeeg);
            break;
            int j = 0;
            break label648;
          }
          label812: str2 = new String("AdExoPlayerHelper is null. Source: ");
          break label141;
          label827: this.zzefg = this.zzefs.zzys();
          this.zzefh = this.zzefs.zzyt();
          this.zzefi = this.zzefs.zzyu();
          if (this.zzefg == null)
            break;
          zza(this.zzaez, false);
          this.zzefv = this.zzefg.getPlaybackState();
          if (this.zzefv != 4)
            break;
          zzyy();
          return;
        }
      }
    }
  }

  private final void zzyy()
  {
    if (this.zzefw);
    do
    {
      return;
      this.zzefw = true;
      zzaxa.zzds("Video is ready.");
      zzaxj.zzdvx.post(new zzbdx(this));
      zzxk();
      this.zzeay.zzhd();
    }
    while (!this.zzefx);
    play();
  }

  private final void zzyz()
  {
    if (this.zzefg != null)
      this.zzefg.zzc(0, true);
  }

  private final void zzza()
  {
    if (this.zzefg != null)
      this.zzefg.zzc(0, false);
  }

  public final int getCurrentPosition()
  {
    if (zzyw())
      return (int)this.zzefg.zzdn();
    return 0;
  }

  public final int getDuration()
  {
    if (zzyw())
      return (int)this.zzefg.getDuration();
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
    float f2;
    if ((this.zzefp != 0.0F) && (this.zzebj == null))
    {
      float f1 = i / j;
      f2 = this.zzefp / f1 - 1.0F;
      if (f2 <= 0.01F)
        break label284;
      j = (int)(i / this.zzefp);
    }
    while (true)
    {
      setMeasuredDimension(i, j);
      if (this.zzebj != null)
        this.zzebj.zzm(i, j);
      if (Build.VERSION.SDK_INT == 16)
      {
        if (((this.zzebh > 0) && (this.zzebh != i)) || ((this.zzebi > 0) && (this.zzebi != j) && (this.zzeaz) && (zzyv()) && (this.zzefg.zzdn() > 0L) && (!this.zzefg.zzdm())))
        {
          zza(0.0F, true);
          this.zzefg.zzd(true);
          long l1 = this.zzefg.zzdn();
          long l2 = zzk.zzln().currentTimeMillis();
          while ((zzyv()) && (this.zzefg.zzdn() == l1) && (zzk.zzln().currentTimeMillis() - l2 <= 250L));
          if (zzyv())
            this.zzefg.zzd(false);
          zzxk();
        }
        this.zzebh = i;
        this.zzebi = j;
      }
      return;
      label284: if (f2 < -0.01F)
        i = (int)(j * this.zzefp);
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
      if (this.zzefg != null)
        break label151;
      zzyx();
    }
    while (true)
    {
      float f = 1.0F;
      if ((this.zzebe != 0) && (this.zzebf != 0))
      {
        paramInt1 = this.zzebe;
        paramInt2 = this.zzebf;
        f = this.zzaft;
      }
      zzb(paramInt1, paramInt2, f);
      zzaxj.zzdvx.post(new zzbec(this));
      return;
      this.zzebj.zzxx();
      this.zzebj = null;
      break;
      label151: zza(this.zzaez, true);
      if (!this.zzefr.zzeee)
        zzyz();
    }
  }

  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    zzaxa.zzds("Surface destroyed");
    pause();
    if (this.zzebj != null)
    {
      this.zzebj.zzxx();
      this.zzebj = null;
    }
    if (this.zzefg != null)
    {
      zzza();
      if (this.zzaez != null)
        this.zzaez.release();
      this.zzaez = null;
      zza(null, true);
    }
    zzaxj.zzdvx.post(new zzbee(this));
    return true;
  }

  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.zzebj != null)
      this.zzebj.zzm(paramInt1, paramInt2);
    zzaxj.zzdvx.post(new zzbed(this, paramInt1, paramInt2));
  }

  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    this.zzeay.zzc(this);
    this.zzebt.zza(paramSurfaceTexture, this.zzebm);
  }

  protected final void onWindowVisibilityChanged(int paramInt)
  {
    zzaxa.zzds(57 + "AdExoPlayerView1 window visibility changed to " + paramInt);
    zzaxj.zzdvx.post(new zzbdu(this, paramInt));
    super.onWindowVisibilityChanged(paramInt);
  }

  public final void pause()
  {
    if (zzyw())
    {
      if (this.zzefr.zzeee)
        zzza();
      this.zzefg.zzd(false);
      this.zzeay.zzym();
      this.zzebu.zzym();
      zzaxj.zzdvx.post(new zzbeb(this));
    }
  }

  public final void play()
  {
    if (zzyw())
    {
      if (this.zzefr.zzeee)
        zzyz();
      this.zzefg.zzd(true);
      this.zzeay.zzyl();
      this.zzebu.zzyl();
      this.zzebt.zzxm();
      zzaxj.zzdvx.post(new zzbea(this));
      return;
    }
    this.zzefx = true;
  }

  public final void seekTo(int paramInt)
  {
    if (zzyw())
      this.zzefg.seekTo(paramInt);
  }

  public final void setVideoPath(String paramString)
  {
    if (paramString != null)
    {
      this.zzeft = paramString;
      zzyx();
      return;
    }
    zzaxa.zzep("Path is null.");
  }

  public final void stop()
  {
    if (zzyv())
    {
      this.zzefg.stop();
      if (this.zzefg != null)
      {
        zza(null, true);
        if (this.zzefs != null)
        {
          this.zzefs.zzyr();
          this.zzefs = null;
        }
        this.zzefg = null;
        this.zzefh = null;
        this.zzefi = null;
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

  public final String zzxg()
  {
    String str1;
    if (this.zzefq == 1)
    {
      str1 = "/Framework";
      if (!this.zzebk)
        break label121;
    }
    label121: for (String str2 = " spherical"; ; str2 = "")
    {
      return 11 + String.valueOf(str1).length() + String.valueOf(str2).length() + "ExoPlayer/1" + str1 + str2;
      if (this.zzefq == 2)
      {
        str1 = 12 + String.valueOf(null).length() + "/Extractor(" + null + ")";
        break;
      }
      str1 = "/Unknown";
      break;
    }
  }

  public final void zzxk()
  {
    zza(this.zzebu.getVolume(), false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdr
 * JD-Core Version:    0.6.2
 */