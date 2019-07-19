package com.google.android.exoplayer2.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.d.a;
import com.google.android.exoplayer2.d.d.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.y;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

@TargetApi(16)
public class v extends com.google.android.exoplayer2.d.b
  implements com.google.android.exoplayer2.g.n
{
  private final Context b;
  private final g.a c;
  private final n d;
  private final long[] e;
  private int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private MediaFormat j;
  private int k;
  private int l;
  private int m;
  private int n;
  private long o;
  private boolean p;
  private boolean q;
  private long r;
  private int s;

  public v(Context paramContext, com.google.android.exoplayer2.d.c paramc, com.google.android.exoplayer2.drm.l<p> paraml, boolean paramBoolean, Handler paramHandler, g paramg, c paramc1, f[] paramArrayOff)
  {
    this(paramContext, paramc, paraml, paramBoolean, paramHandler, paramg, new s(paramc1, paramArrayOff));
  }

  public v(Context paramContext, com.google.android.exoplayer2.d.c paramc, com.google.android.exoplayer2.drm.l<p> paraml, boolean paramBoolean, Handler paramHandler, g paramg, n paramn)
  {
    super(1, paramc, paraml, paramBoolean, 44100.0F);
    this.b = paramContext.getApplicationContext();
    this.d = paramn;
    this.r = -9223372036854775807L;
    this.e = new long[10];
    this.c = new g.a(paramHandler, paramg);
    paramn.a(new a(null));
  }

  private void F()
  {
    long l1 = this.d.a(v());
    if (l1 != -9223372036854775808L)
      if (!this.q)
        break label40;
    while (true)
    {
      this.o = l1;
      this.q = false;
      return;
      label40: l1 = Math.max(this.o, l1);
    }
  }

  private int a(a parama, Format paramFormat)
  {
    if ((com.google.android.exoplayer2.g.ag.a < 24) && ("OMX.google.raw.decoder".equals(parama.a)))
    {
      int i1 = 1;
      if (com.google.android.exoplayer2.g.ag.a == 23)
      {
        PackageManager localPackageManager = this.b.getPackageManager();
        if ((localPackageManager != null) && (localPackageManager.hasSystemFeature("android.software.leanback")))
          i1 = 0;
      }
      if (i1 != 0)
        return -1;
    }
    return paramFormat.maxInputSize;
  }

  private static boolean a(String paramString)
  {
    return (com.google.android.exoplayer2.g.ag.a < 24) && ("OMX.SEC.aac.dec".equals(paramString)) && ("samsung".equals(com.google.android.exoplayer2.g.ag.c)) && ((com.google.android.exoplayer2.g.ag.b.startsWith("zeroflte")) || (com.google.android.exoplayer2.g.ag.b.startsWith("herolte")) || (com.google.android.exoplayer2.g.ag.b.startsWith("heroqlte")));
  }

  private static boolean b(String paramString)
  {
    return (com.google.android.exoplayer2.g.ag.a < 21) && ("OMX.SEC.mp3.dec".equals(paramString)) && ("samsung".equals(com.google.android.exoplayer2.g.ag.c)) && ((com.google.android.exoplayer2.g.ag.b.startsWith("baffin")) || (com.google.android.exoplayer2.g.ag.b.startsWith("grand")) || (com.google.android.exoplayer2.g.ag.b.startsWith("fortuna")) || (com.google.android.exoplayer2.g.ag.b.startsWith("gprimelte")) || (com.google.android.exoplayer2.g.ag.b.startsWith("j2y18lte")) || (com.google.android.exoplayer2.g.ag.b.startsWith("ms01")));
  }

  protected float a(float paramFloat, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i1 = paramArrayOfFormat.length;
    int i2 = 0;
    int i3 = -1;
    while (i2 < i1)
    {
      int i4 = paramArrayOfFormat[i2].sampleRate;
      if (i4 != -1)
        i3 = Math.max(i3, i4);
      i2++;
    }
    if (i3 == -1)
      return -1.0F;
    return paramFloat * i3;
  }

  protected int a(MediaCodec paramMediaCodec, a parama, Format paramFormat1, Format paramFormat2)
  {
    if ((a(parama, paramFormat2) <= this.f) && (parama.a(paramFormat1, paramFormat2, true)) && (paramFormat1.encoderDelay == 0) && (paramFormat1.encoderPadding == 0) && (paramFormat2.encoderDelay == 0) && (paramFormat2.encoderPadding == 0))
      return 1;
    return 0;
  }

  protected int a(a parama, Format paramFormat, Format[] paramArrayOfFormat)
  {
    int i1 = a(parama, paramFormat);
    if (paramArrayOfFormat.length == 1);
    while (true)
    {
      return i1;
      int i2 = paramArrayOfFormat.length;
      for (int i3 = 0; i3 < i2; i3++)
      {
        Format localFormat = paramArrayOfFormat[i3];
        if (parama.a(paramFormat, localFormat, false))
          i1 = Math.max(i1, a(parama, localFormat));
      }
    }
  }

  protected int a(com.google.android.exoplayer2.d.c paramc, com.google.android.exoplayer2.drm.l<p> paraml, Format paramFormat)
    throws d.b
  {
    String str = paramFormat.sampleMimeType;
    if (!o.a(str))
      return 0;
    if (com.google.android.exoplayer2.g.ag.a >= 21);
    boolean bool1;
    for (int i1 = 32; ; i1 = 0)
    {
      bool1 = a(paraml, paramFormat.drmInitData);
      if ((!bool1) || (!a(paramFormat.channelCount, str)) || (paramc.a() == null))
        break;
      return 0x4 | (i1 | 0x8);
    }
    if ((("audio/raw".equals(str)) && (!this.d.a(paramFormat.channelCount, paramFormat.pcmEncoding))) || (!this.d.a(paramFormat.channelCount, 2)))
      return 1;
    DrmInitData localDrmInitData = paramFormat.drmInitData;
    if (localDrmInitData != null)
    {
      int i5 = 0;
      bool2 = false;
      while (i5 < localDrmInitData.schemeDataCount)
      {
        bool2 |= localDrmInitData.get(i5).requiresSecureDecryption;
        i5++;
      }
    }
    boolean bool2 = false;
    List localList = paramc.a(paramFormat.sampleMimeType, bool2);
    if (localList.isEmpty())
    {
      if ((bool2) && (!paramc.a(paramFormat.sampleMimeType, false).isEmpty()));
      for (int i4 = 2; ; i4 = 1)
        return i4;
    }
    if (!bool1)
      return 2;
    a locala = (a)localList.get(0);
    boolean bool3 = locala.a(paramFormat);
    int i2;
    if ((bool3) && (locala.b(paramFormat)))
    {
      i2 = 16;
      if (!bool3)
        break label309;
    }
    label309: for (int i3 = 4; ; i3 = 3)
    {
      return i3 | (i1 | i2);
      i2 = 8;
      break;
    }
  }

  @SuppressLint({"InlinedApi"})
  protected MediaFormat a(Format paramFormat, String paramString, int paramInt, float paramFloat)
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", paramString);
    localMediaFormat.setInteger("channel-count", paramFormat.channelCount);
    localMediaFormat.setInteger("sample-rate", paramFormat.sampleRate);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, paramFormat.initializationData);
    com.google.android.exoplayer2.d.e.a(localMediaFormat, "max-input-size", paramInt);
    if (com.google.android.exoplayer2.g.ag.a >= 23)
    {
      localMediaFormat.setInteger("priority", 0);
      if (paramFloat != -1.0F)
        localMediaFormat.setFloat("operating-rate", paramFloat);
    }
    return localMediaFormat;
  }

  public y a(y paramy)
  {
    return this.d.a(paramy);
  }

  protected List<a> a(com.google.android.exoplayer2.d.c paramc, Format paramFormat, boolean paramBoolean)
    throws d.b
  {
    if (a(paramFormat.channelCount, paramFormat.sampleMimeType))
    {
      a locala = paramc.a();
      if (locala != null)
        return Collections.singletonList(locala);
    }
    return super.a(paramc, paramFormat, paramBoolean);
  }

  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
  }

  public void a(int paramInt, Object paramObject)
    throws i
  {
    switch (paramInt)
    {
    case 4:
    default:
      super.a(paramInt, paramObject);
      return;
    case 2:
      this.d.a(((Float)paramObject).floatValue());
      return;
    case 3:
      b localb = (b)paramObject;
      this.d.a(localb);
      return;
    case 5:
    }
    q localq = (q)paramObject;
    this.d.a(localq);
  }

  protected void a(long paramLong, boolean paramBoolean)
    throws i
  {
    super.a(paramLong, paramBoolean);
    this.d.i();
    this.o = paramLong;
    this.p = true;
    this.q = true;
    this.r = -9223372036854775807L;
    this.s = 0;
  }

  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    throws i
  {
    int i1 = 0;
    int i2;
    if (this.j != null)
    {
      i2 = o.h(this.j.getString("mime"));
      paramMediaFormat = this.j;
    }
    int i3;
    int i4;
    while (true)
    {
      i3 = paramMediaFormat.getInteger("channel-count");
      i4 = paramMediaFormat.getInteger("sample-rate");
      if ((!this.h) || (i3 != 6) || (this.l >= 6))
        break;
      arrayOfInt = new int[this.l];
      while (i1 < this.l)
      {
        arrayOfInt[i1] = i1;
        i1++;
      }
      i2 = this.k;
    }
    int[] arrayOfInt = null;
    try
    {
      this.d.a(i2, i3, i4, 0, arrayOfInt, this.m, this.n);
      return;
    }
    catch (n.a locala)
    {
      throw i.a(locala, s());
    }
  }

  protected void a(com.google.android.exoplayer2.c.e parame)
  {
    if ((this.p) && (!parame.j_()))
    {
      if (Math.abs(parame.c - this.o) > 500000L)
        this.o = parame.c;
      this.p = false;
    }
    this.r = Math.max(parame.c, this.r);
  }

  protected void a(a parama, MediaCodec paramMediaCodec, Format paramFormat, MediaCrypto paramMediaCrypto, float paramFloat)
  {
    this.f = a(parama, paramFormat, q());
    this.h = a(parama.a);
    this.i = b(parama.a);
    this.g = parama.g;
    if (parama.b == null);
    for (String str = "audio/raw"; ; str = parama.b)
    {
      MediaFormat localMediaFormat = a(paramFormat, str, this.f, paramFloat);
      paramMediaCodec.configure(localMediaFormat, null, paramMediaCrypto, 0);
      if (!this.g)
        break;
      this.j = localMediaFormat;
      this.j.setString("mime", paramFormat.sampleMimeType);
      return;
    }
    this.j = null;
  }

  protected void a(String paramString, long paramLong1, long paramLong2)
  {
    this.c.a(paramString, paramLong1, paramLong2);
  }

  protected void a(boolean paramBoolean)
    throws i
  {
    super.a(paramBoolean);
    this.c.a(this.a);
    int i1 = r().b;
    if (i1 != 0)
    {
      this.d.a(i1);
      return;
    }
    this.d.g();
  }

  protected void a(Format[] paramArrayOfFormat, long paramLong)
    throws i
  {
    super.a(paramArrayOfFormat, paramLong);
    if (this.r != -9223372036854775807L)
    {
      if (this.s != this.e.length)
        break label81;
      com.google.android.exoplayer2.g.l.c("MediaCodecAudioRenderer", "Too many stream changes, so dropping change at " + this.e[(-1 + this.s)]);
    }
    while (true)
    {
      this.e[(-1 + this.s)] = this.r;
      return;
      label81: this.s = (1 + this.s);
    }
  }

  protected boolean a(int paramInt, String paramString)
  {
    return this.d.a(paramInt, o.h(paramString));
  }

  protected boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean, Format paramFormat)
    throws i
  {
    if ((this.i) && (paramLong3 == 0L) && ((paramInt2 & 0x4) != 0) && (this.r != -9223372036854775807L))
      paramLong3 = this.r;
    if ((this.g) && ((paramInt2 & 0x2) != 0))
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      return true;
    }
    if (paramBoolean)
    {
      paramMediaCodec.releaseOutputBuffer(paramInt1, false);
      d locald2 = this.a;
      locald2.f = (1 + locald2.f);
      this.d.b();
      return true;
    }
    try
    {
      if (this.d.a(paramByteBuffer, paramLong3))
      {
        paramMediaCodec.releaseOutputBuffer(paramInt1, false);
        d locald1 = this.a;
        locald1.e = (1 + locald1.e);
        return true;
      }
    }
    catch (n.b localb)
    {
      throw i.a(localb, s());
      return false;
    }
    catch (n.d locald)
    {
      label150: break label150;
    }
  }

  protected void b(int paramInt)
  {
  }

  protected void b(Format paramFormat)
    throws i
  {
    super.b(paramFormat);
    this.c.a(paramFormat);
    if ("audio/raw".equals(paramFormat.sampleMimeType));
    for (int i1 = paramFormat.pcmEncoding; ; i1 = 2)
    {
      this.k = i1;
      this.l = paramFormat.channelCount;
      this.m = paramFormat.encoderDelay;
      this.n = paramFormat.encoderPadding;
      return;
    }
  }

  public com.google.android.exoplayer2.g.n c()
  {
    return this;
  }

  protected void c(long paramLong)
  {
    while ((this.s != 0) && (paramLong >= this.e[0]))
    {
      this.d.b();
      this.s = (-1 + this.s);
      System.arraycopy(this.e, 1, this.e, 0, this.s);
    }
  }

  public long d()
  {
    if (g_() == 2)
      F();
    return this.o;
  }

  public y e()
  {
    return this.d.f();
  }

  protected void n()
  {
    super.n();
    this.d.a();
  }

  protected void o()
  {
    F();
    this.d.h();
    super.o();
  }

  protected void p()
  {
    try
    {
      this.r = -9223372036854775807L;
      this.s = 0;
      this.d.j();
      try
      {
        super.p();
        return;
      }
      finally
      {
        this.a.a();
        this.c.b(this.a);
      }
    }
    finally
    {
    }
  }

  public boolean u()
  {
    return (this.d.e()) || (super.u());
  }

  public boolean v()
  {
    return (super.v()) && (this.d.d());
  }

  protected void w()
  {
  }

  protected void x()
    throws i
  {
    try
    {
      this.d.c();
      return;
    }
    catch (n.d locald)
    {
      throw i.a(locald, s());
    }
  }

  private final class a
    implements n.c
  {
    private a()
    {
    }

    public void a()
    {
      v.this.w();
      v.a(v.this, true);
    }

    public void a(int paramInt)
    {
      v.a(v.this).a(paramInt);
      v.this.b(paramInt);
    }

    public void a(int paramInt, long paramLong1, long paramLong2)
    {
      v.a(v.this).a(paramInt, paramLong1, paramLong2);
      v.this.a(paramInt, paramLong1, paramLong2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.v
 * JD-Core Version:    0.6.2
 */