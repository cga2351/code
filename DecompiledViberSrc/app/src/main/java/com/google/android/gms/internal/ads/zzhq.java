package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzhq
{
  private static boolean zzagc = false;
  private int zzafv;
  private final ConditionVariable zzagd = new ConditionVariable(true);
  private final long[] zzage;
  private final zzhs zzagf;
  private AudioTrack zzagg;
  private int zzagh;
  private int zzagi;
  private int zzagj;
  private int zzagk;
  private int zzagl;
  private int zzagm;
  private int zzagn;
  private long zzago;
  private long zzagp;
  private boolean zzagq;
  private long zzagr;
  private Method zzags;
  private long zzagt;
  private int zzagu;
  private long zzagv;
  private long zzagw;
  private long zzagx;
  private byte[] zzagy;
  private int zzagz;
  private int zzaha;
  private boolean zzahb;
  private int zzahc;
  private float zzcv;

  public zzhq()
  {
    if (zzkq.SDK_INT >= 18);
    try
    {
      this.zzags = AudioTrack.class.getMethod("getLatency", null);
      label36: if (zzkq.SDK_INT >= 19);
      for (this.zzagf = new zzht(); ; this.zzagf = new zzhs(null))
      {
        this.zzage = new long[10];
        this.zzcv = 1.0F;
        this.zzagu = 0;
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label36;
    }
  }

  private final long zzdn(long paramLong)
  {
    if (this.zzahb)
    {
      if (this.zzahc == 0)
        return 0L;
      return (paramLong << 3) * this.zzafv / (1000 * this.zzahc);
    }
    return paramLong / this.zzagj;
  }

  private final long zzdo(long paramLong)
  {
    return 1000000L * paramLong / this.zzafv;
  }

  private final long zzdp(long paramLong)
  {
    return paramLong * this.zzafv / 1000000L;
  }

  private final void zzet()
  {
    this.zzago = 0L;
    this.zzagn = 0;
    this.zzagm = 0;
    this.zzagp = 0L;
    this.zzagq = false;
    this.zzagr = 0L;
  }

  public final boolean isInitialized()
  {
    return this.zzagg != null;
  }

  public final void pause()
  {
    if (isInitialized())
    {
      zzet();
      this.zzagg.pause();
    }
  }

  public final void play()
  {
    if (isInitialized())
    {
      this.zzagw = (System.nanoTime() / 1000L);
      this.zzagg.play();
    }
  }

  public final void reset()
  {
    if (isInitialized())
    {
      this.zzagt = 0L;
      this.zzaha = 0;
      this.zzagv = 0L;
      this.zzagx = 0L;
      zzet();
      if (this.zzagg.getPlayState() == 3)
        this.zzagg.pause();
      AudioTrack localAudioTrack = this.zzagg;
      this.zzagg = null;
      this.zzagf.zza(null, false);
      this.zzagd.close();
      new zzhr(this, localAudioTrack).start();
    }
  }

  public final void setVolume(float paramFloat)
  {
    this.zzcv = paramFloat;
    if (isInitialized())
    {
      if (zzkq.SDK_INT >= 21)
        this.zzagg.setVolume(paramFloat);
    }
    else
      return;
    this.zzagg.setStereoVolume(paramFloat, paramFloat);
  }

  public final int zza(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong)
    throws zzhv
  {
    int j;
    if (paramInt2 == 0)
      j = 2;
    label444: label462: 
    do
    {
      return j;
      if ((zzkq.SDK_INT <= 22) && (this.zzahb))
      {
        if (this.zzagg.getPlayState() == 2)
          return 0;
        if ((this.zzagg.getPlayState() == 1) && (this.zzagf.zzev() != 0L))
          return 0;
      }
      int i = this.zzaha;
      j = 0;
      long l1;
      int k;
      if (i == 0)
      {
        if ((this.zzahb) && (this.zzahc == 0))
          this.zzahc = zzkg.zza(paramInt2, this.zzafv);
        l1 = paramLong - zzdo(zzdn(paramInt2));
        if (this.zzagv == 0L)
        {
          this.zzagv = Math.max(0L, l1);
          this.zzagu = 1;
        }
      }
      else
      {
        if (this.zzaha == 0)
        {
          this.zzaha = paramInt2;
          paramByteBuffer.position(paramInt1);
          if (zzkq.SDK_INT < 21)
          {
            if ((this.zzagy == null) || (this.zzagy.length < paramInt2))
              this.zzagy = new byte[paramInt2];
            paramByteBuffer.get(this.zzagy, 0, paramInt2);
            this.zzagz = 0;
          }
        }
        if (zzkq.SDK_INT >= 21)
          break label444;
        int m = (int)(this.zzagt - this.zzagf.zzev() * this.zzagj);
        int n = this.zzagl - m;
        k = 0;
        if (n > 0)
        {
          int i1 = Math.min(this.zzaha, n);
          k = this.zzagg.write(this.zzagy, this.zzagz, i1);
          if (k >= 0)
            this.zzagz = (k + this.zzagz);
        }
      }
      while (true)
      {
        if (k >= 0)
          break label462;
        throw new zzhv(k);
        long l2 = this.zzagv + zzdo(zzdn(this.zzagt));
        if ((this.zzagu == 1) && (Math.abs(l2 - l1) > 200000L))
        {
          Log.e("AudioTrack", 80 + "Discontinuity detected [expected " + l2 + ", got " + l1 + "]");
          this.zzagu = 2;
        }
        int i2 = this.zzagu;
        j = 0;
        if (i2 != 2)
          break;
        this.zzagv += l1 - l2;
        this.zzagu = 1;
        j = 1;
        break;
        k = this.zzagg.write(paramByteBuffer, this.zzaha, 1);
      }
      this.zzaha -= k;
      this.zzagt += k;
    }
    while (this.zzaha != 0);
    return j | 0x2;
  }

  public final void zza(MediaFormat paramMediaFormat, int paramInt)
  {
    boolean bool1 = true;
    int i = paramMediaFormat.getInteger("channel-count");
    int j;
    int k;
    String str;
    int m;
    switch (i)
    {
    case 3:
    case 4:
    case 5:
    case 7:
    default:
      throw new IllegalArgumentException(38 + "Unsupported channel count: " + i);
    case 1:
      j = 4;
      k = paramMediaFormat.getInteger("sample-rate");
      str = paramMediaFormat.getString("mime");
      if ("audio/ac3".equals(str))
      {
        m = 5;
        label126: if ((m != 5) && (m != 6))
          break label241;
      }
      break;
    case 2:
    case 6:
    case 8:
    }
    label241: for (boolean bool2 = bool1; ; bool2 = false)
    {
      if ((!isInitialized()) || (this.zzafv != k) || (this.zzagh != j) || (this.zzahb) || (bool2))
        break label247;
      return;
      j = 12;
      break;
      j = 252;
      break;
      j = 1020;
      break;
      if ("audio/eac3".equals(str))
      {
        m = 6;
        break label126;
      }
      if (zzkl.zzav(str))
      {
        m = 2;
        break label126;
      }
      m = 0;
      break label126;
    }
    label247: reset();
    this.zzagi = m;
    this.zzafv = k;
    this.zzagh = j;
    this.zzahb = bool2;
    this.zzahc = 0;
    this.zzagj = (i * 2);
    this.zzagk = AudioTrack.getMinBufferSize(k, j, m);
    int n;
    int i1;
    int i2;
    if (this.zzagk != -2)
    {
      zzkh.checkState(bool1);
      n = this.zzagk << 2;
      i1 = (int)zzdp(250000L) * this.zzagj;
      i2 = (int)Math.max(this.zzagk, zzdp(750000L) * this.zzagj);
      if (n >= i1)
        break label380;
    }
    while (true)
    {
      this.zzagl = i1;
      return;
      bool1 = false;
      break;
      label380: if (n > i2)
        i1 = i2;
      else
        i1 = n;
    }
  }

  public final void zzeq()
  {
    if (this.zzagu == 1)
      this.zzagu = 2;
  }

  public final boolean zzer()
  {
    return (isInitialized()) && ((zzdn(this.zzagt) > this.zzagf.zzev()) || (this.zzagf.zzeu()));
  }

  public final boolean zzes()
  {
    return this.zzagt > 3 * this.zzagk / 2;
  }

  public final long zzf(boolean paramBoolean)
  {
    int i;
    long l2;
    if ((isInitialized()) && (this.zzagv != 0L))
    {
      i = 1;
      if (i != 0)
        break label35;
      l2 = -9223372036854775808L;
    }
    while (true)
    {
      return l2;
      i = 0;
      break;
      label35: long l3;
      long l4;
      long l6;
      long l7;
      if (this.zzagg.getPlayState() == 3)
      {
        l3 = this.zzagf.zzew();
        if (l3 != 0L)
        {
          l4 = System.nanoTime() / 1000L;
          if (l4 - this.zzagp >= 30000L)
          {
            this.zzage[this.zzagm] = (l3 - l4);
            this.zzagm = ((1 + this.zzagm) % 10);
            if (this.zzagn < 10)
              this.zzagn = (1 + this.zzagn);
            this.zzagp = l4;
            this.zzago = 0L;
            for (int j = 0; j < this.zzagn; j++)
              this.zzago += this.zzage[j] / this.zzagn;
          }
          if ((!this.zzahb) && (l4 - this.zzagr >= 500000L))
          {
            this.zzagq = this.zzagf.zzex();
            if (this.zzagq)
            {
              l6 = this.zzagf.zzey() / 1000L;
              l7 = this.zzagf.zzez();
              if (l6 >= this.zzagw)
                break label425;
              this.zzagq = false;
            }
          }
        }
      }
      long l1;
      while (true)
      {
        if (this.zzags != null);
        try
        {
          this.zzagx = (1000L * ((Integer)this.zzags.invoke(this.zzagg, null)).intValue() - zzdo(zzdn(this.zzagl)));
          this.zzagx = Math.max(this.zzagx, 0L);
          if (this.zzagx > 5000000L)
          {
            long l5 = this.zzagx;
            Log.w("AudioTrack", 61 + "Ignoring impossibly large audio latency: " + l5);
            this.zzagx = 0L;
          }
          this.zzagr = l4;
          l1 = System.nanoTime() / 1000L;
          if (this.zzagq)
          {
            return zzdo(zzdp(l1 - this.zzagf.zzey() / 1000L) + this.zzagf.zzez()) + this.zzagv;
            label425: if (Math.abs(l6 - l4) > 5000000L)
            {
              this.zzagq = false;
              Log.w("AudioTrack", 136 + "Spurious audio timestamp (system clock mismatch): " + l7 + ", " + l6 + ", " + l4 + ", " + l3);
              continue;
            }
            if (Math.abs(zzdo(l7) - l3) <= 5000000L)
              continue;
            this.zzagq = false;
            Log.w("AudioTrack", 138 + "Spurious audio timestamp (frame position mismatch): " + l7 + ", " + l6 + ", " + l4 + ", " + l3);
          }
        }
        catch (Exception localException)
        {
          while (true)
            this.zzags = null;
        }
      }
      if (this.zzagn == 0);
      for (l2 = this.zzagf.zzew() + this.zzagv; !paramBoolean; l2 = l1 + this.zzago + this.zzagv)
        return l2 - this.zzagx;
    }
  }

  // ERROR //
  public final int zzq(int paramInt)
    throws zzhu
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/google/android/gms/internal/ads/zzhq:zzagd	Landroid/os/ConditionVariable;
    //   4: invokevirtual 392	android/os/ConditionVariable:block	()V
    //   7: iload_1
    //   8: ifne +78 -> 86
    //   11: aload_0
    //   12: new 69	android/media/AudioTrack
    //   15: dup
    //   16: iconst_3
    //   17: aload_0
    //   18: getfield 105	com/google/android/gms/internal/ads/zzhq:zzafv	I
    //   21: aload_0
    //   22: getfield 304	com/google/android/gms/internal/ads/zzhq:zzagh	I
    //   25: aload_0
    //   26: getfield 316	com/google/android/gms/internal/ads/zzhq:zzagi	I
    //   29: aload_0
    //   30: getfield 221	com/google/android/gms/internal/ads/zzhq:zzagl	I
    //   33: iconst_1
    //   34: invokespecial 395	android/media/AudioTrack:<init>	(IIIIII)V
    //   37: putfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   40: aload_0
    //   41: getfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   44: invokevirtual 398	android/media/AudioTrack:getState	()I
    //   47: istore_2
    //   48: iload_2
    //   49: iconst_1
    //   50: if_icmpeq +89 -> 139
    //   53: aload_0
    //   54: getfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   57: invokevirtual 401	android/media/AudioTrack:release	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   65: new 389	com/google/android/gms/internal/ads/zzhu
    //   68: dup
    //   69: iload_2
    //   70: aload_0
    //   71: getfield 105	com/google/android/gms/internal/ads/zzhq:zzafv	I
    //   74: aload_0
    //   75: getfield 304	com/google/android/gms/internal/ads/zzhq:zzagh	I
    //   78: aload_0
    //   79: getfield 221	com/google/android/gms/internal/ads/zzhq:zzagl	I
    //   82: invokespecial 404	com/google/android/gms/internal/ads/zzhu:<init>	(IIII)V
    //   85: athrow
    //   86: aload_0
    //   87: new 69	android/media/AudioTrack
    //   90: dup
    //   91: iconst_3
    //   92: aload_0
    //   93: getfield 105	com/google/android/gms/internal/ads/zzhq:zzafv	I
    //   96: aload_0
    //   97: getfield 304	com/google/android/gms/internal/ads/zzhq:zzagh	I
    //   100: aload_0
    //   101: getfield 316	com/google/android/gms/internal/ads/zzhq:zzagi	I
    //   104: aload_0
    //   105: getfield 221	com/google/android/gms/internal/ads/zzhq:zzagl	I
    //   108: iconst_1
    //   109: iload_1
    //   110: invokespecial 407	android/media/AudioTrack:<init>	(IIIIIII)V
    //   113: putfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   116: goto -76 -> 40
    //   119: astore 5
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   126: goto -61 -> 65
    //   129: astore 4
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   136: aload 4
    //   138: athrow
    //   139: aload_0
    //   140: getfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   143: invokevirtual 410	android/media/AudioTrack:getAudioSessionId	()I
    //   146: istore_3
    //   147: aload_0
    //   148: getfield 84	com/google/android/gms/internal/ads/zzhq:zzagf	Lcom/google/android/gms/internal/ads/zzhs;
    //   151: aload_0
    //   152: getfield 128	com/google/android/gms/internal/ads/zzhq:zzagg	Landroid/media/AudioTrack;
    //   155: aload_0
    //   156: getfield 101	com/google/android/gms/internal/ads/zzhq:zzahb	Z
    //   159: invokevirtual 164	com/google/android/gms/internal/ads/zzhs:zza	(Landroid/media/AudioTrack;Z)V
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 88	com/google/android/gms/internal/ads/zzhq:zzcv	F
    //   167: invokevirtual 412	com/google/android/gms/internal/ads/zzhq:setVolume	(F)V
    //   170: iload_3
    //   171: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   53	60	119	java/lang/Exception
    //   53	60	129	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhq
 * JD-Core Version:    0.6.2
 */