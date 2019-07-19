package com.google.android.exoplayer2.video.a;

import android.opengl.Matrix;
import com.google.android.exoplayer2.g.ac;

public final class c
{
  private final float[] a = new float[16];
  private final float[] b = new float[16];
  private final ac<float[]> c = new ac();
  private boolean d;

  private static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    Matrix.setIdentityM(paramArrayOfFloat1, 0);
    float f = (float)Math.sqrt(paramArrayOfFloat2[10] * paramArrayOfFloat2[10] + paramArrayOfFloat2[8] * paramArrayOfFloat2[8]);
    paramArrayOfFloat1[0] = (paramArrayOfFloat2[10] / f);
    paramArrayOfFloat1[2] = (paramArrayOfFloat2[8] / f);
    paramArrayOfFloat1[8] = (-paramArrayOfFloat2[8] / f);
    paramArrayOfFloat2[10] /= f;
  }

  private static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = paramArrayOfFloat2[0];
    float f2 = -paramArrayOfFloat2[1];
    float f3 = -paramArrayOfFloat2[2];
    float f4 = Matrix.length(f1, f2, f3);
    if (f4 != 0.0F)
    {
      Matrix.setRotateM(paramArrayOfFloat1, 0, (float)Math.toDegrees(f4), f1 / f4, f2 / f4, f3 / f4);
      return;
    }
    Matrix.setIdentityM(paramArrayOfFloat1, 0);
  }

  public void a()
  {
    this.c.a();
    this.d = false;
  }

  public void a(long paramLong, float[] paramArrayOfFloat)
  {
    this.c.a(paramLong, paramArrayOfFloat);
  }

  public boolean a(float[] paramArrayOfFloat, long paramLong)
  {
    float[] arrayOfFloat = (float[])this.c.a(paramLong);
    if (arrayOfFloat == null)
      return false;
    b(this.b, arrayOfFloat);
    if (!this.d)
    {
      a(this.a, this.b);
      this.d = true;
    }
    Matrix.multiplyMM(paramArrayOfFloat, 0, this.a, 0, this.b, 0);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a.c
 * JD-Core Version:    0.6.2
 */