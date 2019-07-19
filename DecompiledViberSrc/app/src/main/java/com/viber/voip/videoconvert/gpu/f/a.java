package com.viber.voip.videoconvert.gpu.f;

import com.viber.voip.videoconvert.gpu.encoders.c.c;
import com.viber.voip.videoconvert.gpu.opengl.e;

public abstract class a
  implements d
{
  protected d.b a;
  protected long b;
  protected long c;
  protected long d;

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
  }

  public void a(d.b paramb)
  {
    this.a = paramb;
  }

  protected void a(e parame, c.c paramc)
  {
    float f1 = 1.0F;
    float[] arrayOfFloat1 = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    float f2 = (float)f();
    float f3 = (float)g();
    if ((this.d == 90L) || (this.d == 270L))
    {
      f2 = (float)g();
      f3 = (float)f();
    }
    float f4 = (float)this.b;
    float f5 = (float)this.c;
    if (paramc == c.c.a);
    for (float f6 = f1; ; f6 = 0.0F)
    {
      if (paramc == c.c.b)
      {
        float f8 = f4 / f2;
        if (f3 * f8 < f5)
          f8 *= f5 / (f3 * f8);
        f6 = f2 * f8 / f4;
        f1 = f8 * f3 / f5;
      }
      if (paramc == c.c.c)
      {
        float f7 = f4 / f2;
        if (f3 * f7 > f5)
          f7 *= f5 / (f3 * f7);
        f6 = f2 * f7 / f4;
        f1 = f3 * f7 / f5;
      }
      float[] arrayOfFloat2 = new float[12];
      arrayOfFloat2[0] = (-f6);
      arrayOfFloat2[1] = (-f1);
      arrayOfFloat2[2] = 0.0F;
      arrayOfFloat2[3] = f6;
      arrayOfFloat2[4] = (-f1);
      arrayOfFloat2[5] = 0.0F;
      arrayOfFloat2[6] = (-f6);
      arrayOfFloat2[7] = f1;
      arrayOfFloat2[8] = 0.0F;
      arrayOfFloat2[9] = f6;
      arrayOfFloat2[10] = f1;
      arrayOfFloat2[11] = 0.0F;
      parame.b(arrayOfFloat2);
      parame.a(arrayOfFloat1);
      return;
      f1 = 0.0F;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.f.a
 * JD-Core Version:    0.6.2
 */