package com.google.android.exoplayer2.d;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.k;
import com.google.android.exoplayer2.g.ac;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.i;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends com.google.android.exoplayer2.b
{
  private static final byte[] b = ag.h("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private ByteBuffer[] I;
  private ByteBuffer[] J;
  private long K;
  private int L;
  private int M;
  private ByteBuffer N;
  private boolean O;
  private boolean P;
  private int Q;
  private int R;
  private boolean S;
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  protected d a;
  private final c c;
  private final com.google.android.exoplayer2.drm.l<com.google.android.exoplayer2.drm.p> d;
  private final boolean e;
  private final float f;
  private final e g;
  private final e h;
  private final com.google.android.exoplayer2.p i;
  private final ac<Format> j;
  private final List<Long> k;
  private final MediaCodec.BufferInfo l;
  private Format m;
  private Format n;
  private Format o;
  private k<com.google.android.exoplayer2.drm.p> p;
  private k<com.google.android.exoplayer2.drm.p> q;
  private MediaCodec r;
  private float s;
  private float t;
  private boolean u;
  private ArrayDeque<a> v;
  private a w;
  private a x;
  private int y;
  private boolean z;

  public b(int paramInt, c paramc, com.google.android.exoplayer2.drm.l<com.google.android.exoplayer2.drm.p> paraml, boolean paramBoolean, float paramFloat)
  {
    super(paramInt);
    if (ag.a >= 16);
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.b(bool);
      this.c = ((c)com.google.android.exoplayer2.g.a.a(paramc));
      this.d = paraml;
      this.e = paramBoolean;
      this.f = paramFloat;
      this.g = new e(0);
      this.h = e.e();
      this.i = new com.google.android.exoplayer2.p();
      this.j = new ac();
      this.k = new ArrayList();
      this.l = new MediaCodec.BufferInfo();
      this.Q = 0;
      this.R = 0;
      this.t = -1.0F;
      this.s = 1.0F;
      return;
    }
  }

  private boolean F()
  {
    return this.M >= 0;
  }

  private void G()
  {
    this.L = -1;
    this.g.b = null;
  }

  private void H()
  {
    this.M = -1;
    this.N = null;
  }

  private boolean I()
    throws i
  {
    if ((this.r == null) || (this.R == 2) || (this.U));
    int i1;
    label332: boolean bool;
    do
    {
      while (true)
      {
        return false;
        if (this.L < 0)
        {
          this.L = this.r.dequeueInputBuffer(0L);
          if (this.L >= 0)
          {
            this.g.b = b(this.L);
            this.g.a();
          }
        }
        else
        {
          if (this.R == 1)
          {
            if (this.H);
            while (true)
            {
              this.R = 2;
              return false;
              this.T = true;
              this.r.queueInputBuffer(this.L, 0, 0, 0L, 4);
              G();
            }
          }
          if (this.F)
          {
            this.F = false;
            this.g.b.put(b);
            this.r.queueInputBuffer(this.L, 0, b.length, 0L, 0);
            G();
            this.S = true;
            return true;
          }
          int i2;
          if (this.W)
          {
            i2 = -4;
            i1 = 0;
          }
          while (i2 != -3)
          {
            if (i2 != -5)
              break label332;
            if (this.Q == 2)
            {
              this.g.a();
              this.Q = 1;
            }
            b(this.i.a);
            return true;
            if (this.Q == 1)
            {
              for (int i3 = 0; i3 < this.m.initializationData.size(); i3++)
              {
                byte[] arrayOfByte = (byte[])this.m.initializationData.get(i3);
                this.g.b.put(arrayOfByte);
              }
              this.Q = 2;
            }
            i1 = this.g.b.position();
            i2 = a(this.i, this.g, false);
          }
          continue;
          if (this.g.c())
          {
            if (this.Q == 2)
            {
              this.g.a();
              this.Q = 1;
            }
            this.U = true;
            if (!this.S)
            {
              N();
              return false;
            }
            try
            {
              if (!this.H)
              {
                this.T = true;
                this.r.queueInputBuffer(this.L, 0, 0, 0L, 4);
                G();
                return false;
              }
            }
            catch (MediaCodec.CryptoException localCryptoException2)
            {
              throw i.a(localCryptoException2, s());
            }
          }
        }
      }
      if ((this.X) && (!this.g.d()))
      {
        this.g.a();
        if (this.Q == 2)
          this.Q = 1;
        return true;
      }
      this.X = false;
      bool = this.g.g();
      this.W = c(bool);
    }
    while (this.W);
    if ((this.A) && (!bool))
    {
      com.google.android.exoplayer2.g.p.a(this.g.b);
      if (this.g.b.position() == 0)
        return true;
      this.A = false;
    }
    try
    {
      long l1 = this.g.c;
      if (this.g.j_())
        this.k.add(Long.valueOf(l1));
      if (this.n != null)
      {
        this.j.a(l1, this.n);
        this.n = null;
      }
      this.g.h();
      a(this.g);
      if (bool)
      {
        MediaCodec.CryptoInfo localCryptoInfo = a(this.g, i1);
        this.r.queueSecureInputBuffer(this.L, 0, localCryptoInfo, l1, 0);
      }
      while (true)
      {
        G();
        this.S = true;
        this.Q = 0;
        d locald = this.a;
        locald.c = (1 + locald.c);
        return true;
        this.r.queueInputBuffer(this.L, 0, this.g.b.limit(), l1, 0);
      }
    }
    catch (MediaCodec.CryptoException localCryptoException1)
    {
      throw i.a(localCryptoException1, s());
    }
  }

  private void J()
    throws i
  {
    if ((this.m == null) || (ag.a < 23));
    float f1;
    do
    {
      do
      {
        do
        {
          return;
          f1 = a(this.s, this.m, q());
        }
        while (this.t == f1);
        this.t = f1;
      }
      while ((this.r == null) || (this.R != 0));
      if ((f1 == -1.0F) && (this.u))
      {
        K();
        return;
      }
    }
    while ((f1 == -1.0F) || ((!this.u) && (f1 <= this.f)));
    Bundle localBundle = new Bundle();
    localBundle.putFloat("operating-rate", f1);
    this.r.setParameters(localBundle);
    this.u = true;
  }

  private void K()
    throws i
  {
    this.v = null;
    if (this.S)
    {
      this.R = 1;
      return;
    }
    C();
    y();
  }

  private void L()
    throws i
  {
    MediaFormat localMediaFormat = this.r.getOutputFormat();
    if ((this.y != 0) && (localMediaFormat.getInteger("width") == 32) && (localMediaFormat.getInteger("height") == 32))
    {
      this.G = true;
      return;
    }
    if (this.E)
      localMediaFormat.setInteger("channel-count", 1);
    a(this.r, localMediaFormat);
  }

  private void M()
  {
    if (ag.a < 21)
      this.J = this.r.getOutputBuffers();
  }

  private void N()
    throws i
  {
    if (this.R == 2)
    {
      C();
      y();
      return;
    }
    this.V = true;
    x();
  }

  private boolean O()
  {
    return ("Amazon".equals(ag.c)) && (("AFTM".equals(ag.d)) || ("AFTB".equals(ag.d)));
  }

  private static MediaCodec.CryptoInfo a(e parame, int paramInt)
  {
    MediaCodec.CryptoInfo localCryptoInfo = parame.a.a();
    if (paramInt == 0)
      return localCryptoInfo;
    if (localCryptoInfo.numBytesOfClearData == null)
      localCryptoInfo.numBytesOfClearData = new int[1];
    int[] arrayOfInt = localCryptoInfo.numBytesOfClearData;
    arrayOfInt[0] = (paramInt + arrayOfInt[0]);
    return localCryptoInfo;
  }

  private void a(MediaCodec paramMediaCodec)
  {
    if (ag.a < 21)
    {
      this.I = paramMediaCodec.getInputBuffers();
      this.J = paramMediaCodec.getOutputBuffers();
    }
  }

  private void a(a parama, MediaCrypto paramMediaCrypto)
    throws Exception
  {
    MediaCodec localMediaCodec = null;
    String str = parama.a;
    J();
    boolean bool;
    if (this.t > this.f)
      bool = true;
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      ae.a("createCodec:" + str);
      localMediaCodec = MediaCodec.createByCodecName(str);
      ae.a();
      ae.a("configureCodec");
      Format localFormat = this.m;
      if (bool);
      for (float f1 = this.t; ; f1 = -1.0F)
      {
        a(parama, localMediaCodec, localFormat, paramMediaCrypto, f1);
        this.u = bool;
        ae.a();
        ae.a("startCodec");
        localMediaCodec.start();
        ae.a();
        long l2 = SystemClock.elapsedRealtime();
        a(localMediaCodec);
        this.r = localMediaCodec;
        this.x = parama;
        a(str, l2, l2 - l1);
        return;
        bool = false;
        break;
      }
    }
    catch (Exception localException)
    {
      if (localMediaCodec != null)
      {
        w();
        localMediaCodec.release();
      }
      throw localException;
    }
  }

  private boolean a(MediaCrypto paramMediaCrypto, boolean paramBoolean)
    throws b.a
  {
    if (this.v == null);
    try
    {
      this.v = new ArrayDeque(b(paramBoolean));
      this.w = null;
      if (this.v.isEmpty())
        throw new a(this.m, null, paramBoolean, -49999);
    }
    catch (d.b localb)
    {
      throw new a(this.m, localb, paramBoolean, -49998);
    }
    while (true)
    {
      a locala = (a)this.v.peekFirst();
      if (!a(locala))
        return false;
      a locala1;
      try
      {
        a(locala, paramMediaCrypto);
        return true;
      }
      catch (Exception localException)
      {
        com.google.android.exoplayer2.g.l.a("MediaCodecRenderer", "Failed to initialize decoder: " + locala, localException);
        this.v.removeFirst();
        locala1 = new a(this.m, localException, paramBoolean, locala.a);
        if (this.w != null);
      }
      for (this.w = locala1; this.v.isEmpty(); this.w = a.a(this.w, locala1))
        throw this.w;
    }
  }

  private static boolean a(String paramString)
  {
    return (ag.a < 18) || ((ag.a == 18) && (("OMX.SEC.avc.dec".equals(paramString)) || ("OMX.SEC.avc.dec.secure".equals(paramString)))) || ((ag.a == 19) && (ag.d.startsWith("SM-G800")) && (("OMX.Exynos.avc.dec".equals(paramString)) || ("OMX.Exynos.avc.dec.secure".equals(paramString))));
  }

  private static boolean a(String paramString, Format paramFormat)
  {
    return (ag.a < 21) && (paramFormat.initializationData.isEmpty()) && ("OMX.MTK.VIDEO.DECODER.AVC".equals(paramString));
  }

  private int b(String paramString)
  {
    if ((ag.a <= 25) && ("OMX.Exynos.avc.dec.secure".equals(paramString)) && ((ag.d.startsWith("SM-T585")) || (ag.d.startsWith("SM-A510")) || (ag.d.startsWith("SM-A520")) || (ag.d.startsWith("SM-J700"))))
      return 2;
    if ((ag.a < 24) && (("OMX.Nvidia.h264.decode".equals(paramString)) || ("OMX.Nvidia.h264.decode.secure".equals(paramString))) && (("flounder".equals(ag.b)) || ("flounder_lte".equals(ag.b)) || ("grouper".equals(ag.b)) || ("tilapia".equals(ag.b))))
      return 1;
    return 0;
  }

  private ByteBuffer b(int paramInt)
  {
    if (ag.a >= 21)
      return this.r.getInputBuffer(paramInt);
    return this.I[paramInt];
  }

  private List<a> b(boolean paramBoolean)
    throws d.b
  {
    List localList = a(this.c, this.m, paramBoolean);
    if ((localList.isEmpty()) && (paramBoolean))
    {
      localList = a(this.c, this.m, false);
      if (!localList.isEmpty())
        com.google.android.exoplayer2.g.l.c("MediaCodecRenderer", "Drm session requires secure decoder for " + this.m.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + localList + ".");
    }
    return localList;
  }

  private boolean b(long paramLong1, long paramLong2)
    throws i
  {
    if (!F())
    {
      if ((this.D) && (this.T));
      int i2;
      while (true)
      {
        try
        {
          int i3 = this.r.dequeueOutputBuffer(this.l, E());
          i2 = i3;
          if (i2 >= 0)
            break label140;
          if (i2 != -2)
            break;
          L();
          return true;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          N();
          if (this.V)
            C();
          return false;
        }
        i2 = this.r.dequeueOutputBuffer(this.l, E());
      }
      if (i2 == -3)
      {
        M();
        return true;
      }
      if ((this.H) && ((this.U) || (this.R == 2)))
        N();
      return false;
      label140: if (this.G)
      {
        this.G = false;
        this.r.releaseOutputBuffer(i2, false);
        return true;
      }
      if ((this.l.size == 0) && ((0x4 & this.l.flags) != 0))
      {
        N();
        return false;
      }
      this.M = i2;
      this.N = c(i2);
      if (this.N != null)
      {
        this.N.position(this.l.offset);
        this.N.limit(this.l.offset + this.l.size);
      }
      this.O = e(this.l.presentationTimeUs);
      d(this.l.presentationTimeUs);
    }
    if ((this.D) && (this.T));
    while (true)
    {
      try
      {
        boolean bool2 = a(paramLong1, paramLong2, this.r, this.N, this.M, this.l.flags, this.l.presentationTimeUs, this.O, this.o);
        bool1 = bool2;
        if (!bool1)
          break label456;
        c(this.l.presentationTimeUs);
        if ((0x4 & this.l.flags) == 0)
          break label446;
        i1 = 1;
        H();
        if (i1 != 0)
          break;
        return true;
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        N();
        if (this.V)
          C();
        return false;
      }
      boolean bool1 = a(paramLong1, paramLong2, this.r, this.N, this.M, this.l.flags, this.l.presentationTimeUs, this.O, this.o);
      continue;
      label446: int i1 = 0;
    }
    N();
    label456: return false;
  }

  private static boolean b(a parama)
  {
    String str = parama.a;
    return ((ag.a <= 17) && (("OMX.rk.video_decoder.avc".equals(str)) || ("OMX.allwinner.video.decoder.avc".equals(str)))) || (("Amazon".equals(ag.c)) && ("AFTS".equals(ag.d)) && (parama.f));
  }

  private static boolean b(String paramString, Format paramFormat)
  {
    return (ag.a <= 18) && (paramFormat.channelCount == 1) && ("OMX.MTK.AUDIO.DECODER.MP3".equals(paramString));
  }

  private ByteBuffer c(int paramInt)
  {
    if (ag.a >= 21)
      return this.r.getOutputBuffer(paramInt);
    return this.J[paramInt];
  }

  private static boolean c(String paramString)
  {
    return (ag.d.startsWith("SM-T230")) && ("OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(paramString));
  }

  private boolean c(boolean paramBoolean)
    throws i
  {
    int i1 = 1;
    if ((this.p == null) || ((!paramBoolean) && (this.e)))
      i1 = 0;
    int i2;
    do
    {
      return i1;
      i2 = this.p.e();
      if (i2 == i1)
        throw i.a(this.p.f(), s());
    }
    while (i2 != 4);
    return false;
  }

  private static boolean d(String paramString)
  {
    return ((ag.a <= 23) && ("OMX.google.vorbis.decoder".equals(paramString))) || ((ag.a <= 19) && (("hb2000".equals(ag.b)) || ("stvm8".equals(ag.b))) && (("OMX.amlogic.avc.decoder.awesome".equals(paramString)) || ("OMX.amlogic.avc.decoder.awesome.secure".equals(paramString))));
  }

  private boolean e(long paramLong)
  {
    int i1 = this.k.size();
    for (int i2 = 0; i2 < i1; i2++)
      if (((Long)this.k.get(i2)).longValue() == paramLong)
      {
        this.k.remove(i2);
        return true;
      }
    return false;
  }

  private static boolean e(String paramString)
  {
    return (ag.a == 21) && ("OMX.google.aac.decoder".equals(paramString));
  }

  private void w()
  {
    if (ag.a < 21)
    {
      this.I = null;
      this.J = null;
    }
  }

  protected final MediaCodec A()
  {
    return this.r;
  }

  protected final a B()
  {
    return this.x;
  }

  protected void C()
  {
    this.K = -9223372036854775807L;
    G();
    H();
    this.W = false;
    this.O = false;
    this.k.clear();
    w();
    this.x = null;
    this.P = false;
    this.S = false;
    this.A = false;
    this.B = false;
    this.y = 0;
    this.z = false;
    this.C = false;
    this.E = false;
    this.F = false;
    this.G = false;
    this.H = false;
    this.T = false;
    this.Q = 0;
    this.R = 0;
    this.u = false;
    if (this.r != null)
    {
      d locald = this.a;
      locald.b = (1 + locald.b);
    }
    try
    {
      this.r.stop();
      try
      {
        this.r.release();
        this.r = null;
        if ((this.p != null) && (this.q != this.p));
        try
        {
          this.d.a(this.p);
          return;
        }
        finally
        {
          this.p = null;
        }
      }
      finally
      {
        this.r = null;
        if ((this.p == null) || (this.q == this.p));
      }
    }
    finally
    {
    }
  }

  protected void D()
    throws i
  {
    this.K = -9223372036854775807L;
    G();
    H();
    this.X = true;
    this.W = false;
    this.O = false;
    this.k.clear();
    this.F = false;
    this.G = false;
    if ((this.B) || ((this.C) && (this.T)))
    {
      C();
      y();
    }
    while (true)
    {
      if ((this.P) && (this.m != null))
        this.Q = 1;
      return;
      if (this.R != 0)
      {
        C();
        y();
      }
      else
      {
        this.r.flush();
        this.S = false;
      }
    }
  }

  protected long E()
  {
    return 0L;
  }

  protected float a(float paramFloat, Format paramFormat, Format[] paramArrayOfFormat)
  {
    return -1.0F;
  }

  protected int a(MediaCodec paramMediaCodec, a parama, Format paramFormat1, Format paramFormat2)
  {
    return 0;
  }

  public final int a(Format paramFormat)
    throws i
  {
    try
    {
      int i1 = a(this.c, this.d, paramFormat);
      return i1;
    }
    catch (d.b localb)
    {
      throw i.a(localb, s());
    }
  }

  protected abstract int a(c paramc, com.google.android.exoplayer2.drm.l<com.google.android.exoplayer2.drm.p> paraml, Format paramFormat)
    throws d.b;

  protected List<a> a(c paramc, Format paramFormat, boolean paramBoolean)
    throws d.b
  {
    return paramc.a(paramFormat.sampleMimeType, paramBoolean);
  }

  public final void a(float paramFloat)
    throws i
  {
    this.s = paramFloat;
    J();
  }

  public void a(long paramLong1, long paramLong2)
    throws i
  {
    if (this.V)
    {
      x();
      return;
    }
    int i2;
    if (this.m == null)
    {
      this.h.a();
      i2 = a(this.i, this.h, true);
      if (i2 == -5)
        b(this.i.a);
    }
    else
    {
      y();
      if (this.r == null)
        break label130;
      ae.a("drainAndFeed");
      while (b(paramLong1, paramLong2));
      while (I());
      ae.a();
    }
    while (true)
    {
      this.a.a();
      return;
      if (i2 != -4)
        break;
      com.google.android.exoplayer2.g.a.b(this.h.c());
      this.U = true;
      N();
      return;
      label130: d locald = this.a;
      locald.d += b(paramLong1);
      this.h.a();
      int i1 = a(this.i, this.h, false);
      if (i1 == -5)
      {
        b(this.i.a);
      }
      else if (i1 == -4)
      {
        com.google.android.exoplayer2.g.a.b(this.h.c());
        this.U = true;
        N();
      }
    }
  }

  protected void a(long paramLong, boolean paramBoolean)
    throws i
  {
    this.U = false;
    this.V = false;
    if (this.r != null)
      D();
    this.j.a();
  }

  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    throws i
  {
  }

  protected void a(e parame)
  {
  }

  protected abstract void a(a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto, float paramFloat)
    throws d.b;

  protected void a(String paramString, long paramLong1, long paramLong2)
  {
  }

  protected void a(boolean paramBoolean)
    throws i
  {
    this.a = new d();
  }

  protected abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean, Format paramFormat)
    throws i;

  protected boolean a(a parama)
  {
    return true;
  }

  protected void b(Format paramFormat)
    throws i
  {
    Format localFormat = this.m;
    this.m = paramFormat;
    this.n = paramFormat;
    DrmInitData localDrmInitData = this.m.drmInitData;
    Object localObject;
    int i1;
    if (localFormat == null)
    {
      localObject = null;
      if (ag.a(localDrmInitData, localObject))
        break label91;
      i1 = 1;
    }
    while (true)
      if (i1 != 0)
      {
        if (this.m.drmInitData == null)
          break label244;
        if (this.d == null)
        {
          throw i.a(new IllegalStateException("Media requires a DrmSessionManager"), s());
          localObject = localFormat.drmInitData;
          break;
          label91: i1 = 0;
          continue;
        }
        this.q = this.d.a(Looper.myLooper(), this.m.drmInitData);
        if (this.q == this.p)
          this.d.a(this.q);
      }
    while (true)
    {
      k localk1 = this.q;
      k localk2 = this.p;
      i2 = 0;
      if (localk1 != localk2)
        break;
      MediaCodec localMediaCodec = this.r;
      i2 = 0;
      if (localMediaCodec == null)
        break;
      int i3 = a(this.r, this.x, localFormat, this.m);
      i2 = 0;
      switch (i3)
      {
      case 2:
      default:
        throw new IllegalStateException();
        label244: this.q = null;
      case 1:
      case 0:
      case 3:
      }
    }
    int i2 = 1;
    while (i2 == 0)
    {
      K();
      return;
      boolean bool1 = this.z;
      i2 = 0;
      if (!bool1)
      {
        this.P = true;
        this.Q = 1;
        if ((this.y == 2) || ((this.y == 1) && (this.m.width == localFormat.width) && (this.m.height == localFormat.height)));
        for (boolean bool2 = true; ; bool2 = false)
        {
          this.F = bool2;
          i2 = 1;
          break;
        }
      }
    }
    J();
  }

  protected void c(long paramLong)
  {
  }

  protected final Format d(long paramLong)
  {
    Format localFormat = (Format)this.j.a(paramLong);
    if (localFormat != null)
      this.o = localFormat;
    return localFormat;
  }

  public final int m()
  {
    return 8;
  }

  protected void n()
  {
  }

  protected void o()
  {
  }

  protected void p()
  {
    this.m = null;
    this.v = null;
    try
    {
      C();
      try
      {
        if (this.p != null)
          this.d.a(this.p);
        try
        {
          if ((this.q != null) && (this.q != this.p))
            this.d.a(this.q);
          return;
        }
        finally
        {
          this.p = null;
          this.q = null;
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

  public boolean u()
  {
    return (this.m != null) && (!this.W) && ((t()) || (F()) || ((this.K != -9223372036854775807L) && (SystemClock.elapsedRealtime() < this.K)));
  }

  public boolean v()
  {
    return this.V;
  }

  protected void x()
    throws i
  {
  }

  protected final void y()
    throws i
  {
    if ((this.r != null) || (this.m == null));
    MediaCrypto localMediaCrypto;
    boolean bool1;
    int i1;
    do
    {
      String str1;
      com.google.android.exoplayer2.drm.p localp;
      do
      {
        return;
        this.p = this.q;
        str1 = this.m.sampleMimeType;
        localMediaCrypto = null;
        if (this.p == null)
          break label338;
        localp = (com.google.android.exoplayer2.drm.p)this.p.g();
        if (localp != null)
          break;
      }
      while (this.p.f() == null);
      for (bool1 = false; ; bool1 = localp.a(str1))
      {
        if (!O())
          break label136;
        i1 = this.p.e();
        if (i1 != 1)
          break;
        throw i.a(this.p.f(), s());
        localMediaCrypto = localp.a();
      }
    }
    while (i1 != 4);
    while (true)
    {
      try
      {
        label136: boolean bool2 = a(localMediaCrypto, bool1);
        if (!bool2)
          break;
        String str2 = this.x.a;
        this.y = b(str2);
        this.z = c(str2);
        this.A = a(str2, this.m);
        this.B = a(str2);
        this.C = d(str2);
        this.D = e(str2);
        this.E = b(str2, this.m);
        boolean bool3;
        if (!b(this.x))
        {
          boolean bool4 = z();
          bool3 = false;
          if (!bool4);
        }
        else
        {
          bool3 = true;
        }
        this.H = bool3;
        if (g_() == 2)
        {
          l1 = 1000L + SystemClock.elapsedRealtime();
          this.K = l1;
          G();
          H();
          this.X = true;
          d locald = this.a;
          locald.a = (1 + locald.a);
          return;
        }
      }
      catch (a locala)
      {
        throw i.a(locala, s());
      }
      long l1 = -9223372036854775807L;
      continue;
      label338: bool1 = false;
      localMediaCrypto = null;
    }
  }

  protected boolean z()
  {
    return false;
  }

  public static class a extends Exception
  {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final a e;

    public a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
    {
      this("Decoder init failed: [" + paramInt + "], " + paramFormat, paramThrowable, paramFormat.sampleMimeType, paramBoolean, null, a(paramInt), null);
    }

    public a(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
    {
    }

    private a(String paramString1, Throwable paramThrowable, String paramString2, boolean paramBoolean, String paramString3, String paramString4, a parama)
    {
      super(paramThrowable);
      this.a = paramString2;
      this.b = paramBoolean;
      this.c = paramString3;
      this.d = paramString4;
      this.e = parama;
    }

    private a a(a parama)
    {
      return new a(getMessage(), getCause(), this.a, this.b, this.c, this.d, parama);
    }

    private static String a(int paramInt)
    {
      if (paramInt < 0);
      for (String str = "neg_"; ; str = "")
        return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(paramInt);
    }

    @TargetApi(21)
    private static String a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof MediaCodec.CodecException))
        return ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.d.b
 * JD-Core Version:    0.6.2
 */