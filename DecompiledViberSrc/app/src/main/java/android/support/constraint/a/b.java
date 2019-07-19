package android.support.constraint.a;

public class b
  implements e.a
{
  h a = null;
  float b = 0.0F;
  boolean c = false;
  public final a d;
  boolean e = false;

  public b(c paramc)
  {
    this.d = new a(this, paramc);
  }

  public b a(float paramFloat1, float paramFloat2, float paramFloat3, h paramh1, h paramh2, h paramh3, h paramh4)
  {
    if ((paramFloat2 == 0.0F) || (paramFloat1 == paramFloat3))
    {
      this.b = 0.0F;
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh2, -1.0F);
      this.d.a(paramh4, 1.0F);
      this.d.a(paramh3, -1.0F);
      return this;
    }
    float f = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    this.b = 0.0F;
    this.d.a(paramh1, 1.0F);
    this.d.a(paramh2, -1.0F);
    this.d.a(paramh4, f);
    this.d.a(paramh3, -f);
    return this;
  }

  public b a(e parame, int paramInt)
  {
    this.d.a(parame.a(paramInt, "ep"), 1.0F);
    this.d.a(parame.a(paramInt, "em"), -1.0F);
    return this;
  }

  b a(h paramh, int paramInt)
  {
    this.a = paramh;
    paramh.d = paramInt;
    this.b = paramInt;
    this.e = true;
    return this;
  }

  public b a(h paramh1, h paramh2, int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      i = 0;
      if (paramInt < 0)
      {
        paramInt *= -1;
        i = 1;
      }
      this.b = paramInt;
    }
    if (i == 0)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      return this;
    }
    this.d.a(paramh1, 1.0F);
    this.d.a(paramh2, -1.0F);
    return this;
  }

  b a(h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2)
  {
    if (paramh2 == paramh3)
    {
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh4, 1.0F);
      this.d.a(paramh2, -2.0F);
    }
    do
    {
      do
      {
        return this;
        if (paramFloat != 0.5F)
          break;
        this.d.a(paramh1, 1.0F);
        this.d.a(paramh2, -1.0F);
        this.d.a(paramh3, -1.0F);
        this.d.a(paramh4, 1.0F);
      }
      while ((paramInt1 <= 0) && (paramInt2 <= 0));
      this.b = (paramInt2 + -paramInt1);
      return this;
      if (paramFloat <= 0.0F)
      {
        this.d.a(paramh1, -1.0F);
        this.d.a(paramh2, 1.0F);
        this.b = paramInt1;
        return this;
      }
      if (paramFloat >= 1.0F)
      {
        this.d.a(paramh3, -1.0F);
        this.d.a(paramh4, 1.0F);
        this.b = paramInt2;
        return this;
      }
      this.d.a(paramh1, 1.0F * (1.0F - paramFloat));
      this.d.a(paramh2, -1.0F * (1.0F - paramFloat));
      this.d.a(paramh3, -1.0F * paramFloat);
      this.d.a(paramh4, 1.0F * paramFloat);
    }
    while ((paramInt1 <= 0) && (paramInt2 <= 0));
    this.b = (-paramInt1 * (1.0F - paramFloat) + paramFloat * paramInt2);
    return this;
  }

  b a(h paramh1, h paramh2, h paramh3, float paramFloat)
  {
    this.d.a(paramh1, -1.0F);
    this.d.a(paramh2, 1.0F - paramFloat);
    this.d.a(paramh3, paramFloat);
    return this;
  }

  public b a(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      i = 0;
      if (paramInt < 0)
      {
        paramInt *= -1;
        i = 1;
      }
      this.b = paramInt;
    }
    if (i == 0)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      this.d.a(paramh3, 1.0F);
      return this;
    }
    this.d.a(paramh1, 1.0F);
    this.d.a(paramh2, -1.0F);
    this.d.a(paramh3, -1.0F);
    return this;
  }

  public b a(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    this.d.a(paramh1, -1.0F);
    this.d.a(paramh2, 1.0F);
    this.d.a(paramh3, paramFloat);
    this.d.a(paramh4, -paramFloat);
    return this;
  }

  public h a(e parame, boolean[] paramArrayOfBoolean)
  {
    return this.d.a(paramArrayOfBoolean, null);
  }

  public void a(e.a parama)
  {
    if ((parama instanceof b))
    {
      b localb = (b)parama;
      this.a = null;
      this.d.a();
      for (int i = 0; i < localb.d.a; i++)
      {
        h localh = localb.d.a(i);
        float f = localb.d.b(i);
        this.d.a(localh, f, true);
      }
    }
  }

  boolean a()
  {
    return (this.a != null) && ((this.a.f == h.a.a) || (this.b >= 0.0F));
  }

  boolean a(e parame)
  {
    h localh = this.d.a(parame);
    if (localh == null);
    for (boolean bool = true; ; bool = false)
    {
      if (this.d.a == 0)
        this.e = true;
      return bool;
      c(localh);
    }
  }

  boolean a(h paramh)
  {
    return this.d.a(paramh);
  }

  public b b(h paramh, int paramInt)
  {
    if (paramInt < 0)
    {
      this.b = (paramInt * -1);
      this.d.a(paramh, 1.0F);
      return this;
    }
    this.b = paramInt;
    this.d.a(paramh, -1.0F);
    return this;
  }

  public b b(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      i = 0;
      if (paramInt < 0)
      {
        paramInt *= -1;
        i = 1;
      }
      this.b = paramInt;
    }
    if (i == 0)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      this.d.a(paramh3, -1.0F);
      return this;
    }
    this.d.a(paramh1, 1.0F);
    this.d.a(paramh2, -1.0F);
    this.d.a(paramh3, 1.0F);
    return this;
  }

  public b b(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    this.d.a(paramh3, 0.5F);
    this.d.a(paramh4, 0.5F);
    this.d.a(paramh1, -0.5F);
    this.d.a(paramh2, -0.5F);
    this.b = (-paramFloat);
    return this;
  }

  h b(h paramh)
  {
    return this.d.a(null, paramh);
  }

  String b()
  {
    String str1;
    String str2;
    String str3;
    if (this.a == null)
    {
      str1 = "" + "0";
      str2 = str1 + " = ";
      if (this.b == 0.0F)
        break label397;
      str3 = str2 + this.b;
    }
    for (int i = 1; ; i = 0)
    {
      int j = this.d.a;
      int k = 0;
      Object localObject = str3;
      label97: float f1;
      String str4;
      float f2;
      if (k < j)
      {
        h localh = this.d.a(k);
        if (localh == null);
        do
        {
          k++;
          break label97;
          str1 = "" + this.a;
          break;
          f1 = this.d.b(k);
        }
        while (f1 == 0.0F);
        str4 = localh.toString();
        if (i == 0)
        {
          if (f1 >= 0.0F)
            break label390;
          localObject = (String)localObject + "- ";
          f2 = f1 * -1.0F;
        }
      }
      while (true)
      {
        label218: if (f2 == 1.0F);
        for (String str5 = (String)localObject + str4; ; str5 = (String)localObject + f2 + " " + str4)
        {
          localObject = str5;
          i = 1;
          break;
          if (f1 > 0.0F)
          {
            localObject = (String)localObject + " + ";
            f2 = f1;
            break label218;
          }
          localObject = (String)localObject + " - ";
          f2 = f1 * -1.0F;
          break label218;
        }
        if (i == 0)
          localObject = (String)localObject + "0.0";
        return localObject;
        label390: f2 = f1;
      }
      label397: str3 = str2;
    }
  }

  b c(h paramh, int paramInt)
  {
    this.d.a(paramh, paramInt);
    return this;
  }

  public void c()
  {
    this.a = null;
    this.d.a();
    this.b = 0.0F;
    this.e = false;
  }

  void c(h paramh)
  {
    if (this.a != null)
    {
      this.d.a(this.a, -1.0F);
      this.a = null;
    }
    float f = -1.0F * this.d.a(paramh, true);
    this.a = paramh;
    if (f == 1.0F)
      return;
    this.b /= f;
    this.d.a(f);
  }

  void d()
  {
    if (this.b < 0.0F)
    {
      this.b = (-1.0F * this.b);
      this.d.b();
    }
  }

  public void d(h paramh)
  {
    float f = 1.0F;
    if (paramh.c == 1);
    while (true)
    {
      this.d.a(paramh, f);
      return;
      if (paramh.c == 2)
        f = 1000.0F;
      else if (paramh.c == 3)
        f = 1000000.0F;
      else if (paramh.c == 4)
        f = 1.0E+009F;
      else if (paramh.c == 5)
        f = 1.0E+012F;
    }
  }

  public boolean e()
  {
    return (this.a == null) && (this.b == 0.0F) && (this.d.a == 0);
  }

  public void f()
  {
    this.d.a();
    this.a = null;
    this.b = 0.0F;
  }

  public h g()
  {
    return this.a;
  }

  public String toString()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.b
 * JD-Core Version:    0.6.2
 */