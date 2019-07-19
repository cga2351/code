package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzgr extends zzhp
{
  protected final Handler zzabq;
  private long zzadb;
  public final zzga zzadf;
  private final zzhz zzadg;
  private final boolean zzadh;
  private final zzhn zzadi;
  private final zzhm zzadj;
  private final zzhk zzadk;
  private final List<Long> zzadl;
  private final MediaCodec.BufferInfo zzadm;
  private final zzgw zzadn;
  private zzhj zzado;
  private zzhw zzadp;
  private MediaCodec zzadq;
  private boolean zzadr;
  private ByteBuffer[] zzads;
  private ByteBuffer[] zzadt;
  private long zzadu;
  private int zzadv;
  private int zzadw;
  private boolean zzadx;
  private boolean zzady;
  private int zzadz;
  private int zzaea;
  private boolean zzaeb;
  private int zzaec;
  private int zzaed;
  private boolean zzaee;
  private boolean zzaef;
  private boolean zzaeg;
  private boolean zzaeh;

  public zzgr(zzhn paramzzhn, zzhz paramzzhz, boolean paramBoolean, Handler paramHandler, zzgw paramzzgw)
  {
    if (zzkq.SDK_INT >= 16);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.zzadi = paramzzhn;
      this.zzadg = null;
      this.zzadh = true;
      this.zzabq = paramHandler;
      this.zzadn = paramzzgw;
      this.zzadf = new zzga();
      this.zzadj = new zzhm(0);
      this.zzadk = new zzhk();
      this.zzadl = new ArrayList();
      this.zzadm = new MediaCodec.BufferInfo();
      this.zzadz = 0;
      this.zzaea = 0;
      return;
    }
  }

  private final void zza(MediaCodec.CryptoException paramCryptoException)
  {
    if ((this.zzabq != null) && (this.zzadn != null))
      this.zzabq.post(new zzgt(this, paramCryptoException));
  }

  private final void zza(zzgv paramzzgv)
    throws zzgd
  {
    if ((this.zzabq != null) && (this.zzadn != null))
      this.zzabq.post(new zzgs(this, paramzzgv));
    throw new zzgd(paramzzgv);
  }

  private final boolean zze(boolean paramBoolean)
    throws IOException, zzgd
  {
    if ((this.zzaee) || (this.zzaea == 2))
      return false;
    if (this.zzadv < 0)
    {
      this.zzadv = this.zzadq.dequeueInputBuffer(0L);
      if (this.zzadv < 0)
        return false;
      this.zzadj.zzde = this.zzads[this.zzadv];
      this.zzadj.zzde.clear();
    }
    if (this.zzaea == 1)
    {
      this.zzadq.queueInputBuffer(this.zzadv, 0, 0, 0L, 4);
      this.zzadv = -1;
      this.zzaea = 2;
      return false;
    }
    int i;
    if (this.zzaeg)
      i = -3;
    while (i == -2)
    {
      return false;
      if (this.zzadz == 1)
      {
        for (int i1 = 0; i1 < this.zzado.zzafw.size(); i1++)
        {
          byte[] arrayOfByte = (byte[])this.zzado.zzafw.get(i1);
          this.zzadj.zzde.put(arrayOfByte);
        }
        this.zzadz = 2;
      }
      i = this.zzadi.zza(this.zzaec, this.zzadb, this.zzadk, this.zzadj, false);
      if ((paramBoolean) && (this.zzaed == 1) && (i == -2))
        this.zzaed = 2;
    }
    if (i == -5)
    {
      zzef();
      return true;
    }
    if (i == -4)
    {
      if (this.zzadz == 2)
      {
        this.zzadj.zzde.clear();
        this.zzadz = 1;
      }
      zza(this.zzadk);
      return true;
    }
    if (i == -1)
    {
      if (this.zzadz == 2)
      {
        this.zzadj.zzde.clear();
        this.zzadz = 1;
      }
      this.zzaee = true;
      try
      {
        this.zzadq.queueInputBuffer(this.zzadv, 0, 0, 0L, 4);
        this.zzadv = -1;
        return false;
      }
      catch (MediaCodec.CryptoException localCryptoException2)
      {
        zza(localCryptoException2);
        throw new zzgd(localCryptoException2);
      }
    }
    if (this.zzaeh)
    {
      if (!this.zzadj.zzep())
      {
        this.zzadj.zzde.clear();
        if (this.zzadz == 2)
          this.zzadz = 1;
        return true;
      }
      this.zzaeh = false;
    }
    boolean bool1 = this.zzadj.zzeo();
    if (this.zzadx)
    {
      int n = this.zzadg.getState();
      if (n == 0)
        throw new zzgd(this.zzadg.zzfb());
      if ((n == 4) || ((!bool1) && (this.zzadh)));
    }
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.zzaeg = bool2;
      if (!this.zzaeg)
        break;
      return false;
    }
    while (true)
    {
      int j;
      long l;
      try
      {
        j = this.zzadj.zzde.position();
        int k = j - this.zzadj.size;
        l = this.zzadj.zzaga;
        if ((0x8000000 & this.zzadj.flags) == 0)
          break label711;
        m = 1;
        if (m != 0)
          this.zzadl.add(Long.valueOf(l));
        if (bool1)
        {
          MediaCodec.CryptoInfo localCryptoInfo = this.zzadj.zzafz.zzdl();
          if (k == 0)
          {
            this.zzadq.queueSecureInputBuffer(this.zzadv, 0, localCryptoInfo, l, 0);
            this.zzadv = -1;
            this.zzaeb = true;
            this.zzadz = 0;
            return true;
          }
          if (localCryptoInfo.numBytesOfClearData == null)
            localCryptoInfo.numBytesOfClearData = new int[1];
          int[] arrayOfInt = localCryptoInfo.numBytesOfClearData;
          arrayOfInt[0] = (k + arrayOfInt[0]);
          continue;
        }
      }
      catch (MediaCodec.CryptoException localCryptoException1)
      {
        zza(localCryptoException1);
        throw new zzgd(localCryptoException1);
      }
      this.zzadq.queueInputBuffer(this.zzadv, 0, j, l, 0);
      continue;
      label711: int m = 0;
    }
  }

  private final void zzef()
    throws zzgd
  {
    this.zzadu = -1L;
    this.zzadv = -1;
    this.zzadw = -1;
    this.zzaeh = true;
    this.zzaeg = false;
    this.zzadl.clear();
    if ((zzkq.SDK_INT >= 18) && (this.zzaea == 0))
    {
      this.zzadq.flush();
      this.zzaeb = false;
    }
    while (true)
    {
      if ((this.zzady) && (this.zzado != null))
        this.zzadz = 1;
      return;
      zzed();
      zzea();
    }
  }

  protected final long getDurationUs()
  {
    return this.zzadi.zzo(this.zzaec).zzack;
  }

  protected boolean isReady()
  {
    if ((this.zzado != null) && (!this.zzaeg))
    {
      if ((this.zzaed == 0) && (this.zzadw < 0))
        if (SystemClock.elapsedRealtime() >= 1000L + this.zzadu)
          break label51;
      label51: for (int i = 1; i != 0; i = 0)
        return true;
    }
    return false;
  }

  protected void onStarted()
  {
  }

  protected void onStopped()
  {
  }

  protected void seekTo(long paramLong)
    throws zzgd
  {
    this.zzadb = paramLong;
    this.zzadi.zzdi(paramLong);
    this.zzaed = 0;
    this.zzaee = false;
    this.zzaef = false;
  }

  protected final void zza(long paramLong1, long paramLong2)
    throws zzgd
  {
    int i;
    int j;
    try
    {
      if (!this.zzadi.zzdh(paramLong1))
        break label520;
      if (this.zzaed == 0)
      {
        i = 1;
        this.zzaed = i;
        if ((this.zzadq != null) && (this.zzadi.zza(this.zzaec, this.zzadb, this.zzadk, this.zzadj, true) == -5))
          zzef();
        if ((this.zzado == null) && (this.zzadi.zza(this.zzaec, this.zzadb, this.zzadk, this.zzadj, false) == -4))
          zza(this.zzadk);
        if ((this.zzadq == null) && (zzeb()))
          zzea();
        if (this.zzadq == null);
      }
      label297: 
      while (true)
      {
        if (this.zzaef)
          break label514;
        if (this.zzadw < 0)
          this.zzadw = this.zzadq.dequeueOutputBuffer(this.zzadm, 0L);
        if (this.zzadw == -2)
        {
          zza(this.zzado, this.zzadq.getOutputFormat());
          zzga localzzga2 = this.zzadf;
          localzzga2.zzabi = (1 + localzzga2.zzabi);
        }
        for (j = 1; ; j = 1)
        {
          label217: if (j != 0)
            break label297;
          while ((zze(true)) && (zze(false)));
          this.zzadf.zzdk();
          return;
          i = this.zzaed;
          break;
          if (this.zzadw != -3)
            break label299;
          this.zzadt = this.zzadq.getOutputBuffers();
          zzga localzzga1 = this.zzadf;
          localzzga1.zzabj = (1 + localzzga1.zzabj);
        }
      }
      label299: if (this.zzadw < 0)
        break label514;
      if ((0x4 & this.zzadm.flags) != 0)
        if (this.zzaea == 2)
        {
          zzed();
          zzea();
        }
        else
        {
          this.zzaef = true;
        }
    }
    catch (IOException localIOException)
    {
      throw new zzgd(localIOException);
    }
    long l = this.zzadm.presentationTimeUs;
    int k = this.zzadl.size();
    int m = 0;
    label380: int n;
    label414: MediaCodec localMediaCodec;
    ByteBuffer localByteBuffer;
    MediaCodec.BufferInfo localBufferInfo;
    int i1;
    if (m < k)
      if (((Long)this.zzadl.get(m)).longValue() == l)
      {
        n = m;
        localMediaCodec = this.zzadq;
        localByteBuffer = this.zzadt[this.zzadw];
        localBufferInfo = this.zzadm;
        i1 = this.zzadw;
        if (n == -1)
          break label544;
      }
    label514: label520: label544: for (boolean bool = true; ; bool = false)
    {
      if (zza(paramLong1, paramLong2, localMediaCodec, localByteBuffer, localBufferInfo, i1, bool))
      {
        if (n != -1)
          this.zzadl.remove(n);
        while (true)
        {
          this.zzadw = -1;
          j = 1;
          break;
          this.zzadb = this.zzadm.presentationTimeUs;
        }
      }
      j = 0;
      break label217;
      i = 0;
      break;
      j = 0;
      break label217;
      m++;
      break label380;
      n = -1;
      break label414;
    }
  }

  protected void zza(MediaCodec paramMediaCodec, String paramString, MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto)
  {
    paramMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, 0);
  }

  protected void zza(zzhj paramzzhj, MediaFormat paramMediaFormat)
  {
  }

  protected void zza(zzhk paramzzhk)
    throws zzgd
  {
    zzhj localzzhj = this.zzado;
    this.zzado = paramzzhk.zzado;
    this.zzadp = paramzzhk.zzadp;
    if ((this.zzadq != null) && (zza(this.zzadq, this.zzadr, localzzhj, this.zzado)))
    {
      this.zzady = true;
      this.zzadz = 1;
      return;
    }
    if (this.zzaeb)
    {
      this.zzaea = 1;
      return;
    }
    zzed();
    zzea();
  }

  protected abstract boolean zza(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
    throws zzgd;

  protected boolean zza(MediaCodec paramMediaCodec, boolean paramBoolean, zzhj paramzzhj1, zzhj paramzzhj2)
  {
    return false;
  }

  protected boolean zzas(String paramString)
  {
    return true;
  }

  protected void zzb(long paramLong, boolean paramBoolean)
  {
    this.zzadi.zza(this.zzaec, paramLong);
    this.zzaed = 0;
    this.zzaee = false;
    this.zzaef = false;
    this.zzaeg = false;
    this.zzadb = paramLong;
  }

  protected zzgc zzc(String paramString, boolean paramBoolean)
    throws zzgz
  {
    return zzgx.zzc(paramString, paramBoolean);
  }

  protected final int zzdl(long paramLong)
    throws zzgd
  {
    int i;
    try
    {
      boolean bool = this.zzadi.zzdg(paramLong);
      i = 0;
      if (!bool)
        return 0;
    }
    catch (IOException localIOException)
    {
      throw new zzgd(localIOException);
    }
    do
    {
      i++;
      if (i >= this.zzadi.getTrackCount())
        break;
    }
    while (!zzas(this.zzadi.zzo(i).mimeType));
    this.zzaec = i;
    return 1;
    return -1;
  }

  protected final long zzdu()
  {
    long l = this.zzadi.zzdu();
    if ((l == -1L) || (l == -3L))
      return l;
    return Math.max(l, zzdy());
  }

  protected boolean zzdx()
  {
    return this.zzaef;
  }

  protected long zzdy()
  {
    return this.zzadb;
  }

  protected void zzdz()
  {
    this.zzado = null;
    this.zzadp = null;
    try
    {
      zzed();
      try
      {
        if (this.zzadx)
        {
          this.zzadg.close();
          this.zzadx = false;
        }
        return;
      }
      finally
      {
        this.zzadi.zzp(this.zzaec);
      }
    }
    finally
    {
    }
  }

  protected final void zzea()
    throws zzgd
  {
    if (!zzeb());
    String str1;
    int i;
    do
    {
      return;
      str1 = this.zzado.mimeType;
      if (this.zzadp == null)
        break;
      if (this.zzadg == null)
        throw new zzgd("Media requires a DrmSessionManager");
      if (!this.zzadx)
      {
        this.zzadg.zza(this.zzadp);
        this.zzadx = true;
      }
      i = this.zzadg.getState();
      if (i == 0)
        throw new zzgd(this.zzadg.zzfb());
    }
    while ((i != 3) && (i != 4));
    MediaCrypto localMediaCrypto = this.zzadg.zzfa();
    boolean bool = this.zzadg.requiresSecureDecoderComponent(str1);
    while (true)
    {
      try
      {
        zzgc localzzgc2 = zzc(str1, bool);
        localzzgc1 = localzzgc2;
        if (localzzgc1 == null)
          zza(new zzgv(this.zzado, null, -49999));
        str2 = localzzgc1.name;
        this.zzadr = localzzgc1.zzabo;
      }
      catch (zzgz localzzgz)
      {
        try
        {
          zzgc localzzgc1;
          long l2 = SystemClock.elapsedRealtime();
          this.zzadq = MediaCodec.createByCodecName(str2);
          zza(this.zzadq, str2, this.zzado.zzen(), localMediaCrypto);
          this.zzadq.start();
          long l3 = SystemClock.elapsedRealtime();
          long l4 = l3 - l2;
          if ((this.zzabq != null) && (this.zzadn != null))
            this.zzabq.post(new zzgu(this, str2, l3, l4));
          this.zzads = this.zzadq.getInputBuffers();
          this.zzadt = this.zzadq.getOutputBuffers();
          if (getState() == 3)
          {
            l1 = SystemClock.elapsedRealtime();
            this.zzadu = l1;
            this.zzadv = -1;
            this.zzadw = -1;
            this.zzaeh = true;
            zzga localzzga = this.zzadf;
            localzzga.zzabg = (1 + localzzga.zzabg);
            return;
            localzzgz = localzzgz;
            zza(new zzgv(this.zzado, localzzgz, -49998));
            localzzgc1 = null;
          }
        }
        catch (Exception localException)
        {
          String str2;
          zza(new zzgv(this.zzado, localException, str2));
          continue;
          long l1 = -1L;
          continue;
        }
      }
      bool = false;
      localMediaCrypto = null;
    }
  }

  protected boolean zzeb()
  {
    return (this.zzadq == null) && (this.zzado != null);
  }

  protected final boolean zzec()
  {
    return this.zzadq != null;
  }

  protected final void zzed()
  {
    if (this.zzadq != null)
    {
      this.zzadu = -1L;
      this.zzadv = -1;
      this.zzadw = -1;
      this.zzaeg = false;
      this.zzadl.clear();
      this.zzads = null;
      this.zzadt = null;
      this.zzady = false;
      this.zzaeb = false;
      this.zzadr = false;
      this.zzadz = 0;
      this.zzaea = 0;
      zzga localzzga = this.zzadf;
      localzzga.zzabh = (1 + localzzga.zzabh);
    }
    try
    {
      this.zzadq.stop();
      try
      {
        this.zzadq.release();
        return;
      }
      finally
      {
        this.zzadq = null;
      }
    }
    finally
    {
    }
  }

  protected final void zzee()
  {
    this.zzadi.release();
  }

  protected final int zzeg()
  {
    return this.zzaed;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgr
 * JD-Core Version:    0.6.2
 */