package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.d.d.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.i;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
public class c extends b
{
  private static final int[] c = { 1920, 1600, 1440, 1280, 960, 854, 640, 540, 480 };
  private static boolean d;
  private static boolean e;
  private int A;
  private float B;
  private int C;
  private int D;
  private int E;
  private float F;
  private int G;
  private int H;
  private int I;
  private float J;
  private boolean K;
  private int L;
  private long M;
  private long N;
  private int O;
  private d P;
  b b;
  private final Context f;
  private final e g;
  private final h.a h;
  private final long i;
  private final int j;
  private final boolean k;
  private final long[] l;
  private final long[] m;
  private a n;
  private boolean o;
  private Surface p;
  private Surface q;
  private int r;
  private boolean s;
  private long t;
  private long u;
  private long v;
  private int w;
  private int x;
  private int y;
  private long z;

  public c(Context paramContext, com.google.android.exoplayer2.d.c paramc, long paramLong, com.google.android.exoplayer2.drm.l<p> paraml, boolean paramBoolean, Handler paramHandler, h paramh, int paramInt)
  {
    super(2, paramc, paraml, paramBoolean, 30.0F);
    this.i = paramLong;
    this.j = paramInt;
    this.f = paramContext.getApplicationContext();
    this.g = new e(this.f);
    this.h = new h.a(paramHandler, paramh);
    this.k = M();
    this.l = new long[10];
    this.m = new long[10];
    this.N = -9223372036854775807L;
    this.M = -9223372036854775807L;
    this.u = -9223372036854775807L;
    this.C = -1;
    this.D = -1;
    this.F = -1.0F;
    this.B = -1.0F;
    this.r = 1;
    I();
  }

  private void F()
  {
    if (this.i > 0L);
    for (long l1 = SystemClock.elapsedRealtime() + this.i; ; l1 = -9223372036854775807L)
    {
      this.u = l1;
      return;
    }
  }

  private void G()
  {
    this.s = false;
    if ((com.google.android.exoplayer2.g.ag.a >= 23) && (this.K))
    {
      MediaCodec localMediaCodec = A();
      if (localMediaCodec != null)
        this.b = new b(localMediaCodec, null);
    }
  }

  private void H()
  {
    if (this.s)
      this.h.a(this.p);
  }

  private void I()
  {
    this.G = -1;
    this.H = -1;
    this.J = -1.0F;
    this.I = -1;
  }

  private void J()
  {
    if (((this.C != -1) || (this.D != -1)) && ((this.G != this.C) || (this.H != this.D) || (this.I != this.E) || (this.J != this.F)))
    {
      this.h.a(this.C, this.D, this.E, this.F);
      this.G = this.C;
      this.H = this.D;
      this.I = this.E;
      this.J = this.F;
    }
  }

  private void K()
  {
    if ((this.G != -1) || (this.H != -1))
      this.h.a(this.G, this.H, this.I, this.J);
  }

  private void L()
  {
    if (this.w > 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.v;
      this.h.a(this.w, l2);
      this.w = 0;
      this.v = l1;
    }
  }

  private static boolean M()
  {
    return "NVIDIA".equals(com.google.android.exoplayer2.g.ag.c);
  }

  private static int a(com.google.android.exoplayer2.d.a parama, String paramString, int paramInt1, int paramInt2)
  {
    int i1 = 2;
    if ((paramInt1 == -1) || (paramInt2 == -1))
      return -1;
    label76: int i2;
    switch (paramString.hashCode())
    {
    default:
      i2 = -1;
    case -1664118616:
    case 1187890754:
    case 1331836730:
    case 1599127256:
    case -1662541442:
    case 1599127257:
    }
    while (true)
      switch (i2)
      {
      default:
        return -1;
        if (!paramString.equals("video/3gpp"))
          break label76;
        i2 = 0;
        continue;
        if (!paramString.equals("video/mp4v-es"))
          break label76;
        i2 = 1;
        continue;
        if (!paramString.equals("video/avc"))
          break label76;
        i2 = i1;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8"))
          break label76;
        i2 = 3;
        continue;
        if (!paramString.equals("video/hevc"))
          break label76;
        i2 = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9"))
          break label76;
        i2 = 5;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    int i3 = paramInt1 * paramInt2;
    while (true)
    {
      return i3 * 3 / (i1 * 2);
      if (("BRAVIA 4K 2015".equals(com.google.android.exoplayer2.g.ag.d)) || (("Amazon".equals(com.google.android.exoplayer2.g.ag.c)) && (("KFSOWI".equals(com.google.android.exoplayer2.g.ag.d)) || (("AFTS".equals(com.google.android.exoplayer2.g.ag.d)) && (parama.f)))))
        return -1;
      i3 = 16 * (16 * (com.google.android.exoplayer2.g.ag.a(paramInt1, 16) * com.google.android.exoplayer2.g.ag.a(paramInt2, 16)));
      continue;
      i3 = paramInt1 * paramInt2;
      continue;
      i3 = paramInt1 * paramInt2;
      i1 = 4;
    }
  }

  private static Point a(com.google.android.exoplayer2.d.a parama, Format paramFormat)
    throws d.b
  {
    int i1;
    int i2;
    label22: int i3;
    label32: float f1;
    int[] arrayOfInt;
    int i4;
    if (paramFormat.height > paramFormat.width)
    {
      i1 = 1;
      if (i1 == 0)
        break label96;
      i2 = paramFormat.height;
      if (i1 == 0)
        break label104;
      i3 = paramFormat.width;
      f1 = i3 / i2;
      arrayOfInt = c;
      i4 = arrayOfInt.length;
    }
    label256: label263: for (int i5 = 0; ; i5++)
    {
      if (i5 >= i4)
        break label269;
      int i6 = arrayOfInt[i5];
      int i7 = (int)(f1 * i6);
      if ((i6 <= i2) || (i7 <= i3))
      {
        return null;
        i1 = 0;
        break;
        label96: i2 = paramFormat.width;
        break label22;
        label104: i3 = paramFormat.height;
        break label32;
      }
      if (com.google.android.exoplayer2.g.ag.a >= 21)
      {
        int i12;
        if (i1 != 0)
        {
          i12 = i7;
          if (i1 == 0)
            break label179;
        }
        while (true)
        {
          Point localPoint = parama.a(i12, i6);
          float f2 = paramFormat.frameRate;
          if (!parama.a(localPoint.x, localPoint.y, f2))
            break label263;
          return localPoint;
          i12 = i6;
          break;
          label179: i6 = i7;
        }
      }
      int i8 = 16 * com.google.android.exoplayer2.g.ag.a(i6, 16);
      int i9 = 16 * com.google.android.exoplayer2.g.ag.a(i7, 16);
      if (i8 * i9 <= com.google.android.exoplayer2.d.d.b())
      {
        int i10;
        if (i1 != 0)
        {
          i10 = i9;
          if (i1 == 0)
            break label256;
        }
        for (int i11 = i8; ; i11 = i9)
        {
          return new Point(i10, i11);
          i10 = i8;
          break;
        }
      }
    }
    label269: return null;
  }

  private void a(long paramLong1, long paramLong2, Format paramFormat)
  {
    if (this.P != null)
      this.P.a(paramLong1, paramLong2, paramFormat);
  }

  private void a(MediaCodec paramMediaCodec, int paramInt1, int paramInt2)
  {
    this.C = paramInt1;
    this.D = paramInt2;
    this.F = this.B;
    if (com.google.android.exoplayer2.g.ag.a >= 21)
      if ((this.A == 90) || (this.A == 270))
      {
        int i1 = this.C;
        this.C = this.D;
        this.D = i1;
        this.F = (1.0F / this.F);
      }
    while (true)
    {
      paramMediaCodec.setVideoScalingMode(this.r);
      return;
      this.E = this.A;
    }
  }

  @TargetApi(23)
  private static void a(MediaCodec paramMediaCodec, Surface paramSurface)
  {
    paramMediaCodec.setOutputSurface(paramSurface);
  }

  @TargetApi(21)
  private static void a(MediaFormat paramMediaFormat, int paramInt)
  {
    paramMediaFormat.setFeatureEnabled("tunneled-playback", true);
    paramMediaFormat.setInteger("audio-session-id", paramInt);
  }

  private void a(Surface paramSurface)
    throws i
  {
    if (paramSurface == null)
    {
      if (this.q != null)
        paramSurface = this.q;
    }
    else
    {
      if (this.p == paramSurface)
        break label171;
      this.p = paramSurface;
      i1 = g_();
      if ((i1 == 1) || (i1 == 2))
      {
        localMediaCodec = A();
        if ((com.google.android.exoplayer2.g.ag.a < 23) || (localMediaCodec == null) || (paramSurface == null) || (this.o))
          break label151;
        a(localMediaCodec, paramSurface);
      }
      if ((paramSurface == null) || (paramSurface == this.q))
        break label162;
      K();
      G();
      if (i1 == 2)
        F();
    }
    label151: label162: label171: 
    while ((paramSurface == null) || (paramSurface == this.q))
    {
      while (true)
      {
        int i1;
        MediaCodec localMediaCodec;
        return;
        com.google.android.exoplayer2.d.a locala = B();
        if ((locala == null) || (!b(locala)))
          break;
        this.q = DummySurface.newInstanceV17(this.f, locala.f);
        paramSurface = this.q;
        break;
        C();
        y();
      }
      I();
      G();
      return;
    }
    K();
    H();
  }

  private static int b(com.google.android.exoplayer2.d.a parama, Format paramFormat)
  {
    if (paramFormat.maxInputSize != -1)
    {
      int i1 = paramFormat.initializationData.size();
      int i2 = 0;
      int i3 = 0;
      while (i2 < i1)
      {
        i3 += ((byte[])paramFormat.initializationData.get(i2)).length;
        i2++;
      }
      return i3 + paramFormat.maxInputSize;
    }
    return a(parama, paramFormat.sampleMimeType, paramFormat.width, paramFormat.height);
  }

  private boolean b(com.google.android.exoplayer2.d.a parama)
  {
    return (com.google.android.exoplayer2.g.ag.a >= 23) && (!this.K) && (!a(parama.a)) && ((!parama.f) || (DummySurface.isSecureSupported(this.f)));
  }

  private static boolean b(String paramString)
  {
    return ("OMX.amlogic.avc.decoder.awesome".equals(paramString)) && (com.google.android.exoplayer2.g.ag.a <= 25);
  }

  private static boolean f(long paramLong)
  {
    return paramLong < -30000L;
  }

  private static boolean g(long paramLong)
  {
    return paramLong < -500000L;
  }

  protected void C()
  {
    try
    {
      super.C();
      return;
    }
    finally
    {
      this.y = 0;
      if (this.q != null)
      {
        if (this.p == this.q)
          this.p = null;
        this.q.release();
        this.q = null;
      }
    }
  }

  protected void D()
    throws i
  {
    super.D();
    this.y = 0;
  }

  protected float a(float paramFloat, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i1 = paramArrayOfFormat.length;
    int i2 = 0;
    float f1 = -1.0F;
    while (i2 < i1)
    {
      float f2 = paramArrayOfFormat[i2].frameRate;
      if (f2 != -1.0F)
        f1 = Math.max(f1, f2);
      i2++;
    }
    if (f1 == -1.0F)
      return -1.0F;
    return f1 * paramFloat;
  }

  protected int a(MediaCodec paramMediaCodec, com.google.android.exoplayer2.d.a parama, Format paramFormat1, Format paramFormat2)
  {
    if ((parama.a(paramFormat1, paramFormat2, true)) && (paramFormat2.width <= this.n.a) && (paramFormat2.height <= this.n.b) && (b(parama, paramFormat2) <= this.n.c))
    {
      if (paramFormat1.initializationDataEquals(paramFormat2))
        return 1;
      return 3;
    }
    return 0;
  }

  protected int a(com.google.android.exoplayer2.d.c paramc, com.google.android.exoplayer2.drm.l<p> paraml, Format paramFormat)
    throws d.b
  {
    if (!o.b(paramFormat.sampleMimeType))
      return 0;
    DrmInitData localDrmInitData = paramFormat.drmInitData;
    if (localDrmInitData != null)
    {
      int i5 = 0;
      bool1 = false;
      while (i5 < localDrmInitData.schemeDataCount)
      {
        bool1 |= localDrmInitData.get(i5).requiresSecureDecryption;
        i5++;
      }
    }
    boolean bool1 = false;
    List localList = paramc.a(paramFormat.sampleMimeType, bool1);
    if (localList.isEmpty())
    {
      if ((bool1) && (!paramc.a(paramFormat.sampleMimeType, false).isEmpty()));
      for (int i4 = 2; ; i4 = 1)
        return i4;
    }
    if (!a(paraml, localDrmInitData))
      return 2;
    com.google.android.exoplayer2.d.a locala = (com.google.android.exoplayer2.d.a)localList.get(0);
    boolean bool2 = locala.a(paramFormat);
    int i1;
    int i2;
    if (locala.b(paramFormat))
    {
      i1 = 16;
      boolean bool3 = locala.e;
      i2 = 0;
      if (bool3)
        i2 = 32;
      if (!bool2)
        break label211;
    }
    label211: for (int i3 = 4; ; i3 = 3)
    {
      return i3 | (i2 | i1);
      i1 = 8;
      break;
    }
  }

  @SuppressLint({"InlinedApi"})
  protected MediaFormat a(Format paramFormat, a parama, float paramFloat, boolean paramBoolean, int paramInt)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramFormat.sampleMimeType);
    localMediaFormat.setInteger("width", paramFormat.width);
    localMediaFormat.setInteger("height", paramFormat.height);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, paramFormat.initializationData);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, "frame-rate", paramFormat.frameRate);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, "rotation-degrees", paramFormat.rotationDegrees);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, paramFormat.colorInfo);
    localMediaFormat.setInteger("max-width", parama.a);
    localMediaFormat.setInteger("max-height", parama.b);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, "max-input-size", parama.c);
    if (com.google.android.exoplayer2.g.ag.a >= 23)
    {
      localMediaFormat.setInteger("priority", 0);
      if (paramFloat != -1.0F)
        localMediaFormat.setFloat("operating-rate", paramFloat);
    }
    if (paramBoolean)
    {
      localMediaFormat.setInteger("no-post-process", 1);
      localMediaFormat.setInteger("auto-frc", 0);
    }
    if (paramInt != 0)
      a(localMediaFormat, paramInt);
    return localMediaFormat;
  }

  protected a a(com.google.android.exoplayer2.d.a parama, Format paramFormat, Format[] paramArrayOfFormat)
    throws d.b
  {
    int i1 = paramFormat.width;
    int i2 = paramFormat.height;
    if (b(parama.a))
    {
      i1 = Math.max(i1, 1920);
      i2 = Math.max(i2, 1089);
    }
    int i3 = b(parama, paramFormat);
    if (paramArrayOfFormat.length == 1)
    {
      if (i3 != -1)
      {
        int i16 = a(parama, paramFormat.sampleMimeType, paramFormat.width, paramFormat.height);
        if (i16 != -1)
          i3 = Math.min((int)(1.5F * i3), i16);
      }
      return new a(i1, i2, i3);
    }
    int i4 = paramArrayOfFormat.length;
    int i5 = 0;
    int i6 = i2;
    int i7 = i1;
    int i8 = 0;
    int i13;
    label177: int i9;
    int i14;
    int i10;
    int i11;
    if (i5 < i4)
    {
      Format localFormat = paramArrayOfFormat[i5];
      if (!parama.a(paramFormat, localFormat, false))
        break label407;
      if ((localFormat.width == -1) || (localFormat.height == -1))
      {
        i13 = 1;
        i9 = i13 | i8;
        i14 = Math.max(i7, localFormat.width);
        int i15 = Math.max(i6, localFormat.height);
        i10 = Math.max(i3, b(parama, localFormat));
        i11 = i15;
      }
    }
    for (int i12 = i14; ; i12 = i7)
    {
      i5++;
      i7 = i12;
      i6 = i11;
      i3 = i10;
      i8 = i9;
      break;
      i13 = 0;
      break label177;
      if (i8 != 0)
      {
        com.google.android.exoplayer2.g.l.c("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i7 + "x" + i6);
        Point localPoint = a(parama, paramFormat);
        if (localPoint != null)
        {
          i7 = Math.max(i7, localPoint.x);
          i6 = Math.max(i6, localPoint.y);
          i3 = Math.max(i3, a(parama, paramFormat.sampleMimeType, i7, i6));
          com.google.android.exoplayer2.g.l.c("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i7 + "x" + i6);
        }
      }
      return new a(i7, i6, i3);
      label407: i9 = i8;
      i10 = i3;
      i11 = i6;
    }
  }

  public void a(int paramInt, Object paramObject)
    throws i
  {
    if (paramInt == 1)
      a((Surface)paramObject);
    MediaCodec localMediaCodec;
    do
    {
      return;
      if (paramInt != 4)
        break;
      this.r = ((Integer)paramObject).intValue();
      localMediaCodec = A();
    }
    while (localMediaCodec == null);
    localMediaCodec.setVideoScalingMode(this.r);
    return;
    if (paramInt == 6)
    {
      this.P = ((d)paramObject);
      return;
    }
    super.a(paramInt, paramObject);
  }

  protected void a(long paramLong, boolean paramBoolean)
    throws i
  {
    super.a(paramLong, paramBoolean);
    G();
    this.t = -9223372036854775807L;
    this.x = 0;
    this.M = -9223372036854775807L;
    if (this.O != 0)
    {
      this.N = this.l[(-1 + this.O)];
      this.O = 0;
    }
    if (paramBoolean)
    {
      F();
      return;
    }
    this.u = -9223372036854775807L;
  }

  protected void a(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    ae.a("skipVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    ae.a();
    com.google.android.exoplayer2.c.d locald = this.a;
    locald.f = (1 + locald.f);
  }

  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    int i1;
    int i2;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top")))
    {
      i1 = 1;
      if (i1 == 0)
        break label103;
      i2 = 1 + (paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left"));
      label65: if (i1 == 0)
        break label115;
    }
    label103: label115: for (int i3 = 1 + (paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top")); ; i3 = paramMediaFormat.getInteger("height"))
    {
      a(paramMediaCodec, i2, i3);
      return;
      i1 = 0;
      break;
      i2 = paramMediaFormat.getInteger("width");
      break label65;
    }
  }

  protected void a(com.google.android.exoplayer2.c.e parame)
  {
    this.y = (1 + this.y);
    this.M = Math.max(parame.c, this.M);
    if ((com.google.android.exoplayer2.g.ag.a < 23) && (this.K))
      e(parame.c);
  }

  protected void a(com.google.android.exoplayer2.d.a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto, float paramFloat)
    throws d.b
  {
    this.n = a(parama, paramFormat, q());
    MediaFormat localMediaFormat = a(paramFormat, this.n, paramFloat, this.k, this.L);
    if (this.p == null)
    {
      com.google.android.exoplayer2.g.a.b(b(parama));
      if (this.q == null)
        this.q = DummySurface.newInstanceV17(this.f, parama.f);
      this.p = this.q;
    }
    paramMediaCodec.configure(localMediaFormat, this.p, paramMediaCrypto, 0);
    if ((com.google.android.exoplayer2.g.ag.a >= 23) && (this.K))
      this.b = new b(paramMediaCodec, null);
  }

  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    this.h.a(paramString, paramLong1, paramLong2);
    this.o = a(paramString);
  }

  protected void a(boolean paramBoolean)
    throws i
  {
    super.a(paramBoolean);
    this.L = r().b;
    if (this.L != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.K = bool;
      this.h.a(this.a);
      this.g.a();
      return;
    }
  }

  protected void a(Format[] paramArrayOfFormat, long paramLong)
    throws i
  {
    if (this.N == -9223372036854775807L)
    {
      this.N = paramLong;
      super.a(paramArrayOfFormat, paramLong);
      return;
    }
    if (this.O == this.l.length)
      com.google.android.exoplayer2.g.l.c("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.l[(-1 + this.O)]);
    while (true)
    {
      this.l[(-1 + this.O)] = paramLong;
      this.m[(-1 + this.O)] = this.M;
      break;
      this.O = (1 + this.O);
    }
  }

  protected boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean, Format paramFormat)
    throws i
  {
    if (this.t == -9223372036854775807L)
      this.t = paramLong1;
    long l1 = paramLong3 - this.N;
    if (paramBoolean)
    {
      a(paramMediaCodec, paramInt1, l1);
      return true;
    }
    long l2 = paramLong3 - paramLong1;
    if (this.p == this.q)
    {
      if (f(l2))
      {
        a(paramMediaCodec, paramInt1, l1);
        return true;
      }
      return false;
    }
    long l3 = 1000L * SystemClock.elapsedRealtime();
    int i1;
    if (g_() == 2)
    {
      i1 = 1;
      if ((this.s) && ((i1 == 0) || (!d(l2, l3 - this.z))))
        break label185;
      long l4 = System.nanoTime();
      a(l1, l4, paramFormat);
      if (com.google.android.exoplayer2.g.ag.a < 21)
        break label172;
      b(paramMediaCodec, paramInt1, l1, l4);
    }
    while (true)
    {
      return true;
      i1 = 0;
      break;
      label172: c(paramMediaCodec, paramInt1, l1);
    }
    label185: if ((i1 == 0) || (paramLong1 == this.t))
      return false;
    long l5 = l2 - (l3 - paramLong2);
    long l6 = System.nanoTime();
    long l7 = l6 + l5 * 1000L;
    long l8 = this.g.a(paramLong3, l7);
    long l9 = (l8 - l6) / 1000L;
    if ((c(l9, paramLong2)) && (a(paramMediaCodec, paramInt1, l1, paramLong1)))
      return false;
    if (b(l9, paramLong2))
    {
      b(paramMediaCodec, paramInt1, l1);
      return true;
    }
    if (com.google.android.exoplayer2.g.ag.a >= 21)
    {
      if (l9 < 50000L)
      {
        a(l1, l8, paramFormat);
        b(paramMediaCodec, paramInt1, l1, l8);
        return true;
      }
    }
    else if (l9 < 30000L)
    {
      long l10;
      if (l9 > 11000L)
        l10 = l9 - 10000L;
      try
      {
        Thread.sleep(l10 / 1000L);
        a(l1, l8, paramFormat);
        c(paramMediaCodec, paramInt1, l1);
        return true;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return false;
      }
    }
    return false;
  }

  protected boolean a(MediaCodec paramMediaCodec, int paramInt, long paramLong1, long paramLong2)
    throws i
  {
    int i1 = b(paramLong2);
    if (i1 == 0)
      return false;
    com.google.android.exoplayer2.c.d locald = this.a;
    locald.i = (1 + locald.i);
    b(i1 + this.y);
    D();
    return true;
  }

  protected boolean a(com.google.android.exoplayer2.d.a parama)
  {
    return (this.p != null) || (b(parama));
  }

  protected boolean a(String paramString)
  {
    int i1 = 27;
    if (paramString.startsWith("OMX.google"))
      return false;
    while (true)
    {
      String str1;
      String str2;
      try
      {
        if (!d)
        {
          if ((com.google.android.exoplayer2.g.ag.a <= i1) && ("dangal".equals(com.google.android.exoplayer2.g.ag.b)))
          {
            e = true;
            d = true;
          }
        }
        else
          return e;
        if (com.google.android.exoplayer2.g.ag.a >= i1)
          continue;
        str1 = com.google.android.exoplayer2.g.ag.b;
        switch (str1.hashCode())
        {
        case 1513190:
          str2 = com.google.android.exoplayer2.g.ag.d;
          switch (str2.hashCode())
          {
          case 2006354:
            e = true;
            continue;
          case 2006367:
          }
          break;
        case 1514184:
        case 1514185:
        case -993250464:
        case 61542055:
        case 165221241:
        case -821392978:
        case 917340916:
        case 307593612:
        case 308517133:
        case -1931988508:
        case 2033393791:
        case 55178625:
        case -282781963:
        case -1217592143:
        case 2006372676:
        case 2126:
        case -1680025915:
        case -2022874474:
        case 1691543273:
        case 182191441:
        case 98846:
        case 98848:
        case 99329:
        case 65355429:
        case -173639913:
        case 2047190025:
        case 2047252157:
        case -958336948:
        case 1306947716:
        case 66214468:
        case 66214470:
        case 66214473:
        case 66215429:
        case 66215431:
        case 66215433:
        case 66216390:
        case 101481:
        case 3154429:
        case -575125681:
        case -1320080169:
        case -521118391:
        case -2144781245:
        case -2144781185:
        case -2144781160:
        case 793982701:
        case 794038622:
        case 794040393:
        case 287431619:
        case 1349174697:
        case 1280332038:
        case 2029784656:
        case 2030379515:
        case 2048319463:
        case 2048855701:
        case 98715550:
        case 1709443163:
        case 1977196784:
        case -1180384755:
        case 1176899427:
        case 958008161:
        case 73405:
        case -2097309513:
        case 3284551:
        case 102844228:
        case 1150207623:
        case 75739:
        case 835649806:
        case 245388979:
        case 41325051:
        case 3483:
        case 3351335:
        case 76779:
        case -1052835013:
        case -842500323:
        case -1978993182:
        case -1978990237:
        case -782144577:
        case 3386211:
        case 2436959:
        case 78669:
        case 1060579533:
        case -1481772737:
        case -1481772730:
        case -1481772729:
        case 1906253259:
        case -1936688988:
        case -1936688066:
        case -1936688065:
        case -1615810839:
        case -430914369:
        case 407160593:
        case 79305:
        case 76402249:
        case 2463773:
        case 76404105:
        case 2464648:
        case 76404911:
        case 2564:
        case 507412548:
        case 80618:
        case 1865889110:
        case -1139198265:
        case -797483286:
        case -965403638:
        case -290434366:
        case 316215098:
        case 316215116:
        case 316246811:
        case 316246818:
        case -879245230:
        case 2715:
        case 80963634:
        case 2719:
        case -1554255044:
        case -794946968:
        case -788334647:
        case 1522194893:
        case -56598463:
        case 82882791:
        case 2689555:
        case -1696512866:
        case -277133239:
        case 88274:
        }
      }
      finally
      {
      }
      int i2;
      if (str1.equals("1601"))
      {
        i1 = 0;
        break label3271;
        if (str1.equals("1713"))
        {
          i1 = 1;
          break label3271;
          if (str1.equals("1714"))
          {
            i1 = 2;
            break label3271;
            if (str1.equals("A10-70F"))
            {
              i1 = 3;
              break label3271;
              if (str1.equals("A1601"))
              {
                i1 = 4;
                break label3271;
                if (str1.equals("A2016a40"))
                {
                  i1 = 5;
                  break label3271;
                  if (str1.equals("A7000-a"))
                  {
                    i1 = 6;
                    break label3271;
                    if (str1.equals("A7000plus"))
                    {
                      i1 = 7;
                      break label3271;
                      if (str1.equals("A7010a48"))
                      {
                        i1 = 8;
                        break label3271;
                        if (str1.equals("A7020a48"))
                        {
                          i1 = 9;
                          break label3271;
                          if (str1.equals("AquaPowerM"))
                          {
                            i1 = 10;
                            break label3271;
                            if (str1.equals("ASUS_X00AD_2"))
                            {
                              i1 = 11;
                              break label3271;
                              if (str1.equals("Aura_Note_2"))
                              {
                                i1 = 12;
                                break label3271;
                                if (str1.equals("BLACK-1X"))
                                {
                                  i1 = 13;
                                  break label3271;
                                  if (str1.equals("BRAVIA_ATV2"))
                                  {
                                    i1 = 14;
                                    break label3271;
                                    if (str1.equals("BRAVIA_ATV3_4K"))
                                    {
                                      i1 = 15;
                                      break label3271;
                                      if (str1.equals("C1"))
                                      {
                                        i1 = 16;
                                        break label3271;
                                        if (str1.equals("ComioS1"))
                                        {
                                          i1 = 17;
                                          break label3271;
                                          if (str1.equals("CP8676_I02"))
                                          {
                                            i1 = 18;
                                            break label3271;
                                            if (str1.equals("CPH1609"))
                                            {
                                              i1 = 19;
                                              break label3271;
                                              if (str1.equals("CPY83_I00"))
                                              {
                                                i1 = 20;
                                                break label3271;
                                                if (str1.equals("cv1"))
                                                {
                                                  i1 = 21;
                                                  break label3271;
                                                  if (str1.equals("cv3"))
                                                  {
                                                    i1 = 22;
                                                    break label3271;
                                                    if (str1.equals("deb"))
                                                    {
                                                      i1 = 23;
                                                      break label3271;
                                                      if (str1.equals("E5643"))
                                                      {
                                                        i1 = 24;
                                                        break label3271;
                                                        if (str1.equals("ELUGA_A3_Pro"))
                                                        {
                                                          i1 = 25;
                                                          break label3271;
                                                          if (str1.equals("ELUGA_Note"))
                                                          {
                                                            i1 = 26;
                                                            break label3271;
                                                            if (str1.equals("ELUGA_Prim"))
                                                            {
                                                              break label3271;
                                                              if (str1.equals("ELUGA_Ray_X"))
                                                              {
                                                                i1 = 28;
                                                                break label3271;
                                                                if (str1.equals("EverStar_S"))
                                                                {
                                                                  i1 = 29;
                                                                  break label3271;
                                                                  if (str1.equals("F3111"))
                                                                  {
                                                                    i1 = 30;
                                                                    break label3271;
                                                                    if (str1.equals("F3113"))
                                                                    {
                                                                      i1 = 31;
                                                                      break label3271;
                                                                      if (str1.equals("F3116"))
                                                                      {
                                                                        i1 = 32;
                                                                        break label3271;
                                                                        if (str1.equals("F3211"))
                                                                        {
                                                                          i1 = 33;
                                                                          break label3271;
                                                                          if (str1.equals("F3213"))
                                                                          {
                                                                            i1 = 34;
                                                                            break label3271;
                                                                            if (str1.equals("F3215"))
                                                                            {
                                                                              i1 = 35;
                                                                              break label3271;
                                                                              if (str1.equals("F3311"))
                                                                              {
                                                                                i1 = 36;
                                                                                break label3271;
                                                                                if (str1.equals("flo"))
                                                                                {
                                                                                  i1 = 37;
                                                                                  break label3271;
                                                                                  if (str1.equals("fugu"))
                                                                                  {
                                                                                    i1 = 38;
                                                                                    break label3271;
                                                                                    if (str1.equals("GiONEE_CBL7513"))
                                                                                    {
                                                                                      i1 = 39;
                                                                                      break label3271;
                                                                                      if (str1.equals("GiONEE_GBL7319"))
                                                                                      {
                                                                                        i1 = 40;
                                                                                        break label3271;
                                                                                        if (str1.equals("GIONEE_GBL7360"))
                                                                                        {
                                                                                          i1 = 41;
                                                                                          break label3271;
                                                                                          if (str1.equals("GIONEE_SWW1609"))
                                                                                          {
                                                                                            i1 = 42;
                                                                                            break label3271;
                                                                                            if (str1.equals("GIONEE_SWW1627"))
                                                                                            {
                                                                                              i1 = 43;
                                                                                              break label3271;
                                                                                              if (str1.equals("GIONEE_SWW1631"))
                                                                                              {
                                                                                                i1 = 44;
                                                                                                break label3271;
                                                                                                if (str1.equals("GIONEE_WBL5708"))
                                                                                                {
                                                                                                  i1 = 45;
                                                                                                  break label3271;
                                                                                                  if (str1.equals("GIONEE_WBL7365"))
                                                                                                  {
                                                                                                    i1 = 46;
                                                                                                    break label3271;
                                                                                                    if (str1.equals("GIONEE_WBL7519"))
                                                                                                    {
                                                                                                      i1 = 47;
                                                                                                      break label3271;
                                                                                                      if (str1.equals("griffin"))
                                                                                                      {
                                                                                                        i1 = 48;
                                                                                                        break label3271;
                                                                                                        if (str1.equals("htc_e56ml_dtul"))
                                                                                                        {
                                                                                                          i1 = 49;
                                                                                                          break label3271;
                                                                                                          if (str1.equals("hwALE-H"))
                                                                                                          {
                                                                                                            i1 = 50;
                                                                                                            break label3271;
                                                                                                            if (str1.equals("HWBLN-H"))
                                                                                                            {
                                                                                                              i1 = 51;
                                                                                                              break label3271;
                                                                                                              if (str1.equals("HWCAM-H"))
                                                                                                              {
                                                                                                                i1 = 52;
                                                                                                                break label3271;
                                                                                                                if (str1.equals("HWVNS-H"))
                                                                                                                {
                                                                                                                  i1 = 53;
                                                                                                                  break label3271;
                                                                                                                  if (str1.equals("HWWAS-H"))
                                                                                                                  {
                                                                                                                    i1 = 54;
                                                                                                                    break label3271;
                                                                                                                    if (str1.equals("i9031"))
                                                                                                                    {
                                                                                                                      i1 = 55;
                                                                                                                      break label3271;
                                                                                                                      if (str1.equals("iball8735_9806"))
                                                                                                                      {
                                                                                                                        i1 = 56;
                                                                                                                        break label3271;
                                                                                                                        if (str1.equals("Infinix-X572"))
                                                                                                                        {
                                                                                                                          i1 = 57;
                                                                                                                          break label3271;
                                                                                                                          if (str1.equals("iris60"))
                                                                                                                          {
                                                                                                                            i1 = 58;
                                                                                                                            break label3271;
                                                                                                                            if (str1.equals("itel_S41"))
                                                                                                                            {
                                                                                                                              i1 = 59;
                                                                                                                              break label3271;
                                                                                                                              if (str1.equals("j2xlteins"))
                                                                                                                              {
                                                                                                                                i1 = 60;
                                                                                                                                break label3271;
                                                                                                                                if (str1.equals("JGZ"))
                                                                                                                                {
                                                                                                                                  i1 = 61;
                                                                                                                                  break label3271;
                                                                                                                                  if (str1.equals("K50a40"))
                                                                                                                                  {
                                                                                                                                    i1 = 62;
                                                                                                                                    break label3271;
                                                                                                                                    if (str1.equals("kate"))
                                                                                                                                    {
                                                                                                                                      i1 = 63;
                                                                                                                                      break label3271;
                                                                                                                                      if (str1.equals("le_x6"))
                                                                                                                                      {
                                                                                                                                        i1 = 64;
                                                                                                                                        break label3271;
                                                                                                                                        if (str1.equals("LS-5017"))
                                                                                                                                        {
                                                                                                                                          i1 = 65;
                                                                                                                                          break label3271;
                                                                                                                                          if (str1.equals("M5c"))
                                                                                                                                          {
                                                                                                                                            i1 = 66;
                                                                                                                                            break label3271;
                                                                                                                                            if (str1.equals("manning"))
                                                                                                                                            {
                                                                                                                                              i1 = 67;
                                                                                                                                              break label3271;
                                                                                                                                              if (str1.equals("marino_f"))
                                                                                                                                              {
                                                                                                                                                i1 = 68;
                                                                                                                                                break label3271;
                                                                                                                                                if (str1.equals("MEIZU_M5"))
                                                                                                                                                {
                                                                                                                                                  i1 = 69;
                                                                                                                                                  break label3271;
                                                                                                                                                  if (str1.equals("mh"))
                                                                                                                                                  {
                                                                                                                                                    i1 = 70;
                                                                                                                                                    break label3271;
                                                                                                                                                    if (str1.equals("mido"))
                                                                                                                                                    {
                                                                                                                                                      i1 = 71;
                                                                                                                                                      break label3271;
                                                                                                                                                      if (str1.equals("MX6"))
                                                                                                                                                      {
                                                                                                                                                        i1 = 72;
                                                                                                                                                        break label3271;
                                                                                                                                                        if (str1.equals("namath"))
                                                                                                                                                        {
                                                                                                                                                          i1 = 73;
                                                                                                                                                          break label3271;
                                                                                                                                                          if (str1.equals("nicklaus_f"))
                                                                                                                                                          {
                                                                                                                                                            i1 = 74;
                                                                                                                                                            break label3271;
                                                                                                                                                            if (str1.equals("NX541J"))
                                                                                                                                                            {
                                                                                                                                                              i1 = 75;
                                                                                                                                                              break label3271;
                                                                                                                                                              if (str1.equals("NX573J"))
                                                                                                                                                              {
                                                                                                                                                                i1 = 76;
                                                                                                                                                                break label3271;
                                                                                                                                                                if (str1.equals("OnePlus5T"))
                                                                                                                                                                {
                                                                                                                                                                  i1 = 77;
                                                                                                                                                                  break label3271;
                                                                                                                                                                  if (str1.equals("p212"))
                                                                                                                                                                  {
                                                                                                                                                                    i1 = 78;
                                                                                                                                                                    break label3271;
                                                                                                                                                                    if (str1.equals("P681"))
                                                                                                                                                                    {
                                                                                                                                                                      i1 = 79;
                                                                                                                                                                      break label3271;
                                                                                                                                                                      if (str1.equals("P85"))
                                                                                                                                                                      {
                                                                                                                                                                        i1 = 80;
                                                                                                                                                                        break label3271;
                                                                                                                                                                        if (str1.equals("panell_d"))
                                                                                                                                                                        {
                                                                                                                                                                          i1 = 81;
                                                                                                                                                                          break label3271;
                                                                                                                                                                          if (str1.equals("panell_dl"))
                                                                                                                                                                          {
                                                                                                                                                                            i1 = 82;
                                                                                                                                                                            break label3271;
                                                                                                                                                                            if (str1.equals("panell_ds"))
                                                                                                                                                                            {
                                                                                                                                                                              i1 = 83;
                                                                                                                                                                              break label3271;
                                                                                                                                                                              if (str1.equals("panell_dt"))
                                                                                                                                                                              {
                                                                                                                                                                                i1 = 84;
                                                                                                                                                                                break label3271;
                                                                                                                                                                                if (str1.equals("PB2-670M"))
                                                                                                                                                                                {
                                                                                                                                                                                  i1 = 85;
                                                                                                                                                                                  break label3271;
                                                                                                                                                                                  if (str1.equals("PGN528"))
                                                                                                                                                                                  {
                                                                                                                                                                                    i1 = 86;
                                                                                                                                                                                    break label3271;
                                                                                                                                                                                    if (str1.equals("PGN610"))
                                                                                                                                                                                    {
                                                                                                                                                                                      i1 = 87;
                                                                                                                                                                                      break label3271;
                                                                                                                                                                                      if (str1.equals("PGN611"))
                                                                                                                                                                                      {
                                                                                                                                                                                        i1 = 88;
                                                                                                                                                                                        break label3271;
                                                                                                                                                                                        if (str1.equals("Phantom6"))
                                                                                                                                                                                        {
                                                                                                                                                                                          i1 = 89;
                                                                                                                                                                                          break label3271;
                                                                                                                                                                                          if (str1.equals("Pixi4-7_3G"))
                                                                                                                                                                                          {
                                                                                                                                                                                            i1 = 90;
                                                                                                                                                                                            break label3271;
                                                                                                                                                                                            if (str1.equals("Pixi5-10_4G"))
                                                                                                                                                                                            {
                                                                                                                                                                                              i1 = 91;
                                                                                                                                                                                              break label3271;
                                                                                                                                                                                              if (str1.equals("PLE"))
                                                                                                                                                                                              {
                                                                                                                                                                                                i1 = 92;
                                                                                                                                                                                                break label3271;
                                                                                                                                                                                                if (str1.equals("PRO7S"))
                                                                                                                                                                                                {
                                                                                                                                                                                                  i1 = 93;
                                                                                                                                                                                                  break label3271;
                                                                                                                                                                                                  if (str1.equals("Q350"))
                                                                                                                                                                                                  {
                                                                                                                                                                                                    i1 = 94;
                                                                                                                                                                                                    break label3271;
                                                                                                                                                                                                    if (str1.equals("Q4260"))
                                                                                                                                                                                                    {
                                                                                                                                                                                                      i1 = 95;
                                                                                                                                                                                                      break label3271;
                                                                                                                                                                                                      if (str1.equals("Q427"))
                                                                                                                                                                                                      {
                                                                                                                                                                                                        i1 = 96;
                                                                                                                                                                                                        break label3271;
                                                                                                                                                                                                        if (str1.equals("Q4310"))
                                                                                                                                                                                                        {
                                                                                                                                                                                                          i1 = 97;
                                                                                                                                                                                                          break label3271;
                                                                                                                                                                                                          if (str1.equals("Q5"))
                                                                                                                                                                                                          {
                                                                                                                                                                                                            i1 = 98;
                                                                                                                                                                                                            break label3271;
                                                                                                                                                                                                            if (str1.equals("QM16XE_U"))
                                                                                                                                                                                                            {
                                                                                                                                                                                                              i1 = 99;
                                                                                                                                                                                                              break label3271;
                                                                                                                                                                                                              if (str1.equals("QX1"))
                                                                                                                                                                                                              {
                                                                                                                                                                                                                i1 = 100;
                                                                                                                                                                                                                break label3271;
                                                                                                                                                                                                                if (str1.equals("santoni"))
                                                                                                                                                                                                                {
                                                                                                                                                                                                                  i1 = 101;
                                                                                                                                                                                                                  break label3271;
                                                                                                                                                                                                                  if (str1.equals("Slate_Pro"))
                                                                                                                                                                                                                  {
                                                                                                                                                                                                                    i1 = 102;
                                                                                                                                                                                                                    break label3271;
                                                                                                                                                                                                                    if (str1.equals("SVP-DTV15"))
                                                                                                                                                                                                                    {
                                                                                                                                                                                                                      i1 = 103;
                                                                                                                                                                                                                      break label3271;
                                                                                                                                                                                                                      if (str1.equals("s905x018"))
                                                                                                                                                                                                                      {
                                                                                                                                                                                                                        i1 = 104;
                                                                                                                                                                                                                        break label3271;
                                                                                                                                                                                                                        if (str1.equals("taido_row"))
                                                                                                                                                                                                                        {
                                                                                                                                                                                                                          i1 = 105;
                                                                                                                                                                                                                          break label3271;
                                                                                                                                                                                                                          if (str1.equals("TB3-730F"))
                                                                                                                                                                                                                          {
                                                                                                                                                                                                                            i1 = 106;
                                                                                                                                                                                                                            break label3271;
                                                                                                                                                                                                                            if (str1.equals("TB3-730X"))
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                              i1 = 107;
                                                                                                                                                                                                                              break label3271;
                                                                                                                                                                                                                              if (str1.equals("TB3-850F"))
                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                i1 = 108;
                                                                                                                                                                                                                                break label3271;
                                                                                                                                                                                                                                if (str1.equals("TB3-850M"))
                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                  i1 = 109;
                                                                                                                                                                                                                                  break label3271;
                                                                                                                                                                                                                                  if (str1.equals("tcl_eu"))
                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                    i1 = 110;
                                                                                                                                                                                                                                    break label3271;
                                                                                                                                                                                                                                    if (str1.equals("V1"))
                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                      i1 = 111;
                                                                                                                                                                                                                                      break label3271;
                                                                                                                                                                                                                                      if (str1.equals("V23GB"))
                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                        i1 = 112;
                                                                                                                                                                                                                                        break label3271;
                                                                                                                                                                                                                                        if (str1.equals("V5"))
                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                          i1 = 113;
                                                                                                                                                                                                                                          break label3271;
                                                                                                                                                                                                                                          if (str1.equals("vernee_M5"))
                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                            i1 = 114;
                                                                                                                                                                                                                                            break label3271;
                                                                                                                                                                                                                                            if (str1.equals("watson"))
                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                              i1 = 115;
                                                                                                                                                                                                                                              break label3271;
                                                                                                                                                                                                                                              if (str1.equals("whyred"))
                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                i1 = 116;
                                                                                                                                                                                                                                                break label3271;
                                                                                                                                                                                                                                                if (str1.equals("woods_f"))
                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                  i1 = 117;
                                                                                                                                                                                                                                                  break label3271;
                                                                                                                                                                                                                                                  if (str1.equals("woods_fn"))
                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                    i1 = 118;
                                                                                                                                                                                                                                                    break label3271;
                                                                                                                                                                                                                                                    if (str1.equals("X3_HK"))
                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                      i1 = 119;
                                                                                                                                                                                                                                                      break label3271;
                                                                                                                                                                                                                                                      if (str1.equals("XE2X"))
                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                        i1 = 120;
                                                                                                                                                                                                                                                        break label3271;
                                                                                                                                                                                                                                                        if (str1.equals("XT1663"))
                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                          i1 = 121;
                                                                                                                                                                                                                                                          break label3271;
                                                                                                                                                                                                                                                          if (str1.equals("Z12_PRO"))
                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                            i1 = 122;
                                                                                                                                                                                                                                                            break label3271;
                                                                                                                                                                                                                                                            if (str1.equals("Z80"))
                                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                              i1 = 123;
                                                                                                                                                                                                                                                              break label3271;
                                                                                                                                                                                                                                                              e = true;
                                                                                                                                                                                                                                                              continue;
                                                                                                                                                                                                                                                              if (!str2.equals("AFTA"))
                                                                                                                                                                                                                                                                break label3784;
                                                                                                                                                                                                                                                              i2 = 0;
                                                                                                                                                                                                                                                              break label3787;
                                                                                                                                                                                                                                                              boolean bool = str2.equals("AFTN");
                                                                                                                                                                                                                                                              if (!bool)
                                                                                                                                                                                                                                                                break label3784;
                                                                                                                                                                                                                                                              i2 = 1;
                                                                                                                                                                                                                                                              break label3787;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                              }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                          }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                      }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                  }
                                                                                                                                                                                                                }
                                                                                                                                                                                                              }
                                                                                                                                                                                                            }
                                                                                                                                                                                                          }
                                                                                                                                                                                                        }
                                                                                                                                                                                                      }
                                                                                                                                                                                                    }
                                                                                                                                                                                                  }
                                                                                                                                                                                                }
                                                                                                                                                                                              }
                                                                                                                                                                                            }
                                                                                                                                                                                          }
                                                                                                                                                                                        }
                                                                                                                                                                                      }
                                                                                                                                                                                    }
                                                                                                                                                                                  }
                                                                                                                                                                                }
                                                                                                                                                                              }
                                                                                                                                                                            }
                                                                                                                                                                          }
                                                                                                                                                                        }
                                                                                                                                                                      }
                                                                                                                                                                    }
                                                                                                                                                                  }
                                                                                                                                                                }
                                                                                                                                                              }
                                                                                                                                                            }
                                                                                                                                                          }
                                                                                                                                                        }
                                                                                                                                                      }
                                                                                                                                                    }
                                                                                                                                                  }
                                                                                                                                                }
                                                                                                                                              }
                                                                                                                                            }
                                                                                                                                          }
                                                                                                                                        }
                                                                                                                                      }
                                                                                                                                    }
                                                                                                                                  }
                                                                                                                                }
                                                                                                                              }
                                                                                                                            }
                                                                                                                          }
                                                                                                                        }
                                                                                                                      }
                                                                                                                    }
                                                                                                                  }
                                                                                                                }
                                                                                                              }
                                                                                                            }
                                                                                                          }
                                                                                                        }
                                                                                                      }
                                                                                                    }
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        i1 = -1;
        label3271: switch (i1)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 24:
        case 25:
        case 26:
        case 27:
        case 28:
        case 29:
        case 30:
        case 31:
        case 32:
        case 33:
        case 34:
        case 35:
        case 36:
        case 37:
        case 38:
        case 39:
        case 40:
        case 41:
        case 42:
        case 43:
        case 44:
        case 45:
        case 46:
        case 47:
        case 48:
        case 49:
        case 50:
        case 51:
        case 52:
        case 53:
        case 54:
        case 55:
        case 56:
        case 57:
        case 58:
        case 59:
        case 60:
        case 61:
        case 62:
        case 63:
        case 64:
        case 65:
        case 66:
        case 67:
        case 68:
        case 69:
        case 70:
        case 71:
        case 72:
        case 73:
        case 74:
        case 75:
        case 76:
        case 77:
        case 78:
        case 79:
        case 80:
        case 81:
        case 82:
        case 83:
        case 84:
        case 85:
        case 86:
        case 87:
        case 88:
        case 89:
        case 90:
        case 91:
        case 92:
        case 93:
        case 94:
        case 95:
        case 96:
        case 97:
        case 98:
        case 99:
        case 100:
        case 101:
        case 102:
        case 103:
        case 104:
        case 105:
        case 106:
        case 107:
        case 108:
        case 109:
        case 110:
        case 111:
        case 112:
        case 113:
        case 114:
        case 115:
        case 116:
        case 117:
        case 118:
        case 119:
        case 120:
        case 121:
        case 122:
        case 123:
        }
        label3784: i2 = -1;
        label3787: switch (i2)
        {
        case 0:
        case 1:
        }
      }
    }
  }

  protected void b(int paramInt)
  {
    com.google.android.exoplayer2.c.d locald = this.a;
    locald.g = (paramInt + locald.g);
    this.w = (paramInt + this.w);
    this.x = (paramInt + this.x);
    this.a.h = Math.max(this.x, this.a.h);
    if ((this.j > 0) && (this.w >= this.j))
      L();
  }

  protected void b(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    ae.a("dropVideoBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, false);
    ae.a();
    b(1);
  }

  @TargetApi(21)
  protected void b(MediaCodec paramMediaCodec, int paramInt, long paramLong1, long paramLong2)
  {
    J();
    ae.a("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, paramLong2);
    ae.a();
    this.z = (1000L * SystemClock.elapsedRealtime());
    com.google.android.exoplayer2.c.d locald = this.a;
    locald.e = (1 + locald.e);
    this.x = 0;
    w();
  }

  protected void b(Format paramFormat)
    throws i
  {
    super.b(paramFormat);
    this.h.a(paramFormat);
    this.B = paramFormat.pixelWidthHeightRatio;
    this.A = paramFormat.rotationDegrees;
  }

  protected boolean b(long paramLong1, long paramLong2)
  {
    return f(paramLong1);
  }

  protected void c(long paramLong)
  {
    this.y = (-1 + this.y);
    while ((this.O != 0) && (paramLong >= this.m[0]))
    {
      this.N = this.l[0];
      this.O = (-1 + this.O);
      System.arraycopy(this.l, 1, this.l, 0, this.O);
      System.arraycopy(this.m, 1, this.m, 0, this.O);
    }
  }

  protected void c(MediaCodec paramMediaCodec, int paramInt, long paramLong)
  {
    J();
    ae.a("releaseOutputBuffer");
    paramMediaCodec.releaseOutputBuffer(paramInt, true);
    ae.a();
    this.z = (1000L * SystemClock.elapsedRealtime());
    com.google.android.exoplayer2.c.d locald = this.a;
    locald.e = (1 + locald.e);
    this.x = 0;
    w();
  }

  protected boolean c(long paramLong1, long paramLong2)
  {
    return g(paramLong1);
  }

  protected boolean d(long paramLong1, long paramLong2)
  {
    return (f(paramLong1)) && (paramLong2 > 100000L);
  }

  protected void e(long paramLong)
  {
    Format localFormat = d(paramLong);
    if (localFormat != null)
      a(A(), localFormat.width, localFormat.height);
    J();
    w();
    c(paramLong);
  }

  protected void n()
  {
    super.n();
    this.w = 0;
    this.v = SystemClock.elapsedRealtime();
    this.z = (1000L * SystemClock.elapsedRealtime());
  }

  protected void o()
  {
    this.u = -9223372036854775807L;
    L();
    super.o();
  }

  protected void p()
  {
    this.C = -1;
    this.D = -1;
    this.F = -1.0F;
    this.B = -1.0F;
    this.N = -9223372036854775807L;
    this.M = -9223372036854775807L;
    this.O = 0;
    I();
    G();
    this.g.b();
    this.b = null;
    this.K = false;
    try
    {
      super.p();
      return;
    }
    finally
    {
      this.a.a();
      this.h.b(this.a);
    }
  }

  public boolean u()
  {
    if ((super.u()) && ((this.s) || ((this.q != null) && (this.p == this.q)) || (A() == null) || (this.K)))
      this.u = -9223372036854775807L;
    do
    {
      return true;
      if (this.u == -9223372036854775807L)
        return false;
    }
    while (SystemClock.elapsedRealtime() < this.u);
    this.u = -9223372036854775807L;
    return false;
  }

  void w()
  {
    if (!this.s)
    {
      this.s = true;
      this.h.a(this.p);
    }
  }

  protected boolean z()
  {
    return this.K;
  }

  protected static final class a
  {
    public final int a;
    public final int b;
    public final int c;

    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }

  @TargetApi(23)
  private final class b
    implements MediaCodec.OnFrameRenderedListener
  {
    private b(MediaCodec arg2)
    {
      Object localObject;
      localObject.setOnFrameRenderedListener(this, new Handler());
    }

    public void onFrameRendered(MediaCodec paramMediaCodec, long paramLong1, long paramLong2)
    {
      if (this != c.this.b)
        return;
      c.this.e(paramLong1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.c
 * JD-Core Version:    0.6.2
 */