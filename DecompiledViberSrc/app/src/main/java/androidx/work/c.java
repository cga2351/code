package androidx.work;

import android.os.Build.VERSION;

public final class c
{
  public static final c a = new a().a();
  private j b = j.a;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private long g = -1L;
  private long h = -1L;
  private d i = new d();

  public c()
  {
  }

  c(a parama)
  {
    this.c = parama.a;
    if ((Build.VERSION.SDK_INT >= 23) && (parama.b));
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      this.b = parama.c;
      this.e = parama.d;
      this.f = parama.e;
      if (Build.VERSION.SDK_INT >= 24)
      {
        this.i = parama.h;
        this.g = parama.f;
        this.h = parama.g;
      }
      return;
    }
  }

  public c(c paramc)
  {
    this.c = paramc.c;
    this.d = paramc.d;
    this.b = paramc.b;
    this.e = paramc.e;
    this.f = paramc.f;
    this.i = paramc.i;
  }

  public j a()
  {
    return this.b;
  }

  public void a(long paramLong)
  {
    this.g = paramLong;
  }

  public void a(d paramd)
  {
    this.i = paramd;
  }

  public void a(j paramj)
  {
    this.b = paramj;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void b(long paramLong)
  {
    this.h = paramLong;
  }

  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public boolean b()
  {
    return this.c;
  }

  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public boolean c()
  {
    return this.d;
  }

  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public boolean d()
  {
    return this.e;
  }

  public boolean e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    c localc;
    j localj1;
    j localj2;
    do
    {
      boolean bool11;
      do
      {
        boolean bool10;
        do
        {
          boolean bool8;
          boolean bool9;
          do
          {
            boolean bool6;
            boolean bool7;
            do
            {
              boolean bool4;
              boolean bool5;
              do
              {
                boolean bool2;
                boolean bool3;
                do
                {
                  Class localClass1;
                  Class localClass2;
                  do
                  {
                    do
                    {
                      return bool1;
                      bool1 = false;
                    }
                    while (paramObject == null);
                    localClass1 = getClass();
                    localClass2 = paramObject.getClass();
                    bool1 = false;
                  }
                  while (localClass1 != localClass2);
                  localc = (c)paramObject;
                  bool2 = this.c;
                  bool3 = localc.c;
                  bool1 = false;
                }
                while (bool2 != bool3);
                bool4 = this.d;
                bool5 = localc.d;
                bool1 = false;
              }
              while (bool4 != bool5);
              bool6 = this.e;
              bool7 = localc.e;
              bool1 = false;
            }
            while (bool6 != bool7);
            bool8 = this.f;
            bool9 = localc.f;
            bool1 = false;
          }
          while (bool8 != bool9);
          bool10 = this.g < localc.g;
          bool1 = false;
        }
        while (bool10);
        bool11 = this.h < localc.h;
        bool1 = false;
      }
      while (bool11);
      localj1 = this.b;
      localj2 = localc.b;
      bool1 = false;
    }
    while (localj1 != localj2);
    return this.i.equals(localc.i);
  }

  public long f()
  {
    return this.g;
  }

  public long g()
  {
    return this.h;
  }

  public d h()
  {
    return this.i;
  }

  public int hashCode()
  {
    int j = 1;
    int k = 31 * this.b.hashCode();
    int m;
    int i1;
    label40: int i3;
    label60: int i4;
    if (this.c)
    {
      m = j;
      int n = 31 * (m + k);
      if (!this.d)
        break label132;
      i1 = j;
      int i2 = 31 * (i1 + n);
      if (!this.e)
        break label138;
      i3 = j;
      i4 = 31 * (i3 + i2);
      if (!this.f)
        break label144;
    }
    while (true)
    {
      return 31 * (31 * (31 * (i4 + j) + (int)(this.g ^ this.g >>> 32)) + (int)(this.h ^ this.h >>> 32)) + this.i.hashCode();
      m = 0;
      break;
      label132: i1 = 0;
      break label40;
      label138: i3 = 0;
      break label60;
      label144: j = 0;
    }
  }

  public boolean i()
  {
    return this.i.b() > 0;
  }

  public static final class a
  {
    boolean a = false;
    boolean b = false;
    j c = j.a;
    boolean d = false;
    boolean e = false;
    long f = -1L;
    long g = -1L;
    d h = new d();

    public a a(j paramj)
    {
      this.c = paramj;
      return this;
    }

    public a a(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }

    public c a()
    {
      return new c(this);
    }

    public a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.c
 * JD-Core Version:    0.6.2
 */