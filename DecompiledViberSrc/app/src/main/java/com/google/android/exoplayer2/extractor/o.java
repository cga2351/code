package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.g.a;

public abstract interface o
{
  public abstract a a(long paramLong);

  public abstract boolean a();

  public abstract long b();

  public static final class a
  {
    public final p a;
    public final p b;

    public a(p paramp)
    {
      this(paramp, paramp);
    }

    public a(p paramp1, p paramp2)
    {
      this.a = ((p)a.a(paramp1));
      this.b = ((p)a.a(paramp2));
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
      }
      while ((this.a.equals(locala.a)) && (this.b.equals(locala.b)));
      return false;
    }

    public int hashCode()
    {
      return 31 * this.a.hashCode() + this.b.hashCode();
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[").append(this.a);
      if (this.a.equals(this.b));
      for (String str = ""; ; str = ", " + this.b)
        return str + "]";
    }
  }

  public static final class b
    implements o
  {
    private final long a;
    private final o.a b;

    public b(long paramLong)
    {
      this(paramLong, 0L);
    }

    public b(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      if (paramLong2 == 0L);
      for (p localp = p.a; ; localp = new p(0L, paramLong2))
      {
        this.b = new o.a(localp);
        return;
      }
    }

    public o.a a(long paramLong)
    {
      return this.b;
    }

    public boolean a()
    {
      return false;
    }

    public long b()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.o
 * JD-Core Version:    0.6.2
 */