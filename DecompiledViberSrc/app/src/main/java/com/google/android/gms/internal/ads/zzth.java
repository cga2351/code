package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzth extends zzpe
{
  private static final int[] zzbod = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private Surface zzaez;
  private boolean zzafb;
  private long zzafd;
  private int zzaff;
  private int zzafg;
  private float zzafh;
  private int zzaul;
  private boolean zzawy;
  private final zztl zzboe;
  private final zzto zzbof;
  private final long zzbog = 0L;
  private final int zzboh = -1;
  private final boolean zzboi;
  private final long[] zzboj;
  private zzlh[] zzbok;
  private zztj zzbol;
  private Surface zzbom;
  private int zzbon;
  private long zzboo;
  private int zzbop;
  private int zzboq;
  private int zzbor;
  private float zzbos;
  private int zzbot;
  private int zzbou;
  private int zzbov;
  private int zzbow;
  private float zzbox;
  zztk zzboy;
  private long zzboz;
  private int zzbpa;
  private final Context zzlj;

  public zzth(Context paramContext, zzpg paramzzpg, long paramLong, Handler paramHandler, zztn paramzztn, int paramInt)
  {
    this(paramContext, paramzzpg, 0L, null, false, paramHandler, paramzztn, -1);
  }

  private zzth(Context paramContext, zzpg paramzzpg, long paramLong, zznj<Object> paramzznj, boolean paramBoolean, Handler paramHandler, zztn paramzztn, int paramInt)
  {
    super(2, paramzzpg, null, false);
    this.zzlj = paramContext.getApplicationContext();
    this.zzboe = new zztl(paramContext);
    this.zzbof = new zzto(paramHandler, paramzztn);
    if ((zzsy.SDK_INT <= 22) && ("foster".equals(zzsy.DEVICE)) && ("NVIDIA".equals(zzsy.MANUFACTURER)));
    for (boolean bool = true; ; bool = false)
    {
      this.zzboi = bool;
      this.zzboj = new long[10];
      this.zzboz = -9223372036854775807L;
      this.zzboo = -9223372036854775807L;
      this.zzaff = -1;
      this.zzafg = -1;
      this.zzafh = -1.0F;
      this.zzbos = -1.0F;
      this.zzbon = 1;
      zzkk();
      return;
    }
  }

  private static int zza(String paramString, int paramInt1, int paramInt2)
  {
    int i = 2;
    if ((paramInt1 == -1) || (paramInt2 == -1))
      return -1;
    label76: int j;
    switch (paramString.hashCode())
    {
    default:
      j = -1;
    case -1664118616:
    case 1187890754:
    case 1331836730:
    case 1599127256:
    case -1662541442:
    case 1599127257:
    }
    while (true)
      switch (j)
      {
      default:
        return -1;
        if (!paramString.equals("video/3gpp"))
          break label76;
        j = 0;
        continue;
        if (!paramString.equals("video/mp4v-es"))
          break label76;
        j = 1;
        continue;
        if (!paramString.equals("video/avc"))
          break label76;
        j = i;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8"))
          break label76;
        j = 3;
        continue;
        if (!paramString.equals("video/hevc"))
          break label76;
        j = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9"))
          break label76;
        j = 5;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    int k = paramInt1 * paramInt2;
    while (true)
    {
      return k * 3 / (i * 2);
      if ("BRAVIA 4K 2015".equals(zzsy.MODEL))
        return -1;
      k = zzsy.zzb(paramInt1, 16) * zzsy.zzb(paramInt2, 16) << 4 << 4;
      continue;
      k = paramInt1 * paramInt2;
      continue;
      k = paramInt1 * paramInt2;
      i = 4;
    }
  }

  private final void zza(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    zzsx.beginSection("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    zzsx.endSection();
    zznc localzznc = this.zzbhl;
    localzznc.zzabl = (1 + localzznc.zzabl);
  }

  @TargetApi(21)
  private final void zza(MediaCodec paramMediaCodec, int paramInt, long paramLong1, long paramLong2)
  {
    zzej();
    zzsx.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong2);
    zzsx.endSection();
    zznc localzznc = this.zzbhl;
    localzznc.zzabk = (1 + localzznc.zzabk);
    this.zzboq = 0;
    zzkj();
  }

  private static boolean zza(boolean paramBoolean, zzlh paramzzlh1, zzlh paramzzlh2)
  {
    return (paramzzlh1.zzatq.equals(paramzzlh2.zzatq)) && (zzj(paramzzlh1) == zzj(paramzzlh2)) && ((paramBoolean) || ((paramzzlh1.width == paramzzlh2.width) && (paramzzlh1.height == paramzzlh2.height)));
  }

  private final void zzb(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    zzej();
    zzsx.beginSection("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    zzsx.endSection();
    zznc localzznc = this.zzbhl;
    localzznc.zzabk = (1 + localzznc.zzabk);
    this.zzboq = 0;
    zzkj();
  }

  private final void zzej()
  {
    if ((this.zzbou != this.zzaff) || (this.zzbov != this.zzafg) || (this.zzbow != this.zzbot) || (this.zzbox != this.zzafh))
    {
      this.zzbof.zzb(this.zzaff, this.zzafg, this.zzbot, this.zzafh);
      this.zzbou = this.zzaff;
      this.zzbov = this.zzafg;
      this.zzbow = this.zzbot;
      this.zzbox = this.zzafh;
    }
  }

  private static boolean zzer(long paramLong)
  {
    return paramLong < -30000L;
  }

  private static int zzi(zzlh paramzzlh)
  {
    if (paramzzlh.zzafs != -1)
      return paramzzlh.zzafs;
    return zza(paramzzlh.zzatq, paramzzlh.width, paramzzlh.height);
  }

  private static int zzj(zzlh paramzzlh)
  {
    if (paramzzlh.zzatt == -1)
      return 0;
    return paramzzlh.zzatt;
  }

  private final void zzkh()
  {
    if (this.zzbog > 0L);
    for (long l = SystemClock.elapsedRealtime() + this.zzbog; ; l = -9223372036854775807L)
    {
      this.zzboo = l;
      return;
    }
  }

  private final void zzki()
  {
    this.zzafb = false;
    if ((zzsy.SDK_INT >= 23) && (this.zzawy))
    {
      MediaCodec localMediaCodec = zzir();
      if (localMediaCodec != null)
        this.zzboy = new zztk(this, localMediaCodec, null);
    }
  }

  private final void zzkk()
  {
    this.zzbou = -1;
    this.zzbov = -1;
    this.zzbox = -1.0F;
    this.zzbow = -1;
  }

  private final void zzkl()
  {
    if ((this.zzbou != -1) || (this.zzbov != -1))
      this.zzbof.zzb(this.zzaff, this.zzafg, this.zzbot, this.zzafh);
  }

  private final void zzkm()
  {
    if (this.zzbop > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.zzafd;
      this.zzbof.zzg(this.zzbop, l2);
      this.zzbop = 0;
      this.zzafd = l1;
    }
  }

  private final boolean zzn(boolean paramBoolean)
  {
    return (zzsy.SDK_INT >= 23) && (!this.zzawy) && ((!paramBoolean) || (zztd.zzc(this.zzlj)));
  }

  public final boolean isReady()
  {
    if ((super.isReady()) && ((this.zzafb) || ((this.zzbom != null) && (this.zzaez == this.zzbom)) || (zzir() == null)))
      this.zzboo = -9223372036854775807L;
    do
    {
      return true;
      if (this.zzboo == -9223372036854775807L)
        return false;
    }
    while (SystemClock.elapsedRealtime() < this.zzboo);
    this.zzboo = -9223372036854775807L;
    return false;
  }

  protected final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i;
    int j;
    label65: int k;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i = 1;
      if (i == 0)
        break label179;
      j = 1 + (paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left"));
      this.zzaff = j;
      if (i == 0)
        break label191;
      k = 1 + (paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top"));
      label94: this.zzafg = k;
      this.zzafh = this.zzbos;
      if (zzsy.SDK_INT < 21)
        break label203;
      if ((this.zzbor == 90) || (this.zzbor == 270))
      {
        int m = this.zzaff;
        this.zzaff = this.zzafg;
        this.zzafg = m;
        this.zzafh = (1.0F / this.zzafh);
      }
    }
    while (true)
    {
      paramMediaCodec.setVideoScalingMode(this.zzbon);
      return;
      i = 0;
      break;
      label179: j = paramMediaFormat.getInteger("width");
      break label65;
      label191: k = paramMediaFormat.getInteger("height");
      break label94;
      label203: this.zzbot = this.zzbor;
    }
  }

  protected final void onStarted()
  {
    super.onStarted();
    this.zzbop = 0;
    this.zzafd = SystemClock.elapsedRealtime();
    this.zzboo = -9223372036854775807L;
  }

  protected final void onStopped()
  {
    zzkm();
    super.onStopped();
  }

  protected final int zza(zzpg paramzzpg, zzlh paramzzlh)
    throws zzpk
  {
    String str1 = paramzzlh.zzatq;
    if (!zzsp.zzbf(str1))
      return 0;
    zzne localzzne = paramzzlh.zzatr;
    if (localzzne != null)
    {
      int i1 = 0;
      bool1 = false;
      while (i1 < localzzne.zzazg)
      {
        bool1 |= localzzne.zzap(i1).zzazh;
        i1++;
      }
    }
    boolean bool1 = false;
    zzpd localzzpd = paramzzpg.zze(str1, bool1);
    if (localzzpd == null)
      return 1;
    boolean bool2 = localzzpd.zzat(paramzzlh.zzatn);
    int i;
    label153: int j;
    if ((bool2) && (paramzzlh.width > 0) && (paramzzlh.height > 0))
    {
      if (zzsy.SDK_INT >= 21)
        bool2 = localzzpd.zza(paramzzlh.width, paramzzlh.height, paramzzlh.zzats);
    }
    else
    {
      if (!localzzpd.zzabo)
        break label305;
      i = 8;
      boolean bool3 = localzzpd.zzawy;
      j = 0;
      if (bool3)
        j = 16;
      if (!bool2)
        break label311;
    }
    label303: label305: label311: for (int k = 3; ; k = 2)
    {
      return k | (j | i);
      if (paramzzlh.width * paramzzlh.height <= zzpi.zziw());
      for (bool2 = true; ; bool2 = false)
      {
        if (bool2)
          break label303;
        int m = paramzzlh.width;
        int n = paramzzlh.height;
        String str2 = zzsy.zzbnq;
        Log.d("MediaCodecVideoRenderer", 56 + String.valueOf(str2).length() + "FalseCheck [legacyFrameSize, " + m + "x" + n + "] [" + str2 + "]");
        break;
      }
      break;
      i = 4;
      break label153;
    }
  }

  public final void zza(int paramInt, Object paramObject)
    throws zzku
  {
    Surface localSurface;
    if (paramInt == 1)
    {
      localSurface = (Surface)paramObject;
      if (localSurface == null)
      {
        if (this.zzbom != null)
          localSurface = this.zzbom;
      }
      else
      {
        if (this.zzaez == localSurface)
          break label194;
        this.zzaez = localSurface;
        int i = getState();
        if ((i == 1) || (i == 2))
        {
          MediaCodec localMediaCodec2 = zzir();
          if ((zzsy.SDK_INT < 23) || (localMediaCodec2 == null) || (localSurface == null))
            break label174;
          localMediaCodec2.setOutputSurface(localSurface);
        }
        label93: if ((localSurface == null) || (localSurface == this.zzbom))
          break label185;
        zzkl();
        zzki();
        if (i == 2)
          zzkh();
      }
    }
    label174: label185: label194: MediaCodec localMediaCodec1;
    do
    {
      do
      {
        do
        {
          return;
          zzpd localzzpd = zzis();
          if ((localzzpd == null) || (!zzn(localzzpd.zzaer)))
            break;
          this.zzbom = zztd.zzc(this.zzlj, localzzpd.zzaer);
          localSurface = this.zzbom;
          break;
          zzed();
          zzea();
          break label93;
          zzkk();
          zzki();
          return;
        }
        while ((localSurface == null) || (localSurface == this.zzbom));
        zzkl();
      }
      while (!this.zzafb);
      this.zzbof.zzc(this.zzaez);
      return;
      if (paramInt != 4)
        break label265;
      this.zzbon = ((Integer)paramObject).intValue();
      localMediaCodec1 = zzir();
    }
    while (localMediaCodec1 == null);
    localMediaCodec1.setVideoScalingMode(this.zzbon);
    return;
    label265: super.zza(paramInt, paramObject);
  }

  protected final void zza(zznd paramzznd)
  {
    if ((zzsy.SDK_INT < 23) && (this.zzawy))
      zzkj();
  }

  protected final void zza(zzpd paramzzpd, MediaCodec paramMediaCodec, zzlh paramzzlh, MediaCrypto paramMediaCrypto)
    throws zzpk
  {
    zzlh[] arrayOfzzlh = this.zzbok;
    int i = paramzzlh.width;
    int j = paramzzlh.height;
    int k = zzi(paramzzlh);
    zztj localzztj1;
    if (arrayOfzzlh.length == 1)
    {
      localzztj1 = new zztj(i, j, k);
      this.zzbol = localzztj1;
      zztj localzztj2 = this.zzbol;
      boolean bool = this.zzboi;
      int m = this.zzaul;
      MediaFormat localMediaFormat = paramzzlh.zzen();
      localMediaFormat.setInteger("max-width", localzztj2.width);
      localMediaFormat.setInteger("max-height", localzztj2.height);
      if (localzztj2.zzbpb != -1)
        localMediaFormat.setInteger("max-input-size", localzztj2.zzbpb);
      if (bool)
        localMediaFormat.setInteger("auto-frc", 0);
      if (m != 0)
      {
        localMediaFormat.setFeatureEnabled("tunneled-playback", true);
        localMediaFormat.setInteger("audio-session-id", m);
      }
      if (this.zzaez == null)
      {
        zzsk.checkState(zzn(paramzzpd.zzaer));
        if (this.zzbom == null)
          this.zzbom = zztd.zzc(this.zzlj, paramzzpd.zzaer);
        this.zzaez = this.zzbom;
      }
      paramMediaCodec.configure(localMediaFormat, this.zzaez, null, 0);
      if ((zzsy.SDK_INT >= 23) && (this.zzawy))
        this.zzboy = new zztk(this, paramMediaCodec, null);
      return;
    }
    int n = 0;
    int i1 = arrayOfzzlh.length;
    int i2 = 0;
    label263: int i19;
    label311: int i15;
    int i20;
    int i16;
    int i17;
    if (i2 < i1)
    {
      zzlh localzzlh = arrayOfzzlh[i2];
      if (!zza(paramzzpd.zzabo, paramzzlh, localzzlh))
        break label836;
      if ((localzzlh.width == -1) || (localzzlh.height == -1))
      {
        i19 = 1;
        i15 = i19 | n;
        i20 = Math.max(i, localzzlh.width);
        int i21 = Math.max(j, localzzlh.height);
        i16 = Math.max(k, zzi(localzzlh));
        i17 = i21;
      }
    }
    for (int i18 = i20; ; i18 = i)
    {
      i2++;
      i = i18;
      j = i17;
      k = i16;
      n = i15;
      break label263;
      i19 = 0;
      break label311;
      int i3;
      label450: int i4;
      label461: int i5;
      label472: int i7;
      label494: int i8;
      int i9;
      Object localObject;
      if (n != 0)
      {
        Log.w("MediaCodecVideoRenderer", 66 + "Resolutions unknown. Codec max resolution: " + i + "x" + j);
        if (paramzzlh.height <= paramzzlh.width)
          break label640;
        i3 = 1;
        if (i3 == 0)
          break label646;
        i4 = paramzzlh.height;
        if (i3 == 0)
          break label655;
        i5 = paramzzlh.width;
        float f1 = i5 / i4;
        int[] arrayOfInt = zzbod;
        int i6 = arrayOfInt.length;
        i7 = 0;
        if (i7 >= i6)
          break label830;
        i8 = arrayOfInt[i7];
        i9 = (int)(f1 * i8);
        if ((i8 > i4) && (i9 > i5))
          break label664;
        localObject = null;
      }
      while (true)
      {
        if (localObject != null)
        {
          i = Math.max(i, ((Point)localObject).x);
          j = Math.max(j, ((Point)localObject).y);
          k = Math.max(k, zza(paramzzlh.zzatq, i, j));
          Log.w("MediaCodecVideoRenderer", 57 + "Codec max resolution adjusted to: " + i + "x" + j);
        }
        localzztj1 = new zztj(i, j, k);
        break;
        label640: i3 = 0;
        break label450;
        label646: i4 = paramzzlh.width;
        break label461;
        label655: i5 = paramzzlh.height;
        break label472;
        label664: if (zzsy.SDK_INT >= 21)
        {
          int i14;
          if (i3 != 0)
          {
            i14 = i9;
            label681: if (i3 == 0)
              break label736;
          }
          while (true)
          {
            Point localPoint = paramzzpd.zze(i14, i8);
            float f2 = paramzzlh.zzats;
            if (!paramzzpd.zza(localPoint.x, localPoint.y, f2))
              break label824;
            localObject = localPoint;
            break;
            i14 = i8;
            break label681;
            label736: i8 = i9;
          }
        }
        int i10 = zzsy.zzb(i8, 16) << 4;
        int i11 = zzsy.zzb(i9, 16) << 4;
        if (i10 * i11 <= zzpi.zziw())
        {
          int i12;
          if (i3 != 0)
          {
            i12 = i11;
            label785: if (i3 == 0)
              break label817;
          }
          label817: for (int i13 = i10; ; i13 = i11)
          {
            localObject = new Point(i12, i13);
            break;
            i12 = i10;
            break label785;
          }
        }
        label824: i7++;
        break label494;
        label830: localObject = null;
      }
      label836: i15 = n;
      i16 = k;
      i17 = j;
    }
  }

  protected final void zza(zzlh[] paramArrayOfzzlh, long paramLong)
    throws zzku
  {
    this.zzbok = paramArrayOfzzlh;
    if (this.zzboz == -9223372036854775807L)
    {
      this.zzboz = paramLong;
      super.zza(paramArrayOfzzlh, paramLong);
      return;
    }
    if (this.zzbpa == this.zzboj.length)
    {
      long l = this.zzboj[(-1 + this.zzbpa)];
      Log.w("MediaCodecVideoRenderer", 65 + "Too many stream changes, so dropping offset: " + l);
    }
    while (true)
    {
      this.zzboj[(-1 + this.zzbpa)] = paramLong;
      break;
      this.zzbpa = (1 + this.zzbpa);
    }
  }

  protected final boolean zza(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean)
  {
    while ((this.zzbpa != 0) && (paramLong3 >= this.zzboj[0]))
    {
      this.zzboz = this.zzboj[0];
      this.zzbpa = (-1 + this.zzbpa);
      System.arraycopy(this.zzboj, 1, this.zzboj, 0, this.zzbpa);
    }
    long l1 = paramLong3 - this.zzboz;
    if (paramBoolean)
    {
      zza(paramMediaCodec, paramInt1, l1);
      return true;
    }
    long l2 = paramLong3 - paramLong1;
    if (this.zzaez == this.zzbom)
    {
      if (zzer(l2))
      {
        zza(paramMediaCodec, paramInt1, l1);
        return true;
      }
      return false;
    }
    if (!this.zzafb)
    {
      if (zzsy.SDK_INT >= 21)
        zza(paramMediaCodec, paramInt1, l1, System.nanoTime());
      while (true)
      {
        return true;
        zzb(paramMediaCodec, paramInt1, l1);
      }
    }
    if (getState() != 2)
      return false;
    long l3 = l2 - (1000L * SystemClock.elapsedRealtime() - paramLong2);
    long l4 = System.nanoTime();
    long l5 = l4 + l3 * 1000L;
    long l6 = this.zzboe.zzg(paramLong3, l5);
    long l7 = (l6 - l4) / 1000L;
    if (zzer(l7))
    {
      zzsx.beginSection("dropVideoBuffer");
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      zzsx.endSection();
      zznc localzznc = this.zzbhl;
      localzznc.zzabm = (1 + localzznc.zzabm);
      this.zzbop = (1 + this.zzbop);
      this.zzboq = (1 + this.zzboq);
      this.zzbhl.zzazd = Math.max(this.zzboq, this.zzbhl.zzazd);
      if (this.zzbop == this.zzboh)
        zzkm();
      return true;
    }
    if (zzsy.SDK_INT >= 21)
    {
      if (l7 < 50000L)
      {
        zza(paramMediaCodec, paramInt1, l1, l6);
        return true;
      }
    }
    else if (l7 < 30000L)
    {
      long l8;
      if (l7 > 11000L)
        l8 = l7 - 10000L;
      try
      {
        Thread.sleep(l8 / 1000L);
        zzb(paramMediaCodec, paramInt1, l1);
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

  protected final boolean zza(MediaCodec paramMediaCodec, boolean paramBoolean, zzlh paramzzlh1, zzlh paramzzlh2)
  {
    return (zza(paramBoolean, paramzzlh1, paramzzlh2)) && (paramzzlh2.width <= this.zzbol.width) && (paramzzlh2.height <= this.zzbol.height) && (paramzzlh2.zzafs <= this.zzbol.zzbpb);
  }

  protected final boolean zza(zzpd paramzzpd)
  {
    return (this.zzaez != null) || (zzn(paramzzpd.zzaer));
  }

  protected final void zzd(long paramLong, boolean paramBoolean)
    throws zzku
  {
    super.zzd(paramLong, paramBoolean);
    zzki();
    this.zzboq = 0;
    if (this.zzbpa != 0)
    {
      this.zzboz = this.zzboj[(-1 + this.zzbpa)];
      this.zzbpa = 0;
    }
    if (paramBoolean)
    {
      zzkh();
      return;
    }
    this.zzboo = -9223372036854775807L;
  }

  protected final void zzd(zzlh paramzzlh)
    throws zzku
  {
    super.zzd(paramzzlh);
    this.zzbof.zzc(paramzzlh);
    if (paramzzlh.zzaft == -1.0F);
    for (float f = 1.0F; ; f = paramzzlh.zzaft)
    {
      this.zzbos = f;
      this.zzbor = zzj(paramzzlh);
      return;
    }
  }

  protected final void zzd(String paramString, long paramLong1, long paramLong2)
  {
    this.zzbof.zzc(paramString, paramLong1, paramLong2);
  }

  protected final void zzdz()
  {
    this.zzaff = -1;
    this.zzafg = -1;
    this.zzafh = -1.0F;
    this.zzbos = -1.0F;
    this.zzboz = -9223372036854775807L;
    this.zzbpa = 0;
    zzkk();
    zzki();
    this.zzboe.disable();
    this.zzboy = null;
    this.zzawy = false;
    try
    {
      super.zzdz();
      return;
    }
    finally
    {
      this.zzbhl.zzdk();
      this.zzbof.zzd(this.zzbhl);
    }
  }

  protected final void zzed()
  {
    try
    {
      super.zzed();
      return;
    }
    finally
    {
      if (this.zzbom != null)
      {
        if (this.zzaez == this.zzbom)
          this.zzaez = null;
        this.zzbom.release();
        this.zzbom = null;
      }
    }
  }

  protected final void zzg(boolean paramBoolean)
    throws zzku
  {
    super.zzg(paramBoolean);
    this.zzaul = zzgq().zzaul;
    if (this.zzaul != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.zzawy = bool;
      this.zzbof.zzc(this.zzbhl);
      this.zzboe.enable();
      return;
    }
  }

  final void zzkj()
  {
    if (!this.zzafb)
    {
      this.zzafb = true;
      this.zzbof.zzc(this.zzaez);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzth
 * JD-Core Version:    0.6.2
 */