package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class zzmh
{
  private static boolean zzagc = false;
  private static boolean zzavt = false;
  private int streamType;
  private int zzada;
  private ByteBuffer[] zzadt;
  private int zzafv;
  private final ConditionVariable zzagd;
  private final long[] zzage;
  private AudioTrack zzagg;
  private int zzagh;
  private int zzagi;
  private int zzagl;
  private int zzagm;
  private int zzagn;
  private long zzago;
  private long zzagp;
  private boolean zzagq;
  private long zzagr;
  private Method zzags;
  private int zzagu;
  private long zzagv;
  private long zzagw;
  private long zzagx;
  private zzln zzasc;
  private final zzlw zzavu = null;
  private final zzmq zzavv;
  private final zzmx zzavw;
  private final zzlx[] zzavx;
  private final zzmn zzavy;
  private final zzmj zzavz;
  private final LinkedList<zzmo> zzawa;
  private int zzawb;
  private boolean zzawc;
  private long zzawd;
  private zzln zzawe;
  private long zzawf;
  private long zzawg;
  private ByteBuffer zzawh;
  private int zzawi;
  private int zzawj;
  private long zzawk;
  private long zzawl;
  private int zzawm;
  private long zzawn;
  private long zzawo;
  private int zzawp;
  private zzlx[] zzawq;
  private ByteBuffer zzawr;
  private ByteBuffer zzaws;
  private byte[] zzawt;
  private int zzawu;
  private int zzawv;
  private boolean zzaww;
  private boolean zzawx;
  private boolean zzawy;
  private boolean zzawz;
  private long zzaxa;
  private float zzcv;

  public zzmh(zzlw paramzzlw, zzlx[] paramArrayOfzzlx, zzmn paramzzmn)
  {
    this.zzavy = paramzzmn;
    this.zzagd = new ConditionVariable(true);
    if (zzsy.SDK_INT >= 18);
    try
    {
      this.zzags = AudioTrack.class.getMethod("getLatency", null);
      label46: if (zzsy.SDK_INT >= 19);
      for (this.zzavz = new zzmk(); ; this.zzavz = new zzmj(null))
      {
        this.zzavv = new zzmq();
        this.zzavw = new zzmx();
        this.zzavx = new zzlx[3 + paramArrayOfzzlx.length];
        this.zzavx[0] = new zzmv();
        this.zzavx[1] = this.zzavv;
        System.arraycopy(paramArrayOfzzlx, 0, this.zzavx, 2, paramArrayOfzzlx.length);
        this.zzavx[(2 + paramArrayOfzzlx.length)] = this.zzavw;
        this.zzage = new long[10];
        this.zzcv = 1.0F;
        this.zzagu = 0;
        this.streamType = 3;
        this.zzada = 0;
        this.zzasc = zzln.zzaug;
        this.zzawv = -1;
        this.zzawq = new zzlx[0];
        this.zzadt = new ByteBuffer[0];
        this.zzawa = new LinkedList();
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label46;
    }
  }

  private final boolean isInitialized()
  {
    return this.zzagg != null;
  }

  private final boolean zzb(ByteBuffer paramByteBuffer, long paramLong)
    throws zzmp
  {
    if (!paramByteBuffer.hasRemaining())
      return true;
    boolean bool2;
    label32: int k;
    int m;
    if (this.zzaws != null)
      if (this.zzaws == paramByteBuffer)
      {
        bool2 = true;
        zzsk.checkArgument(bool2);
        k = paramByteBuffer.remaining();
        if (zzsy.SDK_INT >= 21)
          break label242;
        int i1 = (int)(this.zzawn - this.zzavz.zzev() * this.zzawm);
        int i2 = this.zzagl - i1;
        if (i2 <= 0)
          break label527;
        int i3 = Math.min(k, i2);
        m = this.zzagg.write(this.zzawt, this.zzawu, i3);
        if (m > 0)
        {
          this.zzawu = (m + this.zzawu);
          paramByteBuffer.position(m + paramByteBuffer.position());
        }
      }
    while (true)
    {
      this.zzaxa = SystemClock.elapsedRealtime();
      if (m < 0)
      {
        throw new zzmp(m);
        bool2 = false;
        break;
        this.zzaws = paramByteBuffer;
        if (zzsy.SDK_INT >= 21)
          break label32;
        int i = paramByteBuffer.remaining();
        if ((this.zzawt == null) || (this.zzawt.length < i))
          this.zzawt = new byte[i];
        int j = paramByteBuffer.position();
        paramByteBuffer.get(this.zzawt, 0, i);
        paramByteBuffer.position(j);
        this.zzawu = 0;
        break label32;
        label242: if (this.zzawy)
        {
          if (paramLong != -9223372036854775807L);
          AudioTrack localAudioTrack;
          int n;
          for (boolean bool1 = true; ; bool1 = false)
          {
            zzsk.checkState(bool1);
            localAudioTrack = this.zzagg;
            if (this.zzawh == null)
            {
              this.zzawh = ByteBuffer.allocate(16);
              this.zzawh.order(ByteOrder.BIG_ENDIAN);
              this.zzawh.putInt(1431633921);
            }
            if (this.zzawi == 0)
            {
              this.zzawh.putInt(4, k);
              this.zzawh.putLong(8, 1000L * paramLong);
              this.zzawh.position(0);
              this.zzawi = k;
            }
            n = this.zzawh.remaining();
            if (n <= 0)
              break label417;
            m = localAudioTrack.write(this.zzawh, n, 1);
            if (m >= 0)
              break label404;
            this.zzawi = 0;
            break;
          }
          if (m < n)
          {
            m = 0;
            continue;
          }
          m = localAudioTrack.write(paramByteBuffer, k, 1);
          if (m < 0)
          {
            this.zzawi = 0;
            continue;
          }
          this.zzawi -= m;
          continue;
        }
        label404: label417: m = this.zzagg.write(paramByteBuffer, k, 1);
        continue;
      }
      if (!this.zzawc)
        this.zzawn += m;
      if (m == k)
      {
        if (this.zzawc)
          this.zzawo += this.zzawp;
        this.zzaws = null;
        return true;
      }
      return false;
      label527: m = 0;
    }
  }

  private static int zzba(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 187078296:
    case 1504578661:
    case -1095064472:
    case 1505942594:
    }
    while (true)
      switch (i)
      {
      default:
        return 0;
        if (paramString.equals("audio/ac3"))
        {
          i = 0;
          continue;
          if (paramString.equals("audio/eac3"))
          {
            i = 1;
            continue;
            if (paramString.equals("audio/vnd.dts"))
            {
              i = 2;
              continue;
              if (paramString.equals("audio/vnd.dts.hd"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    return 5;
    return 6;
    return 7;
    return 8;
  }

  private final long zzdo(long paramLong)
  {
    return 1000000L * paramLong / this.zzafv;
  }

  private final long zzdp(long paramLong)
  {
    return paramLong * this.zzafv / 1000000L;
  }

  private final void zzeg(long paramLong)
    throws zzmp
  {
    int i = this.zzawq.length;
    int j = i;
    while (true)
    {
      ByteBuffer localByteBuffer1;
      if (j >= 0)
      {
        if (j <= 0)
          break label53;
        localByteBuffer1 = this.zzadt[(j - 1)];
        label30: if (j != i)
          break label77;
        zzb(localByteBuffer1, paramLong);
      }
      while (true)
        if (localByteBuffer1.hasRemaining())
        {
          return;
          label53: if (this.zzawr != null)
          {
            localByteBuffer1 = this.zzawr;
            break label30;
          }
          localByteBuffer1 = zzlx.zzavh;
          break label30;
          label77: zzlx localzzlx = this.zzawq[j];
          localzzlx.zzi(localByteBuffer1);
          ByteBuffer localByteBuffer2 = localzzlx.zzhm();
          this.zzadt[j] = localByteBuffer2;
          if (localByteBuffer2.hasRemaining())
          {
            j++;
            break;
          }
        }
      j--;
    }
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

  private final void zzhn()
  {
    ArrayList localArrayList = new ArrayList();
    zzlx[] arrayOfzzlx = this.zzavx;
    int i = arrayOfzzlx.length;
    int j = 0;
    if (j < i)
    {
      zzlx localzzlx2 = arrayOfzzlx[j];
      if (localzzlx2.isActive())
        localArrayList.add(localzzlx2);
      while (true)
      {
        j++;
        break;
        localzzlx2.flush();
      }
    }
    int k = localArrayList.size();
    this.zzawq = ((zzlx[])localArrayList.toArray(new zzlx[k]));
    this.zzadt = new ByteBuffer[k];
    for (int m = 0; m < k; m++)
    {
      zzlx localzzlx1 = this.zzawq[m];
      localzzlx1.flush();
      this.zzadt[m] = localzzlx1.zzhm();
    }
  }

  private final boolean zzhp()
    throws zzmp
  {
    int j;
    int i;
    if (this.zzawv == -1)
      if (this.zzawc)
      {
        j = this.zzawq.length;
        this.zzawv = j;
        i = 1;
      }
    while (true)
    {
      label30: if (this.zzawv < this.zzawq.length)
      {
        zzlx localzzlx = this.zzawq[this.zzawv];
        if (i != 0)
          localzzlx.zzhl();
        zzeg(-9223372036854775807L);
        if (localzzlx.zzdx());
      }
      do
      {
        return false;
        j = 0;
        break;
        this.zzawv = (1 + this.zzawv);
        i = 1;
        break label30;
        if (this.zzaws == null)
          break label127;
        zzb(this.zzaws, -9223372036854775807L);
      }
      while (this.zzaws != null);
      label127: this.zzawv = -1;
      return true;
      i = 0;
    }
  }

  private final void zzhs()
  {
    if (isInitialized())
    {
      if (zzsy.SDK_INT >= 21)
        this.zzagg.setVolume(this.zzcv);
    }
    else
      return;
    AudioTrack localAudioTrack = this.zzagg;
    float f = this.zzcv;
    localAudioTrack.setStereoVolume(f, f);
  }

  private final long zzht()
  {
    if (this.zzawc)
      return this.zzawo;
    return this.zzawn / this.zzawm;
  }

  private final boolean zzhu()
  {
    return (zzsy.SDK_INT < 23) && ((this.zzawb == 5) || (this.zzawb == 6));
  }

  public final void pause()
  {
    this.zzawx = false;
    if (isInitialized())
    {
      zzet();
      this.zzavz.pause();
    }
  }

  public final void play()
  {
    this.zzawx = true;
    if (isInitialized())
    {
      this.zzagw = (System.nanoTime() / 1000L);
      this.zzagg.play();
    }
  }

  public final void release()
  {
    reset();
    zzlx[] arrayOfzzlx = this.zzavx;
    int i = arrayOfzzlx.length;
    for (int j = 0; j < i; j++)
      arrayOfzzlx[j].reset();
    this.zzada = 0;
    this.zzawx = false;
  }

  public final void reset()
  {
    if (isInitialized())
    {
      this.zzawk = 0L;
      this.zzawl = 0L;
      this.zzawn = 0L;
      this.zzawo = 0L;
      this.zzawp = 0;
      if (this.zzawe != null)
      {
        this.zzasc = this.zzawe;
        this.zzawe = null;
      }
      while (true)
      {
        this.zzawa.clear();
        this.zzawf = 0L;
        this.zzawg = 0L;
        this.zzawr = null;
        this.zzaws = null;
        for (int i = 0; i < this.zzawq.length; i++)
        {
          zzlx localzzlx = this.zzawq[i];
          localzzlx.flush();
          this.zzadt[i] = localzzlx.zzhm();
        }
        if (!this.zzawa.isEmpty())
          this.zzasc = zzmo.zza((zzmo)this.zzawa.getLast());
      }
      this.zzaww = false;
      this.zzawv = -1;
      this.zzawh = null;
      this.zzawi = 0;
      this.zzagu = 0;
      this.zzagx = 0L;
      zzet();
      if (this.zzagg.getPlayState() == 3)
        this.zzagg.pause();
      AudioTrack localAudioTrack = this.zzagg;
      this.zzagg = null;
      this.zzavz.zza(null, false);
      this.zzagd.close();
      new zzmi(this, localAudioTrack).start();
    }
  }

  public final void setStreamType(int paramInt)
  {
    if (this.streamType == paramInt);
    do
    {
      return;
      this.streamType = paramInt;
    }
    while (this.zzawy);
    reset();
    this.zzada = 0;
  }

  public final void setVolume(float paramFloat)
  {
    if (this.zzcv != paramFloat)
    {
      this.zzcv = paramFloat;
      zzhs();
    }
  }

  public final void zza(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
    throws zzml
  {
    boolean bool1;
    if (!"audio/raw".equals(paramString))
      bool1 = true;
    boolean bool4;
    int i6;
    int i7;
    while (true)
    {
      int i5;
      label72: zzlx localzzlx;
      if (bool1)
      {
        i = zzba(paramString);
        if (bool1)
          break label752;
        this.zzawj = zzsy.zzg(paramInt3, paramInt1);
        this.zzavv.zzb(paramArrayOfInt);
        zzlx[] arrayOfzzlx = this.zzavx;
        int i4 = arrayOfzzlx.length;
        i5 = 0;
        bool4 = false;
        i6 = i;
        i7 = paramInt1;
        if (i5 < i4)
          localzzlx = arrayOfzzlx[i5];
      }
      else
      {
        try
        {
          boolean bool5 = localzzlx.zzb(paramInt2, i7, i6);
          boolean bool6 = bool5 | bool4;
          if (localzzlx.isActive())
          {
            i7 = localzzlx.zzhj();
            i6 = localzzlx.zzhk();
          }
          i5++;
          bool4 = bool6;
          break label72;
          bool1 = false;
          continue;
          i = paramInt3;
        }
        catch (zzly localzzly)
        {
          throw new zzml(localzzly);
        }
      }
    }
    if (bool4)
      zzhn();
    boolean bool2 = bool4;
    paramInt1 = i7;
    int i = i6;
    while (true)
    {
      int j;
      switch (paramInt1)
      {
      default:
        throw new zzml(38 + "Unsupported channel count: " + paramInt1);
      case 1:
        j = 4;
        if ((zzsy.SDK_INT <= 23) && ("foster".equals(zzsy.DEVICE)) && ("NVIDIA".equals(zzsy.MANUFACTURER)));
        switch (paramInt1)
        {
        case 4:
        case 6:
        default:
          label336: if ((zzsy.SDK_INT > 25) || (!"fugu".equals(zzsy.DEVICE)) || (!bool1) || (paramInt1 != 1));
          break;
        case 7:
        case 3:
        case 5:
        }
        break;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
      for (int k = 12; ; k = j)
      {
        if ((!bool2) && (isInitialized()) && (this.zzagi == i) && (this.zzafv == paramInt2) && (this.zzagh == k))
        {
          return;
          j = 12;
          break;
          j = 28;
          break;
          j = 204;
          break;
          j = 220;
          break;
          j = 252;
          break;
          j = 1276;
          break;
          j = zzkt.CHANNEL_OUT_7POINT1_SURROUND;
          break;
          j = zzkt.CHANNEL_OUT_7POINT1_SURROUND;
          break label336;
          j = 252;
          break label336;
        }
        reset();
        this.zzagi = i;
        this.zzawc = bool1;
        this.zzafv = paramInt2;
        this.zzagh = k;
        int m;
        int i2;
        zzmh localzzmh;
        if (bool1)
        {
          m = i;
          this.zzawb = m;
          this.zzawm = zzsy.zzg(2, paramInt1);
          if (!bool1)
            break label610;
          if ((this.zzawb != 5) && (this.zzawb != 6))
            break label599;
          i2 = 20480;
          localzzmh = this;
          label560: localzzmh.zzagl = i2;
          if (!bool1)
            break label726;
        }
        label699: label726: for (long l = -9223372036854775807L; ; l = zzdo(this.zzagl / this.zzawm))
        {
          this.zzawd = l;
          zzb(this.zzasc);
          return;
          m = 2;
          break;
          label599: i2 = 49152;
          localzzmh = this;
          break label560;
          label610: int n = AudioTrack.getMinBufferSize(paramInt2, k, this.zzawb);
          if (n != -2);
          int i1;
          int i3;
          for (boolean bool3 = true; ; bool3 = false)
          {
            zzsk.checkState(bool3);
            i1 = n << 2;
            i2 = (int)zzdp(250000L) * this.zzawm;
            i3 = (int)Math.max(n, zzdp(750000L) * this.zzawm);
            if (i1 >= i2)
              break label699;
            localzzmh = this;
            break;
          }
          if (i1 > i3)
          {
            i2 = i3;
            localzzmh = this;
            break label560;
          }
          i2 = i1;
          localzzmh = this;
          break label560;
        }
      }
      label752: bool2 = false;
    }
  }

  // ERROR //
  public final boolean zza(ByteBuffer paramByteBuffer, long paramLong)
    throws zzmm, zzmp
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   4: ifnull +11 -> 15
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   12: if_acmpne +175 -> 187
    //   15: iconst_1
    //   16: istore 4
    //   18: iload 4
    //   20: invokestatic 205	com/google/android/gms/internal/ads/zzsk:checkArgument	(Z)V
    //   23: aload_0
    //   24: invokespecial 389	com/google/android/gms/internal/ads/zzmh:isInitialized	()Z
    //   27: ifne +337 -> 364
    //   30: aload_0
    //   31: getfield 105	com/google/android/gms/internal/ads/zzmh:zzagd	Landroid/os/ConditionVariable;
    //   34: invokevirtual 573	android/os/ConditionVariable:block	()V
    //   37: aload_0
    //   38: getfield 255	com/google/android/gms/internal/ads/zzmh:zzawy	Z
    //   41: ifeq +152 -> 193
    //   44: aload_0
    //   45: getfield 325	com/google/android/gms/internal/ads/zzmh:zzafv	I
    //   48: istore 23
    //   50: aload_0
    //   51: getfield 539	com/google/android/gms/internal/ads/zzmh:zzagh	I
    //   54: istore 24
    //   56: aload_0
    //   57: getfield 401	com/google/android/gms/internal/ads/zzmh:zzawb	I
    //   60: istore 25
    //   62: aload_0
    //   63: getfield 219	com/google/android/gms/internal/ads/zzmh:zzagl	I
    //   66: istore 26
    //   68: aload_0
    //   69: getfield 160	com/google/android/gms/internal/ads/zzmh:zzada	I
    //   72: istore 27
    //   74: aload_0
    //   75: new 112	android/media/AudioTrack
    //   78: dup
    //   79: new 575	android/media/AudioAttributes$Builder
    //   82: dup
    //   83: invokespecial 576	android/media/AudioAttributes$Builder:<init>	()V
    //   86: iconst_1
    //   87: invokevirtual 580	android/media/AudioAttributes$Builder:setUsage	(I)Landroid/media/AudioAttributes$Builder;
    //   90: iconst_3
    //   91: invokevirtual 583	android/media/AudioAttributes$Builder:setContentType	(I)Landroid/media/AudioAttributes$Builder;
    //   94: bipush 16
    //   96: invokevirtual 586	android/media/AudioAttributes$Builder:setFlags	(I)Landroid/media/AudioAttributes$Builder;
    //   99: invokevirtual 590	android/media/AudioAttributes$Builder:build	()Landroid/media/AudioAttributes;
    //   102: new 592	android/media/AudioFormat$Builder
    //   105: dup
    //   106: invokespecial 593	android/media/AudioFormat$Builder:<init>	()V
    //   109: iload 24
    //   111: invokevirtual 597	android/media/AudioFormat$Builder:setChannelMask	(I)Landroid/media/AudioFormat$Builder;
    //   114: iload 25
    //   116: invokevirtual 600	android/media/AudioFormat$Builder:setEncoding	(I)Landroid/media/AudioFormat$Builder;
    //   119: iload 23
    //   121: invokevirtual 603	android/media/AudioFormat$Builder:setSampleRate	(I)Landroid/media/AudioFormat$Builder;
    //   124: invokevirtual 606	android/media/AudioFormat$Builder:build	()Landroid/media/AudioFormat;
    //   127: iload 26
    //   129: iconst_1
    //   130: iload 27
    //   132: invokespecial 609	android/media/AudioTrack:<init>	(Landroid/media/AudioAttributes;Landroid/media/AudioFormat;III)V
    //   135: putfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   138: aload_0
    //   139: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   142: invokevirtual 612	android/media/AudioTrack:getState	()I
    //   145: istore 19
    //   147: iload 19
    //   149: iconst_1
    //   150: if_icmpeq +144 -> 294
    //   153: aload_0
    //   154: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   157: invokevirtual 614	android/media/AudioTrack:release	()V
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   165: new 568	com/google/android/gms/internal/ads/zzmm
    //   168: dup
    //   169: iload 19
    //   171: aload_0
    //   172: getfield 325	com/google/android/gms/internal/ads/zzmh:zzafv	I
    //   175: aload_0
    //   176: getfield 539	com/google/android/gms/internal/ads/zzmh:zzagh	I
    //   179: aload_0
    //   180: getfield 219	com/google/android/gms/internal/ads/zzmh:zzagl	I
    //   183: invokespecial 617	com/google/android/gms/internal/ads/zzmm:<init>	(IIII)V
    //   186: athrow
    //   187: iconst_0
    //   188: istore 4
    //   190: goto -172 -> 18
    //   193: aload_0
    //   194: getfield 160	com/google/android/gms/internal/ads/zzmh:zzada	I
    //   197: ifne +38 -> 235
    //   200: aload_0
    //   201: new 112	android/media/AudioTrack
    //   204: dup
    //   205: aload_0
    //   206: getfield 158	com/google/android/gms/internal/ads/zzmh:streamType	I
    //   209: aload_0
    //   210: getfield 325	com/google/android/gms/internal/ads/zzmh:zzafv	I
    //   213: aload_0
    //   214: getfield 539	com/google/android/gms/internal/ads/zzmh:zzagh	I
    //   217: aload_0
    //   218: getfield 401	com/google/android/gms/internal/ads/zzmh:zzawb	I
    //   221: aload_0
    //   222: getfield 219	com/google/android/gms/internal/ads/zzmh:zzagl	I
    //   225: iconst_1
    //   226: invokespecial 620	android/media/AudioTrack:<init>	(IIIIII)V
    //   229: putfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   232: goto -94 -> 138
    //   235: aload_0
    //   236: new 112	android/media/AudioTrack
    //   239: dup
    //   240: aload_0
    //   241: getfield 158	com/google/android/gms/internal/ads/zzmh:streamType	I
    //   244: aload_0
    //   245: getfield 325	com/google/android/gms/internal/ads/zzmh:zzafv	I
    //   248: aload_0
    //   249: getfield 539	com/google/android/gms/internal/ads/zzmh:zzagh	I
    //   252: aload_0
    //   253: getfield 401	com/google/android/gms/internal/ads/zzmh:zzawb	I
    //   256: aload_0
    //   257: getfield 219	com/google/android/gms/internal/ads/zzmh:zzagl	I
    //   260: iconst_1
    //   261: aload_0
    //   262: getfield 160	com/google/android/gms/internal/ads/zzmh:zzada	I
    //   265: invokespecial 623	android/media/AudioTrack:<init>	(IIIIIII)V
    //   268: putfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   271: goto -133 -> 138
    //   274: astore 22
    //   276: aload_0
    //   277: aconst_null
    //   278: putfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   281: goto -116 -> 165
    //   284: astore 21
    //   286: aload_0
    //   287: aconst_null
    //   288: putfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   291: aload 21
    //   293: athrow
    //   294: aload_0
    //   295: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   298: invokevirtual 626	android/media/AudioTrack:getAudioSessionId	()I
    //   301: istore 20
    //   303: aload_0
    //   304: getfield 160	com/google/android/gms/internal/ads/zzmh:zzada	I
    //   307: iload 20
    //   309: if_icmpeq +20 -> 329
    //   312: aload_0
    //   313: iload 20
    //   315: putfield 160	com/google/android/gms/internal/ads/zzmh:zzada	I
    //   318: aload_0
    //   319: getfield 98	com/google/android/gms/internal/ads/zzmh:zzavy	Lcom/google/android/gms/internal/ads/zzmn;
    //   322: iload 20
    //   324: invokeinterface 631 2 0
    //   329: aload_0
    //   330: getfield 127	com/google/android/gms/internal/ads/zzmh:zzavz	Lcom/google/android/gms/internal/ads/zzmj;
    //   333: aload_0
    //   334: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   337: aload_0
    //   338: invokespecial 633	com/google/android/gms/internal/ads/zzmh:zzhu	()Z
    //   341: invokevirtual 457	com/google/android/gms/internal/ads/zzmj:zza	(Landroid/media/AudioTrack;Z)V
    //   344: aload_0
    //   345: invokespecial 472	com/google/android/gms/internal/ads/zzmh:zzhs	()V
    //   348: aload_0
    //   349: iconst_0
    //   350: putfield 635	com/google/android/gms/internal/ads/zzmh:zzawz	Z
    //   353: aload_0
    //   354: getfield 404	com/google/android/gms/internal/ads/zzmh:zzawx	Z
    //   357: ifeq +7 -> 364
    //   360: aload_0
    //   361: invokevirtual 636	com/google/android/gms/internal/ads/zzmh:play	()V
    //   364: aload_0
    //   365: invokespecial 633	com/google/android/gms/internal/ads/zzmh:zzhu	()Z
    //   368: ifeq +46 -> 414
    //   371: aload_0
    //   372: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   375: invokevirtual 453	android/media/AudioTrack:getPlayState	()I
    //   378: iconst_2
    //   379: if_icmpne +10 -> 389
    //   382: aload_0
    //   383: iconst_0
    //   384: putfield 635	com/google/android/gms/internal/ads/zzmh:zzawz	Z
    //   387: iconst_0
    //   388: ireturn
    //   389: aload_0
    //   390: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   393: invokevirtual 453	android/media/AudioTrack:getPlayState	()I
    //   396: iconst_1
    //   397: if_icmpne +17 -> 414
    //   400: aload_0
    //   401: getfield 127	com/google/android/gms/internal/ads/zzmh:zzavz	Lcom/google/android/gms/internal/ads/zzmj;
    //   404: invokevirtual 215	com/google/android/gms/internal/ads/zzmj:zzev	()J
    //   407: lconst_0
    //   408: lcmp
    //   409: ifeq +5 -> 414
    //   412: iconst_0
    //   413: ireturn
    //   414: aload_0
    //   415: getfield 635	com/google/android/gms/internal/ads/zzmh:zzawz	Z
    //   418: istore 5
    //   420: aload_0
    //   421: aload_0
    //   422: invokevirtual 639	com/google/android/gms/internal/ads/zzmh:zzer	()Z
    //   425: putfield 635	com/google/android/gms/internal/ads/zzmh:zzawz	Z
    //   428: iload 5
    //   430: ifeq +53 -> 483
    //   433: aload_0
    //   434: getfield 635	com/google/android/gms/internal/ads/zzmh:zzawz	Z
    //   437: ifne +46 -> 483
    //   440: aload_0
    //   441: getfield 189	com/google/android/gms/internal/ads/zzmh:zzagg	Landroid/media/AudioTrack;
    //   444: invokevirtual 453	android/media/AudioTrack:getPlayState	()I
    //   447: iconst_1
    //   448: if_icmpeq +35 -> 483
    //   451: invokestatic 244	android/os/SystemClock:elapsedRealtime	()J
    //   454: aload_0
    //   455: getfield 246	com/google/android/gms/internal/ads/zzmh:zzaxa	J
    //   458: lsub
    //   459: lstore 17
    //   461: aload_0
    //   462: getfield 98	com/google/android/gms/internal/ads/zzmh:zzavy	Lcom/google/android/gms/internal/ads/zzmn;
    //   465: aload_0
    //   466: getfield 219	com/google/android/gms/internal/ads/zzmh:zzagl	I
    //   469: aload_0
    //   470: getfield 546	com/google/android/gms/internal/ads/zzmh:zzawd	J
    //   473: invokestatic 642	com/google/android/gms/internal/ads/zzkt:zzdz	(J)J
    //   476: lload 17
    //   478: invokeinterface 646 6 0
    //   483: aload_0
    //   484: getfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   487: ifnonnull +224 -> 711
    //   490: aload_1
    //   491: invokevirtual 198	java/nio/ByteBuffer:hasRemaining	()Z
    //   494: ifne +5 -> 499
    //   497: iconst_1
    //   498: ireturn
    //   499: aload_0
    //   500: getfield 296	com/google/android/gms/internal/ads/zzmh:zzawc	Z
    //   503: ifeq +42 -> 545
    //   506: aload_0
    //   507: getfield 300	com/google/android/gms/internal/ads/zzmh:zzawp	I
    //   510: ifne +35 -> 545
    //   513: aload_0
    //   514: getfield 401	com/google/android/gms/internal/ads/zzmh:zzawb	I
    //   517: istore 15
    //   519: iload 15
    //   521: bipush 7
    //   523: if_icmpeq +10 -> 533
    //   526: iload 15
    //   528: bipush 8
    //   530: if_icmpne +31 -> 561
    //   533: aload_1
    //   534: invokestatic 652	com/google/android/gms/internal/ads/zzmr:zzj	(Ljava/nio/ByteBuffer;)I
    //   537: istore 16
    //   539: aload_0
    //   540: iload 16
    //   542: putfield 300	com/google/android/gms/internal/ads/zzmh:zzawp	I
    //   545: aload_0
    //   546: getfield 427	com/google/android/gms/internal/ads/zzmh:zzawe	Lcom/google/android/gms/internal/ads/zzln;
    //   549: ifnull +115 -> 664
    //   552: aload_0
    //   553: invokespecial 654	com/google/android/gms/internal/ads/zzmh:zzhp	()Z
    //   556: ifne +66 -> 622
    //   559: iconst_0
    //   560: ireturn
    //   561: iload 15
    //   563: iconst_5
    //   564: if_icmpne +11 -> 575
    //   567: invokestatic 659	com/google/android/gms/internal/ads/zzlv:zzhi	()I
    //   570: istore 16
    //   572: goto -33 -> 539
    //   575: iload 15
    //   577: bipush 6
    //   579: if_icmpne +12 -> 591
    //   582: aload_1
    //   583: invokestatic 662	com/google/android/gms/internal/ads/zzlv:zzh	(Ljava/nio/ByteBuffer;)I
    //   586: istore 16
    //   588: goto -49 -> 539
    //   591: new 664	java/lang/IllegalStateException
    //   594: dup
    //   595: new 505	java/lang/StringBuilder
    //   598: dup
    //   599: bipush 38
    //   601: invokespecial 506	java/lang/StringBuilder:<init>	(I)V
    //   604: ldc_w 666
    //   607: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 15
    //   612: invokevirtual 515	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: invokevirtual 519	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokespecial 667	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   621: athrow
    //   622: aload_0
    //   623: getfield 180	com/google/android/gms/internal/ads/zzmh:zzawa	Ljava/util/LinkedList;
    //   626: new 443	com/google/android/gms/internal/ads/zzmo
    //   629: dup
    //   630: aload_0
    //   631: getfield 427	com/google/android/gms/internal/ads/zzmh:zzawe	Lcom/google/android/gms/internal/ads/zzln;
    //   634: lconst_0
    //   635: lload_2
    //   636: invokestatic 564	java/lang/Math:max	(JJ)J
    //   639: aload_0
    //   640: aload_0
    //   641: invokespecial 669	com/google/android/gms/internal/ads/zzmh:zzht	()J
    //   644: invokespecial 566	com/google/android/gms/internal/ads/zzmh:zzdo	(J)J
    //   647: aconst_null
    //   648: invokespecial 672	com/google/android/gms/internal/ads/zzmo:<init>	(Lcom/google/android/gms/internal/ads/zzln;JJLcom/google/android/gms/internal/ads/zzmi;)V
    //   651: invokevirtual 673	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   654: pop
    //   655: aload_0
    //   656: aconst_null
    //   657: putfield 427	com/google/android/gms/internal/ads/zzmh:zzawe	Lcom/google/android/gms/internal/ads/zzln;
    //   660: aload_0
    //   661: invokespecial 503	com/google/android/gms/internal/ads/zzmh:zzhn	()V
    //   664: aload_0
    //   665: getfield 156	com/google/android/gms/internal/ads/zzmh:zzagu	I
    //   668: ifne +77 -> 745
    //   671: aload_0
    //   672: lconst_0
    //   673: lload_2
    //   674: invokestatic 564	java/lang/Math:max	(JJ)J
    //   677: putfield 675	com/google/android/gms/internal/ads/zzmh:zzagv	J
    //   680: aload_0
    //   681: iconst_1
    //   682: putfield 156	com/google/android/gms/internal/ads/zzmh:zzagu	I
    //   685: aload_0
    //   686: getfield 296	com/google/android/gms/internal/ads/zzmh:zzawc	Z
    //   689: ifeq +212 -> 901
    //   692: aload_0
    //   693: aload_0
    //   694: getfield 425	com/google/android/gms/internal/ads/zzmh:zzawl	J
    //   697: aload_0
    //   698: getfield 300	com/google/android/gms/internal/ads/zzmh:zzawp	I
    //   701: i2l
    //   702: ladd
    //   703: putfield 425	com/google/android/gms/internal/ads/zzmh:zzawl	J
    //   706: aload_0
    //   707: aload_1
    //   708: putfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   711: aload_0
    //   712: getfield 296	com/google/android/gms/internal/ads/zzmh:zzawc	Z
    //   715: ifeq +203 -> 918
    //   718: aload_0
    //   719: aload_0
    //   720: getfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   723: lload_2
    //   724: invokespecial 330	com/google/android/gms/internal/ads/zzmh:zzb	(Ljava/nio/ByteBuffer;J)Z
    //   727: pop
    //   728: aload_0
    //   729: getfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   732: invokevirtual 198	java/nio/ByteBuffer:hasRemaining	()Z
    //   735: ifne +191 -> 926
    //   738: aload_0
    //   739: aconst_null
    //   740: putfield 332	com/google/android/gms/internal/ads/zzmh:zzawr	Ljava/nio/ByteBuffer;
    //   743: iconst_1
    //   744: ireturn
    //   745: aload_0
    //   746: getfield 675	com/google/android/gms/internal/ads/zzmh:zzagv	J
    //   749: lstore 7
    //   751: aload_0
    //   752: getfield 296	com/google/android/gms/internal/ads/zzmh:zzawc	Z
    //   755: ifeq +131 -> 886
    //   758: aload_0
    //   759: getfield 425	com/google/android/gms/internal/ads/zzmh:zzawl	J
    //   762: lstore 9
    //   764: lload 7
    //   766: aload_0
    //   767: lload 9
    //   769: invokespecial 566	com/google/android/gms/internal/ads/zzmh:zzdo	(J)J
    //   772: ladd
    //   773: lstore 11
    //   775: aload_0
    //   776: getfield 156	com/google/android/gms/internal/ads/zzmh:zzagu	I
    //   779: iconst_1
    //   780: if_icmpne +68 -> 848
    //   783: lload 11
    //   785: lload_2
    //   786: lsub
    //   787: invokestatic 678	java/lang/Math:abs	(J)J
    //   790: ldc2_w 679
    //   793: lcmp
    //   794: ifle +54 -> 848
    //   797: ldc_w 682
    //   800: new 505	java/lang/StringBuilder
    //   803: dup
    //   804: bipush 80
    //   806: invokespecial 506	java/lang/StringBuilder:<init>	(I)V
    //   809: ldc_w 684
    //   812: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: lload 11
    //   817: invokevirtual 687	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   820: ldc_w 689
    //   823: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: lload_2
    //   827: invokevirtual 687	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   830: ldc_w 691
    //   833: invokevirtual 512	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: invokevirtual 519	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: invokestatic 697	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   842: pop
    //   843: aload_0
    //   844: iconst_2
    //   845: putfield 156	com/google/android/gms/internal/ads/zzmh:zzagu	I
    //   848: aload_0
    //   849: getfield 156	com/google/android/gms/internal/ads/zzmh:zzagu	I
    //   852: iconst_2
    //   853: if_icmpne -168 -> 685
    //   856: aload_0
    //   857: aload_0
    //   858: getfield 675	com/google/android/gms/internal/ads/zzmh:zzagv	J
    //   861: lload_2
    //   862: lload 11
    //   864: lsub
    //   865: ladd
    //   866: putfield 675	com/google/android/gms/internal/ads/zzmh:zzagv	J
    //   869: aload_0
    //   870: iconst_1
    //   871: putfield 156	com/google/android/gms/internal/ads/zzmh:zzagu	I
    //   874: aload_0
    //   875: getfield 98	com/google/android/gms/internal/ads/zzmh:zzavy	Lcom/google/android/gms/internal/ads/zzmn;
    //   878: invokeinterface 700 1 0
    //   883: goto -198 -> 685
    //   886: aload_0
    //   887: getfield 423	com/google/android/gms/internal/ads/zzmh:zzawk	J
    //   890: aload_0
    //   891: getfield 486	com/google/android/gms/internal/ads/zzmh:zzawj	I
    //   894: i2l
    //   895: ldiv
    //   896: lstore 9
    //   898: goto -134 -> 764
    //   901: aload_0
    //   902: aload_0
    //   903: getfield 423	com/google/android/gms/internal/ads/zzmh:zzawk	J
    //   906: aload_1
    //   907: invokevirtual 209	java/nio/ByteBuffer:remaining	()I
    //   910: i2l
    //   911: ladd
    //   912: putfield 423	com/google/android/gms/internal/ads/zzmh:zzawk	J
    //   915: goto -209 -> 706
    //   918: aload_0
    //   919: lload_2
    //   920: invokespecial 383	com/google/android/gms/internal/ads/zzmh:zzeg	(J)V
    //   923: goto -195 -> 728
    //   926: iconst_0
    //   927: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   153	160	274	java/lang/Exception
    //   153	160	284	finally
  }

  public final void zzai(int paramInt)
  {
    if (zzsy.SDK_INT >= 21);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      if ((!this.zzawy) || (this.zzada != paramInt))
      {
        this.zzawy = true;
        this.zzada = paramInt;
        reset();
      }
      return;
    }
  }

  public final boolean zzaz(String paramString)
  {
    return (this.zzavu != null) && (this.zzavu.zzaf(zzba(paramString)));
  }

  public final zzln zzb(zzln paramzzln)
  {
    if (this.zzawc)
    {
      this.zzasc = zzln.zzaug;
      return this.zzasc;
    }
    zzln localzzln1 = new zzln(this.zzavw.zzb(paramzzln.zzauh), this.zzavw.zzc(paramzzln.zzaui));
    zzln localzzln2;
    if (this.zzawe != null)
    {
      localzzln2 = this.zzawe;
      if (!localzzln1.equals(localzzln2))
      {
        if (!isInitialized())
          break label121;
        this.zzawe = localzzln1;
      }
    }
    while (true)
    {
      return this.zzasc;
      if (!this.zzawa.isEmpty())
      {
        localzzln2 = zzmo.zza((zzmo)this.zzawa.getLast());
        break;
      }
      localzzln2 = this.zzasc;
      break;
      label121: this.zzasc = localzzln1;
    }
  }

  public final boolean zzdx()
  {
    return (!isInitialized()) || ((this.zzaww) && (!zzer()));
  }

  public final void zzeq()
  {
    if (this.zzagu == 1)
      this.zzagu = 2;
  }

  public final boolean zzer()
  {
    if (isInitialized())
    {
      if (zzht() <= this.zzavz.zzev())
        if ((!zzhu()) || (this.zzagg.getPlayState() != 2) || (this.zzagg.getPlaybackHeadPosition() != 0))
          break label58;
      label58: for (int i = 1; i != 0; i = 0)
        return true;
    }
    return false;
  }

  public final long zzf(boolean paramBoolean)
  {
    if ((isInitialized()) && (this.zzagu != 0));
    for (int i = 1; i == 0; i = 0)
      return -9223372036854775808L;
    long l6;
    long l7;
    long l9;
    long l10;
    if (this.zzagg.getPlayState() == 3)
    {
      l6 = this.zzavz.zzdv();
      if (l6 != 0L)
      {
        l7 = System.nanoTime() / 1000L;
        if (l7 - this.zzagp >= 30000L)
        {
          this.zzage[this.zzagm] = (l6 - l7);
          this.zzagm = ((1 + this.zzagm) % 10);
          if (this.zzagn < 10)
            this.zzagn = (1 + this.zzagn);
          this.zzagp = l7;
          this.zzago = 0L;
          for (int j = 0; j < this.zzagn; j++)
            this.zzago += this.zzage[j] / this.zzagn;
        }
        if ((!zzhu()) && (l7 - this.zzagr >= 500000L))
        {
          this.zzagq = this.zzavz.zzex();
          if (this.zzagq)
          {
            l9 = this.zzavz.zzey() / 1000L;
            l10 = this.zzavz.zzez();
            if (l9 >= this.zzagw)
              break label496;
            this.zzagq = false;
          }
        }
      }
    }
    while (true)
    {
      if ((this.zzags != null) && (!this.zzawc));
      try
      {
        this.zzagx = (1000L * ((Integer)this.zzags.invoke(this.zzagg, null)).intValue() - this.zzawd);
        this.zzagx = Math.max(this.zzagx, 0L);
        if (this.zzagx > 5000000L)
        {
          long l8 = this.zzagx;
          Log.w("AudioTrack", 61 + "Ignoring impossibly large audio latency: " + l8);
          this.zzagx = 0L;
        }
        this.zzagr = l7;
        l1 = System.nanoTime() / 1000L;
        if (this.zzagq)
        {
          l3 = zzdo(zzdp(l1 - this.zzavz.zzey() / 1000L) + this.zzavz.zzez());
          l4 = this.zzagv;
          while ((!this.zzawa.isEmpty()) && (l3 >= zzmo.zzb((zzmo)this.zzawa.getFirst())))
          {
            zzmo localzzmo = (zzmo)this.zzawa.remove();
            this.zzasc = zzmo.zza(localzzmo);
            this.zzawg = zzmo.zzb(localzzmo);
            this.zzawf = (zzmo.zzc(localzzmo) - this.zzagv);
          }
          label496: if (Math.abs(l9 - l7) > 5000000L)
          {
            Log.w("AudioTrack", 136 + "Spurious audio timestamp (system clock mismatch): " + l10 + ", " + l9 + ", " + l7 + ", " + l6);
            this.zzagq = false;
            continue;
          }
          if (Math.abs(zzdo(l10) - l6) <= 5000000L)
            continue;
          Log.w("AudioTrack", 138 + "Spurious audio timestamp (frame position mismatch): " + l10 + ", " + l9 + ", " + l7 + ", " + l6);
          this.zzagq = false;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          long l1;
          long l4;
          this.zzags = null;
          continue;
          long l2;
          if (this.zzagn == 0)
            l2 = this.zzavz.zzdv();
          while (true)
            if (!paramBoolean)
            {
              l3 = l2 - this.zzagx;
              break;
              l2 = l1 + this.zzago;
              continue;
              long l5;
              if (this.zzasc.zzauh == 1.0F)
                l5 = l3 + this.zzawf - this.zzawg;
              while (true)
              {
                return l5 + l4;
                if ((this.zzawa.isEmpty()) && (this.zzavw.zzia() >= 1024L))
                  l5 = this.zzawf + zzsy.zza(l3 - this.zzawg, this.zzavw.zzhz(), this.zzavw.zzia());
                else
                  l5 = this.zzawf + ()(this.zzasc.zzauh * (l3 - this.zzawg));
              }
            }
          long l3 = l2;
        }
      }
    }
  }

  public final void zzho()
    throws zzmp
  {
    if ((this.zzaww) || (!isInitialized()));
    while (!zzhp())
      return;
    this.zzavz.zzeh(zzht());
    this.zzawi = 0;
    this.zzaww = true;
  }

  public final zzln zzhq()
  {
    return this.zzasc;
  }

  public final void zzhr()
  {
    if (this.zzawy)
    {
      this.zzawy = false;
      this.zzada = 0;
      reset();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmh
 * JD-Core Version:    0.6.2
 */