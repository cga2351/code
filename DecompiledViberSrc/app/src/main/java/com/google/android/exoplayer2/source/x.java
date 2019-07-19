package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.extractor.q.a;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.p;

final class x
{
  private int a = 1000;
  private int[] b = new int[this.a];
  private long[] c = new long[this.a];
  private int[] d = new int[this.a];
  private int[] e = new int[this.a];
  private long[] f = new long[this.a];
  private q.a[] g = new q.a[this.a];
  private Format[] h = new Format[this.a];
  private int i;
  private int j;
  private int k;
  private int l;
  private long m = -9223372036854775808L;
  private long n = -9223372036854775808L;
  private boolean o;
  private boolean p = true;
  private boolean q = true;
  private Format r;
  private int s;

  private int a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int i1 = -1;
    int i2 = 0;
    while ((i2 < paramInt2) && (this.f[paramInt1] <= paramLong))
    {
      if ((!paramBoolean) || ((0x1 & this.e[paramInt1]) != 0))
        i1 = i2;
      int i3 = paramInt1 + 1;
      if (i3 == this.a)
        i3 = 0;
      i2++;
      paramInt1 = i3;
    }
    return i1;
  }

  private long c(int paramInt)
  {
    this.m = Math.max(this.m, d(paramInt));
    this.i -= paramInt;
    this.j = (paramInt + this.j);
    this.k = (paramInt + this.k);
    if (this.k >= this.a)
      this.k -= this.a;
    this.l -= paramInt;
    if (this.l < 0)
      this.l = 0;
    if (this.i == 0)
    {
      if (this.k == 0);
      for (int i1 = this.a; ; i1 = this.k)
      {
        int i2 = i1 - 1;
        return this.c[i2] + this.d[i2];
      }
    }
    return this.c[this.k];
  }

  private long d(int paramInt)
  {
    long l1 = -9223372036854775808L;
    if (paramInt == 0);
    while (true)
    {
      return l1;
      int i1 = e(paramInt - 1);
      int i2 = 0;
      int i3 = i1;
      while (i2 < paramInt)
      {
        long l2 = Math.max(l1, this.f[i3]);
        if ((0x1 & this.e[i3]) != 0)
          return l2;
        int i4 = i3 - 1;
        if (i4 == -1)
          i4 = -1 + this.a;
        i2++;
        i3 = i4;
        l1 = l2;
      }
    }
  }

  private int e(int paramInt)
  {
    int i1 = paramInt + this.k;
    if (i1 < this.a)
      return i1;
    return i1 - this.a;
  }

  public int a()
  {
    return this.j + this.i;
  }

  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = -1;
    try
    {
      int i2 = e(this.l);
      if ((d()) && (paramLong >= this.f[i2]))
      {
        long l1 = this.n;
        if ((paramLong <= l1) || (paramBoolean2))
          break label57;
      }
      while (true)
      {
        return i1;
        label57: int i3 = a(i2, this.i - this.l, paramLong, paramBoolean1);
        if (i3 != i1)
        {
          this.l = (i3 + this.l);
          i1 = i3;
        }
      }
    }
    finally
    {
    }
  }

  public int a(p paramp, e parame, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat, a parama)
  {
    int i1 = -5;
    while (true)
    {
      try
      {
        if (d())
          break label84;
        if ((paramBoolean2) || (this.o))
        {
          parame.a_(4);
          i1 = -4;
          return i1;
        }
        if ((this.r != null) && ((paramBoolean1) || (this.r != paramFormat)))
        {
          paramp.a = this.r;
          continue;
        }
      }
      finally
      {
      }
      i1 = -3;
      continue;
      label84: int i2 = e(this.l);
      if ((paramBoolean1) || (this.h[i2] != paramFormat))
      {
        paramp.a = this.h[i2];
      }
      else if (parame.f())
      {
        i1 = -3;
      }
      else
      {
        parame.c = this.f[i2];
        parame.a_(this.e[i2]);
        parama.a = this.d[i2];
        parama.b = this.c[i2];
        parama.c = this.g[i2];
        this.l = (1 + this.l);
        i1 = -4;
      }
    }
  }

  public long a(int paramInt)
  {
    boolean bool1 = true;
    int i1 = a() - paramInt;
    boolean bool2;
    if ((i1 >= 0) && (i1 <= this.i - this.l))
    {
      bool2 = bool1;
      a.a(bool2);
      this.i -= i1;
      this.n = Math.max(this.m, d(this.i));
      if ((i1 != 0) || (!this.o))
        break label94;
    }
    while (true)
    {
      this.o = bool1;
      if (this.i != 0)
        break label99;
      return 0L;
      bool2 = false;
      break;
      label94: bool1 = false;
    }
    label99: int i2 = e(-1 + this.i);
    return this.c[i2] + this.d[i2];
  }

  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, q.a parama)
  {
    while (true)
    {
      try
      {
        boolean bool1 = this.p;
        if (bool1)
        {
          if ((paramInt1 & 0x1) == 0)
            return;
          this.p = false;
        }
        if (!this.q)
        {
          bool2 = true;
          a.b(bool2);
          if ((0x20000000 & paramInt1) == 0)
            break label524;
          bool3 = true;
          this.o = bool3;
          this.n = Math.max(this.n, paramLong1);
          int i1 = e(this.i);
          this.f[i1] = paramLong1;
          this.c[i1] = paramLong2;
          this.d[i1] = paramInt2;
          this.e[i1] = paramInt1;
          this.g[i1] = parama;
          this.h[i1] = this.r;
          this.b[i1] = this.s;
          this.i = (1 + this.i);
          if (this.i != this.a)
            continue;
          int i2 = 1000 + this.a;
          int[] arrayOfInt1 = new int[i2];
          long[] arrayOfLong1 = new long[i2];
          long[] arrayOfLong2 = new long[i2];
          int[] arrayOfInt2 = new int[i2];
          int[] arrayOfInt3 = new int[i2];
          q.a[] arrayOfa = new q.a[i2];
          Format[] arrayOfFormat = new Format[i2];
          int i3 = this.a - this.k;
          System.arraycopy(this.c, this.k, arrayOfLong1, 0, i3);
          System.arraycopy(this.f, this.k, arrayOfLong2, 0, i3);
          System.arraycopy(this.e, this.k, arrayOfInt2, 0, i3);
          System.arraycopy(this.d, this.k, arrayOfInt3, 0, i3);
          System.arraycopy(this.g, this.k, arrayOfa, 0, i3);
          System.arraycopy(this.h, this.k, arrayOfFormat, 0, i3);
          System.arraycopy(this.b, this.k, arrayOfInt1, 0, i3);
          int i4 = this.k;
          System.arraycopy(this.c, 0, arrayOfLong1, i3, i4);
          System.arraycopy(this.f, 0, arrayOfLong2, i3, i4);
          System.arraycopy(this.e, 0, arrayOfInt2, i3, i4);
          System.arraycopy(this.d, 0, arrayOfInt3, i3, i4);
          System.arraycopy(this.g, 0, arrayOfa, i3, i4);
          System.arraycopy(this.h, 0, arrayOfFormat, i3, i4);
          System.arraycopy(this.b, 0, arrayOfInt1, i3, i4);
          this.c = arrayOfLong1;
          this.f = arrayOfLong2;
          this.e = arrayOfInt2;
          this.d = arrayOfInt3;
          this.g = arrayOfa;
          this.h = arrayOfFormat;
          this.b = arrayOfInt1;
          this.k = 0;
          this.i = this.a;
          this.a = i2;
          continue;
        }
      }
      finally
      {
      }
      boolean bool2 = false;
      continue;
      label524: boolean bool3 = false;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.p = true;
    this.m = -9223372036854775808L;
    this.n = -9223372036854775808L;
    this.o = false;
    if (paramBoolean)
    {
      this.r = null;
      this.q = true;
    }
  }

  public boolean a(long paramLong)
  {
    boolean bool = true;
    try
    {
      if (this.i == 0)
      {
        long l1 = this.m;
        if (paramLong <= l1);
      }
      while (true)
      {
        return bool;
        bool = false;
        continue;
        if (Math.max(this.m, d(this.l)) >= paramLong)
        {
          bool = false;
        }
        else
        {
          int i1 = this.i;
          int i2 = e(-1 + this.i);
          while ((i1 > this.l) && (this.f[i2] >= paramLong))
          {
            i1--;
            i2--;
            if (i2 == -1)
              i2 = -1 + this.a;
          }
          a(i1 + this.j);
        }
      }
    }
    finally
    {
    }
  }

  public boolean a(Format paramFormat)
  {
    boolean bool1 = false;
    if (paramFormat == null);
    try
    {
      this.q = true;
      while (true)
      {
        return bool1;
        this.q = false;
        boolean bool2 = ag.a(paramFormat, this.r);
        bool1 = false;
        if (!bool2)
        {
          this.r = paramFormat;
          bool1 = true;
        }
      }
    }
    finally
    {
    }
  }

  public int b()
  {
    return this.j + this.l;
  }

  public long b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      long l1;
      if (this.i != 0)
      {
        long l2 = this.f[this.k];
        if (paramLong >= l2);
      }
      else
      {
        l1 = -1L;
      }
      while (true)
      {
        return l1;
        if ((paramBoolean2) && (this.l != this.i));
        int i2;
        for (int i1 = 1 + this.l; ; i1 = this.i)
        {
          i2 = a(this.k, i1, paramLong, paramBoolean1);
          if (i2 != -1)
            break label98;
          l1 = -1L;
          break;
        }
        label98: long l3 = c(i2);
        l1 = l3;
      }
    }
    finally
    {
    }
  }

  public void b(int paramInt)
  {
    this.s = paramInt;
  }

  public int c()
  {
    int i1 = e(this.l);
    if (d())
      return this.b[i1];
    return this.s;
  }

  public boolean d()
  {
    try
    {
      int i1 = this.l;
      int i2 = this.i;
      if (i1 != i2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public Format e()
  {
    try
    {
      boolean bool = this.q;
      if (bool);
      for (Format localFormat = null; ; localFormat = this.r)
        return localFormat;
    }
    finally
    {
    }
  }

  public long f()
  {
    try
    {
      long l1 = this.n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean g()
  {
    try
    {
      boolean bool = this.o;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void h()
  {
    try
    {
      this.l = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int i()
  {
    try
    {
      int i1 = this.i - this.l;
      this.l = this.i;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long j()
  {
    try
    {
      int i1 = this.i;
      if (i1 == 0);
      long l1;
      for (long l2 = -1L; ; l2 = l1)
      {
        return l2;
        l1 = c(this.i);
      }
    }
    finally
    {
    }
  }

  public static final class a
  {
    public int a;
    public long b;
    public q.a c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.x
 * JD-Core Version:    0.6.2
 */