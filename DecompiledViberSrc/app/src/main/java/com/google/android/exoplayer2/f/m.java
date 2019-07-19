package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.g.ag;
import java.util.Arrays;

public final class m
  implements b
{
  private final boolean a;
  private final int b;
  private final byte[] c;
  private final a[] d;
  private int e;
  private int f;
  private int g;
  private a[] h;

  public m(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, 0);
  }

  public m(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool1;
    if (paramInt1 > 0)
    {
      bool1 = true;
      com.google.android.exoplayer2.g.a.a(bool1);
      if (paramInt2 < 0)
        break label114;
    }
    label114: for (boolean bool2 = true; ; bool2 = false)
    {
      com.google.android.exoplayer2.g.a.a(bool2);
      this.a = paramBoolean;
      this.b = paramInt1;
      this.g = paramInt2;
      this.h = new a[paramInt2 + 100];
      if (paramInt2 <= 0)
        break label120;
      this.c = new byte[paramInt2 * paramInt1];
      while (i < paramInt2)
      {
        int j = i * paramInt1;
        this.h[i] = new a(this.c, j);
        i++;
      }
      bool1 = false;
      break;
    }
    label120: this.c = null;
    this.d = new a[1];
  }

  public a a()
  {
    try
    {
      this.f = (1 + this.f);
      a locala;
      if (this.g > 0)
      {
        a[] arrayOfa = this.h;
        int i = -1 + this.g;
        this.g = i;
        locala = arrayOfa[i];
        this.h[this.g] = null;
      }
      while (true)
      {
        return locala;
        locala = new a(new byte[this.b], 0);
      }
    }
    finally
    {
    }
  }

  public void a(int paramInt)
  {
    try
    {
      if (paramInt < this.e);
      for (int i = 1; ; i = 0)
      {
        this.e = paramInt;
        if (i != 0)
          b();
        return;
      }
    }
    finally
    {
    }
  }

  public void a(a parama)
  {
    try
    {
      this.d[0] = parama;
      a(this.d);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(a[] paramArrayOfa)
  {
    try
    {
      if (this.g + paramArrayOfa.length >= this.h.length)
        this.h = ((a[])Arrays.copyOf(this.h, Math.max(2 * this.h.length, this.g + paramArrayOfa.length)));
      int i = paramArrayOfa.length;
      for (int j = 0; j < i; j++)
      {
        a locala = paramArrayOfa[j];
        a[] arrayOfa = this.h;
        int k = this.g;
        this.g = (k + 1);
        arrayOfa[k] = locala;
      }
      this.f -= paramArrayOfa.length;
      notifyAll();
      return;
    }
    finally
    {
    }
  }

  public void b()
  {
    int i = 0;
    while (true)
    {
      int j;
      try
      {
        j = Math.max(0, ag.a(this.e, this.b) - this.f);
        int k = this.g;
        if (j >= k)
          return;
        if (this.c != null)
        {
          int n = -1 + this.g;
          if (i <= n)
          {
            a locala1 = this.h[i];
            if (locala1.a == this.c)
            {
              i++;
              continue;
            }
            a locala2 = this.h[n];
            if (locala2.a != this.c)
            {
              n--;
              continue;
            }
            a[] arrayOfa1 = this.h;
            int i1 = i + 1;
            arrayOfa1[i] = locala2;
            a[] arrayOfa2 = this.h;
            int i2 = n - 1;
            arrayOfa2[n] = locala1;
            n = i2;
            i = i1;
            continue;
          }
          m = Math.max(j, i);
          if (m >= this.g)
            continue;
          Arrays.fill(this.h, m, this.g, null);
          this.g = m;
          continue;
        }
      }
      finally
      {
      }
      int m = j;
    }
  }

  public int c()
  {
    return this.b;
  }

  public void d()
  {
    try
    {
      if (this.a)
        a(0);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int e()
  {
    try
    {
      int i = this.f;
      int j = this.b;
      int k = i * j;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.m
 * JD-Core Version:    0.6.2
 */