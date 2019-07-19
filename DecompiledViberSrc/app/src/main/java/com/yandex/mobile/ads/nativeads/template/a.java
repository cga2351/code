package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import com.yandex.mobile.ads.impl.dh;

abstract class a
{
  protected final float a;

  a(float paramFloat)
  {
    this.a = a(paramFloat);
  }

  protected static float b(float paramFloat)
  {
    if (paramFloat < 0.01F)
      paramFloat = 0.01F;
    while (paramFloat <= 1.0F)
      return paramFloat;
    return 1.0F;
  }

  protected abstract float a(float paramFloat);

  public abstract d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3);

  static final class a extends a
  {
    public a(float paramFloat)
    {
      super();
    }

    protected final float a(float paramFloat)
    {
      if (paramFloat < 10.0F)
        paramFloat = 10.0F;
      return paramFloat;
    }

    public final a.d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = Math.min(dh.a(paramContext, this.a), paramInt1);
      return new a.d(i, Math.round(i / paramInt2 * paramInt3));
    }
  }

  static final class b extends a
  {
    public b(float paramFloat)
    {
      super();
    }

    protected final float a(float paramFloat)
    {
      return b(paramFloat);
    }

    public final a.d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = Math.round(paramInt1 * this.a);
      return new a.d(i, Math.round(i / paramInt2 * paramInt3));
    }
  }

  static final class c extends a
  {
    public c(float paramFloat)
    {
      super();
    }

    protected final float a(float paramFloat)
    {
      return b(paramFloat);
    }

    public final a.d a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = dh.a(paramContext, 140.0F);
      int j = Math.round(paramInt1 * this.a);
      int k;
      if (paramInt2 > j)
      {
        float f2 = paramInt2 / j;
        k = Math.round(paramInt3 / f2);
      }
      while (true)
      {
        float f1;
        if (k > i)
          f1 = k / i;
        for (int m = Math.round(j / f1); ; m = j)
        {
          return new a.d(m, i);
          i = k;
        }
        k = paramInt3;
        j = paramInt2;
      }
    }
  }

  static final class d
  {
    private final int a;
    private final int b;

    public d(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public final int a()
    {
      return this.a;
    }

    public final int b()
    {
      return this.b;
    }

    public final boolean equals(Object paramObject)
    {
      if (this == paramObject);
      d locald;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locald = (d)paramObject;
        if (this.a != locald.a)
          return false;
      }
      while (this.b == locald.b);
      return false;
    }

    public final int hashCode()
    {
      return 31 * this.a + this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.template.a
 * JD-Core Version:    0.6.2
 */