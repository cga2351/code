package com.viber.voip.videoconvert.gpu.opengl;

import android.opengl.GLES20;
import com.viber.voip.videoconvert.e;

public class d
{
  private static String a = "Texture";
  private int b;
  private int c;

  public d(int paramInt)
  {
    this.c = paramInt;
    a();
  }

  public int a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.b = arrayOfInt[0];
    GLES20.glBindTexture(this.c, this.b);
    a("glBindTexture mTextureID");
    GLES20.glTexParameterf(this.c, 10241, 9728.0F);
    GLES20.glTexParameterf(this.c, 10240, 9729.0F);
    GLES20.glTexParameteri(this.c, 10242, 33071);
    GLES20.glTexParameteri(this.c, 10243, 33071);
    a("glTexParameter");
    return arrayOfInt[0];
  }

  public void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      e.a().a(paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }

  public void b()
  {
    e();
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.b;
    GLES20.glDeleteTextures(1, arrayOfInt, 0);
  }

  public int c()
  {
    return this.b;
  }

  public void d()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, this.b);
  }

  public void e()
  {
    GLES20.glBindTexture(this.c, 0);
  }

  public boolean f()
  {
    return this.c == 36197;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.opengl.d
 * JD-Core Version:    0.6.2
 */