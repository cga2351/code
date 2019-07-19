package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzhd extends zzgr
{
  private final zzhi zzaeu = null;
  private final zzhh zzaev;
  private final long zzaew = 0L;
  private final int zzaex = 1;
  private final int zzaey;
  private Surface zzaez;
  private boolean zzafa;
  private boolean zzafb;
  private long zzafc;
  private long zzafd;
  private int zzafe;
  private int zzaff;
  private int zzafg;
  private float zzafh;
  private int zzafi;
  private int zzafj;
  private float zzafk;

  public zzhd(zzhn paramzzhn, int paramInt1, long paramLong, Handler paramHandler, zzhh paramzzhh, int paramInt2)
  {
    this(paramzzhn, null, true, 1, 0L, null, paramHandler, paramzzhh, -1);
  }

  private zzhd(zzhn paramzzhn, zzhz paramzzhz, boolean paramBoolean, int paramInt1, long paramLong, zzhi paramzzhi, Handler paramHandler, zzhh paramzzhh, int paramInt2)
  {
    super(paramzzhn, null, true, paramHandler, paramzzhh);
    this.zzaev = paramzzhh;
    this.zzaey = -1;
    this.zzafc = -1L;
    this.zzaff = -1;
    this.zzafg = -1;
    this.zzafh = -1.0F;
    this.zzafi = -1;
    this.zzafj = -1;
    this.zzafk = -1.0F;
  }

  private final void zza(MediaCodec paramMediaCodec, int paramInt)
  {
    zzej();
    zzkp.beginSection("renderVideoBufferImmediate");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    zzkp.endSection();
    zzga localzzga = this.zzadf;
    localzzga.zzabk = (1 + localzzga.zzabk);
    this.zzafb = true;
    zzek();
  }

  private final void zzej()
  {
    if ((this.zzabq == null) || (this.zzaev == null) || ((this.zzafi == this.zzaff) && (this.zzafj == this.zzafg) && (this.zzafk == this.zzafh)))
      return;
    int i = this.zzaff;
    int j = this.zzafg;
    float f = this.zzafh;
    this.zzabq.post(new zzhe(this, i, j, f));
    this.zzafi = i;
    this.zzafj = j;
    this.zzafk = f;
  }

  private final void zzek()
  {
    if ((this.zzabq == null) || (this.zzaev == null) || (this.zzafa))
      return;
    Surface localSurface = this.zzaez;
    this.zzabq.post(new zzhf(this, localSurface));
    this.zzafa = true;
  }

  private final void zzel()
  {
    if ((this.zzabq == null) || (this.zzaev == null) || (this.zzafe == 0))
      return;
    long l1 = SystemClock.elapsedRealtime();
    int i = this.zzafe;
    long l2 = l1 - this.zzafd;
    this.zzabq.post(new zzhg(this, i, l2));
    this.zzafe = 0;
    this.zzafd = l1;
  }

  protected final boolean isReady()
  {
    if ((super.isReady()) && ((this.zzafb) || (!zzec()) || (zzeg() == 2)))
      this.zzafc = -1L;
    do
    {
      return true;
      if (this.zzafc == -1L)
        return false;
    }
    while (1000L * SystemClock.elapsedRealtime() < this.zzafc);
    this.zzafc = -1L;
    return false;
  }

  protected final void onStarted()
  {
    super.onStarted();
    this.zzafe = 0;
    this.zzafd = SystemClock.elapsedRealtime();
  }

  protected final void onStopped()
  {
    this.zzafc = -1L;
    zzel();
    super.onStopped();
  }

  protected final void seekTo(long paramLong)
    throws zzgd
  {
    super.seekTo(paramLong);
    this.zzafb = false;
    this.zzafc = -1L;
  }

  public final void zza(int paramInt, Object paramObject)
    throws zzgd
  {
    if (paramInt == 1)
    {
      Surface localSurface = (Surface)paramObject;
      if (this.zzaez != localSurface)
      {
        this.zzaez = localSurface;
        this.zzafa = false;
        int i = getState();
        if ((i == 2) || (i == 3))
        {
          zzed();
          zzea();
        }
      }
      return;
    }
    super.zza(paramInt, paramObject);
  }

  protected final void zza(MediaCodec paramMediaCodec, String paramString, MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto)
  {
    paramMediaCodec.configure(paramMediaFormat, this.zzaez, paramMediaCrypto, 0);
    paramMediaCodec.setVideoScalingMode(this.zzaex);
  }

  protected final void zza(zzhj paramzzhj, MediaFormat paramMediaFormat)
  {
    int i;
    int j;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = 1;
      if (i == 0)
        break label98;
      j = 1 + (paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left"));
      label59: this.zzaff = j;
      if (i == 0)
        break label109;
    }
    label98: label109: for (int k = 1 + (paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top")); ; k = paramMediaFormat.getInteger("height"))
    {
      this.zzafg = k;
      return;
      i = 0;
      break;
      j = paramMediaFormat.getInteger("width");
      break label59;
    }
  }

  protected final void zza(zzhk paramzzhk)
    throws zzgd
  {
    super.zza(paramzzhk);
    if (paramzzhk.zzado.zzaft == -1.0F);
    for (float f = 1.0F; ; f = paramzzhk.zzado.zzaft)
    {
      this.zzafh = f;
      return;
    }
  }

  protected final boolean zza(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      zzkp.beginSection("skipVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      zzkp.endSection();
      zzga localzzga3 = this.zzadf;
      localzzga3.zzabl = (1 + localzzga3.zzabl);
      return true;
    }
    long l1 = 1000L * SystemClock.elapsedRealtime() - paramLong2;
    long l2 = paramBufferInfo.presentationTimeUs - paramLong1 - l1;
    long l3 = System.nanoTime() + 1000L * l2;
    if (l2 < -30000L)
    {
      zzkp.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      zzkp.endSection();
      zzga localzzga2 = this.zzadf;
      localzzga2.zzabm = (1 + localzzga2.zzabm);
      this.zzafe = (1 + this.zzafe);
      if (this.zzafe == this.zzaey)
        zzel();
      return true;
    }
    if (!this.zzafb)
    {
      zza(paramMediaCodec, paramInt);
      return true;
    }
    if (getState() != 3)
      return false;
    if (zzkq.SDK_INT >= 21)
    {
      if (l2 < 50000L)
      {
        zzej();
        zzkp.beginSection("releaseOutputBufferTimed");
        paramMediaCodec.releaseOutputBuffer(paramInt, l3);
        zzkp.endSection();
        zzga localzzga1 = this.zzadf;
        localzzga1.zzabk = (1 + localzzga1.zzabk);
        this.zzafb = true;
        zzek();
        return true;
      }
    }
    else if (l2 < 30000L)
    {
      long l4;
      if (l2 > 11000L)
        l4 = l2 - 10000L;
      try
      {
        Thread.sleep(l4 / 1000L);
        zza(paramMediaCodec, paramInt);
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          Thread.currentThread().interrupt();
      }
    }
    return false;
  }

  protected final boolean zza(MediaCodec paramMediaCodec, boolean paramBoolean, zzhj paramzzhj1, zzhj paramzzhj2)
  {
    return (paramzzhj2.mimeType.equals(paramzzhj1.mimeType)) && ((paramBoolean) || ((paramzzhj1.width == paramzzhj2.width) && (paramzzhj1.height == paramzzhj2.height)));
  }

  protected final boolean zzas(String paramString)
  {
    return (zzkl.zzau(paramString).equals("video")) && (super.zzas(paramString));
  }

  protected final void zzb(long paramLong, boolean paramBoolean)
  {
    super.zzb(paramLong, paramBoolean);
    this.zzafb = false;
    if ((paramBoolean) && (this.zzaew > 0L))
      this.zzafc = (1000L * SystemClock.elapsedRealtime() + this.zzaew);
  }

  public final void zzdz()
  {
    this.zzaff = -1;
    this.zzafg = -1;
    this.zzafh = -1.0F;
    this.zzafi = -1;
    this.zzafj = -1;
    this.zzafk = -1.0F;
    super.zzdz();
  }

  protected final boolean zzeb()
  {
    return (super.zzeb()) && (this.zzaez != null) && (this.zzaez.isValid());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhd
 * JD-Core Version:    0.6.2
 */