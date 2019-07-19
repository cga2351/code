package com.google.e.g.a;

import com.google.e.p;

final class h extends g
{
  private final boolean a;

  h(c paramc, boolean paramBoolean)
  {
    super(paramc);
    this.a = paramBoolean;
  }

  private void a(d[] paramArrayOfd, a parama)
  {
    int i = 0;
    if (i < paramArrayOfd.length)
    {
      d locald = paramArrayOfd[i];
      if (paramArrayOfd[i] == null);
      while (true)
      {
        i++;
        break;
        int j = locald.g() % 30;
        int k = locald.h();
        if (k > parama.c())
        {
          paramArrayOfd[i] = null;
        }
        else
        {
          if (!this.a)
            k += 2;
          switch (k % 3)
          {
          default:
            break;
          case 0:
            if (1 + j * 3 != parama.d())
              paramArrayOfd[i] = null;
            break;
          case 1:
            if ((j / 3 != parama.b()) || (j % 3 != parama.e()))
              paramArrayOfd[i] = null;
            break;
          case 2:
            if (j + 1 != parama.a())
              paramArrayOfd[i] = null;
            break;
          }
        }
      }
    }
  }

  int a(a parama)
  {
    d[] arrayOfd = b();
    c();
    a(arrayOfd, parama);
    c localc = a();
    p localp1;
    p localp2;
    label46: float f;
    int k;
    int m;
    int n;
    int i1;
    label97: int i3;
    int i4;
    int i5;
    if (this.a)
    {
      localp1 = localc.e();
      if (!this.a)
        break label150;
      localp2 = localc.g();
      int i = b((int)localp1.b());
      int j = b((int)localp2.b());
      f = (j - i) / parama.c();
      k = -1;
      m = i;
      n = 0;
      i1 = 1;
      if (m >= j)
        break label397;
      if (arrayOfd[m] != null)
        break label159;
      i3 = n;
      i4 = i1;
      i5 = k;
    }
    while (true)
    {
      m++;
      k = i5;
      i1 = i4;
      n = i3;
      break label97;
      localp1 = localc.f();
      break;
      label150: localp2 = localc.h();
      break label46;
      label159: d locald = arrayOfd[m];
      int i2 = locald.h() - k;
      if (i2 == 0)
      {
        i3 = n + 1;
        i4 = i1;
        i5 = k;
      }
      else if (i2 == 1)
      {
        int i10 = Math.max(i1, n);
        i5 = locald.h();
        i4 = i10;
        i3 = 1;
      }
      else if ((i2 < 0) || (locald.h() >= parama.c()) || (i2 > m))
      {
        arrayOfd[m] = null;
        i3 = n;
        i4 = i1;
        i5 = k;
      }
      else
      {
        int i6;
        label298: int i8;
        if (i1 > 2)
        {
          i6 = i2 * (i1 - 2);
          if (i6 < m)
            break label339;
          i7 = 1;
          i8 = 1;
          label301: if ((i8 > i6) || (i7 != 0))
            break label351;
          if (arrayOfd[(m - i8)] == null)
            break label345;
        }
        label339: label345: for (int i7 = 1; ; i7 = 0)
        {
          i8++;
          break label301;
          i6 = i2;
          break;
          i7 = 0;
          break label298;
        }
        label351: if (i7 != 0)
        {
          arrayOfd[m] = null;
          i3 = n;
          i4 = i1;
          i5 = k;
        }
        else
        {
          int i9 = locald.h();
          i4 = i1;
          i5 = i9;
          i3 = 1;
        }
      }
    }
    label397: return (int)(0.5D + f);
  }

  int b(a parama)
  {
    c localc = a();
    p localp1;
    p localp2;
    label30: float f;
    d[] arrayOfd;
    int k;
    int m;
    int n;
    int i1;
    if (this.a)
    {
      localp1 = localc.e();
      if (!this.a)
        break label115;
      localp2 = localc.g();
      int i = b((int)localp1.b());
      int j = b((int)localp2.b());
      f = (j - i) / parama.c();
      arrayOfd = b();
      k = -1;
      m = i;
      n = 0;
      i1 = 1;
      label86: if (m >= j)
        break label223;
      if (arrayOfd[m] != null)
        break label124;
    }
    while (true)
    {
      m++;
      break label86;
      localp1 = localc.f();
      break;
      label115: localp2 = localc.h();
      break label30;
      label124: d locald = arrayOfd[m];
      locald.b();
      int i2 = locald.h() - k;
      if (i2 == 0)
      {
        n++;
      }
      else if (i2 == 1)
      {
        int i3 = Math.max(i1, n);
        k = locald.h();
        i1 = i3;
        n = 1;
      }
      else if (locald.h() >= parama.c())
      {
        arrayOfd[m] = null;
      }
      else
      {
        k = locald.h();
        n = 1;
      }
    }
    label223: return (int)(0.5D + f);
  }

  void c()
  {
    for (d locald : b())
      if (locald != null)
        locald.b();
  }

  int[] d()
    throws com.google.e.g
  {
    a locala = e();
    int[] arrayOfInt;
    if (locala == null)
      arrayOfInt = null;
    while (true)
    {
      return arrayOfInt;
      b(locala);
      arrayOfInt = new int[locala.c()];
      for (d locald : b())
        if (locald != null)
        {
          int k = locald.h();
          if (k >= arrayOfInt.length)
            throw com.google.e.g.a();
          arrayOfInt[k] = (1 + arrayOfInt[k]);
        }
    }
  }

  a e()
  {
    d[] arrayOfd = b();
    b localb1 = new b();
    b localb2 = new b();
    b localb3 = new b();
    b localb4 = new b();
    int i = arrayOfd.length;
    int j = 0;
    if (j < i)
    {
      d locald = arrayOfd[j];
      if (locald == null);
      while (true)
      {
        j++;
        break;
        locald.b();
        int k = locald.g() % 30;
        int m = locald.h();
        if (!this.a)
          m += 2;
        switch (m % 3)
        {
        default:
          break;
        case 0:
          localb2.a(1 + k * 3);
          break;
        case 1:
          localb4.a(k / 3);
          localb3.a(k % 3);
          break;
        case 2:
          localb1.a(k + 1);
        }
      }
    }
    if ((localb1.a().length == 0) || (localb2.a().length == 0) || (localb3.a().length == 0) || (localb4.a().length == 0) || (localb1.a()[0] < 1) || (localb2.a()[0] + localb3.a()[0] < 3) || (localb2.a()[0] + localb3.a()[0] > 90))
      return null;
    a locala = new a(localb1.a()[0], localb2.a()[0], localb3.a()[0], localb4.a()[0]);
    a(arrayOfd, locala);
    return locala;
  }

  boolean f()
  {
    return this.a;
  }

  public String toString()
  {
    return "IsLeft: " + this.a + '\n' + super.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.g.a.h
 * JD-Core Version:    0.6.2
 */