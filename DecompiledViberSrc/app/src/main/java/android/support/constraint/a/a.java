package android.support.constraint.a;

import java.util.Arrays;

public class a
{
  int a = 0;
  private final b b;
  private final c c;
  private int d = 8;
  private h e = null;
  private int[] f = new int[this.d];
  private int[] g = new int[this.d];
  private float[] h = new float[this.d];
  private int i = -1;
  private int j = -1;
  private boolean k = false;

  a(b paramb, c paramc)
  {
    this.b = paramb;
    this.c = paramc;
  }

  private boolean a(h paramh, e parame)
  {
    return paramh.i <= 1;
  }

  public final float a(h paramh, boolean paramBoolean)
  {
    if (this.e == paramh)
      this.e = null;
    if (this.i == -1);
    while (true)
    {
      return 0.0F;
      int m = this.i;
      int n = 0;
      int i3;
      for (int i1 = -1; (m != -1) && (n < this.a); i1 = i3)
      {
        if (this.f[m] == paramh.a)
        {
          if (m == this.i)
            this.i = this.g[m];
          while (true)
          {
            if (paramBoolean)
              paramh.b(this.b);
            paramh.i = (-1 + paramh.i);
            this.a = (-1 + this.a);
            this.f[m] = -1;
            if (this.k)
              this.j = m;
            return this.h[m];
            this.g[i1] = this.g[m];
          }
        }
        int i2 = this.g[m];
        n++;
        i3 = m;
        m = i2;
      }
    }
  }

  final h a(int paramInt)
  {
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      if (n == paramInt)
        return this.c.c[this.f[m]];
      m = this.g[m];
    }
    return null;
  }

  h a(e parame)
  {
    Object localObject1 = null;
    boolean bool1 = false;
    int m = this.i;
    int n = 0;
    int i1 = m;
    float f1 = 0.0F;
    float f2 = 0.0F;
    Object localObject2 = null;
    boolean bool2 = false;
    float f3;
    Object localObject3;
    label106: Object localObject4;
    if ((i1 != -1) && (n < this.a))
    {
      f3 = this.h[i1];
      localObject3 = this.c.c[this.f[i1]];
      if (f3 < 0.0F)
      {
        if (f3 > -0.001F)
        {
          this.h[i1] = 0.0F;
          ((h)localObject3).b(this.b);
          f3 = 0.0F;
        }
        if (f3 == 0.0F)
          break label370;
        if (((h)localObject3).f != h.a.a)
          break label263;
        if (localObject1 != null)
          break label206;
        bool2 = a((h)localObject3, parame);
        localObject4 = localObject3;
        localObject3 = localObject2;
      }
    }
    label263: 
    while (true)
    {
      int i2 = this.g[i1];
      n++;
      i1 = i2;
      localObject1 = localObject4;
      localObject2 = localObject3;
      f2 = f3;
      break;
      if (f3 >= 0.001F)
        break label106;
      this.h[i1] = 0.0F;
      ((h)localObject3).b(this.b);
      f3 = 0.0F;
      break label106;
      label206: if (f2 > f3)
      {
        bool2 = a((h)localObject3, parame);
        localObject4 = localObject3;
        localObject3 = localObject2;
      }
      else if ((!bool2) && (a((h)localObject3, parame)))
      {
        bool2 = true;
        localObject4 = localObject3;
        localObject3 = localObject2;
        continue;
        if ((localObject1 == null) && (f3 < 0.0F))
        {
          if (localObject2 == null)
          {
            bool1 = a((h)localObject3, parame);
            f1 = f3;
            f3 = f2;
            localObject4 = localObject1;
            continue;
          }
          if (f1 > f3)
          {
            bool1 = a((h)localObject3, parame);
            f1 = f3;
            f3 = f2;
            localObject4 = localObject1;
            continue;
          }
          if ((!bool1) && (a((h)localObject3, parame)))
          {
            bool1 = true;
            f1 = f3;
            f3 = f2;
            localObject4 = localObject1;
            continue;
            if (localObject1 != null)
              return localObject1;
            return localObject2;
          }
        }
      }
      else
      {
        label370: f3 = f2;
        localObject3 = localObject2;
        localObject4 = localObject1;
      }
    }
  }

  h a(boolean[] paramArrayOfBoolean, h paramh)
  {
    int m = this.i;
    Object localObject1 = null;
    int n = 0;
    int i1 = m;
    float f1 = 0.0F;
    h localh;
    if ((i1 != -1) && (n < this.a))
    {
      if (this.h[i1] >= 0.0F)
        break label154;
      localh = this.c.c[this.f[i1]];
      if (((paramArrayOfBoolean != null) && (paramArrayOfBoolean[localh.a] != 0)) || (localh == paramh) || ((localh.f != h.a.c) && (localh.f != h.a.d)))
        break label154;
      float f2 = this.h[i1];
      if (f2 >= f1)
        break label154;
      f1 = f2;
    }
    label154: for (Object localObject2 = localh; ; localObject2 = localObject1)
    {
      int i2 = this.g[i1];
      n++;
      i1 = i2;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }

  public final void a()
  {
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      h localh = this.c.c[this.f[m]];
      if (localh != null)
        localh.b(this.b);
      m = this.g[m];
    }
    this.i = -1;
    this.j = -1;
    this.k = false;
    this.a = 0;
  }

  void a(float paramFloat)
  {
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[m] /= paramFloat;
      m = this.g[m];
    }
  }

  final void a(b paramb1, b paramb2, boolean paramBoolean)
  {
    int m = this.i;
    int n = 0;
    while ((m != -1) && (n < this.a))
      if (this.f[m] == paramb2.a.a)
      {
        float f1 = this.h[m];
        a(paramb2.a, paramBoolean);
        a locala = (a)paramb2.d;
        int i1 = locala.i;
        for (int i2 = 0; (i1 != -1) && (i2 < locala.a); i2++)
        {
          a(this.c.c[locala.f[i1]], f1 * locala.h[i1], paramBoolean);
          i1 = locala.g[i1];
        }
        paramb1.b += f1 * paramb2.b;
        if (paramBoolean)
          paramb2.a.b(paramb1);
        m = this.i;
        n = 0;
      }
      else
      {
        m = this.g[m];
        n++;
      }
  }

  void a(b paramb, b[] paramArrayOfb)
  {
    int m = this.i;
    int n = 0;
    while ((m != -1) && (n < this.a))
    {
      h localh = this.c.c[this.f[m]];
      if (localh.b != -1)
      {
        float f1 = this.h[m];
        a(localh, true);
        b localb = paramArrayOfb[localh.b];
        if (!localb.e)
        {
          a locala = (a)localb.d;
          int i1 = locala.i;
          for (int i2 = 0; (i1 != -1) && (i2 < locala.a); i2++)
          {
            a(this.c.c[locala.f[i1]], f1 * locala.h[i1], true);
            i1 = locala.g[i1];
          }
        }
        paramb.b += f1 * localb.b;
        localb.a.b(paramb);
        m = this.i;
        n = 0;
      }
      else
      {
        m = this.g[m];
        n++;
      }
    }
  }

  public final void a(h paramh, float paramFloat)
  {
    if (paramFloat == 0.0F)
      a(paramh, true);
    do
    {
      do
      {
        return;
        if (this.i != -1)
          break;
        this.i = 0;
        this.h[this.i] = paramFloat;
        this.f[this.i] = paramh.a;
        this.g[this.i] = -1;
        paramh.i = (1 + paramh.i);
        paramh.a(this.b);
        this.a = (1 + this.a);
      }
      while (this.k);
      this.j = (1 + this.j);
    }
    while (this.j < this.f.length);
    this.k = true;
    this.j = (-1 + this.f.length);
    return;
    int m = this.i;
    int n = 0;
    int i1 = -1;
    while ((m != -1) && (n < this.a))
    {
      if (this.f[m] == paramh.a)
      {
        this.h[m] = paramFloat;
        return;
      }
      if (this.f[m] < paramh.a)
        i1 = m;
      int i4 = this.g[m];
      n++;
      m = i4;
    }
    int i2 = 1 + this.j;
    label247: int i3;
    if (this.k)
    {
      if (this.f[this.j] == -1)
        i2 = this.j;
    }
    else
    {
      if ((i2 >= this.f.length) && (this.a < this.f.length))
      {
        i3 = 0;
        label272: if (i3 < this.f.length)
        {
          if (this.f[i3] != -1)
            break label531;
          i2 = i3;
        }
      }
      if (i2 >= this.f.length)
      {
        i2 = this.f.length;
        this.d = (2 * this.d);
        this.k = false;
        this.j = (i2 - 1);
        this.h = Arrays.copyOf(this.h, this.d);
        this.f = Arrays.copyOf(this.f, this.d);
        this.g = Arrays.copyOf(this.g, this.d);
      }
      this.f[i2] = paramh.a;
      this.h[i2] = paramFloat;
      if (i1 == -1)
        break label537;
      this.g[i2] = this.g[i1];
      this.g[i1] = i2;
    }
    while (true)
    {
      paramh.i = (1 + paramh.i);
      paramh.a(this.b);
      this.a = (1 + this.a);
      if (!this.k)
        this.j = (1 + this.j);
      if (this.a >= this.f.length)
        this.k = true;
      if (this.j < this.f.length)
        break;
      this.k = true;
      this.j = (-1 + this.f.length);
      return;
      i2 = this.f.length;
      break label247;
      label531: i3++;
      break label272;
      label537: this.g[i2] = this.i;
      this.i = i2;
    }
  }

  final void a(h paramh, float paramFloat, boolean paramBoolean)
  {
    if (paramFloat == 0.0F);
    do
    {
      do
      {
        return;
        if (this.i != -1)
          break;
        this.i = 0;
        this.h[this.i] = paramFloat;
        this.f[this.i] = paramh.a;
        this.g[this.i] = -1;
        paramh.i = (1 + paramh.i);
        paramh.a(this.b);
        this.a = (1 + this.a);
      }
      while (this.k);
      this.j = (1 + this.j);
    }
    while (this.j < this.f.length);
    this.k = true;
    this.j = (-1 + this.f.length);
    return;
    int m = this.i;
    int n = 0;
    int i1 = -1;
    while (true)
    {
      if ((m == -1) || (n >= this.a))
        break label318;
      if (this.f[m] == paramh.a)
      {
        float[] arrayOfFloat = this.h;
        arrayOfFloat[m] = (paramFloat + arrayOfFloat[m]);
        if (this.h[m] != 0.0F)
          break;
        if (m == this.i)
          this.i = this.g[m];
        while (true)
        {
          if (paramBoolean)
            paramh.b(this.b);
          if (this.k)
            this.j = m;
          paramh.i = (-1 + paramh.i);
          this.a = (-1 + this.a);
          return;
          this.g[i1] = this.g[m];
        }
      }
      if (this.f[m] < paramh.a)
        i1 = m;
      int i4 = this.g[m];
      n++;
      m = i4;
    }
    label318: int i2 = 1 + this.j;
    label352: int i3;
    if (this.k)
    {
      if (this.f[this.j] == -1)
        i2 = this.j;
    }
    else
    {
      if ((i2 >= this.f.length) && (this.a < this.f.length))
      {
        i3 = 0;
        label377: if (i3 < this.f.length)
        {
          if (this.f[i3] != -1)
            break label619;
          i2 = i3;
        }
      }
      if (i2 >= this.f.length)
      {
        i2 = this.f.length;
        this.d = (2 * this.d);
        this.k = false;
        this.j = (i2 - 1);
        this.h = Arrays.copyOf(this.h, this.d);
        this.f = Arrays.copyOf(this.f, this.d);
        this.g = Arrays.copyOf(this.g, this.d);
      }
      this.f[i2] = paramh.a;
      this.h[i2] = paramFloat;
      if (i1 == -1)
        break label625;
      this.g[i2] = this.g[i1];
      this.g[i1] = i2;
    }
    while (true)
    {
      paramh.i = (1 + paramh.i);
      paramh.a(this.b);
      this.a = (1 + this.a);
      if (!this.k)
        this.j = (1 + this.j);
      if (this.j < this.f.length)
        break;
      this.k = true;
      this.j = (-1 + this.f.length);
      return;
      i2 = this.f.length;
      break label352;
      label619: i3++;
      break label377;
      label625: this.g[i2] = this.i;
      this.i = i2;
    }
  }

  final boolean a(h paramh)
  {
    if (this.i == -1);
    while (true)
    {
      return false;
      int m = this.i;
      for (int n = 0; (m != -1) && (n < this.a); n++)
      {
        if (this.f[m] == paramh.a)
          return true;
        m = this.g[m];
      }
    }
  }

  final float b(int paramInt)
  {
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      if (n == paramInt)
        return this.h[m];
      m = this.g[m];
    }
    return 0.0F;
  }

  public final float b(h paramh)
  {
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      if (this.f[m] == paramh.a)
        return this.h[m];
      m = this.g[m];
    }
    return 0.0F;
  }

  void b()
  {
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      float[] arrayOfFloat = this.h;
      arrayOfFloat[m] = (-1.0F * arrayOfFloat[m]);
      m = this.g[m];
    }
  }

  public String toString()
  {
    String str1 = "";
    int m = this.i;
    for (int n = 0; (m != -1) && (n < this.a); n++)
    {
      String str2 = str1 + " -> ";
      String str3 = str2 + this.h[m] + " : ";
      str1 = str3 + this.c.c[this.f[m]];
      m = this.g[m];
    }
    return str1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a
 * JD-Core Version:    0.6.2
 */