package com.viber.voip.videoconvert.gpu.c;

import android.opengl.Matrix;

public class a
  implements b
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float[] e = new float[16];
  private float[] f = new float[16];

  public a(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.c = (paramFloat3 + (paramFloat1 + (float)paramLong1));
    this.d = (paramFloat4 + (paramFloat2 + (float)paramLong2));
    this.a = ((float)paramLong1 / this.c);
    this.b = ((float)paramLong2 / this.d);
    Matrix.setIdentityM(this.e, 0);
    Matrix.translateM(this.e, 0, paramFloat1 / this.c, paramFloat2 / this.d, 0.0F);
    Matrix.scaleM(this.e, 0, this.a, this.b, 1.0F);
  }

  public void a(float[] paramArrayOfFloat, int paramInt)
  {
    Matrix.multiplyMM(this.f, 0, paramArrayOfFloat, paramInt, this.e, 0);
    System.arraycopy(this.f, 0, paramArrayOfFloat, paramInt, 16);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.c.a
 * JD-Core Version:    0.6.2
 */