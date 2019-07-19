package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzms extends zzpe
  implements zzso
{
  private long zzadb;
  private int zzafu;
  private int zzatx;
  private final zzma zzaxq = new zzma(null, null);
  private final zzmh zzaxr = new zzmh(null, paramArrayOfzzlx, new zzmu(this, null));
  private boolean zzaxs;
  private boolean zzaxt;
  private MediaFormat zzaxu;
  private boolean zzaxv;

  public zzms(zzpg paramzzpg)
  {
    this(paramzzpg, null, true);
  }

  private zzms(zzpg paramzzpg, zznj<Object> paramzznj, boolean paramBoolean)
  {
    this(paramzzpg, null, true, null, null);
  }

  private zzms(zzpg paramzzpg, zznj<Object> paramzznj, boolean paramBoolean, Handler paramHandler, zzlz paramzzlz)
  {
    this(paramzzpg, null, true, null, null, null, new zzlx[0]);
  }

  private zzms(zzpg paramzzpg, zznj<Object> paramzznj, boolean paramBoolean, Handler paramHandler, zzlz paramzzlz, zzlw paramzzlw, zzlx[] paramArrayOfzzlx)
  {
    super(1, paramzzpg, paramzznj, paramBoolean);
  }

  protected static void zzag(int paramInt)
  {
  }

  private final boolean zzbb(String paramString)
  {
    return this.zzaxr.zzaz(paramString);
  }

  protected static void zzc(int paramInt, long paramLong1, long paramLong2)
  {
  }

  protected static void zzhv()
  {
  }

  public final boolean isReady()
  {
    return (this.zzaxr.zzer()) || (super.isReady());
  }

  protected final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    throws zzku
  {
    int i = 0;
    int j;
    if (this.zzaxu != null)
    {
      j = 1;
      if (j == 0)
        break label110;
    }
    int k;
    int m;
    label110: for (String str = this.zzaxu.getString("mime"); ; str = "audio/raw")
    {
      if (j != 0)
        paramMediaFormat = this.zzaxu;
      k = paramMediaFormat.getInteger("channel-count");
      m = paramMediaFormat.getInteger("sample-rate");
      if ((!this.zzaxt) || (k != 6) || (this.zzafu >= 6))
        break label117;
      arrayOfInt = new int[this.zzafu];
      while (i < this.zzafu)
      {
        arrayOfInt[i] = i;
        i++;
      }
      j = 0;
      break;
    }
    label117: int[] arrayOfInt = null;
    try
    {
      this.zzaxr.zza(str, k, m, this.zzatx, 0, arrayOfInt);
      return;
    }
    catch (zzml localzzml)
    {
      throw zzku.zza(localzzml, getIndex());
    }
  }

  protected final void onStarted()
  {
    super.onStarted();
    this.zzaxr.play();
  }

  protected final void onStopped()
  {
    this.zzaxr.pause();
    super.onStopped();
  }

  protected final int zza(zzpg paramzzpg, zzlh paramzzlh)
    throws zzpk
  {
    String str = paramzzlh.zzatq;
    if (!zzsp.zzav(str))
      return 0;
    if (zzsy.SDK_INT >= 21);
    for (int i = 16; (zzbb(str)) && (paramzzpg.zziv() != null); i = 0)
      return 0x3 | (i | 0x4);
    zzpd localzzpd = paramzzpg.zze(str, false);
    if (localzzpd == null)
      return 1;
    if (zzsy.SDK_INT >= 21)
    {
      if (paramzzlh.zzafv != -1)
      {
        boolean bool2 = localzzpd.zzba(paramzzlh.zzafv);
        j = 0;
        if (!bool2)
          break label138;
      }
      if (paramzzlh.zzafu != -1)
      {
        boolean bool1 = localzzpd.zzbb(paramzzlh.zzafu);
        j = 0;
        if (!bool1)
          break label138;
      }
    }
    int j = 1;
    label138: if (j != 0);
    for (int k = 3; ; k = 2)
      return k | (i | 0x4);
  }

  protected final zzpd zza(zzpg paramzzpg, zzlh paramzzlh, boolean paramBoolean)
    throws zzpk
  {
    if (zzbb(paramzzlh.zzatq))
    {
      zzpd localzzpd = paramzzpg.zziv();
      if (localzzpd != null)
      {
        this.zzaxs = true;
        return localzzpd;
      }
    }
    this.zzaxs = false;
    return super.zza(paramzzpg, paramzzlh, paramBoolean);
  }

  public final void zza(int paramInt, Object paramObject)
    throws zzku
  {
    switch (paramInt)
    {
    default:
      super.zza(paramInt, paramObject);
      return;
    case 2:
      this.zzaxr.setVolume(((Float)paramObject).floatValue());
      return;
    case 3:
    }
    int i = ((Integer)paramObject).intValue();
    this.zzaxr.setStreamType(i);
  }

  protected final void zza(zzpd paramzzpd, MediaCodec paramMediaCodec, zzlh paramzzlh, MediaCrypto paramMediaCrypto)
  {
    String str = paramzzpd.name;
    if ((zzsy.SDK_INT < 24) && ("OMX.SEC.aac.dec".equals(str)) && ("samsung".equals(zzsy.MANUFACTURER)) && ((zzsy.DEVICE.startsWith("zeroflte")) || (zzsy.DEVICE.startsWith("herolte")) || (zzsy.DEVICE.startsWith("heroqlte"))));
    for (boolean bool = true; ; bool = false)
    {
      this.zzaxt = bool;
      if (!this.zzaxs)
        break;
      this.zzaxu = paramzzlh.zzen();
      this.zzaxu.setString("mime", "audio/raw");
      paramMediaCodec.configure(this.zzaxu, null, null, 0);
      this.zzaxu.setString("mime", paramzzlh.zzatq);
      return;
    }
    paramMediaCodec.configure(paramzzlh.zzen(), null, null, 0);
    this.zzaxu = null;
  }

  protected final boolean zza(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
    throws zzku
  {
    if ((this.zzaxs) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      zznc localzznc2 = this.zzbhl;
      localzznc2.zzabl = (1 + localzznc2.zzabl);
      this.zzaxr.zzeq();
      return true;
    }
    try
    {
      if (this.zzaxr.zza(paramByteBuffer, paramLong3))
      {
        paramMediaCodec.releaseOutputBuffer(paramInt1, false);
        zznc localzznc1 = this.zzbhl;
        localzznc1.zzabk = (1 + localzznc1.zzabk);
        return true;
      }
    }
    catch (zzmm localzzmm)
    {
      throw zzku.zza(localzzmm, getIndex());
      return false;
    }
    catch (zzmp localzzmp)
    {
      label108: break label108;
    }
  }

  public final zzln zzb(zzln paramzzln)
  {
    return this.zzaxr.zzb(paramzzln);
  }

  protected final void zzd(long paramLong, boolean paramBoolean)
    throws zzku
  {
    super.zzd(paramLong, paramBoolean);
    this.zzaxr.reset();
    this.zzadb = paramLong;
    this.zzaxv = true;
  }

  protected final void zzd(zzlh paramzzlh)
    throws zzku
  {
    super.zzd(paramzzlh);
    this.zzaxq.zzc(paramzzlh);
    if ("audio/raw".equals(paramzzlh.zzatq));
    for (int i = paramzzlh.zzatx; ; i = 2)
    {
      this.zzatx = i;
      this.zzafu = paramzzlh.zzafu;
      return;
    }
  }

  protected final void zzd(String paramString, long paramLong1, long paramLong2)
  {
    this.zzaxq.zzc(paramString, paramLong1, paramLong2);
  }

  public final long zzdv()
  {
    long l = this.zzaxr.zzf(zzdx());
    if (l != -9223372036854775808L)
      if (!this.zzaxv)
        break label42;
    while (true)
    {
      this.zzadb = l;
      this.zzaxv = false;
      return this.zzadb;
      label42: l = Math.max(this.zzadb, l);
    }
  }

  public final boolean zzdx()
  {
    return (super.zzdx()) && (this.zzaxr.zzdx());
  }

  protected final void zzdz()
  {
    try
    {
      this.zzaxr.release();
      try
      {
        super.zzdz();
        return;
      }
      finally
      {
        this.zzbhl.zzdk();
        this.zzaxq.zzd(this.zzbhl);
      }
    }
    finally
    {
    }
  }

  protected final void zzg(boolean paramBoolean)
    throws zzku
  {
    super.zzg(paramBoolean);
    this.zzaxq.zzc(this.zzbhl);
    int i = zzgq().zzaul;
    if (i != 0)
    {
      this.zzaxr.zzai(i);
      return;
    }
    this.zzaxr.zzhr();
  }

  public final zzso zzgj()
  {
    return this;
  }

  public final zzln zzhq()
  {
    return this.zzaxr.zzhq();
  }

  protected final void zzhw()
    throws zzku
  {
    try
    {
      this.zzaxr.zzho();
      return;
    }
    catch (zzmp localzzmp)
    {
      throw zzku.zza(localzzmp, getIndex());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzms
 * JD-Core Version:    0.6.2
 */