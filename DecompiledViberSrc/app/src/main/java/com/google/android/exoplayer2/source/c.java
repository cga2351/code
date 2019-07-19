package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ai;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.p;
import java.io.IOException;

public final class c
  implements m, m.a
{
  public final m a;
  long b;
  long c;
  private m.a d;
  private a[] e;
  private long f;

  public c(m paramm, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.a = paramm;
    this.e = new a[0];
    if (paramBoolean);
    for (long l = paramLong1; ; l = -9223372036854775807L)
    {
      this.f = l;
      this.b = paramLong1;
      this.c = paramLong2;
      return;
    }
  }

  private static boolean a(long paramLong, com.google.android.exoplayer2.trackselection.e[] paramArrayOfe)
  {
    boolean bool1 = paramLong < 0L;
    boolean bool2 = false;
    int i;
    if (bool1)
      i = paramArrayOfe.length;
    for (int j = 0; ; j++)
    {
      bool2 = false;
      if (j < i)
      {
        com.google.android.exoplayer2.trackselection.e locale = paramArrayOfe[j];
        if ((locale != null) && (!o.a(locale.h().sampleMimeType)))
          bool2 = true;
      }
      else
      {
        return bool2;
      }
    }
  }

  private ai b(long paramLong, ai paramai)
  {
    long l1 = ag.a(paramai.f, 0L, paramLong - this.b);
    long l2 = paramai.g;
    if (this.c == -9223372036854775808L);
    long l4;
    for (long l3 = 9223372036854775807L; ; l3 = this.c - paramLong)
    {
      l4 = ag.a(l2, 0L, l3);
      if ((l1 != paramai.f) || (l4 != paramai.g))
        break;
      return paramai;
    }
    return new ai(l1, l4);
  }

  public long a(long paramLong, ai paramai)
  {
    if (paramLong == this.b)
      return this.b;
    ai localai = b(paramLong, paramai);
    return this.a.a(paramLong, localai);
  }

  public long a(com.google.android.exoplayer2.trackselection.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, z[] paramArrayOfz, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    this.e = new a[paramArrayOfz.length];
    z[] arrayOfz = new z[paramArrayOfz.length];
    int i = 0;
    if (i < paramArrayOfz.length)
    {
      this.e[i] = ((a)paramArrayOfz[i]);
      if (this.e[i] != null);
      for (z localz = this.e[i].a; ; localz = null)
      {
        arrayOfz[i] = localz;
        i++;
        break;
      }
    }
    long l1 = this.a.a(paramArrayOfe, paramArrayOfBoolean1, arrayOfz, paramArrayOfBoolean2, paramLong);
    long l2;
    boolean bool;
    label180: int j;
    if ((f()) && (paramLong == this.b) && (a(this.b, paramArrayOfe)))
    {
      l2 = l1;
      this.f = l2;
      if ((l1 != paramLong) && ((l1 < this.b) || ((this.c != -9223372036854775808L) && (l1 > this.c))))
        break label236;
      bool = true;
      a.b(bool);
      j = 0;
      label188: if (j >= paramArrayOfz.length)
        break label290;
      if (arrayOfz[j] != null)
        break label242;
      this.e[j] = null;
    }
    while (true)
    {
      paramArrayOfz[j] = this.e[j];
      j++;
      break label188;
      l2 = -9223372036854775807L;
      break;
      label236: bool = false;
      break label180;
      label242: if ((paramArrayOfz[j] == null) || (this.e[j].a != arrayOfz[j]))
        this.e[j] = new a(arrayOfz[j]);
    }
    label290: return l1;
  }

  public void a(long paramLong)
  {
    this.a.a(paramLong);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    this.a.a(paramLong, paramBoolean);
  }

  public void a(m.a parama, long paramLong)
  {
    this.d = parama;
    this.a.a(this, paramLong);
  }

  public void a(m paramm)
  {
    this.d.a(this);
  }

  public long b(long paramLong)
  {
    this.f = -9223372036854775807L;
    for (a locala : this.e)
      if (locala != null)
        locala.a();
    long l = this.a.b(paramLong);
    if (l != paramLong)
    {
      boolean bool2 = l < this.b;
      bool1 = false;
      if (bool2)
        break label115;
      if (this.c != -9223372036854775808L)
      {
        boolean bool3 = l < this.c;
        bool1 = false;
        if (bool3)
          break label115;
      }
    }
    boolean bool1 = true;
    label115: a.b(bool1);
    return l;
  }

  public TrackGroupArray b()
  {
    return this.a.b();
  }

  public void b(m paramm)
  {
    this.d.a(this);
  }

  public long c()
  {
    if (f())
    {
      long l2 = this.f;
      this.f = -9223372036854775807L;
      long l3 = c();
      if (l3 != -9223372036854775807L)
        return l3;
      return l2;
    }
    long l1 = this.a.c();
    if (l1 == -9223372036854775807L)
      return -9223372036854775807L;
    if (l1 >= this.b);
    for (boolean bool1 = true; ; bool1 = false)
    {
      a.b(bool1);
      boolean bool2;
      if (this.c != -9223372036854775808L)
      {
        boolean bool3 = l1 < this.c;
        bool2 = false;
        if (bool3);
      }
      else
      {
        bool2 = true;
      }
      a.b(bool2);
      return l1;
    }
  }

  public boolean c(long paramLong)
  {
    return this.a.c(paramLong);
  }

  public long d()
  {
    long l = this.a.d();
    if ((l == -9223372036854775808L) || ((this.c != -9223372036854775808L) && (l >= this.c)))
      l = -9223372036854775808L;
    return l;
  }

  public long e()
  {
    long l = this.a.e();
    if ((l == -9223372036854775808L) || ((this.c != -9223372036854775808L) && (l >= this.c)))
      l = -9223372036854775808L;
    return l;
  }

  boolean f()
  {
    return this.f != -9223372036854775807L;
  }

  public void i_()
    throws IOException
  {
    this.a.i_();
  }

  private final class a
    implements z
  {
    public final z a;
    private boolean c;

    public a(z arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public int a(long paramLong)
    {
      if (c.this.f())
        return -3;
      return this.a.a(paramLong);
    }

    public int a(p paramp, com.google.android.exoplayer2.c.e parame, boolean paramBoolean)
    {
      if (c.this.f())
        return -3;
      if (this.c)
      {
        parame.a_(4);
        return -4;
      }
      int i = this.a.a(paramp, parame, paramBoolean);
      if (i == -5)
      {
        Format localFormat = paramp.a;
        int j;
        int k;
        if ((localFormat.encoderDelay != 0) || (localFormat.encoderPadding != 0))
        {
          if (c.this.b == 0L)
            break label123;
          j = 0;
          boolean bool = c.this.c < -9223372036854775808L;
          k = 0;
          if (!bool)
            break label133;
        }
        while (true)
        {
          paramp.a = localFormat.copyWithGaplessInfo(j, k);
          return -5;
          label123: j = localFormat.encoderDelay;
          break;
          label133: k = localFormat.encoderPadding;
        }
      }
      if ((c.this.c != -9223372036854775808L) && (((i == -4) && (parame.c >= c.this.c)) || ((i == -3) && (c.this.d() == -9223372036854775808L))))
      {
        parame.a();
        parame.a_(4);
        this.c = true;
        return -4;
      }
      return i;
    }

    public void a()
    {
      this.c = false;
    }

    public boolean b()
    {
      return (!c.this.f()) && (this.a.b());
    }

    public void c()
      throws IOException
    {
      this.a.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c
 * JD-Core Version:    0.6.2
 */