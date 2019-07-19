package android.support.design.bottomappbar;

import android.support.design.g.b;
import android.support.design.g.d;

public class a extends b
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;

  float a()
  {
    return this.e;
  }

  void a(float paramFloat)
  {
    this.e = paramFloat;
  }

  public void a(float paramFloat1, float paramFloat2, d paramd)
  {
    if (this.c == 0.0F)
    {
      paramd.b(paramFloat1, 0.0F);
      return;
    }
    float f1 = (2.0F * this.b + this.c) / 2.0F;
    float f2 = paramFloat2 * this.a;
    float f3 = paramFloat1 / 2.0F + this.e;
    float f4 = paramFloat2 * this.d + f1 * (1.0F - paramFloat2);
    if (f4 / f1 >= 1.0F)
    {
      paramd.b(paramFloat1, 0.0F);
      return;
    }
    float f5 = f1 + f2;
    float f6 = f5 * f5;
    float f7 = f4 + f2;
    float f8 = (float)Math.sqrt(f6 - f7 * f7);
    float f9 = f3 - f8;
    float f10 = f3 + f8;
    float f11 = (float)Math.toDegrees(Math.atan(f8 / f7));
    float f12 = 90.0F - f11;
    paramd.b(f9 - f2, 0.0F);
    paramd.a(f9 - f2, 0.0F, f9 + f2, f2 * 2.0F, 270.0F, f11);
    paramd.a(f3 - f1, -f1 - f4, f3 + f1, f1 - f4, 180.0F - f12, 2.0F * f12 - 180.0F);
    paramd.a(f10 - f2, 0.0F, f10 + f2, f2 * 2.0F, 270.0F - f11, f11);
    paramd.b(paramFloat1, 0.0F);
  }

  float b()
  {
    return this.d;
  }

  void b(float paramFloat)
  {
    this.d = paramFloat;
  }

  float c()
  {
    return this.c;
  }

  void c(float paramFloat)
  {
    this.c = paramFloat;
  }

  float d()
  {
    return this.b;
  }

  void d(float paramFloat)
  {
    this.b = paramFloat;
  }

  float e()
  {
    return this.a;
  }

  void e(float paramFloat)
  {
    this.a = paramFloat;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.bottomappbar.a
 * JD-Core Version:    0.6.2
 */