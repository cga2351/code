package com.c.a.a.d;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
  protected final a a;
  protected final AtomicReference<b> b;
  protected final boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected int[] g;
  protected c[] h;
  protected a[] i;
  protected int j;
  protected int k;
  private final int l;
  private transient boolean m;
  private boolean n;
  private boolean o;
  private boolean p;

  private a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.a = null;
    this.l = paramInt2;
    this.c = paramBoolean;
    if (paramInt1 < i1)
      paramInt1 = i1;
    while (true)
    {
      this.b = new AtomicReference(e(paramInt1));
      return;
      if ((paramInt1 & paramInt1 - 1) != 0)
      {
        while (i1 < paramInt1)
          i1 += i1;
        paramInt1 = i1;
      }
    }
  }

  private a(a parama, boolean paramBoolean, int paramInt, b paramb)
  {
    this.a = parama;
    this.l = paramInt;
    this.c = paramBoolean;
    this.b = null;
    this.d = paramb.a;
    this.f = paramb.b;
    this.g = paramb.c;
    this.h = paramb.d;
    this.i = paramb.e;
    this.j = paramb.f;
    this.k = paramb.g;
    this.e = paramb.h;
    this.m = false;
    this.n = true;
    this.o = true;
    this.p = true;
  }

  public static a a()
  {
    long l1 = System.currentTimeMillis();
    return a(0x1 | (int)l1 + (int)(l1 >>> 32));
  }

  protected static a a(int paramInt)
  {
    return new a(64, true, paramInt);
  }

  private static c a(int paramInt1, String paramString, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 < 4);
    int[] arrayOfInt;
    int i1;
    switch (paramInt2)
    {
    default:
      arrayOfInt = new int[paramInt2];
      i1 = 0;
    case 1:
    case 2:
    case 3:
    }
    while (i1 < paramInt2)
    {
      arrayOfInt[i1] = paramArrayOfInt[i1];
      i1++;
      continue;
      return new d(paramString, paramInt1, paramArrayOfInt[0]);
      return new e(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1]);
      return new f(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
    }
    return new g(paramString, paramInt1, arrayOfInt, paramInt2);
  }

  private void a(int paramInt, c paramc)
  {
    if (this.n)
      h();
    if (this.m)
      e();
    this.d = (1 + this.d);
    int i1 = paramInt & this.f;
    int i6;
    if (this.h[i1] == null)
    {
      this.g[i1] = (paramInt << 8);
      if (this.o)
        j();
      this.h[i1] = paramc;
      int i5 = this.g.length;
      if (this.d > i5 >> 1)
      {
        i6 = i5 >> 2;
        if (this.d <= i5 - i6)
          break label297;
        this.m = true;
      }
    }
    label200: 
    while (this.j < i6)
    {
      return;
      if (this.p)
        i();
      this.j = (1 + this.j);
      int i2 = this.g[i1];
      int i3 = i2 & 0xFF;
      int i4;
      if (i3 == 0)
        if (this.k <= 254)
        {
          i4 = this.k;
          this.k = (1 + this.k);
          if (i4 >= this.i.length)
            k();
          this.g[i1] = (i2 & 0xFFFFFF00 | i4 + 1);
        }
      while (true)
      {
        a locala = new a(paramc, this.i[i4]);
        this.i[i4] = locala;
        this.e = Math.max(locala.a(), this.e);
        if (this.e <= 255)
          break;
        d(255);
        break;
        i4 = g();
        break label200;
        i4 = i3 - 1;
      }
    }
    label297: this.m = true;
  }

  private void a(b paramb)
  {
    int i1 = paramb.a;
    b localb = (b)this.b.get();
    if (i1 <= localb.a)
      return;
    if ((i1 > 6000) || (paramb.h > 63))
      paramb = e(64);
    this.b.compareAndSet(localb, paramb);
  }

  public static c d()
  {
    return d.b();
  }

  private b e(int paramInt)
  {
    return new b(0, paramInt - 1, new int[paramInt], new c[paramInt], null, 0, 0, 0);
  }

  private void e()
  {
    int i1 = 0;
    this.m = false;
    this.o = false;
    int i2 = this.g.length;
    int i3 = i2 + i2;
    if (i3 > 65536)
      f();
    int i8;
    label365: 
    do
    {
      return;
      this.g = new int[i3];
      this.f = (i3 - 1);
      c[] arrayOfc = this.h;
      this.h = new c[i3];
      int i4 = 0;
      int i5 = 0;
      while (i4 < i2)
      {
        c localc2 = arrayOfc[i4];
        if (localc2 != null)
        {
          i5++;
          int i17 = localc2.hashCode();
          int i18 = i17 & this.f;
          this.h[i18] = localc2;
          this.g[i18] = (i17 << 8);
        }
        i4++;
      }
      int i6 = this.k;
      if (i6 == 0)
      {
        this.e = 0;
        return;
      }
      this.j = 0;
      this.k = 0;
      this.p = false;
      a[] arrayOfa = this.i;
      this.i = new a[arrayOfa.length];
      int i7 = 0;
      int i9;
      for (i8 = i5; i7 < i6; i8 = i9)
      {
        a locala1 = arrayOfa[i7];
        i9 = i8;
        a locala2 = locala1;
        while (locala2 != null)
        {
          int i10 = i9 + 1;
          c localc1 = locala2.a;
          int i11 = localc1.hashCode();
          int i12 = i11 & this.f;
          int i13 = this.g[i12];
          int i16;
          if (this.h[i12] == null)
          {
            this.g[i12] = (i11 << 8);
            this.h[i12] = localc1;
            i16 = i1;
            locala2 = locala2.b;
            i1 = i16;
            i9 = i10;
          }
          else
          {
            this.j = (1 + this.j);
            int i14 = i13 & 0xFF;
            int i15;
            if (i14 == 0)
              if (this.k <= 254)
              {
                i15 = this.k;
                this.k = (1 + this.k);
                if (i15 >= this.i.length)
                  k();
                this.g[i12] = (i13 & 0xFFFFFF00 | i15 + 1);
              }
            while (true)
            {
              a locala3 = new a(localc1, this.i[i15]);
              this.i[i15] = locala3;
              i16 = Math.max(i1, locala3.a());
              break;
              i15 = g();
              break label365;
              i15 = i14 - 1;
            }
          }
        }
        i7++;
      }
      this.e = i1;
    }
    while (i8 == this.d);
    throw new RuntimeException("Internal error: count after rehash " + i8 + "; should be " + this.d);
  }

  private void f()
  {
    this.d = 0;
    this.e = 0;
    Arrays.fill(this.g, 0);
    Arrays.fill(this.h, null);
    Arrays.fill(this.i, null);
    this.j = 0;
    this.k = 0;
  }

  private int g()
  {
    a[] arrayOfa = this.i;
    int i1 = 2147483647;
    int i2 = -1;
    int i3 = 0;
    int i4 = this.k;
    int i5;
    if (i3 < i4)
    {
      i5 = arrayOfa[i3].a();
      if (i5 >= i1)
        break label64;
      if (i5 == 1)
        return i3;
      i2 = i3;
    }
    while (true)
    {
      i3++;
      i1 = i5;
      break;
      return i2;
      label64: i5 = i1;
    }
  }

  private void h()
  {
    int[] arrayOfInt = this.g;
    int i1 = this.g.length;
    this.g = new int[i1];
    System.arraycopy(arrayOfInt, 0, this.g, 0, i1);
    this.n = false;
  }

  private void i()
  {
    a[] arrayOfa = this.i;
    if (arrayOfa == null)
      this.i = new a[32];
    while (true)
    {
      this.p = false;
      return;
      int i1 = arrayOfa.length;
      this.i = new a[i1];
      System.arraycopy(arrayOfa, 0, this.i, 0, i1);
    }
  }

  private void j()
  {
    c[] arrayOfc = this.h;
    int i1 = arrayOfc.length;
    this.h = new c[i1];
    System.arraycopy(arrayOfc, 0, this.h, 0, i1);
    this.o = false;
  }

  private void k()
  {
    a[] arrayOfa = this.i;
    int i1 = arrayOfa.length;
    this.i = new a[i1 + i1];
    System.arraycopy(arrayOfa, 0, this.i, 0, i1);
  }

  public a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new a(this, paramBoolean2, this.l, (b)this.b.get());
  }

  public c a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0);
    int i3;
    c localc;
    for (int i1 = c(paramInt1); ; i1 = b(paramInt1, paramInt2))
    {
      int i2 = i1 & this.f;
      i3 = this.g[i2];
      if ((i1 ^ i3 >> 8) << 8 != 0)
        break label79;
      localc = this.h[i2];
      if (localc != null)
        break;
      return null;
    }
    if (localc.a(paramInt1, paramInt2))
    {
      return localc;
      label79: if (i3 == 0)
        return null;
    }
    int i4 = i3 & 0xFF;
    if (i4 > 0)
    {
      int i5 = i4 - 1;
      a locala = this.i[i5];
      if (locala != null)
        return locala.a(i1, paramInt1, paramInt2);
    }
    return null;
  }

  public c a(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    if (this.c)
      paramString = com.c.a.a.e.d.a.a(paramString);
    int i1;
    if (paramInt < 3)
      if (paramInt == 1)
        i1 = c(paramArrayOfInt[0]);
    while (true)
    {
      c localc = a(i1, paramString, paramArrayOfInt, paramInt);
      a(i1, localc);
      return localc;
      i1 = b(paramArrayOfInt[0], paramArrayOfInt[1]);
      continue;
      i1 = b(paramArrayOfInt, paramInt);
    }
  }

  public c a(int[] paramArrayOfInt, int paramInt)
  {
    int i7;
    c localc;
    if (paramInt < 3)
    {
      int i6 = paramArrayOfInt[0];
      i7 = 0;
      if (paramInt < 2)
        localc = a(i6, i7);
    }
    int i1;
    int i3;
    do
    {
      return localc;
      i7 = paramArrayOfInt[1];
      break;
      i1 = b(paramArrayOfInt, paramInt);
      int i2 = i1 & this.f;
      i3 = this.g[i2];
      if ((i1 ^ i3 >> 8) << 8 != 0)
        break label142;
      localc = this.h[i2];
    }
    while ((localc == null) || (localc.a(paramArrayOfInt, paramInt)));
    label142: 
    while (i3 != 0)
    {
      int i4 = i3 & 0xFF;
      if (i4 <= 0)
        break;
      int i5 = i4 - 1;
      a locala = this.i[i5];
      if (locala == null)
        break;
      return locala.a(i1, paramArrayOfInt, paramInt);
    }
    return null;
    return null;
  }

  public int b(int paramInt1, int paramInt2)
  {
    int i1 = (paramInt1 ^ paramInt1 >>> 15) + paramInt2 * 33 ^ this.l;
    return i1 + (i1 >>> 7);
  }

  public int b(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = 3;
    if (paramInt < i1)
      throw new IllegalArgumentException();
    int i2 = paramArrayOfInt[0] ^ this.l;
    int i3 = 65599 * (33 * (i2 + (i2 >>> 9)) + paramArrayOfInt[1]);
    int i4 = i3 + (i3 >>> 15) ^ paramArrayOfInt[2];
    int i5 = i4 + (i4 >>> 17);
    while (i1 < paramInt)
    {
      int i7 = i5 * 31 ^ paramArrayOfInt[i1];
      int i8 = i7 + (i7 >>> 3);
      i5 = i8 ^ i8 << 7;
      i1++;
    }
    int i6 = i5 + (i5 >>> 15);
    return i6 ^ i6 << 9;
  }

  public c b(int paramInt)
  {
    int i1 = c(paramInt);
    int i2 = i1 & this.f;
    int i3 = this.g[i2];
    c localc;
    if ((i1 ^ i3 >> 8) << 8 == 0)
    {
      localc = this.h[i2];
      if (localc != null);
    }
    a locala;
    do
    {
      int i4;
      do
      {
        do
        {
          return null;
          if (!localc.a(paramInt))
            break;
          return localc;
        }
        while (i3 == 0);
        i4 = i3 & 0xFF;
      }
      while (i4 <= 0);
      int i5 = i4 - 1;
      locala = this.i[i5];
    }
    while (locala == null);
    return locala.a(i1, paramInt, 0);
  }

  public void b()
  {
    if ((this.a != null) && (c()))
    {
      this.a.a(new b(this));
      this.n = true;
      this.o = true;
      this.p = true;
    }
  }

  public int c(int paramInt)
  {
    int i1 = paramInt ^ this.l;
    int i2 = i1 + (i1 >>> 15);
    return i2 ^ i2 >>> 9;
  }

  public boolean c()
  {
    return !this.n;
  }

  protected void d(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.d + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }

  static final class a
  {
    protected final c a;
    protected final a b;
    private final int c;

    a(c paramc, a parama)
    {
      this.a = paramc;
      this.b = parama;
      if (parama == null);
      for (int i = 1; ; i = 1 + parama.c)
      {
        this.c = i;
        return;
      }
    }

    public int a()
    {
      return this.c;
    }

    public c a(int paramInt1, int paramInt2, int paramInt3)
    {
      c localc;
      if ((this.a.hashCode() == paramInt1) && (this.a.a(paramInt2, paramInt3)))
      {
        localc = this.a;
        return localc;
      }
      for (a locala = this.b; ; locala = locala.b)
      {
        if (locala == null)
          break label79;
        localc = locala.a;
        if ((localc.hashCode() == paramInt1) && (localc.a(paramInt2, paramInt3)))
          break;
      }
      label79: return null;
    }

    public c a(int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      c localc;
      if ((this.a.hashCode() == paramInt1) && (this.a.a(paramArrayOfInt, paramInt2)))
      {
        localc = this.a;
        return localc;
      }
      for (a locala = this.b; ; locala = locala.b)
      {
        if (locala == null)
          break label79;
        localc = locala.a;
        if ((localc.hashCode() == paramInt1) && (localc.a(paramArrayOfInt, paramInt2)))
          break;
      }
      label79: return null;
    }
  }

  private static final class b
  {
    public final int a;
    public final int b;
    public final int[] c;
    public final c[] d;
    public final a.a[] e;
    public final int f;
    public final int g;
    public final int h;

    public b(int paramInt1, int paramInt2, int[] paramArrayOfInt, c[] paramArrayOfc, a.a[] paramArrayOfa, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramArrayOfInt;
      this.d = paramArrayOfc;
      this.e = paramArrayOfa;
      this.f = paramInt3;
      this.g = paramInt4;
      this.h = paramInt5;
    }

    public b(a parama)
    {
      this.a = parama.d;
      this.b = parama.f;
      this.c = parama.g;
      this.d = parama.h;
      this.e = parama.i;
      this.f = parama.j;
      this.g = parama.k;
      this.h = parama.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d.a
 * JD-Core Version:    0.6.2
 */