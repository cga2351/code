package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class s
  implements n
{
  public static boolean a = false;
  public static boolean b = false;
  private y A;
  private long B;
  private long C;
  private ByteBuffer D;
  private int E;
  private int F;
  private long G;
  private long H;
  private int I;
  private long J;
  private long K;
  private int L;
  private int M;
  private long N;
  private float O;
  private f[] P;
  private ByteBuffer[] Q;
  private ByteBuffer R;
  private ByteBuffer S;
  private byte[] T;
  private int U;
  private int V;
  private boolean W;
  private boolean X;
  private int Y;
  private q Z;
  private boolean aa;
  private long ab;
  private final c c;
  private final a d;
  private final boolean e;
  private final r f;
  private final aa g;
  private final f[] h;
  private final f[] i;
  private final ConditionVariable j;
  private final p k;
  private final ArrayDeque<d> l;
  private n.c m;
  private AudioTrack n;
  private AudioTrack o;
  private boolean p;
  private boolean q;
  private int r;
  private int s;
  private int t;
  private int u;
  private b v;
  private boolean w;
  private boolean x;
  private int y;
  private y z;

  public s(c paramc, a parama, boolean paramBoolean)
  {
    this.c = paramc;
    this.d = ((a)com.google.android.exoplayer2.g.a.a(parama));
    this.e = paramBoolean;
    this.j = new ConditionVariable(true);
    this.k = new p(new e(null));
    this.f = new r();
    this.g = new aa();
    ArrayList localArrayList = new ArrayList();
    f[] arrayOff1 = new f[3];
    arrayOff1[0] = new w();
    arrayOff1[1] = this.f;
    arrayOff1[2] = this.g;
    Collections.addAll(localArrayList, arrayOff1);
    Collections.addAll(localArrayList, parama.a());
    this.h = ((f[])localArrayList.toArray(new f[localArrayList.size()]));
    f[] arrayOff2 = new f[1];
    arrayOff2[0] = new u();
    this.i = arrayOff2;
    this.O = 1.0F;
    this.M = 0;
    this.v = b.a;
    this.Y = 0;
    this.Z = new q(0, 0.0F);
    this.A = y.a;
    this.V = -1;
    this.P = new f[0];
    this.Q = new ByteBuffer[0];
    this.l = new ArrayDeque();
  }

  public s(c paramc, f[] paramArrayOff)
  {
    this(paramc, paramArrayOff, false);
  }

  public s(c paramc, f[] paramArrayOff, boolean paramBoolean)
  {
    this(paramc, new b(paramArrayOff), paramBoolean);
  }

  private static int a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt == 7) || (paramInt == 8))
      return t.a(paramByteBuffer);
    if (paramInt == 5)
      return a.a();
    if (paramInt == 6)
      return a.a(paramByteBuffer);
    if (paramInt == 14)
    {
      int i1 = a.b(paramByteBuffer);
      if (i1 == -1)
        return 0;
      return 16 * a.a(paramByteBuffer, i1);
    }
    throw new IllegalStateException("Unexpected audio encoding: " + paramInt);
  }

  private static int a(int paramInt, boolean paramBoolean)
  {
    if ((ag.a <= 28) && (!paramBoolean))
      if (paramInt != 7)
        break label56;
    for (paramInt = 8; ; paramInt = 6)
      label56: 
      do
      {
        if ((ag.a <= 26) && ("fugu".equals(ag.b)) && (!paramBoolean) && (paramInt == 1))
          paramInt = 2;
        return ag.e(paramInt);
      }
      while ((paramInt != 3) && (paramInt != 4) && (paramInt != 5));
  }

  @TargetApi(21)
  private static int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramAudioTrack.write(paramByteBuffer, paramInt, 1);
  }

  @TargetApi(21)
  private int a(AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    if (this.D == null)
    {
      this.D = ByteBuffer.allocate(16);
      this.D.order(ByteOrder.BIG_ENDIAN);
      this.D.putInt(1431633921);
    }
    if (this.E == 0)
    {
      this.D.putInt(4, paramInt);
      this.D.putLong(8, 1000L * paramLong);
      this.D.position(0);
      this.E = paramInt;
    }
    int i1 = this.D.remaining();
    if (i1 > 0)
    {
      int i3 = paramAudioTrack.write(this.D, i1, 1);
      if (i3 < 0)
      {
        this.E = 0;
        return i3;
      }
      if (i3 < i1)
        return 0;
    }
    int i2 = a(paramAudioTrack, paramByteBuffer, paramInt);
    if (i2 < 0)
    {
      this.E = 0;
      return i2;
    }
    this.E -= i2;
    return i2;
  }

  private void a(long paramLong)
    throws n.d
  {
    int i1 = this.P.length;
    int i2 = i1;
    while (true)
    {
      ByteBuffer localByteBuffer1;
      if (i2 >= 0)
      {
        if (i2 <= 0)
          break label52;
        localByteBuffer1 = this.Q[(i2 - 1)];
        label30: if (i2 != i1)
          break label76;
        b(localByteBuffer1, paramLong);
      }
      while (true)
        if (localByteBuffer1.hasRemaining())
        {
          return;
          label52: if (this.R != null)
          {
            localByteBuffer1 = this.R;
            break label30;
          }
          localByteBuffer1 = f.a;
          break label30;
          label76: f localf = this.P[i2];
          localf.a(localByteBuffer1);
          ByteBuffer localByteBuffer2 = localf.f();
          this.Q[i2] = localByteBuffer2;
          if (localByteBuffer2.hasRemaining())
          {
            i2++;
            break;
          }
        }
      i2--;
    }
  }

  @TargetApi(21)
  private static void a(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setVolume(paramFloat);
  }

  private long b(long paramLong)
  {
    for (d locald = null; (!this.l.isEmpty()) && (paramLong >= d.b((d)this.l.getFirst())); locald = (d)this.l.remove());
    if (locald != null)
    {
      this.A = d.a(locald);
      this.C = d.b(locald);
      this.B = (d.c(locald) - this.N);
    }
    if (this.A.b == 1.0F)
      return paramLong + this.B - this.C;
    if (this.l.isEmpty())
      return this.B + this.d.a(paramLong - this.C);
    return this.B + ag.a(paramLong - this.C, this.A.b);
  }

  private AudioTrack b(int paramInt)
  {
    return new AudioTrack(3, 4000, 4, 2, 2, 0, paramInt);
  }

  private static void b(AudioTrack paramAudioTrack, float paramFloat)
  {
    paramAudioTrack.setStereoVolume(paramFloat, paramFloat);
  }

  private void b(ByteBuffer paramByteBuffer, long paramLong)
    throws n.d
  {
    boolean bool1 = true;
    if (!paramByteBuffer.hasRemaining());
    label35: int i3;
    int i4;
    label231: 
    do
    {
      return;
      boolean bool2;
      if (this.S != null)
        if (this.S == paramByteBuffer)
        {
          bool2 = bool1;
          com.google.android.exoplayer2.g.a.a(bool2);
          i3 = paramByteBuffer.remaining();
          if (ag.a >= 21)
            break label231;
          int i5 = this.k.b(this.J);
          i4 = 0;
          if (i5 > 0)
          {
            int i6 = Math.min(i3, i5);
            i4 = this.o.write(this.T, this.U, i6);
            if (i4 > 0)
            {
              this.U = (i4 + this.U);
              paramByteBuffer.position(i4 + paramByteBuffer.position());
            }
          }
        }
      while (true)
      {
        this.ab = SystemClock.elapsedRealtime();
        if (i4 >= 0)
          break label289;
        throw new n.d(i4);
        bool2 = false;
        break;
        this.S = paramByteBuffer;
        if (ag.a >= 21)
          break label35;
        int i1 = paramByteBuffer.remaining();
        if ((this.T == null) || (this.T.length < i1))
          this.T = new byte[i1];
        int i2 = paramByteBuffer.position();
        paramByteBuffer.get(this.T, 0, i1);
        paramByteBuffer.position(i2);
        this.U = 0;
        break label35;
        if (this.aa)
        {
          if (paramLong != -9223372036854775807L);
          while (true)
          {
            com.google.android.exoplayer2.g.a.b(bool1);
            i4 = a(this.o, paramByteBuffer, i3, paramLong);
            break;
            bool1 = false;
          }
        }
        i4 = a(this.o, paramByteBuffer, i3);
      }
      if (this.p)
        this.J += i4;
    }
    while (i4 != i3);
    label289: if (!this.p)
      this.K += this.L;
    this.S = null;
  }

  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    default:
      throw new IllegalArgumentException();
    case 5:
      return 80000;
    case 6:
      return 768000;
    case 7:
      return 192000;
    case 8:
      return 2250000;
    case 14:
    }
    return 3062500;
  }

  private long c(long paramLong)
  {
    return paramLong + e(this.d.b());
  }

  private long d(long paramLong)
  {
    return 1000000L * paramLong / this.r;
  }

  private long e(long paramLong)
  {
    return 1000000L * paramLong / this.s;
  }

  private long f(long paramLong)
  {
    return paramLong * this.s / 1000000L;
  }

  private int k()
  {
    if (this.p)
    {
      int i2 = AudioTrack.getMinBufferSize(this.s, this.t, this.u);
      if (i2 != -2);
      for (boolean bool = true; ; bool = false)
      {
        com.google.android.exoplayer2.g.a.b(bool);
        return ag.a(i2 * 4, (int)f(250000L) * this.I, (int)Math.max(i2, f(750000L) * this.I));
      }
    }
    int i1 = c(this.u);
    if (this.u == 5)
      i1 *= 2;
    return (int)(250000L * i1 / 1000000L);
  }

  private void l()
  {
    ArrayList localArrayList = new ArrayList();
    f[] arrayOff = w();
    int i1 = arrayOff.length;
    int i2 = 0;
    if (i2 < i1)
    {
      f localf = arrayOff[i2];
      if (localf.a())
        localArrayList.add(localf);
      while (true)
      {
        i2++;
        break;
        localf.h();
      }
    }
    int i3 = localArrayList.size();
    this.P = ((f[])localArrayList.toArray(new f[i3]));
    this.Q = new ByteBuffer[i3];
    m();
  }

  private void m()
  {
    for (int i1 = 0; i1 < this.P.length; i1++)
    {
      f localf = this.P[i1];
      localf.h();
      this.Q[i1] = localf.f();
    }
  }

  private void n()
    throws n.b
  {
    this.j.block();
    this.o = u();
    int i1 = this.o.getAudioSessionId();
    if ((a) && (ag.a < 21))
    {
      if ((this.n != null) && (i1 != this.n.getAudioSessionId()))
        q();
      if (this.n == null)
        this.n = b(i1);
    }
    if (this.Y != i1)
    {
      this.Y = i1;
      if (this.m != null)
        this.m.a(i1);
    }
    if (this.x);
    for (y localy = this.d.a(this.A); ; localy = y.a)
    {
      this.A = localy;
      l();
      this.k.a(this.o, this.u, this.I, this.y);
      p();
      if (this.Z.a != 0)
      {
        this.o.attachAuxEffect(this.Z.a);
        this.o.setAuxEffectSendLevel(this.Z.b);
      }
      return;
    }
  }

  private boolean o()
    throws n.d
  {
    int i2;
    int i1;
    if (this.V == -1)
      if (this.w)
      {
        i2 = 0;
        this.V = i2;
        i1 = 1;
      }
    while (true)
    {
      label24: if (this.V < this.P.length)
      {
        f localf = this.P[this.V];
        if (i1 != 0)
          localf.e();
        a(-9223372036854775807L);
        if (localf.g());
      }
      do
      {
        return false;
        i2 = this.P.length;
        break;
        this.V = (1 + this.V);
        i1 = 1;
        break label24;
        if (this.S == null)
          break label123;
        b(this.S, -9223372036854775807L);
      }
      while (this.S != null);
      label123: this.V = -1;
      return true;
      i1 = 0;
    }
  }

  private void p()
  {
    if (!r())
      return;
    if (ag.a >= 21)
    {
      a(this.o, this.O);
      return;
    }
    b(this.o, this.O);
  }

  private void q()
  {
    if (this.n == null)
      return;
    final AudioTrack localAudioTrack = this.n;
    this.n = null;
    new Thread()
    {
      public void run()
      {
        localAudioTrack.release();
      }
    }
    .start();
  }

  private boolean r()
  {
    return this.o != null;
  }

  private long s()
  {
    if (this.p)
      return this.G / this.F;
    return this.H;
  }

  private long t()
  {
    if (this.p)
      return this.J / this.I;
    return this.K;
  }

  private AudioTrack u()
    throws n.b
  {
    AudioTrack localAudioTrack;
    if (ag.a >= 21)
      localAudioTrack = v();
    while (true)
    {
      int i2 = localAudioTrack.getState();
      if (i2 != 1)
        try
        {
          localAudioTrack.release();
          label27: throw new n.b(i2, this.s, this.t, this.y);
          int i1 = ag.f(this.v.d);
          if (this.Y == 0)
            localAudioTrack = new AudioTrack(i1, this.s, this.t, this.u, this.y, 1);
          else
            localAudioTrack = new AudioTrack(i1, this.s, this.t, this.u, this.y, 1, this.Y);
        }
        catch (Exception localException)
        {
          break label27;
        }
    }
    return localAudioTrack;
  }

  @TargetApi(21)
  private AudioTrack v()
  {
    AudioAttributes localAudioAttributes;
    AudioFormat localAudioFormat;
    if (this.aa)
    {
      localAudioAttributes = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
      localAudioFormat = new AudioFormat.Builder().setChannelMask(this.t).setEncoding(this.u).setSampleRate(this.s).build();
      if (this.Y == 0)
        break label102;
    }
    label102: for (int i1 = this.Y; ; i1 = 0)
    {
      return new AudioTrack(localAudioAttributes, localAudioFormat, this.y, 1, i1);
      localAudioAttributes = this.v.a();
      break;
    }
  }

  private f[] w()
  {
    if (this.q)
      return this.i;
    return this.h;
  }

  public long a(boolean paramBoolean)
  {
    if ((!r()) || (this.M == 0))
      return -9223372036854775808L;
    long l1 = Math.min(this.k.a(paramBoolean), e(t()));
    return this.N + c(b(l1));
  }

  public y a(y paramy)
  {
    if ((r()) && (!this.x))
    {
      this.A = y.a;
      return this.A;
    }
    y localy;
    if (this.z != null)
    {
      localy = this.z;
      if (!paramy.equals(localy))
      {
        if (!r())
          break label98;
        this.z = paramy;
      }
    }
    while (true)
    {
      return this.A;
      if (!this.l.isEmpty())
      {
        localy = d.a((d)this.l.getLast());
        break;
      }
      localy = this.A;
      break;
      label98: this.A = this.d.a(paramy);
    }
  }

  public void a()
  {
    this.X = true;
    if (r())
    {
      this.k.a();
      this.o.play();
    }
  }

  public void a(float paramFloat)
  {
    if (this.O != paramFloat)
    {
      this.O = paramFloat;
      p();
    }
  }

  public void a(int paramInt)
  {
    if (ag.a >= 21);
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.b(bool);
      if ((!this.aa) || (this.Y != paramInt))
      {
        this.aa = true;
        this.Y = paramInt;
        i();
      }
      return;
    }
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5, int paramInt6)
    throws n.a
  {
    this.r = paramInt3;
    this.p = ag.c(paramInt1);
    boolean bool1;
    boolean bool2;
    if ((this.e) && (a(paramInt2, 1073741824)) && (ag.d(paramInt1)))
    {
      bool1 = true;
      this.q = bool1;
      if (this.p)
        this.F = ag.b(paramInt1, paramInt2);
      if ((!this.p) || (paramInt1 == 4))
        break label154;
      bool2 = true;
      label78: if ((!bool2) || (this.q))
        break label160;
    }
    label154: label160: for (boolean bool3 = true; ; bool3 = false)
    {
      this.x = bool3;
      if ((ag.a >= 21) || (paramInt2 != 8) || (paramArrayOfInt != null))
        break label166;
      paramArrayOfInt = new int[6];
      for (int i8 = 0; i8 < paramArrayOfInt.length; i8++)
        paramArrayOfInt[i8] = i8;
      bool1 = false;
      break;
      bool2 = false;
      break label78;
    }
    label166: if (bool2)
    {
      this.g.a(paramInt5, paramInt6);
      this.f.a(paramArrayOfInt);
      f[] arrayOff = w();
      int i6 = arrayOff.length;
      int i7 = 0;
      i2 = paramInt2;
      bool4 = false;
      i1 = paramInt1;
      i3 = paramInt3;
      while (true)
      {
        if (i7 >= i6)
          break label324;
        f localf = arrayOff[i7];
        try
        {
          boolean bool5 = localf.a(i3, i2, i1);
          boolean bool6 = bool5 | bool4;
          if (localf.a())
          {
            i2 = localf.b();
            i3 = localf.d();
            i1 = localf.c();
          }
          i7++;
          bool4 = bool6;
        }
        catch (f.a locala)
        {
          throw new n.a(locala);
        }
      }
    }
    int i1 = paramInt1;
    int i2 = paramInt2;
    boolean bool4 = false;
    int i3 = paramInt3;
    label324: int i4 = a(i2, this.p);
    if (i4 == 0)
      throw new n.a("Unsupported channel count: " + i2);
    if ((!bool4) && (r()) && (this.u == i1) && (this.s == i3) && (this.t == i4))
      return;
    i();
    this.w = bool2;
    this.s = i3;
    this.t = i4;
    this.u = i1;
    int i5;
    if (this.p)
    {
      i5 = ag.b(this.u, i2);
      this.I = i5;
      if (paramInt4 == 0)
        break label479;
    }
    while (true)
    {
      this.y = paramInt4;
      return;
      i5 = -1;
      break;
      label479: paramInt4 = k();
    }
  }

  public void a(b paramb)
  {
    if (this.v.equals(paramb));
    do
    {
      return;
      this.v = paramb;
    }
    while (this.aa);
    i();
    this.Y = 0;
  }

  public void a(n.c paramc)
  {
    this.m = paramc;
  }

  public void a(q paramq)
  {
    if (this.Z.equals(paramq))
      return;
    int i1 = paramq.a;
    float f1 = paramq.b;
    if (this.o != null)
    {
      if (this.Z.a != i1)
        this.o.attachAuxEffect(i1);
      if (i1 != 0)
        this.o.setAuxEffectSendLevel(f1);
    }
    this.Z = paramq;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if (ag.c(paramInt2))
    {
      boolean bool2;
      if (paramInt2 == 4)
      {
        int i1 = ag.a;
        bool2 = false;
        if (i1 < 21);
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if ((this.c != null) && (this.c.a(paramInt2)) && ((paramInt1 == -1) || (paramInt1 <= this.c.a())));
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  public boolean a(ByteBuffer paramByteBuffer, long paramLong)
    throws n.b, n.d
  {
    if ((this.R == null) || (paramByteBuffer == this.R));
    for (boolean bool = true; ; bool = false)
    {
      com.google.android.exoplayer2.g.a.a(bool);
      if (!r())
      {
        n();
        if (this.X)
          a();
      }
      if (this.k.a(t()))
        break;
      return false;
    }
    if (this.R == null)
    {
      if (!paramByteBuffer.hasRemaining())
        return true;
      if ((!this.p) && (this.L == 0))
      {
        this.L = a(this.u, paramByteBuffer);
        if (this.L == 0)
          return true;
      }
      if (this.z != null)
      {
        if (!o())
          return false;
        y localy1 = this.z;
        this.z = null;
        y localy2 = this.d.a(localy1);
        this.l.add(new d(localy2, Math.max(0L, paramLong), e(t()), null));
        l();
      }
      if (this.M == 0)
      {
        this.N = Math.max(0L, paramLong);
        this.M = 1;
        if (!this.p)
          break label418;
        this.G += paramByteBuffer.remaining();
        label235: this.R = paramByteBuffer;
      }
    }
    else
    {
      if (!this.w)
        break label435;
      a(paramLong);
    }
    while (true)
    {
      if (this.R.hasRemaining())
        break label447;
      this.R = null;
      return true;
      long l1 = this.N + d(s() - this.g.k());
      if ((this.M == 1) && (Math.abs(l1 - paramLong) > 200000L))
      {
        l.d("AudioTrack", "Discontinuity detected [expected " + l1 + ", got " + paramLong + "]");
        this.M = 2;
      }
      if (this.M != 2)
        break;
      long l2 = paramLong - l1;
      this.N = (l2 + this.N);
      this.M = 1;
      if ((this.m == null) || (l2 == 0L))
        break;
      this.m.a();
      break;
      label418: this.H += this.L;
      break label235;
      label435: b(this.R, paramLong);
    }
    label447: if (this.k.c(t()))
    {
      l.c("AudioTrack", "Resetting stalled audio track");
      i();
      return true;
    }
    return false;
  }

  public void b()
  {
    if (this.M == 1)
      this.M = 2;
  }

  public void c()
    throws n.d
  {
    if ((this.W) || (!r()));
    while (!o())
      return;
    this.k.d(t());
    this.o.stop();
    this.E = 0;
    this.W = true;
  }

  public boolean d()
  {
    return (!r()) || ((this.W) && (!e()));
  }

  public boolean e()
  {
    return (r()) && (this.k.e(t()));
  }

  public y f()
  {
    return this.A;
  }

  public void g()
  {
    if (this.aa)
    {
      this.aa = false;
      this.Y = 0;
      i();
    }
  }

  public void h()
  {
    this.X = false;
    if ((r()) && (this.k.c()))
      this.o.pause();
  }

  public void i()
  {
    if (r())
    {
      this.G = 0L;
      this.H = 0L;
      this.J = 0L;
      this.K = 0L;
      this.L = 0;
      if (this.z == null)
        break label169;
      this.A = this.z;
      this.z = null;
    }
    while (true)
    {
      this.l.clear();
      this.B = 0L;
      this.C = 0L;
      this.g.j();
      this.R = null;
      this.S = null;
      m();
      this.W = false;
      this.V = -1;
      this.D = null;
      this.E = 0;
      this.M = 0;
      if (this.k.b())
        this.o.pause();
      final AudioTrack localAudioTrack = this.o;
      this.o = null;
      this.k.d();
      this.j.close();
      new Thread()
      {
        public void run()
        {
          try
          {
            localAudioTrack.flush();
            localAudioTrack.release();
            return;
          }
          finally
          {
            s.a(s.this).open();
          }
        }
      }
      .start();
      return;
      label169: if (!this.l.isEmpty())
        this.A = d.a((d)this.l.getLast());
    }
  }

  public void j()
  {
    i();
    q();
    f[] arrayOff1 = this.h;
    int i1 = arrayOff1.length;
    for (int i2 = 0; i2 < i1; i2++)
      arrayOff1[i2].i();
    f[] arrayOff2 = this.i;
    int i3 = arrayOff2.length;
    for (int i4 = 0; i4 < i3; i4++)
      arrayOff2[i4].i();
    this.Y = 0;
    this.X = false;
  }

  public static abstract interface a
  {
    public abstract long a(long paramLong);

    public abstract y a(y paramy);

    public abstract f[] a();

    public abstract long b();
  }

  public static class b
    implements s.a
  {
    private final f[] a;
    private final x b;
    private final z c;

    public b(f[] paramArrayOff)
    {
      this.a = ((f[])Arrays.copyOf(paramArrayOff, 2 + paramArrayOff.length));
      this.b = new x();
      this.c = new z();
      this.a[paramArrayOff.length] = this.b;
      this.a[(1 + paramArrayOff.length)] = this.c;
    }

    public long a(long paramLong)
    {
      return this.c.a(paramLong);
    }

    public y a(y paramy)
    {
      this.b.a(paramy.d);
      return new y(this.c.a(paramy.b), this.c.b(paramy.c), paramy.d);
    }

    public f[] a()
    {
      return this.a;
    }

    public long b()
    {
      return this.b.j();
    }
  }

  public static final class c extends RuntimeException
  {
    private c(String paramString)
    {
      super();
    }
  }

  private static final class d
  {
    private final y a;
    private final long b;
    private final long c;

    private d(y paramy, long paramLong1, long paramLong2)
    {
      this.a = paramy;
      this.b = paramLong1;
      this.c = paramLong2;
    }
  }

  private final class e
    implements p.a
  {
    private e()
    {
    }

    public void a(int paramInt, long paramLong)
    {
      if (s.d(s.this) != null)
      {
        long l = SystemClock.elapsedRealtime() - s.e(s.this);
        s.d(s.this).a(paramInt, paramLong, l);
      }
    }

    public void a(long paramLong)
    {
      l.c("AudioTrack", "Ignoring impossibly large audio latency: " + paramLong);
    }

    public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      String str = "Spurious audio timestamp (frame position mismatch): " + paramLong1 + ", " + paramLong2 + ", " + paramLong3 + ", " + paramLong4 + ", " + s.b(s.this) + ", " + s.c(s.this);
      if (s.b)
        throw new s.c(str, null);
      l.c("AudioTrack", str);
    }

    public void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      String str = "Spurious audio timestamp (system clock mismatch): " + paramLong1 + ", " + paramLong2 + ", " + paramLong3 + ", " + paramLong4 + ", " + s.b(s.this) + ", " + s.c(s.this);
      if (s.b)
        throw new s.c(str, null);
      l.c("AudioTrack", str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.s
 * JD-Core Version:    0.6.2
 */