package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzpe extends zzks
{
  private static final byte[] zzbgp = zzsy.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private final boolean zzadh;
  private final List<Long> zzadl;
  private final MediaCodec.BufferInfo zzadm;
  private MediaCodec zzadq;
  private ByteBuffer[] zzads;
  private ByteBuffer[] zzadt;
  private int zzadv;
  private int zzadw;
  private boolean zzady;
  private int zzadz;
  private int zzaea;
  private boolean zzaee;
  private boolean zzaef;
  private boolean zzaeg;
  private boolean zzaeh;
  private zzlh zzaue;
  private final zzpg zzbgq;
  private final zznj<Object> zzbgr;
  private final zznd zzbgs;
  private final zznd zzbgt;
  private final zzlj zzbgu;
  private zznh<Object> zzbgv;
  private zznh<Object> zzbgw;
  private zzpd zzbgx;
  private boolean zzbgy;
  private boolean zzbgz;
  private boolean zzbha;
  private boolean zzbhb;
  private boolean zzbhc;
  private boolean zzbhd;
  private boolean zzbhe;
  private boolean zzbhf;
  private boolean zzbhg;
  private long zzbhh;
  private boolean zzbhi;
  private boolean zzbhj;
  private boolean zzbhk;
  protected zznc zzbhl;

  public zzpe(int paramInt, zzpg paramzzpg, zznj<Object> paramzznj, boolean paramBoolean)
  {
    super(paramInt);
    if (zzsy.SDK_INT >= 16);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      this.zzbgq = ((zzpg)zzsk.checkNotNull(paramzzpg));
      this.zzbgr = paramzznj;
      this.zzadh = paramBoolean;
      this.zzbgs = new zznd(0);
      this.zzbgt = new zznd(0);
      this.zzbgu = new zzlj();
      this.zzadl = new ArrayList();
      this.zzadm = new MediaCodec.BufferInfo();
      this.zzadz = 0;
      this.zzaea = 0;
      return;
    }
  }

  private final void zza(zzpf paramzzpf)
    throws zzku
  {
    throw zzku.zza(paramzzpf, getIndex());
  }

  private final boolean zze(long paramLong1, long paramLong2)
    throws zzku
  {
    int j;
    boolean bool3;
    if (this.zzadw < 0)
    {
      if ((this.zzbhd) && (this.zzbhk));
      while (true)
      {
        try
        {
          this.zzadw = this.zzadq.dequeueOutputBuffer(this.zzadm, 0L);
          if (this.zzadw < 0)
            break label353;
          if (!this.zzbhg)
            break;
          this.zzbhg = false;
          this.zzadq.releaseOutputBuffer(this.zzadw, false);
          this.zzadw = -1;
          return true;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          zziu();
          if (this.zzaef)
            zzed();
          return false;
        }
        this.zzadw = this.zzadq.dequeueOutputBuffer(this.zzadm, 0L);
      }
      if ((0x4 & this.zzadm.flags) != 0)
      {
        zziu();
        this.zzadw = -1;
        return false;
      }
      ByteBuffer localByteBuffer = this.zzadt[this.zzadw];
      if (localByteBuffer != null)
      {
        localByteBuffer.position(this.zzadm.offset);
        localByteBuffer.limit(this.zzadm.offset + this.zzadm.size);
      }
      long l = this.zzadm.presentationTimeUs;
      int i = this.zzadl.size();
      j = 0;
      if (j >= i)
        break label347;
      if (((Long)this.zzadl.get(j)).longValue() == l)
      {
        this.zzadl.remove(j);
        bool3 = true;
        label254: this.zzbhi = bool3;
      }
    }
    else
    {
      if ((!this.zzbhd) || (!this.zzbhk))
        break label506;
    }
    while (true)
    {
      try
      {
        boolean bool2 = zza(paramLong1, paramLong2, this.zzadq, this.zzadt[this.zzadw], this.zzadw, this.zzadm.flags, this.zzadm.presentationTimeUs, this.zzbhi);
        bool1 = bool2;
        if (!bool1)
          break label552;
        this.zzadw = -1;
        return true;
        j++;
        break;
        label347: bool3 = false;
        break label254;
        label353: if (this.zzadw == -2)
        {
          MediaFormat localMediaFormat = this.zzadq.getOutputFormat();
          if ((this.zzbha) && (localMediaFormat.getInteger("width") == 32) && (localMediaFormat.getInteger("height") == 32))
          {
            this.zzbhg = true;
            return true;
          }
          if (this.zzbhe)
            localMediaFormat.setInteger("channel-count", 1);
          onOutputFormatChanged(this.zzadq, localMediaFormat);
          continue;
        }
        if (this.zzadw == -3)
        {
          this.zzadt = this.zzadq.getOutputBuffers();
          return true;
        }
        if ((this.zzbhb) && ((this.zzaee) || (this.zzaea == 2)))
          zziu();
        return false;
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        zziu();
        if (this.zzaef)
          zzed();
        return false;
      }
      label506: boolean bool1 = zza(paramLong1, paramLong2, this.zzadq, this.zzadt[this.zzadw], this.zzadw, this.zzadm.flags, this.zzadm.presentationTimeUs, this.zzbhi);
    }
    label552: return false;
  }

  private final boolean zzit()
    throws zzku
  {
    if ((this.zzadq == null) || (this.zzaea == 2) || (this.zzaee));
    int k;
    while (true)
    {
      return false;
      if (this.zzadv < 0)
      {
        this.zzadv = this.zzadq.dequeueInputBuffer(0L);
        if (this.zzadv >= 0)
        {
          this.zzbgs.zzde = this.zzads[this.zzadv];
          this.zzbgs.clear();
        }
      }
      else
      {
        if (this.zzaea == 1)
        {
          if (!this.zzbhb)
          {
            this.zzbhk = true;
            this.zzadq.queueInputBuffer(this.zzadv, 0, 0, 0L, 4);
            this.zzadv = -1;
          }
          this.zzaea = 2;
          return false;
        }
        if (this.zzbhf)
        {
          this.zzbhf = false;
          this.zzbgs.zzde.put(zzbgp);
          this.zzadq.queueInputBuffer(this.zzadv, 0, zzbgp.length, 0L, 0);
          this.zzadv = -1;
          this.zzbhj = true;
          return true;
        }
        int j;
        if (this.zzaeg)
          j = -4;
        int i;
        for (k = 0; j != -3; k = i)
        {
          if (j != -5)
            break label334;
          if (this.zzadz == 2)
          {
            this.zzbgs.clear();
            this.zzadz = 1;
          }
          zzd(this.zzbgu.zzaue);
          return true;
          if (this.zzadz == 1)
          {
            for (int n = 0; n < this.zzaue.zzafw.size(); n++)
            {
              byte[] arrayOfByte = (byte[])this.zzaue.zzafw.get(n);
              this.zzbgs.zzde.put(arrayOfByte);
            }
            this.zzadz = 2;
          }
          i = this.zzbgs.zzde.position();
          j = zza(this.zzbgu, this.zzbgs, false);
        }
        continue;
        label334: if (this.zzbgs.zzic())
        {
          if (this.zzadz == 2)
          {
            this.zzbgs.clear();
            this.zzadz = 1;
          }
          this.zzaee = true;
          if (!this.zzbhj)
          {
            zziu();
            return false;
          }
          try
          {
            if (!this.zzbhb)
            {
              this.zzbhk = true;
              this.zzadq.queueInputBuffer(this.zzadv, 0, 0, 0L, 4);
              this.zzadv = -1;
              return false;
            }
          }
          catch (MediaCodec.CryptoException localCryptoException2)
          {
            throw zzku.zza(localCryptoException2, getIndex());
          }
        }
      }
    }
    if ((this.zzaeh) && (!this.zzbgs.zzid()))
    {
      this.zzbgs.clear();
      if (this.zzadz == 2)
        this.zzadz = 1;
      return true;
    }
    this.zzaeh = false;
    boolean bool1 = this.zzbgs.zzeo();
    if (this.zzbgv != null)
    {
      int m = this.zzbgv.getState();
      if (m == 0)
        throw zzku.zza(this.zzbgv.zzif(), getIndex());
      if ((m == 4) || ((!bool1) && (this.zzadh)));
    }
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.zzaeg = bool2;
      if (this.zzaeg)
        break;
      if ((!this.zzbgy) || (bool1))
        break label603;
      zzsq.zzk(this.zzbgs.zzde);
      if (this.zzbgs.zzde.position() != 0)
        break label598;
      return true;
    }
    label598: this.zzbgy = false;
    while (true)
    {
      label603: long l;
      try
      {
        l = this.zzbgs.zzaga;
        if (this.zzbgs.zzib())
          this.zzadl.add(Long.valueOf(l));
        this.zzbgs.zzde.flip();
        zza(this.zzbgs);
        if (bool1)
        {
          MediaCodec.CryptoInfo localCryptoInfo = this.zzbgs.zzaze.zzdl();
          if (k == 0)
          {
            this.zzadq.queueSecureInputBuffer(this.zzadv, 0, localCryptoInfo, l, 0);
            this.zzadv = -1;
            this.zzbhj = true;
            this.zzadz = 0;
            zznc localzznc = this.zzbhl;
            localzznc.zzazc = (1 + localzznc.zzazc);
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
        throw zzku.zza(localCryptoException1, getIndex());
      }
      this.zzadq.queueInputBuffer(this.zzadv, 0, this.zzbgs.zzde.limit(), l, 0);
    }
  }

  private final void zziu()
    throws zzku
  {
    if (this.zzaea == 2)
    {
      zzed();
      zzea();
      return;
    }
    this.zzaef = true;
    zzhw();
  }

  public boolean isReady()
  {
    return (this.zzaue != null) && (!this.zzaeg) && ((zzgr()) || (this.zzadw >= 0) || ((this.zzbhh != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.zzbhh)));
  }

  protected void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    throws zzku
  {
  }

  protected void onStarted()
  {
  }

  protected void onStopped()
  {
  }

  public final int zza(zzlh paramzzlh)
    throws zzku
  {
    try
    {
      int i = zza(this.zzbgq, paramzzlh);
      return i;
    }
    catch (zzpk localzzpk)
    {
      throw zzku.zza(localzzpk, getIndex());
    }
  }

  protected abstract int zza(zzpg paramzzpg, zzlh paramzzlh)
    throws zzpk;

  protected zzpd zza(zzpg paramzzpg, zzlh paramzzlh, boolean paramBoolean)
    throws zzpk
  {
    return paramzzpg.zze(paramzzlh.zzatq, paramBoolean);
  }

  protected void zza(zznd paramzznd)
  {
  }

  protected abstract void zza(zzpd paramzzpd, MediaCodec paramMediaCodec, zzlh paramzzlh, MediaCrypto paramMediaCrypto)
    throws zzpk;

  protected abstract boolean zza(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
    throws zzku;

  protected boolean zza(MediaCodec paramMediaCodec, boolean paramBoolean, zzlh paramzzlh1, zzlh paramzzlh2)
  {
    return false;
  }

  protected boolean zza(zzpd paramzzpd)
  {
    return true;
  }

  public final void zzc(long paramLong1, long paramLong2)
    throws zzku
  {
    if (this.zzaef)
    {
      zzhw();
      return;
    }
    int j;
    if (this.zzaue == null)
    {
      this.zzbgt.clear();
      j = zza(this.zzbgu, this.zzbgt, true);
      if (j == -5)
        zzd(this.zzbgu.zzaue);
    }
    else
    {
      zzea();
      if (this.zzadq == null)
        break label130;
      zzsx.beginSection("drainAndFeed");
      while (zze(paramLong1, paramLong2));
      while (zzit());
      zzsx.endSection();
    }
    while (true)
    {
      this.zzbhl.zzdk();
      return;
      if (j != -4)
        break;
      zzsk.checkState(this.zzbgt.zzic());
      this.zzaee = true;
      zziu();
      return;
      label130: zzdy(paramLong1);
      this.zzbgt.clear();
      int i = zza(this.zzbgu, this.zzbgt, false);
      if (i == -5)
      {
        zzd(this.zzbgu.zzaue);
      }
      else if (i == -4)
      {
        zzsk.checkState(this.zzbgt.zzic());
        this.zzaee = true;
        zziu();
      }
    }
  }

  protected void zzd(long paramLong, boolean paramBoolean)
    throws zzku
  {
    this.zzaee = false;
    this.zzaef = false;
    if (this.zzadq != null)
    {
      this.zzbhh = -9223372036854775807L;
      this.zzadv = -1;
      this.zzadw = -1;
      this.zzaeh = true;
      this.zzaeg = false;
      this.zzbhi = false;
      this.zzadl.clear();
      this.zzbhf = false;
      this.zzbhg = false;
      if ((!this.zzbgz) && ((!this.zzbhc) || (!this.zzbhk)))
        break label117;
      zzed();
      zzea();
    }
    while (true)
    {
      if ((this.zzady) && (this.zzaue != null))
        this.zzadz = 1;
      return;
      label117: if (this.zzaea != 0)
      {
        zzed();
        zzea();
      }
      else
      {
        this.zzadq.flush();
        this.zzbhj = false;
      }
    }
  }

  protected void zzd(zzlh paramzzlh)
    throws zzku
  {
    zzlh localzzlh = this.zzaue;
    this.zzaue = paramzzlh;
    zzne localzzne = this.zzaue.zzatr;
    Object localObject;
    int i;
    if (localzzlh == null)
    {
      localObject = null;
      if (zzsy.zza(localzzne, localObject))
        break label86;
      i = 1;
    }
    while (true)
      if (i != 0)
      {
        if (this.zzaue.zzatr == null)
          break label235;
        if (this.zzbgr == null)
        {
          throw zzku.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
          localObject = localzzlh.zzatr;
          break;
          label86: i = 0;
          continue;
        }
        this.zzbgw = this.zzbgr.zza(Looper.myLooper(), this.zzaue.zzatr);
        if (this.zzbgw == this.zzbgv)
          this.zzbgr.zza(this.zzbgw);
      }
    if ((this.zzbgw == this.zzbgv) && (this.zzadq != null) && (zza(this.zzadq, this.zzbgx.zzabo, localzzlh, this.zzaue)))
    {
      this.zzady = true;
      this.zzadz = 1;
      if ((this.zzbha) && (this.zzaue.width == localzzlh.width) && (this.zzaue.height == localzzlh.height));
      for (boolean bool = true; ; bool = false)
      {
        this.zzbhf = bool;
        return;
        label235: this.zzbgw = null;
        break;
      }
    }
    if (this.zzbhj)
    {
      this.zzaea = 1;
      return;
    }
    zzed();
    zzea();
  }

  protected void zzd(String paramString, long paramLong1, long paramLong2)
  {
  }

  public boolean zzdx()
  {
    return this.zzaef;
  }

  protected void zzdz()
  {
    this.zzaue = null;
    try
    {
      zzed();
      try
      {
        if (this.zzbgv != null)
          this.zzbgr.zza(this.zzbgv);
        try
        {
          if ((this.zzbgw != null) && (this.zzbgw != this.zzbgv))
            this.zzbgr.zza(this.zzbgw);
          return;
        }
        finally
        {
          this.zzbgv = null;
          this.zzbgw = null;
        }
      }
      finally
      {
      }
    }
    finally
    {
    }
  }

  protected final void zzea()
    throws zzku
  {
    if ((this.zzadq != null) || (this.zzaue == null));
    while (true)
    {
      return;
      this.zzbgv = this.zzbgw;
      if (this.zzbgv != null)
      {
        int i = this.zzbgv.getState();
        if (i == 0)
          throw zzku.zza(this.zzbgv.zzif(), getIndex());
        if ((i != 3) && (i != 4))
          continue;
        this.zzbgv.zzie();
        throw new NoSuchMethodError();
      }
      if (this.zzbgx == null);
      try
      {
        this.zzbgx = zza(this.zzbgq, this.zzaue, false);
        if (this.zzbgx == null)
          zza(new zzpf(this.zzaue, null, false, -49999));
        if (!zza(this.zzbgx))
          continue;
        str1 = this.zzbgx.name;
        zzlh localzzlh1 = this.zzaue;
        if ((zzsy.SDK_INT < 21) && (localzzlh1.zzafw.isEmpty()) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(str1)))
        {
          bool1 = true;
          label209: this.zzbgy = bool1;
          if ((zzsy.SDK_INT >= 18) && ((zzsy.SDK_INT != 18) || ((!"OMX.SEC.avc.dec".equals(str1)) && (!"OMX.SEC.avc.dec.secure".equals(str1)))) && ((zzsy.SDK_INT != 19) || (!zzsy.MODEL.startsWith("SM-G800")) || ((!"OMX.Exynos.avc.dec".equals(str1)) && (!"OMX.Exynos.avc.dec.secure".equals(str1)))))
            break label773;
          bool2 = true;
          label294: this.zzbgz = bool2;
          if ((zzsy.SDK_INT >= 24) || ((!"OMX.Nvidia.h264.decode".equals(str1)) && (!"OMX.Nvidia.h264.decode.secure".equals(str1))) || ((!"flounder".equals(zzsy.DEVICE)) && (!"flounder_lte".equals(zzsy.DEVICE)) && (!"grouper".equals(zzsy.DEVICE)) && (!"tilapia".equals(zzsy.DEVICE))))
            break label779;
          bool3 = true;
          label379: this.zzbha = bool3;
          if ((zzsy.SDK_INT > 17) || ((!"OMX.rk.video_decoder.avc".equals(str1)) && (!"OMX.allwinner.video.decoder.avc".equals(str1))))
            break label785;
          bool4 = true;
          label416: this.zzbhb = bool4;
          if (((zzsy.SDK_INT > 23) || (!"OMX.google.vorbis.decoder".equals(str1))) && ((zzsy.SDK_INT > 19) || (!"hb2000".equals(zzsy.DEVICE)) || ((!"OMX.amlogic.avc.decoder.awesome".equals(str1)) && (!"OMX.amlogic.avc.decoder.awesome.secure".equals(str1)))))
            break label791;
          bool5 = true;
          label483: this.zzbhc = bool5;
          if ((zzsy.SDK_INT != 21) || (!"OMX.google.aac.decoder".equals(str1)))
            break label797;
          bool6 = true;
          label510: this.zzbhd = bool6;
          zzlh localzzlh2 = this.zzaue;
          if ((zzsy.SDK_INT > 18) || (localzzlh2.zzafu != 1) || (!"OMX.MTK.AUDIO.DECODER.MP3".equals(str1)))
            break label803;
          bool7 = true;
          label552: this.zzbhe = bool7;
        }
      }
      catch (zzpk localzzpk)
      {
        try
        {
          boolean bool1;
          boolean bool2;
          boolean bool3;
          boolean bool4;
          boolean bool5;
          boolean bool6;
          boolean bool7;
          long l2 = SystemClock.elapsedRealtime();
          String str2 = String.valueOf(str1);
          if (str2.length() != 0);
          for (String str3 = "createCodec:".concat(str2); ; str3 = new String("createCodec:"))
          {
            zzsx.beginSection(str3);
            this.zzadq = MediaCodec.createByCodecName(str1);
            zzsx.endSection();
            zzsx.beginSection("configureCodec");
            zza(this.zzbgx, this.zzadq, this.zzaue, null);
            zzsx.endSection();
            zzsx.beginSection("startCodec");
            this.zzadq.start();
            zzsx.endSection();
            long l3 = SystemClock.elapsedRealtime();
            zzd(str1, l3, l3 - l2);
            this.zzads = this.zzadq.getInputBuffers();
            this.zzadt = this.zzadq.getOutputBuffers();
            if (getState() != 2)
              break label848;
            l1 = 1000L + SystemClock.elapsedRealtime();
            this.zzbhh = l1;
            this.zzadv = -1;
            this.zzadw = -1;
            this.zzaeh = true;
            zznc localzznc = this.zzbhl;
            localzznc.zzaza = (1 + localzznc.zzaza);
            return;
            localzzpk = localzzpk;
            zza(new zzpf(this.zzaue, localzzpk, false, -49998));
            break;
            bool1 = false;
            break label209;
            label773: bool2 = false;
            break label294;
            label779: bool3 = false;
            break label379;
            label785: bool4 = false;
            break label416;
            label791: bool5 = false;
            break label483;
            label797: bool6 = false;
            break label510;
            label803: bool7 = false;
            break label552;
          }
        }
        catch (Exception localException)
        {
          while (true)
          {
            String str1;
            zza(new zzpf(this.zzaue, localException, false, str1));
            continue;
            label848: long l1 = -9223372036854775807L;
          }
        }
      }
    }
  }

  protected void zzed()
  {
    this.zzbhh = -9223372036854775807L;
    this.zzadv = -1;
    this.zzadw = -1;
    this.zzaeg = false;
    this.zzbhi = false;
    this.zzadl.clear();
    this.zzads = null;
    this.zzadt = null;
    this.zzbgx = null;
    this.zzady = false;
    this.zzbhj = false;
    this.zzbgy = false;
    this.zzbgz = false;
    this.zzbha = false;
    this.zzbhb = false;
    this.zzbhc = false;
    this.zzbhe = false;
    this.zzbhf = false;
    this.zzbhg = false;
    this.zzbhk = false;
    this.zzadz = 0;
    this.zzaea = 0;
    this.zzbgs.zzde = null;
    if (this.zzadq != null)
    {
      zznc localzznc = this.zzbhl;
      localzznc.zzazb = (1 + localzznc.zzazb);
    }
    try
    {
      this.zzadq.stop();
      try
      {
        this.zzadq.release();
        this.zzadq = null;
        if ((this.zzbgv != null) && (this.zzbgw != this.zzbgv));
        try
        {
          this.zzbgr.zza(this.zzbgv);
          return;
        }
        finally
        {
          this.zzbgv = null;
        }
      }
      finally
      {
        this.zzadq = null;
        if ((this.zzbgv == null) || (this.zzbgw == this.zzbgv));
      }
    }
    finally
    {
    }
  }

  protected void zzg(boolean paramBoolean)
    throws zzku
  {
    this.zzbhl = new zznc();
  }

  public final int zzgp()
  {
    return 4;
  }

  protected void zzhw()
    throws zzku
  {
  }

  protected final MediaCodec zzir()
  {
    return this.zzadq;
  }

  protected final zzpd zzis()
  {
    return this.zzbgx;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpe
 * JD-Core Version:    0.6.2
 */