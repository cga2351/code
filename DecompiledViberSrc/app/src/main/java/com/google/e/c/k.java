package com.google.e.c;

public final class k
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final float i;

  private k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.a = paramFloat1;
    this.b = paramFloat4;
    this.c = paramFloat7;
    this.d = paramFloat2;
    this.e = paramFloat5;
    this.f = paramFloat8;
    this.g = paramFloat3;
    this.h = paramFloat6;
    this.i = paramFloat9;
  }

  public static k a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = paramFloat5 + (paramFloat1 - paramFloat3) - paramFloat7;
    float f2 = paramFloat6 + (paramFloat2 - paramFloat4) - paramFloat8;
    if ((f1 == 0.0F) && (f2 == 0.0F))
      return new k(paramFloat3 - paramFloat1, paramFloat5 - paramFloat3, paramFloat1, paramFloat4 - paramFloat2, paramFloat6 - paramFloat4, paramFloat2, 0.0F, 0.0F, 1.0F);
    float f3 = paramFloat3 - paramFloat5;
    float f4 = paramFloat7 - paramFloat5;
    float f5 = paramFloat4 - paramFloat6;
    float f6 = paramFloat8 - paramFloat6;
    float f7 = f3 * f6 - f4 * f5;
    float f8 = (f6 * f1 - f4 * f2) / f7;
    float f9 = (f2 * f3 - f1 * f5) / f7;
    return new k(paramFloat3 - paramFloat1 + f8 * paramFloat3, paramFloat7 - paramFloat1 + f9 * paramFloat7, paramFloat1, paramFloat4 - paramFloat2 + f8 * paramFloat4, paramFloat8 - paramFloat2 + f9 * paramFloat8, paramFloat2, f8, f9, 1.0F);
  }

  public static k a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16)
  {
    k localk = b(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    return a(paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16).a(localk);
  }

  public static k b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    return a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8).a();
  }

  k a()
  {
    return new k(this.e * this.i - this.f * this.h, this.f * this.g - this.d * this.i, this.d * this.h - this.e * this.g, this.c * this.h - this.b * this.i, this.a * this.i - this.c * this.g, this.b * this.g - this.a * this.h, this.b * this.f - this.c * this.e, this.c * this.d - this.a * this.f, this.a * this.e - this.b * this.d);
  }

  k a(k paramk)
  {
    return new k(this.a * paramk.a + this.d * paramk.b + this.g * paramk.c, this.a * paramk.d + this.d * paramk.e + this.g * paramk.f, this.a * paramk.g + this.d * paramk.h + this.g * paramk.i, this.b * paramk.a + this.e * paramk.b + this.h * paramk.c, this.b * paramk.d + this.e * paramk.e + this.h * paramk.f, this.b * paramk.g + this.e * paramk.h + this.h * paramk.i, this.c * paramk.a + this.f * paramk.b + this.i * paramk.c, this.c * paramk.d + this.f * paramk.e + this.i * paramk.f, this.c * paramk.g + this.f * paramk.h + this.i * paramk.i);
  }

  public void a(float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    float f5 = this.e;
    float f6 = this.f;
    float f7 = this.g;
    float f8 = this.h;
    float f9 = this.i;
    for (int k = 0; k < j; k += 2)
    {
      float f10 = paramArrayOfFloat[k];
      float f11 = paramArrayOfFloat[(k + 1)];
      float f12 = f9 + (f3 * f10 + f6 * f11);
      paramArrayOfFloat[k] = ((f7 + (f1 * f10 + f4 * f11)) / f12);
      paramArrayOfFloat[(k + 1)] = ((f8 + (f10 * f2 + f11 * f5)) / f12);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.c.k
 * JD-Core Version:    0.6.2
 */