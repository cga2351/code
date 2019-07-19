package com.google.e;

import com.google.e.c.a.a;

public class p
{
  private final float a;
  private final float b;

  public p(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }

  public static float a(p paramp1, p paramp2)
  {
    return a.a(paramp1.a, paramp1.b, paramp2.a, paramp2.b);
  }

  private static float a(p paramp1, p paramp2, p paramp3)
  {
    float f1 = paramp2.a;
    float f2 = paramp2.b;
    return (paramp3.a - f1) * (paramp1.b - f2) - (paramp3.b - f2) * (paramp1.a - f1);
  }

  public static void a(p[] paramArrayOfp)
  {
    float f1 = a(paramArrayOfp[0], paramArrayOfp[1]);
    float f2 = a(paramArrayOfp[1], paramArrayOfp[2]);
    float f3 = a(paramArrayOfp[0], paramArrayOfp[2]);
    p localp;
    Object localObject1;
    Object localObject2;
    if ((f2 >= f1) && (f2 >= f3))
    {
      localp = paramArrayOfp[0];
      localObject1 = paramArrayOfp[1];
      localObject2 = paramArrayOfp[2];
      if (a((p)localObject1, localp, (p)localObject2) >= 0.0F)
        break label135;
    }
    while (true)
    {
      paramArrayOfp[0] = localObject2;
      paramArrayOfp[1] = localp;
      paramArrayOfp[2] = localObject1;
      return;
      if ((f3 >= f2) && (f3 >= f1))
      {
        localp = paramArrayOfp[1];
        localObject1 = paramArrayOfp[0];
        localObject2 = paramArrayOfp[2];
        break;
      }
      localp = paramArrayOfp[2];
      localObject1 = paramArrayOfp[0];
      localObject2 = paramArrayOfp[1];
      break;
      label135: Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }

  public final float a()
  {
    return this.a;
  }

  public final float b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof p;
    boolean bool2 = false;
    if (bool1)
    {
      p localp = (p)paramObject;
      boolean bool3 = this.a < localp.a;
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = this.b < localp.b;
        bool2 = false;
        if (!bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public final int hashCode()
  {
    return 31 * Float.floatToIntBits(this.a) + Float.floatToIntBits(this.b);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(25);
    localStringBuilder.append('(');
    localStringBuilder.append(this.a);
    localStringBuilder.append(',');
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.p
 * JD-Core Version:    0.6.2
 */